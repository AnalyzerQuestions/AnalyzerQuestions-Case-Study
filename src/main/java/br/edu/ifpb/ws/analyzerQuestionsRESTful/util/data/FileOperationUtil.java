package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileOperationUtil {

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public String reader(String fileName) {

		BufferedReader br;
		StringBuilder sb = null;
		try {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
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
	
	public String parseFile(File file) {

		BufferedReader br;
		StringBuilder sb = null;
		try {
			FileReader fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
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
	
	/**
	 * 
	 * @param content
	 * @param fileName
	 */
	public void  writer(String content, String fileName){
		try {
			File file = new File(fileName);
			
			FileOutputStream outputStream = new FileOutputStream(file);
			outputStream.write(content.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}