package reflection_01;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: java_project
 * @description:
 * @author: YePengFei
 * @create: 2021-01-06 15:29
 **/
public class testClass {
    public static void main(String[] args) throws Exception {
        // 反射在一定意义上破坏了封装性

        Class c1=Student.class;

        Object obj=(Object)c1.newInstance();
        /*访问私有方法*/
        Method add = c1.getDeclaredMethod("add");

        add.setAccessible(true);
        add.invoke((Student)obj);
        /*访问私有成员变量*/
//        Class c2=Students.class;
//        Object object = (Object) c2.newInstance();
//        Field adress  = c2.getDeclaredField("name");
//        adress.setAccessible(true);
//        adress.set(object,"beijing");
//        System.out.println(((Students)object).getName() );

        Class c2=Student.class;
        Object object = (Object) c2.newInstance();
        Field adress  = c2.getDeclaredField("name");
        adress.setAccessible(true);
        adress.set(object,"beijing");
        System.out.println(((Student)object).getName() );


        Class clz = Class.forName("reflection_01.Student");
        Method method = clz.getMethod("setAge", Integer.class);
        Constructor constructor = clz.getConstructor();
        Object object1 = constructor.newInstance();
        method.invoke(object1, 4);
        System.out.println(((Student) object1).getAge()
        );

    }
}
