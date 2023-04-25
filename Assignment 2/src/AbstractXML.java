import java.util.ArrayList;
import java.util.List;

abstract class AbstractXML implements XMLParser {
//  stores the input in string format
  protected String str = "";
//  stores the tags that are open currently
  protected List<String> openTags = new ArrayList<String>();
//  generates the output to be used by infologger and validator
  protected List<String> outputList = new ArrayList<String>();
//  method variable to check whether a bracket is open or not
  protected boolean openBckt = false;
//  method variable to check whether a bracket is closed or not
  private boolean closeBckt = false;
//  method variable to store the string within a tag
  private String tagStr = "";
//  method variable to check whether a tag is open or not
  private boolean isOpenTag = true;
//  method variable to check root tag is established or not
  private boolean isRoot = false;
//  method variable to store the root tag
  private String root = null;

  /**
   * Method to implement the input function of the XML parser.
   * @param c the input character.
   * @return Returns the XMLParser object.
   * @throws InvalidXMLException when a invalid xml is parsed.
   */
  @Override
  public XMLParser input(char c) throws InvalidXMLException {
    // if '<' is encountered.
    if (c == '<') {

      // throw an exception when the '<' is entered without closing the tag.
      if (openBckt) {
        throw new InvalidXMLException("< is already present. Please close the tag first.");
      }

      // set open bracket boolean to true and close bracket boolean to false.
      openBckt = true;
      this.closeBckt = false;

      // add the current input to the str variable.
      str += c;

      // if the tag is not empty add it to the outputList.
      if (!tagStr.equals("") && openTags.size() != 0) {
        outputList.add("Characters:" + tagStr);
      }

      // test whether multiple root is entered.
      if (openTags.size() == 0 && root != null && str.length() != 0) {
        throw new InvalidXMLException("Only one root is allowed");
      }

      // set the tagstr to the current input character.
      tagStr = String.valueOf(c);
    }

    // if '>' character is encountered.
    else if (c == '>') {

      // test whether '>' character is entered before opening a tag.
      if (!isOpenTag && tagStr.equals("<")) {
        throw new InvalidXMLException("please use < first");
      }

      // test whether '>' is entered twice before opening a new tag.
      if (closeBckt) {
        throw new InvalidXMLException("> already present. Please open a tag first.");
      }

      // test whether '>' character is entered before opening a tag.
      if (!openBckt) {
        throw new InvalidXMLException("please use < first");
      }

      // set the close bracket boolean to 'true' and open bracket boolean to 'false'.
      closeBckt = true;
      openBckt = false;

      // add the current input character to the string.
      str += c;

      // add the current character to the tag string representing the characters inside tags.
      tagStr += c;

      // if the root string is null replace it with tagstring value.
      if (root == null) {
        root = tagStr;
      }

      // test whether same root tag is called within.
      if (isOpenTag && isRoot && tagStr.equals(root)) {
        throw new InvalidXMLException(root + " tag can be used only once.");
      }

      // set the root as true if the tagstring is root and the tag is open.
      if (isOpenTag && tagStr.equals(root)) {
        isRoot = true;
      }

      // remove the last entry in the open tag and add it to the output list.
      if (!isOpenTag && (openTags.size() == 0 || openTags.get(openTags.size() - 1)
          .equals(tagStr))) {
        outputList.add("Ended:" + tagStr.substring(1, tagStr.length() - 1));
        if (openTags.size() > 0) {
          openTags.remove(openTags.size() - 1);
        }
        isOpenTag = !isOpenTag;
      }

      // test whether the recent tag is closed.
      else if (!isOpenTag) {
        throw new InvalidXMLException("Please close the previous tag first.");
      }

      // add the current tag to the output list and open tags.
      else {
        outputList.add("Started:" + tagStr.substring(1, tagStr.length() - 1));
        openTags.add(tagStr);
      }

      // set the tagstr to empty string.
      tagStr = "";
    }

    // if '/' character is encountered.
    else if (c == '/' && str.charAt(str.length() - 1) == '<') {
      tagStr = "<";
      isOpenTag = false;
    }

    // for the default characters.
    else {
      // test whether a string is entered at the beginning.
      if (str.length() == 0) {
        throw new InvalidXMLException("Please open a tag first");
      }

      // test whether the tag has a valid name.
      if ((openBckt) && !Character.isAlphabetic(c) && !Character.isDigit(c) && (c != ':') && (c
          != '-') && (c != '_')) {
        throw new InvalidXMLException("Please enter valid name for the tag");
      }

      // test whether tag is starting with a valid character.
      if ((c == '-' || Character.isDigit(c)) && tagStr.length() > 0
          && tagStr.charAt(tagStr.length() - 1) == '<') {
        throw new InvalidXMLException("Tag name cannot start with - or number");
      }

      // add the current character to the str and tagstr variables.
      str += c;
      tagStr += c;

      // test whether the previous tag is closed first.
      if (!isOpenTag && openBckt && (openTags.size() == 0 || !openTags.get(openTags.size() - 1)
          .substring(0, tagStr.length()).equals(tagStr))) {
        throw new InvalidXMLException("Please close the previous tag first.");
      }
    }

    // return the current XML Parser object.
    return this;
  }
}
