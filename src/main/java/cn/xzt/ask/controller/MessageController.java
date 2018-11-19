package cn.xzt.ask.controller;


import cn.xzt.ask.domain.Message;
import cn.xzt.ask.dto.GetMessageDTO;
import cn.xzt.ask.dto.RemoveMessageDTO;
import cn.xzt.ask.service.MessageService;
import cn.xzt.ask.utils.PageUtil;
import cn.xzt.ask.utils.R;
import cn.xzt.ask.utils.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "message")
@Slf4j
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 查询留言
     * @param getMessageDTO
     * @return
     */
    @PostMapping("/get")
    public R getMessage(@RequestBody GetMessageDTO getMessageDTO) {
        if (getMessageDTO.getPageNum() == null || getMessageDTO.getPageSize() == null) {
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        } else {
            PageUtil<Message> messageList = messageService.getMessage(getMessageDTO);
            if (messageList == null || messageList.getSize() == 0) {
                return R.error();
            }
            return R.ok(messageList);
        }
    }


    /**
     * 删除留言
     * @param removeMessageDTO
     * @return
     */
    @PostMapping("/delete")
    public R delete(@RequestBody RemoveMessageDTO removeMessageDTO) {
        List<Integer> ids = removeMessageDTO.getIds();
        if (ids != null && ids.size() > 0) {
            messageService.deleteMessage(ids);
            return R.ok();
        } else {
            return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
        }
    }


    /**
     * 回复留言
     * @param message
     * @return
     */
    @PostMapping("/reply")
    public R replyMessage(@RequestBody Message message){
       if(message.getMessageId()!=null&&message.getReply()!=null){
           messageService.relyMessage(message);
           return R.ok();
       }else {
           return R.error(ResultStatus.PARAM_EMPTY.getCode(), ResultStatus.PARAM_EMPTY.getMessage());
       }
    }

}
