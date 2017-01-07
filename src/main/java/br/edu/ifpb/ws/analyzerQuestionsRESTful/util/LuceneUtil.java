package br.edu.ifpb.ws.analyzerQuestionsRESTful.util;

import java.io.IOException;
import java.util.Arrays;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.br.BrazilianAnalyzer;
import org.apache.lucene.analysis.br.BrazilianStemFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.CharArraySet;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.WordsUtils;


/**
 * 
 * <p>
 * 		<b> Lucene Util </b>
 * </p>
 *
 * <p>
 * 	Tratamento de tokenização e estemização de palavras.
 * </p>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class LuceneUtil {

	private static CharArraySet stopWords;
	private static StringBuffer tokensResult;

	
	/**
	 * Adiciona lista de stopwords brasileiros na tabela do lucene
	 */
	static {
		stopWords = new CharArraySet(Arrays.asList(WordsUtils.BRAZILIAN_STOP_WORDS), true);
	}
	

	/**
	 * Realiza tokenização e remoção de stopwords passados,
	 * fazendo stemming da String e faz merge dos tokens em um stringBuffer
	 * 
	 * @param text - texto a ser tokenizado
	 * @return - String em ordem
	 */
	public static StringBuffer tokenizeString(StringBuffer text) {
		
		tokensResult = new StringBuffer();

		try {
			Analyzer analyzer = new BrazilianAnalyzer(stopWords);
			TokenStream tokenStream = analyzer.tokenStream(null, text.toString());
			tokenStream.reset();
			BrazilianStemFilter filter = new BrazilianStemFilter(tokenStream);

			while (filter.incrementToken()) {
				tokensResult.append(filter.getAttribute(CharTermAttribute.class).toString());
				tokensResult.append(" ");
			}
			analyzer.close();
			filter.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		return tokensResult;
	}
}
