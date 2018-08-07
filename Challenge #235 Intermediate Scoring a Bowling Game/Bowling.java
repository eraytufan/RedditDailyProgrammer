import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bowling {
	
	
	public static void calculate(String array[]) {
		int totalScore =0;
		int[] firstPoint = new int[10];
		int[] secondPoint = new int[10];
		int[] score = new int[10];
		boolean[] strike = new boolean[10];
		boolean[] spare = new boolean[10];
		
		Arrays.fill(firstPoint, 0);
		Arrays.fill(secondPoint, 0);
		
		for(int i= 0; i<array.length; i++) {
			if(array[i].equals("X")) {
				score[i] = 10;
				firstPoint[i] = 10;
				strike[i] = true;
			}
			else if(array[i].matches("[0-9][0-9]")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = Integer.parseInt(array[i].substring(1,2));
				score[i] = firstPoint[i] + secondPoint[i];
			}
			
			else if(array[i].matches("[0-9]/")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = 10 - firstPoint[i];
				score[i] = 10;
				spare[i] = true;
			}
			else if(array[i].matches("-[0-9]")) {
				firstPoint[i] = 0;
				secondPoint[i] = Integer.parseInt(array[i].substring(1,2));
				score[i] = secondPoint[i];
			}
			else if(array[i].matches("[0-9]-")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = 0;
				score[i] = firstPoint[i];
			}
			
			else if(array[i].matches("-/")) {
				firstPoint[i] = 0;
				secondPoint[i] = 10;
				score[i] = 10;
				spare[i] = true;
			}
			
			else if(array[i].matches("X[0-9]/")) {
				firstPoint[i] = 10;
				secondPoint[i] = Integer.parseInt(array[i].substring(1,2));
				score[i] = 20;
				
			}
			else if(array[i].matches("X[0-9][0-9]")) {
				firstPoint[i] = 10;
				secondPoint[i] = Integer.parseInt(array[i].substring(1,2));
				score[i] = 10 + secondPoint[i] + Integer.parseInt(array[i].substring(2,3));
				
			}
			else if(array[i].matches("[0-9][0-9]X")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = Integer.parseInt(array[i].substring(1,2));
				score[i] = firstPoint[i] + secondPoint[i] + 10;
				
			}
			else if(array[i].matches("[0-9]/[0-9]")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = 10 - firstPoint[i];
				score[i] = 10 + Integer.parseInt(array[i].substring(2,3));
				
			}
			else if(array[i].matches("[0-9]/X")) {
				firstPoint[i] = Integer.parseInt(array[i].substring(0,1));
				secondPoint[i] = 10 - firstPoint[i];
				score[i] = 20;
				
			}
			else if(array[i].equals("XXX")){
				firstPoint[i] = 10;
				secondPoint[i] = 10;
				score[i] = 30;
			}
			else {
				score[i] =0;
			}
			
		}
		
		for(int i= 0; i<array.length; i++) {
			
			if(strike[i]) {
				totalScore += score[i] + firstPoint[i+1] + secondPoint[i+1];
				if(strike[i+1]) {
					totalScore += firstPoint[i+2];
					
				}
			}
			else if(spare[i]) {
				totalScore += score[i] + firstPoint[i+1];
			}
			else {
				totalScore += score[i];
			}
			
			System.out.print(totalScore + " ");
			
			
		}
	}
	
	
	
	public static void main(String[] args) {
		String text = "X X X X X X X X X XXX\r\n" + 
				"X -/ X 5- 8/ 9- X 81 1- 4/X\r\n" + 
				"62 71 X 9- 8/ X X 35 72 5/8\r\n" + 
				"X 7/ 72 9/ X X X 23 6/ 7/3\r\n" + 
				"X X X X 9/ X X 9/ 9/ XXX\r\n" + 
				"8/ 54 9- X X 5/ 53 63 9/ 9/X\r\n" + 
				"X 7/ 9- X -8 8/ -6 X X X81\r\n" + 
				"X 9/ 5/ 72 X X X 9- 8/ 9/X";
		
		
		Scanner scanner = new Scanner(text);
		
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  calculate(line.split(" "));
		  System.out.println();
		}
	}
}
