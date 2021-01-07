package com.newtouch.work.entity;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @program: java_project
 * @description: ReadProperties
 * @author: YePengFei
 * @create: 2021-01-07 10:13
 **/
public class ReadProperties {
    private static ReadProperties instance;
    private static Properties prop;
    private ReadProperties (){}

    /*public static ReadProperties getInstance() {
        if (instance == null) {
            instance = new ReadProperties();
        }
        return instance;
        } */

    public static  Properties readProp(){
        if(prop==null){
            prop=new Properties();
            try{
                prop.load(ReadProperties.class.getResourceAsStream("/application.yml"));
                Enumeration<String> en = (Enumeration<String>)prop.propertyNames();
                while(en.hasMoreElements()){
                    String confkey = en.nextElement();
                    String value = prop.getProperty(confkey);
                    System.out.println("key:"+confkey+","+"value:"+value);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return prop;
    }

    public static void main(String[] args) {
        String tablename =ReadProperties.readProp().getProperty("userName");
        System.out.println(tablename);

    }
}
