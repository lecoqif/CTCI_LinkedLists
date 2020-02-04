public class Practice {

    public static void main(String[] args) {

//        Linker obj = new Linker();
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(1);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(2);
//        ListNode f = new ListNode(4);
//        ListNode g = new ListNode(3);
//        a.next = b; b.next = c;
//        c.next = d; d.next = e; e.next = f;
//        f.next = g;
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);
        a.next = b; b.next = c; c.next = e; d.next = e; e.next = f;

        Linker obj = new Linker();
        System.out.println(obj.palindrome_better(a));
    }
}
