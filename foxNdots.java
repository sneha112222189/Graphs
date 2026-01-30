import java.util.*;

public class  foxNdots {
    static class Pair{
        int x,y;
        int px,py;
        Pair(int x,int y,int px,int py){
            this.x=x;
            this.y=y;
            this.px=px;
            this.py=py;
        }
    }
    public static void main(String []args){
        int n=3;
        int m=4;
        String[] grid = {"AAAA","ABCA","AAAA"};
        solve(n,m,grid);
    }

    static void solve(int n,int m,String[] grid){
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    if (bfs(i, j,vis,grid)) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");
    }

    static boolean bfs(int i,int j,boolean[][] vis,String[] grid){
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j,-1,-1));
        vis[i][j]=true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.x;
            int c = p.y;
            int pr = p.px;
            int pc = p.py;
        for(int k=0;k<4;k++){
            int nr = r+dr[k];
            int nc = c+dc[k];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length() && grid[r].charAt(c) == grid[nr].charAt(nc)) {
                if (!vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new Pair(nr,nc,r,c));
                }
                else if (pr != nr || pc != nc) {
                    return true;
                }
            }
        }
        }
        return false;
    }
}
