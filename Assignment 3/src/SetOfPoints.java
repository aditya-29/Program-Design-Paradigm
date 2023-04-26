import java.util.List;

/**
 * Interface to implement the SetOfPoints.
 */
public interface SetOfPoints {

  /**
   * Method to add a point to the list of points.
   *
   * @param point The point to be added.
   */
  void add(Point2D point);

  /**
   * Method to get the availble list of points.
   *
   * @return Returns the points in the form of list.
   */
  List<Point2D> getPoints();

  /**
   * Method to return all the points within the circle.
   *
   * @param center Center of the circle.
   * @param radius Radius of the circle.
   * @return List of points within the circle.
   */
  List<Point2D> allPointsWithinCircle(Point2D center, double radius);

  /**
   * Method to return the closed point from the given point.
   *
   * @param point Input point.
   * @return Closest point.
   */
  Point2D closestPoint(Point2D point);
}
