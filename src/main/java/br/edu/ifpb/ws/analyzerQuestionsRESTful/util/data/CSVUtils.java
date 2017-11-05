package br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;


public class CSVUtils {
	
    private static final String NEW_LINE_SEPARATOR = "\n";
    
	private CSVPrinter csvPrinter;
	
	private static QuestionAnalyzerFinal questionAnalyzer;
    
    private static final Object [] FILE_HEADER = {
    	"TITLE",
    	"QTD"
    	
	};
    
    
 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void writeCSV(String fileName, List<Question> list){
    	questionAnalyzer = new QuestionAnalyzerFinal();
    	FileWriter fWriter = null;
    	
    	CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
    	
    	try {
			fWriter = new FileWriter(fileName);
			csvPrinter = new CSVPrinter(fWriter, csvFormat);
			csvPrinter.printRecord(FILE_HEADER);
			
			for (Question q : list) {
				
		    	List recordQuestions = new ArrayList();
		    	recordQuestions.add(String.valueOf(q.getTitle()));
				recordQuestions.add(String.valueOf(getGoodQuestionAnalyzer(q)));
		
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
    
public static Integer getGoodQuestionAnalyzer(Question question) {
		
		int cont = 0;

		cont = cont + analyseUnderstandableTitle(question.getTitle(), question.getDescription());
		cont = cont + analyseCoherencyBodyAndTitle(question.getTitle(), question.getDescription());
		cont = cont + analyzerObjective(question.getDescription());
		cont = cont + analyzerClarity(question.getTitle(), question.getDescription());
		cont = cont + analyseShowingExample(question.getDescription());
		cont = cont + analyzerUnderstandableDescription(question.getTitle(), question.getDescription());
		cont = cont + analyzerBeEducated(question.getDescription());
		cont = cont + analyzerShortDescriptionQuestion(question.getDescription());
		cont = cont + analyzerDoNotCreateHomeworkQuestions(question.getDescription());
		cont = cont + analyzerUsingProperLanguage(question.getDescription());
		cont = cont + analyzerDetailAboutContext(question.getDescription());
		
		return cont;
	}
	

	
	public static Integer analyseUnderstandableTitle(String title, String description) {
		return questionAnalyzer.analyzerUnderstandableTitle(title, description);
	}
	
	
	public static Integer analyseCoherencyBodyAndTitle(String title, String description){
		return questionAnalyzer.analyzerCoherencyBodyAndTitle(title, description);
	}
	
	public static Integer analyzerObjective(String description){
		return questionAnalyzer.analyzerObjective(description);
	}
	
	public static Integer analyzerClarity(String title, String description){
		return questionAnalyzer.analyzerClarity(title, description);
	}
	
	public static Integer analyseShowingExample(String description){
		return questionAnalyzer.analyzerShowExample(description);
	}
	
	
	public static Integer analyzerUnderstandableDescription(String title, String description){
		return questionAnalyzer.analyzerUnderstandableDescription(title, description);
	}
	
	public static Integer analyzerDetailAboutContext(String description){
		return questionAnalyzer.analyzerDetailAboutContext(description);
	}
	
	public static Integer analyzerUsingProperLanguage(String description){
		return questionAnalyzer.analyzerUsingProperLanguage(description);
	}
	
	public static Integer analyzerBeEducated(String description){
		return questionAnalyzer.analyzerBeEducated(description);
	}
	
	public static Integer analyzerShortDescriptionQuestion(String description){
		return questionAnalyzer.analyzerShortDescriptionQuestion(description);
	}
	
	public static Integer analyzerDoNotCreateHomeworkQuestions(String description){
		return questionAnalyzer.analyzerDoNotCreateHomeworkQuestions(description);
	}

}
