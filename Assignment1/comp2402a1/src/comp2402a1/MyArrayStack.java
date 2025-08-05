package comp2402a1;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;

/**
 * This class implements the MyList interface as a single array a.
 * Elements are stored at positions a[0],...,a[size()-1].  
 * Doubling/halving is used to resize the array a when necessary. 
 * @author morin
 * @author sharp
 *
 * @param <T> the type of objects stored in the List
 */
public class MyArrayStack<T> implements MyList<T> { 
	
	/**
	 * The array used to store elements
	 */
	T[] a;
	
	/**
	 * The number of elements stored
	 */
	int n;
	
	/**
	 * Resize the internal array
	 */
	protected void resize() {
		@SuppressWarnings("unchecked")
		T[] b = (T[])new Object[Math.max(n*2, 1)];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		a = b;
	}

	/**
	 * Constructor
	 */
	@SuppressWarnings("unchecked")
	public MyArrayStack() {
		a = (T[])new Object[1];
		n = 0;
	}

	/**
	 * Constructor
   *
   * @param cap
	 */
	@SuppressWarnings("unchecked")
	public MyArrayStack(int cap) {
		a = (T[])new Object[cap];
		n = 0;
	}
	
	public int size() { return n; }

	public T get(int i) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		return a[i];
	}
	
	public T set(int i, T x) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		T y = a[i];
		a[i] = x;
		return y;
	}
	
	public void add(int i, T x) {
		if (i < 0 || i > n) throw new IndexOutOfBoundsException();
		if (n + 1 > a.length) resize();
		for (int j = n; j > i; j--) 
			a[j] = a[j-1];
		a[i] = x;
		n++;
	}
	
	public T remove(int i) {
		if (i < 0 || i > n - 1) throw new IndexOutOfBoundsException();
		T x = a[i];
		for (int j = i; j < n-1; j++) 
			a[j] = a[j+1];
		n--;
		if (a.length >= 3*n) resize();
		return x;
	}

  public String toString() {
    String s = a.toString();
    String values="";
    // This is the default behaviour of toString.
    // TODO: Override this with more useful behaviour for debugging.

	//iterate through array a and add it to an empty string and return that string
	  /*for(int i=0; i<a.length; i++){
	  	values+=a[i].toString();
	  }*/

	  for(Object T : a){
	  	values+=T;
	  }
    return values;
  }

  public MyList<T> shuffle(MyList<T> other) {
    // TODO: Return the shuffle of this and other.
	  MyArrayStack<T> stack = new MyArrayStack<T>();

	  //this is a list stored in the class
	  //other is a seperate list

	  //use both list and return a comibnation of both

	  //you have to select the larger size of the

	  int smallerSize=0;

	  if(this.size() < other.size()){
		  smallerSize = this.size();
	  }
	  else{
		  smallerSize=other.size();
	  }

	  int largerSize=0;

	  if(this.size() > other.size()){
		  largerSize = this.size();
	  }
	  else{
		  largerSize=other.size();
	  }





	  //store smaller size, make a for loop that iterates from 0 to smaller size
	  //in the for loop we can create 1 more list and store elements like: [i] and [i+1]
	  //we will store elements of "this" [i] and elements of "other" in [i+1]
	  //we will have the remaining larger list, and add those elements at the end of the list


	  //while ___!=EMPTY, this.remove(i), other.remove(i)

	  //for(int num: this) {.......}

	  int finalSize = this.size() + other.size();


	  //OLD WORK !!!!!!!!!!!!!!!!!!!!!!!!!
	  /*int counter=0;
	  int number=0;
	  for(int i=0; i<smallerSize; i++){
		  //the errror is that its entering the if statements before we want it to
		  //we want to enter the if statement only for the remaining elements of the larger list

		  stack.add(i,this.get(counter));
		  //stack.add(number,this.get(counter));

		  stack.add(i,other.get(counter));
		  //stack.add(number,other.get(counter));
		  number++;
		  counter++;


	  }*/

	  //2 if statements and to satisfy one size over the other
	  //if(this.size() > other.size()){
	  //OLD WORK !!!!!!!!!!!!!!!!!!!!!!!!!
	  /*for(int j=smallerSize-1; j<largerSize; j++){
			  stack.add(j,this.get(counter));
			  counter++;

		  }*/

	  //}


	  //OLD WORK !!!!!!!!!!!!!!!!!!!!!!!!!
	  //if(this.size() < other.size()){
		  /*for(int j=smallerSize-1; j<largerSize; j++){
			  stack.add(j,other.get(counter));
			  counter++;

		  } */

	  //}

	  //1. smallersize
	  //0-smaller size in for loop-> try to add "this[i]" and "other[i]" into final stack
	  //also calculate the index of where it should go
	  //we just add this.get(i) into the final stack
	  //we can calculate if its even or odd to determine for this[i] and odd for other[i]
	  //find the longer list, then, we use smallerSize, start from smallersize, and add the remainging elements to the stack

	  //MY ORIGINAL WORK IS RIGHT HERE BELO: 9/25/2021 @ 8:02PM
	  int counter=0; //this was not here before
	  for(int i=0; i<finalSize; i++){
	  	//int value=1;
	  	if(i%2==0){
	  		if(counter<smallerSize){
				stack.add(i,this.get(counter));
				//counter++;
			}
			counter++;
		}
	  	else if(i%2==1){
			if(counter<smallerSize){
				stack.add(i,other.get(i-counter));
				//counter++;
			}


		}
	  	else{
	  		int number=0;
		}
	  }

	  /*if(this.size()<other.size()){
	  	stack.add(stack.size(),this.get(smallerSize-1));
	  }*/

	  if(other.size()<this.size()){
		  stack.add(stack.size(),other.get(smallerSize-1));
	  }


	  if(this.size()>=other.size()){
		  int counter4= stack.size();
		  for(int j=smallerSize; j<largerSize; j++){
	  		stack.add(counter4,this.get(j));
	  		counter4++;
		}
	  }

	  if(this.size()<=other.size()){
	  	int counter3= stack.size();
		  for(int k=smallerSize; k<largerSize+1; k++){
			  stack.add(counter3,other.get(k-1));
			  counter3++;
			  //the error is that the k index in stack is WRONG and we have to add to the end of ther list
		  }
	  }




		//old reference for code above
		/*  if(this.size() > other.size()){
		  stack.add(i,this.get(counter));
		  counter++;
	  }
	  else if(other.size() > this.size()){
		  stack.add(i,other.get(counter));
		  counter++;
	  }*/


	  //for loop that goes through the larger list, until we hit size of the smallest list, then only
	  //take from larger list
	  //get a size thats a sum of both, then iterate using that value,
	  /*

	  int counter=0;
	  for(int i=0; i<finalSize; i++){
	  	if this stack is > other.size()
	  	then add this.get(counter) to final stack
	  	counter++;


	  	if other stack is >
	  	then just adding other.get(counter)
	  		  counter++;
	  	else{

	  		take this.get(counter)
	  		i++

	  		other.get(counter) and add it to the final stack
	  		counter++;
	  	}


	  }

	  */


	  //MY WORK IS BELOW!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	  /*int counter=0;
	  for(int i=0; i<largerSize; i++){
	  	if(i>this.size()){
			counter++;
			stack.add(counter,other.get(i));
		}
	  	else if(i>other.size()){
			stack.add(i,this.get(i));
		}
	  	stack.add(i,this.get(i));
	  	counter++;
	  	stack.add(counter,other.get(i));

	  }*/

	  return stack;//this will be the final list you return
    //return this;
  }

	public MyList<MyList<T>> countOff(int n) {
    // TODO: Return a list of n lists, made by counting off
    // the elements in rounds of n.
    MyList<MyList<T>> l = new MyArrayStack<MyList<T>>();

    if(n==0){
    	return l;
	}


    MyArrayStack<T> stack = new MyArrayStack<T>();
    if(stack.size()<3) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			int value = i % n;
			stack.add(i, this.get(value));
		}
		l.add(counter, stack);
	}
    else{
    	stack=new MyArrayStack<>();
	}


		return l;
  }

  public void reverse() {
    // TODO: Reverse this MyArrayStack.
	  MyArrayStack<T> stack = new MyArrayStack<T>();

	  int counter=0;
	  for(int i=this.size()-1; i>=0; i--){
	  	stack.add(counter,this.get(i));
	  	counter++;
	  }
	  this.a = stack.a;
  }
}
