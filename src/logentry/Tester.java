package logentry;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/short-test_log");
        la.printAll();
    }

    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Uniq Ips: " + la.countUniqueIPs());
    }

    public void testHigherThanNum(int num){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog1_log");
        System.out.println("Uniq IP higher then num " + num);
        la.printAllHigherThanNum(num);
    }

    public void testUniqueIPVisitsOnDay(String someDay){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Uniq Ip in " + someDay + ":" );
        ArrayList<String> logEntitys = la.uniqueIPVisitsOnDay(someDay);
//        for(String ip: logEntitys){
//            System.out.println(ip);
//        }
        System.out.println(logEntitys.size());
    }

    public void testCountUniqueIPsInRange(int low, int high){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Count of uniq IP in status code betweeen " + low + " and " + high + " is:");
        System.out.println(la.countUniqueIPsInRange(low,high));
    }

    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/short-test_log");
        System.out.println("HshMap is :");
        System.out.println(la.countVisitsPerIP());
    }

    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Test mostNumberVisitsByIP");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    }

    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Test IPsMostVisits");
        System.out.println(la.iPsMostVisits(la.countVisitsPerIP()));
    }

    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog3-short_log");
        System.out.println("Test IPsForDays");
        System.out.println(la.iPsForDays());
    }

    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Test DayWithMostIPVisits");
        System.out.println(la.dayWithMostIPVisits(la.iPsForDays()));
    }

    public void iPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("logentry/weblog2_log");
        System.out.println("Test iPsWithMostVisitsOnDay");
        System.out.println(la.iPsWithMostVisitsOnDay(la.iPsForDays(),"Sep 30"));
    }


}
