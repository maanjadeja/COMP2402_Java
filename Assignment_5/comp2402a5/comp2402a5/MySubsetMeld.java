package comp2402a5;
/*
 * author: Alexa Sharp
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class MySubsetMeld implements SubsetMeld {

    HashSet<HashSet<Integer>> hashSet = new HashSet<>(); //try to use a SET FOR THIS QUESTION HASHSET/TREESET
    //SETS HAVE O(log n) runtime

    HashMap<Integer, HashSet> hashMap = new HashMap<>();

    Graph g = new AdjacencyLists(0);

    //meldable heap can work with a simple array, 1d Array
    //how can we represent a subset with a tree, it doesnt have to be a binary/complete/order tree
    //how can we join 2 subsets into 1

    //ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();

    //meldable heap, help for this question, link is in discord

    //think of the idea of a tree and see how a node can have a parent and a root, we will be melding the root
    //this question focuses on speeding up the functions instead of focusing on data structures
    //get rid of functions we dont need and simplify the functions

    int n; //number of elements in the set
    int k=0; //number of subsets in the set
    int index=0;

    public MySubsetMeld(int n) {

      //ArrayList<Integer> subset = new ArrayList<Integer>();

      //id = new int[n];
      // Initially place each element is in its own subset.

      int value=0;
      for (int j=0; j<n; j++){

          g.addVertex();
          this.n++;
          g.addEdge(value,j);
          value++;
          this.k++;

      }




      for( int i=0; i < n; i++ ) {

          HashSet<Integer> subset = new HashSet<>();

          subset.add(i);
          this.n++;

          hashMap.put(index,subset);
          index++;

          this.k++;


          //arrayList.set(i,subset);
          //id[i] = i;
      }


      //hashMap.put(index,subset);
      //index++;
      //hashSet.add(subset);

      //System.out.println("MAAN SUBSET "+subset);
      System.out.println("MAAN HASHMAP: "+hashMap);

      System.out.println("THE N VALUE: "+this.n);
      System.out.println("THE K VALUE: "+this.k);

      //this.n = n;
      //this.k = n;

      //throw new UnsupportedOperationException();
  }

  public boolean same(int x, int y) {
        //boolean returnValue;


      for(Integer i: hashMap.keySet()){

          if(hashMap.get(i).contains(x) && hashMap.get(i).contains(y)){
              return true;
          }

      }

      return false;
           ///throw new UnsupportedOperationException(); //cant get rid of this?!



  }

  public void meld(int x, int y) {

      //ArrayList<Integer> newSubset = new ArrayList<Integer>();
      //System.out.println(x);
      //System.out.println(y);

      //HashSet<Integer> subset = new HashSet<>();

      /*for(int i=0; i<k; i++){

          if(hashSet.contains(x)){



              newSubset.addAll(arrayList.get(i));
              arrayList.remove(i);
          }
          if(arrayList.get(i).contains(y)){
              newSubset.addAll(arrayList.get(i));
              arrayList.remove(i);

          }

      }
      k--;
      arrayList.add(newSubset);*/
      
      int indexX=-1;
      int indexY=-1;
      int sizeX=-1;
      int sizeY=-1;
      for(Integer i: hashMap.keySet()){

          //.contains() is fine O(1) runtime

          if(hashMap.get(i).contains(x)){  //this part is probably slowing down the code
              indexX = i;
              sizeX = hashMap.get(i).size();
          }
          if(hashMap.get(i).contains(y)){
              indexY=i;
              sizeY = hashMap.get(i).size();

          }

          if(indexX!=-1 && indexY!=-1){
              break;
          }


      }

      if(indexX==indexY){
          return;
      }

      if(sizeX > sizeY){
          //addAll & remove is slowing down, we dont want to iterate through the elements
          //people usually use graphs and trees
          //previous assignments have a question to work with O(n) time in less than O(n) time
          //data structure that allows u to move element x & when u move element x, more other elements
          //are moved with it

          //All structures that have of O(log n) and O(1)
          //pointers have O(1) runtime

          hashMap.get(indexX).addAll(hashMap.get(indexY));
          this.k--;
          hashMap.remove(indexY);

      }
      else{

          hashMap.get(indexY).addAll(hashMap.get(indexX));
          this.k--;
          hashMap.remove(indexX);

      }





      //throw new UnsupportedOperationException();
  }

	public int size() {

      return n;

      //throw new UnsupportedOperationException();
	}

  public int numSubsets() {

      return k;

      //throw new UnsupportedOperationException();
	}
}
