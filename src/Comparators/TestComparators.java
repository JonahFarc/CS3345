package Comparators;

import java.util.Arrays;

/**
 * Created by M3800 on 1/18/2017.
 */
public class TestComparators
{
    public static void main(String args[])
    {
        Employee emp1 = new Employee("Joe",20);
        Employee emp2 = new Employee("Sue",25);
        Employee emp3 = new Employee("Bob",22);

        Employee list[] = new Employee[3];
        list[0] = emp1;
        list[1] = emp2;
        list[2] = emp3;

        Arrays.sort(list, new EmpComparatorByAge());

        for (Employee emp : list)
            System.out.println(emp);
    }
}
