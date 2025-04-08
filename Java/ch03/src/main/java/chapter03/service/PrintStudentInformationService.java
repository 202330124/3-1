package chapter03.service;

import chapter03.Student;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrintStudentInformationService {
    private StudentService studentService;

    public PrintStudentInformationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printStudentInformation() {
        Map<String, Student> allStudent = studentService.selectAll();
        Set<String> keys = allStudent.keySet();
        Iterator<String> iterator = keys.iterator();
        System.out.println("============= 학생 목록 시작 =============");

        while(iterator.hasNext()) {
            String key = iterator.next();
            Student student = allStudent.get(key);
            System.out.print("sNum: " + student.getsNum() + "\t");
            System.out.print("sId: " + student.getsId() + "\t");
            System.out.print("sName: " + student.getsName() + "\t");
            System.out.print("sAge: " + student.getsAge() + "\t");
            System.out.print("sGender: " + student.getsGender() + "\t");
            System.out.println("sMajor: " + student.getsMajor());
        }

        System.out.println("============= 학생 목록 끝 =============");
    }
}