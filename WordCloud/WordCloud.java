package WordCloud;
import java.util.*;

public class WordCloud {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int count = 1;
        
        // Loops over cases
        while(sc.hasNextInt()){
            // Gets max width of cloud and number of words to fit in cloud
            int maxWidth = sc.nextInt();
            int numWords = sc.nextInt(); sc.nextLine();
            
            // No width or words, end of input
            if(maxWidth == 0 && numWords == 0)
                break;
            
            ArrayList<String> words = new ArrayList<>();
            ArrayList<Integer> wordOccur = new ArrayList<>();
            int mostFreq = 0;
            // Gets words in cloud and their occurances storing in parallel arraylists
            for(int i=0; i<numWords; i++){
                // Adds word to arraylist
                words.add(sc.next());
                
                // Gets occurance of word and checks if it's highest occurance so far
                int occur = sc.nextInt();
                if(occur > mostFreq){ // If highest occurance so far store it
                    mostFreq = occur;
                }
                
                // Add word occurance to parrallel arraylist
                wordOccur.add(occur);
                sc.nextLine();
            }
            
            // Iterate over words in cloud
            int cloudHeight = 0, lineWidth = 0, lineHeight = 0;
            for(int i=0; i<numWords; i++){
                // Calculate point size (height) for this word -> [8+(40*(occur-4))/(maxOccur-4)]
                int wordHeight = (int)(8 + Math.ceil(((double)40*(wordOccur.get(i)-4))/(mostFreq-4)));
                // Calculate point size (width) for this word -> [9/16 * wordLength * wordHeight]
                int wordWidth = (int)(Math.ceil(((double)9*words.get(i).length()*wordHeight)/16));
                
                // Check if first word in line
                if(lineWidth == 0){ // First word, set line width to word length
                    lineWidth = wordWidth;
                }else{ // Not first word, add word width + 10pt space to line width
                    lineWidth += wordWidth+10;
                }
                
                // Check if exceeded max line width
                if(lineWidth > maxWidth){ // Exceeded line width
                    // Add this lines height to total word cloud height
                    cloudHeight += lineHeight;
                    // Create new line, initializing line width and height to this word width and height
                    lineWidth = wordWidth;
                    lineHeight = wordHeight;
                }
                
                // Check if this word height is heighest in line so far
                if(wordHeight > lineHeight){ // Heighest so far, update line height
                    lineHeight = wordHeight;
                }
            }
            // Add this lines height to total word cloud height
            cloudHeight += lineHeight;
            
            // Print the cloud number and it's cloud height
            System.out.println("CLOUD "+(count++)+": "+cloudHeight);
        }
    }
}