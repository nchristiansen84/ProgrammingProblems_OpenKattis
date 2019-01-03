package SumKindOfProblem;
import java.util.*;

public class SumKindOfProblem {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Get number of cases
        short sets = sc.nextShort();
        short set = 0;
        
        // Loop over cases
        while(sets >= set){
            // Get case number and number
            set = sc.nextShort();
            short n = sc.nextShort();
            
            // Calculate positive, odd, and even sum for output
            //    sumPos  - Sum of first n positive integers
            //    sumOdd  - Sum of first n odd integers 
            //    sumEven - Sum of first n even integers
            int sumPos=0, sumOdd=0, sumEven=0;
            for(short i=1; i<=n;i++){
                sumPos+=i;
                sumOdd+=(i*2)-1;
                sumEven+=i*2;
            }
            
            // Print case number, positive sum, odd sum, then even sum
            System.out.println((set++)+" "+sumPos+" "+sumOdd+" "+sumEven);
        }
    }
}