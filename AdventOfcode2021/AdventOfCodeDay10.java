package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * thanks @clumsveed for the suggestion 
*/

public class AdventOfCodeDay10 {
	private ArrayList<String> input = new ArrayList<String>();
	private ArrayList<Long> scores  = new ArrayList<Long>(); 
	private HashMap<Character, Character> mapOpenClose = new HashMap<Character, Character>();
	private HashMap<Character, Character> mapCloseOpen = new HashMap<Character, Character>();
	private HashMap<Character, Integer> sintaxErrValues = new HashMap<Character, Integer>();
	private HashMap<Character, Integer> symbolValue = new HashMap<Character, Integer>();

	public Day10() throws IOException {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("day10.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (reader.hasNext()) {
			input.add(reader.nextLine());
		}
		reader.close();


		mapOpenClose.put('(', ')');
		mapOpenClose.put('[', ']');
		mapOpenClose.put('{', '}');
		mapOpenClose.put('<', '>');


		mapCloseOpen.put(')', '(');
		mapCloseOpen.put(']', '[');
		mapCloseOpen.put('}', '{');
		mapCloseOpen.put('>', '<');

		// maps the illegal char to the value 
		sintaxErrValues.put(')', 3);
		sintaxErrValues.put(']', 57);
		sintaxErrValues.put('}', 1197);
		sintaxErrValues.put('>', 25137);

		// maps a symbol/value
		symbolValue.put(')', 1);
		symbolValue.put(']', 2);
		symbolValue.put('}', 3);
		symbolValue.put('>', 4);

	}

	public static void main(String args[]) {

		try {
			Day10 d = new Day10();
			d.part1();
			d.part2();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void part1() {
		int errorScore = 0; 


		for (String in : input) {
			String strInput = inputParser(in);
			if (strInput.contains("WRONG")) {
				char illegal = strInput.charAt(strInput.length() - 1);
				errorScore += sintaxErrValues.get(illegal);
			} else {
				// generate scores for part 2
				scores.add(getScore(strInput));
			}
		}
		System.out.println(errorScore);
	}

	public void part2() {
		scores.sort(null); //here was the mistake! without sorting to null the result is too big
		System.out.println(scores.get(scores.size() / 2));
	}

	public String inputParser(String s) {
		String resStr = "";
		Stack<Character> serviceStack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{' || c == '<') {
				serviceStack.add(c);
			} else if (!(serviceStack.pop() == mapCloseOpen.get(c))) { //this is the crucial part, c is the unmatched closing char
				return "WRONG " + Character.toString(c);
			}
		}


		while (serviceStack.size() > 0) { //incomplete stack
			resStr += mapOpenClose.get(serviceStack.pop());
		}
		return resStr;
	}

	public long getScore(String closures) {
		long sum = 0;
		for (int i = 0; i < closures.length(); i++) {
			sum *= 5;
			sum += symbolValue.get(closures.charAt(i));
		}
		return sum;
	}



}
