package main.java.graph;

import java.util.*;

public class Graph {
    private Set<Vertex> vertices = new TreeSet<Vertex>();

    private Set<Edge> edges = new TreeSet<Edge>();

    public void addVertex(String id) {
        // TODO
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                System.out.println("Vertex already exists");
                return;
            }
        }
        vertices.add(new Vertex(id));
        System.out.println("Vertex added");
    }

    public void removeVertex(String id) {
        // TODO
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                vertices.remove(v);
                System.out.println("Vertex removed");
                return;
            }
        }
        System.out.println("Vertex does not exist");
    }

    public void addEdge(String vertex1Id, String vertex2Id, int weight) {
        // add edge to the graph
        Vertex vertex1 = null;
        Vertex vertex2 = null;
        // find vertex1 and vertex2 if they exist
        for (Vertex v : vertices) {
            if (v.getId().equals(vertex1Id)) {
                vertex1 = v;
            }
            if (v.getId().equals(vertex2Id)) {
                vertex2 = v;
            }
        }
        if (vertex1 == null || vertex2 == null) {
            System.out.println("Vertex does not exist");
            return;
        } else {
            edges.add(new Edge(vertex1, vertex2, weight));
            System.out.println("Edge added");
        }
    }

    public void addUndirectedGraphEdge(String vertex1Id, String vertex2Id, int weight) {
        // add edge to the graph
        addEdge(vertex1Id, vertex2Id, weight);
        addEdge(vertex2Id, vertex1Id, weight);
    }

    public void addUnWeightedGraphEdge(String vertex1Id, String vertex2Id) {
        // add edge to the graph
        addEdge(vertex1Id, vertex2Id, 0);
    }

    public void removeEdge(String vertex1Id, String vertex2Id) {
        // remove edge from the graph
        Vertex vertex1 = null;
        Vertex vertex2 = null;
        for (Vertex v : vertices) {
            if (v.getId().equals(vertex1Id)) {
                vertex1 = v;
            }
            if (v.getId().equals(vertex2Id)) {
                vertex2 = v;
            }
        }
        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertex1Id) && e.getDestination().getId().equals(vertex2Id)) {
                edges.remove(e);
                return;
            }
        }
        System.out.println("Edge does not exist");
    }

    public static Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("0");
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addUndirectedGraphEdge("0", "1", 25);
        graph.addUndirectedGraphEdge("0", "2", 25);
        graph.addUndirectedGraphEdge("0", "3", 13);
        graph.addUndirectedGraphEdge("1", "2", 25);
        graph.addUndirectedGraphEdge("1", "3", 13);
        graph.addUndirectedGraphEdge("2", "3", 13);
        return graph;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : vertices) {
            sb.append("Vertices:" + v.getId() + "\n");
            for (Edge e : edges) {
                if (e.getSource().getId().equals(v.getId())) {
                    sb.append(v.getId() + "-->" +e.getDestination().getId() + " " + e.getWeight() + "\n");
                }
            }
        }
        sb.append("\n");

        return sb.toString();
    }

    public Vertex getVertex(String id) {
        for (Vertex v : vertices) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public Edge getEdge(String vertex1Id, String vertex2Id) {
        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertex1Id) && e.getDestination().getId().equals(vertex2Id)) {
                return e;
            }
        }
        return null;
    }

    /*public Set<Vertex> getNeighbors(String vertexId) {
        Set<Vertex> adjacencyList = new TreeSet<Vertex>();
        for (Edge e : edges) {
            if (e.getSource().getId().equals(vertexId)) {
                adjacencyList.add(e.getDestination());
            }
        }
        return adjacencyList;
    }

    // biến listGrpah thành matrixGraph để sử dụng cho các thuật toán
    /*public int[][] convertToMatrix(){

        int[][] matrix = new int[vertices.size()][vertices.size()];// khỏi tạo ma trận

        for (Vertex v : vertices) {
            int row=Integer.parseInt(v.getId());// cho đỉnh source là row
            for (Edge e : edges) {
                if (e.getSource().getId().equals(v.getId())) {
                    int col=Integer.parseInt(e.getDestination().getId());// cho đỉnh destination là col
                    matrix[row][col]=e.getWeight();// cho weight của edge vào trong matrix
                }
            }
        }

        return matrix;
    }*/

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }
}
