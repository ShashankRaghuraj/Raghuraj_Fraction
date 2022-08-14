
//Shashank Raghuraj
//Jimmy Lin
//23/25
//Second batch of cases in C and D
//Regrade: 26/25 (Garrett Bearss)


import java.util.*;
import java.math.*;
import java.lang.Math;
public class Fraction   
{
  //Initialize Instance variables
  private int numerator = 0;
  private int denominator = 0;
  //First constructor which intializes numerator to 0 and denominator to 1
  public Fraction()
  {
    numerator = 0;
    denominator = 1;
  }
  //Second constructor: Takes in a numerator and denominator. Checks to see if d = 0, then it will set n and d to 0
  public Fraction(int n, int d)
  {
    if(d < 0){
      n *= -1;
      d *= -1;
    }
    if(d!=0)
    {
      numerator = n;
      denominator = d;
      this.simplify();
    }
    else{
      System.out.println("*ERROR: Divide by 0*");
      numerator = 0;
      denominator = 1;
    }
    
  }
  //Changes the double to a fraction
  public Fraction(double db)
  {
    //childs way of doing this
    /*denominator = 1;
    while(db % 1 !=0)
    {
      db *= 10;
      denominator *= 10;
    }
    numerator = (int) db;
    System.out.println(numerator);
    this.simplify();*/

    //Finds the length of a double. Longer but more intresting way to do this just in case top one doesnt work

    String doubleLength = Double.toString(db);
    String[] splitValues = doubleLength.split("\\.");
    int totalLength = splitValues[1].length();
    double multiplier = 1.0;
    for(int i = 1; i <= totalLength; i++)
    {
      multiplier*=10;
    }
    db *= multiplier;
    numerator = (int) db;
    denominator = (int) multiplier;
    this.simplify();

  }
  public Fraction add(Fraction f)
  {
    Fraction sum = new Fraction();
    // created a try catch block to catch the divide by 0 exception
    try
    {
      sum.denominator = this.denominator*f.denominator;
      sum.numerator = (this.numerator*f.denominator) + (this.denominator *f.numerator);
      sum.simplify();
      return sum;
    }
    catch(ArithmeticException aExp)
    {
      System.out.println("ERROR: Divide by 0");
      sum.denominator = 1;
      sum.numerator = 0; 
      return sum;
    }
  } 
  public Fraction subtract(Fraction f)
  {
    Fraction sum = new Fraction();
    try
    {
      //Opposite of addition: you just subtract the numerators
      sum.denominator = this.denominator*f.denominator;
      sum.numerator = (this.numerator*f.denominator) - (this.denominator*f.numerator);
      sum.simplify();
      return sum;
    }
    catch(ArithmeticException aExp)
    {
      System.out.println("ERROR: Divide by 0");
      sum.denominator = 1;
      sum.numerator = 0; 
      return sum;
    }
  }
  public Fraction multiply(Fraction f)
  {
    Fraction sum = new Fraction();
    //catches denominator = 0 exception
    try
    {
      //Multiplies the numerators and denominators.
      sum.denominator = (this.denominator*f.denominator);
      sum.numerator = (this.numerator*f.numerator);
      sum.simplify();
      return sum; 
    }
    catch(ArithmeticException aExp)
    {
      System.out.println("ERROR: Cannot multiply by 0");
      sum.numerator = 0;
      sum.denominator = 1;
      return sum;
    }
  }
  public Fraction divide(Fraction f)
  {
    Fraction sum = new Fraction();
    try
    {
      //You flip it: You multiply the denominator by the numerator and the numerator by the deminator
      sum.denominator = (this.denominator*f.numerator);
      sum.numerator = (this.numerator*f.denominator);
      sum.simplify();
      return sum;
    }
    catch(ArithmeticException aExp)
    {
      System.out.println("ERROR: Cannot multiply by 0");
      sum.numerator = 0;
      sum.denominator = 1;
      return sum;
    }
  }
  public double toDouble()
  {
    //Converts the fraction to a double
    double total = this.numerator/(double) this.denominator;
    return total;
  }
  public int compareTo(Fraction f)
  {
    //Compares both fractions. If fraction is > other fraction, return 1. If fraction is < other fraction return -1. If fraction is = other fraction return 0
    double decimal1 = this.numerator/(double) this.denominator;

    double decimal2 = f.numerator/(double) f.denominator;
    
    if(decimal1 > decimal2)
    {
      return 1;
    }
    else if(decimal1 == decimal2){
      return 0;
    }
    else{
      return -1;
    }
  }
  public boolean equals(Fraction f)
  {
    //Checks to see if both fractions are equal
    double decimal1 = this.numerator/(double) this.denominator;

    double decimal2 = f.numerator/(double) f.denominator;

    if(decimal1 == decimal2){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean equals(double dd)
  {
    //Checks to see if the decimal and the fraction are equal
    double decimal1 = this.numerator/(double) this.denominator;

    if(decimal1 == dd){
      return true;
    }
    else{
      return false;
    }
  }
  public boolean equals(int n, int d)
  {
    if(d == 0){
      System.out.println("ERROR: Cannot divide by 0");
      n = 0;
      d = 1;
    }
    //Checks to see if the fraction is equal to the numerator and denominator
    double decimal1 = this.numerator/(double) this.denominator;

    double decimal2 = n/(double) d;
    
    if(decimal1 == decimal2){
      return true;
    }
    else{
      return false;
    }
  }
  public Fraction FractionList(char[] operators, Fraction[] list)
  {
    Fraction result = new Fraction();
    //result.numerator = this.numerator;
    //result.denominator = this.denominator;
    //Logic
    for(int i=0; i < operators.length; i++)
    {
      //used switch case: way easier
        switch (operators[i]) {
        case '+':
          result = this.add(list[i]);
          System.out.println(i + ": " + result.numerator + "/" + result.denominator);
          break;
        case '-':
          result = this.subtract(list[i]);
          System.out.println(i + ": " + result.numerator + "/" + result.denominator);
          break;
        case '*':
          result = this.multiply(list[i]);
          System.out.println(i + ": " + result.numerator + "/" + result.denominator);
          break;
        case '/':
          result = this.divide(list[i]);
          System.out.println(i + ": " + result.numerator + "/" + result.denominator);
          break;
      }
      this.numerator = result.numerator;
      this.denominator = result.denominator;
      System.out.println();
    }
    return result;
  }
  //Simlification method
  //Split up into two parts
  private void simplify()
  {
    //If the deminator = 0  it will set numerator = 0 and demoinator = 1
    if(denominator == 0)
    {
      System.out.println("ERROR: Divide by 0");
      numerator = 0;
      denominator = 1;
    }
    else
    {
      //Finds the absolute value of both in order to account for negatives
      int numeratorAbs = Math.abs(numerator);
      int denomenatorAbs = Math.abs(denominator);
      if(numeratorAbs!=0)
      {
        //Code for finding GCD
        int min = denomenatorAbs;
        if(denomenatorAbs > numeratorAbs)
        {
          min = numeratorAbs;
        }
        int GCD = 0;
        //For loop
        for(int i = 1; i <= min; i++)
        {
          //if both numbers have a modulous of 0, it will set that to the new GCD
          if((denomenatorAbs % i == 0) && (numeratorAbs % i == 0))
          {
            GCD = i;
          }
        }
        //finally it will divide both the numerator and the deominator by the GCD
        numerator /= GCD;
        denominator /= GCD;
      }
    }
    if(numerator == 0){
      numerator = 0;
      denominator = 1;
    }
  }
  //Accessor Methods
  public int getNumerator()
  {
    return numerator;
  }
  public int getDenominator()
  {
    return denominator;
  }
  public void print()
	{
    System.out.println(toString());
	}
	public String toString()
	{
    if(denominator < 0){
      numerator*=-1;
      denominator*=-1;
    }
    return numerator + "/" + denominator;	
	} 
}
