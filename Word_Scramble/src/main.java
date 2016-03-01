import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int level = 1;
		char[] charlist;
		int[] usedchar;
		int wincount;
		String attempt;
		String word;
		System.out.println("Welcome to Word Scramble! ");
		System.out.println("Here are the rules: \n1. A random word from the English Dictionary will be given in its scrambled form. \n2. The definition and tense will not be given. \n3. You must type the unscrambled word to win that round. \n4. Words will get progressively harder. \n5. If you get 5 in a row correct, you win the game!");
		while (true){
		word = "error, word not found";
		wincount = 0;
		//start level code
		for(level = 1; level < 6; level++){
			try {
				word = wordfind.find(level);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error");
			}//insert subroutine finding word from wordfind
			//Version 1 of the scrambler; doesn't work
			/*usedchar = new int[word.length()];
			charlist = new char[word.length()];
			for (int i = 0; i < word.length(); i++){
				int randlen = (int)(Math.random() * (word.length()));
				usedchar[i] = randlen;
				for(int n = 0; n < word.length(); n++){
					if (randlen == usedchar[n]){
						randlen = (int)(Math.random() * (word.length()));
						n = 0;
					}
				}
				charlist[i] = word.charAt(randlen);
				
			}
			for (int i = 0; i < word.length(); i++){
				System.out.print(charlist[i]);
			}
			*/
			//Version 2; working! However, can still print same string. will work on that later.
			charlist = word.toCharArray();
			Random rgen = new Random();  // Random number generator			
			while (true){
				for (int i=0; i<charlist.length; i++) {
				    int randomPosition = rgen.nextInt(charlist.length);
				    char temp = charlist[i];
				    charlist[i] = charlist[randomPosition];
				    charlist[randomPosition] = temp;
				}
				if (charlist.toString() != word){
					break;
				}
			}
			System.out.println("Your scrambled word is...");
			System.out.println(charlist);
			System.out.println("Guess what word this is when unscrambled!");
			attempt = input.nextLine();
			if (attempt.toLowerCase().trim().equals(word.trim())){
				System.out.println("You got it! On to the next level...");
				wincount++;
			}
			else{
				System.out.println("Too bad! You missed it!");
				System.out.println("The answer was '" + word + "'!");
				break;
			}
		}
		if (wincount == 5){
			System.out.println("Congrats! You beat my game!");
		}
		System.out.println("GAME OVER");
		System.out.println("You won " + wincount + " rounds.");
		System.out.println("Type yes if you would like to play again. Press enter to terminate.");
		if (input.nextLine().toLowerCase()!= "yes"){
			break;
		}
		}
	}

}
