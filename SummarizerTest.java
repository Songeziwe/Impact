/** Class model to test the Summarizer class
  *
  * @author Songeziwe S. Soboois
*/

// JUnit imports
import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Java packages
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class SummarizerTest {
	
	@Test
	public void TestGiveMeBack(){
		Summarizer summarizer = new Summarizer();
		int result = summarizer.giveMeBack(1);
		assertEquals(1, result);
	}

	@Test
	public void TestCollect(){
		Collection<Integer> target_collection = new ArrayList<Integer>(10);
		for (int i = 1; i <= 10; i++) {
			target_collection.add(i);
		}
		Summarizer summarizer = new Summarizer();
		Collection<Integer> result = summarizer.collect("1,2,3,4,5,6,7,8,9,10");

		Iterator<Integer> result_iter = result.iterator();
		Iterator<Integer> target_iter = target_collection.iterator();

		boolean isEqual = true;
		while(target_iter.hasNext()){
			if(result_iter.next() != target_iter.next()){
				isEqual = false;
				break;
			}
		}
		if(isEqual)
			System.out.println("TestCollect() PASSED");
		else
			System.out.println("TestCollect() FAILED");
	}

	@Test
	public void Test1SummarizeCollection(){
		Summarizer summarizer = new Summarizer();
		Collection<Integer> collection = summarizer.collect("1,2,3");
		String result = summarizer.summarizeCollection(collection);

		assertEquals("1-3", result);
	}

	@Test
	public void Test2SummarizeCollection(){
		Summarizer summarizer = new Summarizer();
		Collection<Integer> collection = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		String result = summarizer.summarizeCollection(collection);

		assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
	}

	@Test
	public void Test3SummarizeCollection(){
		Summarizer summarizer = new Summarizer();
		Collection<Integer> collection = summarizer.collect("1,2,3,4,5,10,50,49,48,47");
		String result = summarizer.summarizeCollection(collection);

		assertEquals("1-5, 10, 50-47", result);
	}
}