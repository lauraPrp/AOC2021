package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Day8 {

	public static void main(String[] args) {
    int sum = 0;
     try{
        ArrayList<String> list = new ArrayList<String>();
        String vals = "";
        
        Scanner textfile = new Scanner(new File("day8.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        for(int i = 0; i<list.size(); i++) {
           vals+=list.get(i).substring(list.get(i).indexOf("|")+1, list.get(i).length());
        }
        String[] values = vals.split(" ");
        for(int i = 0; i< values.length; i++){
            if(values[i].length()==2){
                sum++;
            }
            if(values[i].length()==3){
            	sum++;
            }
            if(values[i].length()==4){
            	sum++;
            }
            if(values[i].length()==7){
            	sum++;
            }
        }
        
     } catch(FileNotFoundException fnf){
       fnf.printStackTrace();
     }
    System.out.println(sum);
    }
}
