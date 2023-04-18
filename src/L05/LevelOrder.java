package L05;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {
        BinNode<Integer> root =null;
        levelOrder(root);

    }

    private static void levelOrder(BinNode<Integer> root) {

        if(root==null)
            return;
        Queue<BinNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinNode<Integer> temp = q.poll();
            System.out.println(temp.getValue());
            if(temp.hasLeft())
                q.add(temp.getLeft());
            if(temp.hasRight())
                q.add(temp.getRight());
        }
        System.out.println("-----------------------");
    }

    public static BinNode<Integer> add(){
        return null;
    }



}
