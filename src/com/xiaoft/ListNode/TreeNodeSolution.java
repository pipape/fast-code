package com.xiaoft.ListNode;

/*
 * @ClassName TreeNodeSolution
 * @Description
 * @Author xiaofeiteng
 * @Date 2021/8/15 3:58 下午
 * @Version V1.0
 */
public class TreeNodeSolution {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if (preorder == null || preorder.length < 1){
            return null;
        }
        return constructTree(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }

    /*
     * @Description
     * @Return: com.xiaoft.ListNode.TreeNode
     * @Author: xiaofeiteng
     * @Date: 2021/8/15 1:43 下午
     */
    public static TreeNode constructTree(int[] preorder, int prestart, int preend,
                                         int[] inorder, int instart, int inend){
        if(prestart > preend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = null;
        root.right = null;
        root.parent = null;
        if(prestart == preend){
            return root;
        }

        int index = 0;
        for(int i = 0; i < inorder.length; i ++){
            if(inorder[i] == preorder[prestart]){
                index = i;
                break;
            }
        }

        TreeNode node1 = constructTree(preorder,prestart+1,prestart+index-instart,
                inorder,instart,index-1);
        root.left = node1;
        node1.parent = root;
        TreeNode node2 = constructTree(preorder,prestart+index-instart+1,preend,
                inorder,index+1,inend);
        root.right = node2;
        node2.parent = root;

        return root;
    }

    public static TreeNode getNodeInTree(TreeNode head, int target){
        if(head == null){
            return null;
        }
        if(head.val == target){
            return head;
        }
        TreeNode lres = getNodeInTree(head.left,target);
        TreeNode rres = getNodeInTree(head.right,target);

        return lres == null ? rres : lres;
    }

    public static TreeNode getNextNode(TreeNode head, TreeNode node){
        TreeNode pNext = new TreeNode(0);
        if(head == null || node == null){
            return null;
        }

        //有右子节点，找右子节点的最左子节点
        if(node.right != null){
            TreeNode pright = node.right;
            while(pright.left != null){
                pright = pright.left;
            }
            pNext = pright;
        }else if(node.parent != null){
            TreeNode pParent = node.parent;
            TreeNode pCurrent = node;
            while(pParent != null && pParent.right == pCurrent){
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }

        return pNext;
    }

    public static void main(String[] args){
        TreeNode tree = buildTree(new int[]{6,2,1,3,4,5,7,8,9},new int[]{1,2,4,3,5,6,8,7,9});
        System.out.println(getNextNode(tree,getNodeInTree(tree,1)).val);
    }
}
