package GenericClass;

public class TestMailbox
{
    public static void main(String[] args)
    {
        Mailbox<String> mbox = new Mailbox<String>();
        mbox.putMail("You have mail.");
        String s = mbox.getMail();
        System.out.println(s);
    }
}