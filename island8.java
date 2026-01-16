import java.util.*;

class Solution {
    public int numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int island=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    
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
        vis[i][j]=true;

        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;

            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow = row+delrow;
                    int ncol = col+delcol;
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && !vis[nrow][ncol]){
                        vis[nrow][ncol]=true;
                        q.add(new Pair(nrow,ncol));
                    }
                }
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
