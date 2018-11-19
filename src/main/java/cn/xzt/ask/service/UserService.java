package cn.xzt.ask.service;

import cn.xzt.ask.domain.User;
import cn.xzt.ask.dto.UserDTO;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 11:49
 * @Description:
 */
public interface UserService {

    UserDTO login(User user);

}
