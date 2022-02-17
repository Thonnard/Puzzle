package input.puzzle;

import java.util.ArrayList;
import java.util.List;

// class to mix the puzzle solution
// output is a string containing all characters of the solution in random order with spaces in between
public class MixSolution {

	public String mix(String input){
		
		// add characters to ArrayList
		List<Character> characters = new ArrayList<Character>();
		for(char c:input.toCharArray()){
			characters.add(c);
		}
		
		// create string for mixed solution
		StringBuilder mixedSolution = new StringBuilder(input.length());
		while(characters.size()!=0){
			int randPicker = (int)(Math.random()*characters.size());
			mixedSolution.append(characters.remove(randPicker));
		}
		
		// return String of mixed solution
		return(mixedSolution.toString().replace("", " ").trim());
	}
}