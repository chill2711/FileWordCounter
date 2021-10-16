// Java program to sort hashmap by values 
import java.util.*; 
import java.lang.*;
import java.io.*; 


//need help with the word class  
public class Practice{ 
  
    // function to sort hashmap by values 
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> wordCount) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(wordCount.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> x,  
                               Map.Entry<String, Integer> y) 
            { 
                return (y.getValue()).compareTo(x.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> a : list) { 
            temp.put(a.getKey(), a.getValue()); 
        } 
        return temp; 
    } 
  
    // Driver Code 
    public static void main(String[] args) throws FileNotFoundException
    { 
  
        Scanner scan = new Scanner(System.in);
        System.out.println("Input name of file: ");
        String fileName = scan.nextLine();
        Scanner scanner = new Scanner(new File(fileName));
        
        HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
        while(scanner.hasNext()){
            String nextWord = scanner.next().toLowerCase();
            if(!wordCount.containsKey(nextWord))
            {
                wordCount.put(nextWord,1);
            }
            else{
                wordCount.put(nextWord,wordCount.get(nextWord)+1);
            }
        }
  
        System.out.println("Total words = " + wordCount.size());
        
        Map<String,Integer> wordCount1 = sortByValue(wordCount);
        for(Map.Entry<String,Integer> s: wordCount1.entrySet()){
            System.out.println(s.getKey() + " : " + s.getValue());
        }
        
        
        //how to save output printed to a file
        //file should created utilizing same directory of input file
        //name should be name of input file_[date in millis]
        //ex: file name is propjkv.txt it should be saved as propjkv.txt_date_in_millis
    
    
    
        
        
    
    }
    
    
    
  
  
}  