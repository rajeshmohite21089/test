package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.model.Student;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;
import net.guides.springboot2.springboot2jpacrudexample.security.MyUserDetails;
import net.guides.springboot2.springboot2jpacrudexample.service.StudentServices;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppController {

	@Autowired
	StudentServices service;
	 @Autowired 
	 private EmployeeRepository employeeRepository;
	
	@PostMapping("/login")
	public MyUserDetails getAllEmployeess() {
		 System.out.println("userDetails"+"userDetails");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails)auth.getPrincipal();
        
        System.out.println("userDetails"+userDetails);
        return userDetails;
		// return null;0
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println(employeeRepository.findAll());
		System.out.println("inside getAllEmployees");
		return employeeRepository.findAll();
		// return null;0
	}
	@GetMapping("/searchEmployees/{firstName}")
	public List<Employee> getAllEmployeesByFirstName(@PathVariable (name="firstName") String firstName) {
		System.out.println("start inside getAllEmployeesByFirstName");

		//System.out.println(employeeRepository.getEmployeeByFirstName(firstName));
		System.out.println("inside serachEmployees");
		return employeeRepository.getEmployeeByFirstName(firstName);
		// return null;
	}

	/*
	 * @RequestMapping("/") public String viewHomePage(Model model) { List<Student>
	 * listStudent = service.listAll();
	 * model.addAttribute("listStudent",listStudent); return "index"; }
	 */
	
	@RequestMapping("/new")
	public List<Employee> newStudentPage(Model model) {
		/*
		 * Student student=new Student(); model.addAttribute(student); return
		 * "new_student";
		 */
		
		System.out.println(employeeRepository.findAll());
		System.out.println("inside login");
		return employeeRepository.findAll();
	}
	
	
	@RequestMapping(value = "/save", method =RequestMethod.POST)
	public List<Employee> saveStudent(@ModelAttribute("student") Student student ) {
		System.out.println(employeeRepository.findAll());
		System.out.println("inside login");
		return employeeRepository.findAll();
	}
	@RequestMapping("/edit/{sid}")
	public List<Employee> showEditStudentPage(@PathVariable (name="sid") Long sid) {
		System.out.println(employeeRepository.findAll());
		System.out.println("inside login");
		return employeeRepository.findAll();
	}
	
	@RequestMapping("/delete/{sid}")
	public List<Employee> deleteStudentPage(@PathVariable (name="sid") Long sid) {
		System.out.println(employeeRepository.findAll());
		System.out.println("inside login");
		return employeeRepository.findAll();
	}
	
}
