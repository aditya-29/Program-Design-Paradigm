import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import org.junit.Test;


/**
 * Class to test various scenarios of the Infologger and Validator.
 */
public class XMLValidatorTest {

  private final String complete = "Status:Valid";
  private final String inc = "Status:Incomplete";
  private final String empty = "Status:Empty";
  private XMLParser x;

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest1() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('>');

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check incomplete data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest2() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check empty data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest3() {
    x = new XMLValidator();
    assertEquals(empty, x.output());
  }

  /**
   * Test case to check incomplete data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest4() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('<');
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest5() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('>');
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest6() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('>');
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest7() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('<');
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest8() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('+');
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest9() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('-');
  }

  /**
   * Test case to check invalid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTest10() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('b');
    x.input('c');
    x.input('>');
    x.input('<');
    x.input('>');
    assertEquals(inc, x.output());
    x.input('<');
    x.input('-');
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest11() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');
    assertEquals(complete, x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagtest12() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest13() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('1');
    x.input('>');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('1');
    x.input('>');

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest14() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('1');
    x.input('>');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('b');
    x.input('>');

    x.input('a');
    x.input('b');
    x.input('c');
    x.input('d');
    x.input('e');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('1');
    x.input('>');

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check incomplete data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest15() throws InvalidXMLException {
    x = new XMLValidator();
    x.input('<');
    x.input('a');
    x.input('1');
    x.input('>');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('b');
    x.input('>');

    x.input('a');
    x.input('b');
    x.input('c');
    x.input('d');
    x.input('e');

    x.input('<');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('b');
    x.input('>');

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check incomplete data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest16() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<html>";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Status:Incomplete";
    assertEquals(output, x.output());
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check incomplete data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTest17() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<scene>\n";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Status:Incomplete";
    assertEquals(output, x.output());
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo1() throws InvalidXMLException {
    x = new XMLInfoLogger();
    x.input('<');
    x.input('a');
    x.input('>');

    assertEquals("Started:a\n", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo2() throws InvalidXMLException {
    x = new XMLInfoLogger();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('<');
    assertEquals("Started:a\n", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo3() throws InvalidXMLException {
    x = new XMLInfoLogger();
    x.input('<');
    assertEquals("", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo4() throws InvalidXMLException {
    x = new XMLInfoLogger();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    assertEquals("Started:a\nEnded:a\n", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagtestInfo5() throws InvalidXMLException {
    x = new XMLInfoLogger();
    x.input('<');
    x.input('a');
    x.input('>');
    x.input('a');

    x.input('<');
    x.input('b');
    x.input('>');
    x.input('b');

    x.input('<');
    x.input('/');
    x.input('b');
    x.input('>');

    x.input('<');
    x.input('/');
    x.input('a');
    x.input('>');

    String output = "Started:a\nCharacters:a\nStarted:b\nCharacters:b\nEnded:b\nEnded:a\n";
    assertEquals(output, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo6() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html> This is a body</html>";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Started:html\n"
        + "Characters: This is a body\n"
        + "Ended:html\n";
    assertEquals(output, x.output());

  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo7() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html> This is \\n a body <";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Started:html\n";
    assertEquals(output, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo8() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html> This is    a body</html>";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Started:html\n"
        + "Characters: This is    a body\n"
        + "Ended:html\n";
    assertEquals(output, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestInfo9() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html>_<head> This is a heading</head><p>Paragraph</p></html>";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Started:html\n"
        + "Characters:_\n"
        + "Started:head\n"
        + "Characters: This is a heading\n"
        + "Ended:head\n"
        + "Started:p\n"
        + "Characters:Paragraph\n"
        + "Ended:p\n"
        + "Ended:html\n";
    assertEquals(output, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestInfo10() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<ht ml><head></head><div><p></p><p></p></div></html>";

    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }

    String output = "Started:html\n"
        + "Characters:_\n"
        + "Started:head\n"
        + "Characters: This is a heading\n"
        + "Ended:head\n"
        + "Started:p\n"
        + "Characters:Paragraph\n"
        + "Ended:p\n"
        + "Ended:html";
    assertEquals(output, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestInfo11() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<ht ml>";
    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestInfo12() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<-html>";
    for (int i = 0; i < s.length(); i++) {
      x.input(s.charAt(i));
    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestValid1() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<scene>\n"
        + "\n"
        + "    <group>\n"
        + "\n"
        + "        <transform>\n"
        + "\n"
        + "            <set>\n"
        + "\n"
        + "                <translate>\n"
        + "-9";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid2() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html></html><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid3() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html1><p></p><asd></asd></html1><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid4() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html1><p></p><asd></asd></html1><html1></html1>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid5() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<<html>>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestValid6() throws InvalidXMLException {
    x = new XMLValidator();
    String s1 = "<html>";
    String s = "<class>  \n"
        + "    <student>  \n"
        + "        <id>101</id>  \n"
        + "        <firstname>Naman</firstname>  \n"
        + "        <lastname>Kumar</lastname>  \n"
        + "        <subject>Math</subject>  \n"
        + "        <marks>83</marks>  \n"
        + "    </student>  \n"
        + "      \n"
        + "    <student>  \n"
        + "        <id>102</id>  \n"
        + "        <firstname>Kapil</firstname>  \n"
        + "        <lastname>Kumar</lastname>  \n"
        + "        <subject>Chemistry</subject>  \n"
        + "        <marks>60</marks>  \n"
        + "    </student>  \n"
        + "  \n"
        + "    <student>  \n"
        + "        <id>103</id>  \n"
        + "        <firstname>Harsh</firstname>  \n"
        + "        <lastname>Singh</lastname>  \n"
        + "        <subject>English</subject>  \n"
        + "        <marks>70</marks>  \n"
        + "    </student>  \n"
        + "  \n"
        + "    <student>  \n"
        + "        <id>104</id>  \n"
        + "        <f irstname>Jitesh</firstname>  \n"
        + "        <lastname>Singh</lastname>  \n"
        + "        <subject>Physics</subject>  \n"
        + "        <marks>76</marks>  \n"
        + "    </student>  \n"
        + "  \n"
        + "</class>  ";
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s += s;
    s = s1 + s + "</html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals(complete,x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid7() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html></html><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestValid8() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html><htm1><p></p><p></p></htm1></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    String output = "Started:html\n"
        + "Started:htm1\n"
        + "Started:p\n"
        + "Ended:p\n"
        + "Started:p\n"
        + "Ended:p\n"
        + "Ended:htm1\n"
        + "Ended:html\n";

    assertEquals(output, x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid9() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html><html></html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid10() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<></><html><a></a><p></p></html><h0tml><></>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid11() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "dfhchc<asd></asd><html><html><html></html></html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid12() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<asd></asd><html><html><html></html></html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid13() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html><html></html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }

    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid14() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "</><//></><html></html><html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid15() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<></><></><html></html><html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid16() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "html<html></html>asdasd<p></p><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid17() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "</html><html><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestValid18() throws InvalidXMLException {
    x = new XMLInfoLogger();
    String s = "<html><html></html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));

    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check XMLInfoLogger data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void tagTestValid184() throws InvalidXMLException {
    ArrayList<String> s = new ArrayList<String>();

    s.add("<tag1><tag2>");
    s.add("<tag1><tag2>text<");
    s.add("<tag1><tag2><tag3>");
    s.add("<tag1><tag2><tag3>text<");
    s.add("<tag1><tag2><tag3><");
    s.add("<tag1><tag2>text<tag3>");
    s.add("<tag1><tag2><tag3><tag4>");
    s.add("<tag1><tag2><tag3><tag4>text<");
    s.add("<tag1><tag2><tag3><tag4><");
    s.add("<tag1><tag2>text<tag3><tag4>");
    s.add("<tag1>text<tag2><tag3>");
    s.add("<tag1><tag2><tag3>text<tag4>");
    s.add("<tag1><tag2>text<tag3>text<tag4>");

    for (int j = 0; j < s.size(); j++) {
      x = new XMLValidator();
      for (int i = 0; i < s.get(j).length(); i++) {
        x = x.input(s.get(j).charAt(i));
      }
      assertEquals("Status:Incomplete", x.output());
    }
  }

  /**
   * Test case to check valid data.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void tagTestvalid19() throws InvalidXMLException {
    x = new XMLValidator();
    String s = "<html>\n"
        + "        <body>This is a body </body>\n"
        + "    </html>\n"
        + "    <html>\n"
        + "        <body>This is another body </body>\n"
        + "    </html>";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("dtgfd", x.output());
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */

  @Test
  public void calcTest1i1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></html>";

    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    String out = "Started:html\nEnded:html\n";
    assertEquals("Status:Valid", x.output());
    assertEquals(out, y.output());
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void caltest1i2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html><a></a></html>";

    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    String out = "Started:html\nStarted:a\nEnded:a\nEnded:html\n";
    assertEquals("Status:Valid", x.output());
    assertEquals(out, y.output());
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>pdp<a>this</a></html>";

    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    String out = "Started:html\n"
        + "Characters:pdp\n"
        + "Started:a\n"
        + "Characters:this\n"
        + "Ended:a\n"
        + "Ended:html\n";
    assertEquals("Status:Valid", x.output());
    assertEquals(out, y.output());
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "this<html>this <a> is </a>\npdp</html>is";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
    } catch (InvalidXMLException e) {
      assertEquals(empty, out);
      assertEquals(0, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(0, i);
    }
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></htmL>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(i, 11);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(i, 11);
    }
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i6() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html><a></b></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(i, 11);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nStarted:a\n", out);
      assertEquals(i, 11);
    }
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i7() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "</htm1></htm1>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
        System.out.println(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(2, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(2, i);
    }
  }

  /**
   * Test case to check same start and end tag.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest1i8() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<htm1><htm1>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(11, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:htm1\n", out);
      assertEquals(11, i);
    }
  }

  /**
   * Test case to check start and end brackets.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest2i1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></<html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(8, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(8, i);
    }
  }

  /**
   * Test case to check start and end brackets.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest2i2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = ">html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(empty, out);
      assertEquals(0, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(0, i);
    }
  }

  /**
   * Test case to check start and end brackets.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest2i3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html</html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(5, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(5, i);
    }
  }

  /**
   * Test case to check start and end brackets.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest2i4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "html</html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(empty, out);
      assertEquals(0, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(0, i);
    }
  }

  /**
   * Test case to check start and end brackets.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest2i5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>/html";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(inc, x.output());
    assertEquals("Started:html\n", y.output());
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html ></html >";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(5, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(5, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "< html></ html >";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(1, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(1, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>< /html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(7, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(7, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<HTML></HTML>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
    assertEquals("Started:HTML\nEnded:HTML\n", y.output());
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<ht01></ht01>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
    assertEquals("Started:ht01\nEnded:ht01\n", y.output());
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i6() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<9html></9html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(1, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(1, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i7() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html><9/html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(7, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(7, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest5i8() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html,></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(5, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(5, i);
    }
  }

  /**
   * Test case to check tags with valid characters.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */


  @Test
  public void calTest5i9() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<hTMl0:_-></hTMl0:_->";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
    assertEquals("Started:hTMl0:_-\nEnded:hTMl0:_-\n", y.output());
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>\nThis is war .\n ' \t , 0123@#$</html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
    assertEquals("Started:html\n"
            + "Characters:\nThis is war .\n ' \t , 0123@#$\n"
            + "Ended:html\n",
        y.output());
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>This is pdp\n</html><html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(complete, out);
      assertEquals(25, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nCharacters:This is pdp\n\nEnded:html\n", out);
      assertEquals(25, i);
    }
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>This is pdp\n</html><html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(complete, out);
      assertEquals(25, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nCharacters:This is pdp\n\nEnded:html\n", out);
      assertEquals(25, i);
    }
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></html><html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(complete, out);
      assertEquals(13, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nEnded:html\n", out);
      assertEquals(13, i);
    }
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html><html></html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(11, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(11, i);
    }
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i6() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html>\n<a><a></a></a></html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
    assertEquals(
        "Started:html\n"
            + "Characters:\n\n"
            + "Started:a\n"
            + "Started:a\n"
            + "Ended:a\n"
            + "Ended:a\n"
            + "Ended:html\n",
        y.output());
  }

  /**
   * Test case to check the root tags.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest6i7() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></html><a></a>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(complete, out);
      assertEquals(13, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nEnded:html\n", out);
      assertEquals(13, i);
    }
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html></html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html><a></a></html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html>abcd<a>abcd</a>abcd</html>abcd";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(complete, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html";
    String out = "";
    int i   = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i6() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html><a></a>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i7() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html><a></a></html";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test(expected = InvalidXMLException.class)
  public void calTest7i8() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html><a></a></html><a>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals(inc, x.output());
  }

  /**
   * Test case to check XML Validator output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest7i9() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    String s = "<html><1";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        x = x.input(s.charAt(i));
      }
    } catch (InvalidXMLException e) {
      assertEquals(inc, x.output());
      x.input('/');
      x.input('h');
      x.input('t');
      x.input('m');
      x.input('l');
      x.input('>');
    }
    assertEquals(complete, x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i1() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html>abcd</html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\nCharacters:abcd\nEnded:html\n", x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i2() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html></html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\nEnded:html\n", x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i3() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\n", x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i4() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html>abcd<a>def</a></html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\n"
            + "Characters:abcd\n"
            + "Started:a\n"
            + "Characters:def\n"
            + "Ended:a\n"
            + "Ended:html\n",
        x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i5() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html><a>ab .,%c</a>cde\t\t\t\n</html>";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals(
        "Started:html\n"
            + "Started:a\n"
            + "Characters:ab .,%c\n"
            + "Ended:a\n"
            + "Characters:cde\t\t\t\n\n"
            + "Ended:html\n",
        x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i6() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html><a></a></html>abcd";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\n"
        + "Started:a\n"
        + "Ended:a\n"
        + "Ended:html\n", x.output());
  }

  /**
   * Test case to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i7() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();
    String s = "<html><a>abcde";
    String out = "";
    int i = 0;

    for (i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }
    assertEquals("Started:html\nStarted:a\n", x.output());
  }


  /**
   * Test cases to check XML InfoLogger output.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTest8i8() throws InvalidXMLException {
    XMLParser x = new XMLInfoLogger();

    String s = "<html>ch1<p>cp1<a>ca1</a>cp2</p>";

    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
    }

    assertEquals("Started:html\n"
        + "Characters:ch1\n"
        + "Started:p\n"
        + "Characters:cp1\n"
        + "Started:a\n"
        + "Characters:ca1\n"
        + "Ended:a\n"
        + "Characters:cp2\n"
        + "Ended:p\n", x.output());
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb1() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<-html></-html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(1, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("", out);
      assertEquals(1, i);
    }
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb2() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html></html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(complete, out);
      assertEquals(13, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\nEnded:html\n", out);
      assertEquals(13, i);
    }
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb3() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<html><html></html>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(11, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:html\n", out);
      assertEquals(11, i);
    }
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb4() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<qwertyuiopasdfghjklx"
                + "cvbnmwwertyuiopasdfghj"
                + "klzxcvbnmqwertyuiopasdfghjklzxcvbnm>";
    String out = "";
    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }
    assertEquals(inc, x.output());
    assertEquals("Started:qwertyuiopasdfghjklx"
        + "cvbnmwwertyuiopasdfghj"
        + "klzxcvbnmqwertyuiopasdfghjklzxcvbnm\n", y.output());
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb5() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<></>";
    String out = "";
    int i = 0;

    try {
      for (i = 0; i < s.length(); i++) {
        out = x.output();
        x = x.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals(inc, out);
      assertEquals(4, i);
    }

    try {
      for (i = 0; i < s.length(); i++) {
        out = y.output();
        y = y.input(s.charAt(i));
      }
      fail("Did not work");
    } catch (InvalidXMLException e) {
      assertEquals("Started:\n", out);
      assertEquals(4, i);
    }
  }

  /**
   * Additional edge cases to be tested.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Test
  public void calTestb6() throws InvalidXMLException {
    XMLParser x = new XMLValidator();
    XMLParser y = new XMLInfoLogger();
    String s = "<t1><t2></";
    String out = "";

    for (int i = 0; i < s.length(); i++) {
      x = x.input(s.charAt(i));
      y = y.input(s.charAt(i));
    }
    assertEquals(inc, x.output());
    assertEquals("Started:t1\nStarted:t2\n", y.output());
  }




}