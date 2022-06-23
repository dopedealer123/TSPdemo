package main.java.algorithm;

import main.java.graph.Graph;
import java.util.ArrayList;
import java.util.List;
import main.java.step.Step;

public abstract class Algorithm {
    protected Graph graph;

    protected List<Step> stepList = new ArrayList<>();


    public abstract void run();

    public abstract void showStep();

    public Graph getGraph() {
        return graph;
    }
    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }
}
