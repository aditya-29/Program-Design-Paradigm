import java.util.NoSuchElementException;

/**
 * This class represents a Rectangle. A rectangle consist of x, y, width and height.
 */
public class Rectangle {

  private int xMin;
  private int yMin;
  private int width;
  private int height;
  private int xMax;
  private int yMax;

  /**
   * Construct a Rectangle object that has the provided x, y, width and height.
   *
   * @param x      x co-ordinate of the rectangle.
   * @param y      y co-ordinate of the rectangle.
   * @param width  width of the rectangle.
   * @param height height of the rectangle.
   */

  public Rectangle(int x, int y, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width or Height is/are not valid!");
    }
    this.xMin = x;
    this.yMin = y;
    this.width = width;
    this.height = height;
    this.xMax = x + width;
    this.yMax = y + height;
  }

  /**
   * Return the co-ordinates of the
   * given rectangle.
   *
   * @param s input string which consist of informtion about the rectangle.
   * @return int array consisting of x, y, width and height.
   */

  private int[] getValues(String s) {
    String[] strArr = s.split(", ", 0);
    int[] arr = new int[4];

    for (int i = 0; i < strArr.length; i++) {
      arr[i] = Integer.parseInt(strArr[i].split(":")[1]);
    }
    return arr;
  }

  /**
   * Method function used to check whether the given rectangle overlaps the current rectangle.
   *
   * @param other Rectangle to check whether it overlaps the current rectangle.
   * @return Boolean value indicating overlapping or not.
   */

  public boolean overlap(Rectangle other) {
    int[] arr = getValues(other.toString());

    boolean widthIsPositive = Math.min(arr[2] + arr[0], xMax) > Math.max(arr[0], xMin);
    boolean heightIsPositive = Math.min(arr[3] + arr[1], yMax) > Math.max(arr[1], yMin);
    return (widthIsPositive && heightIsPositive);
  }

  /**
   * Method function to return the intersecting portion of two rectangles.
   *
   * @param other Other rectangle to check the intersecting portion.
   * @return Return a rectangle object consisting of the intersecting portion.
   */

  public Rectangle intersect(Rectangle other) {
    int[] arr = getValues(other.toString());

    if (!this.overlap(other)) {
      throw new NoSuchElementException("The given objects are not intersecting");
    }

    int newXMin = Math.max(xMin, arr[0]);
    int newYMin = Math.max(yMin, arr[1]);

    int newXMax = Math.min(xMax, arr[0] + arr[2]);
    int newYMax = Math.min(yMax, arr[1] + arr[3]);

    Rectangle intersectRectangle = new Rectangle(newXMin, newYMin, newXMax - newXMin,
        newYMax - newYMin);
    return intersectRectangle;
  }

  /**
   * Method function to return the union of both rectangles.
   *
   * @param other Other rectangle which is used to form the union with the current rectangle.
   * @return Return a rectangle object consisting of union of both rectangles.
   */
  public Rectangle union(Rectangle other) {
    int[] arr = getValues(other.toString());
    int newXMin = Math.min(xMin, arr[0]);
    int newYMin = Math.min(yMin, arr[1]);

    int newXMax = Math.max(xMax, arr[0] + arr[2]);
    int newYMax = Math.max(yMax, arr[1] + arr[3]);

    Rectangle unionRectangle = new Rectangle(newXMin, newYMin, newXMax - newXMin,
        newYMax - newYMin);
    return unionRectangle;
  }

  /**
   * Method function to print the rectangle object.
   *
   * @return String consisting of x, y, width and height.
   */

  @Override
  public String toString() {
    String s = String.format("x:%d, y:%d, w:%d, h:%d", xMin, yMin, width, height);
    return s;
  }
}
