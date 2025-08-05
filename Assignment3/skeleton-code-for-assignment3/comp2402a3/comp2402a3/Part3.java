package comp2402a3;
// Thanks to Pat Morin for the skeleton of this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeSet;

/**
 *
 * @author morin
 * @author sharp
 * 
 */
public class Part3 {
	
	/**
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    //TODO: Your code goes here -- see Assignment 1 for examples
        //Deque<String> l3 = new ArrayDeque<>();
        //ArrayList<String> l5 = new ArrayList<>();

        //just use 1 list, in the list, use a sortedSet, in sortedSet there is a method called tailSet
        //tailSet gives u the equal or greater elements, [ a b c d ].tailSet(b) = [ b c d ]
        //gives u new set the current element, of elements greater than or equal to the given element, b
        //gives u it in O(1)
        //check if ur current given line is the prefix of the FIRST element of the tailset, then u can print out the line
        //[ aa ab bc de ].tailSet(b) = [ bc de], first element is bc, check if b is the prefix of bc, then u can say ur line is a prefix
        // if the current line is not the prefix of the 1st element in tailSet, then there is no such element that is a prefix of given line


        TreeSet<String> set = new TreeSet<>();

        //only store the last x elements
        //try using an arrayDeque
        //use a sortedSet to store elements in the arrayDeque, it allows u to search more efficeiently O(log n)

        for (String line = r.readLine(); line != null; line = r.readLine()) {



          //tailSet may be empty, first() will give an error
          //want to use minimum amount of space possible
          //if a new line is NOT a prefix of any previous line, we must add it to the treeSet
          //BUT,
          //[abcd, abc] - abc is a prefix
          // [abcd, abc, ab] - ab is a prefix of abcd, ab is a prefix of abc
          //are there any strings, that are a prefix of abc but NOT of abcd

          //if a line is a prefix of another line, we dont need to store it as any future line
          //will already be covered by the first line,


          //we only print out a line if that line is a prefix of any of the lines in the treeSet

          // a b d e -> tailset(c) = [d e], returns all elements larger and equal to c


          //old code!
          /*if(set.tailSet(line).size()==0){
            set.add(line);

          }

          if((set.tailSet(line).first().startsWith(line))){
            w.println(line);
          }*/



          if(set.tailSet(line).isEmpty()==false && set.tailSet(line).first().startsWith(line)){
            w.println(line);
          }
          else{
            set.add(line);
          }

          //set.add(line);



          /*if(set.tailSet(line).first().startsWith(line)){
                w.println(line);
            }*/







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
