package main;

import java.io.IOException;

public class Core {
	
	static int nounCount = 0;
	static int adjCount = 0;
	static String newWord = "";
	static boolean suffix = false;
	
	public static int choice(String[] prompt) {
		System.out.println("<options>");
		for (int i = 0; i < prompt.length; i++) {
			System.out.println((i + 1) + ": " + prompt[i]);
		}
		System.out.println("Input:");
		int r = Generator.getInt();
		if (r == 0) {
			choice(prompt);
		}
		return r;
	}
	
	public static boolean getBool() {
		boolean b = false;
		char i = Generator.getChar();
		if (i == 'y') {b = true;} else {}
		return b;
	}
	
	public static void retry() throws IOException {         /* Randomize another word. */
		String[] cr = new String[] {
				"Save word to text file.",
				"Randomize another word.",
				"Show saved words."
		};

		switch (choice(cr)) {
		case 1:
			Save.writeSave(", " + newWord);
			System.out.println("'" + newWord + "'" + " has been saved to saved.txt");
			break;
		case 2:
			createWord();
			break;
		case 3:
			Lists.printSaved();
			retry();
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
		
		System.out.print("Your Word:");
		System.out.println("    >>>" + newWord + "<<<");
		retry();
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Word Generator");
		
		System.out.println("Print lists? (yes/no):");  /* Shows word arrays. */
		if (getBool() == true) {
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
		if (getBool() == true) {
			suffix = true;
		} else {}
		
		System.out.print("\nThere will be " + adjCount + " " + (adjCount == 1 ? "adjective" : "adjectives") + ", " + nounCount + " " + (nounCount == 1 ? "noun" : "nouns"));
		if (suffix == true) {
			System.out.print(" and a suffix.\n");
		} else {System.out.print(" and no suffix.\n");}
		createWord();
		retry();
	}
}
