public class Main {

        public static void main(String[] args) {

            //[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]

            Node head      = new Node(1);
            head.next      = new Node(2);
            head.next.next = new Node(3);

            head.next.next.child = new Node(7);
            head.next.next.child.next = new Node(8);
            head.next.next.child.next.next = new Node(9);
            head.next.next.child.next.next.next = new Node(10);

            head.next.next.child.next.child = new Node(11);
            head.next.next.child.next.child.next = new Node(12);

            head.next.next.next            = new Node(4);
            head.next.next.next.next       = new Node(5);
            head.next.next.next.next.next  = new Node(6);

            System.out.println(flatten(head));

        }

        static class Node {

            public int val;
            public Node prev;
            public Node next;
            public Node child;

            Node(int val) {
                this.val = val;
            }

        }

    public static Node flatten(Node head) {

        if(head==null) return head;
        Node curr = head;

        while(curr!=null){
            if(curr.child!=null){
                Node down =  curr.child;

                while(down.next!=null)
                    down = down.next;

                Node temp = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child= null;
                down.next = temp;
                if(temp!=null) temp.prev = down;
            }
            curr = curr.next;
        }

        return head;

    }

}
