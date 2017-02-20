package Project1;

/**
 * Created by M3800 on 1/30/2017.
 */
public class oldIndex
{
    private int size;
    private Node head;
    private Node tail;

    public oldIndex()
    {
        size = 0;
        head = null;
        tail = null;
    }

    public int getSize()
    {
        return size;
    }

    private void addAfter(String data, Node n)
    {
        Node add = new Node(data, n.next);
        n.next = add;
    }

    public void add(String s)
    {
        //adding first name to list
        if (head == null)
        {
            Node add = new Node(s,null);
            Node letter = new Node(s.substring(0, 1).toUpperCase(),add);
            head = letter;
            tail = add;
            size += 2;
        }
        //if first letter does not exist yet in list
        else if (find(s.substring(0, 1).toUpperCase()) == null)
        {
            Node add = new Node(s,null);
            Node letter = new Node(s.substring(0, 1).toUpperCase(),add);
            System.out.println(s.substring(0, 1).toUpperCase());
            Node n = head;
            if (n.name.compareTo(letter.name) > 0)
            {
                add.next = n;
                head = letter;
            } else
            {
                while (n != tail)
                {
                    if (letter.name.compareTo(n.next.name) < 0) //|| n.next.name.length() == 1)
                    {
                        add.next = n.next;
                        n.next = head;
                        break;
                    }
                    n = n.next;
                }
                if (n == tail)
                {
                    n.next = letter;
                    tail = add;
                }
            }
            size += 2;
        }
        //if first letter already exists in the list
        else
        {
            Node add = new Node(s,null);
            Node n = find(s.substring(0, 1).toUpperCase());
            while (n != tail)
            {
                System.out.print(s+"v ");
                //if name comes before the next or if next letter is there
                if (n.next.name.compareTo(add.name) > 0 || (n.next.name.length() == 1))
                {
                    System.out.println("FOUND");
                    add.next = n.next;
                    n.next = add;
                    break;
                }
                n = n.next;
                System.out.println("not stuck");
            }
            if (n == tail)
            {
                System.out.println(s + " is the tail");
                n.next = add;
                tail = add;
            }
            size += 1;
        }
    }

    public void remove(String s)
    {
    }

    public void removeLetter(char c)
    {
    }

    public Node find(String s)
    {
        Node n = head;
        if (n == null)
            return null;
        while (n.next != null)
        {
            if (n.name.equals(s))
                return n;
            n = n.next;
        }
        return null;
    }

    public String toString()
    {
        Node n = head;
        StringBuilder output = new StringBuilder();
        //System.out.println("PRINTING");
        while (n != null)
        {
            //System.out.println("Print:");
            //if (n.name.length() > 1)
            //    output.append("\t");
            //System.out.println("name:");
            output.append(n.name);
            //System.out.println("next");
            output.append("\n");
            n = n.next;
        }
        output.delete(output.length() - 1, output.length());
        output.append("\n" + size); //FOR DEBUGGING ONLY
        return output.toString();
    }

    public static void main(String[] args)
    {
        oldIndex i = new oldIndex();
        i.add("Bill");
        i.add("Car");
        i.add("Dylan");
        i.add("John");
        i.add("ddd");
        //i.add("tiff");
        i.add("Bob");
        i.add("Zed");
        i.add("Josh");
        System.out.println(i);
    }

    private static class Node
    {
        String name;
        Node next;

        public Node(String s, Node n)
        {
            name = s;
            next = n;
        }
    }
}