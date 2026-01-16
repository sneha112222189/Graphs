import java.util.*;

//adjacent nodes approach
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution{
    public int numIslands(char[][] grid){
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int island=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
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
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
        
            for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
                int nrow = row+delcol;
                int ncol = col+delcol;
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='1' && vis[nrow][ncol]==false){
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
            }
        }
    }
}

//direction vector approach
