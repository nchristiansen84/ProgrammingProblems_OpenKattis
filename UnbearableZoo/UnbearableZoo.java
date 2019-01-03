package UnbearableZoo;
import java.util.*;

public class UnbearableZoo {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        short listNum = 1;
        
        // Loops over cases
        while(sc.hasNextShort()){
            // Get num animals in this case
            short numLines=sc.nextShort(); sc.nextLine();
            
            // No animals, end of input
            if(numLines == 0)
                break;
            
            // Create tree map to store animals and number of each animal in alphabetical order
            TreeMap<String, Integer> animals=new TreeMap<>();
            
            // Loop over each animal for this case
            for(short i=0; i<numLines; i++){
                // Get full animal name
                String line=sc.nextLine();
                String animal;
                
                // Check if just animal name or if it has description
                if(line.contains(" ")){ // Has description, ex Blue Russian Penguin
                    animal=line.substring(line.lastIndexOf(' ', line.length())+1).toLowerCase();
                }else{ // Just animal, ex Penguin
                    animal=line.toLowerCase();
                }
                
                // Check if animal is already stored
                if(animals.containsKey(animal)){ // Already stored, increment number of that animal
                    animals.put(animal, animals.get(animal)+1);
                }else{ // Not stored, add to tree
                    animals.put(animal, 1);
                }
            }
            
            // Print list of animals and number of each in alphabetical order
            System.out.println("List "+(listNum++)+":");
            for(Map.Entry<String, Integer> animal : animals.entrySet()){
                System.out.println(animal.getKey()+" | "+animal.getValue());
            }
        }
    }
}