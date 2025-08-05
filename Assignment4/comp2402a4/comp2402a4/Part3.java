package comp2402a4;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.SortedSet;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.*;

public class Part3 {

    /**
     * Your code goes here - see Part0 for an example
     * @param r the reader to read from
     * @param w the writer to write to
     * @throws IOException
     */
    public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
      //TODO: Your solution goes here.
        //Queue<String> queue = new PriorityQueue<String>();
        TreeSet<String> sortedSet = new TreeSet<String>();
        //Deque<String> l3 = new ArrayDeque<>();

        for (String line = r.readLine(); line != null; line = r.readLine()) {

            //System.out.println(sortedSet);

            //a c b a -> tailSet(a) = [a b]
            // b c a -> FINAL TREESET = [a] ->tailSet(a) = [b c]

            if(sortedSet.tailSet(line).size() > 0){

                while(sortedSet.higher(line)!=null){

                    sortedSet.remove(sortedSet.higher(line));

                }


            }

            //as u read lines, find a data structure, when we add a line, check if the item we add
            //is greater than any item in the data structure. ex. f d a -> add a to the data strucutre
            // not f and d since they are less than a.
            //also the last value gets printed since there are no values past it.

            //if we insert a string, it gives the next highest element

            // a b a ->[a b a] -> [a]


            if(sortedSet.tailSet(line).isEmpty()){
                    sortedSet.add(line);
            }

        }

        //print lines outside of the "for" loop

        //f d a c b -> f < b .....
        for(String s: sortedSet){
            w.println(s);
        }




    }

    /**
     * The driver.  Open a
     *  BufferedReader and a PrintWriter, either from System.in
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
