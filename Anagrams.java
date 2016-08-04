import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Anagrams {
	public static void main(String[] args) {
		File book = new File("C:\\Users\\rkatoch\\Documents\\sowpods.txt");
		try{
			Scanner input = new Scanner(book);
			HashMap<String,String> anagramMap = new HashMap<>();
			while(input.hasNextLine()) {
				addWordsToMap(anagramMap,input.nextLine());
			}
			printAnagrams(anagramMap);			
		} catch(FileNotFoundException e) {
			System.out.println("File Not found");
		}
	}
	public static void printAnagrams(HashMap<String,String> map) {
		Iterator mapiterator = map.entrySet().iterator();
	    while (mapiterator.hasNext()) {
	        Map.Entry pair = (Map.Entry)mapiterator.next();
	        String list = pair.getValue().toString();
	        if(list.contains(" "))
	        	System.out.println(list);
	        mapiterator.remove(); // avoids a ConcurrentModificationException
	    }
	}
	public static void addWordsToMap(HashMap<String, String> anagram, String s){
		if(anagram.containsKey(sortLetters(s))){
			String cluster = anagram.get(sortLetters(s));
			if(!cluster.contains(s)){
				cluster += " " + s;
				anagram.put(sortLetters(s), cluster);
			}
      }
		else{
			anagram.put(sortLetters(s), s);
		}
	}
	public static String sortLetters(String word){
		String sortedWord="";
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        sortedWord = new String(chars);
        return sortedWord;
	}
}