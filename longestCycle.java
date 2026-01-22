import java.util.*;

class Solution {
    public int longestCycle(int[] edges) { 
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[edges.length]; 
        Arrays.fill(indegree,0); 
        for(int i=0;i<edges.length;i++){ 
            adj.add(new ArrayList<>()); 
            } 
        for(int e=0;e<edges.length;e++){ 
            int u = e; 
            int v = edges[e]; 
            
            if(v!=-1){
                adj.get(u).add(v);  
                indegree[v]++;}
        }

        int[] vis = new int[edges.length]; 
        Arrays.fill(vis,0); 
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<edges.length;i++){
            if(indegree[i]==0 && vis[i]==0){
                vis[i]=1;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.poll();
            for(int nei : adj.get(node)){
                
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        int x=-1;
        int temp=0;
        for(int i=0;i<edges.length;i++){
            if(vis[i]==0){
                temp = dfs(vis,adj,i);
            }
            if(temp!=0){
                x = Math.max(temp,x);
            }
        }
        return x;
    } 
    
    int dfs(int[] vis,List<List<Integer>> adj,int start){
        vis[start]=1;
        for(int nei : adj.get(start)){
            if(vis[nei]==0) return dfs(vis,adj,nei)+1;;
        }
        return 1;
    }
}