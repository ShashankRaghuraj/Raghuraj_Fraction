import java.math.*;
public class ProperFraction extends Fraction
{
  //Rhymes with funstructor: the constructor method
  public ProperFraction(int n, int d)
  {
    super(n,d);
  }
  //the whole number portion of the fraction
  public int getWhole()
  {
    //Calls the getNumerator and getDemoninator accessor methods from Fraction class and uses truncation to get the whole number
    int wholeNumber = getNumerator()/getDenominator();
    return wholeNumber;
  }
  //remainder portion of the fraction
  public int getRemainder()
  {
    //Uses modulous in order to find the remainder
    int remainder = getNumerator() % getDenominator();
    //Finds absolute value or else wrong answer
    if(getWhole() != 0){
      remainder = Math.abs(remainder);
    }
    return remainder;
  }
  //
  public void print()
  {
    System.out.println(toString());
  }
  //prints out answer
  public String toString()
  {
    if(getRemainder() == 0 && getDenominator() == 1)
    {
      return getWhole() + "";
    }
    //If whole = 0, it will only print the remainder and demoninator
    if(getWhole() == 0)
    {
      return getRemainder() + "/" + getDenominator();
    }
    //since it bypases 0, it will no check to see if getWhole % 1, and if thats the case, it will only print the whole portion
    else if(getRemainder() == 0)
    {
      return getWhole() + "";
    }
    else
    {
      //prints the getWhole answer, and the getReaminder becomes the numerator, along with getDemoninator;
      return getWhole() + " " + getRemainder() + "/" + getDenominator();
    } 
  }
}
