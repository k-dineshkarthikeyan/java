import java.util.Scanner;
class Node{
    int key;
    Node left,right;
    Node(int key){
        this.key=key;
        left=right=null;
    }
}
public class BinarySearchTree {
    static Node root1;
    public static Node insert(Node root,int key){
        if(root==null){
            root=new Node(key);
            return root;
        }
        if(root.key>key){
            root.left=insert(root.left,key);
        }
        else if(root.key<key){
            root.right=insert(root.right,key);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.key+" ");
        inorder(root.right);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=sc.nextInt();
        }
        root1=new Node(arr[0]);
        for(int i=1;i<length;i++){
            insert(root1,arr[i]);
        }
        inorder(root1);
    }
}
