import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class to implement the KD tree.
 */
public class PointKDTree implements SetOfPoints {

  private Node head;

  /**
   * Constructor to get the list of points.
   *
   * @param points List of points to be added.
   */
  public PointKDTree(List<Point2D> points) {
    if (points == null) {
      throw new IllegalArgumentException("The given list is null");
    }

    if (points.contains(null)) {
      throw new IllegalArgumentException("The given list has null in it");
    }

    int depth = 0;
    int threshold = 1;
    List<Point2D> pointsX = new ArrayList<>(sort(points, 0));
    List<Point2D> pointsY = new ArrayList<>(sort(points, 1));
    this.head = buildTreeHelper(points, pointsX, pointsY, threshold, depth);
  }

  /**
   * Method to print the tree in string format.
   *
   * @return return the tree in string format.
   */
  @Override
  public String toString() {
    return this.head.toString();
  }

  /**
   * Private method to find the median.
   *
   * @param points input points to find the median.
   * @return Point in the median position.
   */
  private Point2D findMedian(List<Point2D> points) {
    int res = (points.size()) / 2;
    return points.get(res);
  }

  /**
   * Private method to get the node at a particular index.
   *
   * @param pointsIndex input the sorted pointsindex.
   * @return LeafNode leafnode to be returned.
   */
  private Node getNode(List<Point2D> pointsIndex) {
    List<Point2D> nodes = new ArrayList<>();
    if (pointsIndex.size() == 0) {
      return null;
    }
    nodes.add(pointsIndex.get(0));
    return new LeafNode(nodes, null, null);
  }

  /**
   * Private method to find the squared distance.
   *
   * @param P      point.
   * @param aValue value of ax.
   * @param bValue value of by.
   * @param cValue value of intercept.
   * @return distance in double type.
   */
  private double signedDistance(Point2D p, int aValue, int bValue, int cValue) {
    return (aValue * p.get(0)) + (bValue * p.get(1)) + cValue;
  }

  /**
   * Private method to sort the input array.
   *
   * @param points input points.
   * @param key    key to determine the sort format.
   * @return Sorted version of the List of points.
   */
  private List<Point2D> sort(List<Point2D> points, int key) {
    points.sort(
        Comparator.comparingInt((Point2D h) -> h.get(key)));
    return points;
  }


  /**
   * Helper method to build the KD tree from a set of points.
   *
   * @param points    Input points.
   * @param pointsX   Points sorted based on x axis.
   * @param pointsY   Points sorted based on y axis.
   * @param threshold threshold point based on the size of the array.
   * @param depth     Depth of the tree.
   * @return Head of the kd tree.
   */
  private Node buildTreeHelper(List<Point2D> points,
      List<Point2D> pointsX,
      List<Point2D> pointsY,
      int threshold,
      int depth) {

    int aValue;
    int bValue;
    int cValue;
    int median;
    if (depth % 2 == 0 && pointsX.size() <= threshold) {
      return getNode(pointsX);
    }

    if (depth % 2 != 0 && pointsY.size() <= threshold) {
      return getNode(pointsY);
    }

    if (depth % 2 == 0) {
      median = findMedian(pointsX).get(0);
      aValue = 1;
      bValue = 0;
    } else {
      median = findMedian(pointsY).get(1);
      aValue = 0;
      bValue = 1;
    }
    cValue = -median;

    List<Point2D> on = new ArrayList<>();
    List<Point2D> pointsXBefore = new ArrayList<>();
    List<Point2D> pointsXAfter = new ArrayList<>();

    List<Point2D> pointsYBefore = new ArrayList<>();
    List<Point2D> pointsYAfter = new ArrayList<>();

    for (Point2D i : pointsX) {
      double sd = signedDistance(i, aValue, bValue, cValue);

      if (sd < 0) {
        pointsXBefore.add(i);
      } else if (sd > 0) {
        pointsXAfter.add(i);
      } else if (depth % 2 == 0) {
        on.add(i);
      }
    }

    for (Point2D i : pointsY) {
      double sd = signedDistance(i, aValue, bValue, cValue);

      if (sd < 0) {
        pointsYBefore.add(i);
      } else if (sd > 0) {
        pointsYAfter.add(i);
      } else if (depth % 2 != 0) {
        on.add(i);
      }

    }

    Node left = buildTreeHelper(points, pointsXBefore, pointsYBefore, threshold, depth + 1);
    Node right = buildTreeHelper(points, pointsXAfter, pointsYAfter, threshold, depth + 1);

    if (left == null && right == null && on.size() == 1) {
      return new LeafNode(on, null, null);
    }
    return new NonLeafNode(on, left, right);
  }

  /**
   * Method to add a point to the KD tree.
   *
   * @param point The point to be added.
   */
  public void add(Point2D point) {
    if (point == null) {
      throw new IllegalArgumentException("Please enter a valid number");
    }
    this.head = addHelper(point, this.head, 0);
  }


  /**
   * Helper method to add a point to the KD tree.
   *
   * @param point Point to be added.
   * @param head  Head of the node.
   * @param depth depth of the tree.
   * @return
   */
  private Node addHelper(Point2D point, Node head, int depth) {
    if (head == null) {
      List<Point2D> points = new ArrayList<>();
      points.add(point);
      head = new LeafNode(points, null, null);
      return head;
    }
    int key;
    if (depth % 2 == 0) {
      key = 0;
    } else {
      key = 1;
    }

    if (head.nodes.get(0).get(key) > point.get(key)) {
      if (head.left != null) {
        head.left = addHelper(point, head.left, depth + 1);
      } else {
        List<Point2D> points = new ArrayList<>();
        points.add(point);
        LeafNode leafNode = new LeafNode(points, null, null);
        NonLeafNode newNode = new NonLeafNode(head.nodes, leafNode, head.right);
        head = newNode;
      }
      return head;

    } else if (head.nodes.get(0).get(key) < point.get(key)) {
      if (head.right != null) {
        head.right = addHelper(point, head.right, depth + 1);
      } else {
        List<Point2D> points = new ArrayList<>();
        points.add(point);
        LeafNode rightNode = new LeafNode(points, null, null);
        NonLeafNode newNode = new NonLeafNode(head.nodes, head.left, rightNode);
        head = newNode;
      }
      return head;
    } else {
      if (head.isNonLeafNode()) {
        head.nodes.add(point);
        return head;
      } else {
        NonLeafNode newNode = new NonLeafNode(head.nodes, null, null);
        newNode.nodes.add(point);
        return newNode;
      }
    }
  }

  /**
   * Helper method to get all points in the tree.
   *
   * @param head Root of the tree.
   * @param ans  Final ans to be returned.
   * @return Arraylist consisting of all the points.
   */
  private List<Point2D> getPointsHelper(Node head, List<Point2D> ans) {
    if (head != null) {
      ans = getPointsHelper(head.left, ans);
      ans.addAll(head.nodes);
      ans = getPointsHelper(head.right, ans);
    }
    return ans;
  }

  /**
   * Public method used to get all the points in a KD tree.
   *
   * @return An arraylist consisting of all the points.
   */
  public List<Point2D> getPoints() {
    List<Point2D> ans = new ArrayList<>();
    return getPointsHelper(this.head, ans);
  }

  /**
   * Helper method to search all the points in the circle.
   *
   * @param node               Head node of the tree.
   * @param center             Center of the circle.
   * @param radius             radius of the circle.
   * @param pointsWithinCircle List array consisting of points within the circle.
   * @param depth              depth of the recursive call.
   */
  private void circleSearch(Node node, Point2D center, double radius,
      List<Point2D> pointsWithinCircle, int depth) {
    if (node == null) {
      return;
    }

    for (Point2D currPoint : node.nodes) {
      double dist = currPoint.distance(center);

      if (dist <= radius) {
        pointsWithinCircle.add(currPoint);
      }
    }

    Point2D currPoint = node.nodes.get(0);

    if (depth % 2 == 0) {
      if (center.get(0) - radius <= currPoint.get(0)) {
        circleSearch(node.left, center, radius, pointsWithinCircle, depth + 1);
      }
      if (center.get(0) + radius >= currPoint.get(0)) {
        circleSearch(node.right, center, radius, pointsWithinCircle, depth + 1);
      }
    } else {
      if (center.get(1) - radius <= currPoint.get(1)) {
        circleSearch(node.left, center, radius, pointsWithinCircle, depth + 1);
      }
      if (center.get(1) + radius >= currPoint.get(1)) {
        circleSearch(node.right, center, radius, pointsWithinCircle, depth + 1);
      }
    }
  }

  /**
   * Public method to get all the points within a circle in a KD tree.
   *
   * @param center Center of the circle.
   * @param radius Radius of the circle.
   * @return An Arraylist consisting of all the points in the circle.
   */
  public List<Point2D> allPointsWithinCircle(Point2D center, double radius) {
    List<Point2D> pointsWithinCircle = new ArrayList<>();
    if (head == null) {
      throw new IllegalArgumentException("The tree is empty");
    }
    if (Double.compare(radius, 0.0) < 0) {
      throw new IllegalArgumentException("Radius cannot be negative");
    }
    circleSearch(head, center, radius, pointsWithinCircle, 0);
    return pointsWithinCircle;
  }

  /**
   * Helper function to find the closest point in the tree based on the input point.
   *
   * @param point Input point.
   * @return closest point in the tree.
   */
  private Point2D closestPointHelper(Point2D point) {
    double minDist = Double.MAX_VALUE;
    Point2D ans = null;
    for (Point2D p : this.getPoints()) {
      if (p.distance(point) < minDist) {
        minDist = p.distance(point);
        ans = p;
      }
    }
    return ans;
  }

  /**
   * Public method to get the closest neighbour in the kd tree.
   *
   * @param point Input point.
   * @return Closest point.
   */
  public Point2D closestPoint(Point2D point) {
    return closestPointHelper(point);
  }
}
