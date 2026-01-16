import java.util.*;

class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        //left right boundary
        for(int i=0;i<n;i++){
            if(grid[i][0]=='O') bfs(vis,grid,i,0);
            if(grid[i][m-1]=='O') bfs(vis,grid,i,m-1);
        }

        //top bottom boundary
        for(int j=0;j<m;j++){
            if(grid[0][j]=='O') bfs(vis,grid,0,j);
            if(grid[n-1][j]=='O') bfs(vis,grid,m-1,j);
        }

        //flipping non-boundary 'O'
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O' && !vis[i][j]){
                    grid[i][j]='X';
                }
            }
        }
    }

    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    void bfs(boolean[][] vis,char[][] grid,int i,int j){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i,j));
        vis[i][j]=true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;

            for(int k=0;k<4;k++){
                int nrow=row+dr[k];
                int ncol=col+dc[k];
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]=='O' && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}