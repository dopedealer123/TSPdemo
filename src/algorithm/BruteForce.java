package algorithm;

import graph.Vertex;

import java.util.Scanner;

import static math.nextPermutation.findNextPermutation;

public class BruteForce extends Algorithm {
    @Override

    public void explore() {
        int visited=(1<<graph.getVertices().size())-1; //  exp: if graph have 4 nodes -> visited=1111, 5 nodes-> visited=11111

        int shortestPath= shortestPath(visited,1,0);

        System.out.println("quang dg ngan nhat la: "+ shortestPath);

    }

    public int shortestPath(int visited,int checker,int position){

        //khi đã duyệt hết tất cả các đỉnh hay chưa
        if(checker == visited)
        {
            return graph.getEdge(Integer.toString(position),Integer.toString(0)).getWeight();
        }

        /// kiểm tra xem cạnh đã được duyệt thông qua dpArray


        int ans = 100000;
        for(int city=0;city<graph.getVertices().size();city++){

            if((checker&(1<<city))==0){

                int newAns = graph.getEdge(Integer.toString(position),Integer.toString(city)).getWeight() + shortestPath(visited,checker|(1<<city),city);
                ans = (ans > newAns) ? newAns : ans;
            }
        }


        return ans;
    }

}

