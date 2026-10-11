
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zihao
 */
public class MultiTableQueries {
    private static Connection connection;
    private static PreparedStatement getAllClassDescriptions;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static ResultSet resultSet;
    
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> classDescription = new ArrayList<ClassDescription>();
        try
        {
            getAllClassDescriptions = connection.prepareStatement("select class.courseCode, description, seats from class, course where semester = ? and class.courseCode = course.courseCode order by class.courseCode");
            getAllClassDescriptions.setString(1,semester);
            
            resultSet = getAllClassDescriptions.executeQuery();
            
            while(resultSet.next())
            {
                classDescription.add(new ClassDescription(resultSet.getString("coursecode"), resultSet.getString("description"), resultSet.getInt("seats")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return classDescription;
    }
    
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        try
        {
            getScheduledStudentsByClass = connection.prepareStatement("select student.studentid, firstname, lastname from student, schedule where semester = ? and schedule.coursecode = ? and schedule.status = 'Scheduled' "
                                                                    + "and student.studentid = schedule.studentid order BY schedule.timestamp");
            getScheduledStudentsByClass.setString(1, semester);
            getScheduledStudentsByClass.setString(2, courseCode);
            
            resultSet = getScheduledStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                students.add(new StudentEntry(resultSet.getString("studentid"), resultSet.getString("firstname"), resultSet.getString("lastname")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<StudentEntry>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select student.studentid, firstname, lastname from student, schedule where semester = ? and schedule.coursecode = ? and schedule.status = 'Waitlisted' "
                                                                     + "and student.studentid = schedule.studentid order BY schedule.timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                students.add(new StudentEntry(resultSet.getString("studentid"), resultSet.getString("firstname"), resultSet.getString("lastname")));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return students;
    }
}
    
    
    
    
 