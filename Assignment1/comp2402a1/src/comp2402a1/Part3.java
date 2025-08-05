package comp2402a1;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;


public class Part3 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		//read all the lines
		//look at the first floor(n/2) lines
		//get the minimum value in the first half
		//using string.compareTo(), compare all elements in the first half and output the smallest value
		//once you read all the lines, we look at size and if its <=1, output an empty string

		List<String> l = new ArrayList<>();
		//specifically consecutive ones
		ArrayList<String> array = new ArrayList<>();
		//arraylist


		for (String line = r.readLine(); line != null; line = r.readLine()) {
				array.add(line);
		} //cant interate through buffered reader more than once!

		int floorValue = (array.size() / 2);

		//array.removeRange(floorValue,array.size());

		//array.subList(floorValue,array.size()).clear();
		//w.println(array);



		//String word=array.get(0);
		String finalWord=array.get(0);

		if(array.size() <=1){
			finalWord="";
		}

		for(int i=0; i<floorValue; i++){
			if(finalWord.compareTo(array.get(i)) > 0){
				finalWord = array.get(i);
				//word=array.get(i+1);
			}

		}
		w.println(finalWord);


		/*while(array.isEmpty() == false){
			w.println(array.remove(array.size()-1));
		}*/


		// TODO: Your code goes here - see Part0 for an example
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
