package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private String markdownDescription;
	private List<String> tags;

	public Question() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarkdownDescription() {
		return markdownDescription;
	}

	public void setMarkdownDescription(String markdownDescription) {
		this.markdownDescription = markdownDescription;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Question [title=" + title + ", description=" + description + ", markdownDescription="
				+ markdownDescription + "]";
	}

}
