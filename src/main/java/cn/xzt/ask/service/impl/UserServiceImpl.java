package cn.xzt.ask.service.impl;

import cn.xzt.ask.domain.User;
import cn.xzt.ask.dto.UserDTO;
import cn.xzt.ask.mapper.UserMapper;
import cn.xzt.ask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO login(User user) {
        return userMapper.login(user);
    }
}
