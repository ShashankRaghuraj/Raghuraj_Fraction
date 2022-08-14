//Shashank Raghuraj
//Due 11/3/2020
//Task: Get used to a new pal: the Array List
import java.util.Scanner;
import java.util.ArrayList;
public class Main
{
  public static void main(String[]args)
  {
    Fraction f1 = new Fraction(7,8);
    Fraction f2 = new Fraction(-1,12);
    Fraction f3 = new Fraction(15,16);
    ArrayList<Fraction> fractionList = new ArrayList<>();
    fractionList.add(f1);
    fractionList.add(f2);
    fractionList.add(f3);
    Scanner reader = new Scanner(System.in);
    boolean flag = true;
    while(flag)
    {
      System.out.print("\n1. Display the list of fractions\n2. Add a fraction to the end of the list\n3. Insert a fraction at a specific location\n4. Remove a fraction from a specific location\n5. Remove a fraction by value\n6. Replace a fraction at a specific location\n0. Exit\n\nEnter a selection: ");
      int input = reader.nextInt();
      //Trying out more switch case
      switch(input)
      {
        case 0:
          System.exit(0); 
          break;
        case 1:
          displayFractions(fractionList);
          break;
        case 2:
          addFraction(fractionList);
          break;
        case 3:
        case 4:
        case 5:
        case 6:
      }
    }
  }
  public static void displayFractions(ArrayList<Fraction> list)
  {
    Scanner reader = new Scanner(System.in);
    for(int i = 0; i < list.size(); i++)
    {
      System.out.println(i + ".   " + list.get(i));
    }
    System.out.println("Press <Enter> to continue...");
    reader.nextLine();
  }
  public static void addFraction(ArrayList<Fraction> list)
  {
    Scanner reader = new Scanner(System.in);
    System.out.print("Enter numerator of the fraction to add:  ");
    int numerator = reader.nextInt();
    System.out.print("\nEnter denominator of the fraction to add:  ");
    int denominator = reader.nextInt();
    Fraction newFraction = new Fraction(numerator, denominator);
    list.add(newFraction);
    System.out.println("The fraction " + newFraction + " has been successfully added to the end of the list.");
    System.out.println("Press <Enter> to continue...");
    reader.nextLine();
  }
  public static void insertFraction(ArrayList<Fraction> list)
  {
    Scanner reader = new Scanner(System.in);
    System.out.print("\nEnter location where you would like to insert the fraction:  ");
    int location = reader.nextInt();
    System.out.print("Enter numerator of the fraction to add:  ");
    int numerator = reader.nextInt();
    System.out.print("\nEnter denominator of the fraction to add:  ");
    int denominator = reader.nextInt();
    Fraction newFraction = new Fraction(numerator, denominator);
    list.add(location,newFraction);
    System.out.println("The fraction " + newFraction + " has been inserted in the list at location " + location + ".");
    System.out.println("Press <Enter> to continue...");
    reader.nextLine();
  }
  public static void removeFractionValue(ArrayList<Fraction> list)
  {
    Scanner reader = new Scanner(System.in);
    System.out.print("\nEnter the numerator of the fraction to remove:  ");
    int numerator = reader.nextInt();
    System.out.print("\nEnter the denominator of the fraction to remove:  ");
    int denominator = reader.nextInt();
    Fraction findFraction = new Fraction(numerator, denominator);
    for(int i = 0; i < list.size(); i++)
    {
      if(list.get(i) == findFraction)
      {

      }
    }
  }
}
    
