package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Day7 {

	static List<Integer> positions = new ArrayList<>();


	public static Long solve(boolean part,int min, int max) {
		int low = min;
		int high = max;
		long lowest = Long.MAX_VALUE;

		for (int current = low; current <= high; current++) {
			long moves = 0L;

			for (int pos : positions) {
				long dist = Math.abs(pos - current);
				moves += part ? (dist * (dist + 1)) / 2 : dist;
			}

			if (lowest > moves) {
				lowest = moves;
			}
		}
		return lowest;
	}



	public static void main(String args[]) {
		try {
			ArrayList<String> list = new ArrayList<String>();
			Scanner input = new Scanner(new File("day7.txt"));

			while (input.hasNextLine()) {
				String line = input.nextLine();
				list.add(line);
			}



			String line = list.get(0);
			int[] startingPositions = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
			for (String s : line.split(",")) {
				int pos = Integer.parseInt(s);
				positions.add(pos);


				int max = Arrays.stream(startingPositions).max().getAsInt();
				int min = Arrays.stream(startingPositions).min().getAsInt();
				System.out.println("part1 :" + solve(false,min,max));
				System.out.println("part2 :" + solve(true,min,max));


				/* 
				 * OLD PART 1
				 * 
 long minFuel = Long.MAX_VALUE;
   for (int i = 0; i <= max; i++){
			long fuel = 0;
			for (int pos : startingPositions) {
			    int n = Math.abs(pos - i);
			    if (n != 0) {
			        fuel += (n * (n + 1)) / 2;
			    }
			}
			if (fuel <= minFuel) minFuel = fuel;
   }

   System.out.println(minFuel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 */
			}
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
}