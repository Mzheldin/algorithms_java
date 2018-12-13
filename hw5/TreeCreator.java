package hw5;

import java.util.ArrayList;
import java.util.List;

public class TreeCreator {

    public List<BST> create(int num, int size){
        List<BST> list = new ArrayList<>();
        for (int i = 0; i < num; i++) list.add(createOne(6));
        return list;
    }

    public BST<Integer, Integer> createOne(int size){
        BST<Integer, Integer> bst = new BST<>();
        while (bst.getHeight() < size) bst.put((int)(Math.random() * 100), (int)(Math.random() * 200 -  100));
        return bst;
    }

    public void balancedTree(List<BST> list){
        int numsBalance = 0;
        for (BST o : list) if (o.isBalanced()) numsBalance++;
        System.out.println(numsBalance + " из " + list.size() + " деревьев сбалансированы");
    }

}
