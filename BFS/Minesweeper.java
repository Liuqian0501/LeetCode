public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        // There are three differnt cases, to slove this problem, we need to consider every posible case.
        //Fisrt case, If a mine ('M') is revealed, then the game is over - change it to 'X'.
        //Second case, If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
        //Third case, If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
        //Return the board when no more squares will be revealed.
        
        int row = click[0], col = click[1];
        //First Case;
        if(board[row][col] == 'M') {
            board[row][col] = 'X';
        }

        if(board[row][col] == 'E'){
            if(checkAdjacent(board, click) == '0'){//Second case;
                board[row][col] = 'B';
                clickAdjacent(board, click);
            }else{                                  //Third case;
                board[row][col] = checkAdjacent(board, click);
            }
        }
        return board;
    }
    
    private void clickAdjacent(char[][] board, int[] click){
        int row = click[0], col = click[1];
        int rowLen = board.length, colLen = board[0].length;
        int temp[] = {row, col};
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i==0 && j==0) continue;
                if(row + i < rowLen && row + i >= 0 && col + j < colLen && col + j >=0){
                    temp[0] = row + i;
                    temp[1] = col + j;
                    if(board[temp[0]][temp[1]] == 'E')
                        board = updateBoard(board, temp);
                }
            }
        }
        return;
    }
    private char checkAdjacent(char[][] board, int[] click){
        int row = click[0], col = click[1];
        int rowLen = board.length, colLen = board[0].length;
        int count = 0;

        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                if(i==0 && j==0) continue;
                if(row + i < rowLen && row + i >= 0 && col + j < colLen && col + j >= 0){
                    if(board[row + i][ col + j] == 'M') count++;
                }
            }
        }
        return (char)(count + '0');
    }
}
