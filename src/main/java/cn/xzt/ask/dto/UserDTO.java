package cn.xzt.ask.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer userId;
    private String name;
    private String roleCode;
    private String roleName;
}
