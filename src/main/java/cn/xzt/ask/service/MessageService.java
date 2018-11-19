package cn.xzt.ask.service;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.domain.Question;
import cn.xzt.ask.utils.PageUtil;

import java.util.List;

/**
 * @Description:
 * @Auther: lyj
 * @Date: 2018/11/19 11:13
 */
public interface MessageService {


    boolean insert(Message message);

    PageUtil<Question> list(String typeId,Integer currentPage, Integer pageSize);

}
