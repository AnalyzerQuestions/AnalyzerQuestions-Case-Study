package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Usuario;

/**
 * 
 * <p>
 * 		<b> User Repository </b>
 * </p>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	Optional<Usuario> findOneByEmail(String email);

}
