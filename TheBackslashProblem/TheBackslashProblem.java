package TheBackslashProblem;
import java.util.*;

public class TheBackslashProblem {
    // Use memoization to store previously calculated slashes
    static int[] memoSlashes = new int[9];
    
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        // Loop over cases
        while(sc.hasNextInt()){
            // Get number of levels of interpretation to be applied and line 
            //   it should be applied to
            int lvlOfInterp = sc.nextInt(); sc.nextLine();
            String line = sc.nextLine();
            
            // Get number slashes for this level of interpretation
            int numSlashes = getNumSlashes(lvlOfInterp);
            
            String outStr = "";
            // Interate over line
            for(int i=0; i<line.length(); i++){
                char indxChar = line.charAt(i);
                // Check if this char is special char
                if(isSpecialChar(indxChar)){ // Is special char
                    // Add appropriate number of escape chars for this level of interpretation
                    for(int j=0; j<numSlashes; j++){
                        // Add escape char to output string
                        outStr+='\\';
                    }
                }
                // Copy character to output string
                outStr += indxChar;
            }
            
            // Print original line with levels of interpretation applied to it
            System.out.println(outStr);
        }
    }
    
    // Check if input character is a special character
    public static boolean isSpecialChar(char character){
        if((character >= '!' && character <= '*')
           || (character >= '[' && character <= ']')){
            return true;
        }
        return false;
    }
    
    // Calculate number of slashes for provided depth
    public static int getNumSlashes(int depth){
        // Check if we know depth
        if(depth == 0){ // Depth is 0, return 0
            return 0;
        }else if(memoSlashes[depth] == 0){ // Slashes at this depth is not know
            // Calculate slashes and store it in memoized list
            memoSlashes[depth] = (getNumSlashes(depth-1)*2)+1;
        }
        
        // Return slashes for this depth
        return memoSlashes[depth];
    }
}