import java.util.*;

import java.util.ArrayList;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Pair{
    TreeNode node;
    int hd;
    Pair(TreeNode node,int hd){
        this.node=node;
        this.hd=hd;
    }
}
class TopViewOfABinaryTree {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(TreeNode root) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Pair> q=new LinkedList<>();
        Pair pair=new Pair(root,0);
        q.add(pair);
        Map<Integer,Integer> map=new TreeMap<>();

        while(!q.isEmpty()){
            pair=q.remove();
            TreeNode temp=pair.node;
            int hd=pair.hd;
            map.putIfAbsent(hd,temp.data);
            if(temp.left!=null){
                pair=new Pair(temp.left,hd-1);
                q.add(pair);
            }
            if(temp.right!=null){
                pair=new Pair(temp.right,hd+1);
                q.add(pair);
            }
        }
        map.forEach((key,value)->{
            result.add(value);
        });
        return result;
    }

}