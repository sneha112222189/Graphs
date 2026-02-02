import java.util.*;
import java.io.*;

public class cf638B {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());
        List<String> string = new ArrayList<>();

        for(int i=0;i<n;i++){
            string.add(bf.readLine()); 
        }

        int[] indegree = new int[27];
        Arrays.fill(indegree,-1);

        for(int x=0;x<n;x++){
            for(char c : string.get(x).toCharArray()){
                if(indegree[c-'a']==-1) {
                    indegree[c-'a']=0;   
                }
            }
        }
        

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<26;i++) adj.add(new ArrayList<>());

        for(String s : string) {
            for (int i = 0; i < s.length() - 1; i++) {
                int u = s.charAt(i) - 'a';
                int v = s.charAt(i + 1) - 'a';
                if (!adj.get(u).contains(v)) {
                    adj.get(u).add(v);
                    indegree[v]++;
                }
            }
        }

        boolean[] vis = new boolean[27];
        StringBuilder ans = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(!vis[i] && indegree[i]==0){
                vis[i]=true;
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.poll();
                    ans.append((char)('a'+node));

                    for(int nei :adj.get(node)){
                        indegree[nei]--;
                        if(indegree[nei]==0 && !vis[nei])
                            vis[nei]=true;
                            q.add(nei);
                    }
                }
            }
        }   
        System.out.println(ans.toString());
    }
}
