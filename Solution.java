import java.util.PriorityQueue;

public class Solution {
    class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.third,b.third));
        pq.add(new Pair(0,0,0));

        boolean[][] isfinalised = new boolean[heights.length][heights[0].length];

        int[][] ans = new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=0;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r = p.first;
            int c = p.second;
            int len = p.third;
            
            if(isfinalised[r][c]) continue;
            isfinalised[r][c]=true;

            if (r == heights.length - 1 && c == heights[0].length - 1) {
                return len;
            }

            for(int k=0;k<4;k++){
                int nr = r+dr[k];
                int nc = c+dc[k];
                if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length){
                    int effort = Math.abs(heights[nr][nc]-heights[r][c]);
                    int neweffort=Math.max(len,effort);
                    if(neweffort<ans[nr][nc]){
                        ans[nr][nc]=neweffort;
                        pq.add(new Pair(nr,nc,neweffort));
                    }
                }
            }

        }
        return ans[heights.length-1][heights[0].length-1];
    }
} 
