class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return partitionAndMerge(0,lists.length-1,lists);
    }
    private ListNode partitionAndMerge(int start,int end,ListNode[] lists){
        if(start==end){
            return lists[0];
        }
        int mid=start+(end-start)/2;
        ListNode l1=partitionAndMerge(start,mid-1,lists);
        ListNode l2=partitionAndMerge(mid+1,end,lists);

        return mergeTwoLists(l1,l2);
    }
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l2.next,l1);
            return l2;
        }
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}