import java.math.BigInteger;

public class LookAndSayIterator implements RIterator{
  private BigInteger seed;
  private BigInteger endValue;
  private LinkedList node;

  private boolean checkValidity(BigInteger seed, boolean throwError) {
    if (throwError) {
      if (seed.compareTo(BigInteger.valueOf(0)) == 0  || seed.compareTo(endValue) == 1 || String.valueOf(seed).contains("0")) {
        this.seed = null;
        endValue = null;
        throw new IllegalArgumentException("Please enter a valid seed and end value.");
      }
    }
    else {
      if (seed.compareTo(BigInteger.valueOf(0)) == 0  || seed.compareTo(endValue) == 1) {
        return false;
      }
    }
    return true;
  }

  public LookAndSayIterator(BigInteger seed, BigInteger endValue) {
    this.seed = seed;
    this.endValue = endValue;
    checkValidity(seed, true);
    node = new LinkedList(seed);
  }

  public LookAndSayIterator(BigInteger seed) {
    this.seed = seed;
    this.endValue = new BigInteger("9999999999".repeat(10));
    checkValidity(seed,true);
    node = new LinkedList(seed);
  }

  public LookAndSayIterator() {
    this.seed = BigInteger.valueOf(1);
    this.endValue = new BigInteger("9999999999".repeat(10));
    checkValidity(seed,true);
    node = new LinkedList(seed);
  }

  private LinkedList calcNextNumber() {
    String encodedString = "";
    String number = this.node.getValue().toString();
    for (int i = 0, count = 1; i < number.length(); i++) {
      if (i + 1 < number.length() && number.charAt(i) == number.charAt(i + 1)) {
        count++;
      } else {
        encodedString = encodedString.concat(Integer.toString(count)).concat(Character.toString(number.charAt(i)));
        count = 1;
      }
    }
    return new LinkedList(new BigInteger(encodedString));
  }

  private LinkedList calcPrevNumber() {
    String encodedString = this.node.getValue().toString();
    String decodedString = "";

    if (encodedString.length() % 2 != 0)
      return null;
    int temp = 0;
    for (int i=0; i<encodedString.length(); i++) {
      if (i%2==0) {
        temp = Character.getNumericValue(encodedString.charAt(i));
      }
      else {
        decodedString += i * temp;
        temp = 0;
      }
    }
    return new LinkedList(new BigInteger(decodedString));
  }

  @Override
  public boolean hasPrevious() {
    LinkedList node;
    if (this.node.getPrev() == null) {
      node = calcPrevNumber();
    }
    else {
      node = this.node.getPrev();
    }
    if (node == null) {
      return false;
    }
    return checkValidity(node.getValue(), false);
  }

  @Override
  public boolean hasNext() {
    LinkedList node;
    if (this.node.getNext() == null) {
      node = calcNextNumber();
    }
    else {
      node = this.node.getNext();
    }
    return checkValidity(node.getValue(), false);
  }

  @Override
  public BigInteger prev() {
    LinkedList curr = node;
    if (hasPrevious()) {
      this.node.setPrev(calcPrevNumber());
      this.node = this.node.getPrev();
      this.node.setNext(curr);
      System.out.println(curr.getValue());
      System.out.println(this.node.getValue());
      System.out.println("---");
    }
    return curr.getValue();
  }

  @Override
  public BigInteger next() {
    LinkedList curr = node;
    if (hasNext()){
      this.node.setNext(calcNextNumber());
      this.node = this.node.getNext();
      this.node.setPrev(curr);
    }
    return curr.getValue();
  }
}
