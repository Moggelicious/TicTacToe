// The class that makes the board and win condititons.
public class gameBoard {

    protected int Rows;
    protected int Cols;
    protected String content = "   ";                                           
    protected String[][]cells;                                                  
    protected Boolean checkMove = true;
    protected int winRow ;
    protected int moveCount;
    
    
    //Contructor for a gameBoard, needs 2 ints.
    public gameBoard(int rows, int columns){                                      
        
        this.winRow = rows;
        this.Rows = rows;                                                     
        this.Cols = columns;                                                  
        cells = new String[Rows][Cols];                                        
    }
    
    //Method for drawing a board, print out four | minus one |. 
    public void drawBoard(){        
        System.out.println();
        for(int row = 0; row < Rows; row++){
            for(int col = 0; col < Cols; col++){
                System.out.print(cells[row][col]);
                if (col < Cols - 1){
                    System.out.print("|");
                }
            }
    //Print out four - minus one -.
        System.out.println();
            if(row < Rows - 1){
                for (int line = 0; line < Cols*4 -1 ; line++){              
                    System.out.print("-"); //
                }
            System.out.println();
            }
        }
    }
    //method for replacing cells with "   ".
    public void emptyCells(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                cells[i][j]= content;
            }
        }
    }
    //Method for showing number of cell position and printing int as String.
    public void locationCells(){
        System.out.println("The coordinates of the board:");
        for(int i =0; i < cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                cells[i][j] = (Integer.toString(i) + "," + Integer.toString(j));
            }
        }
    }
    //Method for setting moveCount.
    public void setmoveCount(int count){
        this.moveCount = count;
    }
    //Method for getPostition and returning cells
    public String[][] getPosition(){
        return cells;
    }
    //Method for checking if space is occupied with X/O and not inside board.
    public Boolean setPosition(int[] checkPosition ,String Piece){
        String piece = Piece;
        int[] move = checkPosition;

        if(cells.length -1 < move[0] || cells.length -1 < move[1] || move[0] < 0 || move[1] < 0){
            System.out.println("\nPosition on the board is not valid.");
            return false;
        }
        else if(cells[move[0]][move[1]].equals(" X ") || cells[move[0]][move[1]].equals(" O ")){
            System.out.println("This space is occupied.");     
            return false;
        }
        else{
            System.out.print("\nmarker placed.");
            cells[move[0]][move[1]] = piece;
        }
        return true;
    }
    //Method for winning condition adding 1 in moveCount each time when checking
    public int gameCondition(int r, int c, String piece){
        moveCount++;
        //Checking horizontal 3 in a row and if, going to switch case 1.
        for(int i = 0; i < winRow; i++){
            if(cells[r][i] != piece){
                break;
            }
            else if(i == winRow-1){
                System.out.print("\n" + cells.length + " in a row!\nYou won!");
                return 1;
            }
        }
        //Checking vertical 3 in a row and if, going to switch case 1.
        for(int j = 0; j < winRow; j++){
            if(cells[j][c] != piece){
                break;
            }
            else if(j == winRow-1){
                System.out.print("\n" + cells.length + " in a column!");
                return 1;
            }
        }    
        //Checking diagonal 3 in a row and if, going to switch to case 1.
        if(r == c ){
            for(int k = 0; k < winRow; k++){
                if(cells[k][k] != piece){
                   break;
                }
                else if(k == winRow-1){
                    System.out.print("\n" + cells.length + " in a diagonal!");
                    return 1;
                } 
            }
        }
        //Checking anti-diagonal 3 in a row and if, going to switch to case 1.
        if((r + c) == (winRow - 1)){
            for(int l = 0; l < winRow; l++){
                if(cells[l][(winRow-1)-l] != piece){
                    break;
                }
                else if(l == winRow-1){
                    System.out.print("\n" + cells.length+" in a diagonal!");
                    return 1;
                }
            }
        }
        //If movecount is higher than cells*2 then Switch to Case 2.
        if(moveCount == (cells.length*cells.length)){
            System.out.print("\nNobody won!");
            return 2;
        }
        return 0;
    }
}