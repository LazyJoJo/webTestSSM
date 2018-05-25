package rgcc.service;

import rgcc.entity.User;

import java.util.List;


public interface IUserService {
    User getUserById(int userId);
    List<User> getUsers();
}
