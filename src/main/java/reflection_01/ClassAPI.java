package reflection_01;

import java.lang.reflect.Field;

/**
 * @program: java_project
 * @description: 反射
 * @author: YePengFei
 * @create: 2021-01-06 13:52
 **/
public class ClassAPI {

    public static void main(String[] args) throws Exception {
        /// 获取成员变量
        Class<?> clazz = Class.forName("reflection_01.Student");
        // 获取成员变量,包括子类及父类,同时只能包含公共的方法
        Field[]  fields = clazz.getFields();
//        System.out.print(fields.length);
//        for(Field field: fields){
//            System.out.println(field);
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//            System.out.println(field.getModifiers());
//            System.out.println("-------------------------");
//        }
//        Field[]  field1 = aClass.getDeclaredFields();
//        for(Field declar: field1){
//            System.out.println(declar);
//            System.out.println(declar.getName());
//            System.out.println(declar.getType());
//            System.out.println(declar.getModifiers());
//            System.out.println("-------------------------");
//        }
        // 反射在一定意义上破坏了封装性
        Field adress  =  clazz.getDeclaredField("name");
        adress.setAccessible(true);
        System.out.println(adress.getName());
        Object o = clazz.newInstance();
        adress.set(o,"zhangyisan");
        System.out.println(((Student) o).getName());

//        Class c1=Student.class;
//        Object obj=(Object)c1.newInstance();
//        Method add = c1.getDeclaredMethod("add");
//        add.setAccessible(true);
//        add.invoke((Student)obj);
    }

}