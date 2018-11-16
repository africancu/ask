package cn.xzt.ask.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private Integer messageId;
    private String title;
    private String content;
    private String reply;
    private String phone;
    private String email;
    private Date createTime;
    private Date updateTime;

}
