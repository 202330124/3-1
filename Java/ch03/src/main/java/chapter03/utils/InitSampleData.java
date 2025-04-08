package chapter03.utils;

public class InitSampleData {
    private String[] sNums;
    private String[] sIds = { "rabbit", "hippo", "raccoon", "elephant", "lion" };
    private String[] sPws = { "0001", "0002", "0003", "0004", "0005" };
    private String[] sNames = { "user01", "user2", "user03", "user04", "user05" };
    private int[] sAges = { 19, 20, 22, 23, 25 };
    private char[] sGender = { 'M', 'F', 'M', 'M', 'F' };
    private String[] sMajors = { "AAA", "BBB", "CCC", "DDD", "EEE" };

    public String[] getsNums() {
        return sNums;
    }

    public void setsNums(String[] sNums) {
        this.sNums = sNums;
    }

    public String[] getsIds() {
        return sIds;
    }

    public void setsIds(String[] sIds) {
        this.sIds = sIds;
    }

    public String[] getsPws() {
        return sPws;
    }

    public void setsPws(String[] sPws) {
        this.sPws = sPws;
    }

    public String[] getsNames() {
        return sNames;
    }

    public void setsNames(String[] sNames) {
        this.sNames = sNames;
    }

    public int[] getsAges() {
        return sAges;
    }

    public void setsAges(int[] sAges) {
        this.sAges = sAges;
    }

    public char[] getsGender() {
        return sGender;
    }

    public void setsGender(char[] sGender) {
        this.sGender = sGender;
    }

    public String[] getsMajors() {
        return sMajors;
    }

    public void setsMajors(String[] sMajors) {
        this.sMajors = sMajors;
    }
}