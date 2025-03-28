package BinaryTrees;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BinaryTreesPart1B {
    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    

        public static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if( idx >= nodes.length || nodes[idx]==-1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorderTraversal(Node root){
            if(root==null){
                // System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+ " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }

        public static void inOrder(Node root){
            if(root==null){
                System.out.print(-1 + " ");
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return;
            }

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
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

        public static int heightOfTree(Node root){
            if(root==null){ 
                return 0;       //0 height
            }

            return Math.max( heightOfTree(root.left), heightOfTree(root.right) ) + 1;
        }

        public static int countTotalNodes(Node root){
            if(root==null){
                return 0;
            }

            return countTotalNodes(root.left) + countTotalNodes(root.right) + 1;
        }

        public static int sumOfNodes(Node root){
            if(root==null){
                return 0;
            }

            return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
        }

        public static int DiameterOFATree(Node root){

            if(root==null){
                return 0;
            }

            int leftDiameter = DiameterOFATree(root.left);
            int rightDiameter = DiameterOFATree(root.right);
            
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            return Math.max(leftHeight+rightHeight+1, Math.max(leftDiameter, rightDiameter) );

        }

        public static boolean checkIfTreeAndSubtreeAreIdentical( Node root, Node subRoot ){
            if(root==null && subRoot==null){
                return true;
            }

            if(root==null && subRoot!=null){
                return false;
            }
            if(root!=null && subRoot==null){
                return false;
            }
            if(root.data!=subRoot.data){
                return false;
            }


            if(!checkIfTreeAndSubtreeAreIdentical(root.left, subRoot.left )){
                return false;
            } 
        
            if(!checkIfTreeAndSubtreeAreIdentical(root.right, subRoot.right )){
                return false;
            } 

            return true;

          
        }


        public static boolean isTreeAndSubtreeAreIdentical( Node root, Node subRoot ){
            
            if(root==null){
                return false;
            }

            if(root.data==subRoot.data){
                if(checkIfTreeAndSubtreeAreIdentical(root, subRoot)){
                    return true;
                }
                
            }

            return isTreeAndSubtreeAreIdentical(root.left, subRoot) || isTreeAndSubtreeAreIdentical(root.right, subRoot);
        }


    public static class Info{
        int diameter;
        int height;

        public Info(int diameter, int height){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static Info DiameterOFATreeOptimized(Node root){
        if(root==null){
            return new Info(0, 0);
        }

        Info leftInfo = DiameterOFATreeOptimized(root.left);
        Info rightInfo = DiameterOFATreeOptimized(root.right);


        int diameter= Math.max( leftInfo.height+rightInfo.height+1, Math.max( leftInfo.diameter, rightInfo.diameter));
        int height= Math.max( leftInfo.height, rightInfo.height) +1;

        return new Info(diameter, height);

    }

    public static class Info2{
        int hzd;            //horizontal
        Node node;         

        public Info2(Node node, int hzd){
            this.hzd = hzd;
            this.node = node;
        }
    }

    public static void topView(Node root){

        Queue<Info2> que = new LinkedList<>();

        HashMap<Integer,Node> hMap = new HashMap<>();

        que.add(new Info2(root, 0));
        que.add(null);
        int max=0, min=0;


        while(!que.isEmpty()){

            Info2 curr = que.remove(); 
            
            if(curr==null){
                if(que.isEmpty()){
                    break;
                }
                else{
                    que.add(null);
                }
            }
            else{

                //first time the horizontal distance is occurring
                if(!hMap.containsKey(curr.hzd)){
                    hMap.put(curr.hzd, curr.node);
                }

                if(curr.node.left!=null){
                    que.add(new Info2(curr.node.left, curr.hzd-1));
                    min = Math.min(min, curr.hzd-1);
                    
                }

                if(curr.node.right!=null){
                    que.add(new Info2(curr.node.right, curr.hzd+1));
                    max = Math.max(max, curr.hzd+1);
                }
            }
        }


        //print top view 
        for(int i=min; i<=max; i++){
            System.out.print(hMap.get(i).data+" ");
        }


    }

    public static void kthLevelOfATreeWithQueueIteration(Node root, int k){

        if(root==null){
            return;
        }

        Queue<Node> que = new LinkedList<>();

        que.add(root);
        que.add(null);

        int count=0;

        while(!que.isEmpty() && count!=k){

            Node curr = que.remove();

            if(curr==null){
                if(que.isEmpty()){
                    break;
                }
                else{
                    if(count==k-1){
                        System.out.println();
                    }
                    
                    count++;
                    que.add(null);
                }
            }
            else{
                if(count==k-1){
                    System.out.print(curr.data+" ");
                }
                
                if(curr.left!=null){
                    que.add(curr.left);
                }
                if(curr.right!=null){
                    que.add(curr.right);
                }
            }
        }
    }

    public static void kthLevelOfATreeWithRecursion(Node root, int level, int k){

        if(root==null){
            return;
        }

        if(k==level){
            System.out.print(root.data+" ");
            return;
        }

        kthLevelOfATreeWithRecursion(root.left, level+1, k);
        kthLevelOfATreeWithRecursion(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path ){

        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data==n){
            return true;
        }

        if( getPath(root.left, n, path) || getPath(root.right, n, path)){
            return true;
        }

        path.remove(root);

        return false;
        
    }
    public static int lowestCommonAncestor1(Node root, int n1, int n2){ 

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i).data!=path2.get(i).data){
                break;
            }
        }

        return path1.get(i-1).data;
    }

    public static Node lowestCommonAncestor2(Node root, int n1, int n2){

        //when n1 or n1 at start of node or data in any node in the tree
        if( root==null || root.data==n1 || root.data==n2){
            return root;
        }

        Node leftNode = lowestCommonAncestor2(root.left, n1, n2);
        Node rightNode = lowestCommonAncestor2(root.right, n1, n2);

        if(leftNode==null){
            return rightNode;
        }

        if(rightNode==null){
            return leftNode;
        }

        //if current root is the common ancestor
        return root;
    }

    public static int nodeDistanceFromlca(Node root, int n){

        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }

        int leftDist = nodeDistanceFromlca( root.left, n);
        int rightdist = nodeDistanceFromlca(root.right, n);

        if( leftDist==-1 && rightdist==-1){
            return -1;
        }
        else if(leftDist==-1){
            return rightdist + 1;
        }
        else{
            return leftDist + 1;
        }


    }

    public static int minDistanceBetweenNodes(Node root, int n1, int n2){

        Node lca = lowestCommonAncestor2(root, n1, n2);

        int n1Distance = nodeDistanceFromlca(lca, n1);
        int n2Distance = nodeDistanceFromlca(lca, n2);

        return ( n1Distance + n2Distance );


    }

    public static int KthAncestorOfNode(Node root, int k, int n){

        if(root==null){
            return -1;
        }

        if(root.data==n){
            return 0;
        }

        int leftDis = KthAncestorOfNode( root.left, k, n);
        int rightDis = KthAncestorOfNode( root.right, k, n);
    
        if(leftDis==-1 && rightDis==-1){
            return -1;
        }

        int max = Math.max(leftDis, rightDis);
     
        if(max+1==k){
            System.out.println("the kth ancestor is "+root.data);
        }

        return max +1;

    }

    public static int transformOfSumTree(Node root){
        if(root==null){
            return 0;
        }

        int BothSumData = transformOfSumTree(root.left) + transformOfSumTree(root.right) + root.data;
        root.data = BothSumData - root.data;       //store sum of left and right sum

        return BothSumData;                        //return left , right and root sum


    }
    
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------
    //------------------------------------------------------------------------
    
    /*Leetcode Questions Starting:- */

        /*(1). Binary Tree Right Side View */

        public static void binaryTreeRightSideView(Node root){

            Queue<Node> que = new LinkedList<>();
            List<Integer> li = new ArrayList<>();
            que.add(root);
            

            while(!que.isEmpty()){

                
                int size = que.size();

                Node curr=null;

                while(size!=0){
                    
                    if(que.size()>0){
                        curr = que.remove();

                        if(curr==null){

                        }
                        else{
                            if(curr.left!=null){
                                que.add(curr.left);
                            }
    
                            if(curr.right!=null){
                                que.add(curr.right);
                            }
                        }   

                    }
                    
                    size--;
            }

                    if(curr!=null){
                        li.add(curr.data);
                    }
                    
                

            }

            // System.out.println(li);
                

            }

        /*(2). deleteNodeAndReturnForest */
        public static Node deleteNAndReturnF( Node root, List<Integer> to_delete, List<Node> forest){

            if(root==null){
                return null;
            }

            root.left = deleteNAndReturnF(root.left, to_delete, forest);
            root.right = deleteNAndReturnF(root.right, to_delete, forest);

            if(to_delete.contains(root.data)){

                if(root.left!=null){
                    forest.add(root.left);
                    root.left = null;
                }

                if(root.right!=null){
                    forest.add(root.right);
                    root.right = null;
                }

                return null;
    
            }

            return root;

            // if(!to_delete.contains(root.data)){
            //     return root;
            // }

            // if(root.left!=null){
            //     forest.add(root.left);
            // }

            // if(root.right!=null){
            //     forest.add(root.right);
            // }

            // root.left = null;
            // root.right = null;
            // return null;



        }
        public static void deleteNodeAndReturnForest(Node root,List<Integer> to_delete ){

            List<Node> forest = new ArrayList<Node>();
            List<Integer> toDeleteList = new ArrayList<Integer>();

            for(int to_be_delete: to_delete){
                toDeleteList.add(to_be_delete);
            }

            Node newNode = deleteNAndReturnF( root, toDeleteList, forest);

            //if root data is in list of deleted elements then, function return null for root
            if(newNode!=null){
                forest.add(newNode);
            }
            

            for(int i=0; i<forest.size(); i++){
                System.out.println(forest.get(i).data);
            }

            
        }
        
        /*(3). Check Completeness of a Binary Tree*/

        /*first approach with BFS */
        public static boolean checkCompletenessOFBinaryTree1( Node root){

            if(root==null){
                return true;
            }


            boolean past = false;
            Queue<Node> que = new LinkedList<>();
            que.add(root);
            
            while(!que.isEmpty()){

                Node newNode = que.remove();

                if(newNode==null){
                    past = true;
                }
                else{

                    if(past==true){
                        return false;
                    }

                    que.add(newNode.left);
                    que.add(newNode.right);

                }
            }


            return true;
        }
          
        /*second approach with DFS */

        public static int countTotalNodesForCheckCompletenessOFBinaryTree2(Node root){
            if(root==null){
                return 0;
            }

            return countTotalNodesForCheckCompletenessOFBinaryTree2(root.left) + countTotalNodesForCheckCompletenessOFBinaryTree2(root.right) + 1;
        }

        public static boolean conditionCheckCompletenessOFBinaryTree2(Node root, int totalNodes, int index){
            if(root==null){
                return true;
            }

            if(totalNodes < index){
                return false;
            }

            return conditionCheckCompletenessOFBinaryTree2(root.left, totalNodes, index*2) && conditionCheckCompletenessOFBinaryTree2(root.right, totalNodes, index*2+1);


        }

        public static boolean checkCompletenessOFBinaryTree2( Node root){

            int totalNodes = countTotalNodesForCheckCompletenessOFBinaryTree2(root);

            return conditionCheckCompletenessOFBinaryTree2( root, totalNodes, 1);

           
        }
        
        /*(4). Find Leaves of Binary Tree using DFS (Premium Question Not allowed in Leetcode)*/
        public static int findLeavesOfBinaryTree(Node root, HashMap<Integer, ArrayList<Integer>> hp){
            if(root==null){
                return 0;
            }

            int height = Math.max( findLeavesOfBinaryTree(root.left, hp), findLeavesOfBinaryTree(root.right, hp) ) + 1;

            //if key exist in hashmap

            if(!hp.containsKey(height)){
                hp.put(height, new ArrayList<>());
            }
            hp.get(height).add(root.data);

            return height;
        }

        /*(5). Binary Tree Pruning */
          
        //by using DFS
        public static Node binaryTreePruning(Node root){

            if(root==null){
                return null;
            }

            Node leftNode = binaryTreePruning(root.left);
            Node rightNode = binaryTreePruning(root.right);

            if( leftNode==null && rightNode==null && root.data==0){
                return null;
            }

            root.left = leftNode;
            root.right = rightNode;

            return root;

        }

        /*(6). Path Sum II*/
        
        //by using DFS
        public static Node pathSumII_TargetSum( Node root, int targetSum, int sum, List<List<Integer>> list, ArrayList<Integer> al ){

            
            if(root==null){
                return null;
            }
            
            
            al.add(root.data);

            pathSumII_TargetSum( root.left, targetSum, sum+root.data, list, al);
            pathSumII_TargetSum( root.right, targetSum, sum+root.data, list, al);

            if(root.left==null && root.right==null && (sum + root.data) == targetSum){        
                list.add( new ArrayList<>(al));
            }

            al.removeLast();

            return root;


            
        }

        public static List<List<Integer>> pathSumII( Node root, int targetSum){

            List<List<Integer>> list = new ArrayList<List<Integer>>();
            ArrayList<Integer> al = new ArrayList<>();

            pathSumII_TargetSum( root, targetSum, 0, list, al);

            return list;
        }

        /*(7). Path Sum */

        public static boolean pathSumCheck(Node root, int targetSum, int sum){

            if(root==null){
                return false;
            }

            if( pathSumCheck( root.left, targetSum, sum + root.data ) || pathSumCheck( root.right, targetSum, sum + root.data )){
                return true;
            }
            

            if( root.left==null && root.right==null && (root.data+sum)==targetSum){
                return true;
            }

            return false;

        } 
        
        public static boolean pathSum( Node root, int targetSum){

            return pathSumCheck(root, targetSum, 0);
            
        }
    
        /*(8). Add One Row to Tree */
        
        /*by using dfs */
        public static Node addOneRowToTreeMain(Node root, int val, int depth, int count){

            if(root==null){
                return null;
            }
        
            //when depth is grater than 1
            if(count+1 == depth){

                Node tempLeft = root.left;
                Node tempRight = root.right;

                root.left = new Node(val);
                root.right = new Node(val);

                root.left.left = tempLeft;
                root.right.right = tempRight;
                return root;

            }

            root.left = addOneRowToTreeMain(root.left, val, depth, count+1);
            root.right = addOneRowToTreeMain(root.right, val, depth, count+1);
            return root;

        }
        public static Node addOneRowToTree(Node root, int val, int depth){

            //case for root when depth is 1
            if(1==depth){
                Node newNode = new Node(val);
                newNode.left = root;
                newNode.right = null;
                return newNode;
            }

            Node newRoot = addOneRowToTreeMain(root, val, depth, 1);  
            return newRoot;

        }

        /*by using bfs*/
        public static Node addOneRowToTreeWithBFS(Node root, int val, int depth){

            //first case when depth is 1
            if(depth==1){
                Node newNode = new Node(val);
                newNode.left = root;
                newNode.right = null;
                return newNode;
            }

            int level = 1;
            Queue<Node> que = new LinkedList<>();
            que.add(root);
            que.add(null);

            while(!que.isEmpty()){

                Node currNode = que.remove();

                if(currNode==null){
                    if(que.isEmpty()){
                        break;
                    }
                    else{

                        if(level==depth-1){
                            break;
                        }
                        System.out.println();
                        level++;
                        que.add(null);
                    }
                }
                else{

                        if(level==depth-1){

                            Node leftNode = new Node(val);
                            Node rightNode = new Node(val);

                            leftNode.left = currNode.left;
                            rightNode.right = currNode.right;

                            currNode.left = leftNode;
                            currNode.right = rightNode;
                
                        }
                        else{

                            if(currNode.left!=null ){
                                que.add(currNode.left);
                            }
                            
                            if(currNode.right!=null){
                                que.add(currNode.right);
                            }
                        }
                }

            }

            return root;

        }


        /*(9).  Leaf-Similar Trees*/

        //by using dfs 

        public static void getAllLeafTreesForLeafSimilarTrees(Node root, ArrayList<Integer> arr){

            if(root==null){
                return;
            }

            if(root.left==null && root.right==null){
                arr.add( root.data);
            }

            getAllLeafTreesForLeafSimilarTrees(root.left, arr);
            getAllLeafTreesForLeafSimilarTrees(root.right, arr);

        }

        public static boolean leafSimilarTrees(Node root1, Node roo2){

            ArrayList<Integer> arr1 = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();

            getAllLeafTreesForLeafSimilarTrees( root1, arr1);
            getAllLeafTreesForLeafSimilarTrees( roo2, arr2);

            if(arr1.size()!=arr2.size()){
                return false;
            }

            for(int i=0; i<arr1.size(); i++){
               
                if(arr1.get(i)!=arr2.get(i)){
                    return false;
                }
            }

            return true;
        }


        /*(10). Maximum Difference Between Node and Ancestor*/

            //(i). by dfs (time:- O(n^2))

            static int maxDiffForNodeAndRoot;
            public static void findMaxDiff(Node root, Node child){
    
                if(root==null || child==null){
                    return;
                }
    
            
                maxDiffForNodeAndRoot = Math.max( maxDiffForNodeAndRoot, Math.abs(root.data-child.data) );
        
                findMaxDiff( root, child.left);
                findMaxDiff( root, child.right); 
    
            }
    
            public static void maxAncestorDiffRoots(Node root) {
    
                if(root==null){
                    return;
                }
        
                findMaxDiff(root, root.left);
                findMaxDiff(root, root.right);
                
                maxAncestorDiffRoots( root.left);
                maxAncestorDiffRoots( root.right);
    
            }
     
            public static int maxAncestorDiff(Node root) {
        
                maxDiffForNodeAndRoot = -1;
                maxAncestorDiffRoots(root);
        
                return maxDiffForNodeAndRoot;
        
            }

            //(ii). optimal approach  ( O(N) )
            
            public static int maxAncestorDiffRootsO(Node root, int maxV, int minV) {
        
                if(root==null){
                    return Math.abs(maxV-minV);
                }
        
                maxV = Math.max( maxV, root.data);
                minV = Math.min( minV, root.data);
        
                int leftMax = maxAncestorDiffRootsO( root.left, maxV, minV);
                int rightMax = maxAncestorDiffRootsO( root.right, maxV, minV);
        
                return Math.max( leftMax, rightMax);
        
            }
        
            public static int maxAncestorDiffO(Node root) {
        
                int maxDiff = maxAncestorDiffRootsO( root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
                return maxDiff;
        
            }
        
        /*(11). Maximum Product of Splitted Binary Tree */

            /* (i). not optimized  */
            public static int maxValFor_MPOS=0;
            public static int totalSumFor_MPOS=0;
            public static int totalSumOfNodes_MPOS(Node root){

                if(root==null){
                    return 0;
                }

                return totalSumOfNodes_MPOS(root.left) + totalSumOfNodes_MPOS(root.right) + root.data;
            }

            public static int findMaxProduct_MPOS(Node root){

                if(root==null){
                    return 0;
                }

                int leftSum = findMaxProduct_MPOS(root.left);
                int rightSum = findMaxProduct_MPOS(root.right);

                int leftSumOfSplittedTree = leftSum + rightSum + root.data;
                int rightSumOfSplittedTree = totalSumFor_MPOS - leftSumOfSplittedTree;

                System.out.println(leftSumOfSplittedTree*rightSumOfSplittedTree);
                maxValFor_MPOS = Math.max( maxValFor_MPOS, leftSumOfSplittedTree*rightSumOfSplittedTree);

                return leftSumOfSplittedTree;
            }

            public static int maxProduct_MPOS(Node root){

                totalSumFor_MPOS = totalSumOfNodes_MPOS(root);

                findMaxProduct_MPOS(root);

                return maxValFor_MPOS;

            }

            /* (ii). optimized  */

            public static int find_MPOS(Node root){

                if(root==null){
                    return 0;
                }

                int leftSum = find_MPOS(root.left);
                int rightSum = find_MPOS(root.right);

                int leftSumOfSplittedTree = leftSum + rightSum + root.data;
                int rightSumOfSplittedTree = totalSumFor_MPOS - leftSumOfSplittedTree;
 
                maxValFor_MPOS = Math.max( maxValFor_MPOS, leftSumOfSplittedTree*rightSumOfSplittedTree);

                return leftSumOfSplittedTree;
            }

            public static int maxProduct_MPOS_optimized(Node root){

                totalSumFor_MPOS = find_MPOS(root);

                find_MPOS(root);

                return maxValFor_MPOS;

            }

        /*(12). Binary Tree Maximum Path Sum*/

            /*(i). bfs*/
            static int maxSum_MPS = 0;
            public static int findMaxPathSum_MPS(Node root){

                if(root==null){
                    return 0;
                }

                int left = findMaxPathSum_MPS(root.left);
                int right = findMaxPathSum_MPS(root.right);

                //case:1- all three sum is max
                int nicha_hi_mil_gya_answer = left + right + root.data;

                //case:2- only one sum from left and root (or) right and root is max.
                int koi_ek_aacha = Math.max( left, right) + root.data;

                //case:3- only root is max
                int only_root_acha = root.data;

                maxSum_MPS = Math.max( nicha_hi_mil_gya_answer, Math.max( koi_ek_aacha, only_root_acha));



                //return sirf case2 or case3

                return Math.max( koi_ek_aacha, only_root_acha);

            }

            public static int maxPathSum_MPS(Node root){

                maxSum_MPS = 0;

                maxSum_MPS = findMaxPathSum_MPS(root);

                return maxSum_MPS;

            }

        /*(13). Is Same Tree */

        public boolean isSameTree(Node p, Node q) {
        
            if(p==null && q!=null){
                return false;
            }
    
            if(p!=null && q==null){
                return false;
            }
    
            if(q==null && p==null){
                return true;
            }
    
            if(p.data!=q.data){
                return false;
            }
    
            if( !isSameTree( p.left, q.left) || !isSameTree( p.right, q.right)){
                return false;
            }
    
            return true;
        }

        /*(14). find Duplicate Subtrees */

        public static String duplicateSubtrees( Node root, HashMap< String, Integer> hp, ArrayList<Node> roots){

            if(root==null){
                return "N";
            }

            String str = root.data + "," + duplicateSubtrees(root.left, hp, roots) + "," + duplicateSubtrees(root.right, hp, roots);

            if(hp.containsKey(str)){
                hp.put( str, hp.get(str) + 1);
            }
            else{
                hp.put(str, 1);
            }

            if(hp.get(str)==2){
                roots.add(root);
            }

            return str;

        }

        public static ArrayList<Node> findDuplicateSubtrees( Node root){

            HashMap<String,Integer> hp = new HashMap<>();
            ArrayList<Node> roots = new ArrayList<>();
        
            String str = duplicateSubtrees(root, hp, roots);
            
            return roots; 


        }

        /*(15). Symmetric Tree*/
        public static boolean check(Node leftNode, Node rightNode){

            if(leftNode==null && rightNode==null){
                return true;
            }
    
            
    
            if( (leftNode==null && rightNode!=null) || (leftNode!=null && rightNode==null) ){
                return false;
            }
            
            if(leftNode.data!=rightNode.data){
                return false;
            }
    
            if(!check( leftNode.left, rightNode.right)){
                return false;
            }
    
            if(!check( leftNode.right, rightNode.left)){
                return false;
            }
    
            return true;
        
        }
        public static boolean isSymmetric(Node root) {
    
            return check( root.left, root.right);
            
        }

        /*(16). Sum Root to Leaf Numbers */

            /*(i). Use string and array , but not a good way */
        
        public static void findSumNumbersSRTLN_1(Node root, String str, ArrayList<String> arr){

            if(root==null){
                return;
            }
           
            //add element to string 
            str += root.data;


            if(root.left==null && root.right==null){
                arr.add( str);
                return;
            }

            findSumNumbersSRTLN_1(root.left, str, arr);
            findSumNumbersSRTLN_1(root.right, str, arr);

        }

        public static int sumNumbersSRTLN_1(Node root){

            ArrayList<String> arr = new ArrayList<>();
            String tempStr = new String("");

            findSumNumbersSRTLN_1( root, tempStr, arr);

            int sum=0;

            while( arr.size() > 0){
                sum += Integer.parseInt( arr.remove(0)) ;
            }

            return sum;

        }


            /*(ii). good approach */
        
        public static int findSumNumbersSRTLN_2(Node root, int num){

            if(root==null){
                return 0;
            }

            
            if(root.left==null && root.right==null){
                return num*10 + root.data; 
            }

            int leftNum = findSumNumbersSRTLN_2( root.left, num*10 + root.data);
            int rightNum = findSumNumbersSRTLN_2( root.right, num*10 + root.data);

            return leftNum+rightNum;
            
            

        }

        public static int sumNumbersSRTLN_2(Node root){

            int sum = findSumNumbersSRTLN_2( root, 0);
            return sum;

        }

        /*(17). Construct Binary Tree from Preorder and Inorder Traversal */

        /* 

        public Node makeTree( int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){

            if( inStart > inEnd){
                return null;
            }
    
            //preorder end root
            Node newRoot = new Node( postorder[postEnd]);
      
            int i = inStart;
            for(; i<=inEnd; i++){
    
                if( inorder[i]==newRoot.data){
                    break;
                }
            }
    
            //find leftSize and rightSize from inOrder
            int leftSize = i-inStart;
            int rightSize = inEnd-i;
    
            newRoot.left = makeTree( inorder, postorder, inStart, i-1, postStart, postStart+leftSize-1);
            newRoot.right = makeTree( inorder, postorder, i+1, inEnd, postEnd-rightSize, postEnd-1);
    
            return newRoot;
    
        }

        public Node buildTree(int[] inorder, int[] postorder) {
    
            Node root = makeTree( inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
            return root;
        }

        */
       
        /*(18). Longest ZigZag Path in a Binary Tree */

        /*first Approach */
        int maxPathZigZag1=0; 
        public void mainZigZag1(Node root, int steps, boolean goLeft){

            if(root==null){
                return;
            }
    
            //find Max
            maxPathZigZag1 = Math.max( maxPathZigZag1, steps);
    
            if(goLeft==true){
                mainZigZag1( root.left, steps+1, false);
                mainZigZag1( root.right, 1, true);
            }
            else{
                mainZigZag1( root.right, steps+1, true);
                mainZigZag1( root.left, 1, false);
            }
        }

        public int longestZigZag1(Node root) {
            
            mainZigZag1( root, 0, true);
    
            return maxPathZigZag1;
        }


        /*second approach */

        int maxPathZigZag2=Integer.MIN_VALUE; 
        public void mainZigZag2(Node root, int leftMax, int rightMax){
            
            if(root==null){
                return;
            }
    
            //find Max
            maxPathZigZag2 = Math.max( maxPathZigZag2, Math.max( leftMax, rightMax) );
    
            mainZigZag2( root.left, rightMax+1, 0);
            mainZigZag2( root.right, 0, leftMax+1 );
    
        }
        
        public int longestZigZag2(Node root) {
            
            mainZigZag2( root, 0, 0);
    
            return maxPathZigZag2;
        }

        /*(19). Maximum Width of Binary Tree */

        //using bfs
        public static class MaxWidthOfBTClass{
            Node node;
            int idx;

            public MaxWidthOfBTClass( Node node, int idx){
                this.node = node;
                this.idx = idx;
            }
        }
        public static int maxWidthOfBT( Node root){

            if(root==null){
                return 0;
            }

            Deque<MaxWidthOfBTClass> que = new LinkedList<>();
            que.add( new MaxWidthOfBTClass( root, 0));
            int maxWidth=0;

            while(!que.isEmpty()){

                int n = que.size();
                MaxWidthOfBTClass l = que.getFirst();
                MaxWidthOfBTClass r = que.getLast();

                maxWidth = Math.max( maxWidth, r.idx-l.idx+1);


                while(n>0){

                    MaxWidthOfBTClass curr = que.removeFirst();

                    if(curr.node.left!=null){
                        que.add( new MaxWidthOfBTClass( curr.node.left, 2*curr.idx+1));
                    }

                    if(curr.node.right!=null){
                        que.add( new MaxWidthOfBTClass( curr.node.right, 2*curr.idx+2 ));
                    }

                    n--;
                }


            }

            return maxWidth;

        }

        /*(20). Maximum Level Sum of a Binary Tree */

        //using bfs
        public static int maximumLevelSumByBFS(Node root) {

            if(root==null){
                return 0;
            }

            Queue<Node> que = new LinkedList<>();
            que.add( root);

            int maxLevelSum=Integer.MIN_VALUE;
            int minLevel = 1;
            int level = 0;

            while(!que.isEmpty()){

                int n = que.size();
                //curr sum
                int currSum = 0;

                while(n>0){

                    Node curr = que.remove();
                    currSum += curr.data;
                    System.out.print(curr.data);
                    
                    

                    if(curr.left!=null){
                        que.add( curr.left);
                    }

                    if(curr.right!=null){
                        que.add( curr.right);
                    }

                    n--;
                }
                System.out.println();
               
                level++;

                if(currSum > maxLevelSum){
                    maxLevelSum = currSum;
                    minLevel = level;
                }
            

            }

            return minLevel;


        }

        //using dfs
        public static void maximumLevelSumByDFSCalc(Node root, HashMap<Integer,Integer> hm, int level){

            if(root==null){
                return ;
            }

            hm.put( level, hm.get(level)==null ? root.data : hm.get(level)+root.data);

            maximumLevelSumByDFSCalc( root.left, hm, level+1);
            maximumLevelSumByDFSCalc( root.right, hm, level+1);


        }
        
        public static int maximumLevelSumByDFS(Node root){

            if(root==null){
                return 0;
            }

            HashMap<Integer,Integer> hm = new HashMap<>();

            maximumLevelSumByDFSCalc( root, hm, 1);

            int maxLevelSum=Integer.MIN_VALUE;
            int minLevel = 1;

            for(int key: hm.keySet()){
                if(maxLevelSum < hm.get( key)){
                    minLevel = key;
                    maxLevelSum = hm.get( key);
                }
            }

            return minLevel;
        }

        /*(21). Minimum Depth of a Binary Tree */

        //using dfs
        /* 
        static int minimum_Depth_Of_BT = Integer.MAX_VALUE;
        public static void findMinimumDepthOfBT( Node root, int depth){
            
            if(root==null){
                return;
            }

            if(root.left==null && root.right==null){
                minimum_Depth_Of_BT = Math.min( minimum_Depth_Of_BT, depth);
            }

            findMinimumDepthOfBT( root.left, depth + 1 );
            findMinimumDepthOfBT( root.right, depth + 1 );

        }
        public static int minimumDepthOfBT(Node root){

            findMinimumDepthOfBT( root, 1);

            return minimum_Depth_Of_BT;
        }

        */

       

        /*(22). All Nodes Distance K in Binary Tree*/
        public static void parentAddToChildByInOrder( Node root, HashMap<Node,Node> childParent){

            if(root==null){
                return;
            }
            
            if(root.left!=null){
                childParent.put( root.left, root);
            }
            parentAddToChildByInOrder( root.left, childParent);

            if(root.right!=null){
                childParent.put( root.right, root);
            }
            parentAddToChildByInOrder( root.right, childParent);

        }

        public static void findAllNodesOfDistanceK( Node root, HashMap<Node,Node> childParent, List<Integer> result, Node target, int k){

            Queue<Node> que = new LinkedList<>();
            que.add(target);
            
            HashSet<Integer> visited = new HashSet<>();
            visited.add(target.data);
            int level = 0;

            while(!que.isEmpty()){
                
                int n = que.size();

                while(n>0){

                    Node curr = que.remove();

                    //left
                    if( curr.left!=null && !visited.contains(curr.left.data)){
                        que.add( curr.left);
                        visited.add( curr.left.data);
                        
                        if( level+1==k){
                            result.add( curr.left.data);
                        }
                    }

                    //right
                    if( curr.right!=null && !visited.contains(curr.right.data)){
                        que.add( curr.right);
                        visited.add( curr.right.data);
                        
                        if( level+1==k){
                            result.add( curr.right.data);
                        }
                    }

                    //parant
                    if( childParent.containsKey( curr) && !visited.contains( childParent.get(curr).data )){
                        que.add( childParent.get( curr));
                        visited.add( childParent.get( curr).data );
                        
                        if( level+1==k){
                            result.add( childParent.get(curr).data);
                        }
                    }

                    n--;
                }

                level++;

                //k nodes added
                if(level==k){
                    break;
                }
            }

            
        }

        public static List<Integer> allNodesOfDistanceK( Node root, Node target, int k){

            //it contains the child as key and parent as value( child-parent relationship)
            HashMap< Node, Node> childParent = new HashMap<>();

            parentAddToChildByInOrder( root, childParent);

            //it contains all k nodes
            List<Integer> result = new ArrayList<>();
            findAllNodesOfDistanceK( root, childParent, result, target, k );

            return result;

        }
        
        /*(23). Validate Binary Tree Nodes*/
        public static boolean validateBinaryTreeNodes( int n, int[] leftChild, int[] rightChild){

            HashMap<Integer, Integer> childParent = new HashMap<>(); 

            //(i).check every child only have one parent
            for(int i=0; i<n; i++){

                if( childParent.containsKey( leftChild[i]) || childParent.containsKey(rightChild[i])){
                    return false;
                }

                if( leftChild[i]!=-1 && !childParent.containsKey(leftChild[i]) ){
                    childParent.put( leftChild[i], i);
                }

                if( rightChild[i]!=-1 && !childParent.containsKey(rightChild[i]) ){
                    childParent.put( rightChild[i], i);
                }

            }

            //(ii).only one root and it has no parent
            int root=-1;
            for(int i=0; i<n; i++){

                //find root
                if(!childParent.containsKey(i)){

                    //check if other parent is present then return false ( means root = -1 is changed previously )
                    if(root!=-1){
                        return false;
                    }

                    root = i;
                }
            }

            //(iii). check if only one connected tree is present
            
            //use bfs 

            Queue<Integer> que = new LinkedList<>();
            que.add( root);
            int count=0;

            while(!que.isEmpty()){

                int size = que.size();

                while( size>0){

                    int curr = que.remove();
                    count++;

                    for(int key: childParent.keySet()){

                        if(childParent.get(key)==curr){
                            que.add( key);
                        }
                    }
                    
                    size--;
                }

            }

            //after bfs check if count is equal to n, otherwise it means other component is present
            if(count!=n){
                return false;
            }

            return true;

        }

        /*(24). Find Largest Value in Each Tree Row*/

        //using bfs
        public static List<Integer> largestValueInEachTreeRow1(Node root){

            List<Integer> result = new ArrayList<>();
        
            if(root==null){
                return result;
            }

            Queue<Node> que = new LinkedList<>();
            que.add( root);

            while(!que.isEmpty()){

                int n = que.size();
                int max = Integer.MIN_VALUE;

                while( n>0){

                    Node curr = que.remove();

                    if(curr.left!=null){
                        que.add( curr.left);
                    }

                    if(curr.right!=null){
                        que.add( curr.right);
                    }

                    max = Math.max( max, curr.data);
                    
                    n--;
                }

                result.add( max);
            }

            return result;

        }

        //using dfs
        public static void findLargestValueInEachTreeRow2(Node root, HashMap<Integer,Integer> hm, int level){

            if(root==null){
                return;
            }

            if( hm.get( level)==null){
                hm.put( level, root.data);
            }
            else if( hm.get( level) < root.data){
                hm.put( level, root.data);
            }

            findLargestValueInEachTreeRow2( root.left, hm, level+1);
            findLargestValueInEachTreeRow2( root.right, hm, level+1);
        
        }

        public static List<Integer> largestValueInEachTreeRow2(Node root){

            List<Integer> result = new ArrayList<>();

            if(root==null){
                return result;
            }
            HashMap<Integer,Integer> hm = new HashMap<>();
            findLargestValueInEachTreeRow2( root, hm, 1);

            for(int key: hm.keySet()){
                result.add( hm.get( key));
            }

            return result;


        }

        /*(25). Count Nodes Equal to Average of Subtree */

        //using dfs
        public static int countTotalNodesEqualToAVG_O_S = 0;
        static class CTNETAOS{
            int count;
            int totalSum;

            CTNETAOS( int count, int totalSum){
                this.count = count;
                this.totalSum = totalSum;
            }
        }
        public static CTNETAOS calculateCountTotalNodesEqualToAverageOfSubtree(Node root){

            if(root==null){
                return new CTNETAOS( 0, 0);
            }

            CTNETAOS leftNode = calculateCountTotalNodesEqualToAverageOfSubtree( root.left);
            CTNETAOS rightNode = calculateCountTotalNodesEqualToAverageOfSubtree( root.right);

            int totalCount = leftNode.count + rightNode.count + 1;
            int totalSum = leftNode.totalSum + rightNode.totalSum + root.data;

            if( totalSum/totalCount == root.data){
                countTotalNodesEqualToAVG_O_S +=1;
            }

            return new CTNETAOS( totalCount, totalSum);


            
        }
        public static int countTotalNodesEqualToAverageOfSubtree(Node root){

            if(root==null){
                return 1;
            }
            if(root.left==null || root.right==null){
                return 1;
            }

            CTNETAOS rootNode = calculateCountTotalNodesEqualToAverageOfSubtree( root);

            return countTotalNodesEqualToAVG_O_S;


        }


        /*(26). Amount of Time for Binary Tree to Be Infected */


        //using bfs
        public static void addParentForAOTFBTTBI( Node root, HashMap<Node,Node> childParent ){

            if(root==null){
                return;
            }

            if( root.left!=null){
                childParent.put( root.left, root);
            }

            addParentForAOTFBTTBI( root.left, childParent); 

            if( root.right!=null){
                childParent.put( root.right, root);
            }

            addParentForAOTFBTTBI( root.right, childParent);

        }
        public static Node findTargetNodeForAOTFBTTBI(Node root, int targetValue){
            
            if(root==null){
                return null;
            }

            if(root.data==targetValue){
                return root;
            }

            Node findFromLeft = findTargetNodeForAOTFBTTBI( root.left, targetValue);
            Node findFromRight = findTargetNodeForAOTFBTTBI( root.right, targetValue);

            if( findFromLeft !=null ){
                return findFromLeft;
            }

            
            return findFromRight;


        }
        public static int findAmountOfTimeForBinaryTreeToBeInfected( Node root, HashMap<Node,Node> childParent, Node targetNode){

            if(root==null){
                return 0;
            }

            Queue<Node> que = new LinkedList<>();
            que.add( targetNode);

            HashSet<Integer> visited = new HashSet<>();
            visited.add( targetNode.data);

            int amountOfTime = 0;

            while(!que.isEmpty()){

                int n = que.size();

                while( n>0){

                    Node curr = que.remove();

                    if(curr.left!=null && !visited.contains( curr.left.data)){
                        que.add( curr.left);
                        visited.add( curr.left.data);
                    }

                    if( curr.right!=null && !visited.contains( curr.right.data)){
                        que.add( curr.right);
                        visited.add( curr.right.data);
                    }

                    if( childParent.containsKey(curr) && !visited.contains( childParent.get( curr).data) ){
                        que.add( childParent.get( curr));
                        visited.add( childParent.get( curr).data);
                    }

                    
                    n--;
                    
                    

                }
                
                amountOfTime++;
                
            }



            return amountOfTime-1;

        }
        public static int amountOfTimeForBinaryTreeToBeInfected( Node root, int start){

            HashMap<Node,Node> childParent = new HashMap<>();

            //add parent for the child in hashmap
            addParentForAOTFBTTBI( root, childParent);

            //i have to find the target Node , cause i have target in as int, but queue contains nodes , so i find it
            Node targetNode = findTargetNodeForAOTFBTTBI( root, start);

            if(targetNode==null){
                return 0;
            }


            int totalTimeForBTToBeInfected = findAmountOfTimeForBinaryTreeToBeInfected( root, childParent, targetNode);

            return totalTimeForBTToBeInfected;
        }




    public static void main(String[] args) {
        // int nodes[] = { 1, 2, 4, -1, -1, 5 , -1, -1, 3, -1, 6, -1, -1 };
        // int nodes[] = { 1, 2, 4, -1, -1, 5 , -1, -1, 3, 6, -1, -1, -1 };
        // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1};
        // int nodes[] = { 1, 2, 4, -1, -1, 5 , -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        // int nodes[] = { 1, 2, 4, -1, -1, 5 , -1, -1, 3, -1, 6, -1, -1 };
        // int nodes[] = { 1, 2, 4, -1, -1, 5 , -1, -1, 3, -1, -1 };
        // int nodes[] = { 1, 1, 1, 0, -1, -1, -1, 1, -1, -1, 0, 0, -1, -1, 1, -1, -1 };
        // int nodes[] = { 1, -1, 2, 3, -1, -1, 4, 5, -1, -1, 6, -1, -1 };
        // int nodes[] = { 1, 2, 4, -1, -1, -1, 3, 2, 4, -1, -1, -1, 4, -1, -1};
        // int nodes[] = { 1, 2, 3, 4, -1, -1, -1, -1, 2, 4, 3, -1, -1, -1, -1};
        // int nodes[] = { 4, 9, 5, -1, -1, 1, -1, -1, 0, -1, -1 };
        // int nodes[] = { 3, 9, -1, -1, 20, 15, -1, -1, 7, -1, -1 };
        // int nodes[] = { 3, 5, 6, -1, -1, 2, 7, -1, -1, 4, -1, -1, 1, 0, -1, -1, 8, -1, -1};
        // int nodes[] = { 1, 3, 5, -1, -1, 3, -1, -1, 2, -1, 9, -1, -1};
        // int nodes[] = { 4, 8, 0, -1, -1, 1, -1, -1, 5, -1, 6, -1, -1};
        int nodes[] = { 1, 5, -1, 4, 9, -1, -1, 2, -1, -1 , 3, 10, -1, -1, 6, -1, -1};


        idx = -1;
        //create tree
        Node root = buildTree(nodes);

        /*(1). pre order */
        // preorderTraversal(root);
        // System.out.println();

        /*(2). in order  */
        // inOrder(root);
        // System.out.println();

        /*(3). post order  */
        // postOrder(root);

        /*(4). level Order Traversal */
        // int height = heightOfTree(root);
        // System.out.println(height);

        /*(5). count total no. of nodes */
        // int totalNodes = countTotalNodes(root);
        // System.out.println(totalNodes);

        /*(6). sum of nodes */
        // int sumOfNodes = sumOfNodes(root);
        // System.out.println(sumOfNodes);

        /*(7). Diameter of a Tree:- No. of nodes in the longest path between 2 leaves */
            
        /* 
            // first: O(n2) 
            int DiameterOFATree = DiameterOFATree(root);
            System.out.println(DiameterOFATree);

            // optimized: O(n) 
            Info info = DiameterOFATreeOptimized(root);
            System.out.println(info.diameter+"   "+info.height);
        */
        

        /*(8). if tree and subtree both are identical or not */
        
            /* 
            // create tree
            Node root1 = new Node(1);
            root1.left = new Node(2);
            root1.right = new Node(3);
            root1.left.left = new Node(4);
            root1.left.right = new Node(5);
            root1.right.left = new Node(6);
            root1.right.right = new Node(7);

            // create subtree
            Node subRoot = new Node(2);
            subRoot.left = new Node(4);
            subRoot.right = new Node(5);
       
            System.out.println( isTreeAndSubtreeAreIdentical(root1, subRoot));
            */

        
        /*(9). print the top view of the tree */

        /* 
            Node root1 = new Node(1);
            root1.left = new Node(2);
            root1.right = new Node(3);
            root1.left.left = new Node(4);
            root1.left.right = new Node(5);
            root1.right.left = new Node(6);
            root1.right.right = new Node(7);
            topView(root1);

        */


        /*(10).  Kth level of a tree*/

        /*first approach with iteration*/
        /* 
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        kthLevelOfATreeWithQueueIteration(root1, 3);
        */

        /*second approach with recursion*/
        /* 
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        kthLevelOfATreeWithRecursion(root1, 1, 3);
        */


        /*(11). lowest common ancestor :-  */

        /*first approach:- time O(n) and space:- O(n)*/
        /* 
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println("lowest common ancestor "+lowestCommonAncestor1(root1, 4, 5));
        */

        /*second approach:- time O(n)*/
        /* 
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println("lowest common ancestor "+lowestCommonAncestor1(root1, 4, 5));

        */


        /*(12). min Distance between nodes:-  */

        /* 
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println("min distance between nodes "+minDistanceBetweenNodes(root1, 4, 6));

        */
        
        /*(13). Kth Ancestor of Node :-  */

        /* 
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        KthAncestorOfNode(root1,1,4);

        */


        /*(14). :-  Transform of Sum Tree*/

        /* 

        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        root1.right.right.right = new Node(10);


        transformOfSumTree(root1);

        tree.preorderTraversal(root1);
        */

        //------------------------------------------------------------------------
        //------------------------------------------------------------------------
        //------------------------------------------------------------------------
        //------------------------------------------------------------------------
        //------------------------------------------------------------------------

        /*Leetcode Questions Starting:- */

        /*(1). Binary Tree Right Side View */
        /*
        binaryTreeRightSideView(root);
        */

        /*(2).  delete Node And Return Forest*/
        /* 
        List<Integer> to_delete = new ArrayList<>();
        to_delete.add(3);
        to_delete.add(5);
        deleteNodeAndReturnForest(root, to_delete );
        */

        /*(3). Check Completeness of a Binary Tree*/

          /*first approach with BFS */
          /* System.out.println( checkCompletenessOFBinaryTree1(root)); */
          
          /*second approach with DFS */
          /* System.out.println( checkCompletenessOFBinaryTree2(root)); */
        

        /*(4). Find Leaves of Binary Tree using DFS (Premium Question Not allowed in Leetcode)*/
 
        /* 
        HashMap<Integer, ArrayList<Integer>> hp = new HashMap<>();
        findLeavesOfBinaryTree(root, hp);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<hp.size(); i++){
            arr.add( hp.get(i+1));
        }

        System.out.println(arr);
        */


        /*(5). Binary Tree Pruning */
        /* 
        preorderTraversal(root);
        System.out.println();
        binaryTreePruning(root);
        preorderTraversal(root);
        */

        /*(6). Path Sum II */

        /* 
        System.out.println(root);
        int targetSum = 22;
        System.out.println( pathSumII( root, targetSum));
        */

        /*(7). Path Sum */

         /* 
         System.out.println(root);
         int targetSum = 27;
         System.out.println( pathSum( root, targetSum));
         */
        
        /*(8). Add One Row to Tree */

        /* 
        //by using dfs 
        Node newRoot = addOneRowToTree(root, 1, 3);

        //by using bfs 
        addOneRowToTreeWithBFS(root, 1, 3);

        */

        /*(9). Leaf-Similar Trees */

        // leafSimilarTrees(root, root);

        /*(10). Maximum Difference Between Node and Ancestor*/

            /* (i). by dfs (time:- O(n^2))  */
            /* 
            System.out.println(maxAncestorDiff(root)); 
            */

            /* (ii). optimal approach  ( O(N) )  */
            /* 
            System.out.println(maxAncestorDiffO(root)); 
            */
        
        /*(11). Maximum Product of Splitted Binary Tree */

            /* (i). not optimized  */
            
            // System.out.println(maxProduct_MPOS(root));

            /* (ii). optimized */

            // System.out.println(maxProduct_MPOS_optimized(root));
    
        /*(12). Binary Tree Maximum Path Sum*/

            // System.out.println( maxPathSum_MPS(root));

        /*(13). Same Tree */

        /*(14). find Duplicate Subtrees */

        // System.out.println(findDuplicateSubtrees(root));

        /*(15). Symmetric Tree*/

        // System.out.println( isSymmetric(root));

        /*(16). Sum Root to Leaf Numbers */
        
          //(i). Use string and array , but not a good way 
          // System.out.println( sumNumbersSRTLN_1(root));
 
          //(ii). good approach 
          // System.out.println( sumNumbersSRTLN_2(root));

        
        /*(17). Construct Binary Tree from Preorder and Inorder Traversal */

        /*(18). Construct Binary Tree from Preorder and Inorder Traversal */

        /*(19). Maximum Width of Binary Tree */

        //using bfs

        // System.out.println( maxWidthOfBT(root));

        /*(20). Maximum level Sum of a BT */

        //using bfs
        // System.err.println( maximumLevelSumByBFS(root));

        //using dfs
        // System.out.println( maximumLevelSumByDFS(root));


        /*(21). Minimum Depth of a Binary Tree */
        // System.out.println( minimumDepthOfBT( root));

        /*(22). All Nodes Distance K in Binary Tree*/
    
        /*(23). Validate Binary Tree Nodes*/
        /* 
            //testcase 1
            // int leftChild[] = {1, -1, 3, -1};
            // int rightChild[] =  { 2, -1, -1, -1};

            //testcase 2
            int leftChild[] = { 1, 0, 3, -1};
            int rightChild[] =  { -1, -1, -1, -1};
            System.out.println( validateBinaryTreeNodes( 4, leftChild, rightChild) ? "it is a binary tree" : "it is not a binary tree");
        */

        /*(24). Find Largest Value in Each Tree Row*/
        
            //using bfs
            // System.out.println( largestValueInEachTreeRow1( root));

            //using dfs
            // System.out.println( largestValueInEachTreeRow2( root));

        /*(25). Count Nodes Equal to Average of Subtree */

        // System.out.println( countTotalNodesEqualToAverageOfSubtree( root));

        /*(26). Amount of Time for Binary Tree to Be Infected */

        System.out.println( amountOfTimeForBinaryTreeToBeInfected( root, 3));


    }
}
