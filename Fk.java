import java.util.*;
public class Fk {

    // public static int Profit()
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int maxw=sc.nextInt();
        int items=sc.nextInt();
        int[] w=new int[items];
        int[] p=new int[items];
        double[] wp=new double[items];
        double[] wp1=new double[items];
        for(int i=0;i<items;i++){
            w[i]=sc.nextInt();
        }
        for(int i=0;i<items;i++){
            p[i]=sc.nextInt();
        }
        for(int i=0;i<items;i++){
            wp[i]=w[i]/p[i];
        }
        // for(int i=0;i<items;i++){
            
        // } 
        Arrays.sort(wp);
        for(int i=items-1;i>-1;i--){
            wp1[(items-1)-i]=wp[i];
        }
        max=0;
        for(int i=0;i<items;i++){
            max=max+wp1[i];
        }
    }
}





// import java.util.Scanner;

// public class Fk {
    
//     static int knapsack(int[] wt, int[] val, int capacity, int n) {
//         if (n == 0 || capacity == 0) {
//             return 0;
//         }

//         if (wt[n - 1] > capacity) {
//             return knapsack(wt, val, capacity, n - 1);
//         } else {
//             return Math.max(val[n - 1] + knapsack(wt, val, capacity - wt[n - 1], n - 1),
//                             knapsack(wt, val, capacity, n - 1));
//         }
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Enter no of items: ");
//         int n = scanner.nextInt();

//         int[] wt = new int[n];
//         int[] val = new int[n];

//         System.out.print("Enter weights of items:");
//         for (int i = 0; i < n; i++) {
//             wt[i] = scanner.nextInt();
//         }

//         System.out.print("Enter values of items:");
//         for (int i = 0; i < n; i++) {
//             val[i] = scanner.nextInt();
//         }

//         System.out.print("Enter capacity of the knapsack: ");
//         int capacity = scanner.nextInt();

//         int maxVal = knapsack(wt, val, capacity, n);
//         System.out.print("The max value that can be obtained is: " + maxVal);

//         scanner.close();
//     }
// }
