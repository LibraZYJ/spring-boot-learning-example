package com.zyj.springboot.unit;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

/**
 * @author YuJie_zhao
 * @date 2021/8/4 22:34
 */
@Slf4j
@Service
public class EasyPoiDemo {

    /**
     * 导出word数据(07版)
     *
     * @param params   map数据集合
     * @param fileName 模板名称
     * @param goalName 文件名称
     * @return 文件存储地址
     * @throws Exception
     */
    public String exportWord(Map<String, Object> params, String fileName, String goalName) {

        try {
            //模板地址
            String fileTemplateUrl = "E:/temp/";
            fileName = fileTemplateUrl + fileName + ".docx";
            XWPFDocument doc = WordExportUtil.exportWord07(fileName, params);
            // 判断文件存放地址是否存在,没有则创建
            //文件存储地址
            String fileGoalUrl = "E:/temp/";
            File savefile = new File(fileGoalUrl);
            if (!savefile.exists()) {
                log.info("导出word数据时存储文件目录不存在,为您创建文件夹!");
                savefile.createNewFile();
            }
            goalName = fileGoalUrl + goalName + ".docx";
            FileOutputStream fos = new FileOutputStream(goalName);
            doc.write(fos);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出word数据异常:" + e);
            return null;
        }
        return goalName;
    }
}
