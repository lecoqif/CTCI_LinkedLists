public class ListNode {
    ListNode next = null;
    int data;

    public ListNode(int d){
        data = d;
    }

    void appendToTail(int d){
        ListNode end = new ListNode(d);
        ListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}
