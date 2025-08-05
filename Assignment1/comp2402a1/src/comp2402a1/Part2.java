package comp2402a1;
// Thanks to Pat Morin for this file!
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

public class Part2 {

	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {

		//List<String> l = new ArrayList<>();
		//specifically consecutive ones

		//ArrayList<String> block = new ArrayList<>();
		ArrayList<ArrayList<String>> array2 = new ArrayList<ArrayList<String>>();

		//ArrayList[][] array2 = new ArrayList[][2402];
		Stack aStack = new Stack<>();

		//collections.reverse() to reverse
		//2 seperate arraylists, 1 a
		//to add we just do array2.add(block);
		//create a nwe block everytime we hit 2402 lines



		//MAKE A COLLECTION OF COLLECTIONS TO STORE THE CHUNKS OF 2402 LINES!!!!

		//arraylist
		//2d Arraylist, store lists inside it
		//2 seperate for loops, to populate the 2d arraylist and then second to print it
		//in the 2d array, make each row hold 2402 lines like we are adding below
		//then print out the 2d array from bottom to top.

		//UNCOMMENTED
		/*int counter=0;
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			block.add(line);
			counter++;
			if(counter < 4){
				array2.add(block);
				counter=0;
				block = new ArrayList<>();

			}
		}*/


		//OUR ORIGINAL WORK IS BELOW!
		int counter=0;
		String block="";
		for (String line = r.readLine(); line != null; line = r.readLine()) {

				//array.add(line);
				block+=line+"\n";
				counter++;
				if(counter == 2402){
					aStack.push(block);
					counter=0;
					block="";
				}
		}

		//cant interate through buffered reader more than once!
		//OUR ORIGINAL WORK IS BELOW!
		if(block != ""){
			aStack.push(block);
		}

		/*for(int i=0; i<2402; i++){
			w.println(array.remove(i));
		}

		for(String text : aStack){
			w.println(aStack.pop());
		}*/

		//UNCOMMENTED!!
		/*Collections.reverse(array2);

		for(int i=0; i<array2.size(); i++){
			w.println(array2.get(i));
		}*/


		//OUR ORIGINAL WORK IS BELOW!
		while(aStack.isEmpty() == false){
			w.print(aStack.pop());
		}
		//if counter is like the final one, dont consider the extra line at the end



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
