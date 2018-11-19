package cn.xzt.ask.service.impl;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.domain.Question;
import cn.xzt.ask.mapper.MessageMapper;
import cn.xzt.ask.service.MessageService;
import cn.xzt.ask.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: lyj
 * @Date: 2018/11/19 11:14
 */

@Service
public class MessageServiceImpl implements MessageService {

    private MessageMapper messageMapper;

    @Autowired
    public MessageServiceImpl(MessageMapper messageMappers) {
        messageMapper=messageMappers;
    }

    @Override
    public boolean insert(Message message) {
        int s= messageMapper.insert(message);
        if(s>=0) {
            return true;
        }
        return false;
    }

    @Override
    public PageUtil<Question> list(String typeId,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Question> listAll=messageMapper.list(typeId);
        if (listAll == null) {
            listAll = new ArrayList<>();
        }
        return new PageUtil<>(listAll);

    }
}
