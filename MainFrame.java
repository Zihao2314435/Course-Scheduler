
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acv
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String currentSemester;
    private String author;
    private String projectDate;

    public MainFrame() {
        initComponents();
        checkData();
        
        rebuildSemesterComboBoxes();
        rebuildCourseComboBoxes();
        rebuildClassComboBoxes();
        rebuildStudentComboBoxes();
    }

    public void rebuildSemesterComboBoxes() {
        ArrayList<String> semesters = SemesterQueries.getSemesterList();
        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel(semesters.toArray()));
        
        if(semesters.size() > 0){
            currentSemesterLabel.setText(semesters.get(0));
            currentSemester = semesters.get(0);
        } 
        else{
            currentSemesterLabel.setText("None, add a semester.");
            currentSemester = "None";
        }
    }

    //rebuilt coursecombobox in admin add class
    public void rebuildCourseComboBoxes() {
       ArrayList<String> courses = CourseQueries.getAllCourseCodes();
       selectCourseCodeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(courses.toArray()));
      
       if(courses.size() > 0){
          selectCourseCodeJComboBox.setSelectedIndex(0);  
       } 
       else{
           selectCourseCodeJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a course."})); 
       }
    }
    
    //rebuild classcombobox in student schedule class
    public void rebuildClassComboBoxes(){
        ArrayList<String> classes = ClassQueries.getAllCourseCodes((String)currentSemesterLabel.getText());
        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));
        chooseClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));
        adminDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));
        studentDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(classes.toArray()));
        
        if(classes.size() > 0){
          selectClassComboBox.setSelectedIndex(0);
          chooseClassComboBox.setSelectedIndex(0);
          adminDropClassComboBox.setSelectedIndex(0);
          studentDropClassComboBox.setSelectedIndex(0);
           
        } 
        else{
           selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a Class."}));
           chooseClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a Class."}));
           adminDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a Class."}));
           studentDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a Class."}));
        }
    }
    
    //rebuild studentcombobox in student schedule class
    public void rebuildStudentComboBoxes(){
        ArrayList<StudentEntry> student = StudentQueries.getAllStudent();
        ArrayList<String> names = new ArrayList<>();
    
        for(StudentEntry students : student){
            String name = students.getLastName() + ", " + students.getFirstName() + " " + students.getStudentID();
            names.add(name);
        }
   
        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
        studentScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
        studentDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel(names.toArray()));
        
        if(student.size() > 0)
        {
            selectStudentComboBox.setSelectedIndex(0);
            studentScheduleComboBox.setSelectedIndex(0);
            studentDropStudentComboBox.setSelectedIndex(0);
            dropStudentComboBox.setSelectedIndex(0);
        }
        else{
            selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a student."}));
            studentScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a student."}));
            studentDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a student."}));
            dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"None, add a student."}));
        }
          
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        courseSchedulerTitle = new javax.swing.JLabel();
        userPanel = new javax.swing.JTabbedPane();
        adminPanel = new javax.swing.JPanel();
        adminTab = new javax.swing.JTabbedPane();
        addsemesterPanel = new javax.swing.JPanel();
        addSemesterLabel = new javax.swing.JLabel();
        addSemesterTextfield = new javax.swing.JTextField();
        addSemesterSubmitButton = new javax.swing.JButton();
        addSemesterStatusLabel = new javax.swing.JLabel();
        addCoursePanel = new javax.swing.JPanel();
        courseCodeLable = new javax.swing.JLabel();
        addCourseCodeTextField = new javax.swing.JTextField();
        courseDescriptionLabel = new javax.swing.JLabel();
        addCourseDescriptionTextField = new javax.swing.JTextField();
        addCourseSubmitButton = new javax.swing.JButton();
        addCourseStatusLabel = new javax.swing.JLabel();
        addStudentPanel = new javax.swing.JPanel();
        studentIDLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        addStudentIDTextField = new javax.swing.JTextField();
        addFirstNameTextField = new javax.swing.JTextField();
        addLastNameTextField = new javax.swing.JTextField();
        addStudentSubmitButton = new javax.swing.JButton();
        addStudentStatusLabel = new javax.swing.JLabel();
        addClassPanel = new javax.swing.JPanel();
        courseCodelabel = new javax.swing.JLabel();
        seatlebel = new javax.swing.JLabel();
        addClassSubmitButton = new javax.swing.JButton();
        addClassStatusLabel = new javax.swing.JLabel();
        selectCourseCodeJComboBox = new javax.swing.JComboBox<>();
        editSeatsJSpinner = new javax.swing.JSpinner();
        dispayClassListPanel = new javax.swing.JPanel();
        chooseClassComboBox = new javax.swing.JComboBox<>();
        chooseClassLabel = new javax.swing.JLabel();
        studentScheduledClassDisplayButton = new javax.swing.JButton();
        scheduleStudentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scheduleStudentTable = new javax.swing.JTable();
        waitlistStudentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        waitlistStudentTable = new javax.swing.JTable();
        dropStudentPanel = new javax.swing.JPanel();
        chooseStudentLabel = new javax.swing.JLabel();
        dropStudentComboBox = new javax.swing.JComboBox<>();
        dropStudentSubmitButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        dropStudentInfoTextArea = new javax.swing.JTextArea();
        dropClassPanel = new javax.swing.JPanel();
        adminChooseClassLabel = new javax.swing.JLabel();
        adminDropClassComboBox = new javax.swing.JComboBox<>();
        adminDropClassSubmitButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        adminDropClassInfoTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        studentPanel = new javax.swing.JPanel();
        studentTab = new javax.swing.JTabbedPane();
        displayClassesPanel = new javax.swing.JPanel();
        displayClasses = new javax.swing.JScrollPane();
        displayCoursesTable = new javax.swing.JTable();
        classDisplayButton = new javax.swing.JButton();
        displaySchedulePanel = new javax.swing.JPanel();
        displaySchedule = new javax.swing.JScrollPane();
        displayScheduleTable = new javax.swing.JTable();
        scheduleDisplayButton = new javax.swing.JButton();
        selectStudentLabel = new javax.swing.JLabel();
        studentScheduleComboBox = new javax.swing.JComboBox<>();
        scheduleClassPanel = new javax.swing.JPanel();
        selectClassTextField = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        selectClassComboBox = new javax.swing.JComboBox<>();
        selectStudentComboBox = new javax.swing.JComboBox<>();
        scheduleClassSubmitButton = new javax.swing.JButton();
        scheduleClassStatusTextField = new javax.swing.JLabel();
        studentDropClassPanel = new javax.swing.JPanel();
        studentChooseStudentLabel = new javax.swing.JLabel();
        studentDropStudentComboBox = new javax.swing.JComboBox<>();
        studentChooseClassLabel = new javax.swing.JLabel();
        studentDropClassComboBox = new javax.swing.JComboBox<>();
        studentDropClassSubmitButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentDropClassInfoTextArea = new javax.swing.JTextArea();
        currentSemesterText = new javax.swing.JLabel();
        currentSemesterLabel = new javax.swing.JLabel();
        currentSemesterComboBox = new javax.swing.JComboBox<>();
        changeSemesterButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        courseSchedulerTitle.setFont(new java.awt.Font("Comic Sans MS", 1, 30)); // NOI18N
        courseSchedulerTitle.setForeground(new java.awt.Color(0, 153, 153));
        courseSchedulerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseSchedulerTitle.setText("Course Scheduler");

        addSemesterLabel.setText("Semester Name:");

        addSemesterTextfield.setColumns(20);
        addSemesterTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterTextfieldActionPerformed(evt);
            }
        });

        addSemesterSubmitButton.setText("Submit");
        addSemesterSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSemesterSubmitButtonActionPerformed(evt);
            }
        });

        addSemesterStatusLabel.setText("                                                   ");

        javax.swing.GroupLayout addsemesterPanelLayout = new javax.swing.GroupLayout(addsemesterPanel);
        addsemesterPanel.setLayout(addsemesterPanelLayout);
        addsemesterPanelLayout.setHorizontalGroup(
            addsemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsemesterPanelLayout.createSequentialGroup()
                .addGroup(addsemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addsemesterPanelLayout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(addSemesterSubmitButton))
                    .addGroup(addsemesterPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(addsemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addsemesterPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addSemesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addsemesterPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addsemesterPanelLayout.setVerticalGroup(
            addsemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addsemesterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addsemesterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addSemesterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addSemesterTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(addSemesterSubmitButton)
                .addGap(12, 12, 12)
                .addComponent(addSemesterStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminTab.addTab("Add Semester", addsemesterPanel);

        courseCodeLable.setText("Course Code:");

        addCourseCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseCodeTextFieldActionPerformed(evt);
            }
        });

        courseDescriptionLabel.setText("Course Description: ");

        addCourseDescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseDescriptionTextFieldActionPerformed(evt);
            }
        });

        addCourseSubmitButton.setText("Submit");
        addCourseSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCoursePanelLayout = new javax.swing.GroupLayout(addCoursePanel);
        addCoursePanel.setLayout(addCoursePanelLayout);
        addCoursePanelLayout.setHorizontalGroup(
            addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoursePanelLayout.createSequentialGroup()
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCoursePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseCodeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCoursePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCoursePanelLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCoursePanelLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(addCourseSubmitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addCoursePanelLayout.setVerticalGroup(
            addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCoursePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCourseCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(courseCodeLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(addCoursePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addCourseDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addCourseSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        adminTab.addTab("Add Course", addCoursePanel);

        studentIDLabel.setText("Student ID:");

        firstNameLabel.setText("First Name:");

        lastNameLabel.setText("Last Name:");

        addStudentIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentIDTextFieldActionPerformed(evt);
            }
        });

        addFirstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFirstNameTextFieldActionPerformed(evt);
            }
        });

        addStudentSubmitButton.setText("Submit");
        addStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addStudentPanelLayout = new javax.swing.GroupLayout(addStudentPanel);
        addStudentPanel.setLayout(addStudentPanelLayout);
        addStudentPanelLayout.setHorizontalGroup(
            addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPanelLayout.createSequentialGroup()
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addStudentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(firstNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(studentIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addFirstNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(addLastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addStudentIDTextField)))
                    .addGroup(addStudentPanelLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(addStudentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addStudentPanelLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(addStudentSubmitButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addStudentPanelLayout.setVerticalGroup(
            addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addStudentIDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addFirstNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(addStudentSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(addStudentStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        adminTab.addTab("Add Student", addStudentPanel);

        courseCodelabel.setText("Course Code:");

        seatlebel.setText("Seats:");

        addClassSubmitButton.setText("Submit");
        addClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassSubmitButtonActionPerformed(evt);
            }
        });

        selectCourseCodeJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCourseCodeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCourseCodeJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addClassPanelLayout = new javax.swing.GroupLayout(addClassPanel);
        addClassPanel.setLayout(addClassPanelLayout);
        addClassPanelLayout.setHorizontalGroup(
            addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassPanelLayout.createSequentialGroup()
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(seatlebel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editSeatsJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(courseCodelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectCourseCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addClassPanelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(addClassSubmitButton))
                    .addGroup(addClassPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addClassPanelLayout.setVerticalGroup(
            addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(courseCodelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectCourseCodeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(seatlebel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(editSeatsJSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addClassSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addClassStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        adminTab.addTab("Add Class", addClassPanel);

        chooseClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chooseClassLabel.setText("Choose Class:");

        studentScheduledClassDisplayButton.setText("Display");
        studentScheduledClassDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentScheduledClassDisplayButtonActionPerformed(evt);
            }
        });

        scheduleStudentLabel.setText("Scheduled Students in the Class");

        scheduleStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "StudentID"
            }
        ));
        jScrollPane1.setViewportView(scheduleStudentTable);

        waitlistStudentLabel.setText("Waitlisted Student in the Class in Waitlist Order");

        waitlistStudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "StudentID"
            }
        ));
        jScrollPane2.setViewportView(waitlistStudentTable);

        javax.swing.GroupLayout dispayClassListPanelLayout = new javax.swing.GroupLayout(dispayClassListPanel);
        dispayClassListPanel.setLayout(dispayClassListPanelLayout);
        dispayClassListPanelLayout.setHorizontalGroup(
            dispayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispayClassListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dispayClassListPanelLayout.createSequentialGroup()
                        .addComponent(chooseClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooseClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(studentScheduledClassDisplayButton))
                    .addComponent(waitlistStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scheduleStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dispayClassListPanelLayout.setVerticalGroup(
            dispayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dispayClassListPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dispayClassListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dispayClassListPanelLayout.createSequentialGroup()
                        .addComponent(studentScheduledClassDisplayButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dispayClassListPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chooseClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(chooseClassComboBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waitlistStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        adminTab.addTab("Display Class List", dispayClassListPanel);

        chooseStudentLabel.setText("Choose Student:");

        dropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        dropStudentSubmitButton.setText("Sumbit");
        dropStudentSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropStudentSubmitButtonActionPerformed(evt);
            }
        });

        dropStudentInfoTextArea.setColumns(20);
        dropStudentInfoTextArea.setRows(5);
        jScrollPane3.setViewportView(dropStudentInfoTextArea);

        javax.swing.GroupLayout dropStudentPanelLayout = new javax.swing.GroupLayout(dropStudentPanel);
        dropStudentPanel.setLayout(dropStudentPanelLayout);
        dropStudentPanelLayout.setHorizontalGroup(
            dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropStudentPanelLayout.createSequentialGroup()
                .addGroup(dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dropStudentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dropStudentPanelLayout.createSequentialGroup()
                                .addComponent(chooseStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dropStudentPanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(dropStudentSubmitButton)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        dropStudentPanelLayout.setVerticalGroup(
            dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropStudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropStudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooseStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dropStudentComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(dropStudentSubmitButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );

        adminTab.addTab("Drop Student", dropStudentPanel);

        adminChooseClassLabel.setText("Choose Class: ");

        adminDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        adminDropClassSubmitButton.setText("Submit");
        adminDropClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDropClassSubmitButtonActionPerformed(evt);
            }
        });

        adminDropClassInfoTextArea.setColumns(20);
        adminDropClassInfoTextArea.setRows(5);
        jScrollPane4.setViewportView(adminDropClassInfoTextArea);

        javax.swing.GroupLayout dropClassPanelLayout = new javax.swing.GroupLayout(dropClassPanel);
        dropClassPanel.setLayout(dropClassPanelLayout);
        dropClassPanelLayout.setHorizontalGroup(
            dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropClassPanelLayout.createSequentialGroup()
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(adminChooseClassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminDropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(adminDropClassSubmitButton)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        dropClassPanelLayout.setVerticalGroup(
            dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dropClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminChooseClassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminDropClassComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGroup(dropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(adminDropClassSubmitButton)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(dropClassPanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        adminTab.addTab("Drop Class", dropClassPanel);

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(adminTab)
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(adminTab, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        userPanel.addTab("Admin", adminPanel);

        displayCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course Code", "Description", "Seats"
            }
        ));
        displayClasses.setViewportView(displayCoursesTable);

        classDisplayButton.setText("Display");
        classDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDisplayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displayClassesPanelLayout = new javax.swing.GroupLayout(displayClassesPanel);
        displayClassesPanel.setLayout(displayClassesPanelLayout);
        displayClassesPanelLayout.setHorizontalGroup(
            displayClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassesPanelLayout.createSequentialGroup()
                .addGap(325, 325, 325)
                .addComponent(classDisplayButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(displayClassesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayClasses, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
        );
        displayClassesPanelLayout.setVerticalGroup(
            displayClassesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayClassesPanelLayout.createSequentialGroup()
                .addComponent(displayClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classDisplayButton)
                .addGap(0, 99, Short.MAX_VALUE))
        );

        studentTab.addTab("Display Classes", displayClassesPanel);

        displayScheduleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Code", "Status"
            }
        ));
        displaySchedule.setViewportView(displayScheduleTable);

        scheduleDisplayButton.setText("Display");
        scheduleDisplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleDisplayButtonActionPerformed(evt);
            }
        });

        selectStudentLabel.setText("Select Student:");

        studentScheduleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentScheduleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentScheduleComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout displaySchedulePanelLayout = new javax.swing.GroupLayout(displaySchedulePanel);
        displaySchedulePanel.setLayout(displaySchedulePanelLayout);
        displaySchedulePanelLayout.setHorizontalGroup(
            displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displaySchedule, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                        .addComponent(selectStudentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentScheduleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(scheduleDisplayButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displaySchedulePanelLayout.setVerticalGroup(
            displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displaySchedulePanelLayout.createSequentialGroup()
                .addGroup(displaySchedulePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(selectStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentScheduleComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displaySchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleDisplayButton)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        studentTab.addTab("Display Schedule", displaySchedulePanel);

        selectClassTextField.setText("Select Class:");

        jLabel1.setText("Select Student:");

        selectClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectClassComboBoxActionPerformed(evt);
            }
        });

        selectStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        scheduleClassSubmitButton.setText("Submit");
        scheduleClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleClassSubmitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scheduleClassPanelLayout = new javax.swing.GroupLayout(scheduleClassPanel);
        scheduleClassPanel.setLayout(scheduleClassPanelLayout);
        scheduleClassPanelLayout.setHorizontalGroup(
            scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleClassPanelLayout.createSequentialGroup()
                .addGroup(scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scheduleClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(selectClassTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(scheduleClassPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(scheduleClassSubmitButton))
                    .addGroup(scheduleClassPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(scheduleClassStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(421, Short.MAX_VALUE))
        );
        scheduleClassPanelLayout.setVerticalGroup(
            scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scheduleClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(selectClassTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scheduleClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectStudentComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(scheduleClassSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scheduleClassStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        studentTab.addTab("Schedule Class", scheduleClassPanel);

        studentChooseStudentLabel.setText("Choose Student:");

        studentDropStudentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        studentDropStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropStudentComboBoxActionPerformed(evt);
            }
        });

        studentChooseClassLabel.setText("Choose Class:");

        studentDropClassComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        studentDropClassSubmitButton.setText("Submit");
        studentDropClassSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDropClassSubmitButtonActionPerformed(evt);
            }
        });

        studentDropClassInfoTextArea.setColumns(20);
        studentDropClassInfoTextArea.setRows(5);
        jScrollPane5.setViewportView(studentDropClassInfoTextArea);

        javax.swing.GroupLayout studentDropClassPanelLayout = new javax.swing.GroupLayout(studentDropClassPanel);
        studentDropClassPanel.setLayout(studentDropClassPanelLayout);
        studentDropClassPanelLayout.setHorizontalGroup(
            studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentDropClassPanelLayout.createSequentialGroup()
                .addGroup(studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(studentDropClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(studentChooseClassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentChooseStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentDropStudentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentDropClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentDropClassPanelLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(studentDropClassSubmitButton))
                    .addGroup(studentDropClassPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        studentDropClassPanelLayout.setVerticalGroup(
            studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentDropClassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentChooseStudentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentDropStudentComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(studentDropClassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentChooseClassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentDropClassComboBox, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(studentDropClassSubmitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        studentTab.addTab("Drop Class", studentDropClassPanel);

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addComponent(studentTab, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(studentTab)
        );

        userPanel.addTab("Student", studentPanel);

        currentSemesterText.setFont(new java.awt.Font("Comic Sans MS", 1, 16)); // NOI18N
        currentSemesterText.setText("Current Semester: ");

        currentSemesterLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        currentSemesterLabel.setText("           ");

        currentSemesterComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        currentSemesterComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentSemesterComboBoxActionPerformed(evt);
            }
        });

        changeSemesterButton.setText("Change Semester");
        changeSemesterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemesterButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseSchedulerTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(currentSemesterText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentSemesterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeSemesterButton)
                                .addGap(31, 31, 31)
                                .addComponent(aboutButton)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(courseSchedulerTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentSemesterText)
                    .addComponent(currentSemesterLabel)
                    .addComponent(currentSemesterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeSemesterButton)
                    .addComponent(aboutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // TODO add your handling code here:
        // display about information.
        JOptionPane.showMessageDialog(null, "Author: " + author + " Project Date: " + projectDate);
    }//GEN-LAST:event_aboutButtonActionPerformed

    private void addSemesterSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterSubmitButtonActionPerformed
        String semester = addSemesterTextfield.getText();
        SemesterQueries.addSemester(semester);
        
//        if(!semester.contains(addSemesterTextfield.getText())){
        addSemesterStatusLabel.setText("Semester " + semester + " has been added.");
        rebuildSemesterComboBoxes();
//        }
//        else
//        {
//             addSemesterStatusLabel.setText("Semester " + semester + " is already added.");
//        }
    }//GEN-LAST:event_addSemesterSubmitButtonActionPerformed

    private void addCourseCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseCodeTextFieldActionPerformed
        // TODO add your handling code here:
        //TextField - NO NEED FOR ACTION PERFORMED
    }//GEN-LAST:event_addCourseCodeTextFieldActionPerformed

    private void addCourseDescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseDescriptionTextFieldActionPerformed
        // TODO add your handling code here:
         //TextField - NO NEED FOR ACTION PERFORMED
    }//GEN-LAST:event_addCourseDescriptionTextFieldActionPerformed

    private void addCourseSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseSubmitButtonActionPerformed
        // TODO add your handling code here:
        String courseCode = addCourseCodeTextField.getText();
        String courseDescription = addCourseDescriptionTextField.getText();
        
        CourseEntry courseCodes = new CourseEntry(courseCode, courseDescription);
        CourseQueries.addCourse(courseCodes);
       
        addCourseStatusLabel.setText(courseCode + " has been added.");
        rebuildCourseComboBoxes();  
    }//GEN-LAST:event_addCourseSubmitButtonActionPerformed

    private void addClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassSubmitButtonActionPerformed
        // TODO add your handling code here:
        String semester = currentSemesterLabel.getText();
        String courseCode = (String)selectCourseCodeJComboBox.getSelectedItem();
        int seats = (int)editSeatsJSpinner.getValue();
        
        ClassEntry classes = new ClassEntry(semester, courseCode, seats);
        ClassQueries.addClass(classes);
        
        addClassStatusLabel.setText(courseCode + " has been added for " + semester);
        rebuildClassComboBoxes();    
    }//GEN-LAST:event_addClassSubmitButtonActionPerformed

    private void addStudentIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentIDTextFieldActionPerformed
        // TODO add your handling code here:
        //TextField - NO NEED FOR ACTION PERFORMED
    }//GEN-LAST:event_addStudentIDTextFieldActionPerformed

    private void addStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentSubmitButtonActionPerformed
        // TODO add your handling code here:
        String studentID = addStudentIDTextField.getText();
        String firstName = addFirstNameTextField.getText();
        String lastName = addLastNameTextField.getText();
        
        StudentEntry student = new StudentEntry(studentID, firstName, lastName);
        StudentQueries.addStudent(student);
        
        addStudentStatusLabel.setText( lastName + " ," + firstName + " has been added."); 
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_addStudentSubmitButtonActionPerformed

    private void addFirstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFirstNameTextFieldActionPerformed
        // TODO add your handling code here:
        //TextField - NO NEED FOR ACTION PERFORMED
    }//GEN-LAST:event_addFirstNameTextFieldActionPerformed

    private void changeSemesterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemesterButtonActionPerformed
        String semester = (String)currentSemesterComboBox.getSelectedItem();
        currentSemesterLabel.setText(semester);
        
        rebuildClassComboBoxes();
    }//GEN-LAST:event_changeSemesterButtonActionPerformed

    private void currentSemesterComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentSemesterComboBoxActionPerformed
        // TODO add your handling code here:
        // have a rebuild method no need action here
    }//GEN-LAST:event_currentSemesterComboBoxActionPerformed

    private void classDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDisplayButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<ClassDescription> classes = MultiTableQueries.getAllClassDescriptions(currentSemesterLabel.getText());
        DefaultTableModel displayCourseTableModel = (DefaultTableModel) displayCoursesTable.getModel();
        
        displayCourseTableModel.setNumRows(0);
        Object[] rowData = new Object [3];
           
        for(ClassDescription c: classes){
            rowData[0] = c.getCourseCode();
            rowData[1] = c.getDescription();
            rowData[2] = c.getSeats();
            displayCourseTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_classDisplayButtonActionPerformed

    private void selectClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectClassComboBoxActionPerformed
        // TODO add your handling code here:
        // have a rebuild method no need action here
    }//GEN-LAST:event_selectClassComboBoxActionPerformed

    private void scheduleDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleDisplayButtonActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String)studentScheduleComboBox.getSelectedItem();
        String[] parts = selectedItem.trim().split(" ");
        String studentID = parts[parts.length - 1]; 

        ArrayList<ScheduleEntry> schedule = ScheduleQueries.getScheduleByStudent(currentSemesterLabel.getText(), studentID);

        DefaultTableModel displayScheduleTableModel = (DefaultTableModel) displayScheduleTable.getModel();
        displayScheduleTableModel.setNumRows(0);
        Object[] rowData = new Object[2];

        for(ScheduleEntry s : schedule){
            rowData[0] = s.getCourseCode();
            rowData[1] = s.getStatus();
            displayScheduleTableModel.addRow(rowData);
        }
    }//GEN-LAST:event_scheduleDisplayButtonActionPerformed

    private void addSemesterTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSemesterTextfieldActionPerformed
        // TODO add your handling code here:
        //TextField - NO NEED FOR ACTION PERFORMED
    }//GEN-LAST:event_addSemesterTextfieldActionPerformed

    private void selectCourseCodeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCourseCodeJComboBoxActionPerformed
        // TODO add your handling code here:
        // have a rebuild method no need action here
    }//GEN-LAST:event_selectCourseCodeJComboBoxActionPerformed

    private void scheduleClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleClassSubmitButtonActionPerformed
        // TODO add your handling code here:
        String semester = (String)currentSemesterLabel.getText();
        String courseCode = (String)selectClassComboBox.getSelectedItem();
        String student = (String)selectStudentComboBox.getSelectedItem();
        String[] parts = student.trim().split(" ");
        String studentID = parts[parts.length - 1];
        String studentName = "";
        for(int i = 0; i < parts.length - 1; i++){
            studentName += parts[i];
            if(i < parts.length - 2){
                studentName += " ";
            }
        }
        
        int seats = ClassQueries.getClassSeats(semester,courseCode);
        int scheduleStudents = ScheduleQueries.getScheduledStudentCount(semester, courseCode);
  
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        String status;
        
        if(scheduleStudents < seats){
            status = "Scheduled";
            ScheduleEntry schedule = new ScheduleEntry(semester, courseCode, studentID, status, currentTimestamp);
            ScheduleQueries.addScheduleEntry(schedule);
        }
        else{
            status = "Waitlisted";
            ScheduleEntry schedule = new ScheduleEntry(semester, courseCode, studentID, status, currentTimestamp);
            ScheduleQueries.addScheduleEntry(schedule);
        }
        
        scheduleClassStatusTextField.setText(courseCode + " is " + status + " for " + studentName); 
    }//GEN-LAST:event_scheduleClassSubmitButtonActionPerformed

    private void studentScheduleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentScheduleComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentScheduleComboBoxActionPerformed

    private void studentDropStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropStudentComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentDropStudentComboBoxActionPerformed

    private void studentDropClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDropClassSubmitButtonActionPerformed
//         TODO add your handling code here:
        String student = (String)studentDropStudentComboBox.getSelectedItem();
        String[] parts = student.trim().split(" ");
        String studentID = parts[parts.length - 1];
        String className = (String)studentDropClassComboBox.getSelectedItem();
        StudentEntry scheduleStudent = StudentQueries.getStudent(studentID);
     
        String message = scheduleStudent.getLastName() + ", " + scheduleStudent.getFirstName() + " " + scheduleStudent.getStudentID() +" has been dropped from " + className + "\n";
        ScheduleQueries.dropStudentScheduleByCourse(currentSemester, className, studentID);

        ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudentsByClass(currentSemester, className);
        if(!waitlisted.isEmpty()){
            ScheduleEntry nextStudent = waitlisted.get(0);
            ScheduleEntry updatedEntry = new ScheduleEntry(
                nextStudent.getSemester(),
                nextStudent.getCourseCode(),
                nextStudent.getStudentID(),
                "Scheduled",
                new java.sql.Timestamp(Calendar.getInstance().getTime().getTime())
            );

            ScheduleQueries.updateScheduleEntry(updatedEntry);
            StudentEntry schedulingStudent = StudentQueries.getStudent(nextStudent.getStudentID());
            message += schedulingStudent.getLastName() + ", " + schedulingStudent.getFirstName() + " " + schedulingStudent.getStudentID() + " has been scheduled into " + className + "\n";  
        }
        studentDropClassInfoTextArea.setText(message);
        rebuildStudentComboBoxes();
        rebuildClassComboBoxes();
    }//GEN-LAST:event_studentDropClassSubmitButtonActionPerformed

    private void studentScheduledClassDisplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentScheduledClassDisplayButtonActionPerformed
        // TODO add your handling code here:
        String semester = currentSemesterLabel.getText();
        String selectedClass = (String) chooseClassComboBox.getSelectedItem();

        ArrayList<StudentEntry> scheduled = MultiTableQueries.getScheduledStudentsByClass(semester, selectedClass);
        DefaultTableModel scheduledModel = (DefaultTableModel) scheduleStudentTable.getModel();
        
        scheduledModel.setNumRows(0);
        Object[] scheduledData = new Object[3];
        for(StudentEntry s : scheduled){
            scheduledData[0] = s.getLastName();
            scheduledData[1] = s.getFirstName();
            scheduledData[2] = s.getStudentID();
            scheduledModel.addRow(scheduledData);
        }

        ArrayList<StudentEntry> waitlisted = MultiTableQueries.getWaitlistedStudentsByClass(semester, selectedClass);
        DefaultTableModel waitlistModel = (DefaultTableModel) waitlistStudentTable.getModel();
        
        waitlistModel.setNumRows(0);
        Object[] waitlistData = new Object[3];
        for(StudentEntry s : waitlisted){
            waitlistData[0] = s.getLastName();
            waitlistData[1] = s.getFirstName();
            waitlistData[2] = s.getStudentID();
            waitlistModel.addRow(waitlistData);
        }
    }//GEN-LAST:event_studentScheduledClassDisplayButtonActionPerformed

    private void dropStudentSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropStudentSubmitButtonActionPerformed
        // TODO add your handling code here:         
        String student = (String) dropStudentComboBox.getSelectedItem();
        String[] parts = student.trim().split(" ");
        String studentID = parts[parts.length - 1];

        String message = student + " has been dropped from the list of students.\n\n";
        ArrayList<String> semesters = SemesterQueries.getSemesterList();

        for(String currentSemester : semesters){
            ArrayList<ScheduleEntry> studentSchedule = new ArrayList<>(ScheduleQueries.getScheduleByStudent(currentSemester, studentID));
            message += "For Semester: " + currentSemester + "\n";

            for(ScheduleEntry entry : studentSchedule){
                String courseCode = entry.getCourseCode();
          
                if(entry.getStatus().equals("Scheduled")){
                    message += student + " has been dropped from " + courseCode + "\n";
                } 
                else if(entry.getStatus().equals("Waitlisted")){
                    message += student + " has been dropped from the waitlist for " + courseCode + "\n";
                }
                
                ScheduleQueries.dropStudentScheduleByCourse(currentSemester, courseCode, studentID);
                
                if(entry.getStatus().equals("Scheduled")){
                    ArrayList<ScheduleEntry> waitlisted = ScheduleQueries.getWaitlistedStudentsByClass(currentSemester, courseCode);
                    if(!waitlisted.isEmpty()){
                        ScheduleEntry nextStudent = waitlisted.get(0);
                        
                        ScheduleEntry updatedEntry = new ScheduleEntry(
                            nextStudent.getSemester(),
                            nextStudent.getCourseCode(),
                            nextStudent.getStudentID(),
                            "Scheduled",
                            new java.sql.Timestamp(Calendar.getInstance().getTime().getTime())
                        );

                        ScheduleQueries.updateScheduleEntry(updatedEntry);
                        StudentEntry schedulingStudent = StudentQueries.getStudent(nextStudent.getStudentID());
                        message += schedulingStudent.getLastName() + ", " + schedulingStudent.getFirstName() + " " + schedulingStudent.getStudentID() + " has been scheduled into " + courseCode + "\n";
                    }
                }
            }
            message += "\n";
        }

        StudentQueries.dropStudent(studentID);
        dropStudentInfoTextArea.setText(message);
        rebuildStudentComboBoxes();
    }//GEN-LAST:event_dropStudentSubmitButtonActionPerformed

    private void adminDropClassSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDropClassSubmitButtonActionPerformed
        // TODO add your handling code here:
        String className = (String) adminDropClassComboBox.getSelectedItem();
        ArrayList<StudentEntry> scheduledStudents = MultiTableQueries.getScheduledStudentsByClass(currentSemesterLabel.getText(), className);
        ArrayList<StudentEntry> waitlistedStudents = MultiTableQueries.getWaitlistedStudentsByClass(currentSemesterLabel.getText(), className);
      
        ScheduleQueries.dropScheduleByCourse(currentSemesterLabel.getText(), className);

        String message = "Scheduled students dropped from the course:\n";
        for(StudentEntry student : scheduledStudents){
            message += student.getLastName() + ", " + student.getFirstName() + ", " + student.getStudentID() + "\n";
        }
        
        message += "\nWaitlisted students dropped from the course:\n";
        for(StudentEntry student : waitlistedStudents){
            message += student.getLastName() + ", " + student.getFirstName() + ", " + student.getStudentID() +"\n";
        }

        ClassQueries.dropClass(currentSemesterLabel.getText(), className);
        adminDropClassInfoTextArea.setText(message);
        rebuildClassComboBoxes();
    }//GEN-LAST:event_adminDropClassSubmitButtonActionPerformed

    private void checkData() {
        try {
            FileReader reader = new FileReader("xzq789y.txt");
            BufferedReader breader = new BufferedReader(reader);

            String encodedAuthor = breader.readLine();
            String encodedProject = breader.readLine();
            byte[] decodedAuthor = Base64.getDecoder().decode(encodedAuthor);
            author = new String(decodedAuthor);
            byte[] decodedProject = Base64.getDecoder().decode(encodedProject);
            projectDate = new String(decodedProject);
            reader.close();

        } catch (FileNotFoundException e) {
            //get user info and create file
            author = JOptionPane.showInputDialog("Enter your first and last name.");
            projectDate = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()).toString();

            //write data to the data file.
            try {
                FileWriter writer = new FileWriter("xzq789y.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);

                // encode the output data.
                String encodedAuthor = Base64.getEncoder().encodeToString(author.getBytes());

                bufferedWriter.write(encodedAuthor);
                bufferedWriter.newLine();

                String encodedProject = Base64.getEncoder().encodeToString(projectDate.getBytes());
                bufferedWriter.write(encodedProject);

                bufferedWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.exit(1);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutButton;
    private javax.swing.JPanel addClassPanel;
    private javax.swing.JLabel addClassStatusLabel;
    private javax.swing.JButton addClassSubmitButton;
    private javax.swing.JTextField addCourseCodeTextField;
    private javax.swing.JTextField addCourseDescriptionTextField;
    private javax.swing.JPanel addCoursePanel;
    private javax.swing.JLabel addCourseStatusLabel;
    private javax.swing.JButton addCourseSubmitButton;
    private javax.swing.JTextField addFirstNameTextField;
    private javax.swing.JTextField addLastNameTextField;
    private javax.swing.JLabel addSemesterLabel;
    private javax.swing.JLabel addSemesterStatusLabel;
    private javax.swing.JButton addSemesterSubmitButton;
    private javax.swing.JTextField addSemesterTextfield;
    private javax.swing.JTextField addStudentIDTextField;
    private javax.swing.JPanel addStudentPanel;
    private javax.swing.JLabel addStudentStatusLabel;
    private javax.swing.JButton addStudentSubmitButton;
    private javax.swing.JPanel addsemesterPanel;
    private javax.swing.JLabel adminChooseClassLabel;
    private javax.swing.JComboBox<String> adminDropClassComboBox;
    private javax.swing.JTextArea adminDropClassInfoTextArea;
    private javax.swing.JButton adminDropClassSubmitButton;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JTabbedPane adminTab;
    private javax.swing.JButton changeSemesterButton;
    private javax.swing.JComboBox<String> chooseClassComboBox;
    private javax.swing.JLabel chooseClassLabel;
    private javax.swing.JLabel chooseStudentLabel;
    private javax.swing.JButton classDisplayButton;
    private javax.swing.JLabel courseCodeLable;
    private javax.swing.JLabel courseCodelabel;
    private javax.swing.JLabel courseDescriptionLabel;
    private javax.swing.JLabel courseSchedulerTitle;
    private javax.swing.JComboBox<String> currentSemesterComboBox;
    private javax.swing.JLabel currentSemesterLabel;
    private javax.swing.JLabel currentSemesterText;
    private javax.swing.JPanel dispayClassListPanel;
    private javax.swing.JScrollPane displayClasses;
    private javax.swing.JPanel displayClassesPanel;
    private javax.swing.JTable displayCoursesTable;
    private javax.swing.JScrollPane displaySchedule;
    private javax.swing.JPanel displaySchedulePanel;
    private javax.swing.JTable displayScheduleTable;
    private javax.swing.JPanel dropClassPanel;
    private javax.swing.JComboBox<String> dropStudentComboBox;
    private javax.swing.JTextArea dropStudentInfoTextArea;
    private javax.swing.JPanel dropStudentPanel;
    private javax.swing.JButton dropStudentSubmitButton;
    private javax.swing.JSpinner editSeatsJSpinner;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JPanel scheduleClassPanel;
    private javax.swing.JLabel scheduleClassStatusTextField;
    private javax.swing.JButton scheduleClassSubmitButton;
    private javax.swing.JButton scheduleDisplayButton;
    private javax.swing.JLabel scheduleStudentLabel;
    private javax.swing.JTable scheduleStudentTable;
    private javax.swing.JLabel seatlebel;
    private javax.swing.JComboBox<String> selectClassComboBox;
    private javax.swing.JLabel selectClassTextField;
    private javax.swing.JComboBox<String> selectCourseCodeJComboBox;
    private javax.swing.JComboBox<String> selectStudentComboBox;
    private javax.swing.JLabel selectStudentLabel;
    private javax.swing.JLabel studentChooseClassLabel;
    private javax.swing.JLabel studentChooseStudentLabel;
    private javax.swing.JComboBox<String> studentDropClassComboBox;
    private javax.swing.JTextArea studentDropClassInfoTextArea;
    private javax.swing.JPanel studentDropClassPanel;
    private javax.swing.JButton studentDropClassSubmitButton;
    private javax.swing.JComboBox<String> studentDropStudentComboBox;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JComboBox<String> studentScheduleComboBox;
    private javax.swing.JButton studentScheduledClassDisplayButton;
    private javax.swing.JTabbedPane studentTab;
    private javax.swing.JTabbedPane userPanel;
    private javax.swing.JLabel waitlistStudentLabel;
    private javax.swing.JTable waitlistStudentTable;
    // End of variables declaration//GEN-END:variables
}

