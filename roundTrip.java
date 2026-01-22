import java.util.*;

class roundTrip {
    static boolean found=false;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args){
        int n=6;
        int[][] trip = {{0,1},{1,3},{1,2},{5,3},{1,5},{2,4},{4,5}};
        roundTrip(trip,n);
    }

    static void roundTrip(int[][] trip,int n){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] t:trip){
            int u=t[0];
            int v=t[1];
            adj.get(u).add(v);
        }

        int[] vis = new int[n];
        int[] path = new int[n];
        Arrays.fill(vis,0);
        Arrays.fill(path,0);
        
        for(int i=0;i<n;i++){
            if(vis[i]==0 && !found){
                dfs(adj,path,vis,i);
            }
        }
        if(!found){
            System.out.println("IMPOSSIBLE");
        }
    }

    static void dfs(List<List<Integer>> adj,int[] path,int[] vis,int start){
        vis[start]=1;
        path[start]=1;
        ans.add(start);

        for(int nei : adj.get(start)){
            if(vis[nei]==0){
                
                dfs(adj,path,vis,nei);
                if(found) return;
            }
            else if(path[nei]==1){
                found = true;
                int index = ans.indexOf(nei);
                List<Integer> cycle = ans.subList(index,ans.size());
                System.out.println(cycle.size());
                System.out.println(cycle);
                return;
            }
        }  
        path[start]=0;
        ans.remove(ans.size()-1);
    }
}
