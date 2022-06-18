package context;

import algorithm.Algorithm;
import graph.Graph;

public class Context {
    private Algorithm algorithm;


    public void play() {
        algorithm.explore();
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
