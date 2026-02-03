import java.util.*;
import java.io.*;

public class cycleFindCSES {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[n+1][3];
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
                }
            }
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u]==Integer.MAX_VALUE) continue;
            if(dist[u]+w<dist[v]){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
