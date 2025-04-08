package chapter03;

public class Student {
    private String sNum;
    private String sId;
    private String sPwd;
    private String sName;
    private int sAge;
    private char sGender;
    private String sMajor;

    public Student(String sNum, String sId, String sPwd, int sAge, String sName, char sGender, String sMajor) {
        this.sNum = sNum;
        this.sId = sId;
        this.sPwd = sPwd;
        this.sAge = sAge;
        this.sName = sName;
        this.sGender = sGender;
        this.sMajor = sMajor;
    }

    public String getsNum() {
        return sNum;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public char getsGender() {
        return sGender;
    }

    public void setsGender(char sGender) {
        this.sGender = sGender;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }
}