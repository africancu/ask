package cn.xzt.ask.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 15:05
 * @Description:
 */
@Data
public class QuestionDTO {
    private Integer questionId;
    private String question;
    private String answer;
    private Integer typeId;
    private String typeName;
    private Date createTime;
}
