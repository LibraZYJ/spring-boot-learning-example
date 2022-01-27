package com.example.testeverything.Jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * @author Yujie_Zhao
 * @date 2022/1/26 14:06
 * @deprecated 利用Jackson 来解决数据反序列化的问题，
 */

public class ReadValueDemo {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "赵玉杰");
//        map.put("sex", "男");
//        map.put("age", 18);

        UserBase userBaseJson = new UserBase();
        userBaseJson.setUserName("赵玉杰");
        userBaseJson.setAge(18);
        userBaseJson.setAddTime(123);
        //这边  序列化  一个json
        String json1 = objectMapper.writeValueAsString(userBaseJson);
        System.out.println("json1 : " + json1);
        String json2 = "[{\"userName\":\"赵玉杰\",\"age\":18,\"addTime\":123},{\"userName\":\"科伊星\",\"age\":1,\"addTime\":321}]";

        //下面开始反序列化

        //简单的方法， 直接将一个json转换成实体类
        UserBase userBase = objectMapper.readValue(json1, UserBase.class);
        //TypeReference主要争对于复杂类型
        UserBase userBase1  =  objectMapper.readValue(json1, new TypeReference<UserBase>() {});
        System.out.println("简单的: " + userBase.getUserName());
        System.out.println("TypeReference: " + userBase1.getUserName());


        //把Json转换成Map ，这里必须使用的是，TypeReference, Map的定义类型可以看自己的使用情况的，别入值都是String 可以Map<String，String>
        Map<String, Object> userList  = objectMapper.readValue(json1, new TypeReference<Map<String, Object>>() {});
        System.out.println("map :" + userList.get("userName"));

        //List<Bean> 模式，必须使用 TypeReference
        List<UserBase> userBases = objectMapper.readValue(json2, new TypeReference<List<UserBase>>() {});
        System.out.println("List : " + userBases.get(0).getUserName());


        //Bean[]数组， 必须使用TypeReference
        UserBase[] userBases1 = objectMapper.readValue(json2, new TypeReference<UserBase[]>() {});
        System.out.println("ary : " + userBases1[0].getUserName());





    }
}

@Data
class UserBase {
    private String userName;
    private Integer age;
    private Integer addTime;
}