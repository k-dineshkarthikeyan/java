import java.util.*;

class Path implements Comparator<Path>{
    int source,dest,cost;
    Path(){}
    Path(int s,int d,int c){
        source=s;
        dest=d;
        cost=c;
    }
    public String toString(){
        return source+"--("+cost+")->"+dest;
    }
    @Override
    public int compare(Path p1,Path p2){
        return p1.cost-p2.cost;
    }
}
public class Krouscals {
 
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Path> paths = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cost=sc.nextInt();
                if(cost!=0){
                    paths.add(new Path(i,j,cost));
                }
            }
        }
        int tcost=0;
        List<HashSet<Integer>> groups = new ArrayList<>();
        Collections.sort(paths,new Path());
        for (Path path : paths) {
            int x=-1,y=-1;
            for(int i=0;i<groups.size();i++){
                if(x!=-1&&y!=-1) break;
                HashSet<Integer> group = groups.get(i);
                if(group.contains(path.source)) x=i;
                if(group.contains(path.dest)) y=i;
            }
            HashSet<Integer> grp;
            if(x==-1&&y==-1){ //new group
                grp = new HashSet<>();
                grp.add(path.source);
                grp.add(path.dest);
                groups.add(grp);
            }
            else if(x==-1||y==-1){ // one in grp but not another
                grp = groups.get((x>y)?x:y);
                grp.add(path.source);
                grp.add(path.dest);
            }
            else if(x!=y){ // merge 2 grp
                groups.get(x).addAll(groups.get(y));
                groups.remove(y);
            }
            else{
                // cyclic -- ignore
                continue;
            }
            tcost+=path.cost;
            System.out.println(path.toString());
        }
        System.out.println("\nTotal Cost : "+tcost);
    }
}
