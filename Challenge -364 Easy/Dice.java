import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Dice {
	
	
	
	public static void main(String[] args) {
		String fileName = "src\\input.txt";
		Random r = new Random();
		String input = readStream(fileName);
		System.out.println(input);
		
		Scanner scanner = new Scanner(input);

		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  String answ[] = line.split("d");
		  int sum = 0;
		  ArrayList<Integer> rolls = new ArrayList<Integer>();
		  for(int i=0; i<Integer.parseInt(answ[0]); i++){
			  int randomRoll=r.nextInt(Integer.parseInt(answ[1])) + 1;
			  sum += randomRoll;
			  rolls.add(randomRoll);
		  }
		  
		  Iterator iter = rolls.iterator();
		  System.out.print(sum + ": ");
		  while (iter.hasNext()) {
			  System.out.print(iter.next() + " ");
		  }
		  System.out.println();
		}
		
		
		scanner.close();
    }
			
    
	
	public static String readStream(String fileLocation) {
		// The name of the file to open.
        String fileName = fileLocation;

        // This will reference one line at a time
        String line = null;
        String retValue = "";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                retValue += line + "\n";
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        return retValue;
	}
}
