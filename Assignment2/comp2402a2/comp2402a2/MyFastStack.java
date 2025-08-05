package comp2402a2;

import java.util.LinkedList;
import java.util.Stack;


/**
 * This class implements the MyStack interface.
 * @author sharp
 *
 * @param <T> the type of objects stored in the MyStack
 */
public class MyFastStack<T> implements MyStack<T> {
	Stack <T> stack;
	int n;

	//dont use linkedlist, use arraystack

	public MyFastStack() {
    // TODO: Your code goes here
		stack = new Stack<>();


	}

	public int size() {
    // TODO: Your code goes here
		return n;
		//return  stack.size();
    //return -1;
	}

	
	public void push(T x) {
		if(stack.isEmpty()){
			stack.add(x);
			n++;

		}

		else if(x.equals("")){
			return;
		}

		else if(x == null){
			return;
		}

		else if(stack.peek().equals(x)){
			stack.pop();
			n--;
		}

		else{
			stack.add(x);
			n++;
		}
    // TODO: Your code goes here
	}
	
	public T pop() {
		T value;
		if(stack.isEmpty()){
			return null;
		}
		else{
			value = stack.pop();
			n--;
		}
    // TODO: Your code goes here
    return value;
	}

}
