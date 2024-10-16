package raisetech.student.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository;  // StudentRepositoryの自動注入

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// 全ての学生情報を取得
	@GetMapping("/studentInfo")
	public String getAllStudentInfo() {
		List<Student> students = repository.findAll();  // 全ての学生情報を取得
		if (students.isEmpty()) {
			return "No students found.";
		}

		StringBuilder result = new StringBuilder();
		for (Student student : students) {
			result.append(student.getName())  // 学生の名前を取得
					.append(" ")
					.append(student.getAge())  // StudentクラスのgetAgeメソッドを使用
					.append("歳\n");
		}

		return result.toString();
	}

	// 新しい学生情報を登録
	@PostMapping("/studentInfo")
	public String setStudentInfo(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);  // データベースに新しい学生を登録
		return "Student " + name + " has been registered.";
	}
}
