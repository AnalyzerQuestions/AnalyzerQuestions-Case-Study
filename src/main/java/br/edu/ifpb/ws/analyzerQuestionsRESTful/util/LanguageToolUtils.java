package br.edu.ifpb.ws.analyzerQuestionsRESTful.util;

import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BrazilianPortuguese;
import org.languagetool.rules.RuleMatch;

/**
 * 
 * <p>
 * 		<b> Language Tool Utils </b>
 * </p>
 *
 * <p>
 * 	Verificação de ortografia.
 * </p>
 * 
 * <pre>
 * @see <a href="https://www.languagetool.org/">Language Toll</a>
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class LanguageToolUtils {

	private static List<RuleMatch> matches;

	/**
	 * Método verifica se um texto passado esta com ortografia correta.
	 * 
	 * @param text
	 * @return
	 */
	public static boolean textIsValid(String text, Integer freq) {
		JLanguageTool langTool = new JLanguageTool(new BrazilianPortuguese());
		try {
			matches = langTool.check(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matches.size() <= freq;
	}

}
