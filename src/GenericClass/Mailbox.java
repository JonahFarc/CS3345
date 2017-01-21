package GenericClass;//Write a generic class to act as a mailbox which contains one field
//called mail of the generic type. Add methods to get and put mail.

public class Mailbox<mail>
{
    private mail myMail;
    public mail getMail()
    {
        return myMail;
    }
    public void putMail(mail m)
    {
        myMail = m;
    }
}
