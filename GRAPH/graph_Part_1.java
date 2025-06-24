package GRAPH;

import java.util.*;

import GRAPH.graph_Part_1.CCWMC;
import GRAPH.graph_Part_1.CheapestFWKS;
import GRAPH.graph_Part_1.Edge;
import GRAPH.graph_Part_1.KruskalA;
import GRAPH.graph_Part_1.PairDijA;
import GRAPH.graph_Part_1.PairPrimA;

public class graph_Part_1 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge( int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // DFS
    public static void traversalDFS( ArrayList<ArrayList<Edge>> al, HashSet<Integer> visited, int curr ){
        
        if(!visited.contains(curr)){
            visited.add( curr);
            System.out.print(curr+" ");

            for(int i=0; i<al.get(curr).size(); i++){
                traversalDFS( al, visited, al.get( curr).get(i).dest);
            }
        }
    }



    // Has Path exists
    public static boolean hasPathExistsUsingDFS( ArrayList<ArrayList<Edge>> al, HashSet<Integer> visited, int target, int curr){

        if(target==curr){
            return true;
        }

        if(!visited.contains(curr)){
            
            visited.add(curr);
            for(int i=0; i<al.get(curr).size(); i++){
                boolean isPathExists = hasPathExistsUsingDFS( al, visited, target, al.get(curr).get(i).dest);
                if(isPathExists){
                    return true;
                }
            }

        }

        return false;
    }


    // Traverse Disjoint Graph 
    public static void traverseDisjointGraphUsingDFS( ArrayList<ArrayList<Edge>> al, HashSet<Integer> visited){

        for(int i=0; i<al.size(); i++){
            if(!visited.contains(i)){
                traversalDFS( al, visited, i);
            }
        }
    }


    // Cycle Detection in Undirected graph  
    public static boolean cycleDetectionInUndirectedGraphUtils( ArrayList<ArrayList<Edge>> al, HashSet<Integer> visited, int curr, int parent){

            visited.add( curr);
            for(int i=0; i<al.get(curr).size(); i++){

                //when their is no parent at start 
                if(parent==-1){
                    boolean isCycleExist = cycleDetectionInUndirectedGraphUtils( al, visited, al.get(curr).get(i).dest, curr);
                    if(isCycleExist==true){
                        return true;
                    }
                }
                //when neightbour is visited and it is not your parent 
                else if( al.get(curr).get(i).dest!=parent && visited.contains( al.get(curr).get(i).dest)){
                    return true;
                }
                //when neighbour is not visited and it is not your parent
                else if(  al.get(curr).get(i).dest!=parent && !visited.contains( al.get(curr).get(i).dest)){
                    boolean isCycleExist = cycleDetectionInUndirectedGraphUtils( al, visited, al.get(curr).get(i).dest, curr);
                    if(isCycleExist==true){
                        return true;
                    }
                }
                //when neighbour is visited and it is your parent
                else{

                }
            }

            return false;
        
    }
    public static boolean cycleDetectionInUndirectedGraph( ArrayList<ArrayList<Edge>> al, HashSet<Integer> visited){

        for(int i=0; i<al.size(); i++){
            if(!visited.contains(i)){
                visited.add(i);
                boolean isCycleExist = cycleDetectionInUndirectedGraphUtils( al, visited, i, -1);
                if(isCycleExist==true){
                    return true;
                }
            }
        }

        return false;
    }



    // ( check for bipartitegraph) two colors approach using BFS with time:-  O(V+E) 
    public static boolean checkIsBipartiteGraphUtils( ArrayList<ArrayList<Edge>> graph, int[] colorList, int curr){

        //0 means red color
        //1 means blue color
        //-1 means no color

        Queue<Integer> que = new LinkedList<>();

        que.add(curr);
        colorList[curr] = 0; 

        while(!que.isEmpty()){
            int currVal = que.remove();

            for(int i=0; i<graph.get(currVal).size(); i++){
                int neightbour = graph.get( currVal).get(i).dest;

                //if their is no color set to neighbours then set toggle color
                if( colorList[neightbour]==-1){
                    colorList[neightbour] = colorList[currVal]==1 ? 0 : 1;
                    que.add( neightbour);
                }
                //if neighbour color is same then return false
                else if( colorList[neightbour]==colorList[currVal]){
                    return false;
                }
                //if neighbour color is different then do nothing
                else{

                }
            }
        }

        return true;
        

    }
    public static boolean checkIsBipartiteGraph( ArrayList<ArrayList<Edge>> graph ){
        

        int colorList[] = new int[graph.size()];

        Arrays.fill( colorList, -1);
        

        for(int i=0; i< graph.size(); i++){
            if(colorList[i]==-1){
                if(!checkIsBipartiteGraphUtils(graph, colorList, i)){
                    return false;
                }
            }
        }
        
        return true;
    }

    

    // public static boolean checkBIPGU( ArrayList<ArrayList<Edge>> graph, int[] colorList, int curr){

    //     for(int i=0; i<colorList.length; i++){
            
    //     }
    // }
    // public static boolean checkBIPG( ArrayList<ArrayList<Edge>> graph ){

    //     int colorList[] = new int[graph.size()];
    //     Arrays.fill( colorList, -1);

    //     for(int i=0; i<graph.size(); i++){

    //         if(colorList[i]==-1){         
    //             checkBIPGU( graph, colorList, i);
    //         }                       
    //     }
    // }

    

    // ( check for bipartitegraph) two colors approach using DFS with time:-  O(V+E) 
    public static boolean checkIsBipartiteGraphUtilsUsingDFS( ArrayList<ArrayList<Edge>> graph, int[] colorList, int curr, int color){

        colorList[curr] = color;

        for(int i=0; i<graph.get(curr).size(); i++){
            int neightbour = graph.get( curr).get(i).dest;

            //if their is no color set to neighbours then set toggle color
            if( colorList[neightbour]==-1){
                if(!checkIsBipartiteGraphUtilsUsingDFS( graph, colorList, neightbour, color==1 ? 0 : 1)){
                    return false;
                };
            }
            //if neighbour color is same then return false
            else if( colorList[neightbour]==color){
                return false;
            }
            //if neighbour color is different then do nothing
            else{

            }
        }

        return true;
        

    }
    public static boolean checkIsBipartiteGraphUsingDFS( ArrayList<ArrayList<Edge>> graph ){
        

        int colorList[] = new int[graph.size()];

        Arrays.fill( colorList, -1);
        //0 means red color
        //1 means blue color
        //-1 means no color

        for(int i=0; i< graph.size(); i++){
            if(colorList[i]==-1){
                if(!checkIsBipartiteGraphUtilsUsingDFS(graph, colorList, i, 1)){
                    return false;
                }
            }
        }
        
        return true;
    }



    // Cycle Detection in Directed graph
    public static boolean cycleDetectionInDirectedGraphUtils( ArrayList<ArrayList<Edge>> graph, HashSet<Integer> visited, boolean[] stack, int curr){

        visited.add(curr);

        for(int i=0; i<graph.get(curr).size(); i++){
            int neighbour = graph.get(curr).get(i).dest;
            
            // if current element neighbour exist in stack, means cycle exist
            if( stack[neighbour]==true){
                return true;
            }
            // if current element neighbour not visited yet
            else if(!visited.contains( neighbour)){

                stack[neighbour] = true;
                if( cycleDetectionInDirectedGraphUtils( graph, visited, stack, neighbour)){
                    return true;
                }
                stack[neighbour] = false;
            }
            else{

            }
        }

        return false;

    }
    public static boolean cycleDetectionInDirectedGraph( ArrayList<ArrayList<Edge>> graph){

        HashSet<Integer> visited = new HashSet<>();
        boolean[] stack = new boolean[graph.size()];

        for(int i=0; i<graph.size(); i++){

            if(!visited.contains(i)){
                stack[i] = true;
                if(cycleDetectionInDirectedGraphUtils( graph, visited, stack, i)){
                    return true;
                }
                stack[i] = false;
            }
        }

        return false;

    }



    // Topological Sorting using DFS
    public static void topologicalSortUtilsUsingDFS(ArrayList<ArrayList<Edge>> graph, HashSet<Integer> visited, int curr, Stack<Integer> stk){

        visited.add( curr);
        for(int i=0; i<graph.get(curr).size(); i++){
            int neighbour = graph.get(curr).get(i).dest;
            if(!visited.contains(neighbour)){
                topologicalSortUtilsUsingDFS( graph, visited, neighbour, stk);
            }
        }

        stk.push(curr);
        
    }
    public static ArrayList<Integer> topologicalSortUsingDFS(ArrayList<ArrayList<Edge>> graph){
        
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<graph.size(); i++){
            if(!visited.contains(i)){
                topologicalSortUtilsUsingDFS( graph, visited, i, stk);
            }
        }

   
        ArrayList<Integer> result = new ArrayList<>();

        while(!stk.isEmpty()){
            result.add( stk.pop());    
        }

        return result;

    }




    // Topological Sorting using BFS( using Kahn's Algorithm)
    // If You are unable to generate topological sort than it means that you have a cyclic directed graph, ( means if topological result is lesser than n means that it is a directed cyclic graph)
    public static ArrayList<Integer> topologicalSortUsingBFS(ArrayList<ArrayList<Edge>> graph){

        //count indegree for each vertex
        int inDegree[] = new int[graph.size()];
        
        for(int i=0; i<graph.size(); i++){
            for(int j=0; j<graph.get(i).size(); j++){
                inDegree[graph.get(i).get(j).dest]++;
            }
        }

     
        
        Queue<Integer> que = new LinkedList<>();
        //return result
        ArrayList<Integer> result = new ArrayList<>();

        //add 0 count indegree in the queue
        for(int i=0; i<inDegree.length; i++){
            if( inDegree[i]==0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
           
            int curr = que.remove();

            //now remove neighbours count by 1
            for(int i=0; i<graph.get(curr).size(); i++){
                int neighbour = graph.get(curr).get(i).dest;
                inDegree[neighbour]--;

                //add 0 count indegree in the queue
                if(inDegree[neighbour]==0){
                        que.add(neighbour);
                }
            }

            result.add(curr);

        }

        return result;



    }


    // All Paths from Source to Target in Directed Graph
    public static void allPathsFromSourceToDestination(ArrayList<ArrayList<Edge>> graph, ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> container, ArrayList<Integer> visited, int src, int dest){

        if(src==dest){
            paths.add(new ArrayList<>(container));
        }

        for(int i=0; i<graph.get(src).size(); i++){
            int neighbour = graph.get(src).get(i).dest;
                container.add(neighbour);
                allPathsFromSourceToDestination( graph, paths, container, visited, neighbour, dest);
                container.remove(container.size()-1);
        }
    }


    public static void allPath()


    /*dijkstra algorithm */
    public static class PairDijA implements Comparable<PairDijA>{
        int node;
        int path;

        PairDijA( int node, int path){
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(PairDijA p2){
            return this.path - p2.path;
        }

    }
    public static int[] dijkstraAlgoToFindTheShartestPath( ArrayList<ArrayList<Edge>> graph){

        //distances
        int dist[] = new int[graph.size()];

        //visited 
        ArrayList<Integer> visited = new ArrayList<>();

        //only 0 have 0 distance others are infinite values ( if question give the source , you have to add that source here and initialize with 0)
        for(int i=1; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<PairDijA> pq = new PriorityQueue<PairDijA>();
        pq.add( new PairDijA( graph.get(0).get(0).src, 0));

        while(!pq.isEmpty()){

            PairDijA curr = pq.remove();

            if(!visited.contains(curr.node)){

                    visited.add( curr.node);
    
                for(int i=0; i<graph.get(curr.node).size(); i++){
    
                    Edge nb = graph.get(curr.node).get(i);
    
                    //relaxation
                    if( dist[nb.src]+nb.wt < dist[nb.dest]){
                        dist[nb.dest] = dist[nb.src]+nb.wt;
                        pq.add( new PairDijA( nb.dest, dist[nb.dest]));
                    }
                }

            }

        }


        return dist;


    }



    /*bellman Ford algorithm */
    public static int[] bellmanFordAlgoToFindTheShartestPath(ArrayList<ArrayList<Edge>> graph){

        int dist[] = new int[graph.size()];

        //initialize others with infinite and source with 0
        for(int i=0; i<graph.size(); i++){
            if(0!=i){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //iterate to V-1
        for(int i=0; i<graph.size()-1; i++){

            //all edges 
            for(int j=0; j<graph.size(); j++){
                for(int k=0; k<graph.get(j).size(); k++){

                    Edge curr = graph.get(j).get(k);

                    //relaxation
                    if( dist[curr.src] + curr.wt < dist[curr.dest]){
                        dist[curr.dest] = dist[curr.src] + curr.wt;
                    }
                }
            }
        }

        return dist;


    }



    /*prim's algorithm */
    public static class PairPrimA implements Comparable<PairPrimA>{
        
        int node;
        int cost;
        
        PairPrimA( int node, int cost){
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(PairPrimA pair2){
            return this.cost - pair2.cost;
        }
    }
    public static int primAlgoToFindMinimumSpanningTree( ArrayList<ArrayList<Edge>> graph){

        int minCost = 0;
        ArrayList<Integer> visited = new ArrayList<>();
        
        PriorityQueue<PairPrimA> pq = new PriorityQueue<>();
        pq.add( new PairPrimA( 0, 0)); //at start


        while(!pq.isEmpty()){
            
            PairPrimA curr = pq.remove();
            
            if(!visited.contains(curr.node)){

                minCost += curr.cost;
                visited.add( curr.node);

                for(int i=0; i<graph.get(curr.node).size(); i++){

                    pq.add( new PairPrimA( graph.get(curr.node).get(i).dest, graph.get(curr.node).get(i).wt));

                }
            }


        }

        return minCost;

        

    }




    /*Cheapest Flights Within K Stops */
    public static class CheapestFWKS implements Comparable<CheapestFWKS>{
        int vertex;
        int cost;
        int stops;

        CheapestFWKS( int vertex, int cost, int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int compareTo(CheapestFWKS pair2){
            return this.stops-pair2.stops;
        }

    }
    public static int cheapestFlightsWithinKStops( ArrayList<ArrayList<Edge>> graph, int stops, int src, int dest){


        int dist[] = new int[graph.size()];

        for(int i=0; i<graph.size();i++){
            if( src!=i){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // PriorityQueue<CheapestFWKS> pq = new PriorityQueue<>();
        Queue<CheapestFWKS> pq = new LinkedList<>();
        pq.add( new CheapestFWKS( src, 0, 0 ));
        int stopsCount=0;

        while(!pq.isEmpty()){

            CheapestFWKS curr = pq.remove();

            if( curr.stops > stops+1){
                break;
            }
            
            for(int i=0; i<graph.get(curr.vertex).size(); i++){
    
                Edge nb = graph.get(curr.vertex).get(i);

                // Relaxation: Update the distance if a shorter path is found
                if( curr.cost + nb.wt < dist[nb.dest] && curr.stops<=stops){
                    dist[nb.dest] = curr.cost + nb.wt;
                    pq.add( new CheapestFWKS( nb.dest, dist[nb.dest], curr.stops+1));
                }
    
            }

        }

        if(dist[dest]==Integer.MAX_VALUE ){
            return -1;
        }
        else{
            return dist[dest];
        }
      
        

    }



    /*Connecting Cities With Minimum Cost */
    public static class CCWMC implements Comparable<CCWMC>{
        int vertex;
        int cost;

        CCWMC( int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(CCWMC pair2){
            return this.cost - pair2.cost;
        } 
    }
    public static int connectingCitiesWithMinimumCost( ArrayList<ArrayList<Edge>> graph ){

        int minimumCost=0;
        PriorityQueue<CCWMC> pq = new PriorityQueue<>();
        ArrayList<Integer> visited = new ArrayList<>();
        pq.add( new CCWMC( 0, 0));


        while(!pq.isEmpty()){

            CCWMC curr = pq.remove();

            if(!visited.contains(curr.vertex)){
                visited.add(curr.vertex);
                minimumCost += curr.cost;
                System.out.println("node: "+curr.vertex+" cost: "+curr.cost);
 
                for( int i=0; i<graph.get(curr.vertex).size(); i++){
                    Edge nb = graph.get( curr.vertex).get(i);
                    pq.add( new CCWMC( nb.dest, nb.wt ));
                }

                
            }

        }

        return minimumCost;

    }



    /* Disjoint Set DS */
    public static int find( int[] parent, int[] rank, int i){

        if(parent[i]==i){
            return i;
        }

        // return find( parent, rank, parent[i]);  //without path compression
        return parent[i] = find( parent, rank, parent[i]);  //with path compression



    }
    public static void union( int[] parent, int[] rank, int first, int second){

        first = find( parent, rank, first);
        second = find( parent, rank, second);

        if( rank[first]==rank[second]){
            parent[second] = first;
            rank[first]++;
        }
        else if( rank[first] > rank[second]){
            parent[second] = first;
            rank[first]++;
        }
        else{
            parent[first] = second;
            rank[second]++;
        }
    }



    /*Kruskal's Algorithm */
    public static class KruskalA implements Comparable<KruskalA>{
        int src;
        int dest;
        int cost;

        KruskalA( int src, int dest, int cost){
            this.src = src;
            this.dest = dest; 
            this.cost = cost;
        }

        @Override
        public int compareTo(KruskalA pair2){ 
            return this.cost - pair2.cost;
        } 
    }
    public static int kruskalAlgorithm( ArrayList<Edge> graph){

        int minCost = 0;
        int parent[] = new int[graph.size()];

        //initialize parent
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        //rank
        int rank[] = new int[graph.size()];

        PriorityQueue<KruskalA> pq = new PriorityQueue<>();

        //add graph edges in the priority queue
        for(int i=0; i<graph.size(); i++){
            Edge eg = graph.get(i);
            pq.add( new KruskalA( eg.src, eg.dest, eg.wt) );
        }

        //now find minimum cost, all edges are sorted
        while(!pq.isEmpty()){
            KruskalA curr = pq.remove();
            System.out.println(curr.cost);

            int par1 = find( parent, rank, curr.src);
            int par2 = find( parent, rank, curr.dest);

            //not take circular cycles
            if(par1!=par2){
                System.out.println("cost: "+curr.cost);
                union( parent, rank, par1, par2);
                minCost += curr.cost;
            }
        }

        return minCost;
        
    }   


    /* Flood Fill Algorithm */
    public static void floodFill(int[][] image, int sr, int sc, int color, int oldColor) {

        if( sr<0 || sr>image.length-1 || sc<0 || sc>image[0].length-1 || image[sr][sc]!=oldColor){
            return;
        }
        
        image[sr][sc] = color;

        //down
        floodFill( image, sr+1, sc, color, oldColor);
        //up
        floodFill( image, sr-1, sc, color, oldColor);
        //right
        floodFill( image, sr, sc+1, color, oldColor);
        //left
        floodFill( image, sr+1, sc-1, color, oldColor);
    }


    /* Number of Enclaves */
    public static void markVisitedByDFS(int[][] grid, int i, int j){

        if( i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==0){
            return;
        }

        grid[i][j] = 0;

        markVisitedByDFS( grid, i+1, j);
        markVisitedByDFS( grid, i-1, j);
        markVisitedByDFS( grid, i, j+1);
        markVisitedByDFS( grid, i, j-1);

    }


    public static void main(String[] args) {
        
        /*Create a Graph USING Ajacency List*/       /* Adjacency List time complexity is O(V+E) and Adjacency Matrix time complexity is O(V^2) */

        /* 
        int V=5;
        ArrayList<ArrayList<Edge>> al = new ArrayList<>();

        //initialize arrayList for each vertex
        for(int i=0; i<V; i++){
            al.add( new ArrayList<>());
        }

        //vertex 0
        al.get(0).add(new Edge( 0, 1, 5));
        //vertex 1
        al.get(1).add(new Edge( 1, 0, 5));
        al.get(1).add(new Edge( 1, 2, 1));
        al.get(1).add(new Edge( 1, 3, 3));
        //vertex 2
        al.get(2).add(new Edge( 2, 1, 1));
        al.get(2).add(new Edge( 2, 3, 1));
        al.get(2).add(new Edge( 2, 4, 2));
        //vertex 3
        al.get(3).add(new Edge( 3, 1, 3));
        al.get(3).add(new Edge( 3, 2, 1));
        //vertex 4
        al.get(4).add(new Edge( 4, 2, 2));

        //now we can find neighbours for each vertex

        //if we want to find 1's vertex then,
        for(int i=0; i<al.get(1).size(); i++){
            System.out.println( " source: " + al.get(1).get(i).src + " destination: " + al.get(1).get(i).dest + " weight: " + al.get(1).get(i).wt);
        }

        */

        /*Graph Traversals*/

            //create graph 
            /* 
            int V = 7; // Total number of vertices
            ArrayList<ArrayList<Edge>> al = new ArrayList<>();
    
            // Initialize arrayList for each vertex
            for (int i = 0; i < V; i++) {
                al.add(new ArrayList<>());
            }
    
            // Vertex 0
            al.get(0).add(new Edge(0, 1, 1));
            al.get(0).add(new Edge(0, 2, 1));
    
            // Vertex 1
            al.get(1).add(new Edge(1, 0, 1));
            al.get(1).add(new Edge(1, 3, 1));
    
            // Vertex 2
            al.get(2).add(new Edge(2, 0, 1));
            al.get(2).add(new Edge(2, 4, 1));
    
            // Vertex 3
            al.get(3).add(new Edge(3, 1, 1));
            al.get(3).add(new Edge(3, 4, 1));
            al.get(3).add(new Edge(3, 5, 1));
    
            // Vertex 4
            al.get(4).add(new Edge(4, 2, 1));
            al.get(4).add(new Edge(4, 3, 1));
            al.get(4).add(new Edge(4, 5, 1));
    
            // Vertex 5
            al.get(5).add(new Edge(5, 3, 1));
            al.get(5).add(new Edge(5, 4, 1));
            al.get(5).add(new Edge(5, 6, 1));
    
            // Vertex 6
            al.get(6).add(new Edge(6, 5, 1));

            */


            /*(1). (using BFS ) ( time complexity is O(V+E) )*/

            /* 
            Queue<Integer> que = new LinkedList<>();
            boolean visited[] = new boolean[V];

            //add first vertex
            que.add( 0);

            while(!que.isEmpty()){ 
                int curr = que.remove();
        
                if(!visited[curr]){
                    visited[curr] = true;                
                    System.out.print( curr +" ");

                    for(int i=0; i<al.get(curr).size(); i++){
                        Edge e = al.get(curr).get(i);
                        que.add( e.dest);
                    }
                }
            }
            
            */

          
            /*(2).(using DFS) ( time complexity is O(V+E) )*/

            /* 
            HashSet<Integer> visited = new HashSet<>();
            traversalDFS( al, visited, 0);
            */

            /*(3). Has Path exists*/
            /* 
            HashSet<Integer> visited = new HashSet<>();
            System.out.println( " has path Exists: "+ (hasPathExistsUsingDFS( al, visited, 5, 0)==true ? "Yes, it Exists" : "No, It is not exists")); 
            */

            /*(4).Traverse Disjoint Graph */

            /* 

            //create disjoint graph first

            int n = 16; // Total vertices
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
            // Initialize the adjacency list
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
    
            // Graph 1 edges
            graph.get(0).add(new Edge(0, 1, 1));
            graph.get(1).add(new Edge(1, 0, 1));
            graph.get(1).add(new Edge(1, 2, 1));
            graph.get(2).add(new Edge(2, 1, 1));
            graph.get(2).add(new Edge(2, 3, 1));
            graph.get(3).add(new Edge(3, 2, 1));
            graph.get(3).add(new Edge(3, 0, 1));
            graph.get(0).add(new Edge(0, 3, 1));
    
            // Graph 2 edges
            graph.get(4).add(new Edge(4, 5, 1));
            graph.get(5).add(new Edge(5, 4, 1));
            graph.get(5).add(new Edge(5, 6, 1));
            graph.get(6).add(new Edge(6, 5, 1));
            graph.get(6).add(new Edge(6, 7, 1));
            graph.get(7).add(new Edge(7, 6, 1));
            graph.get(7).add(new Edge(7, 8, 1));
            graph.get(8).add(new Edge(8, 7, 1));
            graph.get(8).add(new Edge(8, 4, 1));
            graph.get(4).add(new Edge(4, 8, 1));
    
            // Graph 3 edges
            graph.get(9).add(new Edge(9, 10, 1));
            graph.get(10).add(new Edge(10, 9, 1));
            graph.get(10).add(new Edge(10, 11, 1));
            graph.get(11).add(new Edge(11, 10, 1));
            graph.get(11).add(new Edge(11, 12, 1));
            graph.get(12).add(new Edge(12, 11, 1));
            graph.get(12).add(new Edge(12, 13, 1));
            graph.get(13).add(new Edge(13, 12, 1));
            graph.get(13).add(new Edge(13, 14, 1));
            graph.get(14).add(new Edge(14, 13, 1));
            graph.get(14).add(new Edge(14, 15, 1));
            graph.get(15).add(new Edge(15, 14, 1));
            graph.get(15).add(new Edge(15, 9, 1));
            graph.get(9).add(new Edge(9, 15, 1));


            HashSet<Integer> visited = new HashSet<>();

            traverseDisjointGraphUsingDFS( graph, visited);

            */
    
           /*(5). Cycle Detection in Undirected graph  ( time complexity is O(V+E) )*/

           /* 
            // Initialize the adjacency list
            int n = 5; // Total number of nodes (0 to 4)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            
            // Adding edges
            // Node 1 edges
            graph.get(1).add(new Edge(1, 0, 1)); // 1 <-> 0
            graph.get(1).add(new Edge(1, 2, 1)); // 1 <-> 2
            
            // Node 2 edges
            graph.get(2).add(new Edge(2, 1, 1)); // 2 <-> 1
            graph.get(2).add(new Edge(2, 0, 1)); // 2 <-> 0
            
            // Node 0 edges
            graph.get(0).add(new Edge(0, 1, 1)); // 0 <-> 1
            graph.get(0).add(new Edge(0, 2, 1)); // 0 <-> 2
            graph.get(0).add(new Edge(0, 3, 1)); // 0 <-> 3
            
            // Node 3 edges
            graph.get(3).add(new Edge(3, 0, 1)); // 3 <-> 0
            graph.get(3).add(new Edge(3, 4, 1)); // 3 <-> 4
            
            // Node 4 edges
            graph.get(4).add(new Edge(4, 3, 1)); // 4 <-> 3

          
            HashSet<Integer> visited = new HashSet<>();
            System.out.println( " is cycle detected "+ cycleDetectionInUndirectedGraph( graph5, visited));

            */

            /*(6). check if it is a Bipartite Graph */

            /*(i). two colors approach using BFS with time:-  O(V+E) */
            /* 
            // Initialize the adjacency list
            int n = 4; // Total number of nodes (0 to 3)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            
            // Adding edges
            // Node 0 edges
            graph.get(0).add(new Edge(0, 1, 1));
            graph.get(0).add(new Edge(0, 3, 1)); 
            
            // Node 1 edges
            graph.get(1).add(new Edge(1, 0, 1)); 
            graph.get(1).add(new Edge(1, 2, 1)); 
            
            // Node 2 edges
            graph.get(2).add(new Edge(2, 1, 1)); 
            graph.get(2).add(new Edge(2, 3, 1)); 
            
            // Node 3 edges
            graph.get(3).add(new Edge(3, 0, 1)); 
            graph.get(3).add(new Edge(3, 2, 1)); 

            // Node 4 edges
            graph.get(3).add(new Edge(3, 0, 1)); 
            graph.get(3).add(new Edge(3, 2, 1)); 

        
            System.out.println(" is graph is bipartite "+ checkIsBipartiteGraph( graph));

            */


            /*(ii). two colors approach using DFS with time:-  O(V+E) */

            /* 
            // Initialize the adjacency list
            int n = 4; // Total number of nodes (0 to 3)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            
            // Adding edges
            // Node 0 edges
            graph.get(0).add(new Edge(0, 1, 1));
            graph.get(0).add(new Edge(0, 3, 1)); 
            
            // Node 1 edges
            graph.get(1).add(new Edge(1, 0, 1)); 
            graph.get(1).add(new Edge(1, 2, 1)); 
            
            // Node 2 edges
            graph.get(2).add(new Edge(2, 1, 1)); 
            graph.get(2).add(new Edge(2, 3, 1)); 
            
            // Node 3 edges
            graph.get(3).add(new Edge(3, 0, 1)); 
            graph.get(3).add(new Edge(3, 2, 1)); 

            // Node 4 edges
            graph.get(3).add(new Edge(3, 0, 1)); 
            graph.get(3).add(new Edge(3, 2, 1)); 

        
            System.out.println(" is graph is bipartite "+ checkIsBipartiteGraphUsingDFS( graph));

            */
             
                                                            
            /*(7). Cycle Detection in Directed graph */

            //test case 1:- cyclic 
            /* 
            int n = 4; 
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // Adding edges based on your original request
            // Edge from 1 to 0
            graph.get(1).add(new Edge(1, 0, 1));
            // Edge from 0 to 2
            graph.get(0).add(new Edge(0, 2, 1));
            // Edge from 2 to 3
            graph.get(2).add(new Edge(2, 3, 1));
            // Edge from 3 to 0
            graph.get(3).add(new Edge(3, 0, 1));
            */

            //test case 2:- acyclic 
            /* 
            // Initialize the adjacency list for the second graph
            int n = 4; // Total number of nodes (0 to 3)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // Edge from 0 to 1
            graph.get(0).add(new Edge(0, 1, 1));
            // Edge from 0 to 2
            graph.get(0).add(new Edge(0, 2, 1));
            // Edge from 2 to 3
            graph.get(2).add(new Edge(2, 3, 1));
            // Edge from 1 to 3
            graph.get(1).add(new Edge(1, 3, 1));
            */

            //test case 3:- cyclic 
            /* 
            
            int n = 5; // Total number of nodes (0 to 4)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
    
            // Edge from 0 to 1
            graph.get(0).add(new Edge(0, 1, 1));
            // Node 1 has no neighbors, so we do not add any edges for it

            // Edge from 2 to 1
            graph.get(2).add(new Edge(2, 1, 1));
            // Edge from 2 to 3
            graph.get(2).add(new Edge(2, 3, 1));

            // Edge from 3 to 4
            graph.get(3).add(new Edge(3, 4, 1));

            // Edge from 4 to 2
            graph.get(4).add(new Edge(4, 2, 1));
            */

                /*(i). Cycle Detection in directed graph using DFS ( time:- O(V+E))*/

                    // System.out.println( " is cycle exist in directed graph " + cycleDetectionInDirectedGraph( graph));
            
            /*(8). Topological Sorting */

            /* 
                int n = 6; // Total number of nodes (0 to 5)
                ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
            
                // Initialize the graph
                for (int i = 0; i < n; i++) {
                    graph.add(new ArrayList<>());
                }
    
                // Edge from 5 to 0
                graph.get(5).add(new Edge(5, 0, 1));
                // Edge from 5 to 2
                graph.get(5).add(new Edge(5, 2, 1));
    
                // Node 0 has no neighbors, so we do not add any edges for it
    
                // Edge from 4 to 0
                graph.get(4).add(new Edge(4, 0, 1));
                // Edge from 4 to 1
                graph.get(4).add(new Edge(4, 1, 1));
        
                // Edge from 2 to 3
                graph.get(2).add(new Edge(2, 3, 1));
        
                // Edge from 3 to 1
                graph.get(3).add(new Edge(3, 1, 1));
            */

                /*(i). Topological Sorting using DFS*/ 
                    // System.out.println( "the topological Sorting is " + topologicalSortUsingDFS( graph));

                /*(ii). Topological Sorting using BFS */
                    // Topological Sorting using BFS( using Kahn's Algorithm)
                    // If You are unable to generate topological sort than it means that you have a cyclic directed graph, ( means if topological result is lesser than n means that it is a directed cyclic graph)
    
                    // System.out.println( "the topological Sorting is " + topologicalSortUsingBFS( graph));
         
            
            
            /*(9). All Paths from Source to Target in Directed Graph */

            /* 
            int n = 6; // Total number of nodes (0 to 5)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

            // Initialize the graph
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // Edge from 5 to 0
            graph.get(5).add(new Edge(5, 0, 1));
            // Edge from 5 to 2
            graph.get(5).add(new Edge(5, 2, 1));

            // Edge from 0 to 3
            graph.get(0).add(new Edge(0, 3, 1));

            // Edge from 4 to 0
            graph.get(4).add(new Edge(4, 0, 1));
            // Edge from 4 to 1
            graph.get(4).add(new Edge(4, 1, 1));

            // Edge from 2 to 3
            graph.get(2).add(new Edge(2, 3, 1));

            // Edge from 3 to 1
            graph.get(3).add(new Edge(3, 1, 1));

            ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
            ArrayList<Integer> container = new ArrayList<>();
            ArrayList<Integer> visited = new ArrayList<>();


            allPathsFromSourceToDestination( graph, paths, container, visited, 5, 1);
            System.out.println("the all paths are "+paths);

            */

            /*(10). Dijkstra's Algorithm  time:- O(V+ElogV)  logV is for sorted priority queues*/
            //fails when weights are negative

            /* 
            int n = 6;
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
            // Initialize the graph
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // 0 has edges to 1 and 2
            graph.get(0).add(new Edge(0, 1, 2));
            graph.get(0).add(new Edge(0, 2, 4));
    
            // 1 has edges to 2 and 3
            graph.get(1).add(new Edge(1, 2, 1));
            graph.get(1).add(new Edge(1, 3, 7));
    
            // 2 has an edge to 4
            graph.get(2).add(new Edge(2, 4, 3));
    
            // 3 has an edge to 5
            graph.get(3).add(new Edge(3, 5, 1));
    
            // 4 has edges to 3 and 5
            graph.get(4).add(new Edge(4, 3, 2));
            graph.get(4).add(new Edge(4, 5, 5));
    
            // 5 is single and ready to mingle (no outgoing edges)

        int result[] = dijkstraAlgoToFindTheShartestPath( graph);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }

        */

            /*(11). Bellman Ford Algorithm Dijkstra's Algorithm  time:- O(V*E) */
            //fails when it contains negative weights cycles

            /* 
            int n = 6;
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
            // Initialize the graph
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // 0 has edges to 1 and 2
            graph.get(0).add(new Edge(0, 1, 2));
            graph.get(0).add(new Edge(0, 2, 4));
    
            // 1 has edges to 2 and 3
            graph.get(1).add(new Edge(1, 2, 1));
            graph.get(1).add(new Edge(1, 3, 7));
    
            // 2 has an edge to 4
            graph.get(2).add(new Edge(2, 4, 3));
    
            // 3 has an edge to 5
            graph.get(3).add(new Edge(3, 5, 1));
    
            // 4 has edges to 3 and 5
            graph.get(4).add(new Edge(4, 3, 2));
            graph.get(4).add(new Edge(4, 5, 5));
    
            // 5 is single and ready to mingle (no outgoing edges)


            int result[] = bellmanFordAlgoToFindTheShartestPath( graph);

            for(int i=0; i<result.length; i++){
                System.out.print(result[i]+" ");
            }

            */

            /*(12). PRIM's Algorothm( to find minimum spanning tree) */
            //answer is same if two paths have same weight( choose any path)

            /* 
            int n = 7; // Number of vertices (0 to 6)
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    
            // Initialize the graph
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
    
            // Add edges according to the specified weights
            // 0 has edges to 1 and 3
            graph.get(0).add(new Edge(0, 1, 5)); // Edge from 0 to 1 with weight 5
            graph.get(1).add(new Edge(1, 0, 5)); // Edge from 1 to 0 with weight 5 (undirected)
    
            graph.get(0).add(new Edge(0, 3, 20)); // Edge from 0 to 3 with weight 20
            graph.get(3).add(new Edge(3, 0, 20)); // Edge from 3 to 0 with weight 20 (undirected)
    
            // 1 has an edge to 2
            graph.get(1).add(new Edge(1, 2, 5)); // Edge from 1 to 2 with weight 5
            graph.get(2).add(new Edge(2, 1, 5)); // Edge from 2 to 1 with weight 5 (undirected)
    
            // 2 has an edge to 3
            graph.get(2).add(new Edge(2, 3, 5)); // Edge from 2 to 3 with weight 5
            graph.get(3).add(new Edge(3, 2, 5)); // Edge from 3 to 2 with weight 5 (undirected)
    
            // 3 has an edge to 4
            graph.get(3).add(new Edge(3, 4, 1)); // Edge from 3 to 4 with weight 1
            graph.get(4).add(new Edge(4, 3, 1)); // Edge from 4 to 3 with weight 1 (undirected)
    
            // 4 has edges to 5 and 6
            graph.get(4).add(new Edge(4, 5, 2)); // Edge from 4 to 5 with weight 2
            graph.get(5).add(new Edge(5, 4, 2)); // Edge from 5 to 4 with weight 2 (undirected)
    
            graph.get(4).add(new Edge(4, 6, 4)); // Edge from 4 to 6 with weight 4
            graph.get(6).add(new Edge(6, 4, 4)); // Edge from 6 to 4 with weight 4 (undirected)
    
            // 5 has an edge to 6
            graph.get(5).add(new Edge(5, 6, 2)); // Edge from 5 to 6 with weight 2
            graph.get(6).add(new Edge(6, 5, 2)); // Edge from 6 to 5 with weight 2 (undirected)

            // Call the Bellman-Ford algorithm
            System.out.println( "minimum spanning tree cost : " + primAlgoToFindMinimumSpanningTree( graph));

            */

            /*(13). Cheapest Flights Within K Stops */

            /*test case:-1 */
            /* 
            int n=4;
            int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100}, { 1, 3, 600} ,{ 2, 3, 200} } ;
            int src=0;
            int dest=3;
            int k=1;
            */

            /*test case:-2 */
            /* 
            int n=3;
            int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500} } ;
            int src=0;
            int dest=2;
            int k=0;
            */

            /*test case:-3 */
            /* 
            int n=3;
            int flights[][] = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1}, { 2, 3, 1} } ;
            int src=0;
            int dest=3;
            int k=1;
            */

            /* 
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

            for(int i=0; i<n; i++){
                graph.add( new ArrayList<>());
            }

            for(int i=0; i<flights.length; i++){
                graph.get(flights[i][0]).add( new Edge( flights[i][0], flights[i][1], flights[i][2]));
            }

            System.out.println("Cheapest Flights cost is : "+ cheapestFlightsWithinKStops( graph, k, src, dest));

            */
            
            /*(14). Connecting Cities With Minimum Cost */

            /* 
            int cities[][] = {
                { 0, 1, 2, 3, 4},
                { 1, 0, 5, 0, 7},
                { 2, 5, 0, 6, 0},
                { 3, 0, 6, 0, 0},
                { 4, 7, 0, 0, 0}
            };

            
            ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

            for(int i=0; i<(cities.length) ; i++){
                graph.add( new ArrayList<>());
            }

            for(int i=0; i<cities.length; i++){
                for(int j=0; j<cities[0].length; j++){
                    if(cities[i][j]!=0){
                        graph.get(i).add( new Edge( i, j, cities[i][j]));
                    }
                }
            }

            System.out.println( "connecting cities with Minimum Cost is "+ connectingCitiesWithMinimumCost( graph));

            */

            /*(15). Disjoint Set DS ( also do path compression for optimization)*/     /* time complexity:- O(1)  */

            /* 
            int n=7;
            int parent[] = new int[n];
            int rank[] = new int[n];

            //in the start each node is self-parent node
            for(int i=0; i<n; i++){
                parent[i] = i;
            }

            //before query:-
            System.out.println("parent: ");
            for(int i=0; i<n; i++){
                System.out.print(parent[i]+" ");
            }

            System.out.println();
            System.out.println("rank: ");
            for(int i=0; i<n; i++){
                System.out.print(rank[i]+" ");
            }
            System.out.println();



            //queries execute
            union( parent, rank, 1, 3 );
            System.out.println(find( parent, rank, 3 ));
            union( parent, rank, 2, 4 );
            union( parent, rank, 3, 6 );
            union( parent, rank, 1, 4 );
            System.out.println( find( parent, rank, 3));
            System.out.println( find( parent, rank, 4));
            union( parent, rank, 1, 5);


            
            //after query:-
            System.out.println("parent: ");
            for(int i=0; i<n; i++){
                System.out.print(parent[i]+" ");
            }

            System.out.println();

            System.out.println("rank: ");
            for(int i=0; i<n; i++){
                System.out.print(rank[i]+" ");
            }
            System.out.println();

            */

            /*(16). Kruskal's Algorithm */     /* time complexity:- O(V) + O(ElogE) */

            /* 
            int n = 4; // Number of vertices (0 to 3)
            ArrayList<Edge> graph = new ArrayList<>();
    
            graph.add(new Edge( 0, 1, 10)); 
            graph.add(new Edge( 0, 2, 15)); 
            graph.add(new Edge( 0, 3, 30)); 
            graph.add(new Edge( 1, 3, 40)); 
            graph.add(new Edge( 2, 3, 50));
    
            System.out.println("Minimum spanning tree cost: " + kruskalAlgorithm(graph));

            */

            /*(17). Flood Fill Algorithm  ( time complexity:- m*n)*/

            /* 
            int image[][] = { { 1, 1, 1} , { 1, 1, 0}, { 1, 0, 1}};
            int sr = 1; 
            int sc = 1;
            int color = 2;

            int oldColor = image[sr][sc];
            floodFill( image, sr, sc, color, oldColor);

            for(int i=0; i<image.length; i++){
                for(int j=0; j<image[0].length; j++){
                    System.out.print(image[i][j]+"  ");
                }
                System.out.println();
            }

            */

            /*(18). Number of Enclaves (time:- m*n) */

            /* 
            int[][] grid = { { 0, 0, 0, 0}, { 1, 0, 1, 0} , { 0, 1, 1, 0} , { 0, 0, 0, 0}};

            //mark visit only in the boundry and apply DFS
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
    
                    if( i==0 || i==grid.length-1 || j==0 || j==grid[0].length-1){
                        markVisitedByDFS( grid, i, j);
                    }
                }
            }
    
            //now count the values which are non zero
            int count=0;
            for(int i=0; i<grid.length; i++){
                for(int j=0; j<grid[0].length; j++){
                    
                    if(grid[i][j]==1){
                        count += grid[i][j];
                    }
                }
            }
    
            System.out.println( "total count: "+count);

            */
    





    
    
    }
}
