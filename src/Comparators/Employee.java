package Comparators;

import java.util.Comparator;

/**
 * Employee class
 * fields age, name
 * two comparators: one by age, one by name
 */
public class Employee
{
    private int age;
    private String name;

    public Employee(String n, int a)
    {
        name = n;
        age = a;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return name + ", " + age;
    }
}
