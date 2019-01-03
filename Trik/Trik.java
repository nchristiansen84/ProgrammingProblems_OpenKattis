package Trik;
import java.util.*;

public class Trik {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int set = 1;
        
        // Loop through cases
        while(sc.hasNextLine()){
            // Get sequence of moves
            String line=sc.nextLine();
            byte ballPos = 1;
            
            // Loop through sequence of moves
            for(byte i = 0; i<line.length(); i++){
                // Checks which move was done
                if(line.charAt(i) == 'A'){ // Swaps pos 1 and 2
                    // If ball is is pos 1 or 2, update it
                    if(ballPos == 1){
                        ballPos = 2;
                    }else if(ballPos == 2){
                        ballPos = 1;
                    }
                }else if(line.charAt(i) == 'B'){ // Swaps pos 2 and 3
                    // If ball is is pos 2 or 3, update it
                    if(ballPos == 2){
                        ballPos = 3;
                    }else if(ballPos == 3){
                        ballPos = 2;
                    }
                }else{  // Move 'C'. Swaps pos 1 and 3
                    // If ball is is pos 1 or 3, update it
                    if(ballPos == 1){
                        ballPos = 3;
                    }else if(ballPos == 3){
                        ballPos = 1;
                    }
                }
            }
            
            // Print ball position after sequence of moves
            System.out.println(ballPos);
        }
    }
}