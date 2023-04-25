/**
 * Class to implement the XMLValidator  .
 */
public class XMLValidator extends AbstractXML {

  /**
   * Method to implement the output function of the XML Parser.
   *
   * @return String indicating the status of the xml object.
   */
  @Override
  public String output() {
    if (str.equals("")) {
      return "Status:Empty";
    }
    if (openTags.size() == 0 && !openBckt) {
      return "Status:Valid";
    }
    return "Status:Incomplete";
  }
}
