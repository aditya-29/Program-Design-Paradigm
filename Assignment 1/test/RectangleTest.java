import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import java.util.NoSuchElementException;

/**
 * A test class to run unit test on the Rectangle implementing tile.
 */

public class RectangleTest {

  private Rectangle r1;
  private Rectangle r2;
  private Rectangle r3;
  private Rectangle r4;
  private Rectangle r5;
  private Rectangle r6;
  private Rectangle r7;
  private Rectangle r8;

  private Rectangle r9;

  private Rectangle r10;

  /**
   * A Before function which initialises the objects necesary for test cases.
   */

  @Before
  public void setUp() {
    r1 = new Rectangle(0, 0, 10, 10);
    r2 = new Rectangle(0, 0, 9, 9);
    r3 = new Rectangle(10, 10, 10, 10);
    r4 = new Rectangle(-1, -1, 11, 11);
    r5 = new Rectangle(2, 2, 6, 6);
    r6 = new Rectangle(-9, -9, 10, 10);
    r7 = new Rectangle(0, -9, 9, 9);
    r8 = new Rectangle(100, 100, 1, 1);
    r9 = new Rectangle(0, 0, 2, 2);
    r10 = new Rectangle(0, 0, 3, 3);
  }

  /**
   * Test case to negative width input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void checkNegativeWidth() {
    Rectangle tile = new Rectangle(0, 0, 0, 10);
  }

  /**
   * Test case to check negative height input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void checkNegativeHeight() {
    Rectangle tile = new Rectangle(0, 0, 10, 0);
  }

  /**
   * Test case to check the inputs when they are valid.
   */
  @Test
  public void checkCorrectInputs() {
    Rectangle tile = new Rectangle(0, 0, 10, 10);
    assertEquals("x:0, y:0, w:10, h:10", tile.toString());
  }

  /**
   * Test case to check toString operation for r1.
   */
  @Test
  public void checkToStringCase1() {
    assertEquals("x:0, y:0, w:10, h:10", r1.toString());
  }

  /**
   * Test case to check toString operation for negative width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void checkToStringCase2() {
    Rectangle tile = new Rectangle(0, 0, 0, 10);
  }

  /**
   * Test case to check toString opeartion for r2.
   */
  @Test
  public void checkToStringCase3() {
    assertEquals("x:0, y:0, w:9, h:9", r2.toString());
  }

  /**
   * Test case to check toString opearation for r3.
   */
  @Test
  public void checkToStringCase4() {
    assertEquals("x:10, y:10, w:10, h:10", r3.toString());
  }

  /**
   * Test case to check toString operation for r4.
   */

  @Test
  public void checkToStringCase5() {
    assertEquals("x:-1, y:-1, w:11, h:11", r4.toString());
  }

  /**
   * Test case to check toString opeartion for r5.
   */
  @Test
  public void checkToStringCase6() {
    assertEquals("x:2, y:2, w:6, h:6", r5.toString());
  }

  /**
   * Test case to check toString operation for r6.
   */
  @Test
  public void checkToStringCase7() {
    assertEquals("x:-9, y:-9, w:10, h:10", r6.toString());
  }

  /**
   * Test case to check toString operation for r7.
   */
  @Test
  public void checkToStringCase8() {
    assertEquals("x:0, y:-9, w:9, h:9", r7.toString());
  }

  /**
   * Test case to check toString operation for r8.
   */
  @Test
  public void checkToStringCase9() {
    assertEquals("x:100, y:100, w:1, h:1", r8.toString());
  }

  /**
   * Test case to check overlap between r1 and r2.
   */
  @Test
  public void checkOverlapCase1() {
    assertEquals(r1.overlap(r2), true);
  }

  /**
   * Test case to check overlap between r1 and r3.
   */
  @Test
  public void checkOverlapCase2() {
    assertEquals(r1.overlap(r3), false);
  }

  /**
   * Test case to check the overlap between r1 and r4.
   */
  @Test
  public void checkOverlapCase3() {
    assertEquals(r1.overlap(r4), true);
  }

  /**
   * Test case to check the overlap between r1 and r5.
   */
  @Test
  public void checkOverlapCase4() {
    assertEquals(r1.overlap(r5), true);
  }

  /**
   * Test case to check the overlap between r1 and r6.
   */
  @Test
  public void checkOverlapCase5() {
    assertEquals(r1.overlap(r6), true);
  }

  /**
   * Test case to check the overlap between r1 and r1.
   */
  @Test
  public void checkOverlapCase6() {
    assertEquals(r1.overlap(r1), true);
  }

  /**
   * Test case to check the overlap between r1 and r7.
   */
  @Test
  public void checkOverlapCase7() {
    assertEquals(r1.overlap(r7), false);
  }

  /**
   * Test case to check the overlap between r1 and r8.
   */
  @Test
  public void checkOverlapCase8() {
    assertEquals(r1.overlap(r8), false);
  }

  /**
   * Test case to check the union condition between r1 and r2.
   */
  @Test
  public void checkUnionCase1() {
    String res = r1.union(r2).toString();
    assertEquals("x:0, y:0, w:10, h:10", res);
  }

  /**
   * Test case to check the union condition between r1 and r3.
   */
  @Test
  public void checkUnionCase2() {
    String res = r1.union(r3).toString();
    assertEquals("x:0, y:0, w:20, h:20", res);
  }

  /**
   * Test case to check the union condition between r1 and r4.
   */
  @Test
  public void checkUnionCase3() {
    String res = r1.union(r4).toString();
    assertEquals("x:-1, y:-1, w:11, h:11", res);
  }

  /**
   * Test case to check the union condition between r1 and r5.
   */
  @Test
  public void checkUnionCase4() {
    String res = r1.union(r5).toString();
    assertEquals("x:0, y:0, w:10, h:10", res);
  }

  /**
   * Test case to check the union condition between r1 and r6.
   */
  @Test
  public void checkUnionCase5() {
    String res = r1.union(r6).toString();
    assertEquals("x:-9, y:-9, w:19, h:19", res);
  }

  /**
   * Test case to check the union condition between r1 and r7.
   */
  @Test
  public void checkUnionCase6() {
    String res = r1.union(r7).toString();
    assertEquals("x:0, y:-9, w:10, h:19", res);
  }

  /**
   * Test case to check the union condition between r1 and r8.
   */
  @Test
  public void checkUnionCase7() {
    String res = r1.union(r8).toString();
    assertEquals("x:0, y:0, w:101, h:101", res);
  }

  /**
   * Test case to check the union condition between r1 and r1.
   */
  @Test
  public void checkUnionCase8() {
    String res = r1.union(r1).toString();
    assertEquals("x:0, y:0, w:10, h:10", res);
  }

  /**
   * Test case to check the intersection object between r1 and r1.
   */
  @Test
  public void checkIntesectCase1() {
    String res = r1.intersect(r1).toString();
    assertEquals("x:0, y:0, w:10, h:10", res);
  }

  /**
   * Test case to check the intersection object between r1 and r2.
   */
  @Test
  public void checkIntersectCase2() {
    String res = r1.intersect(r2).toString();
    assertEquals("x:0, y:0, w:9, h:9", res);
  }

  /**
   * Test case to check the intersection object between r1 and r3.
   */
  @Test(expected = NoSuchElementException.class)
  public void checkIntersectCase3() {
    String res = r1.intersect(r3).toString();
  }

  /**
   * Test case to check the intersection object between r1 and r4.
   */
  @Test
  public void checkIntersectCase4() {
    String res = r1.intersect(r4).toString();
    assertEquals("x:0, y:0, w:10, h:10", res);
  }

  /**
   * Test case to check the intersection object between r1 and r5.
   */
  @Test
  public void checkIntersectCase5() {
    String res = r1.intersect(r5).toString();
    assertEquals("x:2, y:2, w:6, h:6", res);
  }

  /**
   * Test case to check the intersection object between r1 and r6.
   */
  @Test
  public void checkIntersectCase6() {
    String res = r1.intersect(r6).toString();
    assertEquals("x:0, y:0, w:1, h:1", res);
  }

  /**
   * Test case to check the intersection object between r1 and r7.
   */
  @Test(expected = NoSuchElementException.class)
  public void checkIntersectCase7() {
    String res = r1.intersect(r7).toString();
  }

  /**
   * Test case to check the intersection object between r1 and r8.
   */
  @Test(expected = NoSuchElementException.class)
  public void checkIntersectCase8() {
    String res = r1.intersect(r8).toString();
  }

  /**
   * Overlap Test case to check 2 rectangle touch lower left edge.
   */
  @Test
  public void overlapEdge1() {
    r2 = new Rectangle(-2, -2, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap Test case to check rectangle touch upper left edge.
   */
  @Test
  public void overlapEdge2() {
    r2 = new Rectangle(-2, 2, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap Test case to check rectangle touch upper right edge.
   */
  @Test
  public void overlapEdge3() {
    r2 = new Rectangle(2, 2, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap Test case to check rectangle touch lower right edge.
   */
  @Test
  public void overlapEdge4() {
    r2 = new Rectangle(0, 2, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle overlap at upper right edge.
   */
  @Test
  public void overlapEdge5() {
    r2 = new Rectangle(1, 1, 2, 2);
    assertEquals(true, r9.overlap(r2));
  }

  /**
   * Overlapo test case to check rectangle overlap upper left edge.
   */
  @Test
  public void overlapEdge6() {
    r2 = new Rectangle(1, -1, 2, 2);
    assertEquals(true, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle overlap upper right edge.
   */
  @Test
  public void overlapEdge7() {
    r2 = new Rectangle(1, 1, 2, 2);
    assertEquals(true, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle overlap lower right edge.
   */
  @Test
  public void overlapEdge8() {
    r2 = new Rectangle(1, -1, 2, 2);
    assertEquals(true, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle within another.
   */
  @Test
  public void overlapEdge9() {
    r2 = new Rectangle(-1, -1, 4, 4);
    assertEquals(true, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle within another.
   */
  @Test
  public void overlapEdge10() {
    r2 = new Rectangle(1, 1, 1, 1);
    assertEquals(true, r10.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle not touching left.
   */
  @Test
  public void overlapEdge11() {
    r2 = new Rectangle(-3, 0, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle not touching top.
   */
  @Test
  public void overlapEdge12() {
    r2 = new Rectangle(0, 3, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle not touching right.
   */
  @Test
  public void overlapEdge13() {
    r2 = new Rectangle(3, 0, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Overlap test case to check rectangle not touching bottom.
   */
  @Test
  public void overlapEdge14() {
    r2 = new Rectangle(0, -3, 2, 2);
    assertEquals(false, r9.overlap(r2));
  }

  /**
   * Intersect test case to check rectangle touch upper right edge.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge1() {
    r2 = new Rectangle(2, 2, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check rectangle touch lower right edge.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEedge2() {
    r2 = new Rectangle(0, -2, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check rectangle touch upper left edge.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge3() {
    r2 = new Rectangle(-2, 2, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check rectangle touch lower left edge.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge4() {
    r2 = new Rectangle(-2, -2, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check overlap upper right edge.
   */
  @Test
  public void intersectEdge5() {
    r2 = new Rectangle(1, 1, 2, 2);
    String res = r9.intersect(r2).toString();
    assertEquals("x:1, y:1, w:1, h:1", res);
  }

  /**
   * Intersect test case to check overlap lower right edge.
   */
  @Test
  public void intersectEdge6() {
    r2 = new Rectangle(1, -1, 2, 2);
    String res = r9.intersect(r2).toString();
    assertEquals("x:1, y:0, w:1, h:1", res);
  }

  /**
   * Intersect test case to check overlap upper left edge.
   */
  @Test
  public void intersectEdge7() {
    r2 = new Rectangle(-1, 1, 2, 2);
    String res = r9.intersect(r2).toString();
    assertEquals("x:0, y:1, w:1, h:1", res);
  }

  /**
   * Intersect test case to check overlap lower left edge.
   */
  @Test
  public void intersectEdge8() {
    r2 = new Rectangle(-1, -1, 2, 2);
    String res = r9.intersect(r2).toString();
    assertEquals("x:0, y:0, w:1, h:1", res);
  }

  /**
   * Intersect test case to check rectangle within other.
   */
  @Test
  public void intersectEdge9() {
    r2 = new Rectangle(-1, -1, 4, 4);
    String res = r9.intersect(r2).toString();
    assertEquals("x:0, y:0, w:2, h:2", res);
  }

  /**
   * Intersect test case to check rectangle outside other.
   */
  @Test
  public void intersectEdge10() {
    r2 = new Rectangle(1, 1, 1, 1);
    String res = r10.intersect(r2).toString();
    assertEquals("x:1, y:1, w:1, h:1", res);
  }

  /**
   * Intersect test case to check non touch right.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge11() {
    r2 = new Rectangle(3, 0, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check non touch top.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge12() {
    r2 = new Rectangle(0, 3, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check non touch left.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge13() {
    r2 = new Rectangle(-3, 0, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Intersect test case to check non touch bottom.
   */
  @Test(expected = NoSuchElementException.class)
  public void intersectEdge14() {
    r2 = new Rectangle(0, -3, 2, 2);
    String res = r9.intersect(r2).toString();
  }

  /**
   * Union test case to check rectangle touch upper right edge.
   */
  @Test
  public void unionEdge1() {
    r2 = new Rectangle(2, 2, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:0, w:4, h:4", res);
  }

  /**
   * Union test case to check rectangle touch lower right edge.
   */
  @Test
  public void unionEdge2() {
    r2 = new Rectangle(2, -2, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:-2, w:4, h:4", res);
  }

  /**
   * Union test case to check rectangle touch upper left edge.
   */
  @Test
  public void unionEdge3() {
    r2 = new Rectangle(-2, 2, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:-2, y:0, w:4, h:4", res);
  }

  /**
   * Union test case to check rectangle touch lower left edge.
   */
  @Test
  public void unionEdge4() {
    r2 = new Rectangle(-2, -2, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:-2, y:-2, w:4, h:4", res);
  }

  /**
   * Union test case to check rectangle intersect upper right edge.
   */
  @Test
  public void unionEdge5() {
    r2 = new Rectangle(1, 1, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:0, w:3, h:3", res);
  }

  /**
   * Union test case to check rectangle intersect lower right edge.
   */
  @Test
  public void unionEdge6() {
    r2 = new Rectangle(1, -1, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:-1, w:3, h:3", res);
  }

  /**
   * Union test case to check rectangle intersect upper left edge.
   */
  @Test
  public void unionEdge7() {
    r2 = new Rectangle(-1, 1, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:-1, y:0, w:3, h:3", res);
  }

  /**
   * Union test case to check rectangle intersect lower left edge.
   */
  @Test
  public void unionEdge8() {
    r2 = new Rectangle(-1, -1, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:-1, y:-1, w:3, h:3", res);
  }

  /**
   * Union test case to check rectangle inside other.
   */
  @Test
  public void unionEdge9() {
    r2 = new Rectangle(-1, -1, 4, 4);
    String res = r9.union(r2).toString();
    assertEquals(r2.toString(), res);
  }

  /**
   * Union test case to check rectangle outside other.
   */
  @Test
  public void unionEdge10() {
    r2 = new Rectangle(1, 1, 1, 1);
    String res = r10.union(r2).toString();
    assertEquals(r10.toString(), res);
  }

  /**
   * Union test case to check rectangle on top.
   */
  @Test
  public void unionEdge11() {
    r2 = new Rectangle(0, 3, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:0, w:2, h:5", res);
  }

  /**
   * union test case to check rectangle on right.
   */
  @Test
  public void unionEdge12() {
    r2 = new Rectangle(3, 0, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:0, w:5, h:2", res);
  }

  /**
   * Union test case to check rectangle on left.
   */
  @Test
  public void unionEdge13() {
    r2 = new Rectangle(-3, 0, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:-3, y:0, w:5, h:2", res);
  }

  /**
   * Union test case top check rectangle on bottom.
   */
  @Test
  public void unionEdge14() {
    r2 = new Rectangle(0, -3, 2, 2);
    String res = r9.union(r2).toString();
    assertEquals("x:0, y:-3, w:2, h:5", res);
  }
}

































