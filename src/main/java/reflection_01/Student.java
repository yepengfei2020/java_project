package reflection_01;

/**
 * @program: java_project
 * @description:
 * @author: YePengFei
 * @create: 2021-01-06 15:28
 **/
public class Student extends People{
    private void add(){
        System.out.println("增加数据！");
    }

    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public Student(int id, String name,Integer age) {
        super(age);
        this.id = id;
        this.name = name;
    }
    public Student() {

    }
}
