package rgcc.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rgcc.dao.*;
import rgcc.entity.User;
import rgcc.service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(int userId) {
        User u = this.userMapper.selectByPrimaryKey(userId);
        return u;
    }

    public List<User> getUsers() {
        return userMapper.findAll();
    }
}
