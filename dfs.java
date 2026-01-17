import java.util.*;

class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        int start = 0;
        ansdfs(ans,vis,start,adj);
        return ans;
    }
    
    void ansdfs(ArrayList<Integer> ans,boolean[] vis,int start,ArrayList<ArrayList<Integer>> adj){
        
        vis[start]=true;
        ans.add(start);
        
        for(int i : adj.get(start)){
            if(!vis[i]){
                ansdfs(ans,vis,i,adj);
            }
        }
    }
}