package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class Application {

	private String name = "Enami Kouji";
	private String age = "37";
	private String gender = "Male";
	private Map<String, String> student = new HashMap<>();

	public Application() {
		student.put("123", "Alice");
		student.put("456", "Bob");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo() {
		return name + " " + age + "歳 " + gender;
	}

	@PostMapping("/studentInfo")
	public void setStudentInfo(@RequestParam String name, @RequestParam String age) {
		this.name = name;
		this.age = age;
	}

	@GetMapping("/students")
	public Map<String, String> getStudents() {
		return student;
	}
}