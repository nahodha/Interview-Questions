package linked_lists;

public class Node {
    public Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public void insert(Node head, Node node) {
        Node tracker = head;

        while (tracker.next != null) {
            tracker = tracker.next;
        }

        tracker.next = node;
    }

    public void insertAfter(Node head, Node beforeNode, Node insertNode) {
        Node tracker = head;

        while (tracker != beforeNode) {
            tracker = tracker.next;
        }

        if (tracker == beforeNode) {
            insertNode.next = tracker.next;
            tracker.next = insertNode;
        }
    }

    public Node insertPos(Node head, Node node, int pos) {
        if (pos == 0) {
            node.next = head;
            return node;
        }

        Node tracker = head;
        Node prev = head;
        int counter = 1;

        while (tracker != null) {
            if (counter == pos) {
                prev.next = node;
                node.next = tracker;

                return head;
            }

            prev = tracker;
            tracker = tracker.next;
            counter++;
        }

        return head;
    }

    public void insertAtPos(Node head, int data, int pos) {
        Node tracker = head;
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

    public Node insertHead(Node head, Node node) {
        return insertPos(head, node, 0);
    }

    public Node delete(Node head, Node node) {
        if (node == head) {
            head = head.next;
            return head;
        }

        Node tracker = head;

        while (tracker.next != node && tracker.next != null) {
            tracker = tracker.next;
        }

        if (tracker.next == node) {
            tracker.next = node.next;
            node = null;
        }

        return head;

    }

    public Node deletePos(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return head;
        }

        Node tracker = head;
        Node prev = head;
        int counter = 0;

        while (tracker != null) {
            if (counter == pos) {
                prev.next = tracker.next;
                tracker = null;
                return head;
            }

            prev = tracker;
            tracker = tracker.next;
            counter++;
        }

        return head;
    }

    public Node deleteHead(Node head) {
        return deletePos(head, 0);
    }

    public void printList(Node head) {
        Node tracker = head;

        while (tracker != null) {
            System.out.print(tracker.data);
            System.out.print(" ");
            tracker = tracker.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(30);
        Node node1 = new Node(1);
        Node node2 = new Node(14);
        Node node3 = new Node(15);
        Node node4 = new Node(11);
        Node node5 = new Node(13);
        Node node6 = new Node(12);
        Node node7 = new Node(1);

        head.insert(head, node1);
        head.insert(head, node2);
        head.insert(head, node3);
        head.insert(head, node4);
        head.insert(head, node5);
        head.insert(head, node6);
        head.insert(head, node7);

        head.printList(head);

        node6.insertAfter(head, head, new Node(88));
        head.printList(head);

        head = head.insertHead(head, new Node(3333));

        head = head.insertPos(head, new Node(910), 10);
        System.out.println("insert pos");
        head.printList(head);

        head.insertAtPos(head, 4, 1);
        head.printList(head);

        head = head.delete(head, node7);
        head.printList(head);

        head = head.deletePos(head, 8);
        head.printList(head);

        head = head.deleteHead(head);
        head.printList(head);

    }

}
