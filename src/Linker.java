import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class Linker {

    public ListNode removeDups_hash(ListNode node){
        HashSet<Integer> set = new HashSet<>();
        if(node == null) return null;
        ListNode head = node;
        set.add(node.data);
        while(node != null){
            if(set.contains(node.next.data)){
                node.next = node.next.next;
            } else {
                set.add(node.next.data);
            }
            node = node.next;
        }
        return head;
    }

    public int returnKthToLast(ListNode head, int k){
        ListNode fst = head;
        ListNode runner = head;
        int i = 1;
        while(runner.next != null && i < k){
            runner = runner.next;
            i++;
        }
        while(runner.next != null){
            runner = runner.next;
            fst = fst.next;
        }
        return fst.data;

    }

    public void deleteMiddle(ListNode node){
        node.data = node.next.data;
        node.next = node.next.next;
        return;
    }

    public ListNode sumLists(ListNode l1, ListNode l2){
        int prev_carry = 0;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(l1 != null || l2 != null){
            int l1val = (l1 == null) ? 0 : l1.data;
            int l2val = (l2 == null) ? 0 : l2.data;
            int total = l1val + l2val + prev_carry;
            int sum = total % 10;
            int carry = total / 10;
            curr.next = new ListNode(sum);
            prev_carry = carry;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            curr = curr.next;
        }
        if(prev_carry != 0) curr.next = new ListNode(prev_carry);
        return head.next;
    }

    public boolean palindrome(ListNode head){
        ListNode curr = head;
        int len = findLength(curr);
        if(len == 0 || len == 1) return true;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < len / 2; i++){
            st.push(head.data);
            head = head.next;
        }
        if(len % 2 == 0){
            for(int i = len / 2; i < len; i++){
                if(head.data != st.pop()) return false;
                head = head.next;
            }
        } else {
            head = head.next;
            for(int i = (len / 2) + 1; i < len; i++){
                if(head.data != st.pop()) return false;
                head = head.next;
            }
        }
        return true;
    }

    public int findLength(ListNode head){
        if(head == null) return 0;
        int res = 1;
        while(head.next != null){
            head = head.next;
            res++;
        }
        return res;
    }

    public boolean palindrome_better(ListNode head){
        ListNode slow = head, fast = head;
        Stack<Integer> st = new Stack<>();

        while(fast != null && fast.next != null) {
            st.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next;
        while(slow != null){
            if(st.pop() != slow.data) return false;
            slow = slow.next;
        }

        return true;
    }

    public boolean loopdetect(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

}
