/** Class model to summarize a sequence of numbers
 *
 * @author Songeziwe S. Soboois
 */

// Imports
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class Summarizer implements NumberRangeSummarizer {

	// To check if JUnit works
	int giveMeBack(int number){
		return number;
	}
	
	// Create a collection of integers out of the input string
	public Collection<Integer> collect(String input) {
		String[] list_ = input.split(",");
		Collection<Integer> collection = new ArrayList<Integer>(list_.length);

		// Populate the Collection of integers
		// Time complexity is O(n)
		try{
			for (String element:list_) 
				collection.add(Integer.parseInt(element));
		}catch(NumberFormatException e){
			System.out.println("Error: please provide a sequence of numbers e.g. 1,2,3,4,3,5,3\nThe digits must be comma seperated.");
			System.out.println("Your input was " + input);
			System.exit(0);
		}
		return collection;
	}

	// get the summarized string
    // return the result
    public String summarizeCollection(Collection<Integer> input){
    	if(input.size() == 0){
    		System.out.println("collection is empty.");
    		System.exit(0);
    	}

    	// Declare and initialize an iterator for the collection
    	Iterator<Integer> iter = input.iterator();
    	
    	// variable to store the output string
    	String result = "";
		
		// variables to track collection values    	
    	Integer lower 	  = Integer.MIN_VALUE;
    	Integer prev 	  = Integer.MIN_VALUE;   	
		Integer current	  = Integer.MIN_VALUE;
    	Integer nextValue = Integer.MIN_VALUE;

    	String hyphen   = "-";
    	boolean isLower = false;

    	int iteration = 0;

    	// iterate through the collection 
    	while(iter.hasNext()) {
    		
    		if(iteration == 0){ current = iter.next(); ++iteration; }

    		if(iter.hasNext()){ nextValue = iter.next(); }

 	   		if(Math.abs(prev - current) == 1 || Math.abs(nextValue - current) == 1) {
    			// identify lower bound
    			if(!isLower) {
    				lower   = current;
    				isLower = !isLower;
    			}
    			// identify upper bound
    			else if(Math.abs(nextValue - current) != 1 ){
    				result += lower + hyphen + current + ", ";
	    			isLower = false;
	    			if(!iter.hasNext())
	    				result += nextValue;
    			}else if( !(iter.hasNext()) ) {
    				result += lower + hyphen + nextValue;
    			}
    		}else{
    			if(iter.hasNext())
    				result += current + ", ";
    			else
    				result += nextValue;
    		}
    		// update the prev and current variables for the next iteration of the loop
    		prev = current;
    		current = nextValue;
    	}
    	return result;
    }
}