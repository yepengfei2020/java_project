package reflection_01;

/**
 * @program: java_project
 * @description: 反射
 * @author: YePengFei
 * @create: 2021-01-06 13:21
 **/
public class CreateClassObject {
    public static void main(String[] args) throws Exception {
        //1.通过class.forName获取Class对象
        Class clazz = Class.forName("reflection_01.People");
        //2.通过类名来获取
        //Class<People> clazz1 = People.class;
        //3.通过对象的.class来获取
        //Class clazz2 = new People().getClass();
//        System.out.println(clazz.getPackage());
//        System.out.println(clazz.getName());
//        System.out.println(clazz.getSimpleName());
//        System.out.println(clazz.getCanonicalName());

        //4.基本数据类型可以通过type来获取class对象

        Class<Integer> type = Integer.TYPE;

        System.out.println(type.getName());
        System.out.println(type.getCanonicalName());



    }
}
