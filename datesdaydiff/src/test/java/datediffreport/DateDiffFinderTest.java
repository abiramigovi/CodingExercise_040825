package datediffreport;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateDiffFinderTest {
	
	public DateDiffFinder dateDiffFinder=new DateDiffFinder();

	@Test
	
    void testValidDates() {
		
        assertTrue(dateDiffFinder.isValidDate("29 02 2020")); 
        assertFalse(dateDiffFinder.isValidDate("31 04 2020")); 
        assertFalse(dateDiffFinder.isValidDate("29 02 2019")); 
        assertFalse(dateDiffFinder.isValidDate("32 01 2020")); 
        assertFalse(dateDiffFinder.isValidDate("31 02 2020")); 
        assertFalse(dateDiffFinder.isValidDate("15 13 2020")); 
        assertFalse(dateDiffFinder.isValidDate("15 07 1899")); 
    }
	
	@Test
    void testDateDifference() {
        assertEquals(0, dateDiffFinder.calculateDateDiff("01 01 2020", "01 01 2020"));
        assertEquals(1, dateDiffFinder.calculateDateDiff("01 01 2020", "02 01 2020"));
        assertEquals(28, dateDiffFinder.calculateDateDiff("01 02 2020", "29 02 2020")); 
        assertEquals(365, dateDiffFinder.calculateDateDiff("01 01 2019", "01 01 2020"));
        assertEquals(-1, dateDiffFinder.calculateDateDiff("01 01 2019", "01 01232020"));
        assertEquals(-1, dateDiffFinder.calculateDateDiff("01 014 2019", "01 01232020"));
        assertEquals(-1, dateDiffFinder.calculateDateDiff(" ", "01 01232020"));
        assertEquals(-1, dateDiffFinder.calculateDateDiff("01 01 2019", " "));
        assertEquals(2, dateDiffFinder.calculateDateDiff("01 01 2019", "03 01 2019"));
        assertEquals(366, dateDiffFinder.calculateDateDiff("31 12 2019", "31 12 2020"));


        


    }

	
   

}
