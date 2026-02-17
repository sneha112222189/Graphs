import java.util.*;

class Solution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis1 = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++){
            if(!vis1[i]){
                dfs1(i,adj,st,vis1);
            }
        }

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i=0;i<V;i++){
            rev.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int nei : adj.get(i)){
                rev.get(nei).add(i);
            }
        }

        Arrays.fill(vis1,false);
        int scc=0;

        while(!st.isEmpty()){
            int node = st.pop();
            if(!vis1[node]){
                dfs2(node,rev,vis1);
                scc++;
            }
        }
        return scc;
    }

    void dfs1(int start,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,boolean[] vis1){
        vis1[start]=true;
        for(int x : adj.get(start)){
            if(!vis1[x]){
                dfs1(x,adj,st,vis1);
            }
        }
        st.push(start);
    }

    void dfs2(int start,ArrayList<ArrayList<Integer>> rev,boolean[] vis1){
        vis1[start]=true;

        for(int nei : rev.get(start)){
            if(!vis1[nei]){
                dfs2(nei,rev,vis1);
            }
        }
    }
}
