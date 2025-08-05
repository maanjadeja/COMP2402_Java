package comp2402a4;
// Thanks to Pat Morin for the skeleton of this file!

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import java.util.*;

public class BinarySearchTree<Node extends BinarySearchTree.BSTNode<Node,T>, T> extends
		BinaryTree<Node> implements SSet<T> {

	protected Comparator<T> c;
	
	public static class BSTNode<Node extends BSTNode<Node,T>,T>
		extends BinaryTree.BTNode<Node> {
    // Usually these would not be public, but for server tests it's necessary.
		public T x;       // Holds the data value of this node.
    public int s;     // The size of the tree rooted at this node. This variable is NEVER updated though
		//size is basically the number of nodes present including the root node
	}

	/**
	 * The number of nodes (elements) currently in the tree
	 */
	protected int n;
	

	/**
	 * An extension of BSTNode that you can actually instantiate.
	 */
  protected static class BSTEndNode<T> extends BSTNode<BSTEndNode<T>,T> {
			public BSTEndNode() {
				this.parent = this.left = this.right = null;
        this.x = null;
        this.s = 1;       // A single node has size 1.
			}
	}

	protected Node newNode(T x) {
		Node u = super.newNode();
		u.x = x;
    u.s = 1;              // A single node has size 1.
		return u;
	}

	public BinarySearchTree(Node sampleNode, Node nil, Comparator<T> c) {
		super(sampleNode, nil);
		this.c = c; 
	}

	public BinarySearchTree(Node sampleNode, Comparator<T> c) {
		super(sampleNode);
		this.c = c; 
	}

	public BinarySearchTree(Node sampleNode) {
		this(sampleNode, new DefaultComparator<T>());
	}

	/**
   * Compute the size (number of nodes) of the tree rooted at u
	 * @return the size of the subtree rooted at u
	 */
	public int size2(Node u) {
    // TODO: You shouldn't have to change this method, but u.s will be 
    // incorrect unless you update it where necessary.

		//we dont need to do anything here, we have to make modifications in other places. Work on add and remove parts!
    return u.s;
	}
	
	/**
	 * Search for a value in the tree
	 * @return the last node on the search path for x
	 */
	protected Node findLast(T x) {
		Node w = r, prev = nil;
		while (w != nil) {
			prev = w;
			int comp = c.compare(x, w.x);
			if (comp < 0) {
				w = w.left;
			} else if (comp > 0) {
				w = w.right;
			} else {
				return w;
			}
		}
		return prev;
	}
	
	/**
	 * Search for a value in the tree
	 * @return the last "left turn" node on the search path for x
	 */
	protected Node findGENode(T x) {
		Node w = r, z = nil;
		while (w != nil) {
			int comp = c.compare(x, w.x);
			if (comp < 0) {
				z = w;        // We're turning left! Save z.
				w = w.left;
			} else if (comp > 0) {
				w = w.right;
			} else {
				return w;
			}
		}
		return z;
	}

	/**
	 * Search for a value in the tree
	 * @return the min value y >= x; null if x is larger than everything in tree
	 */
	public T find(T x) {
		Node w = r, z = nil;
		while (w != nil) {
			int comp = c.compare(x, w.x);
			if (comp < 0) {
				z = w;
				w = w.left;
			} else if (comp > 0) {
				w = w.right;
			} else {
				return w.x;
			}
		}
		return z == nil ? null : z.x;
	}

	/**
	 * Search for a value in the tree
	 * @return the last "right turn" node on the search path for x
	 */
	protected Node findLTNode(T x) {
		Node u = r, z = nil;
		while (u != nil) {
			int comp = c.compare(x, u.x);
			if (comp < 0) {
				u = u.left;
			} else if (comp > 0) {
				z = u;      // We're turning right! Save z.
				u = u.right;
			} else {
				return u;
			}
		}
		return z;
	}

  /*
   * Return the value that follows x (i.e. the minimum value
   * y such that y > x. If no such element exists, return null
   * @return the successor value of x.
   */
  public T succ(T x) {
    // TODO: Implement this method. It should match slowSucc, but
    // should be faster :-)
	  T succ = null;
	  Node currentNode = r;

	  while(currentNode!=null){
		  if(c.compare(currentNode.x,x)==0){

			  currentNode = currentNode.right;

		  }
		  else if(c.compare(currentNode.x,x)>0){

			  if(succ == null || c.compare(currentNode.x,succ) < 0){
				  succ = currentNode.x;
			  }

			  currentNode = currentNode.left;

		  }
		  else{

			  currentNode = currentNode.right;

		  }
	  }

	  return succ;

	  //return null;
  }

  /*
   * Return the value that follows x (i.e. the minimum value
   * y such that y > x. If no such element exists, return null
   * @return the successor value of x.
   */
  public T slowSucc(T x) {
    // Does an inorder traversal in O(n) time.
		Iterator<T> it = iterator();
    while( it.hasNext() ) {
      T curr = (T)(it.next());
      if( c.compare(curr, x) > 0 ) { // we have our first > elt
        return curr;                 // Return this element
      }
    }
    return null;            // never found anything
  }

  /*
   * Return the value that precedes x (i.e. the maximum value
   * y such that y < x. If no such element exists, return null
   * @return the predecessor value of x.
   */
  public T pred(T x) {
    // TODO: Implement this method. It should match slowPred, but
    // should be faster :-)
	T pred = null;
	Node currentNode = r;
	//we would have to do compare functions for each node we visit and have a case
	//to move left or right for each one
	  // and keep going down
	while(currentNode!=null){
		if(c.compare(currentNode.x,x)==0){

			currentNode = currentNode.left;

		}
		else if(c.compare(currentNode.x,x)<0){

			if(pred == null || c.compare(currentNode.x,pred) > 0){
				pred = currentNode.x;
			}

			currentNode = currentNode.right;

		}
		else{

			currentNode = currentNode.left;

		}
	}

	return pred;



    //return null;
  }

  /*
   * Return the value that precedes x (i.e. the maximum value
   * y such that y < x. If no such element exists, return null
   * @return the predecessor value of x.
   */
  public T slowPred(T x) {
    // Does an in-order traversal in O(n) time.
    T pred = null; // Keep track of the predecessor of curr
		Iterator<T> it = iterator();
    while( it.hasNext() ) {
      T curr = it.next();
      if( c.compare(curr, x) >= 0 ) { // we have our first >= elt
        return pred;                  // Return that last element we saw
      }
      pred = curr;
    }
    return pred;                    // never found anything >= elt
  }

  /*
   * Return a BST that contains all elements >= x, and remove them
   * from this. 
   * @return the BST containing all elements >= x
   */
  public BinarySearchTree<Node,T> chop(T x) {
//		Node sample = super.newNode();
//		BinarySearchTree<Node,T> other = new
//        BinarySearchTree<Node, T>(sample);
//	  BinarySearchTree<Node,T> small = new
//			  BinarySearchTree<Node, T>(sample);
    // TODO: Implement this method. It should match slowChop in
    // behaviour, but should be faster :-)
	  //Node currentNode = this.r;
	  //Node otherNode = other.r;

//	  while(currentNode!=null){
//
//	  	if(currentNode.right == null && currentNode.left==null){
//	  		break;
//		}
//
//
//	  		//otherNode=currentNode;
//
//	  		//use pointer manipulation, meaning changing what the edges point to from certain nodes
//			//make a new .this list and add it to it and and set this equal to the new list
//			//make sure to set the parent to null whenever necessary
//			/*if(c.compare(currentNode.left.x,x)>=x){
//				other.add(currentNode.left);
//			}
//
//			else{
//
//				other.add(currentNode.right);
//
//			}*/
//
//		  while(currentNode!=null){
//
//			  if(c.compare(currentNode.x, x)<0){
//				  currentNode = currentNode.right;
//			  }
//
//			  else if(c.compare(currentNode.x, x)>0){
//
//			  	/*if(other==null || c.compare(currentNode.x,x) < 0){
//			  		other.add(currentNode);
//				}*/
//				  other.add(currentNode);
//				  //other.add(currentNode.right);
//
//				  this.remove(currentNode);
//
//				  //this.remove(currentNode);
//				  //other.add(currentNode);
//				  currentNode=currentNode.left;
//				  //currentNode.parent = null;
//
//			  }
//			  else {
//				  if(currentNode.right!=null){
//					  other.add(currentNode.right);
//
//				  }
//
//				  break;
//
//			  }
//
//
//
//
//
//		  }
//
//
//
//
//
//	  }
	  Node sample = super.newNode();
	  BinarySearchTree<Node,T> other = new
			  BinarySearchTree<Node, T>(sample);
	  BinarySearchTree<Node,T> small = new
			  BinarySearchTree<Node, T>(sample);

	  Queue<Node> queue = new LinkedList<Node>();

	  Node currentNode = null;
	  queue.add(r);
	  int count = 0;

	  while(!queue.isEmpty()){
		  count = queue.size();

		  if(count == 0)	break;

		  while(count != 0){
			  currentNode = queue.remove();
			  count--;
			  //System.out.println(currentNode.x);


			  if(currentNode == null)	continue;
			  if(currentNode.left != null){
				  queue.add(currentNode.left);
			  }

			  if(currentNode.right != null){
				  queue.add(currentNode.right);
			  }


			  if(c.compare(currentNode.x,x)<0)	{
				  //System.out.println("added in small");
				  small.add(currentNode.x);}
			  else {
				  //System.out.println("added in other");
				  other.add(currentNode.x);}
		  }
	  }

	  this.clear();
	  this.r = small.r;
	  this.n = small.n;

	  return other;



  }

  
  /*
   * Return a BST that contains all elements >= x, and remove them
   * from this. 
   * Runs in O(n*height) time, where in a balanced tree height is O(log n).
   * @return the BST containing all elements >= x
   */
  public BinarySearchTree<Node,T> slowChop(T x) {
		Node sample = super.newNode();
		BinarySearchTree<Node,T> other = new 
        BinarySearchTree<Node, T>(sample);

    // Iterate through the n nodes in-order.
    // When see value >=x, add to new BST in O(height) time, and
    // remove it from this BST (on next iteration) in O(height) time.
		Iterator<T> it = iterator();
    T prev = null;
    while( it.hasNext() ) {
      T curr = (T)(it.next());
      if( c.compare(curr, x) >= 0 ) { // we have our first >= x 
        other.add(curr);
        if( prev != null ) {
          this.remove(prev);          // safe to remove now
        }
        prev = curr;
      }
    }
    if( prev != null ) {
      this.remove(prev); // edge case, get that last one!
    }
    return other; 
  }



	/**
	 * Add the node u as a child of node p -- ASSUMES p has no child
	 * where u should be added
	 * @param p
	 * @param u
	 * @return true if the child was added, false otherwise
	 */
	protected boolean addChild(Node p, Node u) {
		if (p == nil) {
			r = u;              // inserting into empty tree
		} else {
			int comp = c.compare(u.x, p.x);
			if (comp < 0) {
				p.left = u;
			} else if (comp > 0) {
				p.right = u;
			} else {
				return false;   // u.x is already in the tree
			}
			u.parent = p;
			//u.s++; //added

			// Update all ancestors of u to have one bigger size
      while( p != nil ) {
		  p.s+=(u.s);
		  p = p.parent;
		  //u.s++; //added

	  }
		}
		n+=(u.s);
		return true;		
	}

	/**
	 * Add a new value
	 * @param x
	 * @return
	 */
	public boolean add(T x) {
		Node p = findLast(x);
		return addChild(p, newNode(x));		
	}

	/**
	 * Add a new value
	 * @param x
	 * @return
	 */
	public boolean add(Node u) {
		Node p = findLast(u.x);
		return addChild(p, u);		
	}

	/**
	 * Remove the node u --- ASSUMING u has at most one child
	 * @param u
	 */
	protected void splice(Node u) {
		Node s, p; // s is the child of u, p is the parent.
		if (u.left != nil) {
			s = u.left;
		} else {
			s = u.right;
		}
		if (u == r) { // There is no parent, just replace r with s.
			r = s;
			p = nil;
		} else {
			p = u.parent;
			if (p.left == u) {
				p.left = s; // splice out u
			} else {
				p.right = s;  // splice out u
			}
		}
		if (s != nil) {
			s.parent = p;
		}
    while( p != nil ) {
    	p.s--;
      	p = p.parent;

    }
		n--;
	}
	
	/**
	 * Remove the node u from the binary search tree
	 * @param u
	 */
	protected void remove(Node u) {
		if (u.left == nil || u.right == nil) {
			splice(u);
		} else {
			Node w = u.right;
			while (w.left != nil) 
				w = w.left;
			u.x = w.x;
			splice(w);
		}
	}
	

	/**
	 * Remove a node
	 * @param x
	 * @return
	 */
	public boolean remove(T x) {
		Node u = findLast(x);
		if (u != nil && c.compare(x,u.x) == 0) {
			remove(u);
			return true;
		}
		return false;
	}
	
	public String toString() {
		String s = "[";
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			s += it.next().toString() + (it.hasNext() ? "," : "");
		}
		s += "]";
		return s;
	}
	
  // Why do I need this method, shouldn't inheritance and polymorphism
  // take care of this?
	public Node firstNode() {
    return super.firstNode();
  }

  // Why do I need this method, shouldn't inheritance and polymorphism
  // take care of this?
	public Node nextNode(Node u) {
    return super.nextNode(u);
  }


	public Iterator<T> iterator(Node u) {
		class BTI implements Iterator<T> {
			protected Node w, prev;
			public BTI(Node iw) {
				w = iw;
			}
			public boolean hasNext() {
				return w != nil;
			}
			public T next() {
				T x = w.x;
				prev = w;
				w = nextNode(w);
				return x;
			}
			public void remove() {
				// NOTE: This is a bug.  remove() methods have to be changed
        // DON'T USE REMOVE ON THE ITERATOR				
				BinarySearchTree.this.remove(prev);
			}
		}
		return new BTI(u);
	}

	public Iterator<T> iterator() {
		return iterator(firstNode());
	}

	public Iterator<T> iterator(T x) {
		return iterator(findGENode(x));
	}
	
	public int size() {
		return n;
	}

	public void clear() {
		super.clear();
		n = 0;
	}

	public Comparator<? super T> comparator() {
		return c;
	}




	public static BinarySearchTree<BSTEndNode<Integer>,Integer> emptyBST() {
    return randomBST(0);
	}

	public static BinarySearchTree<BSTEndNode<Integer>,Integer> randomBST(int n) {
		BSTEndNode<Integer> sample = new BSTEndNode<Integer>();
		BinarySearchTree<BSTEndNode<Integer>,Integer> t = new 
        BinarySearchTree<BSTEndNode<Integer>, Integer>(sample);
		Random rand = new Random();
    for( int i=0; i < n; i++ ) {
      int value = rand.nextInt(3*n);
      t.add(value);
    }

		return t;
	}

}
