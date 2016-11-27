package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;


public class CSVUtils {
	
    private static final String NEW_LINE_SEPARATOR = "\n";
    
	private CSVPrinter csvPrinter;
    
    private static final Object [] FILE_HEADER = {
    	"TITLE",
    	"DESCRIÇAO",
    	"DESCRICAO HTML",
    	"TAGS", 
    	"FOI RESPONDIDA", 
    	
	};
    
    
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void writeCSV(String fileName, List<Question> list){
    	
    	FileWriter fWriter = null;
    	
    	CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
    	
    	try {
			fWriter = new FileWriter(fileName);
			csvPrinter = new CSVPrinter(fWriter, csvFormat);
			csvPrinter.printRecord(FILE_HEADER);
			
			for (Question q : list) {
		    	List recordQuestions = new ArrayList();
		    	recordQuestions.add(String.valueOf(q.getTitle()));
				recordQuestions.add(String.valueOf(q.getDescription()));
				recordQuestions.add(String.valueOf(q.getDescritptionHtml()));
				recordQuestions.add(String.valueOf(q.getTags()));
				recordQuestions.add(String.valueOf(q.isAnswered()));
		
				csvPrinter.printRecord(recordQuestions);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fWriter.flush();
				fWriter.close();
				csvPrinter.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
    }
}
