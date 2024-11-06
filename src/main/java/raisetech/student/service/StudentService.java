package raisetech.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.student.Repository.StudentRepository;
import raisetech.student.data.Student;
import raisetech.student.data.StudentCourse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> serchStudentList () {
        // 検索処理
        List<Student> students = repository.search();

        // 年齢が30代の人のみを抽出する
        return students.stream()
                .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
                .collect(Collectors.toList());
    }

    public List<StudentCourse> searchCourseList() {
        // 検索処理
        List<StudentCourse> courses = repository.searchStudentcourses();

        // 「JAVAコース」のコース情報のみを抽出する
        return courses.stream()
                .filter(course -> "Java".equalsIgnoreCase(course.getCourseName()))
                .collect(Collectors.toList());
    }

    public
    StudentRepository getRepository() {
        return repository;
    }
}