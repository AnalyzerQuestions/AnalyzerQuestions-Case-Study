package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {
/*
	public String readerTxt() {

		StringBuilder sb =  new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("/classJava.txt")));
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}*/
	
	public static String readerTxt(String txt) {

		BufferedReader br;
		StringBuilder sb = null;
		try {
			br = new BufferedReader(new FileReader(txt));
			sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
