package lhh.tree;

import java.util.Stack;

/**
 * @program: IdeaJava
 * @Date: 2019/12/4 15:06
 * @Author: lhh
 * @Description:
 */
class Node{
    public int data;
    public Node leftChild;
    public Node rightChild;

}
public class TreeApp {

    private Node root;

    public TreeApp(){root = null;}

    public void insert(int id) {
        Node newNode = new Node();
        newNode.data = id;
        if(root == null){root = newNode;}
        else{
            Node current = root;
            Node parent;
            while(true)
            {
                parent = current;
                {
                    if(id < current.data)
                    {
                        current = current.leftChild;
                        if (current == null)
                        {
                            parent.leftChild = newNode;
                            return ;
                        }

                    }
                    else
                    {
                        current = current.rightChild;
                        if(current == null)
                        {
                            parent.rightChild = newNode;
                            return ;
                        }

                    }
                }

            }
        }
    }

    //中序遍历
    public void inOrder(Node localRoot) {
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.rightChild);
        }
    }

    //前序遍历
    public void preOrder(Node localRoot) {
        if(localRoot != null)
        {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    //后序遍历
    public void postOrder(Node localRoot) {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.data + " ");
        }
    }

    //得到要删除节点的后继节点
    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != delNode.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public boolean delete(int key)
    {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.data != key)  //找到要删除的节点
        {
            parent = current;
            if(key < current.data){
                isLeftChild = true;
                current = current.leftChild;
            }
            else
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null)return false;    //没找到就返回错误
        }

        //如果要删除的节点没有子节点
        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)
            {
                root = null;
            }
            else if(isLeftChild)
            {
                parent.leftChild = null;
            }
            else
                parent.rightChild = null;
        }

        //如果要删除的节点没有左子树
        else if(current.leftChild == null)
        {
            if(current == root)
            {
                root = current.rightChild;
            }
            else if(isLeftChild)
            {
                parent.leftChild = current.rightChild;
            }
            else
                parent.rightChild = current.rightChild;
        }
        //如果要删除的节点没有右子树
        else if(current.rightChild == null)
        {
            if(current == root)
            {
                root = current.leftChild;
            }
            else if(isLeftChild)
            {
                parent.leftChild = current.leftChild;
            }
            else
                parent.rightChild = current.leftChild;
        }

        //要删除的节点有左右两个子树，删除的节点要替换成它的中序后继
        else
        {
            Node successor = getSuccessor(current);
            if(current == root)
            {
                root = successor;
            }
            else if(isLeftChild)
            {
                parent.leftChild = successor;
            }
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public void displayTree()
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
                Node temp = (Node)globalStack.pop();
                if(temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null)
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


    public static void main(String[] args) {
        TreeApp myTree = new TreeApp();
        myTree.insert(10);
        myTree.insert(6);
        myTree.insert(14);
        myTree.insert(8);
        myTree.insert(12);
        myTree.insert(16);
        myTree.insert(3);
        myTree.insert(7);
        myTree.insert(15);
        myTree.insert(19);
        myTree.insert(20);
        myTree.insert(17);

        System.out.print("前序遍历：");
      myTree.preOrder(myTree.root);
        System.out.println();
        System.out.print("中序遍历：");
      myTree.inOrder(myTree.root);
        System.out.println();
        System.out.print("后序遍历：");
      myTree.postOrder(myTree.root);
        System.out.println();

        /*System.out.println("删除"+myTree.delete(8));*/
      myTree.displayTree();
    }

}




























