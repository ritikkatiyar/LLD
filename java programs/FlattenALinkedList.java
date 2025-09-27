public class FlattenALinkedList {

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int x) {
            data = x;
            next = null;
            bottom = null;
        }
    }

    public Node flatten(Node root) {
        // code here
        if(root==null){
            return null;
        }
        Node root2=flatten(root.next);
        return mergeTwoLinkedList(root,root2);
    }
    public Node mergeTwoLinkedList(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.data<l2.data){
            l1.bottom=mergeTwoLinkedList(l1.bottom,l2);
            return l1;
        }else{
            l2.bottom=mergeTwoLinkedList(l1,l2.bottom);
            return l2;
        }

    }

}
