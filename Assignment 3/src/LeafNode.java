import java.util.List;

/**
 * Class to represent the leaf node.
 */
public class LeafNode extends Node {

  /**
   * Constructor to initialize the Leaf Node.
   *
   * @param points Points to be initialised in the node.
   * @param left   Left child.
   * @param right  Right child.
   */
  public LeafNode(List<Point2D> points, Node left, Node right) {
    super(points, left, right);
    assert (this.nodes.size() == 1);
  }

  /**
   * Override the function isLeafNode to return true.
   *
   * @return True (boolean).
   */
  @Override
  protected boolean isLeafNode() {
    return true;
  }

  /**
   * Override the to string function.
   *
   * @return Non-Leaf node in string format.
   */
  @Override
  public String toString() {
    String s = "Leaf Node:{" + this.nodes + "}";
    s += ";left:{" + this.left + "}";
    s += ";right:{" + this.right + "}";
    return s;
  }
}
