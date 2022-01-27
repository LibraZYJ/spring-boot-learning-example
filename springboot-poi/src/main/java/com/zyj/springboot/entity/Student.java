package com.zyj.springboot.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author YuJie_zhao
 * @date 2021/8/4 23:10
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 2131321500629905052L;

    @Excel(name = "学生姓名")
    private String studentName;

    @Excel(name = "学生年龄")
    private Integer age;

    @Excel(name = "学生生日", importFormat = "yyyy/MM/dd", exportFormat = "yyyy/MM/dd")
    private Date birthday;

    @Excel(name = "语文成绩")
    private BigDecimal chineseScore;

    @Excel(name = "数学成绩")
    private BigDecimal mathScore;

}