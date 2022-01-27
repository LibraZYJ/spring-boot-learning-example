package com.zyj.springboot.unit;

import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author YuJie_zhao
 * @date 2021/8/4 22:37
 */
public class WordExportUtil {

    private WordExportUtil() {

    }

    /**
     * 解析Word2007版本
     *
     * @param url
     *            模板地址
     * @param map
     *            解析数据源
     * @return
     */
    public static XWPFDocument exportWord07(String url, Map<String, Object> map) throws Exception {
        return new ParseWord07().parseWord(url, map);
    }

    /**
     * 解析Word2007版本
     *
     * @param document
     *            模板
     * @param map
     *            解析数据源
     */
    public static void exportWord07(XWPFDocument document, Map<String, Object> map) throws Exception {
        new ParseWord07().parseWord(document, map);
    }

    /**
     * 一个模板生成多页
     * @param url
     * @param list
     * @return
     * @throws Exception
     */
    public static XWPFDocument exportWord07(String url, List<Map<String, Object>> list) throws Exception {
        return new ParseWord07().parseWord(url, list);
    }
}