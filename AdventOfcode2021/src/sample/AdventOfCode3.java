import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCode3 {
  
public static int convertoBinary(int[] charlist) {
   StringBuilder strB = new StringBuilder("");
   for(int i=0;i<charlist.length;i++){
   	  strB.append(charlist[i]);    
    }
   return Integer.parseInt(strB.toString(),2);
}

public static ArrayList<String> load(ArrayList<String> list,String filename) throws FileNotFoundException{	
    Scanner file = new Scanner(new File(filename));  
    while (file.hasNextLine()) {
        String line = file.nextLine();
        list.add(line);
    }
    return list;
}

public static int getPowerConsumption(ArrayList<String> list) {
    int elemLEn= list.get(0).length();
    int [] gamma = new int[elemLEn]; 
    int [] eps = new int[elemLEn]; 
   
    for(int x =0;x<elemLEn;x++) {
    	int count1=0;
    	int count0=0;
    	for(int i=0;i<list.size();i++) {
	        	if(list.get(i).charAt(x)=='0') 
	        		count0++;
	        	else 
	        		count1++;
    	}
    	
    	 if(count0>count1) {
    		 gamma[x]=0;
    	 	 eps[x]=1;
    	 }
    	 else { 
    		 gamma[x]=1;
    		 eps[x]=0;
    	 }
    }
    return convertoBinary(gamma)*convertoBinary(eps);
}

public static void main(String args[]) throws IOException {
	 ArrayList<String> list = new ArrayList<String>();
	 list=load(list,"day3.txt");
	 int powerConsumption =getPowerConsumption(list);
	     
   System.out.print( "part1 :"+ powerConsumption);  
}
}


