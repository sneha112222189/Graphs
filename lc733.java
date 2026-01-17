class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = new int[image.length][image[0].length];
        int originalcolor=image[sr][sc];

        if(originalcolor==color) return image;
        
        dfs(originalcolor,image,sr,sc,color);
        return ans;
    }
    void dfs(int originalcolor,int[][] image,int sr,int sc,int color){
       if(image[sr][sc]!=originalcolor) return;

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        image[sr][sc]=color;

        for(int k=0;k<4;k++){
            int nr=sr+dr[k];
            int nc=sc+dc[k];

            if( nr<image.length && nr>=0 && nc<image[0].length && nc>=0){
                dfs(originalcolor,image,nr,nc,color);
            }
        }
    }
}