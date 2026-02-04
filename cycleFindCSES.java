import java.util.*;
import java.io.*;

public class cycleFindCSES {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][3];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i][0]=u;
            edges[i][1]=v;
            edges[i][2]=w;
        }

        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(parent,-1);

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        for(int i=1;i<=n-1;i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u]==Integer.MAX_VALUE) continue;

                if(dist[u]+w<dist[v]){
                    dist[v]=dist[u]+w;
                    parent[v]=u;
                }
            }
        }
        int cycleNode = -1;
        boolean found = false;
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u]==Integer.MAX_VALUE) continue;
            if(dist[u]+w<dist[v]){
                
                parent[v]=u;
                cycleNode=v;
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

        for (int i = 1; i <= n; i++) {
            cycleNode = parent[cycleNode];
        }

        List<Integer> cycle = new ArrayList<>();
        int cur = cycleNode;
        do{
        cycle.add(cur);
        cur=parent[cur];}
        while(cur!=cycleNode);
        
        cycle.add(cycleNode);
        Collections.reverse(cycle);
        for(int x : cycle){
        System.out.print(x+" ");
        }
    }
}
