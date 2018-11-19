package cn.xzt.ask.utils;

import lombok.extern.slf4j.Slf4j;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 周明军
 * @Date: 2018/11/19 11:49
 * @Description: 分词工具类
 */
@Slf4j
public class SegUtil {

    /**
     * 分词
     *
     * @param text
     * @return
     * @throws IOException
     */
    public static List<String> segment(String text) {
        Configuration configuration = DefaultConfig.getInstance();
        configuration.setUseSmart(true);
        IKSegmenter ik = new IKSegmenter(new StringReader(text), configuration);
        Lexeme lexeme = null;
        List<String> list = new ArrayList<>();
        try {
            while ((lexeme = ik.next()) != null) {
                list.add(lexeme.getLexemeText());
            }
        } catch (Exception e) {
            log.error("分词出错！");
            e.printStackTrace();
        }
        return list;
    }

}
