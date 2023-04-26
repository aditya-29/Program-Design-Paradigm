import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Class to test various unit test cases for the pointKD tree.
 */
public class PointKDTreeTest {

  public PointKDTree tree;

  /**
   * Test case to check the build function.
   */
  @Test
  public void buildTest3() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(0, 1));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(1, 2), (1, 1)]};left:{Leaf Node:{[(0, 1)]};left:"
        + "{null};right:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to check the closest neighbours.
   */
  @Test
  public void closestNeighbours1() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(5, 23));
    ps.add(new Point2D(6, 28));
    ps.add(new Point2D(8, 24));
    ps.add(new Point2D(10, 28));
    ps.add(new Point2D(9, 26));
    ps.add(new Point2D(10, 30));
    ps.add(new Point2D(7, 22));

    ps.add(new Point2D(9, 18));
    ps.add(new Point2D(6, 24));
    ps.add(new Point2D(8, 32));
    ps.add(new Point2D(10, 28));
    ps.add(new Point2D(9, 20));
    ps.add(new Point2D(7, 32));
    ps.add(new Point2D(7, 27));

    ps.add(new Point2D(18, 30));
    ps.add(new Point2D(11, 22));
    ps.add(new Point2D(17, 31));
    ps.add(new Point2D(13, 28));
    ps.add(new Point2D(16, 24));
    ps.add(new Point2D(19, 26));
    ps.add(new Point2D(10, 28));

    ps.add(new Point2D(14, 27));
    ps.add(new Point2D(18, 23));
    ps.add(new Point2D(17, 22));
    ps.add(new Point2D(18, 24));

    tree = new PointKDTree(ps);
    System.out.println(tree);

    System.out.println(tree.allPointsWithinCircle(new Point2D(2, 2), 24));
    assertEquals(new Point2D(9, 18), tree.closestPoint(new Point2D(10, -10)));
  }

  /**
   * Test case to check the closest point using fuzzy testing.
   */
  @Test
  public void fuzzyTestClosestPoint() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(5, 23));
    ps.add(new Point2D(6, 28));
    ps.add(new Point2D(8, 24));
    ps.add(new Point2D(10, 28));
    ps.add(new Point2D(9, 26));
    ps.add(new Point2D(10, 30));
    ps.add(new Point2D(7, 22));

    ps.add(new Point2D(9, 18));
    ps.add(new Point2D(6, 24));
    ps.add(new Point2D(8, 32));
    ps.add(new Point2D(10, 28));
    ps.add(new Point2D(9, 20));
    ps.add(new Point2D(7, 32));
    ps.add(new Point2D(7, 27));

    ps.add(new Point2D(18, 30));
    ps.add(new Point2D(11, 22));
    ps.add(new Point2D(17, 31));
    ps.add(new Point2D(13, 28));
    ps.add(new Point2D(16, 24));
    ps.add(new Point2D(19, 26));
    ps.add(new Point2D(10, 28));

    ps.add(new Point2D(14, 27));
    ps.add(new Point2D(18, 23));
    ps.add(new Point2D(17, 22));
    ps.add(new Point2D(18, 24));

    tree = new PointKDTree(ps);
    System.out.println(tree);

    assertEquals(new Point2D(9, 18), tree.closestPoint(new Point2D(-10, -10)));
    assertEquals(new Point2D(5, 23), tree.closestPoint(new Point2D(-10, 10)));
    assertEquals(new Point2D(6, 28), tree.closestPoint(new Point2D(-10, 30)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 50)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 70)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 90)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 110)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 130)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 150)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 170)));
    assertEquals(new Point2D(7, 32), tree.closestPoint(new Point2D(-10, 190)));
    assertEquals(new Point2D(9, 18), tree.closestPoint(new Point2D(10, -10)));
    assertEquals(new Point2D(9, 18), tree.closestPoint(new Point2D(10, 10)));
    assertEquals(new Point2D(10, 30), tree.closestPoint(new Point2D(10, 30)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 50)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 70)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 90)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 110)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 130)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 150)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 170)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(10, 190)));
    assertEquals(new Point2D(17, 22), tree.closestPoint(new Point2D(30, -10)));
    assertEquals(new Point2D(17, 22), tree.closestPoint(new Point2D(30, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(30, 30)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 50)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 70)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 90)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 110)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(30, 170)));
    assertEquals(new Point2D(8, 32), tree.closestPoint(new Point2D(30, 190)));
    assertEquals(new Point2D(17, 22), tree.closestPoint(new Point2D(50, -10)));
    assertEquals(new Point2D(18, 23), tree.closestPoint(new Point2D(50, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(50, 30)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(50, 50)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 70)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 90)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 110)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(50, 190)));
    assertEquals(new Point2D(18, 23), tree.closestPoint(new Point2D(70, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(70, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(70, 30)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(70, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(70, 70)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 90)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 110)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(70, 190)));
    assertEquals(new Point2D(18, 23), tree.closestPoint(new Point2D(90, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(90, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(90, 30)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(90, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(90, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(90, 90)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(90, 110)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(90, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(90, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(90, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(90, 190)));
    assertEquals(new Point2D(18, 23), tree.closestPoint(new Point2D(110, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(110, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(110, 30)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(110, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(110, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(110, 90)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(110, 110)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(110, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(110, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(110, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(110, 190)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(130, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(130, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(130, 30)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(130, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(130, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(130, 90)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(130, 110)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(130, 130)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(130, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(130, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(130, 190)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(150, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(150, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(150, 30)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(150, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(150, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(150, 90)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(150, 110)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(150, 130)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(150, 150)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(150, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(150, 190)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(170, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(170, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(170, 30)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(170, 50)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 90)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 110)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 130)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 150)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(170, 170)));
    assertEquals(new Point2D(17, 31), tree.closestPoint(new Point2D(170, 190)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(190, -10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(190, 10)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(190, 30)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(190, 50)));
    assertEquals(new Point2D(19, 26), tree.closestPoint(new Point2D(190, 70)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 90)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 110)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 130)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 150)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 170)));
    assertEquals(new Point2D(18, 30), tree.closestPoint(new Point2D(190, 190)));
  }


  /**
   * Test case to check the build function.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBT0() {
    List<Point2D> ps = null;
    tree = new PointKDTree(ps);
  }

  /**
   * Test case to check the build function with one node in the tree.
   */
  @Test
  public void testBT1() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));

    tree = new PointKDTree(ps);
    String out = "Leaf Node:{[(3, 3)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to check with one node with multiple values in the tree.
   */
  @Test
  public void testBT2() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 5));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3), (3, 5)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with no nodes.
   */
  @Test(expected = NullPointerException.class)
  public void testBT3() {
    List<Point2D> ps = new ArrayList<>();

    tree = new PointKDTree(ps);
    String out = "";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT4() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 5));
    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(4, 5));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3), (3, 5)]};left:{Leaf Node:{[(1, 2)]};left:{null};"
        + "right:{null}};right:{Leaf Node:{[(4, 5)]};left:{null};right:{null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT5() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 5));
    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(1, 10));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3), (3, 5)]};left:{Non-Leaf Node:{[(1, 10)]};left:"
        + "{Leaf Node:{[(1, 2)]};left:{null};right:{null}};right:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT6() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 5));
    ps.add(new Point2D(4, 10));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3), (3, 5)]};left:{null};right:{Leaf Node:{[(4, 10)]}"
        + ";left:{null};right:{null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT7() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(1, 10));
    ps.add(new Point2D(5, 10));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(1, 10)]};left:{null};right:{null}};r"
        + ""
        + "ight:{Leaf Node:{[(5, 10)]};left:{null};right:{null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBT8() {
    List<Point2D> ps = new ArrayList<>();
    Point2D p = null;
    ps.add(p);
    ps.add(p);

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(1, 10)]};left:{null};right:{null}}"
        + ";right:{Leaf Node:{[(5, 10)]};left:{null};right:{null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with no nodes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBT9() {
    List<Point2D> ps = null;
    tree = new PointKDTree(ps);
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT10() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 10));
    ps.add(new Point2D(3, 10));
    ps.add(new Point2D(4, 10));
    ps.add(new Point2D(4, 6));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(4, 10), (4, 6)]};left:{Non-Leaf Node:{[(3, 10), (3, 10)]};l"
        + "eft:{null};right:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to create a build tree with muliple nodes.
   */
  @Test
  public void testBT11() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(1, 3));
    ps.add(new Point2D(1, 4));
    ps.add(new Point2D(1, 5));

    tree = new PointKDTree(ps);

    String out = "Non-Leaf Node:{[(1, 1), (1, 2), (1, 3), (1, 4), (1, 5)]};left:{null}"
        + ";right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */

  @Test
  public void testAdd1() {
    List<Point2D> ps = new ArrayList<>();
    tree = new PointKDTree(ps);

    tree.add(new Point2D(3, 3));
    String out = "Leaf Node:{[(3, 3)]};left:{null};right:{null}";

    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */

  @Test
  public void testAdd2() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    tree = new PointKDTree(ps);

    tree.add(new Point2D(4, 10));
    String out = "Non-Leaf Node:{[(3, 3)]};left:{null};right:{Leaf Node:{[(4, 10)]};lef"
        + "t:{null};right:{null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd3() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 6));

    tree = new PointKDTree(ps);

    tree.add(new Point2D(2, 10));
    String out = "Non-Leaf Node:{[(3, 3), (3, 6)]};left:{Leaf Node:{[(2, 10)]};left:{n"
        + "ull};right:{null}};right:{null}";
    assertEquals(out, tree.toString());

  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd4() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 6));
    ps.add(new Point2D(2, 10));

    tree = new PointKDTree(ps);

    tree.add(new Point2D(4, 10));
    String out = "Non-Leaf Node:{[(3, 3), (3, 6)]};left:{Leaf Node:{[(2, 10)]};left:{null};rig"
        + "ht:{null}};right:{Leaf Node:{[(4, 10)]};left:{null};right:{null}}";

    assertEquals(out, tree.toString());

  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd5() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 6));
    ps.add(new Point2D(2, 10));
    ps.add(new Point2D(4, 10));

    tree = new PointKDTree(ps);

    tree.add(new Point2D(3, 3));
    String out = "Non-Leaf Node:{[(3, 3), (3, 6), (3, 3)]};left:{Leaf Node:{[(2, 10)]};left:"
        + "{null};right:{null}};right:{Leaf Node:{[(4, 10)]};left:{null};right:{null}}";

    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd6() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(3, 4));
    ps.add(new Point2D(3, 5));

    tree = new PointKDTree(ps);
    tree.add(new Point2D(3, 10));
    String out = "Non-Leaf Node:{[(3, 3), (3, 4), (3, 5), (3, 10)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree one by one.
   */
  @Test
  public void testAdd7() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));

    tree = new PointKDTree(ps);
    String out = "Leaf Node:{[(3, 3)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(2, 5));
    out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(2, 5)]};left:{null};right:{null}};"
        + "right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(2, 4));
    out = "Non-Leaf Node:{[(3, 3)]};left:{Non-Leaf Node:{[(2, 5)]};left:{Leaf Node:{[(2,"
        + ""
        + " 4)]};left:{null};right:{null}};right:{null}};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(1, 4));
    out = "Non-Leaf Node:{[(3, 3)]};left:{Non-Leaf Node:{[(2, 5)]};left:{Non-Lea"
        + "f Node:{[(2, 4)]};left:{Leaf Node:{[(1, 4)]};left:{null};right:{null}};right:{null}};"
        + "right:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd8() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(2, 5));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(2, 5)]};left:{null};right:{nu"
        + "ll}};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(2, 5));
    out = "Non-Leaf Node:{[(3, 3)]};left:{Non-Leaf Node:{[(2, 5), (2, 5)]};left:{null};ri"
        + "ght:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */

  @Test
  public void testAdd9() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(2, 5));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(2, 5)]};left:{null};right:"
        + "{null}};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(3, 3));
    out = "Non-Leaf Node:{[(3, 3), (3, 3)]};left:{Leaf Node:{[(2, 5)]};left:{null};righ"
        + "t:{null}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAdd10() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(2, 5));

    tree = new PointKDTree(ps);
    String out = "Non-Leaf Node:{[(3, 3)]};left:{Leaf Node:{[(2, 5)]};left:{null};right:{nul"
        + "l}};right:{null}";
    assertEquals(out, tree.toString());

    Point2D p = null;
    tree.add(p);
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd11() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 0));
    ps.add(new Point2D(-1, -1));
    ps.add(new Point2D(1, -1));
    ps.add(new Point2D(-2, -1));
    ps.add(new Point2D(-2, 1));

    tree = new PointKDTree(ps);

    String out = "Non-Leaf Node:{[(-1, -1)]};left:{Non-Leaf Node:{[(-2, 1)]};left:{Leaf Node:{[(-"
        + "2, -1)]};left:{null};right:{null}};right:{null}};right:{Non-Leaf Node:{[(0, 0)]};left"
        + ":{Leaf Node:{[(1, -1)]};left:{null};right:{null}};right:{null}}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(1, -1));
    out = "Non-Leaf Node:{[(-1, -1)]};left:{Non-Leaf Node:{[(-2, 1)]};left:{Leaf Node:{[(-2, -1"
        + ")]};left:{null};right:{null}};right:{null}};right:{Non-Leaf Node:{[(0, 0)]};left:{Non-"
        + "Leaf Node:{[(1, -1), (1, -1)]};left:{null};right:{null}};right:{null}}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(-2, -1));
    out = "Non-Leaf Node:{[(-1, -1)]};left:{Non-Leaf Node:{[(-2, 1)]};left:{Non-Leaf Node:{[(-"
        + "2, -1), (-2, -1)]};left:{null};right:{null}};right:{null}};right:{Non-Leaf Node:{[("
        + "0, 0)]};left:{Non-Leaf Node:{[(1, -1), (1, -1)]};left:{null};right:{null}};right:{"
        + "null}}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAdd12() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 0));

    tree = new PointKDTree(ps);

    String out = "Leaf Node:{[(0, 0)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());

    Point2D p = null;
    tree.add(p);
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd13() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 0));

    tree = new PointKDTree(ps);
    String out = "Leaf Node:{[(0, 0)]};left:{null};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(-1, 5));
    out = "Non-Leaf Node:{[(0, 0)]};left:{Leaf Node:{[(-1, 5)]};left:{null};right:{null"
        + "}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to add a node to the tree.
   */
  @Test
  public void testAdd14() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 0));

    tree = new PointKDTree(ps);

    tree.add(new Point2D(-2, 5));
    String out = "Non-Leaf Node:{[(0, 0)]};left:{Leaf Node:{[(-2, 5)]};left:{null};right"
        + ":{null}};right:{null}";
    assertEquals(out, tree.toString());

    tree.add(new Point2D(-1, 6));
    out = "Non-Leaf Node:{[(0, 0)]};left:{Non-Leaf Node:{[(-2, 5)]};left:{null};rig"
        + "ht:{Leaf Node:{[(-1, 6)]};left:{null};right:{null}}};right:{null}";
    assertEquals(out, tree.toString());
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP1() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(2, 5));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(1, 1)).toString();
    String ref = new Point2D(2, 5).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP2() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(2, 5));
    ps.add(new Point2D(7, 6));
    ps.add(new Point2D(3, 1));
    ps.add(new Point2D(9, 8));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(5, 2)).toString();
    String ref = new Point2D(3, 1).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP3() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(2, 5));
    ps.add(new Point2D(7, 6));
    ps.add(new Point2D(3, 1));
    ps.add(new Point2D(9, 8));
    ps.add(new Point2D(4, 7));
    ps.add(new Point2D(8, 3));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(5, 2)).toString();
    String ref = new Point2D(3, 1).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP4() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(2, 2));
    ps.add(new Point2D(4, 4));
    ps.add(new Point2D(0, 5));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(3, 3)).toString();
    String ref = new Point2D(2, 2).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP5() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(3, 2));
    ps.add(new Point2D(2, 2));
    ps.add(new Point2D(2, 4));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(2, 3)).toString();
    String ref = new Point2D(2, 2).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP6_1() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(-2, -3));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(3, -1));
    ps.add(new Point2D(5, 1));
    ps.add(new Point2D(6, -2));
    ps.add(new Point2D(8, 6));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(0, 0)).toString();
    String ref = new Point2D(0, 2).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP6_2() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(-2, -3));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(3, -1));
    ps.add(new Point2D(5, 1));
    ps.add(new Point2D(6, -2));
    ps.add(new Point2D(8, 6));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(-2, -2)).toString();
    String ref = new Point2D(-2, -3).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP6_3() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(-2, -3));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(3, -1));
    ps.add(new Point2D(5, 1));
    ps.add(new Point2D(6, -2));
    ps.add(new Point2D(8, 6));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(4, 1)).toString();
    String ref = new Point2D(5, 1).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP6_4() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(-2, -3));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(3, -1));
    ps.add(new Point2D(5, 1));
    ps.add(new Point2D(6, -2));
    ps.add(new Point2D(8, 6));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(3, -1)).toString();
    String ref = new Point2D(3, -1).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP6_5() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(-2, -3));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(3, -1));
    ps.add(new Point2D(5, 1));
    ps.add(new Point2D(6, -2));
    ps.add(new Point2D(8, 6));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(0, 0)).toString();
    String ref = new Point2D(0, 2).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCP7() {
    List<Point2D> ps = new ArrayList<>();

    tree = new PointKDTree(ps);
    String p = tree.closestPoint(new Point2D(3, 3)).toString();
    String ref = new Point2D(0, 2).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP8() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 5));
    ps.add(new Point2D(1, 7));
    ps.add(new Point2D(1, 10));
    ps.add(new Point2D(0, 10));
    ps.add(new Point2D(0, 2));
    ps.add(new Point2D(3, 5));
    ps.add(new Point2D(3, 9));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(3, 6)).toString();
    String ref = new Point2D(3, 5).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP9() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 3));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(100, 100)).toString();
    String ref = new Point2D(3, 3).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP10() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 0));

    tree = new PointKDTree(ps);

    tree.add(new Point2D(2, 0));
    tree.add(new Point2D(3, 0));
    tree.add(new Point2D(4, 0));
    tree.add(new Point2D(5, 0));

    String p = tree.closestPoint(new Point2D(3, 3)).toString();
    String ref = new Point2D(3, 0).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP11() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(3, 4));
    ps.add(new Point2D(5, 6));
    ps.add(new Point2D(7, 8));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(10, 10)).toString();
    String ref = new Point2D(7, 8).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find the closest point in the tree.
   */
  @Test
  public void testCP12() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(3, 4));
    ps.add(new Point2D(3, 4));
    ps.add(new Point2D(7, 8));

    tree = new PointKDTree(ps);

    String p = tree.closestPoint(new Point2D(3, 3)).toString();
    String ref = new Point2D(3, 4).toString();
    assertEquals(ref, p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCircle1() {
    List<Point2D> ps = new ArrayList<>();
    Point2D center = new Point2D(0, 0);
    double radius = 5.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle2() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(3, 4));
    Point2D center = new Point2D(3, 4);
    double radius = 5.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(3, 4));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle3() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(3, 4));
    ps.add(new Point2D(0, 1));
    ps.add(new Point2D(-1, -1));
    ps.add(new Point2D(5, 5));
    ps.add(new Point2D(-3, 2));

    Point2D center = new Point2D(0, 0);
    double radius = 3.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 1));
    ref.add(new Point2D(-1, -1));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle4() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(2, 2));
    ps.add(new Point2D(4, 4));
    ps.add(new Point2D(6, 6));
    ps.add(new Point2D(8, 8));

    Point2D center = new Point2D(0, 0);
    double radius = 2.5;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle5() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 3));
    ps.add(new Point2D(0, -3));
    ps.add(new Point2D(3, 0));
    ps.add(new Point2D(-3, 0));

    Point2D center = new Point2D(0, 0);
    double radius = 3.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 3));
    ref.add(new Point2D(0, -3));
    ref.add(new Point2D(-3, 0));
    ref.add(new Point2D(3, 0));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle6() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 3));
    ps.add(new Point2D(0, -3));
    ps.add(new Point2D(3, 0));
    ps.add(new Point2D(-3, 0));
    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(-1, -1));

    Point2D center = new Point2D(0, 0);
    double radius = 3.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 3));
    ref.add(new Point2D(0, -3));
    ref.add(new Point2D(-3, 0));
    ref.add(new Point2D(-1, -1));
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(3, 0));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle7() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 3));
    ps.add(new Point2D(0, -3));
    ps.add(new Point2D(3, 0));
    ps.add(new Point2D(-3, 0));
    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(-1, -1));

    Point2D center = new Point2D(0, 0);
    double radius = 3.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 3));
    ref.add(new Point2D(0, -3));
    ref.add(new Point2D(-3, 0));
    ref.add(new Point2D(-1, -1));
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(3, 0));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle8() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(-1, -1));
    ps.add(new Point2D(2, -2));
    ps.add(new Point2D(-2, 2));

    Point2D center = new Point2D(0, 0);
    double radius = 2.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(-1, -1));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle9() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(5, 5));

    Point2D center = new Point2D(0, 0);
    double radius = 2.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle10() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(-1, -1));
    ps.add(new Point2D(2, -2));
    ps.add(new Point2D(-2, 2));

    Point2D center = new Point2D(0, 0);
    double radius = 2.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(-1, -1));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle11() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));

    Point2D center = new Point2D(0, 0);
    double radius = 5.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 5));
    ref.add(new Point2D(0, -5));
    ref.add(new Point2D(-5, 0));
    ref.add(new Point2D(5, 0));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle12() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));
    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(2, 2));
    ps.add(new Point2D(3, 3));

    Point2D center = new Point2D(0, 0);
    double radius = 3.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(2, 2));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle13() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(1, 1));
    ps.add(new Point2D(2, 2));
    ps.add(new Point2D(3, 3));
    ps.add(new Point2D(4, 4));
    ps.add(new Point2D(5, 5));
    ps.add(new Point2D(10, 10));
    ps.add(new Point2D(20, 20));

    Point2D center = new Point2D(-2, -2);
    double radius = 7.0;
    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(2, 2));
    ref.add(new Point2D(1, 1));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle14() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));

    Point2D center = new Point2D(0, 0);
    double radius = 4.999999;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCircle15() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));

    Point2D center = new Point2D(0, 0);
    double radius = -1;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(4, 4));
    ref.add(new Point2D(2, 2));
    ref.add(new Point2D(1, 1));
    ref.add(new Point2D(3, 3));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle16() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));

    Point2D center = new Point2D(0, 0);
    double radius = 0.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a circle..
   */
  @Test
  public void testCircle17() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));
    ps.add(new Point2D(0, 0));

    Point2D center = new Point2D(0, 0);
    double radius = 0.0;

    tree = new PointKDTree(ps);

    String p = tree.allPointsWithinCircle(center, radius).toString();
    List<Point2D> ref = new ArrayList<>();
    ref.add(new Point2D(0, 0));

    assertEquals(ref.toString(), p);
  }

  /**
   * Test case to find all the points inside a tree.
   */
  @Test
  public void testGetPoints1() {
    List<Point2D> ps = new ArrayList<>();

    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, -5));
    ps.add(new Point2D(-5, 0));
    ps.add(new Point2D(0, 0));

    tree = new PointKDTree(ps);


    assertEquals("[(-5, 0), (0, 5), (0, -5), (0, 0"
        + "), (5, 0)]", tree.getPoints().toString());
  }

  /**
   * Test case to find all the points inside a tree.
   */
  @Test
  public void testGetPoints2() {
    List<Point2D> ps = new ArrayList<>();
    tree = new PointKDTree(ps);

    assertEquals("[]", tree.getPoints().toString());
  }

  /**
   * Test case to find all the points inside a tree.
   */
  @Test
  public void testGetPoints3() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    ps.add(new Point2D(0, 5));
    ps.add(new Point2D(5, 0));
    tree = new PointKDTree(ps);

    assertEquals("[(0, 5), (0, 5), (0, 5), (5, 0), (5, 0), (5, 0)]", tree.getPoints().toString());
  }

  @Test
  public void testGetPoints4() {
    List<Point2D> ps = new ArrayList<>();
    ps.add(new Point2D(2, 3));
    ps.add(new Point2D(1, 2));
    ps.add(new Point2D(4, 5));
    ps.add(new Point2D(6, 8));
    ps.add(new Point2D(-1, 5));
    ps.add(new Point2D(-0, 4));
    ps.add(new Point2D(2, 8));

    tree = new PointKDTree(ps);
    System.out.println(tree.toString());

    assertEquals("[(0, 5), (0, 5), (0, 5), (5, 0), (5, 0), (5, 0)]", tree.getPoints().toString());
  }
}
