package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.MsgDTO;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.QuestionRepository;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.ReaderQuestions;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 * @author <a href="https://github.com/JoseRafael97">José Rafael</a>
 *
 */
@Service
public class QuestionService {
	

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnalyzerQuestionService analyzer;
	
	private final String CSV_300_QUESTION = "perguntasOrder.csv";

	
	public Question findById(Long id){
		return questionRepository.findOne(id);
	}
	
	public Question update(Question question) {
		return questionRepository.save(question);
	}

	public List<Question> getQuestions() {
		ReaderQuestions rq = new ReaderQuestions(CSV_300_QUESTION);
		List<Question> questions = rq.readCsvFile();

		return questions;
	}
	
	public List<MsgDTO> getAnalize(Question question) {
		return analyzer.getSuggestions(question);
	}
}
