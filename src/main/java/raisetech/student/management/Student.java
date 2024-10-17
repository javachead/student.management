package raisetech.student.management;

public class Student {
    private String name;
    private int age;

    // コンストラクタ
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // ゲッター
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}