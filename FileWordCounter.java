
/**
 * Program will ask for location of input file
 * Provide the words ordered by frequency
 * Print output on screen & save to a file
 *
 * @author Coleman Hill
 * @version March 10, 2021
 */
import java.util.*;
import java.io.*;
import java.util.Calendar;
import java.util.Date;
public class FileWordCounter
{
    public static void main(String [] args) throws FileNotFoundException{
        //creating scanner object to read from
        Scanner scan = new Scanner(System.in);
        System.out.println("Input name of file: ");
        String fileName = scan.nextLine();
        Scanner scanner = new Scanner(new File(fileName));
        //creating word object
        Word aWord;

        // reading strings in the file
        HashMap<String,Word> x = new HashMap<String,Word>();
        while (scanner.hasNext()){
            String nextWord = scanner.next().toLowerCase();
            if(x.containsKey(nextWord)){
                x.get(nextWord).frequency();
            }
            else{
                aWord = new Word(nextWord);
                x.put(nextWord,aWord);
            }
        }

        //placing values in array list to use collections.sort
        ArrayList<Word> a = new ArrayList<>(x.values());        

        System.out.println("Total Words = " + x.size());

        //sort by frequency ascending order
        Collections.sort(a);
        //sorting by descending order
        Collections.reverse(a);
        //printing the word & frequencies
        for(Word w: a){
            System.out.println(w.toString());
        }

        //creating date object for file saving
        Date date = new Date();
        long time = date.getTime();

        //writing to file and saving it as fileName with date in milliseconds
        try{
            WriteFile(fileName + String.valueOf(time),a);
        }
        catch(IOException e){
            System.out.println("Error");
        }

    }
    //writing file method
    public static void WriteFile(String fileName, ArrayList x) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("Total Words = " + String.valueOf(x.size()) + "\n");
        for(int i =0; i < x.size();i++){
            writer.write(x.get(i) + "");
            writer.newLine();
        }

        writer.close();
    }    

    
}
