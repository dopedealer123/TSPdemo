package algorithm;

import graph.Vertex;

import java.util.Scanner;

import static math.nextPermutation.findNextPermutation;

public class BruteForce extends Algorithm {
    @Override
    public void explore() {

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------BruteForce-------------");
        Vertex startVertex = null;
        String startId = " ";
        do {
            System.out.println("Enter the starting vertex id: ");
            startId = sc.nextLine();
            startVertex = graph.getVertex(startId);
            if (startVertex == null) {
                System.out.println("Invalid vertex id"); //
                System.out.println("This is graph: ");
                System.out.println(graph.toString());
            } else
                break; // valid vertex id
        } while (true);

        int shortestPath = 1000000000;
        int source = Integer.parseInt(startId);
        int[] nodes= new int[graph.getVertices().size()-1];
        int n=nodes.length;
        int j=0;

        for (int i=0; i<graph.getVertices().size(); i++){

            if(i !=source){
                nodes[j]=i;
                j++;
            }
        }

        while(findNextPermutation(nodes))
        {
            int pathWeight = 0;

            int temp = source;
            for (int i = 0; i < n; i++)
            {
                pathWeight += graph.getEdge(Integer.toString(temp),Integer.toString(nodes[i])).getWeight();
                temp = nodes[i];
            }
            pathWeight += graph.getEdge(Integer.toString(temp),Integer.toString(source)).getWeight();

            shortestPath = (shortestPath > pathWeight) ? pathWeight : shortestPath;
        }
        System.out.println("shortest path: "+ shortestPath);

    }
}

