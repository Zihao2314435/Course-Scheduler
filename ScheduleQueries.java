
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zihao
 */

public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduledStudentCount;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static PreparedStatement dropStudentScheduleByCourse;
    private static PreparedStatement dropScheduleByCourse;
    private static PreparedStatement updateScheduleEntry;
    private static ResultSet resultSet;
    
    public static void addScheduleEntry(ScheduleEntry schedule)
    {
        connection = DBConnection.getConnection();
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into schedule (semester, coursecode, studentid, status, timestamp) values (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, schedule.getSemester());
            addScheduleEntry.setString(2, schedule.getCourseCode());
            addScheduleEntry.setString(3, schedule.getStudentID());
            addScheduleEntry.setString(4, schedule.getStatus());
            addScheduleEntry.setTimestamp(5, schedule.getTimeStamp());
            
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID)
    {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> scheduleByStudent = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select semester, coursecode, studentid, status, timestamp from schedule where semester = ? and studentID = ? order by timestamp");
            getScheduleByStudent.setString(1,semester);
            getScheduleByStudent.setString(2,studentID);
            
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next())
            {
                scheduleByStudent.add(new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"),resultSet.getString("status"),resultSet.getTimestamp("timestamp")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduleByStudent;
    }
    
    public static int getScheduledStudentCount(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int scheduledStudentCount = 0;
        try
        {
            getScheduledStudentCount = connection.prepareStatement("select count(studentID) from schedule where semester = ? and courseCode = ? and status = 'Scheduled'");
            getScheduledStudentCount.setString(1, semester);
            getScheduledStudentCount.setString(2, courseCode);
            
            resultSet = getScheduledStudentCount.executeQuery();
            
            while(resultSet.next())
            { 
                scheduledStudentCount += resultSet.getInt(1);
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduledStudentCount;
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> scheduleByStudent = new ArrayList<ScheduleEntry>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select semester, coursecode, studentid, status, timestamp from schedule where semester = ? and coursecode = ? and status = 'Waitlisted' order by timestamp");
            getWaitlistedStudentsByClass.setString(1,semester);
            getWaitlistedStudentsByClass.setString(2,courseCode);
            
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                scheduleByStudent.add(new ScheduleEntry(resultSet.getString("semester"), resultSet.getString("coursecode"), resultSet.getString("studentid"),resultSet.getString("status"),resultSet.getTimestamp("timestamp")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return scheduleByStudent;
    }
    
    public static void dropStudentScheduleByCourse(String semester, String courseCode, String studentID){
        
        connection = DBConnection.getConnection();
        try
        {
            dropStudentScheduleByCourse = connection.prepareStatement("delete from schedule where semester = ? and coursecode = ? and studentid = ?");
            dropStudentScheduleByCourse.setString(1, semester);
            dropStudentScheduleByCourse.setString(2, courseCode);
            dropStudentScheduleByCourse.setString(3, studentID);
            
            dropStudentScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static void dropScheduleByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        try
        {
            dropScheduleByCourse = connection.prepareStatement("delete from schedule where semester = ? and coursecode = ?");
            dropScheduleByCourse.setString(1, semester);
            dropScheduleByCourse.setString(2, courseCode);
            
            dropScheduleByCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static void updateScheduleEntry(ScheduleEntry entry){
        connection = DBConnection.getConnection();
        try
        {
            updateScheduleEntry = connection.prepareStatement("update schedule set status = ?, timestamp = ? where semester = ? and coursecode = ? and studentid = ?");
            updateScheduleEntry.setString(1, entry.getStatus());
            updateScheduleEntry.setTimestamp(2, entry.getTimeStamp());
            updateScheduleEntry.setString(3, entry.getSemester());
            updateScheduleEntry.setString(4, entry.getCourseCode());
            updateScheduleEntry.setString(5, entry.getStudentID());
            
            updateScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}
