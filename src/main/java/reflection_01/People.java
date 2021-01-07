package reflection_01;

/**
 * @program: java_project
 * @description: people
 * @author: YePengFei
 * @create: 2021-01-06 13:23
 **/
public class People {
    private String name;
    private Integer age;

    public People(){}

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public People( Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
