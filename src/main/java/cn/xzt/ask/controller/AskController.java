package cn.xzt.ask.controller;

import cn.xzt.ask.dto.QuestionDTO;
import cn.xzt.ask.service.AskService;
import cn.xzt.ask.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 14:53
 * @Description:
 */
@RestController
@RequestMapping(value = "/ask")
@Slf4j
public class AskController {
    @Autowired
    private AskService askService;

    /**
     * 查询相关题干
     *
     * @param text
     * @return
     */
    @PostMapping("/queryRelativeQuestion")
    public R queryRelativeQuestion(@RequestBody String text) {
        if (StringUtil.isBlank(text)) {
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        }
        Map<String, Object> jsonToMap = JSONUtil.JSONToMap(text);
        text = (String) jsonToMap.get("text");
        log.info("text = {}", text);
        List<String> segment = SegUtil.segment(text);
        log.info("分词结果：{}", segment);
        List<QuestionDTO> questionList = null;
        Map<String, Object> map = new HashMap<>();
        if (segment.size() > 0) {
            map.put("segment", segment);
            questionList = askService.queryRelativeQuestion(segment);
            map.put("questionList", questionList);
        }
        return R.ok(map);
    }

    @GetMapping("/queryAnswerById/{id}")
    public R queryAnswerById(@PathVariable("id") String id) {
        if (StringUtil.isBlank(id)) {
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        }
        QuestionDTO questionDTO = askService.queryAnswerById(id);
        return R.ok(questionDTO);
    }

    /**
     * 分页查询全部
     *
     * @return
     */
    @GetMapping("/list")
    public R list(Integer pageNum, Integer pageSize) {
        log.info("pageNum = {}, pageSize = {}", pageNum, pageSize);
        if (pageNum == null || pageSize == null) {
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        }
        PageUtil<QuestionDTO> list = askService.list(pageNum, pageSize);
        return R.ok(list);
    }

}
