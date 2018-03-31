package main;

import java.io.IOException;

public class Core {
	
	static int nounCount = 0;
	static int adjCount = 0;
	static String newWord = "";
	static boolean suffix = false;
	
	public static void retry() throws IOException {         /* Randomize another word. */
		System.out.println("Generate again? (yes/no)");
		
		char r = Generator.getChar();
		
		switch (r) {
		case 'y': System.out.println("You chose yes");
		createWord();
		break;
		
		case 'n': System.out.println("You chose no");
				  System.out.println("done");
		break;
		
		default: System.err.println("invalid input");
		retry();
		break;
		}
	}
	
	public static void createWord() throws IOException {        /* Creates a newly randomized word. */
		newWord = "";
		String w;
		String o = "";
		for (int i = 0; i < adjCount; i++) {
			w = Generator.randomAdjective();
			if (w == o) {w = Generator.randomAdjective();} else {}
			newWord = newWord + w + " ";
			w = o;
		}
		
		for (int i = 0; i < nounCount; i++) {
			w = Generator.randomNoun();
			if (w == o) {w = Generator.randomNoun();} else {}
			newWord = newWord + w;
		}
		
		if (suffix == true) {
			newWord = newWord + Generator.randomSuffix();
		} else {}
		
		System.out.println("Your Word:");
		System.out.println("    >>>" + newWord + "<<<");	
		retry();
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Word Generator");
		
		System.out.println("Enter 0 to see lists, any other integer to continue:");  /* Shows word arrays. */
		if (Generator.getInt() == 0) {
			for (int i = 0; i < Generator.adjMax; i++) {
				if (i == 0) {System.out.println(">> Adjectives <<");} else {}
				System.out.println(Generator.adjectives[i]);
				if (i == Generator.adjMax - 1) {System.out.println(" ");} else {}
			}
			for (int i = 0; i < Generator.nounMax; i++) {
				if (i == 0) {System.out.println(">> Nouns <<");} else {}
				System.out.println(Generator.nouns[i]);
				if (i == Generator.nounMax - 1) {System.out.println(" ");} else {}
			}
			for (int i = 0; i < Generator.suffMax; i++) {
				if (i == 0) {System.out.println(">> Suffixes <<");} else {}
				System.out.println(Generator.suffixes[i]);
				if (i == Generator.suffMax - 1) {System.out.println(" ");} else {}
			}
		} else {}
		
		System.out.println("Enter number of nouns:");
		nounCount = Generator.getInt();
		System.out.println("You entered: " + nounCount);
		
		System.out.println("Enter number of adjectives:");
		adjCount = Generator.getInt();
		System.out.println("You entered: " + adjCount);
		
		System.out.println("Should the word have a suffix? (yes/no):");
		char p = Generator.getChar();
		switch (p) {
		case 'y':
			suffix = true;
			break;
			
		case 'n':
			break;
		}
		
		System.out.print("\nThere will be " + adjCount + " " + (adjCount == 1 ? "adjective" : "adjectives") + ", " + nounCount + " " + (nounCount == 1 ? "noun" : "nouns"));
		if (suffix == true) {
			System.out.print(" and a suffix.\n");
		} else {System.out.print(" and no suffix.\n");}
		
		createWord();
	}
}
