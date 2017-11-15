import java.io.File;
import java.util.Scanner;


public class Menu {
	public static String Words;
	public static char[] textImport;
	public static char[] Name;
	public static void main(String[] args) {	
		do{
		//Menu
		System.out.println("1: Input a string");
		System.out.println("2: Input a file");
		System.out.println("3: Loop through input or file");
		System.out.println("4: Exit");
		//End of menu
		
		//Scan user input
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		//End of scan user input
		
		switch(choice)
		{
		
		case 1:
			//Input string
			System.out.println("Please enter a string");
			Scanner scannerU = new Scanner(System.in);
			Words = scannerU.nextLine();
			//End of input string
			break;
		case 2:
			//Input file
			Scanner fileScan;
			String fileString;
				try {				
				fileScan = new Scanner(new File("myDoc.txt"));
				while (fileScan.hasNextLine()) 
				{
					fileString = fileScan.nextLine();
					textImport = fileString.toCharArray();
					System.out.println(textImport);
				}	                
				} 
				catch (Exception e) 
				{
					System.out.println("File not found");
					return;
				}
				//End of input file
			break;
		case 3:
			//Loop through
			int i =0, j =0, counter =0;	
			String Alphabet="abcdefghijklmnopqrstuvwxyz";
			String upAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			char[] Alpha = Alphabet.toCharArray();
			char[] upAlpha = upAlphabet.toCharArray();
			if (textImport != null)
			{
				Name = textImport;
			} else {
				Name = Words.toCharArray();
			}
			for (i = 0; i < Alpha.length; ++i)
			{
				counter = 0;
		    	for (j = 0; j < Name.length; ++j) 
		    	{if (Name[j] != Alpha[i] && upAlpha[i]==Name[j]){
		    		counter++;
		    	}
		    	if (Alpha[i] == Name[j])  
		    	{
		    	counter++;
		    	}	
		   	}
		    //Calculate percentage
		    float percent = (counter * 100.0f) / Name.length;
		    System.out.println("The character " + Alpha[i] + " occurs " + counter + " times or " + percent + "%");
			}	
			//End of loop through		
			break;
		case 4:
			//Exit
			System.exit(1);
			break;
		}
		}
		while(true);
	}
}

