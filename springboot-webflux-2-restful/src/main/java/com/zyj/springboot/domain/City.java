package com.zyj.springboot.domain;

import lombok.Data;

/**
 * @author Yujie_Zhao
 * @ClassName City
 * @Description TODO
 * @Date 2021/4/16  11:19
 * @Version 1.0
 **/
@Data
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;
}