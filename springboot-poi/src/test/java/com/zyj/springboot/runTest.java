package com.zyj.springboot;

import cn.afterturn.easypoi.word.WordExportUtil;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jeecgframework.poi.word.entity.WordImageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YuJie_zhao
 * @date 2021/8/3 22:41
 */
@SpringBootTest
public class runTest {


    @Test
    public void imageWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("time", new Date());
        WordImageEntity image = new WordImageEntity();
        image.setHeight(200);
        image.setWidth(500);
        image.setUrl("E:\\temp\test.jpg");
        image.setType(WordImageEntity.URL);
        map.put("testCode", image);
        try {

            XWPFDocument doc = com.zyj.springboot.unit.WordExportUtil.exportWord07("E:\\temp\\test.docx", map);
            FileOutputStream fos = new FileOutputStream("E:/temp/image.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**

     * 简单导出没有图片和Excel

     */
    @Test
    public void SimpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", "Easypoi");
        map.put("person", "JueYue");
        map.put("time", new Date());
        map.put("me","JueYue");
        map.put("date", "2015-01-03");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "cn/afterturn/easypoi/test/word/doc/Simple.docx", map);
            FileOutputStream fos = new FileOutputStream("D:/excel/simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testPage() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "小明" + i);
            list.add(map);
        }
        //----------------------------------------------
        try {
            XWPFDocument doc = WordExportUtil
                    .exportWord07("word/loan.docx", list);
            FileOutputStream fos = new FileOutputStream("D:/home/excel/ManyPageWordTest.拼接多页测试.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}