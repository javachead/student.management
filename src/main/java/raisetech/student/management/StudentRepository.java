package raisetech.student.management;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StudentRepository {
    //@Select("SELECT * FROM student WHERE name = #{name}")
    //Student searchByName(String name);

    // 全ての学生を取得
    @Select("SELECT * FROM student")
    List<Student> findAll();

    void registerStudent(String name, int age);

    /*
    // 学生の登録
    @Insert("INSERT INTO student (name, age) VALUES (#{name}, #{age})")
    void registerStudent(String name, int age);
    // 学生の年齢を更新
    @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
    void updateStudent(String name, int age);
    // 学生の削除
    @Delete("DELETE FROM student WHERE name = #{name}")
    void deleteStudent(String name);
    */
}