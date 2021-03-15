package mum.edu.service;

import mum.edu.model.User;
import mum.edu.repository.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    DataFacade dataFacade;

    @Override
    public boolean checkUserAuthentication(User user) {
        return dataFacade.checkUser(user);
    }
}
