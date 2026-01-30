import java.io.*;
import java.util.*;

public class kefaNpark {
  static int ans=0;
  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    
    int[] cat = new int[n + 1];
    st = new StringTokenizer(bf.readLine());

    for (int i = 1; i <= n; i++) {
      cat[i] = Integer.parseInt(st.nextToken());
    }
    
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(bf.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    
    boolean[] vis = new boolean[n+1];
    dfs(cat,cat[1],adj,1,vis,m);
    
    System.out.println(ans);
  }
  
  static void dfs(int[] cat,int cons,List<List<Integer>> adj,int start,boolean[] vis,int m){
    vis[start]=true;
    if(cons>m) return;
    boolean isLeaf = true;
    for(int nei : adj.get(start)){
      if(!vis[nei]){
        isLeaf=false;
        int newCons = (cat[nei]==1)?cons+1:0;
        dfs(cat,newCons,adj,nei,vis,m);
      }
    
    }
    if(isLeaf) ans++;
  }

  }