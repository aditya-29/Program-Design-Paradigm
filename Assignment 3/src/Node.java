import java.util.ArrayList;
import java.util.List;

/**
 * Class to define the Node.
 */
public class Node {

  protected List<Point2D> nodes;
  protected Node left;
  protected Node right;

  /**
   * Constructor to initialize the Node.
   *
   * @param points Points to be stored in the node.
   * @param left   contains the left node.
   * @param right  contains the right node.
   */
  public Node(List<Point2D> points, Node left, Node right) {
    this.nodes = new ArrayList<>(points);
    this.left = left;
    this.right = right;
  }

  /**
   * Return the result for is leaf node query.
   *
   * @return return False.
   */
  protected boolean isLeafNode() {
    return false;
  }

  /**
   * Return the resylt for is non-leaf node query.
   *
   * @return return False.
   */
  protected boolean isNonLeafNode() {
    return false;
  }
}
