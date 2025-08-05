package comp2402a5;
// Thanks to Pat Morin for this file!

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Part4 {
	
	/**
	 * Your code goes here - see Part0 for an example
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {
    //TODO: Your solution goes here.
		Graph g = new AdjacencyLists(0);

		HashSet<String> set1 = new HashSet<>();

		Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

		Hashtable<String, Integer> table2 = new Hashtable<String, Integer>();



		int counter=0;
		boolean isFirst = true;
		int source=0;
		int indexLast=0;
		int indexFirst=0;
		String finalInput="";
		String firstValue="";
		for (String line = r.readLine(); line != null; line = r.readLine()) {


			//a word can start from letter e and end with letter e
			//since we are adding the edges inside the for loop we cant get the connections we need


			Character firstCharacter = line.charAt(0);
			Character lastCharacter = line.charAt(line.length()-1);

			String keyValue = String.valueOf(line.charAt(0))+String.valueOf(line.charAt(line.length()-1));

			if(firstValue == ""){
				firstValue = String.valueOf(line.charAt(0))+String.valueOf(line.charAt(line.length()-1));
			}


			if(table2.get(keyValue)==null){

				table2.put(keyValue,counter);
				counter++;
				g.addVertex();

			}

			finalInput = String.valueOf(line.charAt(0))+String.valueOf(line.charAt(line.length()-1));


			/*if(table.get(firstCharacter)==null){

				table.put(firstCharacter,counter);
				counter++;
				g.addVertex();
			}


			if(table.get(lastCharacter)==null){
				table.put(lastCharacter,counter);
				counter++;
				g.addVertex();
			}

			indexFirst = table.get(firstCharacter);
			indexLast = table.get(lastCharacter);


			if(isFirst){
				source = indexLast;
				isFirst = false;
			}


			g.addEdge(indexFirst,indexLast);*/




		}

		for(String s: table2.keySet()){

			for(String words: table2.keySet()){

				//vertices 1,2  1,3  2,1  2,3  3,1  3,2

				if(s.charAt(s.length()-1) == words.charAt(0)){

					int firstVertex = table2.get(s);
					int secondVertex = table2.get(words);

					g.addEdge(firstVertex,secondVertex);

				}


			}

		}

		//Canada  -----> C----A  B----L A-----A
		//Brazil
		//Africa

		//store the first and last letter each word in 1 string variable

		//System.out.println("outside the for loop!");
		//System.out.println(table);
		//System.out.println(source);
		//System.out.println(indexFirst);
		//bfs(g, source, indexLast);
		int firstVertexofFirstValue = table2.get(firstValue);
		int finalVertexofFinalValue = table2.get(finalInput);

		int minDistance = Algorithms.bfs(g, firstVertexofFirstValue, finalVertexofFinalValue);
		//bfs function is causing the issue, as we are off by 1 in certain infiles
		//w.println(comp2402a5.Algorithms.bfs(g, source, indexLast));
		if(minDistance==-1){

			w.println(0);

		}
		else{
			w.println(minDistance+1);

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
			//System.out.println("calling doit");
			doIt(r, w);
			//System.out.println("called doit");
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 1e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
