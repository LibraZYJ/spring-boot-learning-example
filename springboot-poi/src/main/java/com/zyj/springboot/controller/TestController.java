package com.zyj.springboot.controller;

import cn.afterturn.easypoi.word.WordExportUtil;
import cn.afterturn.easypoi.word.entity.params.ExcelListEntity;
import cn.afterturn.easypoi.word.parse.excel.ExcelEntityParse;
import com.zyj.springboot.entity.Student;
import com.zyj.springboot.unit.EasyPoiDemo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YuJie_zhao
 * @date 2021/8/4 23:11
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    private static final String TEMPLATE_FILE_NAME = "E:/temp/test.docx";

    @Autowired
    private EasyPoiDemo easyPoiDemo;


    @GetMapping("/easyPoiDemo")
    public String exportWordDemo(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", "这是标题");
        params.put("name", "张三");
        return easyPoiDemo.exportWord(params, "export", "test2");

    }


    @GetMapping("/export2")
    public void export(HttpServletRequest request, HttpServletResponse response) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");
        Map<String, Object> params = new HashMap<>();

        params.put("title", "这是标题");
        params.put("name", "李四");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07("E:/temp/export.docx", params);
            String filename = "E:/temp/test2.docx";

            // 判断文件存放地址是否存在,没有则创建
            File savefile = new File(filename);
            if (!savefile.exists()) {
                log.info("导出word数据时存储文件目录不存在,为您创建文件夹!");
                savefile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(filename);
            doc.write(fos);
            // 设置强制下载不打开
            response.setContentType("application/force-download");
            // 设置文件名
            response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
            OutputStream out = response.getOutputStream();
            doc.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            delAllFile("E:/test/");
        }
    }


    @GetMapping("/exportWord")
    public void exportWord(HttpServletResponse response) throws Exception {
        // 填充参数
        Map<String, Object> map = new HashMap<>(9);
        map.put("0", "one");
        map.put("1", "two");
        map.put("2", "three");
        map.put("3", "four");
        map.put("4", "five");
        map.put("5", "six");

        XWPFDocument document = WordExportUtil.exportWord07(TEMPLATE_FILE_NAME, map);
        List<Student> list = new ArrayList<>(2);
        this.addStudents(list);
        // 导出批量数据
        new ExcelEntityParse().parseNextRowAndAddRow(document.getTableArray(1), 1,
                new ExcelListEntity(list, Student.class, 1));

        String fileName = System.currentTimeMillis() + ".docx";
        response.reset();
        response.setContentType("application/msword");
        String dispositionValue = "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8");
        response.setHeader("Content-disposition", dispositionValue);
        response.setCharacterEncoding("UTF-8");
        OutputStream output = response.getOutputStream();
        document.write(output);
        document.close();
        output.close();
    }

    private void addStudents(List<Student> list) {
        Student stu = new Student();
        stu.setStudentName("zyj");
        stu.setAge(11);
        stu.setBirthday(new Date());
        stu.setChineseScore(new BigDecimal("88"));
        stu.setMathScore(new BigDecimal("85.5"));
        list.add(stu);
        stu = new Student();
        stu.setStudentName("lisi");
        stu.setAge(12);
        stu.setBirthday(new Date());
        stu.setChineseScore(new BigDecimal("87"));
        stu.setMathScore(new BigDecimal("89"));
        list.add(stu);
    }
}