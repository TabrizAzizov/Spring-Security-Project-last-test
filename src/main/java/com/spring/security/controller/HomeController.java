package com.spring.security.controller;

import com.spring.security.entity.Student;
import com.spring.security.repository.StudentRepository;
import com.spring.security.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
@NoArgsConstructor
@AllArgsConstructor
//@RequestMapping("/students")
public class HomeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/students")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("students/new")
    public String CreateStudentForm(Model model){
        //create student object to hold student form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";

    }
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";

    }
    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable  Long id,@ModelAttribute("student") Student student,Model model){
        //get student from database by id
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());
        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    //delete method
    @GetMapping("students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}