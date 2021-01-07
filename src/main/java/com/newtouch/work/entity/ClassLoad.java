package com.newtouch.work.entity;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @program: java_project
 * @description:
 * @author: YePengFei
 * @create: 2021-01-06 17:01
 **/
public class ClassLoad {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //1.获取一个系统类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        //2.获取系统类加载器的父类加载器，即扩展类加载器。
        classLoader = classLoader.getParent();
        //3.获取扩展类加载器的父类加载器，即引用类加载器。
        classLoader = classLoader.getParent();
        //4.测试当前类由那个类加载器加载
        classLoader = Class.forName("com.newtouch.work.entity.Student").getClassLoader();
        System.out.println(classLoader);
        //5.测试JDK提供的Object类由那个类加载器提供
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);
        //6.关于类加载器的一个主要的方法：getRe
        InputStream inputStream = null;
//      inputStream = this.getClass().getClassLoader().getResourceAsStream();
        new ClassLoad().getPropertiesByInputStream_One();

    }

    public void  ClassLoader() throws IOException {
        Properties properties = new Properties();
        //类加载器不能够成功
//      properties.load(this.getClass().getClassLoader().getResourceAsStream("/application.yml"));
//      properties.load(ClassLoad.class.getResourceAsStream("/application.yml"));
//      properties.load(this.getClass().getResourceAsStream("/application.properties"));
        String userName = properties.getProperty("userName");
        String userName1 = properties.getProperty("userName1");
        System.out.println(userName+"*********"+userName1);
    }

    private void getPropertiesByInputStream_One() throws IOException {
        //全路径
       String path = "F:\\project\\java_project\\src\\main\\resources\\application.properties";
       // String path = "/application.properties";
        Properties properties = new Properties();
        InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
        properties.load(inputStream);
        System.out.println(this.getClass().getName()+"+"+Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println(properties.getProperty("userName"));
    }

    private void getPropertiesByInputStream_Two() throws IOException {
        //路径/开头，表示从classpath下取路径
//        String path = "/appium.properties";
        //路径不为/开头，从当前类所在包下取
        String path = "application.properties";
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(path);
        properties.load(inputStream);
        System.out.println(this.getClass().getName()+"+"+Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println(properties.getProperty("userName"));
    }

    private void getPropertiesByInputStream_Three() throws IOException{
        //getClassLoader默认加载路径就是classpath，规定不需要用/开头文件路径
        String path = "application.properties";

        Properties properties= new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        properties.load(inputStream);

        System.out.println(this.getClass().getName()+"+"+Thread.currentThread().getStackTrace()[1].getMethodName());

        System.out.println(properties.getProperty("userName"));
    }

    private void getPropertiesByInputStream_Four() throws IOException{
        //ClassLoader默认加载路径就是classpath，规定不需要用/开头文件路径
        String path = "application.properties";

        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        properties.load(inputStream);

        System.out.println(this.getClass().getName()+"+"+Thread.currentThread().getStackTrace()[1].getMethodName());

        System.out.println(properties.getProperty("userName"));
    }

    private void getPropertiesByResourceBundle_Five(){
        //这个getBundle()方法的参数相对同目录路径，并去掉.properties后缀，否则将抛异常
        String path = "application";
        ResourceBundle resourceBundle  = ResourceBundle.getBundle(path);

        System.out.println(this.getClass().getName()+"+"+Thread.currentThread().getStackTrace()[1].getMethodName());

        System.out.println(resourceBundle.getString("userName"));
    }






}
