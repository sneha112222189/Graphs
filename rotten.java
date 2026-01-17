
class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<Pair>();
        int time=0;
        

        int fresh=0;
        int rotten=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {fresh++;}
                if(grid[i][j]==2){
                    rotten++;
                    q.add(new Pair(i,j));
                }
            }
        }

        

        while(!q.isEmpty() ){
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            q.remove();

            int q_size = q.size();

            boolean isRot=false;
            for(int l=0;l<q_size;l++){

                int[] dr={-1,0,1,0};
                int[] dc={0,1,0,-1};
                
                for(int k=0;k<4;k++){
                    int nr = r+dr[k];
                    int nc = c+dc[k];

                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new Pair(nr,nc));
                        isRot=true;
                    }
                }
                //q_size--;
            }
            if(isRot==true) time++;
            else break;
        }
        
        if(fresh==0) return time;
        else return -1;

    }
    
}