package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class QuestionPojo {

	@SerializedName("question_id")
	private int questionId;
	private String body;
	private List<String> tags;
	private String title;
	private String bodyMarkdown;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBodyMarkdown() {
		return bodyMarkdown;
	}

	public void setBodyMarkdown(String bodyMarkdown) {
		this.bodyMarkdown = bodyMarkdown;
	}

	@Override
	public String toString() {
		return "QuestionPojo [questionId=" + questionId + ", body=" + body + ", tags=" + tags + ", title=" + title
				+ ", bodyMarkdown=" + bodyMarkdown + "]";
	}

}
