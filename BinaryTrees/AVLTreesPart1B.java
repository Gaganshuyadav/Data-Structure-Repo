package BinaryTrees;

import java.util.Queue;
import java.util.LinkedList;

public class AVLTreesPart1B {
    public static class Node{
        int data;
        int height;
        Node left, right;

        Node(int data){
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

    }

    public static Node root;

    public static int height( Node root){
        if(root==null){
            return 0;
        }

        return root.height;
    }

    public static int balanceFactor(Node root){

        if(root==null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node X){
        Node Y = X.right;
        Node T2 = Y.left;

        // Perform rotation
        Y.left = X;
        X.right = T2;

        //Update heights
        X.height = 1 + Math.min( height( X.left), height( X.right));
        Y.height = 1 + Math.min( height( Y.left), height( Y.right));

        return Y;
    }

    public static Node rightRotate(Node Y){
        Node X = Y.left;
        Node T2 = X.right;

        // Perform rotation
        X.right = Y;
        Y.left = T2;

        //Update heights
        Y.height = 1 + Math.min( height( Y.left), height( Y.right));
        X.height = 1 + Math.min( height( X.left), height( X.right));

        return X;
    }

    public static Node insert( Node root, int key){

        if(root==null){
            return new Node(key);
        }
        else if( key < root.data ){
            root.left = insert(root.left, key);
        }
        else if( root.data < key){
            root.right = insert(root.right, key);
        }
        else{
            return root;
        }

        //calculate height ( if rotation is occurs then this height is changed)
        root.height = 1 + Math.max( height(root.left), height(root.right) ) ;

        //Get root's balance factor
        int bf = balanceFactor(root);

        // Left Left Case
        if( 1 < bf && key < root.left.data){
            return rightRotate(root);
        }

        // Right Right Case
        if( bf < -1 && root.right.data < key){
            return leftRotate(root);
        }

        // Left Right Case
        if( 1< bf && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if( bf < -1 && root.right.data > key){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;  //return if AVL Balanced
    }


     public static void levelOrderTraversal(Node root){
            if(root==null){
                return;
            }

            Queue<Node> que = new LinkedList<>();
            System.out.println();
            que.add(root);
            que.add(null);

            while(!que.isEmpty()){
                Node currNode = que.remove();

                if(currNode==null){
                    if(que.isEmpty()){
                        break;
                    }
                    else{
                        System.out.println();
                        que.add(null);
                    }
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        que.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        que.add(currNode.right);
                    }
                }
            }

            
        }



    


    public static void main(String[] args) {

        root = insert(root, 10);
        root = insert(root, 20);        
        root = insert(root, 30);        
        root = insert(root, 40);        
        root = insert(root, 50);        
        root = insert(root, 25);

        levelOrderTraversal(root);

        
        

      
        
    }
}
