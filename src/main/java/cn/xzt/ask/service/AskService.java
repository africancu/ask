package cn.xzt.ask.service;

import cn.xzt.ask.domain.Question;
import cn.xzt.ask.dto.QuestionDTO;
import cn.xzt.ask.utils.PageUtil;

import java.util.List;

public interface AskService {

    List<QuestionDTO> queryRelativeQuestion(List<String> keys);

    QuestionDTO queryAnswerById(String id);

    PageUtil<QuestionDTO> list(Integer pageNum, Integer pageSize);


}
