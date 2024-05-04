import java.util.Scanner;
public class MergeSort {

    public static int[] sort(int[] arr,int start,int end){
        int mid=(start+end)/2;
        for(int i:arr) System.out.print(i+" ");
        System.out.println(" | "+start+" "+mid+" "+end);
        if(start==end) return new int[] {arr[start]};
        int[] left=sort(arr, start, mid);
        int[] right=sort(arr, mid+1, end);
        int[] sorted=new int[left.length+right.length];
        int l=0,r=0,a=0;
        while (l<left.length && r<right.length) {
            if(left[l]<=right[r]){
                sorted[a++]=left[l++];
            }
            else{
                sorted[a++]=right[r++];
            }
        }
        while (l<left.length) {
            sorted[a++]=left[l++];
        }
        while (r<right.length) {
            sorted[a++]=right[r++];
        }
        return sorted;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Length of the Array: ");
        int n = sc.nextInt();
       
        int[] arr =new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        arr=sort(arr, 0 , arr.length-1);
        
        System.out.println("Elements in Sorted Order: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
