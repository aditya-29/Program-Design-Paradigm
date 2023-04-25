/**
 * Class to implement the XMLInfoLogger.
 */
public class XMLInfoLogger extends AbstractXML {

  /**
   * Method to implement the output function of the XML Parser object.
   *
   * @return String indicating started, ended and characters of the xml object.
   */
  @Override
  public String output() {
    String output = "";

    for (String s : outputList) {
      output += s;
      output += "\n";
    }
    output += "\n";
    return output.substring(0, Math.max(output.length() - 1, 0));
  }
}
