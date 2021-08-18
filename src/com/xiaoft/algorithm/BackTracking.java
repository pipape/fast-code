package com.xiaoft.algorithm;

public class BackTracking {
    static int count = 0;
    public static boolean hasPath(char[][] board,String word){
        if(board == null || board.length < 1){
            return false;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(doHasPath(board,i,j,word,count,visited)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean doHasPath(char[][] board,int row,int col,String word,
                                    int count,boolean[][] visited){
        if(count == word.length()){
            return true;
        }
        boolean hasPath = false;
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length
                && board[row][col] == word.charAt(count) && visited[row][col] != true){
            visited[row][col] = true; //标记为已遍历
            count ++;   //字符遍历长度+1
            hasPath = doHasPath(board,row-1,col,word,count,visited) ||
                    doHasPath(board,row+1,col,word,count,visited) ||
                    doHasPath(board,row,col-1,word,count,visited) ||
                    doHasPath(board,row,col+1,word,count,visited);

            if(!hasPath){
                count --;
                visited[row][col] = false;
            }
        }

        return hasPath;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(hasPath(board,"ABF"));;
    }
}
