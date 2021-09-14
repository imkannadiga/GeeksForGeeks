class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        if(head==null||head.next==null) return;
        Node slow=head,fast=head;
        slow=slow.next;
        fast=fast.next.next;
        while(slow!=null && fast!=null && fast.next!=null){
            if(slow==fast) break;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(slow==null || fast==null || fast.next==null) return;
        if(slow==fast){
            slow=head;
            if(slow!=fast){
                while(slow.next!=fast.next){
                    slow=slow.next;
                    fast=fast.next;
                }
                fast.next=null;
            }
            else{
                while(fast.next!=slow)
                    fast=fast.next;
                fast.next=null;
            }
        }
        return;
    }
}