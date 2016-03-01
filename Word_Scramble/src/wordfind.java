import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class wordfind {

	public static String find(int range) throws FileNotFoundException {
		File file = new File("C:/Dictionaries/commonwords.txt");
		Scanner dict = new Scanner(new FileReader(file));
		String word = "hello";
		int index = (int) ((Math.random() + (range-1))*200);
		for (int i = 0; i<index; i++){
			word = dict.nextLine();
		}
		dict.close();
		return word;
	}
	public static void main(String[] args) {
	}
		
	}
