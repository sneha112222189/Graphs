import java.util.*;

class teamBuilding {
    void team(int n,int m,int[][] friends){

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : friends){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                dfs(color,adj,i);
            }
        }
    }

    void dfs(int[] color,List<List<Integer>> adj,int start){
        if(color[start]==-1){
            color[start]=1;
            System.out.println(color[start]+" ");
        }

        for(int nei : adj.get(start)){
            if(color[nei]==-1){
                color[nei]=(color[start]==1)?2:1;
                System.out.println(color[nei]+" ");
                dfs(color,adj,nei);
            }
            else if(color[start] == color[nei]){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
