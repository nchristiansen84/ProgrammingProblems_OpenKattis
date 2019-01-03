package TouchscreenKeyboard;
import java.util.*;

// Created word class which consist of a word and a distance
//   overrides compare and compareTo
class Word implements Comparator<Word>, Comparable<Word>{
    String word;
    int dist;

    // Word constructor
    Word(String word, int dist){
        this.word = word;
        this.dist = dist;
    }

    // Override compareTo to check distance and if distance is the same 
    //   then check alphabetical
    @Override
    public int compareTo(Word word){
        if(this.dist == word.dist){
            return this.word.compareTo(word.word);
        }if(this.dist > word.dist){
            return 1;
        }else{
            return -1;
        }
    }
    
    // Override compare to check distance and if distance is the same 
    //   then check alphabetical
    @Override
    public int compare(Word word1, Word word2){
        if(word1.dist == word2.dist){
            return word1.word.compareTo(word2.word);
        }if(word1.dist > word2.dist){
            return 1;
        }else{
            return -1;
        }
    }
}

public class TouchscreenKeyboard {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        
        // Get number of cases
        short numCases = sc.nextShort();
        short caseCount = 1;
        
        // Loop over cases
        while(caseCount <= numCases){
            // Get typed word and number of words similar in spell checker list
            String typedWord = sc.next();
            short wordListLen = sc.nextShort(); sc.nextLine();
            
            // Get all the similar spell checker words, and calculate distance
            //   from the typed word
            ArrayList<Word> wordList = new ArrayList<>();
            for(short i=0; i<wordListLen; i++){
                // Get spell checker word
                String word = sc.nextLine();
                int dist = 0;
                
                // Calcualte distance of each character in word from each 
                //   character in typed word to see how similar it is
                for(short j=0; j<word.length(); j++){
                    dist += calcKeyboardDist(typedWord.charAt(j), word.charAt(j));
                }
                
                // Add word and distance to list
                wordList.add(new Word(word, dist));
            }
            
            // Sorts all of the spell checker words based off of distance then
            //   alphabetically
            Collections.sort(wordList);
            // Prints all sorted spell checker words
            for(Word word : wordList){
                System.out.println(word.word+" "+word.dist);
            }
            
            // Increment case number
            caseCount++;
        }
    }
    
    // Calculates the distance between two keys
    public static int calcKeyboardDist(char key1, char key2){
        // Keyboard layout
        String keyboard[] = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int key1Row = 1, key1Col, key2Row = 1, key2Col;
        
        // Get pos of key1 in row 1
        key1Col = keyboard[0].indexOf(key1);
        if(key1Col == -1){ // Not in row 1 of keyboard
            // Get pos of key1 in row 2
            key1Col = keyboard[1].indexOf(key1);
            if(key1Col == -1){ // Not in row 2 of keyboard
                // Get pos of key1 in row 3
                key1Col = keyboard[2].indexOf(key1);
                key1Row = 3;
            }else{
                key1Row = 2;
            }
        }
        
        // Get pos of key2 in row 1
        key2Col = keyboard[0].indexOf(key2);
        if(key2Col == -1){ // Not in row 1 of keyboard
            // Get pos of key2 in row 2
            key2Col = keyboard[1].indexOf(key2);
            if(key2Col == -1){ // Not in row 2 of keyboard
                // Get pos of key2 in row 3
                key2Col = keyboard[2].indexOf(key2);
                key2Row = 3;
            }else{
                key2Row = 2;
            }
        }
        
        // Calculate distance between key1 and key2 -> |RowKey1-RowKey2| + |ColKey1-ColKey2|
        return Math.abs(key1Row-key2Row) + Math.abs(key1Col-key2Col);
    }
}