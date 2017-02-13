// Project 1 for CS 3345.001
// Programmer: Dylan Yu (dsy160030)
// Description: Creates a singly-linked list that stores names alphabetically, sorted by letter nodes.
// This program can add or remove strings to the list or search for strings. The output is also formatted.

public class Index
{
    //Variables to be used
    private Node head;
    private Node tail;
    private int size;

    //Adds given string to the front of the linked list
    private void addFront(String x)
    {
        head = new Node(x, head);
        if (tail == null)
            tail = head;

        size++;
    }

    //Adds given string to the end of the linked list
    private void addEnd(String x)
    {
        if (tail == null)
        {
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

    //Adds given string to the linked list in the position after the node provided
    private void addAfter(Node n, String data)
    {
        Node next = n.next;
        n.next = new Node(data, next);
        size++;
    }

    //Adds the given string to the linked list in sorted order
    public void add(String data)
    {
        if (find(data) != null) //If the string is already in the linked list, don't add it
            return;
        if (size < 1) //If list is empty
        {
            addFront(data.substring(0, 1).toUpperCase());
            addEnd(data);
        }
        else if (find(data.substring(0, 1).toUpperCase()) != null) //If letter node already exists
        {
            Node n = find(data.substring(0, 1).toUpperCase());
            while (n.next != null && n.next.data.compareTo(data) < 0 && n.next.data.length() > 1) //Search for alphabetical spot after the letter node, or until the end fo the list
            {
                n = n.next;
            }
            if (n.next == null)
            {
                addEnd(data);
            }
            else
                addAfter(n, data);
        }
        else //If letter node does not exist yet
        {
            String search = data.substring(0,1).toUpperCase() + data.substring(1);
            if(head.data.compareTo(search) > 0)
            {
                addFront(data);
                addFront(data.substring(0,1).toUpperCase());
            }
            else
            {
                Node n = head;
                while (n.next != null && (n.next.data.substring(0, 1).toUpperCase() + n.next.data.substring(1)).compareTo(search) < 0) //Search for alphabetical spot for the letter node, or until the end of the list
                {
                    n = n.next;
                }
                if (n.next == null)
                {
                    addEnd(data.substring(0, 1).toUpperCase());
                    addEnd(data);
                }
                else
                {
                    addAfter(n, data.substring(0, 1).toUpperCase());
                    n = n.next;
                    addAfter(n, data);
                }
            }
        }
    }

    //Removes the string from the linked list. If it's the last one of the letter, removes the letter as well.
    public void remove(String s)
    {
        if (find(s) == null) //If the string is not in the linked list, do nothing
            return;
        if (s.length() == 1) //If trying to delete a letter node, disallow that.
            return;
        Node n = find(s);
        Node letter = find(s.substring(0, 1).toUpperCase());
        if (letter.next == n && (n.next == null || n.next.data.length() == 1)) //If it's the last string in the letter
        {
            if (head == letter) //If the letter node is the first letter node in the linked list
            {
                head = n.next;
                if (tail == n) //If the list consists only of this letter node and the string
                    tail = n.next;
            }
            else //If not first letter node in list
            {
                Node prev = head; //Get the node before the letter
                while (prev.next != letter)
                    prev = prev.next;
                if (tail == n)  //Reset the tail if it needs to be moved
                    tail = prev;
                prev.next = prev.next.next.next;  //remove the letter node and string
            }
            size--;
            size--;
        }
        else //If not the last string in letter
        {
            Node prev = letter;
            while (prev.next != n) //Get the node before the string
                prev = prev.next;
            prev.next = prev.next.next; //remove the node with the string
            if (tail == n)
                tail = prev;
            size--;
        }
    }

    //Removes the letter node and all of the strings associated with it
    public void removeLetter(char c)
    {
        String s = (c + "").toUpperCase();
        if (find(s) == null) //If letter node does not exist
            return;
        Node n = find(s);
        while (n.next.next != null && n.next.next.data.length() != 1) //remove each string one by one until there's only one left
        {
            remove(n.next.data);
        }
        remove(n.next.data); //Remove the final string and the letter node
    }

    //Search linearly through the list for the string given
    public Node find(String s)
    {
        Node n = head;
        if (n == null)
            return null;
        while (n != null)
        {
            if (n.data.equals(s))
                return n;
            n = n.next;
        }
        return null;
    }

    //Output the string in the format provided
    public String toString()
    {
        StringBuilder output = new StringBuilder("");
        Node p = head;
        while (p != null)
        {
            if (p.data.length() > 1)
                output.append("\t");
            output.append(p.data + "\n");
            p = p.next;
        }

        return new String(output);
    }

    public static void main(String[] args)
    {
        Index list = new Index();

        //Testing add
        System.out.println("Testing adding to the list: ");
        list.add("Bob");
        list.add("Dan");
        list.add("Ben");
        list.add("Sarah");
        list.add("anne");
        list.add("george");
        list.add("Deb");
        list.add("Greg");
        list.add("John");
        System.out.print(list);
        System.out.println("________________________\n");

        //Testing find
        System.out.println("Testing searching through the list: ");
        Node n = list.find("Ben");
        System.out.println(n == null ? "Not found!" : "Found!");
        n = list.find("Dylan");
        System.out.println(n == null ? "Not found!" : "Found!");
        n = list.find("deb");
        System.out.println(n == null ? "Not found!" : "Found!");
        System.out.println("________________________\n");

        //Testing remove
        System.out.println("Testing removal from the list: ");
        list.remove("Deb");
        list.remove("John");
        System.out.print(list);
        System.out.println("________________________\n");

        //Testing removeLetter
        System.out.println("Testing removing letter nodes from the list: ");
        list.removeLetter('S');
        list.removeLetter('g');
        System.out.print(list);
    }

    //Node class, stores data and pointer to next node
    private static class Node
    {
        String data;
        Node next;

        public Node(String data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
}
