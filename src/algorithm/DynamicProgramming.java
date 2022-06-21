package algorithm;

public class DynamicProgramming extends Algorithm {
    @Override
    public void explore() {

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

        int shortestPath= shortestPath(dpArray,visited,1,0);
        System.out.println("quang dg ngan nhat la: "+ shortestPath);

    }

    public int shortestPath(int[][] dpArray,int visited,int mask,int position){

        //khi đã duyệt hết tất cả các đỉnh hay chưa
        if(mask == visited)
        {
            return graph.getEdge(Integer.toString(position),Integer.toString(0)).getWeight();
        }

        /// kiểm tra xem cạnh đã được duyệt thông qua dpArray
        if(dpArray[mask][position] != -1)
        {
            return dpArray[mask][position];
        }


        int ans = 100000;
        for(int city=0;city<graph.getVertices().size();city++){

            if((mask&(1<<city))==0){

                int newAns = graph.getEdge(Integer.toString(position),Integer.toString(city)).getWeight() + shortestPath(dpArray,visited,mask|(1<<city),city);
                ans = (ans > newAns) ? newAns : ans;
            }
        }


        dpArray[mask][position] = ans;
        return dpArray[mask][position] = ans;
    }

}
