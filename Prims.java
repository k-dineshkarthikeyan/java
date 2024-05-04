import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
    PriorityQueue<Path> pque=new PriorityQueue<>();
    HashSet<Integer> visited= new HashSet<>();//set doesn't contains duplicates
    Path[][] paths;
    int tcost=0,n;
    class Path implements Comparable<Path>{
        int source,dest,cost;
        Path(int s,int d,int c){
            source=s;
            dest=d;
            cost=c;
        }
        public String toString(){
            return source+"--("+cost+")->"+dest;
        }
        @Override
        public int compareTo(Path p){
            return this.cost-p.cost;
        }
    }
    Prims(int[][] p){
        n=p.length;
        paths= new Path[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                paths[i][j]=new Path(i,j,p[i][j]);
            }
        }
    }

    public void vist(int node){
        visited.add(node);
        for(Path p:paths[node]){
            if(p.cost!=0) pque.add(p); //cost of the visited node is getting added
        }
    }
    public int mst() {
        vist(0);
        while(visited.size()<n){
            Path minPath = pque.poll();
            if(!visited.contains(minPath.dest)){
                vist(minPath.dest);
                tcost+=minPath.cost;
                System.out.println(minPath.toString());
            }
        }
        return tcost;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] adjMat = new int[n][n]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjMat[i][j]=sc.nextInt();
            }
        }
        Prims p =new Prims(adjMat);
        System.out.println("");
        System.out.println("\nTotal Cost : "+p.mst());

    }
}
