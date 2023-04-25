package lookandsay;

import java.math.BigInteger;

/**
 * Class to initialize a linked list.
 */
public class LinkedList {
  private BigInteger val;
  private LinkedList prev;
  private LinkedList next;

  /**
   * Constructor where the object is created with a value.
   * @param val initial value
   */
  public LinkedList(BigInteger val) {
    this.val = val;
    this.prev = null;
    this.next = null;
  }

  /**
   * Set the previous node.
   * @param prev previous linkedlist node.
   */
  public void setPrev(LinkedList prev) {
    this.prev = prev;
  }

  /**
   * Get the previous node.
   * @return linkedlist node.
   */
  public LinkedList getPrev() {
    return this.prev;
  }

  /**
   * Set the next node.
   * @param next next linkedlist node.
   */
  public void setNext(LinkedList next) {
    this.next = next;
  }

  /**
   * get the next node.
   * @return linkedlist node.
   */
  public LinkedList getNext() {
    return this.next;
  }

  /**
   * Get the value of the current node.
   * @return value in biginteger
   */
  public BigInteger getValue() {
    return this.val;
  }

}
