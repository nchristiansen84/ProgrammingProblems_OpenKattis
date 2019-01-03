package StuckInATimeLoop;
import java.util.*;

public class StuckInATimeLoop {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loop through cases
        while(sc.hasNextShort()){
            short maxCount=sc.nextShort();
            
            // Print Abracadabra maxCount times
            for(short i = 1; i<=maxCount; i++){
                System.out.println(i+" Abracadabra");
            }
        }
    }
}