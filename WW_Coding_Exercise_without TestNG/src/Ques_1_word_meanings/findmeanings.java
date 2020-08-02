package Ques_1_word_meanings;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class findmeanings {

	public static void main(String[] args) {
		String filepath = "./DictionaryFile/myfile.txt";
		boolean fileflagstatus = doesfileexists(filepath);
		System.out.println("Is File exists at the path " + filepath + " : " + fileflagstatus);
		System.out.println();
		try {
			if (fileflagstatus == true) {
				List<String> readdata = readfile(filepath);
				splitwords(readdata);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}/* Checking if file exists in the mentioned path */

	public static boolean doesfileexists(String filepath) {
		boolean fileflag = false;
		try {
			File myfile = new File(filepath);
			fileflag = myfile.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileflag;
	}

	/* Reading the file data */
	public static List<String> readfile(String filepath) {
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/* Organizing file data look like Dictionary */
	public static void splitwords(List<String> filecontent) {

		for (String s : filecontent) {
			String[] word = s.split("-");
			for (String st : word) {
				String[] word1 = st.split(",");
				for (int i = 0; i < word1.length; i++) {
					System.out.println(word1[i].trim());
				}
			}

		}
	}
}
