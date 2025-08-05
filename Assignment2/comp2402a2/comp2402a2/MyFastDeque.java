package comp2402a2;

import java.util.ArrayDeque;
import java.util.Deque;



/**
 * This class implements the MyDeque interface.
 * @author sharp
 *
 * @param <T> the type of objects stored in the MyDeque
 */
public class MyFastDeque<T> implements MyDeque<T> {

	Deque <T> deque;
	int n;


	public MyFastDeque() {
    // TODO: Your code goes here
		//use an arraydeque
		deque = new ArrayDeque<>();

	}

	public int size() {
    // TODO: Your code goes here
		return n;
    //return -1;
	}
	
	public void addFirst(T x) {
    // TODO: Your code goes here
		if(deque.size()==0){
			deque.addFirst(x);
			n++;
		}

		else if(deque.getFirst().equals(x)){
			deque.removeFirst();
			n--;
		}
		else{
			deque.addFirst(x);
			n++;
		}

	}
	
	public void addLast(T x) {
    // TODO: Your code goes here

		if(deque.size()==0){
			deque.addLast(x);
			n++;
		}

		else if(deque.getLast().equals(x)){
			deque.removeLast();
			n--;
		}
		else{
			deque.addLast(x);
			n++;
		}


	}
	
	public T removeFirst() {
    // TODO: Your code goes here
		if(deque.size()==0){
			return null;
		}
		else{
			n--;
			return deque.removeFirst();

		}

    //return null;
	}

	public T removeLast() {
    // TODO: Your code goes here
		if(deque.size()==0){
			return null;
		}
		else{
			n--;
			return deque.removeLast();

		}
    //return null;
	}
}
