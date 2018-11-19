package cn.xzt.ask.utils;

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
public class SegUtil {

    /**
     * 分词
     * @param text
     * @return
     * @throws IOException
     */
    public static List<String> segment(String text) throws IOException {
        Configuration configuration = DefaultConfig.getInstance();
        configuration.setUseSmart(true);
        IKSegmenter ik = new IKSegmenter(new StringReader(text), configuration);
        Lexeme lexeme = null;
        List<String> list = new ArrayList<>();
        while ((lexeme = ik.next()) != null) {
            list.add(lexeme.getLexemeText());
        }
        return list;
    }

}
