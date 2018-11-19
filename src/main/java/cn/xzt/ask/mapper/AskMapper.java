package cn.xzt.ask.mapper;

import cn.xzt.ask.domain.Question;
import cn.xzt.ask.dto.QuestionDTO;

import java.util.List;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 15:08
 * @Description:
 */
public interface AskMapper {

    List<QuestionDTO> queryRelativeQuestion(List<String> keys);

    QuestionDTO queryAnswerById(String id);

    List<QuestionDTO> list();


}
