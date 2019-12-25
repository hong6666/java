package lhh.tree;

import java.util.Stack;

/**
 * @program: IdeaJava
 * @Date: 2019/12/24 15:20
 * @Author: lhh
 * @Description:
 */
class TreeNode{
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val)
    {
        this.val = val;
    }
}
public class TreeMirrorApp {

    public TreeNode root = null;

    public void insert(int val) {
        TreeNode newNode = new TreeNode(val);
        if(root == null){root = newNode;}
        else{
            TreeNode current = root;
            TreeNode parent;
            while(true)
            {
                parent = current;
                {
                    if(val < current.val)
                    {
                        current = current.left;
                        if (current == null)
                        {
                            parent.left = newNode;
                            return ;
                        }
                    }
                    else
                    {
                        current = current.right;
                        if(current == null)
                        {
                            parent.right = newNode;
                            return ;
                        }
                    }
                }

            }
        }
    }

    public  void displayTree()
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

    public void mirror(TreeNode root)
    {
        if(root == null) return ;
        if(root.left ==null && root.right == null) return ;
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null)
        {
            mirror(root.left);
        }
        if(root.right != null)
        {
            mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeMirrorApp theTree = new TreeMirrorApp();
        theTree.insert(9);
        theTree.insert(5);
        theTree.insert(6);
        theTree.insert(2);
        theTree.insert(4);
        theTree.insert(10);
        theTree.insert(14);

        theTree.displayTree();
        theTree.mirror(theTree.root);
        theTree.displayTree();
    }

}
