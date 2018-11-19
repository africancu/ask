package cn.xzt.ask.service.impl;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.dto.GetMessageDTO;
import cn.xzt.ask.mapper.MessageMapper;
import cn.xzt.ask.service.MessageService;
import cn.xzt.ask.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zxjaihhl on 2018/11/19.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询留言
     * @return
     */
    @Override
    public PageUtil<Message> getMessage(GetMessageDTO getMessageDTO) {
            Integer pageNum = getMessageDTO.getPageNum();
            Integer pageSize = getMessageDTO.getPageSize();
            PageHelper.startPage(pageNum, pageSize);
            List<Message> messageList = messageMapper.getMessage();
            return new PageUtil<>(messageList);

    }

    /**
     * 删除留言
     * @param ids
     */
    @Override
    public void deleteMessage(List<Integer> ids) {
        messageMapper.deleteMessage(ids);
    }

    /**
     * 回复留言
     * @param message
     */
    @Override
    public void relyMessage(Message message) {
        messageMapper.replyMessage(message);
    }
}
