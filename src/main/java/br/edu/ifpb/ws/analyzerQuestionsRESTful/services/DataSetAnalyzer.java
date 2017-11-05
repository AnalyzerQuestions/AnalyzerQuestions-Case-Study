package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.CSVUtils;

@Service
public class DataSetAnalyzer {

	private static QuestionService questionService;

	public static void main(String[] args) {
		questionService = new QuestionService();
		List<Question> questions = questionService.getQuestions();

		System.out.println("starting...");
		CSVUtils csvUtils = new CSVUtils();

		csvUtils.writeCSV("datasetAnaly.csv", questions);

		System.out.println("success!");

	}

}
