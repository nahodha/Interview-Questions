package linked_lists;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed
 */
public class RemoveDuplicates {
    public Node removeDuplicates(Node head) {
        Node tracker = head;
        Node runner = head.next;
        Node prevRunner = head;

        while (tracker != null) {

            while (runner != null) {
                if (runner == tracker) {
                    prevRunner = runner;
                    runner = runner.next;
                    continue;
                }

                if (runner.data == tracker.data) {
                    prevRunner.next = runner.next;
                    Node curr = runner;
                    runner = runner.next;
                    curr = null;
                    continue;
                }

                prevRunner = runner;
                runner = runner.next;

            }
            runner = head;
            tracker = tracker.next;
        }

        return head;

    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.insert(head, new Node(43));
        head.insert(head, new Node(43));
        head.insert(head, new Node(1));
        head.insert(head, new Node(1));
        head.insert(head, new Node(3));
        head.insert(head, new Node(4));

        head.printList(head);

        RemoveDuplicates rd = new RemoveDuplicates();
        head = rd.removeDuplicates(head);
        head.printList(head);
    }
}
