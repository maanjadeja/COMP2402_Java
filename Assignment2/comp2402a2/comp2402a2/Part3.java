package comp2402a2;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;


public class Part3 {
	
	/**
	 * Your code goes here - see Part0 for an example
   * @param x the number of lines to read in
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(int x, BufferedReader r, PrintWriter w) 
      throws IOException {
		// TODO: Your code goes here - see Part0 for an example
		Deque<String> l2 = new ArrayDeque<>(x);

		//store x amount of lines in l2, and get rid of the first element when the n>x.
		//if the user inputs more than x lines, then you get rid of the first element and put the new inputted element at the back
		//then output the whole list backwards

		//use a deque, and read backwards
		int counter=0;
		for (String line = r.readLine(); line != null; line = r.readLine()) {
			//if(counter%x==0){
			if (x==0){
				break;
			}
			if(counter>=x){ //focus here
				l2.removeFirst();
				counter--;
			}
			l2.addLast(line);
			//counter=0;
			//}
			counter++;
		}


		for(int i=0; i<counter; i++){
			w.println(l2.removeLast());
			//l2.removeLast();
		}




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
      int x;
      if (args.length == 0) {
        x = 3;
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);
      } else if( args.length == 1) {
        x = Integer.parseInt(args[0]); 
        r = new BufferedReader(new InputStreamReader(System.in));
        w = new PrintWriter(System.out);
      } else if (args.length == 2) {
        x = Integer.parseInt(args[0]); 
        r = new BufferedReader(new FileReader(args[1]));
        w = new PrintWriter(System.out);				
      } else {
        x = Integer.parseInt(args[0]); 
        r = new BufferedReader(new FileReader(args[1]));
        w = new PrintWriter(new FileWriter(args[2]));
      }
			long start = System.nanoTime();
			doIt(x, r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
