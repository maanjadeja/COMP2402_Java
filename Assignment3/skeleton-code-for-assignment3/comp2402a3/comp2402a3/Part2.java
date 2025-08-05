package comp2402a3;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.Set;


public class Part2 {
	
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

      Deque<String> l3 = new ArrayDeque<>();

      TreeMap<String,Integer> map = new TreeMap<String, Integer>();

      for (String line = r.readLine(); line != null; line = r.readLine()) {


          l3.add(line);
          //w.println(line);

          //l4.add(line);


          if(!map.containsKey(line)){
            map.put(line,1);
          }
          else{
            int duplicateCount = map.get(line);
            duplicateCount++;
            map.replace(line,duplicateCount);
          }


        if(l3.size() > x){
          //added the if statemnt below
          String value = l3.removeFirst();

          if(map.get(value) > 1){
            int duplicateCount2 = map.get(value);
            duplicateCount2--;
            map.replace(value,duplicateCount2);
          }
          else{
            map.remove(value);
            //l4.remove(value);
          }


        }

        //main focus is on printing out the lines
        if(l3.size() == x && line.equals(map.lastKey())){

          w.println(line);

        }




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
