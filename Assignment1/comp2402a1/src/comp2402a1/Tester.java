package comp2402a1;

import java.util.Iterator;
import java.util.Random;

public class Tester {

  public static void testAddToBack(int n) {
    System.out.println( "Test AddToBack------");
    MyList<Integer> mal = new MyArrayStack<Integer>();
    System.out.println( mal );

    for( int i = 0; i < n; i++ ) {
      mal.add(i, mal.size());
      System.out.println( mal );
    }
    System.out.println( "Done Test AddToBack------");
  }

  public static void testRemoveFromFront(int n) {
    System.out.println( "Test RemoveFromFront------");
    MyList<Integer> mal = new MyArrayStack<Integer>();

    for( int i = 0; i < n; i++ ) {
      mal.add(i, mal.size());
    }

    System.out.println( mal );
    for( int i = 0; i < n; i++ ) {
      mal.remove(0);
      System.out.println( mal );
    }
    System.out.println( "Done Test RemoveFromFront------");
  }

  public static void main(String[] args) {
    testAddToBack(10);
    testRemoveFromFront(10);

    //make 2 myArrayStacks of ints and call shuffle on them.
    MyList<Integer> first = new MyArrayStack<Integer>();
    MyList<Integer> second = new MyArrayStack<Integer>();

    first.add(0,1);
    first.add(1,3);
    first.add(2,5);
    first.add(3,7);
    first.add(4,9);
    first.add(5,11);
    first.add(6,13);
    first.add(7,15);
    first.add(8,17);
    first.add(9,19);
    first.add(10,21);



    second.add(0,2);
    second.add(1,4);
    second.add(2,6);
    second.add(3,8);
    second.add(4,10);
    second.add(5,12);
    second.add(6,14);
    second.add(7,16);
    second.add(8,18);
    second.add(9,20);
    second.add(10,22);






    System.out.println(" ");
    System.out.println("FIRST LIST: ");
    System.out.println(" ");
    System.out.println(first.toString());
    System.out.println(" ");
    System.out.println("FIRST LIST COUNTOFF: " +first.countOff(3).toString());
    System.out.println(" ");
    System.out.println("FIRST LIST SIZE: " +first.size());
    System.out.println(" ");
    System.out.println("SECOND LIST: ");
    System.out.println(" ");
    System.out.println(second.toString());
    System.out.println(" ");
    System.out.println("SECOND LIST SIZE: " +second.size());
    System.out.println(" ");
    second.reverse();
    System.out.println(" ");
    System.out.println("SECOND LIST REVERESED: " +second.toString());
    System.out.println(" ");

    System.out.println("SHUFFLE METHOD!");

    System.out.println(first.shuffle(second).toString());
    System.out.println(" ");
    System.out.println(" ");





  }
}
