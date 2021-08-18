package com.xiaoft.codeview817;

import java.util.*;

public class CodeView {
    List<Node> nodeList = new ArrayList<>();

    class Node{
        Node left;
        Node right;
        String data;
        Node(String num){
            left = null;
            right = null;
            data = num;
        }
    }

    public Node createBinaryTree(){
        Scanner sc = new Scanner(System.in);
        String str = "";
        while(sc.hasNextLine()){
            str =  sc.nextLine();
            nodeList.add(new Node(str));
            str =  sc.nextLine();
        }
        sc.close();

        if(nodeList != null && nodeList.size() > 0){
            for(int index = 0; index < (nodeList.size()/2 -1); index ++){
                nodeList.get(index).left = nodeList.get(index * 2 + 1);
                nodeList.get(index).right = nodeList.get(index * 2 + 2);
            }

            int index = nodeList.size()/2 -1;
            nodeList.get(index).left = nodeList.get(index * 2 + 1);
            if(nodeList.size() % 2 == 1){
                nodeList.get(index).right = nodeList.get(index * 2 + 2);
            }

            return nodeList.get(0);
        }

        return null;
    }

    public void preOrderPrint(Node head){
        if(head == null){
            return;
        }

        System.out.println(head.data);
        preOrderPrint(head.left);
        preOrderPrint(head.right);
    }

    public static void main(String[] args) {
        CodeView codeView = new CodeView();
        codeView.preOrderPrint(codeView.createBinaryTree());
    }
}
