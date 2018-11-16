package cn.xzt.ask.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Question {

    private Integer questionId;
    private Integer typeId;
    private String question;
    private String answer;
    private Integer count;
    private Date createTime;
    private Date updateTime;

}
