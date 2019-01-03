package Yoda;
import java.util.*;

public class Yoda {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loop over cases
        while(sc.hasNextLine()){
            // Get first and second number
            String firstNum = sc.nextLine();
            String secondNum = sc.nextLine();
            
            // Check which number is longer
            if(firstNum.length() < secondNum.length()){ // Second number is longer
                int firstNumLen = firstNum.length(), secondNumLen = secondNum.length();
                // Add 0's to make first number same legnth as second number
                for(int i=0; i<secondNumLen-firstNumLen; i++){
                    firstNum = "0" + firstNum;
                }
            }else{ // First num is longer
                int firstNumLen = firstNum.length(), secondNumLen = secondNum.length();
                // Add 0's to make second number same legnth as first number
                for(int i=0; i<firstNumLen-secondNumLen; i++){
                    secondNum = "0" + secondNum;
                }
            }
            
            // Loop over input numbers
            String firstOutStr = "", secondOutStr = "";
            for(int i=0; i<firstNum.length(); i++){
                // Check each digit to see if less than, equal to, greater than
                if(firstNum.charAt(i) < secondNum.charAt(i)){ // digit in second num is larger
                    secondOutStr += secondNum.charAt(i);
                }else if(secondNum.charAt(i) < firstNum.charAt(i)){ // digit in first num is larger
                    firstOutStr += firstNum.charAt(i);
                }else{ // digits are the same
                    firstOutStr += firstNum.charAt(i);
                    secondOutStr += secondNum.charAt(i);
                }
            }
            
            // Check if output for first num is empty
            if(firstOutStr.equals("")){ // Empty, output YODA
                System.out.println("YODA");
            }else{ // Not empty, output new number
                System.out.println(Long.parseLong(firstOutStr));
            }
            
            // Check if output for second num is empty
            if(secondOutStr.equals("")){ // Empty, output YODA
                System.out.println("YODA");
            }else{ // Not empty, output new number
                System.out.println(Long.parseLong(secondOutStr));
            }
        }
    }
}