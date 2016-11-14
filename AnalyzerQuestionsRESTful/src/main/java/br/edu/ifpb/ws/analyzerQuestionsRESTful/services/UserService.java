package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.User;
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
	public User saveUser(User user){
		
		this.userRepository.save(user);
		
		return user;
	}
	
	
	/**
	 * Método responsável por buscar um usário com id passado no banco de dados
	 * @param id
	 * @return
	 */
	public User findUserById(Long id){
		
		return this.userRepository.findOne(id);
	}
	
	/**
	 * Método responsável por atualizar as informações de um usário no banco de dados
	 * @param user
	 * @return
	 */
	public User updateUser(User user){
		this.userRepository.save(user);
		return user;
	}

}
