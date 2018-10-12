import java.io.*;
import java.util.*;
import java.util.Scanner;

public class wordsearch {


	static hashTable alphabet = new hashTable(25);


	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("-- Type in break to exit the whileloop --");
		String input ="";
		int asciiVal;
		
		
		
		fileIntoBst("mobi.txt");
		
		while(!input.equals("break")) {
			
		System.out.println("Enter a word to search for");
		input = in.nextLine();
		String character = input.charAt(0)+"";
		character = character.toLowerCase();
		asciiVal = CharToAscii(character);
		System.out.println(search(alphabet.bstArray[asciiVal % 97], input));
		
		}


	}

	public static void fileIntoBst(String fileName) throws IOException {

		String str = "";
		boolean bool = true;
		File temp = new File(fileName);
		Scanner file = new Scanner(temp);

		while(bool) {
			try {
				str = (file.nextLine());
			}
			catch(Exception e) {
				bool = false;
				break;
			}
			try {
				wordsIntoBst(str);
			}
			catch(Exception e) {
			}
		}
	}

	// A method that ignores punctuation and puts each seperate word into a BST dependent on its first letter. Ex: ant --> (linkedList) La;
	public static void wordsIntoBst(String str) {
		
		
		String letter;
		String word ="";
		
		for(int i=0; i<=str.length(); i++) {

			//inserts into proper bst;
			if( i == str.length() || ((str.charAt(i)+"").equals(" ") && i != 0)) {

				//gets first letter of word 
				letter = word.charAt(0)+"";
				letter = letter.toLowerCase();

				//get ascii value of the letter
				int asciiVal = CharToAscii(letter);
				 

				//specific bst and enter word there
				if(search( alphabet.bstArray[asciiVal %97], word) == false) {
					 alphabet.bstArray[asciiVal %97] = insert( alphabet.bstArray[asciiVal %97], word);
					
				}


				word ="";
			}
			// checking if i is a letter and builds a word
			if(Character.isLetter(str.charAt(i))) {
				letter = str.charAt(i)+"";
				word+=letter;
			}
			// if the string is finished
			if( i == str.length()) {
				break;
			}

		}

	}

	//read the first line
	public static void readLine(String name) throws IOException{

		boolean bool = true;
		File temp = new File(name);
		Scanner file = new Scanner(temp);

		while(bool) {
			try {
				System.out.println(file.nextLine());
			}
			catch(Exception e) {
				bool = false;
			}
		}
		file.close();
	}


	//finds smallest string
	public static String smaller(String str1, String str2) {
		if(str1.compareTo(str2) < 0)
			return str1;
		else if(str1.compareTo(str2) > 0)
			return str2;
		else return "equal";

	}

	// Inserts into Binary search tree
	public static bstNode insert(bstNode T, String str){

		if ( T == null)
			T = new bstNode(str);
		else
			if ((str.compareTo(T.item) < 0))
				T.left = insert(T.left,str);
			else 
				T.right = insert(T.right,str);
		return T;
	}

	//Prints Binary search Tree
	public static void printInOrder(bstNode T){
		if (T!=null){
			printInOrder(T.left);
			System.out.print(T.item+" ");
			printInOrder(T.right);
		}
	}

	//Searching BST
	public static boolean search(bstNode T, String str){
		if (T == null )
			return false;

		if(T.item.equals(str))
			return true;

		if ((str.compareTo(T.item) < 0))
			return search(T.left,str);
		else
			return search (T.right, str);
	}

	public static int CharToAscii(String c) {
		
		char character = c.charAt(0);
		int ascii = (int) character;
		return ascii;

	}


}
