class Solution
{
    int getMiddle(Node head)
    {
        Node ptr1 = head;
        Node ptr2 = head;
        while(ptr2!=null){
            if(ptr2.next==null)
                return ptr1.data;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if(ptr2==null)
                return ptr1.data;
        }
        return 0; 
    }
}