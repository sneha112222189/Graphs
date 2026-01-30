import java.util.*;
import java.io.*;

public class party {
  static ArrayList<ArrayList<Integer>> adj;
  static class Node {
        int v, depth;
        Node(int v, int depth) {
            this.v = v;
            this.depth = depth;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
      
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        List<Integer> roots = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            int u = Integer.parseInt(br.readLine());
            if(u != -1){
              roots.add(i);
            }
            else{
              adj.get(u).add(i);
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        int ans=0;

        for(int root : roots){
          q.add(new Node(root,1));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            ans = Math.max(ans, cur.depth);

            for (int child : adj.get(cur.v)) {
                q.add(new Node(child, cur.depth + 1));
            }
        }
        System.out.println(ans);
    }
}
