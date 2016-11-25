package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.TSuggestions;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
@Table(name = "msg_suggestion")
public class Suggestion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TSuggestions tipo;

	@ElementCollection
	private List<String> categoria;

	private String msg;

	public TSuggestions getTipo() {
		return tipo;
	}

	public void setTipo(TSuggestions tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<String> categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "MSG [id=" + id + ", tipo=" + tipo + ", msg=" + msg + "]";
	}

}
