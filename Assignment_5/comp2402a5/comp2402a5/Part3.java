package comp2402a5;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


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
      //TODO: Your solution goes here.

      //HashMap<String, Integer> map = new HashMap<String, Integer>();
      Set<Integer> set = new HashSet<>();
      boolean check=false;
      for (String line = r.readLine(); line != null; line = r.readLine()) {
        /*if(map.get(firstyKey)){
          x-value = line.length();
          w.println(yes)
        }*/
        //map.put(line, line.length());


        if(set.contains(x-line.length())){
          //set.add(line.length());
          w.println("yes");
          check = true;
          break;
        }
        set.add(line.length());

      }

      if(check==false){
        w.println("no");
      }

      /*for(String key: map.keySet()){
        int otherValue=x-map.remove(key);
        if(map.containsValue(otherValue)){//its checking the same key twice!
          w.println("yes");
          //w.println(key);
          //w.println()
          break;
        }
        else{
          w.println("no");
          break;
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
