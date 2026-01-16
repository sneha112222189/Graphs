import java.util.ArrayList;

//UNDIRECTED UNWEIGHTED GRAPH USING ADJACENCY LIST
class Graph{
    int V;
    ArrayList<ArrayList<Integer>> adj;
    // GRAPH CONSTRUCTOR
    Graph(int V){
        this.V=V;
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    // ADD EDGE METHOD
    void addEdge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    // PRINT GRAPH METHOD
    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.println(i+"->"+adj.get(i));
        }
    }
}

// UNDIRECTED WEIGHTED GRAPH USING ADJACENCY LIST
class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}

class WeightedGraph{
    int V;
    ArrayList<ArrayList<Pair>> adj;
    
    WeightedGraph(int V){
        this.V=V;
        adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u,int v,int w){
        adj.get(u).add(new Pair(v,w));
        adj.get(v).add(new Pair(u,w));
    }
    
    void printGraph(){
        for(int i=0;i<V;i++){
            System.out.println(i+"->");
            for(Pair p:adj.get(i)){
                System.out.println("("+p.node+","+p.weight+")");
            }
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[] args) {
        Graph g=new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.printGraph();
    }
}