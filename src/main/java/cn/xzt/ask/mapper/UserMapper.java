package cn.xzt.ask.mapper;

import cn.xzt.ask.domain.User;
import cn.xzt.ask.dto.UserDTO;

public interface UserMapper {

    UserDTO login(User user);
}
