package com.zyj.springboot.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author Yujie_Zhao
 * @ClassName City
 * @Description @Accessors(chain = true) 注解，能让我们方便使用链式方法创建实体对象。
 * @Date 2021/4/16  11:19
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Document(collection = "city")
public class City {

    /**
     * 城市编号
     */
    @MongoId
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