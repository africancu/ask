package cn.xzt.ask.domain;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private Integer roleId;
}
