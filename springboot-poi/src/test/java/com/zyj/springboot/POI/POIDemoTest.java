package com.zyj.springboot.POI;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

@SpringBootTest
class POIDemoTest {

    @Test
    public void testExportWord() throws Exception {
        String tmpFile = "E:/temp/template.doc";
        String expFile = "E:/temp/result.doc";
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "标题部份");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        datas.put("author", "知识林");
        datas.put("url", "http://www.zslin.com");

        POIDemo.build(new File(tmpFile), datas, expFile);
    }
    @Test
    public void testExportWord2() throws Exception {
        String tmpFile = "classpath:template.doc";
        String expFile = "E:/temp/result.doc";
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "标题部份");
        datas.put("content", "这里是内容，测试使用POI导出到Word的内容！");
        datas.put("author", "知识林");
        datas.put("url", "http://www.zslin.com");

        POIDemo.build(ResourceUtils.getFile(tmpFile), datas, expFile);
    }


}