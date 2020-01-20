//Julianna Ngo's ListTester.java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListTester {
	
	public static void main(String[] args) {
		
		//----------------------N = 10--------------------------------------
		ArrayList<Number> partA10AL = new ArrayList<>();
		FileList<Number> partA10FL = new FileList<>("partAN10FL.txt");
		
		ArrayList<Number> partB10AL = new ArrayList<>();
		FileList<Number> partB10FL = new FileList<>("partBN10FL.txt");
		adder(10, partB10AL);
		adder(10, partB10FL);
		
		ArrayList<Number> partC10AL = new ArrayList<>();
		FileList<Number> partC10FL = new FileList<>("partCN10FL.txt");
		adder(10, partC10AL);
		adder(10, partC10FL);
		String s1 = "ArrayList: In ms, N = 10, ADD: start = "
				+addBeginning(10, partA10AL)+ ", end = " 
				+ addEnd(10, partA10AL)+ ", rnd = "
				+addRnd(10, partA10AL) + "\tRMV: start = "+rmvBeginning(10, partB10AL)
				+", end = ";
		adder(10, partB10AL);
		s1 += rmvEnd(10, partB10AL) + ", rnd = ";
		adder(10, partB10AL);
		s1 += rmvRnd(10, partB10AL) + "\tRMV BY VALUE: " + rmvByValue(10, partC10AL)+"\n\n";
		s1 += "FileList: In ms, N = 10, ADD: start = "
				+addBeginning(10, partA10FL)+ ", end = " 
				+addEnd(10, partA10FL)+ ", rnd = "
				+addRnd(10, partA10FL) + "\tRMV: start = "+rmvBeginning(10, partB10FL)
				+", end = ";
		adder(10, partB10FL);
		s1 += rmvEnd(10, partB10FL) + ", rnd = ";
		adder(10, partB10FL);
		s1 += rmvRnd(10, partB10FL) + "\tRMV BY VALUE: " + rmvByValue(10, partC10FL)+"\n\n";
		System.out.print(s1);
		//----------------------N = 100--------------------------------------
		ArrayList<Number> partA100AL = new ArrayList<>();
		FileList<Number> partA100FL = new FileList<>("partAN100FL.txt");
		
		ArrayList<Number> partB100AL = new ArrayList<>();
		FileList<Number> partB100FL = new FileList<>("partBN100FL.txt");
		adder(100, partB100AL);
		adder(100, partB100FL);
		
		ArrayList<Number> partC100AL = new ArrayList<>();
		FileList<Number> partC100FL = new FileList<>("partCN100FL.txt");
		adder(100, partC100AL);
		adder(100, partC100FL);
		
		String s2 = "ArrayList: In ms, N = 100, ADD: start = "
				+addBeginning(100, partA100AL)+ ", end = " 
				+addEnd(100, partA100AL)+ ", rnd = "
				+addRnd(100, partA100AL) + "\tRMV: start = "+rmvBeginning(100, partB100AL)
				+", end = ";
		
		adder(100, partB100AL);
		s2 += rmvEnd(100, partB100AL) + ", rnd = ";
		adder(100, partB100AL);

		s2 += rmvRnd(100, partB100AL) + "\tRMV BY VALUE: " + rmvByValue(100, partC100AL)+"\n\n";
		s2 += "FileList: In ms, N = 100, ADD: start = "
				+addBeginning(100, partA100FL)+ ", end = " 
				+ addEnd(100, partA100FL)+ ", rnd = "
				+addRnd(100, partA100FL) + "\tRMV: start = "+rmvBeginning(100, partB100FL)
				+", end = ";
		adder(100, partB100FL);
		s2 += +rmvEnd(100, partB100FL) + ", rnd = ";
		adder(100, partB100FL);
		s2 += rmvRnd(100, partB100FL) + "\tRMV BY VALUE: " + rmvByValue(100, partC100FL)+"\n\n";
		System.out.print(s2);
		
		//----------------------N = 1000--------------------------------------
		ArrayList<Number> partA1000AL = new ArrayList<>();
		FileList<Number> partA1000FL = new FileList<>("partAN1000FL.txt");
		
		ArrayList<Number> partB1000AL = new ArrayList<>();
		FileList<Number> partB1000FL = new FileList<>("partBN1000FL.txt");
		adder(1000, partB1000AL);
		adder(1000, partB1000FL);
		
		ArrayList<Number> partC1000AL = new ArrayList<>();
		FileList<Number> partC1000FL = new FileList<>("partCN1000FL.txt");
		adder(1000, partC1000AL);
		adder(1000, partC1000FL);
		
		String s3 = "ArrayList: In ms, N = 1000, ADD: start = "
				+addBeginning(1000, partA1000AL)+ ", end = " 
				+addEnd(1000, partA1000AL)+ ", rnd = "
				+addRnd(1000, partA1000AL) + "\tRMV: start = "+rmvBeginning(1000, partB1000AL)
				+", end = ";
		adder(1000, partB1000AL);
		s3 += rmvEnd(1000, partB1000AL) + ", rnd = ";
		adder(1000, partB1000AL);
		s3 += rmvRnd(1000, partB1000AL) + "\tRMV BY VALUE: " + rmvByValue(1000, partC1000AL)+"\n\n";
		s3 += "FileList: In ms, N = 1000, ADD: start = "
				+addBeginning(1000, partA1000FL)+ ", end = " 
				+ addEnd(1000, partA1000FL)+ ", rnd = "
				+addRnd(1000, partA1000FL) + "\tRMV: start = "+rmvBeginning(1000, partB1000FL)
				+", end = ";
		adder(1000, partB1000FL);
		s3 += rmvEnd(1000, partB1000FL) + ", rnd = ";
		adder(1000, partB1000FL);
		s3 += rmvRnd(1000, partB1000FL) + "\tRMV BY VALUE: " + rmvByValue(1000, partC1000FL)+"\n\n";
		System.out.print(s3);
		
		
		//Write all strings to File "testrun.txt"
		File testRun = new File ("testrun.txt");
		try {
			testRun.createNewFile();
			Thread.sleep(1);
			FileWriter sw = new FileWriter(testRun);
			sw.write(s1+s2+s3);
			sw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//HELPER METHODS--------------------------------------------
	/**
	 * Adds N random integers to the specified list
	 * 
	 * @param N
	 * @param list
	 */
	//Formula for Integer random based on Vytautas' code available at:
	//https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	public static void adder(int N, List list) {
		list.clear();
		int random;
		for (int i = 0; i < N; i++) {
			random = (int)(Math.random()*(10*N));
			list.add(random);
		}
	}
	
	//PART A---------------------------------------------------
	
	/**
	 * Adds N random numbers to the beginning of specified list
	 * 
	 * @param N
	 * @param list
	 * @return time (in ms) it takes to add N random numbers to the beginning of list
	 */
	public static Long addBeginning(int N, List list) {
		int random;
		int range = 10*N;
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			random = (int)(Math.random()*range);
			list.add(0, random);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}
	
	
	/**
	 * Adds N random numbers to the end of the list
	 * 
	 * @param N
	 * @param list
	 * @return time (in ms) that it takes to add N random numbers to the end of the specified list
	 */
	public static Long addEnd(int N, List list) {
		int random;
		int range = 10*N;
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			random = (int)(Math.random()*range);
			list.add(random);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}
	
	/**
	 * Adds N random numbers to random indices of the specified list
	 * 
	 * @param N
	 * @param list
	 * @return time (in ms) that it takes to add N random numbers to a list at random indices
	 */
	//Formula for int randomI based on user2512642's code available at:
	//https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	public static Long addRnd(int N, List list) {
		int random;
		int randomI;
		int range = 10*N;
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			random = (int)(Math.random()*range);
			randomI = (int)(Math.random()*i);
			list.add(randomI, random);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}
	
	///PART B-----------------------------------------------------
	
	/**
	 * Removes N numbers from beginning of list
	 * 
	 * @param N
	 * @param list
	 * @return time it takes to remove N number from the beginning of list (in ms)
	 */
	public static Long rmvBeginning(int N, List list) {
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			list.remove(0);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		return endTime;
	}
	
	/**
	 * Removes N numbers from the end of the given list
	 * 
	 * @param N
	 * @param list
	 * @return time it takes to remove N numbers at the end of list (in ms)
	 */
	public static Long rmvEnd(int N, List list) {
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			list.remove(N-i-1);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}

	/**
	 * Removes N numbers from the given list at random indices
	 * 
	 * @param N
	 * @param list
	 * @return time it takes to remove N numbers randomly (in ms)
	 */
	//Formula for int randomI based on user2512642's code available at:
	//https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	public static Long rmvRnd(int N, List list) {
		int randomI;
		Long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			randomI = (int)(Math.random()*(N-i));
			list.remove(randomI);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}
	//PART C--------------------------------------------------
	
	/**
	 * Removes N items from the given list by their values.
	 * 
	 * @param N
	 * @param list
	 * @return time it takes to remove N numbers from a list by their values (in ms)
	 */
	//Formula for Integer random based on Vytautas' code available at:
	//https://stackoverflow.com/questions/5271598/java-generate-random-number-between-two-given-values
	public static Long rmvByValue(int N, List list) {
		int N10 = N*10;
		Long startTime = System.currentTimeMillis();
		while (list.size() > 0) {
			Integer random = (int)(Math.random()*(N10));
			list.remove(random);
		}
		Long endTime = System.currentTimeMillis() - startTime;
		list.clear();
		return endTime;
	}
}
