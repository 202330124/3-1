package chapter03;

import chapter03.service.EMSInformationService;
import chapter03.service.PrintStudentInformationService;
import chapter03.service.StudentService;
import chapter03.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        InitSampleData initSampleData = context.getBean("initSampleData", InitSampleData.class);
        String[] sNums = initSampleData.getsNums();
        String[] sIds = initSampleData.getsIds();
        String[] sPwds = initSampleData.getsPws();
        int[] sAges = initSampleData.getsAges();
        String[] sNames = initSampleData.getsNames();
        char[] sGenders = initSampleData.getsGender();
        String[] sMajors = initSampleData.getsMajors();
        System.out.println("sNums: " + sNums[0]);

        StudentService studentService = context.getBean("studentService", StudentService.class);
        for(int i = 0; i < sNums.length; i++) {
            studentService.register(new Student(sNums[i], sIds[i], sPwds[i], sAges[i], sNames[i], sGenders[i], sMajors[i]));
        }

        Student selectStudent = studentService.select("spring01");
        selectStudent.setsMajor("컴퓨터전공");
        studentService.modify(selectStudent);

        studentService.delete("spring02");

        PrintStudentInformationService printStudentInformationService = context.getBean("printStudentInformationService", PrintStudentInformationService.class);
        printStudentInformationService.printStudentInformation();

        EMSInformationService emsInformationService = context.getBean("emsInformationService", EMSInformationService.class);
        emsInformationService.printEMSInformationService();
    }
}