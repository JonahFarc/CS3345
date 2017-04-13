package Project4;// Project 4 for CS 3345.001
// Programmer: Dylan Yu (dsy160030)
// Description: Runs an external sort on a file with data named T1. Requires an argument to be a number.
// The sort uses a bubble sort algorithm mixed with an external sort.
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ExternalSort
{
    public static String sort(String s)
    {
        String[] strings = s.split(" ");
        int length = strings.length;
        int[] ray = new int[length];
        for(int i = 0; i < length; i++)
        {
            int min = i;
            for(int x = i; x < length; x++)
                if(Integer.parseInt(strings[x]) < Integer.parseInt(strings[min]))
                {
                    min = x;
                }
            ray[i] = Integer.parseInt(strings[min]);
            strings[min] = strings[i];
        }
        String output = "";
        for (int i = 0; i < ray.length; i++)
            output += ray[i] + " ";
        return output;
    }
    public static void print(Path p)
    {
        try(Scanner sc = new Scanner(p);)
        {
            while (sc.hasNextInt())
            {
                System.out.print(sc.nextInt()+" ");
            }
            System.out.println();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static Path extsort(Path t1, int runsize)
    {
        Path t2 = Paths.get("T2");
        Path t3 = Paths.get("T3");
        Path t4 = Paths.get("T4");
        try(Scanner s = new Scanner(t1);)
        {
            int sum = 0;
            PrintWriter print1 = new PrintWriter(t3.toString());
            PrintWriter print2 = new PrintWriter(t4.toString());
            while(s.hasNextInt()) {
                int count = 0;
                String print = "";
                while (s.hasNextInt() && count++ < runsize){
                    print += s.nextInt() + " ";
                sum++;}
                print = sort(print);
                print1.print(print);
                print = "";
                count = 0;
                while (s.hasNextInt() && count++ < runsize){
                    print += s.nextInt() + " ";sum++;}
                print = sort(print);
                print2.print(print);
            }
            print1.close();
            print2.close();
            int runs = sum % (runsize*2) == 0 ? sum/(runsize*2) : sum/(runsize*2) + 1;
            for(int i = 0; i < runs; i++)
            {
                if(i%2 == 0)
                {
                    try(Scanner scan = new Scanner(t3); ) {
                        try (Scanner scans = new Scanner(t4)) {
                            boolean printer = false;
                            PrintWriter p1 = new PrintWriter(t1.toString());
                            PrintWriter p2 = new PrintWriter(t2.toString());
                            while(scan.hasNextInt()) {
                                String print = "";
                                int count = 0;
                                while (scan.hasNextInt() && count++ < runsize * (Math.pow(2,i))) {
                                    print += scan.nextInt() + " ";
                                }
                                int counts = 0;
                                while (scans.hasNextInt() && counts++ < runsize * (Math.pow(2,i))) {
                                    print += scans.nextInt() + " ";
                                }
                                print = sort(print);
                                if(!printer)
                                    p1.print(print);
                                else
                                    p2.print(print);
                                printer = !printer;
                            }
                            p1.close();
                            p2.close();
                        }
                        catch (Exception e) {System.out.println(e);}
                    }
                    catch(Exception e){System.out.println(e);}
                }
                if(i%2 == 1)
                {
                    String print = "";
                    try(Scanner scan = new Scanner(t1); ) {
                        try (Scanner scans = new Scanner(t2)) {
                            boolean printer = false;
                            PrintWriter p3 = new PrintWriter(t3.toString());
                            PrintWriter p4 = new PrintWriter(t4.toString());
                            while (scan.hasNextInt()) {
                                int count = 0;
                                while (scan.hasNextInt() && count++ < runsize * (Math.pow(2, i))) {
                                    print += scan.nextInt() + " ";
                                }
                                int counts = 0;
                                while (scans.hasNextInt() && counts++ < runsize * (Math.pow(2, i))) {
                                    print += scans.nextInt() + " ";
                                }
                                print = sort(print);
                                if (!printer)
                                    p3.print(print);
                                else
                                    p4.print(print);
                                printer = !printer;
                            }
                            p3.close();
                            p4.close();
                        }
                        catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    catch(Exception e){System.out.println(e);}
                }
            }
            if(runs%2 == 1)
                return t1;
            return t3;

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return t1;
    }
    public static void main(String[] args)
    {
        int runsize = Integer.parseInt(args[0]);
        Path p = Paths.get("T1");
        Path sort = extsort(p, runsize);
        print(sort);
    }
}
