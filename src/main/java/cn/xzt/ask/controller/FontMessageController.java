package cn.xzt.ask.controller;

import cn.xzt.ask.domain.Message;
import cn.xzt.ask.domain.Question;
import cn.xzt.ask.service.FontMessageService;
import cn.xzt.ask.utils.PageUtil;
import cn.xzt.ask.utils.ParamCheckUtil;
import cn.xzt.ask.utils.R;
import cn.xzt.ask.utils.ResultStatus;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Auther: lyj
 * @Date: 2018/11/19 11:33
 */
@RestController
@RequestMapping("/fontmessage")
public class FontMessageController {


    private FontMessageService messageService;

    @Autowired
    public FontMessageController(FontMessageService mmessageService) {
        messageService = mmessageService;
    }


    @PostMapping("/create")
    public R save(HttpServletRequest request, @RequestBody String params) {
        R response = ParamCheckUtil.checkPrams(params, "title", "content", "phone", "email");
        if (response != null) {
            return response;
        }

        JSONObject jsonObject = JSONObject.parseObject(params);
        Message message = new Message();
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
    public R findAll(String typeId, Integer pageNum, Integer pageSize) throws Exception {
        if (pageNum  == null) {
            pageNum  = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageUtil<Question> comments = messageService.list(typeId, pageNum , pageSize);
        return R.ok(comments);
    }

}
