package gendermag2;
/*
Generate a Song ID randomly (7-digit integer from 1000000 to 9999999) and assign to each
song programmatically (you can make it either a first or a last column in the .txt file).
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SongID {

	public static void main(String[] args) {
	
		//create a new instance of the File
		File file = new File("/Users/marsanto/git/repository2/Cps_2232/src/gendermag2/Songs.txt");
		
		try {
		//Reader
		BufferedReader read = new BufferedReader(new FileReader(file));
		//Writer, creates "NewFile.txt"
		BufferedWriter write = new BufferedWriter(new FileWriter("NewFile.txt"));
		
		//Reads the first line & assigns it to a string variable called header
		String header = read.readLine();
		//Creates a string header & format using \t
        String header2 = "Song ID\t" + header;
        //Writes the "header2" string to the output file & adds a new line "\n"
        write.write(header2+"\n");
		
		//This read each line
		String line = read.readLine();
		//While loop that will execute as long as the line variable is not null
        while (line != null) {
        	//Prints the contents of the line variable to the console
        	System.out.println(line);
            line = read.readLine();
            
        //Generate a Song ID randomly (7-digit integer from 1000000 to 9999999)
        int songID = (int)(Math.random() * 9000000) + 1000000;
            
        //Writes the line with Song ID to the output file & make a new line
        String newLine = songID + "\t" + line;
        write.write(newLine+"\n");
        }//end while loop
        
        //Close file
        read.close();
        write.close();
        
        System.out.println("Sucesss! New file with songID");
        
		} catch (IOException e) {
	       e.printStackTrace();
	     }	
}
}
