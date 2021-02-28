package mum.edu.repository;

import mum.edu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataFacade {
	public boolean checkUser (User user );
	public List<String> getAdvice(String roast);
}
