import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5{
	static ArrayList<Day5.Coordinates> listFilled = new ArrayList<Coordinates>();	
	public static void buildCoordinates(String entry) {

	Coordinates cFirst=new Coordinates(entry.substring(0,entry.indexOf( "->" )-1));
	Coordinates cLast=new Coordinates(entry.substring(entry.indexOf( "->" )+3,entry.length()));
	Coordinates cmiddle = new Coordinates(0,0);
	//controllo se x1 = x2
	if(cFirst.getX()==cLast.getX()) {
				//controllo e ciclo sulle y
	
		if(cFirst.getY()<cLast.getY()) { // x1==x2 & y1<y2
			// x resta uguale, aggiungo le coordinate incrementando di y con j fino ad arrivare al valore y2
			//System.out.println("x1=x2: y1<y2 "+cFirst.getX()+" "+cFirst.getY()+" "+cLast.getX()+" "+cLast.getY());
				for (int j=cFirst.getY();j<=cLast.getY();j++) {//es 2,1->2,3
					cmiddle = new Coordinates(cFirst.getX(), j);
					//System.out.println(cmiddle.getX()+" --"+cmiddle.getY());  
					listFilled.add(cmiddle);
				}
			
			
		}else if (cFirst.getY()>cLast.getY()) { // x1==x2 & y1>y2 //es 2,8->2,3
			//System.out.println("x1=x2: y1>y2 "+cFirst.getX()+" "+cFirst.getY()+" "+cLast.getX()+" "+cLast.getY());
				for (int j=cFirst.getY();j>=cLast.getY();j--) {
					cmiddle = new Coordinates(cFirst.getX(), j);
					//System.out.println(cmiddle.getX()+" --"+cmiddle.getY());  
					listFilled.add(cmiddle);
				}
		}
	}
	if(cFirst.getY()==cLast.getY()) {
		

		if(cFirst.getX()<cLast.getX()) { // x1==x2 & y1<y2
			// x resta uguale, aggiungo le coordinate incrementando di y con j fino ad arrivare al valore y2
			//System.out.println("x1<x2: y1=y2 "+cFirst.getX()+" "+cFirst.getY()+" "+cLast.getX()+" "+cLast.getY());
				for (int j=cFirst.getX();j<=cLast.getX();j++) {//es 2,1->2,3
					cmiddle = new Coordinates( j,cLast.getY());
					//System.out.println(cmiddle.getX()+" --"+cmiddle.getY());  
					listFilled.add(cmiddle);
				}
			
		}else if (cFirst.getX()>cLast.getX()) { // x1>x2 & y1=y2 
				//System.out.println("x1>x2: y1=y2 "+cFirst.getX()+" "+cFirst.getY()+" "+cLast.getX()+" "+cLast.getY());
				for (int j=cFirst.getX();j>=cLast.getX();j--) {
					cmiddle = new Coordinates( j,cLast.getY());
					//System.out.println(cmiddle.getX()+" --"+cmiddle.getY());  
					listFilled.add(cmiddle);
				}
		}
	
	}
	System.out.println("listfilled size"+listFilled.size());
	}
	

	
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		
		String[][] grid = new String[1000][1000];
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
            	grid[row][col] = ".";
            }
        }
	
	       
		Scanner file;
		try {
			file = new Scanner(new File("day5.txt"));
			
			while (file.hasNextLine()) {
		            String line = file.nextLine();
		            list.add(line);
			}
			
			for(int i =0;i<list.size();i++) {
			buildCoordinates(list.get(i));
			}
			
			for(int i=0;i<listFilled.size();i++) {
				Coordinates coor= (Coordinates)listFilled.get(i);
			    if(grid[coor.getX()][coor.getY()].equals(".")) {
			    	grid[coor.getX()][coor.getY()]="1";
			    }
			    else if(!grid[coor.getX()][coor.getY()].equals(".")) {
			    	grid[coor.getX()][coor.getY()]=	""+
			    (Integer.parseInt(grid[coor.getX()][coor.getY()])+1);
			    }
			}
			
			
			int counter=0;
		       for(int i=0;i<1000;i++) {
		    	   for(int j=0;j<1000;j++) {
		    		   if(!grid[i][j].equals(".")) {
		    			int gridVal= Integer.parseInt(grid[i][j]);
		    			//System.out.println(gridVal);
		    		   if(gridVal>=2) counter++;
		    		   }
		    	   }
		       } 
		       System.out.println("result: "+counter);
			
			
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	static  class Coordinates {

		int x;
		int y;
			/**
		 * @param x
		 * @param y
		 */
		public Coordinates(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Coordinates(String xy) {
			super();
			int x=Integer.parseInt(xy.substring(0,xy.indexOf(",")));
			int y=Integer.parseInt(xy.substring(xy.lastIndexOf(",")+1, xy.length()).trim());
			
			this.x = x;
			this.y = y;
		}
		
			public int getX() {
				return x;
			}
			
			public int getY() {
				return y;
			}
			
	}	
	
}
