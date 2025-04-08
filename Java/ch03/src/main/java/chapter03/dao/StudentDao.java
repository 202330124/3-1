package chapter03.dao;

import chapter03.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDao {
    private Map<String, Student> studentMap = new HashMap<>();

    public void insert(Student student) {
        studentMap.put(student.getsNum(), student);
    }

    public Student select(String sNum) {
        return studentMap.get(sNum);
    }

    public void update(Student student) {
        studentMap.put(student.getsNum(), student);
    }

    public void delete(String sNum) {
        studentMap.remove(sNum);
    }

    public Map<String, Student> getStudentMap() {
        return studentMap;
    }
}