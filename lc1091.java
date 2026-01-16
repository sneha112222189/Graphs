import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        
        boolean[][] vis = new boolean[n][n];
    
        return bfs(vis,grid);
    }

    int bfs(boolean[][] vis,int[][] grid){
        int n=grid.length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0,1));
        vis[0][0]=true;
        
        int[] drow={-1,-1,-1,0,0,1,1,1};
        int[] dcol={-1,0,1,-1,1,-1,0,1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int dist = p.dist;

            if(row==n-1 && col==n-1) return dist;

            for(int k=0;k<8;k++){
                int nrow=row+drow[k];
                int ncol=col+dcol[k];
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid.length  && grid[nrow][ncol]==0 && !vis[nrow][ncol]  ){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol,dist+1));
                }
            }
        }
        return -1;
    }

    class Pair{
        int first;
        int second;
        int dist;
        Pair(int first,int second,int dist){
            this.first=first;
            this.second=second;
            this.dist=dist;
        }
    }
}