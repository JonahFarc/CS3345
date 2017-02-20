package Project1;// Linked list
// Singly-linked, each node has an int

public class Linkedlist
{
    private Node head;
    private Node tail;
    private int size;

    public void addFront(int x)
    {
        head = new Node(x, head);
        if(tail == null)
            tail = head;

        size++;
    }

    public void addEnd(int x)
    {
        if (tail == null){
            tail = new Node(x, null);
            head = tail;
        }
        else
        {
            tail.next = new Node(x, null);
            tail = tail.next;
        }
        size++;
    }

    public void reverse()
    {
        if (size < 2)
            return;

        Node p = head;
        Node q = head.next;
        Node r = null;

        while(q != null)
        {
            p.next = r;
            r = p;
            p = q;
            q = q.next;
        }

        p.next = r;

        tail = head;
        head = p;

    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("[ ");

        Node p = head;
        while(p != null)
        {
            sb.append(p.data + " ");
            p = p.next;
        }
        sb.append("]");

        return new String(sb);
    }

    public static void main(String[] args)
    {
        Linkedlist list = new Linkedlist();

        for(int i = 1; i <=5; i++)
        {
            list.addFront(i);
        }

        System.out.println(list);
        list.reverse();
        System.out.println(list);
        System.out.println(list.head.data);
        System.out.println(list.tail.data);
    }


    private static class Node
    {
        int data;
        Node next;

        public Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
