import java.util.*;

class Solution{
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int orangesRotting(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();

        int fresh=0;
        int rotten=0;
        int time=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2){
                    rotten++;
                    q.add(new Pair(i,j));
                }
            }
        }

        int q_size=q.size();

        for(int x=0;x<q_size;x++){
            while(!q.isEmpty()){
                Pair p = q.poll();
                int r = p.first;
                int c = p.second;

                int[] dr={-1,0,1,0};
                int[] dc={0,1,0,-1};
                
                boolean isRot=false;

                for(int k=0;k<4;k++){
                    int nr = r+dr[k];
                    int nc = c+dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        q.add(new Pair(nr,nc));
                        fresh--;
                        isRot=true;
                    }
                }
                if(isRot == true) time++;
                else break;
            }
        }
        if(fresh==0) return time;
        return -1;
    }
}