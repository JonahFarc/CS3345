package Project5;// Project 5 for CS 3345.001
// Programmer: Dylan Yu (dsy160030)
// Description: Runs the Dijkstra algorithm on the given adjacency list. It will give the shortest path between two given vertices.

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {
    public static Vertex[] flights;
    //creates the vertex class
    private static class Vertex
    {
        public String name;
        public List<Vertex> adj;
        public boolean known;
        public int dist;
        public Vertex path;
        public Vertex(String name, int dist)
        {
            this.name = name;
            this.dist = dist;
            adj = new ArrayList<Vertex>();
            known = false;
        }
    }
    //prints out the path from initial to terminal vertex
    private static void printPath(Vertex v)
    {
        if(v.path != null)
        {
            printPath(v.path);
            System.out.print(" -> ");
        }
        System.out.print(v.name);
    }
    //checks if there are any unknown vertices in the list
    private static boolean unknown(List<Vertex> vertices)
    {
        for(int i = 0; i < vertices.size(); i++)
            if(!vertices.get(i).known)
                return true;
        return false;
    }
    //Main code of the dijkstra algorithm
    private static void dijkstra(Vertex v)
    {
        //sets the initial vertex to be known with a distance of 0
        flights[location(v.name)].dist = 0;
        flights[location(v.name)].known = true;
        int loop = -1;
        int index = 0;
        //loops through all the vertices
        for(;loop < flights.length-1; loop++) {
            if(index == location(v.name))
                index++;
            if(loop == -1)
                index = location(v.name);
            //loops through all the adjacent vertices of each vertex
            while (unknown(flights[index].adj)) {
                //finds the smallest unknown adjacent vertex
                int min = -1;
                for (int i = 0; i < flights[index].adj.size(); i++)
                    if (!flights[index].adj.get(i).known)
                        if (min == -1 || flights[index].adj.get(i).dist < flights[index].adj.get(min).dist)
                            min = i;
                //sets the vertex to be known and finds the shortest possible path to that location
                Vertex w = flights[location(flights[index].adj.get(min).name)];
                w.known = true;
                flights[index].adj.get(min).known = true;
                w.dist = Math.min(flights[index].dist+flights[index].adj.get(min).dist, w.dist);
                //loops through all the adjacent vertices of the adjacent vertices
                for (int i = 0; i < w.adj.size(); i++) {
                    Vertex x = w.adj.get(i);
                    //if unknown, sets the variable to the shortest distance to reach the path.
                    if (!x.known) {
                        int cwx = w.adj.get(i).dist;
                        if (w.dist + cwx < flights[location(x.name)].dist) {
                            flights[location(x.name)].dist = (w.dist + cwx);
                            flights[location(x.name)].path = w;
                        }
                    }
                }
            }
            if(index == location(v.name))
                index = -1;
            index++;

        }
    }
    //returns the location in the array if the name of the vertex is found. Otherwise, returns -1.
    private static int location(String name)
    {
        for(int i = 0; i < flights.length; i++)
            if(flights[i].name.equals(name))
                return i;
        return -1;
    }
    public static void main(String[] args)
    {
        Vertex[] localFlights = new Vertex[1];
        int numFlights = 0;
        //Parse all the information into an ArrayList
        try {
            Scanner s = new Scanner(new File("airports.txt"));
            //count number of flight vertices by looping through the lines of the file
            while(s.hasNextLine())
            {
                numFlights++;
                s.nextLine();
            }
            s.close();
            //initialize array
            localFlights = new Vertex[numFlights];
            s = new Scanner(new File("airports.txt"));
            //loop through and add values to each flight vertex
            for (int i = 0; i < numFlights; i++)
            {
                String scanned = s.nextLine();
                Scanner sc = new Scanner(scanned);
                localFlights[i] = new Vertex(sc.next(), Integer.MAX_VALUE-5);
                //add adjacent vertices and their distances
                while(sc.hasNext())
                    localFlights[i].adj.add(new Vertex(sc.next(), sc.nextInt()));
                sc.close();
            }
            s.close();
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
        //takes the command about whether or not to pass it
        String cmd = "Yes";
        Scanner input = new Scanner(System.in);
        boolean continuee = true;
        while(continuee)
        {
            flights = localFlights;
            System.out.print("Enter departure airport:  ");
            String initial = input.next();
            System.out.print("Enter arrival airport:    ");
            String terminal = input.next();
            dijkstra(flights[location(initial)]);
            System.out.println();
            System.out.print("Price:       ");
            System.out.println(flights[location(terminal)].dist);
            System.out.print("Connections: ");
            System.out.println();
            System.out.print("Route:       ");
            System.out.print(initial + " -> ");
            printPath(flights[location(terminal)]);
            System.out.print("\n\nCheck another route (Y/N)? ");
            //ensures the input is a valid response, or else prompts for another answer
            boolean validinput = false;
            while(!validinput)
            {
                cmd = input.next();
                if (cmd.matches("(y|Y)(es|ES|)"))
                    continuee=true;
                else if (cmd.matches("(n|N)(o|O|)"))
                    continuee=false;
                else
                {
                    System.out.println("\nInvalid input. Check another route (Y/N)? ");
                    continue;
                }
            }

        }
    }
}
