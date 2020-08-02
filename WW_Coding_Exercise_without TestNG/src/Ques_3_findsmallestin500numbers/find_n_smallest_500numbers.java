package Ques_3_findsmallestin500numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class find_n_smallest_500numbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner num = new Scanner(System.in);
		System.out.println("Enter the Random Numbers count to generate Random Numbers: ");
		int randomcount = num.nextInt();
		HashSet<Integer> finallst = GenerateRandnum(randomcount);
		System.out.println();
		System.out.println(randomcount + " Random numbers : " + finallst);
		System.out.println();
		List<Integer> lst = new ArrayList<Integer>(finallst);
		Findsmallestnum(lst);
	}

	// This method generates 500 distinct Random Numbers
	public static HashSet<Integer> GenerateRandnum(int rc) {
		HashSet<Integer> randomnum = new HashSet<Integer>();
		Random rand = new Random();
		while (randomnum.size() <= rc) {
			randomnum.add(rand.nextInt(5000));
		}
		return randomnum;

	}

	// This method finds the nth smallest number from Random numbers list
	public static void Findsmallestnum(List<Integer> finallst1) {
		int smallnum = 0;
		try {
			Collections.sort(finallst1);
			System.out.println("The sorted list : " + finallst1);
			System.out.println();
			Scanner value = new Scanner(System.in);
			System.out.println("Enter the n value to find the nth smallest number   : ");
			int n = value.nextInt();
			value.close();
			System.out.println();
			smallnum = finallst1.get(n - 1);
			System.out.println("The " + n + "th smallest number  = " + smallnum);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
