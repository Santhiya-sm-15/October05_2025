# October05_2025
The problem that I solved today

Consider a rat placed at position (0, 0) in an n x n square matrix maze[][]. The rat's goal is to reach the destination at position (n-1, n-1). The rat can move in four possible directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).

The matrix contains only two possible values:

0: A blocked cell through which the rat cannot travel.
1: A free cell that the rat can pass through.
Your task is to find all possible paths the rat can take to reach the destination, starting from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any cell along the same path. Furthermore, the rat can only move to adjacent cells that are within the bounds of the matrix and not blocked.
If no path exists, return an empty list.

Note: Return the final result vector in lexicographically smallest order.

Code:
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
