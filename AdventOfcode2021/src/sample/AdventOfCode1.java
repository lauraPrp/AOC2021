package sample;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCode1 {

	  public static void main(String args[]) throws IOException {
		  ArrayList<Integer> list = new ArrayList<Integer>();
	        Scanner file = new Scanner(new File("dayOne.txt"));
	        
	        while (file.hasNextLine()) {
	            int line = Integer.parseInt(file.nextLine());
	            list.add(line);
	        }
	        
	        int count = 0;
	        for (int i = 0; i < list.size() - 1; i++) {	
	            if (list.get(i + 1) > list.get(i)) {
	                count++;
	            }
	        }
	        
	        System.out.println(count);
	    }
	}
	
	

