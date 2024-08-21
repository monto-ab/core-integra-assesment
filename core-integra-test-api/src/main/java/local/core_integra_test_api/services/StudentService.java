package local.core_integra_test_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import local.core_integra_test_api.models.Student;
import local.core_integra_test_api.models.request.StudentRequest;
import local.core_integra_test_api.repositories.StudentRepository;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student addStudent(StudentRequest request) {
    Student student = new Student();
    student.setName(request.getName());
    student.setAge(request.getAge());
    return studentRepository.saveAndFlush(student);

  }

  public Student updateStudent(String id, Student request) {
    // cast id to Long

    Long.parseLong(id);
    Student student = studentRepository.findById(Long.parseLong(id)).orElse(null);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }
    System.out.println("Student found");
    student.setName(request.getName());
    student.setAge(request.getAge());
    return studentRepository.saveAndFlush(student);
  }

  public void deleteStudent(String id) {
    // cast id to Long
    Long.parseLong(id);
    Student student = studentRepository.findById(Long.parseLong(id)).orElse(null);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }
    studentRepository.delete(student);

  }

  public Student getStudentById(String id) {
    // cast id to Long
    Long.parseLong(id);
    Student student = studentRepository.findById(Long.parseLong(id)).orElse(null);
    if (student == null) {
      throw new RuntimeException("Student not found");
    }
    return student;
  }

}
