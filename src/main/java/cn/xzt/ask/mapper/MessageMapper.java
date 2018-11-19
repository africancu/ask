package cn.xzt.ask.mapper;

import cn.xzt.ask.domain.Message;

import java.util.List;

/**
 * Created by zxjaihhl on 2018/11/19.
 */
public interface MessageMapper {

    List<Message> getMessage();

    void deleteMessage(List<Integer> ids);

    void replyMessage(Message message);
}
