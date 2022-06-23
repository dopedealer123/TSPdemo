package main.java.algorithm;

import java.util.HashMap;
import main.java.step.Step;
import main.java.utils.PressEnterToContinue;
public class BruteForce extends Algorithm {

    private HashMap<Integer, String> pseudoStep = new HashMap<Integer, String>();

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public BruteForce() {
        super();
        // init pseudoStep
        pseudoStep.put(0, "function findTour(pos, checker)");
        pseudoStep.put(1, "if every node has been visited: return cost[pos][0]\n"  + " ans = ∞");
        pseudoStep.put(2, "for every unvisited node V\n" + "  ans = min(ans,findTour(v,mask|(1<<V))+cost[pos][v])");
        pseudoStep.put(3, "return ans\n");
    }
    @Override

    public void run() {
        int visited=(1<<graph.getVertices().size())-1; //  exp: if graph have 4 nodes -> visited=1111, 5 nodes-> visited=11111

        int shortestPath= shortestPath(visited,1,0);

        System.out.println("quang dg ngan nhat la: "+ shortestPath);

    }

    public int shortestPath(int visited,int checker,int position){
        //step1
        //khi đã duyệt hết tất cả các đỉnh hay chưa
        if(checker == visited)
        {
            return graph.getEdge(Integer.toString(position),Integer.toString(0)).getWeight();
        }
        //step2
        /// kiểm tra xem cạnh đã được duyệt thông qua dpArray


        int ans = 100000;
        for(int city=0;city<graph.getVertices().size();city++){

            if((checker&(1<<city))==0){

                int newAns = graph.getEdge(Integer.toString(position),Integer.toString(city)).getWeight() + shortestPath(visited,checker|(1<<city),city);
                ans = Math.min(ans,newAns);
                //step3
            }
        }


        return ans;
        //step4
    }

    public void showStep() {
        for (Step step : stepList) {
            System.out.println(step.toString());
            System.out.println("----------------------------");
            for (int i = 0; i < pseudoStep.size(); i++) {
                if (step.getId() == i) {
                    System.out.println(ANSI_GREEN + pseudoStep.get(i) + ANSI_RESET);
                } else {
                    System.out.println(pseudoStep.get(i));
                }
            }
            PressEnterToContinue.run();
        }
    }
}

