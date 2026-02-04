import java.util.*;
import java.io.*;

public class highScoreCSES {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edge = new int[m][3];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[i][0]=u;
            edge[i][1]=v;
            edge[i][2]=w;
        }

        long[] dist = new long[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;

        for(int i=0;i<n-1;i++){
            for(int[] edges : edge){
                int u = edges[0];
                int v = edges[1];
                long w = -edges[2];
                if(dist[u]==Integer.MAX_VALUE) continue;

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w<dist[v]){
                    
                        dist[v]=dist[u]+w;
                    
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int[] e : edge) {
                int u = e[0], v = e[1];
                long w = -e[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = -Integer.MAX_VALUE;
                }
            }
        }
        if (dist[n] == -Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(-dist[n]); // revert sign
        }
    }
}
