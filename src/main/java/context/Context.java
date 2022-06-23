package main.java.context;

import main.java.algorithm.Algorithm;

public class Context {
    private Algorithm algorithm;


    public void play() {
        algorithm.run();
        algorithm.showStep();
    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
