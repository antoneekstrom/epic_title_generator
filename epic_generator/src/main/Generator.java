package main;

import java.util.concurrent.ThreadLocalRandom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generator {
	
	public static String[] nouns = new String[] {
			"turd",
			"boi",
			"steve",
			"trash",
			"garbage",
			"person",
			"human",
			"lump",
			"butt",
			"man",
	};
	public static String[] adjectives = new String[] {
			"not epic",
			"stinky",
			"bouncy",
			"uncool",
			"garbage",
			"mushy",
			"small",
			"actual",
			"poopy",
			"moist",
			"thick",
	};
	public static String[] suffixes = new String[] {
			"lord",
			"master",
			"eater",
			"consumer",
			"sniffer",
			"licker",
	};
	public static int nounMax = nouns.length;
	public static int adjMax = adjectives.length;
	public static int suffMax = suffixes.length;
	static int min = 0;
	
	public static int getInt() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		try {
			i = Integer.parseInt(reader.readLine());
		}
		catch (Exception e){
			System.err.println("Invalid Format");
		}
		
		return i;
	}
	
	public static String getString() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		
		return s;
	}
	
	public static char getChar() {
		char c = 0;
		try {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		c = reader.readLine().charAt(0);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		return c;
	}
	public static String randomNoun() {

		int r = ThreadLocalRandom.current().nextInt(min, nounMax);
		String w = nouns[r];
		return w;
	}
	public static String randomAdjective() {
		
		int r = ThreadLocalRandom.current().nextInt(min, adjMax);
		String w = adjectives[r];
		return w;
	}
	
	public static String randomSuffix() {
		int r = ThreadLocalRandom.current().nextInt(min, suffMax);
		String w = suffixes[r];
		return w;
	}
	
	public static void main(String[] args) throws IOException {  /* main */
		/*char c = getChar(); uncomment if things stop working, remove if they don't
		System.out.println(c);*/
		
		String[] c1 = new String[] {
				"henlo",
				"u",
				"stinky",
		};
		Core.choice(c1);
	}
}