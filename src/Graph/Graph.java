package Graph;

import java.awt.Label;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    private List<Vertex> listOfVertexs = new ArrayList<Vertex>();
    private List<Edge> listOfEdges = new ArrayList<Edge>();

    public Graph() {
    }

    public List<Vertex> getListOfVertexs() {
        return listOfVertexs;
    }
    
    public void addVertex() {
        this.listOfVertexs.add(inputVertex());
    }
    
    public void addVertex(Vertex Vertex) {
        this.listOfVertexs.add(Vertex);
    }

    public void addVertexs(List<Vertex> Vertexs) {
        this.listOfVertexs.addAll(Vertexs);
    }

    public List<Edge> getListOfEdges() {
        return listOfEdges;
    }
    
    public void addEdge() {
        this.listOfEdges.add(inputEdge());
    }
    
    public void addEdge(int from, int to){
        Vertex f = findVertex(from);
        Vertex t = findVertex(to);
        this.listOfEdges.add(new Edge(f, t, 1));
    }

    public void addEdge(Edge Edge) {
        this.listOfEdges.add(Edge);
    }
    
    public void addEdges(List<Edge> Edges) {
        this.listOfEdges.addAll(Edges);
    }
    
    public Vertex inputVertex(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        return new Vertex(id);
    }
    
    public Vertex findVertex(int id){
        for(int i=0; i<this.listOfVertexs.size(); i++){
            if(this.listOfVertexs.get(i).getId() == id){
                return this.listOfVertexs.get(i);
            }
        }
        return null;
    }
    
    public Edge inputEdge(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Vertex from: ");
        int fr = Integer.parseInt(sc.nextLine());
        Vertex from = findVertex(fr);
        System.out.println("Enter Vertex to: ");
        int t = Integer.parseInt(sc.nextLine());
        Vertex to = findVertex(t);
        System.out.println("Enter Edge weight: ");
        int weight = Integer.parseInt(sc.nextLine());
        return new Edge(from, to, weight);
    }
    
    public void removeVertex(int id){
        Vertex t = findVertex(id);
        for(int i=0; i<listOfEdges.size(); i++){
            if(listOfEdges.get(i).getFrom().equals(t) || listOfEdges.get(i).getTo().equals(t)){
                listOfEdges.remove(i);
            }
        }
        for(int i=0; i<listOfVertexs.size(); i++){
            if(listOfVertexs.get(i).equals(t)){
                listOfVertexs.remove(i);
            }
        }
    }
    
    public void removeEdge(int from, int to){
        Vertex fr = findVertex(from);
        Vertex t = findVertex(to);
        for(int i=0; i<listOfEdges.size(); i++){
            if(listOfEdges.get(i).getFrom().equals(fr) && listOfEdges.get(i).getTo().equals(t)){
                listOfEdges.remove(i);
            }
        }
    }
    
    public void removeAllOfGraph(){
        while(listOfVertexs.size() != 0){
            removeVertex(listOfVertexs.get(0).getId());
        }
    }
    
    public void printGraph(){
        for(int i=0; i<this.listOfVertexs.size(); i++){
            System.out.println(listOfVertexs.get(i).toString());
        }
        for(int i=0; i<this.listOfEdges.size(); i++){
            System.out.println(listOfEdges.get(i).toString());
        }
    }
}
