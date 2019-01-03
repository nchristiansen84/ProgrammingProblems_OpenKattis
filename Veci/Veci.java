package Veci;
import java.util.*;

public class Veci {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loop over cases
        while(sc.hasNextLine()){
            // Get array of digits
            char digits[] = sc.nextLine().toCharArray();
            
            // Find non-increasing suffix
            int i = digits.length-1;
            while(i > 0 && digits[i-1] >= digits[i]) i--;
            
            // Already at last permutation
            if(i <= 0){
                System.out.println("0");
                continue;
            }
            
            // Finds next digit that is greater than pivot
            int j = digits.length-1;
            while(digits[j] <= digits[i-1]) j--;
            
            // Swap next greatest value with pivot
            swap(digits, i-1, j);
            
            // Reverse the suffix in order to have next highest permutation
            j = digits.length-1;
            while(i < j) swap(digits, i++, j--);
            
            // Prints next highest permutation
            System.out.println(digits);
        }
    }
    
    // Swaps two characters based on indexes
    public static void swap(char chars[], int indx1, int indx2){
        char temp = chars[indx1];
        chars[indx1] = chars[indx2];
        chars[indx2] = temp;
    }
}