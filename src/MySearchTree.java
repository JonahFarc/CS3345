/**
 * Created by M3800 on 2/20/2017.
 */
/*
   10 points
   a) add
       Adds a node to the tree containing the passed value.

   10 points
   b) find
        Returns true if the value passed is in the tree.

   10 points
   c) leafCount
        Returns the count of all of the leaves in the tree.

   10 points
   d) parentCount
        Returns the count of all of the parents in the tree.

   10 points
   e) height
        Returns the height of the tree.

   10 points
   f) isPerfect
        Returns true if the tree is a perfect tree.
        (A perfect tree is filled at every level).

   10 points
   g) ancestors
        Returns the ancestor values of the passed value.

   10 points
   h) inOrderPrint
        Prints node values using an inorder traversal.

   10 points
   i) preOrderPrint
        Prints node values using a preorder traversal.

   10 points
   j) Main
        Demonstrates all of the above methods.
 */
public class MySearchTree<elem extends Comparable<elem>>
{
    Node<elem> root;
    int size;

    public void add(elem data)
    {
        add(data, root);
    }

    private void add(elem data, Node<elem> node)
    {
        if(data.compareTo(node.data) < 0)
        {
            if(node.left != null)
                add(data, node.left);
            else
            {
                node.left = new Node<elem>(data, null, null);
                size++;
            }
        }
        else if(data.compareTo(node.data) > 0)
        {
            if (node.right != null)
                add(data, node.right);
            else
            {
                node.right = new Node<elem>(data, null, null);
                size++;
            }
        }
        return;
    }

    public Node find(elem data)
    {
        return find(data, root);
    }

    private Node find(elem data, Node<elem> node)
    {
        if(data.compareTo(node.data) == 0)
            return node;
        else if(data.compareTo(node.data) < 0)
        {
            if(node.left != null)
                return find(data, node.left);
            else
                return null;
        }
        else if(data.compareTo(node.data) > 0)
        {
            if(node.right != null)
                return find(data, node.right);
            else
                return null;
        }
    }

    public int leafCount()
    {
        return leafCount(root);
    }

    private int leafCount(Node<elem> node)
    {
        if(node.left == null && node.right == null)
            return 1;
        else if(node.left!= null && node.right != null)
            return leafCount(node.left) + leafCount(node.right);
        else if (node.left != null)
            return leafCount(node.left);
        else
            return leafCount(node.right);
    }

    public int parentCount()
    {
        return parentCount(root);
    }

    private int parentCount(Node<elem> node)
    {
        if(node.left == null && node.right == null)
            return 0;
        else if(node.left!= null && node.right != null)
            return 1+leafCount(node.left) + leafCount(node.right);
        else if (node.left != null)
            return 1+leafCount(node.left);
        else
            return 1+leafCount(node.right);
    }

    public int height()
    {

    }

    public boolean isPerfect()
    {

    }

    public elem ancestors(elem data)
    {

    }

    public void inOrderPrint(Node<elem> node)
    {
        if (node != null)
        {
            inOrderPrint(node.left);
            System.out.println(node.data);
            inOrderPrint(node.right);
        }
    }

    public void preOrderPrint(Node<elem> node)
    {
        if (node != null)
        {
            System.out.println(node.data);
            preOrderPrint(node.left);
            preOrderPrint(node.right);
        }
    }

    public static void main(String[] args)
    {

    }

    private static class Node<elem>
    {
        elem data;
        Node<elem> left;
        Node<elem> right;

        public Node(elem data, Node<elem> left, Node<elem> right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
