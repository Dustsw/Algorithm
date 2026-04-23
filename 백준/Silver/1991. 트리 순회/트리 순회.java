import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        char value;
        Node left;
        Node right;
        public Node(char value){
            this.value=value;
        }
    }
    static Node[] tree = new Node[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char pValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if(tree[pValue-'A'] == null){
                tree[pValue-'A'] = new Node(pValue);
            }
            if(leftValue != '.'){
                tree[leftValue-'A'] = new Node(leftValue);
                tree[pValue-'A'].left = tree[leftValue-'A'];
            }
            if(rightValue != '.'){
                tree[rightValue-'A'] = new Node(rightValue);
                tree[pValue-'A'].right = tree[rightValue-'A'];
            }
        }
        Node root = tree[0];
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
    }
    static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }
    static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}