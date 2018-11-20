package cn.xzt.ask.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass())
           {return false;}
        Message message = (Message) o;
        return Objects.equals(title, message.title) &&
                Objects.equals(content, message.content) &&
                Objects.equals(email, message.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, content, email);
    }
}
