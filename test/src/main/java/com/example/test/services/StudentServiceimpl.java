package com.example.test.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.test.exception.*;
import com.example.test.entities.Student;
import com.example.test.StudentRepo.studentRepo;
@Service
public class StudentServiceimpl implements StudentService {

	private studentRepo studentRepo;
	List<Student> list;
	public StudentServiceimpl(studentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	public List<Student> getStudent() {
		return studentRepo.findAll();
	}
	@Override
	public Student getStudent(long id) {
		return studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
	}
	@Override
	public Student addStudent(Student Std) {
		return studentRepo.save(Std);
	}
	@Override
	public Student updateStudent(Student student, long id) {
		// we need to check whether student with given id is exist in DB or not
				Student existingStudent = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("student", "Id", id)); 
				
		        
				existingStudent.setfirst_name(student.getfirst_name());
				existingStudent.setlast_name(student.getlast_name());
				existingStudent.setemail(student.getemail());	
				
				// save existing student
				studentRepo.save(existingStudent);
				return existingStudent;
	}
	@Override
	public void deleteStudent(long id) {
		studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "Id", id));
		studentRepo.deleteById(id);
	}

}
