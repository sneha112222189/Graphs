import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class labyrinth {
    public void labyrinth(char[][] grid,int n,int m){
        boolean[][] vis =new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j] && grid[i][j]=='A'){
                    bfs(grid,vis,i,j);
                } 
            }
        }
    }

    void bfs(char[][] grid,boolean[][] vis,int i,int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;

            if (grid[r][c] == 'B') {
            System.out.println("YES");
            return;
            }

            for(int k=0;k<4;k++){
                int nr = r+dr[k];
                int nc = c+dc[k];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !vis[nr][nc] && grid[nr][nc]!='#'){
                        vis[nr][nc]=true;
                        q.add(new Pair(nr,nc));
                }
            }                
        }
        System.out.println("NO");
    }
}


