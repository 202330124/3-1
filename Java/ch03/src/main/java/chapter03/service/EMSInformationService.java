package chapter03.service;

import chapter03.DBConnectionInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EMSInformationService {
    private String info;
    private String copyright;
    private String version;
    private int sYear;
    private int sMonth;
    private int sDay;
    private int eYear;
    private int eMonth;
    private int eDay;
    private List<String> developers;
    private Map<String, String> administrators;
    private Map<String, DBConnectionInfo> dbInfos;

    public void printEMSInformationService() {
        System.out.println("============= EMS 정보 출력 =============");
        String devPeriod = sYear + "-" + sMonth + "-" + sDay + "~" + eYear + "-" + eMonth + "-" + eDay;
        System.out.println(info + "(" + devPeriod + ")");
        System.out.println(copyright);
        System.out.println(version);
        System.out.println("Developers: " + developers);
        System.out.println("Administrators: " + administrators);
        printDBInfo();
        System.out.println("============= EMS 정보 출력 끝 =============");
    }

    public String printDBInfo() {
        Set<String> keys = dbInfos.keySet();
        Iterator<String> it = keys.iterator();

        while(it.hasNext()) {
            String key = it.next();
            DBConnectionInfo info = dbInfos.get(key);
            System.out.println("[" + key + "] DB");
            System.out.println(info.getUrl());
            System.out.println(info.getUsername());
            System.out.println(info.getPassword());
        }

        return info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getsYear() {
        return sYear;
    }

    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    public int getsMonth() {
        return sMonth;
    }

    public void setsMonth(int sMonth) {
        this.sMonth = sMonth;
    }

    public int getsDay() {
        return sDay;
    }

    public void setsDay(int sDay) {
        this.sDay = sDay;
    }

    public int geteYear() {
        return eYear;
    }

    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    public int geteMonth() {
        return eMonth;
    }

    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    public int geteDay() {
        return eDay;
    }

    public void seteDay(int eDay) {
        this.eDay = eDay;
    }

    public List<String> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<String> developers) {
        this.developers = developers;
    }

    public Map<String, String> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Map<String, String> administrators) {
        this.administrators = administrators;
    }

    public Map<String, DBConnectionInfo> getDbInfos() {
        return dbInfos;
    }

    public void setDbInfos(Map<String, DBConnectionInfo> dbInfos) {
        this.dbInfos = dbInfos;
    }
}