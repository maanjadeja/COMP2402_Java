package comp2402a5;

import java.io.*;
import java.util.*;

public class Tester {
  protected static void println(String msg) {
    for (String line : msg.split("\n")) {
      System.out.println(line);
    }
  }

  protected static void printf(String format, Object... args) {
    System.out.printf(format, args);
  }

  static void testSubsetMeld(SubsetMeld s0, SubsetMeld s1, int[] a) {
    printf("\nSubsetMeld Testing\n");
    printf("a: %s\n", Arrays.toString(a) );

    testSize(s0, s1);
    testNumSubsets(s0, s1);
    testSame(s0, s1);

    for( int i=0; i+1 < a.length; i+=2 ) {
      // meld a[i] and a[i+1]
      //printf("meld(%d,%d)\n", a[i], a[i+1]);
      s0.meld(a[i], a[i+1]);
      s1.meld(a[i], a[i+1]);
      //printf("slow:\n%s\n", s0);
      //printf("my:\n%s\n", s1);
      testSize(s0, s1);
      testNumSubsets(s0, s1);
      testSame(s0,s1);
      break;
    }
  }

  static void testSize(SubsetMeld s0, SubsetMeld s1) {
    int a0 = s0.size();  
    int a1 = s1.size(); 
    if (a0 != a1) {
      printf("Failed size test\n");
      printf("\tExpected: %d, Got: %d.\n", a0, a1);
    } else {
      //printf("Passed size test\n");
    }
  }

  static void testNumSubsets(SubsetMeld s0, SubsetMeld s1) {
    int a0 = s0.numSubsets();  
    int a1 = s1.numSubsets(); 
    if (a0 != a1) {
      printf("Failed numSubsets test\n");
      printf("\tExpected: %d, Got: %d.\n", a0, a1);
    } else {
      //printf("Passed numSubsets test\n");
    }
  }

  static void testSame(SubsetMeld s0, SubsetMeld s1) {
    boolean passedAll = true;
    for( int i=0; i < s0.size(); i++ ) {
      for( int j=0; j < s0.size(); j++ ) {
        boolean b0 = s0.same(i,j);
        boolean b1 = s1.same(i,j);
        if (b0 != b1) {
          printf("Failed same test\n");
          printf( "\tExpected same(%d,%d): %b; got: %b\n", i, j, b0, b1);
          passedAll = false;
        }
      }
    }
  //  if( passedAll ) 
      //printf("Passed same test\n");
  }

  public static void main(String[] args) {
    Random rand = new Random();
    int n = 20;
    if (args.length == 1) {
      n = Integer.parseInt(args[0]);
    }
    printf("Testing with n = %d\n", n);


    SubsetMeld s0 = new SlowSubsetMeld(n);
    //System.out.println("SLOWSUBSETMELD: "+s0);
    SubsetMeld s1 = new MySubsetMeld(n);
    //System.out.println("MYSUBSETMELD: "+s1);


    // populate a with the melds you want to test.
    int[] a = new int[n];
    for( int i=0; i < n; i++ ) {
      a[i] = i;
    }
    testSubsetMeld(s0, s1, a);

    // make a new array a and test again if you wish
    s0 = new SlowSubsetMeld(n);
    s1 = new MySubsetMeld(n);
    a = new int[n];
    for( int i=0; i < n; i++ ) {
      a[i] = rand.nextInt(n);
    }
    testSubsetMeld(s0, s1, a);

    // make a new array a and test again if you wish
    s0 = new SlowSubsetMeld(n);
    s1 = new MySubsetMeld(n);
    a = new int[2*n];
    for( int i=0; i < n-1; i++ ) {
      a[2*i] = i;
      a[2*i+1] = i+1;
    }
    testSubsetMeld(s0, s1, a);

    // make a new array a and test again if you wish
    s0 = new SlowSubsetMeld(n);
    s1 = new MySubsetMeld(n);
    a = new int[2*n];
    for( int i=0; i < n-1; i++ ) {
      a[2*i] = n-i-1;
      a[2*i+1] = n-i-2;
    }
    testSubsetMeld(s0, s1, a);
  }

}
