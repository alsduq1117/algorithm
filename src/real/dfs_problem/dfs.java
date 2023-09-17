package real.dfs_problem;

import java.util.ArrayList;
import java.util.List;

public class dfs {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int startX = 3;
    static int startY = 2;
    static int endX = 4;
    static int endY = 2;
    static int totalPaths = 0;

    public static void main(String[] args) {
        visited = new boolean[8][5];

        List<String> paths=new ArrayList<>();

        visited[startX][startY] = true; // Mark start cell as visited
        findPath(startX,startY,"("+startX+","+startY+")",32-1,paths);

        System.out.println("Total paths: " + totalPaths);

    }

    public static void findPath(int x,int y,String path,int remainingSteps,List<String> paths){
        if(x==endX&&y==endY&&remainingSteps==0){
            if (path.contains("(0,2)") && path.contains("(1,3)") && path.contains("(1,4)") ||
                    path.contains("(6,0)") && path.contains("(6,1)") && path.contains("(7,2)")) {
                return;
            }
            paths.add(path);
            System.out.println(path);
            totalPaths++;
            return;//return after printing the path
        }

        for(int[] dir:dirs){
            int newX=x+dir[0];
            int newY=y+dir[1];

            if(isValid(newX,newY)&&!visited[newX][newY]){
                visited[newX][newY]=true;//mark as visited before going to next cell
                findPath(newX,newY,path+"->("+newX+","+newY+")",remainingSteps-1,paths);
                visited[newX][newY]=false;//backtrack here after returning from stack of next cell calls.
            }
        }
    }

    public static boolean isValid(int x,int y){
        return ((x>=0 && x<=6 && y>=0 && y<=1) ||
                (x>=0 && x<=7 && y==2) ||
                (x>=1 && x<=7 && y>=3 && y<=4));
    }



}