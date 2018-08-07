import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Bomb {
	public static ArrayList<String> colors;
	
	public Bomb() {
		colors = readStream("src\\input1.txt");
	}
	
	public void printResult() {
		if(defuseBomb()) {
			System.out.println("Bomb defused");
		}
		else {
			System.out.println("Booom");
		}
	}
	public static boolean defuseBomb() {		
		for(int i =0; i <colors.size()-1 ; i++) {
			if (colors.get(i).equals("white")){
				if(colors.get(i+1).equals("black") || colors.get(i+1).equals("white")) {
					return false;
				}
			}
			else if (colors.get(i).equals("red")) {
				if (!(colors.get(i+1).equals("green"))) {
					return false;
				}
			}
			else if (colors.get(i).equals("black")) {
				if(colors.get(i+1).equals("white") || colors.get(i+1).equals("green") || colors.get(i+1).equals("orange")) {
					return false;
				}
			}
			else if(colors.get(i).equals("orange")) {
				//System.out.println(colors.get(i));
				if(!(colors.get(i+1).equals("red") || colors.get(i+1).equals("black") )){
					return false;
				}
			}
			else if(colors.get(i).equals("green")) {
				if(!(colors.get(i+1).equals("orange") || colors.get(i+1).equals("white" ))){
					return false;
				}
			}
			else if (colors.get(i).equals("purple")) {
				if(colors.get(i+1).equals("purple") || colors.get(i+1).equals("green") || colors.get(i+1).equals("orange")|| colors.get(i+1).equals("white")) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	
	public static ArrayList<String> readStream(String fileLocation) {
		// The name of the file to open.
        String fileName = fileLocation;

        // This will reference one line at a time
        String line = null;
        ArrayList<String> retValue = new ArrayList<String>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
            	retValue.add(line);
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
	

	public static void main(String[] args) {
		Bomb bomb = new Bomb();
		bomb.printResult();
	}
	
}
