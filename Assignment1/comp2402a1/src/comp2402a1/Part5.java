package comp2402a1;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;


public class Part5 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
		// Your code goes here - see Part0 for an example

		Stack aStack = new Stack<>();
		ArrayList<String> array = new ArrayList<>();

		ArrayDeque<String> aDeque = new ArrayDeque<String>();


		//deque size() < 2022 pop right end of it

		int counter=0;
		String block="";
		for (String line = r.readLine(); line != null; line = r.readLine()) {

			aDeque.addFirst(line);

			while(aDeque.size() >= 2022){
				aDeque.removeLast();
			}

			//aStack.push(line);
			//array.add(line);
			/*block+=line+"\n";
			counter++;
			if(counter < 2022 ){
				aStack.push(block);
				counter=0;
				block="";
			}*/
		}



		/*if(block != ""){
			aStack.push(block);
		} */



		/*for(int i=0; i<2022; i++){
			w.print(aStack.pop());
		}*/
		/*if(aStack.isEmpty() == false){
			w.print(aStack.pop());
		}*/

		while(aDeque.isEmpty() == false){
			w.print(aDeque.removeLast()+"\n");
		}

		/*while(aStack.isEmpty() == false){
			w.print(aStack.pop());
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
