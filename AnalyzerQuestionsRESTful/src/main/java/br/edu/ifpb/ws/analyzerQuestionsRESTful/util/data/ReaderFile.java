package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderFile {

	public String readerTxt(String txt) {

		StringBuilder sb =  new StringBuilder();
		ClassLoader cl = this.getClass().getClassLoader();
		InputStreamReader isr = new InputStreamReader(cl.getResourceAsStream(txt));
		try {
			BufferedReader br = new BufferedReader(isr);
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
	
	/*public static String readerTxt(String txt) {

		BufferedReader br;
		StringBuilder sb = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try {
			br = new BufferedReader(new FileReader(new InputStreamReader(classloader.getResourceAsStream("test.csv"))));
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
	}*/
	
	public static void main(String[] args) {
		ReaderFile rf = new ReaderFile();
		System.out.println(rf.readerTxt("classJava.txt"));
	}
}
