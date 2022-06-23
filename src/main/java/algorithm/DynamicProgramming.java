package main.java.algorithm;

public class DynamicProgramming extends Algorithm {
    @Override
    public void run() {

        int visited=(1<<graph.getVertices().size())-1;

        // số hoán vị của các đỉnh trong đồ thị (không tính đỉnh gốc là 0)
        int permutationNum=(1<<graph.getVertices().size());
        // dpAray: mỗi dòng tương đương 1 hoán vị c
        int [][]dpArray=new int[permutationNum][graph.getVertices().size()];

        //khoi tao gia tri ban dau la -1, chưa có cạnh nào đc duyệt
        for(int i=0;i<permutationNum;i++)
        {
            for(int j=0;j<graph.getVertices().size();j++)
            {
                dpArray[i][j] = -1;
            }
        }

        int shortestPath= findTour(dpArray,visited,1,0);
        System.out.println("quang dg ngan nhat la: "+ shortestPath);

    }

    public int findTour(int[][] dpArray, int visited, int checker, int position){

        //kiểm tra đã duyệt hết tất cả các đỉnh hay chưa
        if(checker == visited)
        {
            return graph.getEdge(Integer.toString(position),Integer.toString(0)).getWeight();
        }

        /// kiểm tra xem cạnh có tồn tai trong dpArray
        if(dpArray[checker][position] != -1)
        {
            return dpArray[checker][position];
        }


        int ans = 100000;
        // với mỗi đỉnh chưa đc duyệt
        for(int city=0;city<graph.getVertices().size();city++){

            if((checker&(1<<city))==0){

                int newAns = graph.getEdge(Integer.toString(position),Integer.toString(city)).getWeight() + findTour(dpArray,visited,checker|(1<<city),city);
                ans = Math.min(ans,newAns);
            }
        }


        dpArray[checker][position] = ans;
        return dpArray[checker][position] = ans;
    }

    public void showStep() {
        // TODO
        System.out.println("Dijkstra");
    }
}