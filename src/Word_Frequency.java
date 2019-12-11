import java.util.*;
import java.io.*;

//Command to remember 
//indents my program
//ctrl + shift + F button
public class Word_Frequency {
	HashMap<String, Integer> frequency_map = new HashMap<String, Integer>();

	Word_Frequency(String lyrics_file_name) throws FileNotFoundException {
		Scanner lyrics_sc = new Scanner(new File(lyrics_file_name));
		PrintWriter FileStuf = new PrintWriter("src/Frequency_outPut.txt");
		
		// Populate the frequency_map
		while (lyrics_sc.hasNext()) {
			String word = lyrics_sc.next().toLowerCase();

			if (frequency_map.containsKey(word)) {
				frequency_map.put(word, frequency_map.get(word) + 1);
			} else {
				frequency_map.put(word, 1);
			}
		}

		// this part prints all my text to a file
		// Prints all keys and values in the map
		for (String key : frequency_map.keySet()) {
			FileStuf.printf("%d: %s\n", frequency_map.get(key), key);
		}

		lyrics_sc.close();
		FileStuf.close();
	}
}
