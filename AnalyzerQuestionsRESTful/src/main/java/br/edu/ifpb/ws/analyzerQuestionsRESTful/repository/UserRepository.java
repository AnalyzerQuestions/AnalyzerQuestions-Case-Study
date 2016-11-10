package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
