package comp2402a1;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Part4 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example

		//List<String> l = new ArrayList<>();
		//specifically consecutive ones
		ArrayList<String> array = new ArrayList<>();
		//arraylist

		//SET, or data structure that has fastest search time
		HashSet set = new HashSet<>();

		//Hashset is resourceful, return true/false if you try to add something if its a duplicate
		//doesnt add, then it returns false

		//Use Sets, and maps as duplicates are not present

		//String object = "";

		for (String line = r.readLine(); line != null; line = r.readLine()) {
			/*if(line.compareTo(object) == 0){
				array.add(line);
				object = line;
			}*/
			if(set.contains(line)==false){ //takes linear time, so goes slower with larger input
				set.add(line);
			}
			else{
				w.println(line);
			}

			//array.add(line);
			//you can check here if the array already contains the value you are adding
			//if the value is already present, then just print it

		} //cant interate through buffered reader more than once!


		/*while(array.isEmpty() == false){
			w.println(array.remove(array.size()-1));
		}*/

		//has the current element appeared in the list before.
		//use .contains or indexOf
		//SUBLIST


		/*String finalWord=array.get(0);
		ArrayList<String> array2 = new ArrayList<>();
		for(int i=0; i<array.size(); i++){
			array2 = array.subList(i+1, array.size());
			if(array2.contains(finalWord)){
				w.println(finalWord);
			}
			finalWord="";
		} */




		/*String finalWord=array.get(0);
		for(int i=0; i<array.size(); i++){
			if(finalWord.compareTo(array.get(i)) == 0){
				w.println(finalWord);
				finalWord=array.get(i+1);
				//word=array.get(i+1);
			}

		}*/



	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
