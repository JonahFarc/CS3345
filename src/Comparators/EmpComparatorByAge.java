package Comparators;

import java.util.Comparator;

/**
 * Created by M3800 on 1/18/2017.
 */
public class EmpComparatorByAge implements Comparator<Employee>
{
    public int compare(Employee e1, Employee e2)
    {
        if (e1.getAge() < e2.getAge())
            return -1;
        else if (e1.getAge() > e2.getAge())
            return 1;
        else
            return 0;
    }
}
