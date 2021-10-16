import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Comparator;
/**
 * The Word class represents a word with its corresponding frequency
 *
 * @author Coleman Hill
 * @version March 10, 2021
 */
public class Word implements Comparable <Word>
{
    
    private String word;
    private int frequency = 0;
    //constructor
    public Word(String word){
         this.word = word;
         frequency = 1;
    }
    
    //set method for word
    public void setWord(String word){
        this.word = word;
    }
    
    //get method for word
    public String getWord(){
        return word;
    }
    
    // set frequency
    public void setFrequnecy(int frequency){
        this.frequency = frequency;
    }
    
    //increasing frequency
    public void frequency(){
        frequency++;
    }
    
    //get method for frequency
    public int getFrequency(){
        return frequency;
    }
    
    //comparing frequencies
    public int compareTo(Word o){
        return new Integer(this.frequency).compareTo(o.getFrequency());
        
    }
    
    //overriding toString method to get word & frequency
    public String toString(){
        return word + " " + frequency;
    }
    

    
    
}
