package com.csi.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.domin.Student;

public class DemoFastJson {
    public static void main(String[] args) {
        Student s = new Student("狗蛋",1001);
        Student s2 = new Student("蛋蛋",1002);
        s.setStudent(s2);
        s2.setStudent(s2);
//        JSON.DEFAULT_GENERATE_FEATURE|= SerializerFeature.DisableCircularReferenceDetect.getMask();
        Object obj = null;
        JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
        //进行格式转换
        String string = JSON.toJSONString(s, SerializerFeature.PrettyFormat);
        System.out.println(string);
        String string2 = JSON.toJSONString(s2,SerializerFeature.PrettyFormat);
        System.out.println(string2);
        
    }
}
