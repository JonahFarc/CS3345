/**
 * Write a generic class (using Java generics) called Pair that stores two values
 * of the generic type.  It should have a constructor to set them,
 * two methods getfirst() and getsecond() to retrieve them, and a
 * method called swap() that exchanges them.
 * Include a "main" method that creates a Pair of strings and swaps them,
 * printing the before and after values.
 */
public class Pair<type>
{
    type value1;
    type value2;

    public Pair(type first, type second)
    {
        value1 = first;
        value2 = second;
    }
    public type getfirst()
    {
        return value1;
    }
    public type getsecond()
    {
        return value2;
    }
    public void swap()
    {
        type temp = value1;
        value1 = value2;
        value2 = temp;
    }
    public String toString()
    {
        return "Value 1: " + value1 + "\n" + "Value 2: " + value2;
    }

}
