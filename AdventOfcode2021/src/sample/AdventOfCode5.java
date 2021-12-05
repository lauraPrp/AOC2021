import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* part 1 rough version : AdventOfcode2021/src/sample/Day5.java
* part 2 clean and inspired by https://github.com/topaz 
*/
public class AdventOfCode5 {
	
	
	public static void main(String args[]) {
		List<String> input = new ArrayList<String>();
		 try {
			 Scanner sc = new Scanner(new File("day5.txt"));
			 while(sc.hasNextLine()) {
				 input.add(sc.nextLine());
			 }
			part1(input);
			part2(input);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void part1(List<String> input) {
		int[][] map = new int[1000][1000];
		int x1, x2, y1, y2;
		for (String line : input) {
			String[] p1 = line.substring(0, line.indexOf(" ")).split(",");
			String[] p2 = line.substring(line.lastIndexOf(" ") + 1).split(",");
			x1 = Integer.parseInt(p1[0]);
			y1 = Integer.parseInt(p1[1]);
			x2 = Integer.parseInt(p2[0]);
			y2 = Integer.parseInt(p2[1]);
			if (x1 == x2) {
				// This is a vertical line.
				// Let's find the lower y-value and work our way up to the higher y-value.
				int lowY = Math.min(y1, y2);
				int highY = Math.max(y1, y2);
				for (int y = lowY; y <= highY; y++) {
					map[x1][y]++;
				}
			} else if (y1 == y2) {
				// This is a horizontal line.
				// Let's find the lower x-value and work our way up to the higher x-value.
				int lowX = Math.min(x1, x2);
				int highX = Math.max(x1, x2);
				for (int x = lowX; x <= highX; x++) {
					map[x][y1]++;
				}
			}
		}

		int count = 0;
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map[0].length; x++) {
				if (map[y][x] >= 2) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void part2(List<String> input) {
		int[][] grid = new int[1000][1000];
		int x1, x2, y1, y2;
		for (String line : input) {
			String[] p1 = line.substring(0, line.indexOf(" ")).split(",");
			String[] p2 = line.substring(line.lastIndexOf(" ") + 1).split(",");
			x1 = Integer.parseInt(p1[0]);
			y1 = Integer.parseInt(p1[1]);
			x2 = Integer.parseInt(p2[0]);
			y2 = Integer.parseInt(p2[1]);

			if (y1 == y2) {
				int lowX = Math.min(x1, x2);
				int highX = Math.max(x1, x2);
				for (int x = lowX; x <= highX; x++) {
					grid[y1][x]++;
				}
			} else if (x1 == x2) {
				int lowY = Math.min(y1, y2);
				int highY = Math.max(y1, y2);
				for (int y = lowY; y <= highY; y++) {
					grid[y][x1]++;
				}
			} else {
				int diff = (y2 - y1) / (x2 - x1);
				if (diff == 1) {//  line goes down/ right.
					if (x1 < x2) {// (x1, y1) is the leftmost point
						int y = y1;
						for (int x = x1; x <= x2; x++) {
							grid[y][x]++;
							y++;
						}
					} else if (x2 < x1) {// (x2, y2) is the leftmost point
						int y = y2;
						for (int x = x2; x <= x1; x++) {
							grid[y][x]++;
							y++;
						}
					}
				} else if (diff == -1) {//  line goes up/ right.
					if (x1 < x2) {// (x1, y1) is the leftmost point
						int y = y1;
						for (int x = x1; x <= x2; x++) {
							grid[y][x]++;
							y--;
						}
					} else if (x2 < x1) {// (x2, y2) is the leftmost point
						int y = y2;
						for (int x = x2; x <= x1; x++) {
							grid[y][x]++;
							y--;
						}
					}
				}
			}
		}

		int res = 0;
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				if (grid[y][x] >= 2) {
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
