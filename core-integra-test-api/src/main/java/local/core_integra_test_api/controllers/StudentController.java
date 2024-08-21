package local.core_integra_test_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import local.core_integra_test_api.models.Student;
import local.core_integra_test_api.models.request.StudentRequest;
import local.core_integra_test_api.services.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin()
@RequestMapping("/api/students")
public class StudentController {

  @Autowired
  StudentService service;

  @GetMapping()
  public List<Student> getAllStudents() {
    return service.getAllStudents();
  }

  @GetMapping("{id}")
  public Student getStudentById(@PathVariable String id) {
    return service.getStudentById(id);
  }

  @PostMapping()
  public Student addStudent(@RequestBody StudentRequest request) {
    return service.addStudent(request);
  }

  @PutMapping("{id}")
  public Student updateStudent(@PathVariable String id, @RequestBody Student request) {
    return service.updateStudent(id, request);
  }

  @DeleteMapping("{id}")
  public void deleteStudent(@PathVariable String id) {
    service.deleteStudent(id);
  }

}
