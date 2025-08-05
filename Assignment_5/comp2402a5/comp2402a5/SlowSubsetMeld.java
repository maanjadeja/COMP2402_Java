package comp2402a5;
/*
 * author: Alexa Sharp
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SlowSubsetMeld implements SubsetMeld {
  int[] id;   // id[i] is the "subset id" of element i
  int n;      // n is the number of elements in all subsets
  int k;      // the number of subsets

  public SlowSubsetMeld(int n) {
    id = new int[n];
    // Initially place each element is in its own subset.
    for( int i=0; i < n; i++ ) {
      id[i] = i;
    }
    this.n = n;
    this.k = n; 
  }

  // Returns whether x and y are in the same subset
  public boolean same(int x, int y) {
    if( x < 0 || x >=n || y < 0 || y >= n ) 
      throw new IndexOutOfBoundsException( "indices " + x + " , " + y );
    // x and y are in the same subset if and only if they 
    // have the same subset id.
    return (id[x] == id[y]);
  }

  // Meld the sets that contain x and y.
  public void meld(int x, int y) {
    if( x < 0 || x >=n || y < 0 || y >= n ) 
      throw new IndexOutOfBoundsException( "indices " + x + " , " + y );

    if( id[x] == id[y] ) return;

    // Meld the subset containing x into the subset containing y.
    // That is, for each element in x's subset, set its id to that of y.
    int idx = id[x];
    for( int i=0; i < id.length; i++ ) {
      if( id[i] == idx ) { // i is in x's subset since it has x's id.
        id[i] = id[y];
      }
    }
    k--; // We have one less subset now.
  }

	public int size() {
    return n;
	}

  public int numSubsets() {
    return k;
  }

  public String toString() {
    // This is a basic toString.
    StringBuilder sb = new StringBuilder();
    for( int i=0; i < n; i++ ) {
      sb = sb.append(i + ": " + id[i] + "\n");
    }
    return sb.toString();
  }
}
