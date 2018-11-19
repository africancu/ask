package cn.xzt.ask.controller;

import cn.xzt.ask.domain.User;
import cn.xzt.ask.dto.UserDTO;
import cn.xzt.ask.service.UserService;
import cn.xzt.ask.utils.R;
import cn.xzt.ask.utils.ResultStatus;
import cn.xzt.ask.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 11:49
 * @Description: 用户登录控制类
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        if (user == null || StringUtil.isBlank(user.getUsername()) || StringUtil.isBlank(user.getPassword())){
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        }
        UserDTO login = userService.login(user);
        if (null == login){
            return R.error(ResultStatus.LOGIN_ERROR.getCode(), ResultStatus.LOGIN_ERROR.getMessage());
        }
        return R.ok(login);
    }
}
