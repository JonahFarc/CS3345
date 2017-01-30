/**
 * Created by M3800 on 1/30/2017.
 */
public class Index {
    Node head;
    public Index()
    {
        head = null;
    }
    public void add(String s)
    {
        if(head == null)
        {
            Node letter = new Node(s.substring(0,1));
            Node add = new Node(s);
            letter.next = add;
            head = letter;
        }
        if(find(s.substring(0,1)) == null)
        {
            Node letter = new Node(s.substring(0,1));
            Node add = new Node(s);
            letter.next = add;
            Node n = head;
            if(n.name.compareTo(letter.name) < 0)
            {
                add.next = head;
                head = letter;
            }
            else
            {
                while (n.next != null) {
                    if (letter.name.compareTo(n.next.name) < 0) {
                        add.next = n.next;
                        n.next = head;
                        break;
                    }
                    n = n.next;
                }
                if(n.next == null)
                    n.next = letter;
            }
        }
        else
        {
            Node add = new Node(s)
            Node n = find(s.substring(0,1));
            while (n.next != null)
            {
                if(n.next.name.compareTo(add.name) > 0)
                {
                    add.next = n.next;
                    n.next = add;
                    break;
                }
                n = n.next;
            }
            if(n.next == null)
                n.next = add;
        }
    }
    public void remove(String s)
    {
        Node n = find(s.substring(0,1));
        if(n!= null) {
            while (n.next != null) {
                if (n.next.name.equals(s)) {
                    n.next = n.next.next;
                    if(n.next.next.name.charAt(0) != s.charAt(0))
                        removeLetter(s.charAt(0));
                    break;
                }
            }
        }
    }
    public void removeLetter(char c){}
    public Node find(String s)
    {
        Node n = head;
        if(n==null)
            return null;
        while (n.next != null) {
            if (n.name.equals(s))
                return n;
            n = n.next;
        }
        return null;
    }
    public String toString()
    {
        Node n = head;
        while(n.next != null)
    }
    public static void main(String[] args)
    {

    }
}
class Node{
    String name;
    Node next;
    public Node(String s)
    {
        name = s;
        next = null;
    }
    public String getName() {
        return name;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getNext() {
        return next;
    }
}