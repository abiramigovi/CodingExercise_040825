package datediffreport;



public class MainApplication {

	public static void main(String[] args) {
		
		String inputFile="input.txt";

		DateDiffFinder diff=new DateDiffFinder();
		diff.calculateDateDiff(inputFile);
		
		if(args.length>1) {
			diff.calculateDateDiff(args[0],args[1]);
		}
		
		
	}
	
	

}
