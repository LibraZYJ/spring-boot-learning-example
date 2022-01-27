package com.zyj.springboot.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 * @author YuJie_zhao
 * @date 2021/8/3 22:54
 */
public class FirstWordTest {

    //模板文件地址
    private static String inputUrl = "E:\\demo\\001.docx";
    //新生产的模板文件
    private static String outputUrl = "E:\\demo\\test.docx";

    /**
     *
     * @param inputUrl 模板路径
     * @param outputUrl 模板保存路径
     */
    public static void changeWord(String inputUrl, String outputUrl ){

        try {
            //获取word文档解析对象
            XWPFDocument doucument = new XWPFDocument(POIXMLDocument.openPackage(inputUrl));
            //获取段落文本对象
            List<XWPFParagraph> paragraph = doucument.getParagraphs();
            //获取首行run对象
            XWPFRun run = paragraph.get(0).getRuns().get(0);
            //设置文本内容
            run.setText("修改了的word");
            //生成新的word
            File file = new File(outputUrl);

            FileOutputStream stream = new FileOutputStream(file);
            doucument.write(stream);
            stream.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        changeWord(inputUrl,outputUrl);
    }
}
