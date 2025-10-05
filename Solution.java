class Solution {
    ArrayList<String> res;
    public void f(int i,int j,int n,int[][] maze,String s) 
    {
        if(i==n-1 &&  j==n-1)
        {
            res.add(new String(s));
            return;
        }
        if(i>=n || j>=n || i<0 || j<0 || maze[i][j]==0) return;
        maze[i][j]=0;
        f(i-1,j,n,maze,s+'U');
        f(i+1,j,n,maze,s+'D');
        f(i,j-1,n,maze,s+'L');
        f(i,j+1,n,maze,s+'R');
        maze[i][j]=1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n=maze.length;
        res=new ArrayList<>();
        f(0,0,n,maze,"");
        Collections.sort(res);
        return res;
    }
}