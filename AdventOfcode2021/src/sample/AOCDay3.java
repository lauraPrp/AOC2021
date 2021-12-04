package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AOCDay3 {

public static void main(String args[]) throws IOException {
	String gamma_rate; //most common bit
	String epsilon_rate; //least common bit
	 int powerConsumption;
	  ArrayList<String> list = new ArrayList<String>();
      Scanner file = new Scanner(new File("day3.txt"));
     
      while (file.hasNextLine()) {
          String line = file.nextLine();
          list.add(line);
      }
      
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
      
StringBuilder strB = new StringBuilder("");
StringBuilder strBE = new StringBuilder("");

      for(int i=0;i<gamma.length;i++){
    	  strB.append(gamma[i]);    
    	  strBE.append(eps[i]); 
      }
      gamma_rate =strB.toString();
      epsilon_rate =strBE.toString();
      powerConsumption =Integer.parseInt(gamma_rate,2)*(Integer.parseInt(epsilon_rate,2));
   System.out.print( powerConsumption);  
      


}

}


