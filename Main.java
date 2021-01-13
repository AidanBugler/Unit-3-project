import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

class Main {
  public static void main(String[] args) throws IOException {
    String[] nameArray; 
    int [] scoreArray;
    String [] totalFile;
    int index = 0;
    
    
    //Int varible to count lines of text
    int lineCounter = 0;
    //Making the File to read from
    File myFile = new File("ScoreSheet.txt");
    myFile.createNewFile();

    //Putting the names and Scores into the File
    //FileWriter myWriter = new FileWriter (myFile);
    
    //myWriter.close();

    Scanner myReader = new Scanner (myFile);
    while(myReader.hasNextLine())
    {
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
    for (int i=0; i< (lineCounter/2); i++ )
    {
      System.out.println(nameArray[i]);
      System.out.println(scoreArray[i]);
    }

  }
}