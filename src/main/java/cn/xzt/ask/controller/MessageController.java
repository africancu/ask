package cn.xzt.ask.controller;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.domain.Question;
import cn.xzt.ask.service.MessageService;
import cn.xzt.ask.utils.PageUtil;
import cn.xzt.ask.utils.ParamCheckUtil;
import cn.xzt.ask.utils.R;
import cn.xzt.ask.utils.ResultStatus;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Auther: lyj
 * @Date: 2018/11/19 11:33
 */
@RestController
@RequestMapping("/message")
public class MessageController {


    private MessageService messageService;

    @Autowired
    public MessageController(MessageService mmessageService){
        messageService=mmessageService;
    }


    @PostMapping("/create")
    public R save(HttpServletRequest request, @RequestBody String params){
        R response = ParamCheckUtil.checkPrams(params, "title", "content", "phone","email");
        if (response != null) {
            return response;
        }

        JSONObject jsonObject = JSONObject.parseObject(params);
        Message message =new Message();
        message.setContent(jsonObject.getString("content"));
        message.setEmail(jsonObject.getString("email"));
        message.setPhone(jsonObject.getString("phone"));
        message.setTitle(jsonObject.getString("title"));
        boolean result = messageService.insert(message);
        if (result) {
            return R.ok();
        }
        return R.error(ResultStatus.ERROR.getCode(), ResultStatus.ERROR.getMessage());
    }

    @GetMapping("/list")
    public R findAll(String typeId,@RequestParam Integer currentPage,@RequestParam Integer pageSize) throws Exception {
        PageUtil<Question> comments = messageService.list(typeId,currentPage, pageSize);
        return R.ok(comments);
    }

}
