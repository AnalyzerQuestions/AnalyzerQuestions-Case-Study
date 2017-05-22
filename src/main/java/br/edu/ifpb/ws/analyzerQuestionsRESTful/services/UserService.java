package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Usuario;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.exception.UniqueConstraintException;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.UserRepository;

/**
 * 
 * <p>
 * <b> User Service </b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Método responsável por salvar um usário no banco de dados
	 * @param user
	 * @return
	 * @throws UniqueConstraintException 
	 */
	public Usuario saveUser(Usuario user) throws UniqueConstraintException{
		Optional<Usuario> userOp = userRepository.findOneByEmail(user.getEmail());
		if(userOp.isPresent()) {
			throw new UniqueConstraintException("Usuário com este e-mail já respondeu.");
		}
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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Usuario getById(Long id) {
		return userRepository.getOne(id);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Usuario> getAll(){
		return userRepository.findAll();
	}

}
