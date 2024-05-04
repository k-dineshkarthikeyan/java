import java.net.SocketPermission;
import java.util.Scanner;
class Knapsack{
    
    public static int knapsackf(int matrix[][],int[][] matrix1){
        for(int i=0;i<matrix1.length;i++){
            for(int j=0;j<matrix1[0].length;j++){
                if(i==0){
                   matrix1[i][j]=0;
                }
                else{
                    if(j<matrix[i][1]){
                        matrix1[i][j]=matrix1[i-1][j];
                    }
                    else{
                        matrix1[i][j]=Math.max(matrix1[i-1][j],(matrix[i][0]+matrix1[i-1][(j-(matrix[i][1]))]));
                    }
                }
            }
        }
        return matrix1[(matrix1.length)-1][(matrix1[0].length)-1];
    }
    
    public static int[][] mat_creation(int items,int max){
        int[][] matrix1=new int[items+1][max+1];
        for(int i=0;i<items+1;i++){
            for(int j=0;j<max+1;j++){
                matrix1[i][j]=0;
            }
        }
        return matrix1;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no.of.items: ");
        int items=sc.nextInt();
        int[][] matrix=new int[items+1][2];
        System.out.println("Enter the weight and profit of an items next to next: ");
        for(int i=0;i<items+1;i++){
            for(int j=0;j<2;j++){
                if(i==0){
                    matrix[i][j]=0;
                }
                else{
                    matrix[i][j]=sc.nextInt();
                }
            }
        }
        System.out.println("Enter max weight: ");
        int max=sc.nextInt();
        System.out.println("Maximum profit is");
        System.out.println(knapsackf(matrix,(mat_creation(items,max))));
    }
}

