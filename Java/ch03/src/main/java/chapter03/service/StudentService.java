package chapter03.service;

import chapter03.Student;
import chapter03.dao.StudentDao;

import java.util.Map;

public class StudentService {
    private StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void register(Student student) {
        if(!exists(student.getsNum())) {
            studentDao.insert(student);
        }

        else {
            System.out.println("이미 등록된 회원입니다.");
        }
    }

    public boolean exists(String sNum) {
        Student student = this.studentDao.select(sNum);
        return student != null;
    }

    public Student select(String sNum) {
        if(exists(sNum)) {
            return studentDao.select(sNum);
        }

        else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }

        return null;
    }

    public Map<String, Student> selectAll() {
        return studentDao.getStudentMap();
    }

    public void modify(Student student) {
        if(exists(student.getsNum())) {
            studentDao.update(student);
        }

        else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }
    }

    public void delete(String sNum) {
        if(exists(sNum)) {
            studentDao.delete(sNum);
        }

        else {
            System.out.println("회원 정보를 찾을 수 없습니다.");
        }
    }
}