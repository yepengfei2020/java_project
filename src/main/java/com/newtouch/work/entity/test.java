package com.newtouch.work.entity;

import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @program: java_project
 * @description:
 * @author: YePengFei
 * @create: 2021-01-07 09:50
 **/
public class test {
    public static void main(String[] args) throws IOException {
        new test().pathTest();
    }

    public void pathTest() throws IOException {
        File f = new File(this.getClass().getResource("/").getPath());
//        System.out.println(f.getPath());
//        f = new File(f.getPath() + "/conf/config.properties");
//        this.getClass().getClassLoader().getResource("test.java").getPath();
//        this.getClass().getClassLoader().getResources("test.java");
//        System.out.println(System.getProperty("user.dir" ));  // F:\project\java_project
        System.out.println(this.getClass().getResource("/application.yml").getFile());
        System.out.println(this.getClass().getResource("/application.yml").getPath());
        System.out.println(this.getClass().getResource("/application.yml").getContent());
        System.out.println(this.getClass().getResource("/").getFile());
        File file1 = new File(this.getClass().getResource("/application.yml").getFile());
        System.out.println("文件路径："+ file1.getPath());
        System.out.println("文件名称："+ file1.getName());
        System.out.println("文件绝对路径："+ file1.getAbsolutePath());
        System.out.println("文件那个文件下："+ file1.getParent());
        System.out.println("文件规范路径："+ file1.getCanonicalPath());
        System.out.println("文件绝对文件："+ file1.getAbsoluteFile());


        String path  = this.getClass().getResource("/application.yml").getFile();
        Properties properties = new  Properties();

        System.out.println("************************FileInputStream*********************************");

        InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
        properties.load(inputStream);
        System.out.println(properties.getProperty("userName"));

        System.out.println("*************************getResourceAsStream********************************");
        properties.load(test.class.getResourceAsStream("/application.yml"));
        System.out.println(properties.getProperty("userName"));

        System.out.println("***********************getClassLoader()**********************************");

//        InputStream inputStream1 = this.getClass().getClassLoader().getResourceAsStream("application.yml");
        InputStream inputStream1 = this.getClass().getClassLoader().getSystemResourceAsStream("application.yml");
        properties.load(inputStream1);
        System.out.println(properties.getProperty("userName"));



        System.out.println("***********************ClassLoader**********************************");

        InputStream inputStream2 = ClassLoader.getSystemResourceAsStream("application.yml");
        properties.load(inputStream2);
        System.out.println(properties.getProperty("userName"));


        System.out.println("**************************getBundle*******************************");
        ResourceBundle resourceBundle  = ResourceBundle.getBundle("application");

        System.out.println(resourceBundle.getString("userName"));


    }
}
