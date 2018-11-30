package linked_lists;

public class DoublyNode {
    public DoublyNode prev = null;
    public DoublyNode next = null;
    int data;

    public DoublyNode(int data) {
        this.data = data;
    }


    public void insert(DoublyNode head, DoublyNode node) {
        DoublyNode tracker = head;

        while (tracker.next != null) {
            tracker = tracker.next;
        }

        tracker.next = node;
        node.prev = tracker;
    }

    public void insertAfter(DoublyNode head, DoublyNode beforeNode, DoublyNode insertNode) {
        DoublyNode tracker = head;

        while (tracker != beforeNode) {
            tracker = tracker.next;
        }

        if (tracker == beforeNode) {
            insertNode.next = tracker.next;
            tracker.next.prev = insertNode;
            insertNode.prev = tracker;
            tracker.next = insertNode;
        }
    }

    public DoublyNode insertPos(DoublyNode head, DoublyNode node, int pos) {
        if (pos == 0) {
            node.next = head;
            head.prev = node;
            return node;
        }

        DoublyNode tracker = head;
        DoublyNode prevTracker = head;

        int counter = 1;

        while (tracker != null) {
            if (counter == pos) {
                prevTracker.next = node;
                node.next = tracker;
                node.prev = prevTracker;
                tracker.prev = node;

                return head;
            }

            prevTracker = tracker;
            tracker = tracker.next;
            counter++;
        }

        return head;
    }

    public void insertAtPos(DoublyNode head, int data, int pos) {
        DoublyNode tracker = head;
        int counter = 0;

        while (tracker != null) {
            if (counter == pos) {
                tracker.data = data;
                return;
            }

            tracker = tracker.next;
            counter++;
        }
    }

    public DoublyNode insertHead(DoublyNode head, DoublyNode node) {
        return insertPos(head, node, 0);
    }

    public DoublyNode delete(DoublyNode head, DoublyNode node) {
        if (node == head) {
            head = head.next;
            head.prev = null;
            return head;
        }

        DoublyNode tracker = head;

        while (tracker.next != node && tracker.next != null) {
            tracker = tracker.next;
        }

        if (tracker.next == node) {
            DoublyNode nodeNext = node.next;
            tracker.next = nodeNext;

            if (nodeNext != null) {
                nodeNext.prev = tracker;
            }

            node = null;
        }

        return head;

    }

    public DoublyNode deletePos(DoublyNode head, int pos) {
        if (pos == 0) {
            head = head.next;
            head.prev = null;
            return head;
        }

        DoublyNode tracker = head;
        DoublyNode prevTracker = head;
        int counter = 0;

        while (tracker != null) {
            if (counter == pos) {
                prevTracker.next = tracker.next;
                tracker.next.prev = prevTracker;
                tracker = null;
                return head;
            }

            prevTracker = tracker;
            tracker = tracker.next;
            counter++;
        }

        return head;
    }

    public DoublyNode deleteHead(DoublyNode head) {
        return deletePos(head, 0);
    }

    public void printList(DoublyNode head) {
        DoublyNode tracker = head;

//        To avoid Nullpointer exception when printing prev for head.
        System.out.print("(null) <- " + String.valueOf(tracker.data) + " ");
        tracker = tracker.next;

        while (tracker != null) {
            System.out.print(" (" + String.valueOf(tracker.prev.data) + ") <- ");
            System.out.print(tracker.data);
            System.out.print(" ");
            tracker = tracker.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        DoublyNode head = new DoublyNode(30);
        DoublyNode node1 = new DoublyNode(1);
        DoublyNode node2 = new DoublyNode(14);
        DoublyNode node3 = new DoublyNode(15);
        DoublyNode node4 = new DoublyNode(11);
        DoublyNode node5 = new DoublyNode(13);
        DoublyNode node6 = new DoublyNode(12);
        DoublyNode node7 = new DoublyNode(1);

        head.insert(head, node1);
        head.insert(head, node2);
        head.insert(head, node3);
        head.insert(head, node4);
        head.insert(head, node5);
        head.insert(head, node6);
        head.insert(head, node7);

        head.printList(head);

        node6.insertAfter(head, head, new DoublyNode(88));
        head.printList(head);

        head = head.insertHead(head, new DoublyNode(3333));

        head = head.insertPos(head, new DoublyNode(910), 10);
        head.printList(head);

        head.insertAtPos(head, 4, 0);
        head.printList(head);

        head = head.delete(head, node7);
        head.printList(head);

        head = head.deletePos(head, 8);
        head.printList(head);

        head = head.deleteHead(head);
        head.printList(head);

    }

}
