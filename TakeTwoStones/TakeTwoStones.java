package TakeTwoStones;
import java.util.*;

public class TakeTwoStones {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loops through cases
        while(sc.hasNextInt()){
            // Gets number of stones
            int numStones=sc.nextInt();
            
            // Checks who will win based off of odd or even
            if(numStones % 2 == 0){ // Even, Bob wins
                System.out.println("Bob");
            }else{ // Odd, Alice wins
                System.out.println("Alice");
            }
        }
    }
}