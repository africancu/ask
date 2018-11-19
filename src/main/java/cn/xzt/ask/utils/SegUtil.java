package cn.xzt.ask.utils;


import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SegUtil {

    // 测试分词的效果，以及停用词典是否起作用
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

    public static void main(String[] args) throws Exception{
        List<String> segment = segment("个人所得税劳务报酬所得的税率是什么");
        System.out.println(segment);
    }

}
