package mum.edu.repository;

import mum.edu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDataImpl implements DataFacade {
	@Autowired
	Database database;

	public boolean checkUser (User user ) {
 		return database.checkUser(user);
	}
	public List<String> getAdvice(String roast) { 
		return database.getAdvice(roast);
	}
}



