import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
        System.out.println("Welcome to a game of Tic Tac Toe!\n");
        
        System.out.print("Enter your name Player O(Nought): "); 
        String player1 = input.nextLine();
        player playerO = new player (player1," O "); 
        playerO.setName(player1);
        
        System.out.print("Enter your name Player X(Cross): ");
        String player2 = input.nextLine();
        player playerX = new player (player2," X ");
        playerX.setName(player2);

        
        System.out.print("Choose a boardsize (3-10): ");
        
        Boolean checkSize = true;
        int s = 0;
        while(checkSize){
            String size = input.next();
                    try{
                    // try to make string size into int s
                    s = Integer.parseInt(size);                             
                    if(3 > s || 10 < s ){
                        System.out.println("Size of the board must be from three(3) to ten(10) in size: ");
                    }
                    else{
                        System.out.println("\n");
                        checkSize = false;                                  
                    }
                    }
                    // if not then do this and redo while
                    catch(NumberFormatException e){
                        System.out.println("Size of the board must be a number:");
                        checkSize = true;
                    }
        }
        //Object ticTacToe from construktor gameBoard. sending s to gameboard Rows Cols
        gameBoard ticTacToe = new gameBoard(s,s);

        //objects using mtethods
        playerO.printStats(1);
        playerX.printStats(2);
        ticTacToe.emptyCells(); 
        ticTacToe.locationCells();
        ticTacToe.drawBoard();
        ticTacToe.emptyCells();     
        String PieceO = playerO.getPiece();
        String PieceX= playerX.getPiece();
        System.out.print("\n");
        
        Boolean gameOn= true;
        Boolean playing = true;
        
        //checking position in gameBoard class if occupied or valid 
        while(playing){
            while(gameOn){
                Boolean oTurn= true;
                Boolean xTurn= true;
                
            //for playerO sending playerO moves to player.class and if win to gameBoard.class
            while(oTurn){
                int[] move1 = playerO.playerTurn();
                int r = move1[0];
                int c = move1[1];
                //if occupied then redo loop in gameboard until move true
                if(ticTacToe.setPosition(move1, PieceO) !=true){
                    System.out.println();
                    ticTacToe.drawBoard();
                    System.out.println();
                }
                else{
                    //check if win condition or draw in gameboard
                    System.out.println("\n");
                    ticTacToe.drawBoard();
                    
                    switch(ticTacToe.gameCondition(r, c, PieceO)){
                        case 1:
                            System.out.println("\nYou won!\n");
                            int score = playerO.getScore();
                            playerO.setScore(score +1);
                            ticTacToe.drawBoard();
                            oTurn= false;
                            xTurn= false;
                            gameOn=false;
                            break;

                        case 2:
                            System.out.println("\nIt's a draw!\n");
                            ticTacToe.drawBoard();
                            oTurn= false;
                            xTurn= false;
                            gameOn=false;
                            break;

                        default: 
                            oTurn= false;
                            break;
                    }
                }
            }
            // //for playerX sending playerO moves to player.class and if win to gameBoard.class
            while(xTurn){
                int[] move2 = playerX.playerTurn();
                int r = move2[0];
                int c = move2[1];
                //if occupied then redo loop in gameboard until move true
                if(ticTacToe.setPosition(move2, PieceX) !=true){
                    System.out.println();
                    ticTacToe.drawBoard();
                    System.out.println();
                }
                else{
                    //check if win condition or draw in gameboard
                    System.out.println("\n");
                    ticTacToe.drawBoard();
                    
                    switch(ticTacToe.gameCondition(r, c, PieceX)){
                        case 1:
                            System.out.println("You won!\n");
                            int score = playerX.getScore();
                            playerX.setScore(score +1);
                            ticTacToe.drawBoard();
                            xTurn= false;
                            gameOn=false;
                        break;
                    
                        case 2:
                        System.out.println("It's a draw!\n");
                        ticTacToe.drawBoard();
                        xTurn= false;
                        gameOn=false;
                        break;
                        
                        default:
                        xTurn= false;
                        break;
                    }
                }
            }
            }
            System.out.println();                    
            System.out.println("Play again? (y/n)");
            String answer = input.next();
            switch (answer.toLowerCase()){
                    
                case "y":
                    playing = true;
                    gameOn= true;
                    System.out.println();
                    playerO.printStats(1);
                    System.out.println();
                    playerX.printStats(2);
                    System.out.println();
                    ticTacToe.setmoveCount(0);
                    ticTacToe.emptyCells();
                    ticTacToe.drawBoard(); 
                    System.out.println();                        
                    break;
                
                case "n":
                    playing = false;
                    gameOn= false;
                    System.out.println();
                    playerO.printStats(1);
                    System.out.println();
                    playerX.printStats(2);
                    break;
                    
                    default:
                        System.out.println("Please enter y or n:");
                        playing = true;
                        gameOn = false;
                        break;
                    }
            }
    }
}
