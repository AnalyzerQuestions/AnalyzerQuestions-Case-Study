package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.StringTokenizerUtils;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
public class ReaderQuestions {

	
	private static final String[] FILE_HEADER_MAPPING = { 
					"TITLE",
					"DESCRICAO",
					"DESCRIÇAO HTML",
					"TAGS",
					"FOI RESPONDIDA"
	};
		
	private static final String TITLE = "TITLE";
	private static final String DESCRICAO = "DESCRICAO";
	private static final String DESCRICAO_HTML = "DESCRIÇAO HTML";
	private static final String TAGS = "TAGS";
	private static final String FOI_RESPONDIDA = "FOI RESPONDIDA";

	private static String FILE_NAME;
	private List<Question> questions;
	
	
	@SuppressWarnings("static-access")
	public ReaderQuestions(String file) {
		
		this.FILE_NAME = file;
	}

	public List<Question> readCsvFile() {
		
		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

		try {
			questions = new ArrayList<Question>();
			fileReader = new FileReader(FILE_NAME);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = csvRecords.get(i);

				Question question = new Question(
						record.get(TITLE), 
						record.get(DESCRICAO), 
						record.get(DESCRICAO_HTML), 
						this.parseToList(record.get(TAGS)),
						this.parseToBoolean(record.get(FOI_RESPONDIDA)));
				
				questions.add(question);
			}
			
			return questions;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				fileReader.close();
				csvFileParser.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		throw new RuntimeException("Erro ao tratar o dataset");
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	private List<String> parseToList(String s){
		String preparement = s.substring(1, s.length()-1);
		String[] sliped = StringTokenizerUtils.parseTokenWithoutComma(preparement);
		
		return Arrays.asList(sliped);
	}
	
	private boolean parseToBoolean(String s){
		return new Boolean(s);
	}
}
