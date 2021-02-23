import java.io.File;//ben duker
import java.io.Reader;
import java.util.*;

public class Boogle {
	public final static int SIZE =5;//sets the size 
public String filename = "dict.txt";
public static final String DELIM = "\t";// your delim
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	AdjMatrix a = new AdjMatrix();
		char[][] bog = new char[SIZE][SIZE];
		Random r = new Random();
		
		for(int i = 0; i < SIZE; i++){
		     for(int j = 0; j <SIZE;j++)
		     {
		    	 int number = (int) (Math.random()*26) +65;
		    	     bog[i][j] = (char) number;//sets the array to characters
		    	     System.out.print(bog[i][j] + " ");
		     }
		     System.out.println();
	}
		String[] words = readFile("dict.txt");//makes the file a String array to be read in
		int currentChar = 0;
		boolean cont = true;
		while(cont) {
		for(String word : words)
		for(int i = 0; i<bog.length;i++) {//goes through the array and checks the letters at index 0 then will increment each spot 
			for(int j=0; j<bog[i].length;j++) {
				if(i>0 && j>0 && bog[i-1][j-1]==word.charAt(currentChar))  {
					  //upperleft
					currentChar++;
				 
					  
							 }
				else if(j>0 &&bog[i][j-1]==word.charAt(currentChar+1)) {
					 //middle left
					 currentChar++;
					  
				 }
				else if(i<5 && j<0 && bog[i+1][j-1]==word.charAt(currentChar+1)) {
					  //bottom left
					 currentChar++;
					  
				 }
				else if(i<0 && bog[i+1][j]==word.charAt(currentChar+1)) {
					   //bottom middle
					 currentChar++;
				 }
				
				else if(i>5 && bog[i-1][j]==word.charAt(currentChar+1)) {
					  //top middle
					 currentChar++;
					  
				 }
				else if(i>4 && j<0 && bog[i-1][j+1]==word.charAt(currentChar+1)) {
					  //top right
					 currentChar++;
					  
				 }
				else if(j<0 && bog[i][j+1]==word.charAt(currentChar+1) ) {
					  //middle right
					 currentChar++;
					  
				 }
				else if(i<0 && j<0 && bog[i+1][j+1]==word.charAt(currentChar+1)) {
					  //bottom right
					 currentChar++;
					  
				 }
				else {//if its not in the character array breaks out and goes to the next word
					cont = false;
							break;
				}
					
				}
			
			}
		}
		
		System.out.println("your work list is");
		System.out.print(words);//prints 
			}
	
	
	public static String[] readFile(String fileName)
	{
		try
		{
			//Creates a scanner for the file and then first counts each word
			Scanner fileScanner = new Scanner(new File(fileName));
			int wordCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				wordCount++;
			}
			if(wordCount <= 0)
				return null;
			//Creates the return array, resets the file scanner, and populates the array
			String[] retArr = new String[wordCount];
			fileScanner = new Scanner(new File(fileName));
			for(int i=0;i<retArr.length;i++)
			{
				if(!fileScanner.hasNextLine())
					break;
				retArr[i] = fileScanner.nextLine();
			}
			return retArr;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	
	
}
