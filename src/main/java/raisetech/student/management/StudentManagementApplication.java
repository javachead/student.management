package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}

@RestController
class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping("/studentList")
    public
    List<Student> getStudentList() {
        return repository.search();
    }

    @GetMapping("/studentCourseList")
    public
    List<StudentCourse> getStudentCourseList() {
        return repository.searchcourselist();
    }
}