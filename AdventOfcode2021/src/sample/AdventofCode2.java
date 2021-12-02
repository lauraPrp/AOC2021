package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventofCode2 {
	
			public static void main(String args[])  throws FileNotFoundException, IOException {
			    Map<String, Integer> map = new HashMap();
			    map.put("depth", 0);
			    map.put("forward", 0);
			    map.put("aim", 0);
			    File puzzleFile = new File("Puzzle.txt");
			    
			    BufferedReader br = new BufferedReader(new FileReader(puzzleFile));
			    
			    String line;
			    while ((line = br.readLine()) != null) {
			        String[] split = line.split(" ");
			        if(split[0].equals("down")){
			         map.put("aim", (map.get("aim") + Integer.parseInt(split[1])));
			        } 
			        else if (split[0].equals("up")){
			         map.put("aim", (map.get("aim") - Integer.parseInt(split[1])));
			        } 
			        else if (split[0].equals("forward")){
			         map.put("forward", (map.get("forward") + Integer.parseInt(split[1])));
			         map.put("depth", (map.get("depth") + (map.get("aim") * Integer.parseInt(split[1]))));
			        }    
			    }
			    System.out.println(map.get("depth") * map.get("forward"));
			}
}