package cn.xzt.ask.service;

import cn.xzt.ask.domain.User;
import cn.xzt.ask.dto.UserDTO;

public interface UserService {

    UserDTO login(User user);

}
