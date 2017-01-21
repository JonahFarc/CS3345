/**
 * Created by M3800 on 1/20/2017.
 */
public class TestPair
{
    public static void main(String[] args)
    {
        Pair<String> test = new Pair<>("uno","dos");
        System.out.println("Before:\n" + test);
        test.swap();
        System.out.println("\nAfter:\n" + test);
    }
}
