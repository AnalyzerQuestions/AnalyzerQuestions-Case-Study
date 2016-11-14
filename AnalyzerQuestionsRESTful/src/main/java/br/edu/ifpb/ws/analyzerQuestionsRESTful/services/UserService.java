package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Usuario;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	/**
	 * Método responsável por salvar um usário no banco de dados
	 * @param user
	 * @return
	 */
	public Usuario saveUser(Usuario user){
		
		this.userRepository.save(user);
		
		return user;
	}
	
	
	/**
	 * Método responsável por buscar um usário com id passado no banco de dados
	 * @param id
	 * @return
	 */
	public Usuario findUserById(Long id){
		
		return this.userRepository.findOne(id);
	}
	
	/**
	 * Método responsável por atualizar as informações de um usário no banco de dados
	 * @param user
	 * @return
	 */
	public Usuario updateUser(Usuario user){
		this.userRepository.save(user);
		return user;
	}

}
