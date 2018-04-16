package com.aiatss.example;

import static com.aiatss.example.AssertUtil.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ExampleTest {
	
	@Test
	public void should_return_6_results_when_given_3_charactors() {
		Anagrams anagrams = new Anagrams();
		
		List<String> result = anagrams.from("ABC");
		
		assertThat(result).containsExactlyInAnyOrder("","ABC","ACB","BAC","BCA","CAB","CBA");
	}
	
	@Test
	public void should_return_means_of_two_integers() {
	    //Given
	    ScoreCollection scores = new ScoreCollection();
	    scores.add(70);
	    scores.add(90);

	    //When
	    int meanValue = scores.getMathMean();

	    //Then
	    assertEquals(80, meanValue);
	}


}
