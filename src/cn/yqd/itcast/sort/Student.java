package cn.yqd.itcast.sort;
//1.定义一个学生类Student，具有年龄age和姓名name两个属性，并通过Comparable接口提供比较规则；
public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student o) {
        // 升序
        return this.getAge() - o.getAge();
    }

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
