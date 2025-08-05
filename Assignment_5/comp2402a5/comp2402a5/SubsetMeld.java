package comp2402a5;
/*
 * author: Alexa Sharp
 */

public interface SubsetMeld {
  /*
   * Return whether x and y are in the same subset.
   */
  public boolean same(int x, int y);

  /*
   * Merge the subsets that contain x and y.
   */
  public void meld(int x, int y);

  /*
   * Return the number of elements.
   */
  public int size();

  /*
   * Return the number of subsets.
   */
  public int numSubsets();
}
