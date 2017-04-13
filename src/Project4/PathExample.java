package Project4;

import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample
{
    public static void write(Path p)
    {
        try ( PrintWriter pw = new PrintWriter(p.toString()) )
        {
            pw.println("1 2 3");
        }
        catch (Exception e)
        {
            System.out.println("Write: " + p);
            System.out.println(e);
        }
    }

    public static void read(Path p)
    {
        try ( Scanner sc = new Scanner(p); )
        {
            while (sc.hasNextInt())
            {
                int v = sc.nextInt();
                System.out.println(v);
            }
        }
        catch (Exception e)
        {
            System.out.println("Read: " + p);
            System.out.println(e);
        }
    }


    public static void main(String args[])
    {
        Path p = Paths.get("T1");
        PathExample.read(p);
        PathExample.write(p);
        PathExample.read(p);
    }
}
