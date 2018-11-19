package cn.xzt.ask.mapper;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.domain.Question;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Auther: lyj
 * @Date: 2018/11/19 10:09
 */

@Component
public interface MessageMapper {

    int insert(Message message);

    List<Question> list(@Param("typeId") String typeId);

}
