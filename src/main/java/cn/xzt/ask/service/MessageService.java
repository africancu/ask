package cn.xzt.ask.service;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.dto.GetMessageDTO;
import cn.xzt.ask.utils.PageUtil;

import java.util.List;


/**
 * Created by zxjaihhl on 2018/11/19.
 */
public interface MessageService {
    PageUtil<Message> getMessage(GetMessageDTO getMessageDTO);

    void deleteMessage(List<Integer> ids);

    void relyMessage(Message message);
}
