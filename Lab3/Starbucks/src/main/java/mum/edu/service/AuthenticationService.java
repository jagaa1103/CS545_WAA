package mum.edu.service;

import mum.edu.model.User;

public interface AuthenticationService {
    public boolean checkUserAuthentication(User user);
}
