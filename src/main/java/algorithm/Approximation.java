package main.java.algorithm;

import main.java.step.Step;
import main.java.utils.PressEnterToContinue;
import main.java.graph. Vertex;

import java.util.*;

public class Approximation extends Algorithm {
    private HashMap<Integer, String> pseudoStep = new HashMap<Integer, String>();

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";

    @Override
    public void run() {

        int[] finalAns=new int[graph.getVertices().size()+1];
        int index=0;

        boolean[] visitedNodes = new boolean[graph.getVertices().size()];

        for(int i=0;i<graph.getVertices().size();i++)
        {
            visitedNodes[i] = false;
        }

        int[] parent = primMST();

        dfs(parent,0,visitedNodes,finalAns,index);
        System.out.println(index);
        //1finalAns[index]=0;

        int shortestPath = 0;


        System.out.println(Arrays.toString(finalAns));

        for (int i = 1; i <finalAns.length; i++) {
            String source= Integer.toString(finalAns[i-1]);
            String destination= Integer.toString(finalAns[i]);
            System.out.println(finalAns[i-1]+" "+finalAns[i]);
            shortestPath = shortestPath +  graph.getEdge(source,destination).getWeight();
        }

        System.out.println(shortestPath);


    }

    public void showStep() {
        for (Step step : stepList) {
            System.out.println(step.toString());
            System.out.println("----------------------------");
            for (int i = 0; i < pseudoStep.size(); i++) {
                if (step.getId() == i) {
                    System.out.println(ANSI_RED + pseudoStep.get(i) + ANSI_RESET);
                } else {
                    System.out.println(pseudoStep.get(i));
                }
            }
            PressEnterToContinue.run();
        }
    }

    public void nextStep() {
        for (Step step : stepList) {
            System.out.println(step.toString());
            System.out.println("----------------------------");
            for (int i = 0; i < pseudoStep.size(); i++) {
                if (step.getId() == i) {
                    System.out.println(ANSI_RED + pseudoStep.get(i) + ANSI_RESET);
                } else {
                    System.out.println(pseudoStep.get(i));
                }
            }

        }
    }

    public int minKey(int[] key, boolean[] mstSet) // return the index of a vertex has min value and is not visited
    {
        int min = Integer.MAX_VALUE;
        int minIndex=-1;

        for (int v = 0; v < graph.getVertices().size(); v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }


    public int[] primMST() // getting the Minimum Spanning Tree from the given graph, using Prim's Algorithm
    {
        int V= graph.getVertices().size();

        int[] parent = new int[V];// Exp: if parent[u]=v, mean v is parent of u

        int[] key = new int[V]; // Key values used to pick minimum weight edge in cut

        boolean[] mstSet = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0;

        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);

            mstSet[u] = true;

            int weight;

            for (int v = 0; v < V; v++) {

                if (graph.getEdge(Integer.toString(u), Integer.toString(v)) !=null) { // if edge is existed

                     weight = graph.getEdge(Integer.toString(u), Integer.toString(v)).getWeight();
                }else{
                    weight=0;
                }


                if (weight!= 0 && !mstSet[v] && weight < key[v]) {

                    parent[v] = u;

                    key[v] = weight;
                }
            }
        }
        return parent; // return the list of MST
    }


    void dfs(int[] parent, int startingVertex, boolean[] visitedNodes, int[]finalAns,int index) // getting the preorder walk of the MST using DFS
    {
        System.out.println("index: "+ index);
        // adding the node to final answer
        finalAns[index]=startingVertex;

        index=index+1;

        // checking the visited status
        visitedNodes[startingVertex] = true;

        // using a recursive call
        for(int i=0;i<graph.getVertices().size();i++)
        {
            if(i==startingVertex)
            {
                continue;
            }
            if(parent[i]==startingVertex)//  if startingVertex is parent of i
            {
                if(visitedNodes[i])
                {
                    continue;
                }
                dfs(parent,i,visitedNodes,finalAns,index);
            }
        }
}
}

