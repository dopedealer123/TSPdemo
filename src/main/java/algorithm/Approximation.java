package main.java.algorithm;

import main.java.graph.Vertex;

import java.util.*;

public class Approximation extends Algorithm {
    @Override
    public void run() {
        // TODO
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------BFS-------------");
        Vertex startVertex = null;
        Vertex endVertex = null;
        do {
            System.out.println("Enter the starting vertex id: ");
            String startId = sc.nextLine();
            startVertex = graph.getVertex(startId);
            System.out.println("Enter the ending vertex id: ");
            String endId = sc.nextLine();
            endVertex = graph.getVertex(endId);
            if (startVertex == null || endVertex == null) {
                System.out.println("Invalid vertex id"); //
                System.out.println("This is graph: ");
                System.out.println(graph.toString());
            } else
                break; // valid vertex id
        } while (true);

        Queue<Vertex> queue = new LinkedList<>();
        HashMap<Vertex, Boolean> visited = new HashMap<>();
        HashMap<Vertex, Vertex> parent = new HashMap<>();
        boolean founded = false;
        queue.add(startVertex);
        while (queue.size() > 0 && !founded) {
            System.out.println("Queue: ");
            for (Vertex v : queue) {
                System.out.print(v.getId() + " ");
            }
            System.out.println("\nVisited: ");
            for (Vertex v : visited.keySet()) {
                System.out.print(v.getId() + " ");
            }
            Vertex vertex = queue.remove();
            System.out.println("\nCurrent vertex: " + vertex.getId());

            visited.put(vertex, true);
            Set<Vertex> neighbors = graph.getNeighbors(vertex.getId());
            for (Vertex v : neighbors) {
                System.out.println("Neighbor: " + v.getId());
                if (v.getId().equals(endVertex.getId())) {
                    System.out.println("Path found ");
                    founded = true;
                    parent.put(v, vertex);
                    break;
                }
                if (!visited.containsKey(v)) {
                    parent.put(v, vertex); // save the parent of v
                    queue.add(v);
                }
            }
        }
        if (!founded) {
            System.out.println("No path found");
        } else {
            System.out.println("The shortest path from " + startVertex.getId() + " to " + endVertex.getId() + " is: ");
            Vertex v = endVertex;
            while (v != null) {
                System.out.println(v.getId());
                v = parent.get(v);
            }
        }
    }

    public void showStep() {
        // TODO
        System.out.println("Dijkstra");
    }
}

