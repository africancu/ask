package cn.xzt.ask.dto;

import lombok.Data;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 11:49
 * @Description:
 */
@Data
public class UserDTO {
    private Integer userId;
    private String name;
    private String roleCode;
    private String roleName;
}
