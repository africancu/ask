package cn.xzt.ask.domain;

import lombok.Data;

import java.util.Date;

@Data
public class QuestionType {

    private Integer typeId;
    private String name;
    private Date createTime;
    private Date updateTime;

}
