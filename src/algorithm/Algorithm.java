package algorithm;

import graph.Graph;

public abstract class Algorithm {
    protected Graph graph;

    public abstract void explore();

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
