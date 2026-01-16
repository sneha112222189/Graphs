import java.util.*;

class Solution {
    public int numIslands(char[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int island=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    vis[i][j]=true;
                    island++;
                    bfs(grid,vis,i,j);
                }
            }
        }
        return island;
    }

    void bfs(char[][] grid,boolean[][] vis,int i,int j){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i,j));

        Pair p = q.poll();
        int row = p.first;
        int col = p.second;

        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};

        
        for(int k=0;k<4;k++){
            int nrow = row + drow[k];
            int ncol = col + dcol[k]; 
            if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && !vis[nrow][ncol]){
                vis[nrow][ncol]=true;
                q.add(new Pair(nrow,ncol));
            }
        }
    }

    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
}
