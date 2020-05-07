package nowcoder;


import java.util.Arrays;
import java.util.Stack;

/**
 * RebuildBinaryTree,重建二叉树
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含
 * 重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author 李弘昊
 * @since 2020/5/6
 */
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x;}
}
public class RebuildBinaryTree {

    public void displayTree(TreeNode root)
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("...........................................");
        while (isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks;j++)
            {
                System.out.print(' ');
            }
            while(globalStack.isEmpty()==false)
            {
                TreeNode temp = (TreeNode)globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.val);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null)
                    {
                        isRowEmpty = false;
                    }
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0){
            return null;
        }
        int rootVal = pre[0];
        if(pre.length == 1){
            return new TreeNode(rootVal);
        }
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i=0;i<in.length;i++){
            if(rootVal == in[i]){
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),
                Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),
                Arrays.copyOfRange(in,rootIndex+1,in.length));

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode mytree = reConstructBinaryTree(pre,in);
        RebuildBinaryTree rebuildBinaryTree = new RebuildBinaryTree();
        rebuildBinaryTree.displayTree(mytree);

    }
}
