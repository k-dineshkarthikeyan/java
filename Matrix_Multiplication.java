import java.util.Scanner;
import java.util.ArrayList;
class GFG {
    public static int mat(int[] arr, int i, int j){
        int num1=Integer.MAX_VALUE;
        int num=Integer.MAX_VALUE;
        if(i==j){
            return 0;
        }
        for(int n=i;n<j;n++){
            if(n==i){
               num1=mat(arr,i,n)+mat(arr,n+1,j)+(arr[i-1]*arr[n]*arr[j]);
            }
            else{
               num=mat(arr,i,n)+mat(arr,n+1,j)+(arr[i-1]*arr[n]*arr[j]);
            }
            if(num<num1){
               num1=num;
            } 
        }
        return num1;
    }
    
	public static void main (String[] args) {
	     Scanner sc=new Scanner(System.in);
	     ArrayList<Integer> ar=new ArrayList<Integer>();
	     while (sc.hasNext()) {
            String input = sc.next();
            ar.add(Integer.parseInt(input));
	     }
	     int[] arr=new int[ar.size()];
	     for(int i=0;i<ar.size();i++){
	         arr[i]=ar.get(i);
	     }
         System.out.println("Feasible no.of multiplications is: ");
	     System.out.println(mat(arr,1,(arr.length)-1));
	}
}