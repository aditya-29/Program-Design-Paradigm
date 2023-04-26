import java.util.List;

/**
 * Ckass to represent the non leaf node.
 */
public class NonLeafNode extends Node {

  /**
   * Constructor to initialize the NonLeaf Node.
   *
   * @param points Points to be initialised in the node.
   * @param left   Left child.
   * @param right  Right child.
   */
  public NonLeafNode(List<Point2D> points, Node left, Node right) {
    super(points, left, right);
  }

  /**
   * Override the function isNonLeafNode to return true.
   *
   * @return True (boolean).
   */
  @Override
  protected boolean isNonLeafNode() {
    return true;
  }

  /**
   * Override the to string function.
   *
   * @return Non-Leaf node in string format.
   */
  @Override
  public String toString() {
    String s = "Non-Leaf Node:{" + this.nodes + "}";
    s += ";left:{" + this.left + "}";
    s += ";right:{" + this.right + "}";
    return s;
  }
}
