package application;

import controller.Administrator;
import controller.BackupDataUtils;
import controller.RestoreDataUtils;
import java.io.File;
import java.util.HashMap;
import model.HallManager;
import model.MapStaffAndStudent;
import staff_view.AdministratorForm;
import view.LoginForm;
import staff_view.MaintenanceSecretaryHomePage;

public class MVCProject {
    
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        
        //initialize staff
        new MapStaffAndStudent();
        new AdministratorForm();
        new Administrator();
        
        File file = new File("HallForCreateRoom.txt");                
        RestoreDataUtils.restoreHallInfor(file);
        
        //restore all hall
        //nen de vo luc new Admin Page
        Administrator.setListHall(RestoreDataUtils.restoreHallAll());

        //backup hall
        //nen de vo luc new Admin Page
        BackupDataUtils.backupHallAll(Administrator.getListHall());
        
        //restore
        File studentFile = new File("student.txt");
        File staffFile = new File("staff.txt");
        
        RestoreDataUtils.RestoreDataFromFile(studentFile, staffFile);
    }
    
}
