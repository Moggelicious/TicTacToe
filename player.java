import java.util.Scanner;

public class player {
    
    protected Scanner scanTurn = new Scanner(System.in);
    protected String playerName;
    protected String piece;
    protected int score;
    protected String player;
   
    //Constructor for playername And piece
    public player(String name, String playerPiece){
        this.playerName = name;
        this.piece = playerPiece;
    }
    //Method getName returns playerName
    public String getName(){                                                    
        return playerName;
    }
    //Method point Player to player
    public void setName(String Player){
        this.player = Player;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public String getPiece(){
        return piece;
    }
    public void printStats(int playerNumber){
        System.out.println("Player: " +playerName);
        System.out.println("Piece:" +piece);
        System.out.println("Wins: " +score);
        System.out.println();
    }
    
    //Method for entering position.
    public int[] playerTurn(){

        Boolean checkMove = true;
        int r = 0;
        int c = 0;
         
        while(checkMove){                                                     
            
            System.out.println("\n" + playerName + "'s turn.");
            System.out.print("Enter a row position:");
            String row = scanTurn.next();
            System.out.print("Enter a column position:");
            String col = scanTurn.next();
            // try to make string to int, if valid then go on.
            try{
                r = Integer.parseInt(row) ;
                c = Integer.parseInt(col) ;  
                checkMove= false;
            }
            // If not valid then this and redo while.
            catch(NumberFormatException e){        
                System.out.println("\nYou must enter a valid position.");
                checkMove = true;
            }
        }
        
        int rowcols[] = new int[2];
        rowcols[0] = r;
        rowcols[1] = c;
        return rowcols;
    }
}
    

