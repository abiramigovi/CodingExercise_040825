package datediffreport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DateDiffFinder {
	
	public void calculateDateDiff(String inputFile) {
		 String outputFile = "output.txt";
		try {
			InputStream is;
			
			is = getClass().getClassLoader().getResourceAsStream(inputFile);
			
			 if(is==null) {
				  System.err.println("Error:  file not found at path: " + inputFile);
			 }else {
				 BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			       
				 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
				 
				String date1;
		        String date2;
		        int pairNumber = 0;

		        while ((date1 = reader.readLine()) != null && (date2 = reader.readLine()) != null) {
		                System.out.println( ++pairNumber + " : " +date1+" - "+date2);
		                
		                if(isValidDate(date1)&&isValidDate(date2)) {
		    				int diff=calculateDayDiff(date1,date2);
		    				if(diff>=0) {
		    				writer.write(date1+", "+date2+", Days Difference  "+diff);
		    				writer.newLine();
		    				}
		    			}
		    			
		                
		        }
		        if(pairNumber==0) {
		        	System.out.println("Input file empty");
		        }
		        writer.close();
			 }
				 
			 }catch (IOException e) {
		            System.out.println("Error reading the file: " + e.getMessage());
		     }catch (Exception e) {
		            System.out.println("Error reading the file: " + e.getMessage());
		     }
		
	
		
			
	}
	
	public int calculateDateDiff(String date1, String date2) {
		if(isValidDate(date1)&&isValidDate(date2)) {
			return calculateDayDiff(date1,date2);
		}
		
		return -1;
	}
	
	public  boolean isValidDate(String date) {
		
		if(date==null) {
			System.out.println("Date is empty");
			return false;
		}
		
		date=date.trim();
		
        String datePattern = "(0[1-9]|[12][0-9]|3[01])\\s" +        
                "(0[1-9]|1[0-2])\\s" +                 
                "(19\\d{2}|200\\d|201\\d|2020)";   

		if (date == null || !date.matches(datePattern)) {
			System.out.println(date+" -not valid date");
            return false;
        }
		
		String[] dateValues=date.split(" ");
		int days=Integer.parseInt(dateValues[0]);
		int month=Integer.parseInt(dateValues[1]);
		int year=Integer.parseInt(dateValues[2]);
		if(days>getMonthDays(month,year)) {
			System.out.println(date+" -not valid date");
			return false;
		}
		return true;
	}
	
	public  boolean isLeapYear(int year) {
		if(year%4==0)
			return true;
		else
			return false;
	}
	public  int getMonthDays(int month, int year) {
		switch(month) {
			case 2: 
				return isLeapYear(year) ?29:28;
			case 4:case 6: case 9:case 11:
				return 30;
			default: 
				return 31;
		}
			

	}
	public  int calculateDayDiff(String earliest,String latest ) {
		
		int totalDays1=calculateTotalDays(earliest);
		int totalDays2=calculateTotalDays(latest);
		
		//System.out.println(calculateTotalDays(earliest));
		//System.out.println(calculateTotalDays(latest));
		int diff=totalDays2-totalDays1;
		if(totalDays1>totalDays2) {
			diff=totalDays1-totalDays2;
			System.out.println(latest+", "+earliest+", Days Difference  "+diff);
	        return diff;
		}
		
		
		System.out.println(earliest+", "+latest+", Days Difference  "+diff);
		
		return diff;
		
	}
	
	public  int calculateTotalDays(String earliest) {
		String[] dateValues=earliest.split(" ");
		int days=Integer.parseInt(dateValues[0]);
		int month=Integer.parseInt(dateValues[1]);
		int year=Integer.parseInt(dateValues[2]);
		int totalDays=days;
		for(int i=1;i<month;i++) {
			totalDays+=getMonthDays(i,year);
		}
		for(int i=0;i<year;i++) {
			totalDays+=isLeapYear(i) ?366:365;
		}
		return totalDays;
	}

}
