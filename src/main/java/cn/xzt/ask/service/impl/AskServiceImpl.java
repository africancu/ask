package cn.xzt.ask.service.impl;

import cn.xzt.ask.domain.Question;
import cn.xzt.ask.dto.QuestionDTO;
import cn.xzt.ask.mapper.AskMapper;
import cn.xzt.ask.service.AskService;
import cn.xzt.ask.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 15:07
 * @Description:
 */
@Service
public class AskServiceImpl implements AskService {
    @Autowired
    private AskMapper askMapper;

    @Override
    public List<QuestionDTO> queryRelativeQuestion(List<String> keys) {
        List<QuestionDTO> questionList = askMapper.queryRelativeQuestion(keys);
        return questionList;
    }

    @Override
    public QuestionDTO queryAnswerById(String id) {
        QuestionDTO question = askMapper.queryAnswerById(id);
        return question;
    }

    @Override
    public PageUtil<QuestionDTO> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<QuestionDTO> list = askMapper.list();
        return new PageUtil<>(list);
    }
}
