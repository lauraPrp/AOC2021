package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

public class Day6 {
public static ArrayList<Integer> decreaseList(ArrayList<Integer> listNumToDecrease) {
int dim = listNumToDecrease.size();
int add =0;
	ArrayList<Integer> returnList = new ArrayList<Integer>();
	for(int i=0;i<dim;i++) {
		 
		int newNum=listNumToDecrease.get(i);
		if(newNum-1<0) {
			newNum=6;
			add++;
		}else {
			newNum--;
		}
		
	returnList.add(newNum);
	}
	while(add>0) {
		returnList.add(8);
		add--;
	}
	
	System.out.println(returnList);
	return returnList;
	
}
	
	public static void main(String[] args) {
		
		try {
			ArrayList<Integer> list = new ArrayList<Integer>();
			Scanner textfile;
			textfile = new Scanner(new File("day6.txt"));
			textfile.useDelimiter(Pattern.compile(","));
			while (textfile.hasNextInt()) {
				//System.out.println(""+textfile.nextInt());
				list.add(textfile.nextInt());
		}			

			long[] counts = new long[9];
			
			for(Integer unit :list) {
				counts[unit]++;
			}
			for(int i=0;i<256;i++) {
				long[] newGenerationCounts=new long[9];
				newGenerationCounts[8]=counts[0];
				newGenerationCounts[7]=counts[8];
				newGenerationCounts[6]=counts[7]+counts[0];
				newGenerationCounts[5]=counts[6];
				newGenerationCounts[4]=counts[5];
				newGenerationCounts[3]=counts[4];
				newGenerationCounts[2]=counts[3];
				newGenerationCounts[1]=counts[2];
				newGenerationCounts[0]=counts[1];
		counts=Arrays.copyOf(newGenerationCounts, 9);
			}
			
			System.out.println(LongStream.of(counts).sum());
 			
			
/*			
		
for(int i=80;i>0;i--) {
	list= new ArrayList<Integer>( decreaseList(list)) ;
}		
	System.out.print("part 1:"+list.size());

	System.out.print("part 2: too many fishes" );
	*/	
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}

	}

}
