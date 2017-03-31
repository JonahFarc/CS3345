package Project2;

/**
 * Created by M3800 on 2/20/2017.
 */

public class    MySearchTree<elem extends Comparable<? super elem>>
{
    Node<elem> root;
    int size;

    public void add(elem data)
    {
        add(data, root);
    }

    private void add(elem data, Node<elem> node)
    {
        if(node == null)
            return;
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
        return null;
    }

    public int leafCount()
    {
        return leafCount(root);
    }

    private int leafCount(Node<elem> node)
    {
        if(node == null)
            return -1;
        if(node.left == null && node.right == null)
            return 1;
        else if(node.left != null && node.right != null)
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
        if(node == null)
            return -1;
        if(node.left == null && node.right == null)
            return 0;
        else if(node.left != null && node.right != null)
            return 1+leafCount(node.left) + leafCount(node.right);
        else if (node.left != null)
            return 1+leafCount(node.left);
        else
            return 1+leafCount(node.right);
    }

    public int height()
    {
        return height(root);
    }

    private int height(Node<elem> node)
    {
        if(node == null)
            return -1;
        if(node.left == null && node.right == null)
            return 0;
        else if (node.left != null && node.right != null)
            return 1+Math.max(height(node.left),height(node.right));
        else if (node.left != null)
            return 1+height(node.left);
        else
            return 1+height(node.right);
    }

    public boolean isPerfect()
    {
        return isPerfect(root);
    }

    private boolean isPerfect(Node<elem> node)
    {
        if(node == null)
            return false;
        if((node.left != null && node.right == null) || (node.right != null && node.left == null))
            return false;
        if(node.left == null && node.right == null)
            return true;
        if(height(node.right) == height(node.left) && isPerfect(node.left) && isPerfect(node.right))
            return true;
        return false;
    }

    public elem ancestors(elem data)
    {
        return data;
    }

    public void inOrderPrint()
    {
        inOrderPrint(root);
    }
    private void inOrderPrint(Node<elem> node)
    {
        if (node != null)
        {
            inOrderPrint(node.left);
            System.out.println(node.data);
            inOrderPrint(node.right);
        }
    }

    public void preOrderPrint()
    {
        preOrderPrint(root);
    }

    private void preOrderPrint(Node<elem> node)
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
        return;
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
