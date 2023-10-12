import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
public class FirstNonRepeatingStream {
    private final LinkedList<Character> charList; 
    private final Map<Character, Integer> charFrequency;

    public FirstNonRepeatingStream() {
        charList = new LinkedList<>();
        charFrequency = new HashMap<>();
    }

    public void add(char c) {
        
        if (charFrequency.containsKey(c)) {
            
            charFrequency.put(c, charFrequency.get(c) + 1);
        } else {
            
            charFrequency.put(c, 1);
        }
        
        
    }

    public static Map.Entry<Character, Integer> sortCharFrequencyByKey(Map<Character, Integer> charFrequency) {

        TreeMap<Character, Integer> sortedCharFrequency = new TreeMap<>(charFrequency);
        

        return sortedCharFrequency.firstEntry();
    }

    public static Entry<Character, Integer> sortbykey(Map<Character, Integer> map) {

        TreeMap<Character, Integer> sortedMap = new TreeMap<>(map);

        // Print the sorted map
        // for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        // Retrieve and print the second smallest entry
        Entry<Character, Integer> secondEntry = sortedMap.higherEntry(sortedMap.firstKey());
        return secondEntry;
    }


   public char getFirstNonRepeating() {
        Entry<Character, Integer> secondEntry=sortbykey(charFrequency);    
        
    
        Map.Entry<Character, Integer> topEntry = sortCharFrequencyByKey(charFrequency);
        
        if (topEntry != null && topEntry.getValue()!=2) {
            
           return topEntry.getKey();
        } else if(topEntry.getValue()==2 &&secondEntry.getValue()==2){
            return '-';    
        }
        return secondEntry.getKey();

    }

    public static void main(String[] args) {
        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
        stream.add('b');
        stream.add('b');
        stream.add('a');
       // stream.add('b');
        System.out.println(stream.getFirstNonRepeating()); 
        


    }
}
