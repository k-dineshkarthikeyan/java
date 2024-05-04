import java.util.Arrays;
import java.util.Scanner;

class Job implements Comparable<Job>{
    int id,profit,deadline;
    Job(int i,int p, int d){
        id=i;
        profit=p;
        deadline=d;
    }
    @Override
    public int compareTo(Job job){
        return -this.profit+job.profit;
    }
}
public class JobSeq {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        int md=0;
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            int d=sc.nextInt();
            if(d>md) md=d;
            jobs[i]=new Job(1+i, p, d);
        }

        Arrays.sort(jobs);
        int totalProfit=0;
        int[] slots = new int[md];
        for (Job j : jobs) {
            int d=j.deadline;
            while(d>0){
                if(slots[--d]==0){
                    totalProfit+=j.profit;
                    slots[d]=j.id;
                    break;
                }
            }
        }
        System.out.print("Job Sequence : ");
        for(int i:slots) System.out.print(i+" ");
        System.out.println("\nTotal Profit : "+totalProfit);
    }
}
