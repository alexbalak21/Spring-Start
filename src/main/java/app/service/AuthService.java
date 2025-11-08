package app.service;

import app.dto.UserLoginRequest;
import app.dto.UserRegisterRequest;
import app.model.User;

public interface AuthService {
    User registerUser(UserRegisterRequest registerRequest);
    String authenticateUser(UserLoginRequest loginRequest);
}
