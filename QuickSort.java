// package LABFAT_PREP;
import java.util.Scanner;
public class QuickSort {
    public static void swap(int[] arr, int x, int y){
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static void sort(int[] arr,int start,int end){
        if(start>=end) return;
        int p=end,c=start;
        for(int d=start;d<=end;d++){
            if(arr[d]<=arr[p]){
                swap(arr, c++, d);
            }
        }
        if (p<--c){
            swap(arr, p, c);
        }
        sort(arr, start, c-1);
        sort(arr, c+1, end);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Length of the Array: ");
        int n = sc.nextInt();
       
        int[] arr =new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr, 0 , arr.length-1);
        
        System.out.println("Elements in Sorted Order: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
//              .
//  2 5 1 8 7 8 85
//          ,
//  , - position to be swqpped the the next comming no that is <= pivot
//         .
// 3 4 2 5 6
//       ,