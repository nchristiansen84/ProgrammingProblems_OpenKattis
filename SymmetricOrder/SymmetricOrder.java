package SymmetricOrder;
import java.util.*;

public class SymmetricOrder {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int set = 1;
        
        // Loops through cases
        while(sc.hasNextShort()){
            // Gets number of names for this case
            short numStrings=sc.nextShort(); sc.nextLine();
            LinkedList<String> names=new LinkedList<>();
            
            // No names, end of input was reached
            if(numStrings == 0)
                break;
            
            // Loop over input names
            for(short i=0; i<(numStrings+1)/2; i++){
                // Add names to middle to create new list format
                int mid = (names.size()+1)/2;
                
                // Get name and add to middle of new list
                String line=sc.nextLine();
                names.add(mid, line);
                
                // If there is another name, add to middle+1 of new list
                if(mid < numStrings/2){
                    line = sc.nextLine();
                    names.add(mid+1, line);
                }
            }
            
            // Print new list format
            System.out.println("SET "+(set++));
            for(short i=0; i<numStrings; i++){
                System.out.println(names.get(i));
            }
        }
    }
}