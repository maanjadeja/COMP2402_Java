package comp2402a3;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Part1 {
	
	/**
	 * Your code goes here - see Part0 for an example
   * @param x the number of lines to read in
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(int x, BufferedReader r, PrintWriter w) 
      throws IOException {
      //TODO: Your code goes here -- see Assignment 2 for examples

      //Set<String> s1 = new HashSet<>();
      //List<Object> l2 = new ArrayList<>();

      Deque<String> l3 = new ArrayDeque<>();

      Set<String> l4 = new TreeSet<>();

      //only store the last x elements
      //try using an arrayDeque
      //use a sortedSet to store elements in the arrayDeque, it allows u to search more efficeiently O(log n)

      //int counter=0;
        boolean value;
      for (String line = r.readLine(); line != null; line = r.readLine()) {

        /*if(s1.contains(line)) continue;
          s1.add(line);*/

          l3.add(line);
          value = l4.add(line);

          //commented out
          if(!value){
              l3.remove(line);
              //l3.removeFirstOccurrence(line);
              //l3.addLast(line);
          }

          if(l3.size()>x){
            l4.remove(l3.removeFirst());
            //l3.addLast(line);
          }

      }



      /*int size=l3.size();
      for(int i=0; i<size; i++){
        l4.add(l3.removeFirst());
        //System.out.println(l4);

      } */

      /*System.out.println("THE l4 LIST: ");
      System.out.println(l4);*/

      for(String s:l4){
        w.println(s);
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
