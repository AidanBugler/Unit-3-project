import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class Main {
    static int [] scoreArray;

    static String [] addNameMethod(String str[], String userInput)
    {
      String [] temp  = new String [str.length +1];
      for (int i=0;i < str.length; i++)
      {
       temp [i]  = str [i] ; 
      }
      temp[temp.length-1] = userInput;
      return temp;
    }

    static int [] addScoreMethod (int arr [], int userInput)
    {
      int [] temp  = new int [arr.length +1];
      for (int i=0;i <arr.length; i++)
      {
        temp [i] = arr [i]; 
      }
      temp[temp.length-1] = userInput;
      return temp;
    }

    static String[] remainderNameSortMethod(String str[], int arrLength)
  {
    if (arrLength==0)
    {
      return str;
    }
    String temp;
    int intTemp;
    for (int i = 0; i < arrLength-1; i++) 
    {
      if (str[i].compareTo(str[i+1]) > 0) {
      temp = str[i];
      str[i] = str[i+1];
      str[i+1] = temp;
      intTemp = scoreArray[i];
      scoreArray[i] = scoreArray[i+1];
      scoreArray[i+1] = intTemp;
      }
    }

  return remainderNameSortMethod(str,arrLength-1);
  }
  //static int [] remainderScoreSortMethod(int arr[], int arrlength)
 // {
 //   return arr;
 // }

  public static void main(String[] args) throws IOException {
    Scanner input = new Scanner(System.in);
    int choice; 
    String[] nameArray; 
    String [] totalFile;
    int index = 0;
    //Int varible to count lines of text
    int lineCounter = 0;
    String newName;
    int newScore; 
    //Making the File to read from
    File myFile = new File("ScoreSheet.txt");
    myFile.createNewFile();
    
    Scanner myReader = new Scanner (myFile);
    while(myReader.hasNextLine())
    {
      myReader.nextLine();
      lineCounter = lineCounter + 1;
    }
    myReader.close();
    
    totalFile = new String [lineCounter];
    myReader = new Scanner (myFile);
    while(myReader.hasNextLine())
    {
      totalFile [index] = myReader.nextLine();
      index = index +1;
    }

    myReader.close();
    //Setting up an array 
    
    nameArray = new String [(lineCounter/2)];
    scoreArray = new int [(lineCounter/2)];
    for (int i=0;i<(lineCounter/2); i++)
    {
      nameArray[i] = totalFile[i];
    }
    index = 0;
    for (int i=(lineCounter/2); i<lineCounter;i++)
    {
      scoreArray [index] = Integer.parseInt(totalFile[i]);
      index = index +1;
    }
    
    
    //Asking the user if they would like to add any names and scores to the FileWriter
    System.out.println("Would you like to add a new name and score to the file?");
    System.out.println("1. yes   2. no");
    choice = Integer.parseInt(input.nextLine());

    while (choice == 1)
    {
      System.out.println("What is the new name?");
      newName = input.nextLine();
      System.out.println("What score did they get?");
      newScore = Integer.parseInt(input.nextLine());
      System.out.println();

      nameArray = addNameMethod(nameArray, newName);
      scoreArray = addScoreMethod(scoreArray, newScore);

      System.out.println("Would you like to save the scores or add more?");
      System.out.println("1. Add more  2. Save and move on");
      choice = Integer.parseInt(input.nextLine());
    }
    
    if (choice == 2)
    {
    //Putting the names and Scores into the File
    FileWriter myWriter = new FileWriter (myFile);
    for (int i= 0; i<nameArray.length; i++)
    {
    myWriter.write(nameArray[i]+"\n");

    }
    for (int i= 0; i<scoreArray.length; i++)
    {
      myWriter.write(scoreArray[i]+"\n");
    }
    myWriter.close(); 

    for (int i=0; i< nameArray.length; i++ )
    {
    System.out.println(remainderNameSortMethod(nameArray,nameArray.length)[i] + " " +scoreArray[i]);
    }
    }
  }
}