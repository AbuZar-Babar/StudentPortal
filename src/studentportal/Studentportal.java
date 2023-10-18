package studentportal;
import java.util.*;
import javax.swing.JOptionPane;
/**
 * @author AbuZar
 */


public class Studentportal {
    
 //      static Scanner input =new Scanner(System.in);

    public static void main(String[] args) {
        
       //======================ARRAY LIST OF STUDENT OBJECTS=====================================//
        
       ArrayList<Student> stdarr=new ArrayList<>();
       
       ArrayList<Login> login=new ArrayList<>();
       
       Student s1=new Student("abuzar","fa22-bse-133",3.6);
       Login l1=new Login(4444);
       
       
       Student s2=new Student("mohib","fa22-bse-125",4.0);
       Login l2=new Login(5555);
       
       
       Student s3=new Student("asim","fa22-bse-111",3.5);
       Login l3=new Login(1111);
       

       
       //===========================ADDING OBJECTS TO ARRAY======================================
       stdarr.add(s1);
       login.add(l1);
       
       stdarr.add(s2);
       login.add(l2);
       
       stdarr.add(s3);
       login.add(l3);
       
       //===========================STRING OF OPTIONS============================================
       String[] login_options={"Login as Student","Login as Admin","exit"};
       
       //=============================LOOP FOR SELECTING OPTIONS=================================
       while(true)
       {
          int choice = JOptionPane.showOptionDialog(null, "Enter Options",
          "Student Portal", 0, 1, null, login_options, null);
       switch(choice)
       {
           case 0 -> student_portal(stdarr,login);
              
           case 1 -> admin_portal(stdarr,login);    
           
           case 2->  System.exit(0);
       }      
       }
               
    }
    /*===================================================================================================
    ===========================           METHODS FOR STUDENT PORTAL          ===========================
    =====================================================================================================*/
    
    //-----------------------------------------------------METHOD FOR ENTRING STUDENT NAME
    static void student_portal(ArrayList<Student> arr,ArrayList<Login> login)
    {
    String name=JOptionPane.showInputDialog("Enter Name");
    name=name.toUpperCase();
    Check_name(name,arr,login);  
}
    
    
    //------------------------------------------------------------------METHOD FOR CHECKING THE NAME IN
    
    
    static void Check_name(String name,ArrayList<Student> arr,ArrayList<Login> login)     //   THE ARRAY LISY
    {   int counter=0;
        for(int i=0;i<arr.size();i++)
        {
            if(name.equals(arr.get(i).getName()))
            {
                counter++;   
                
                check_pass(i,arr,login);
                break;     
            }
        } 
        if(counter==0)
        {
            JOptionPane.showMessageDialog(null, "Name Not Found");
        }     
    }
    
    
    
    
    //--------------------------------------------------------------------------METHOD FOR CHECKING THE PASSOWRD IF
    //                                                                          NAME IS CORRECT
    static void check_pass(int i,ArrayList<Student>arr,ArrayList<Login> login)
    {
        int pass=Integer.parseInt(JOptionPane.showInputDialog("Enter Your 4 Digit Password"));
        if(pass==login.get(i).get_pass())
        {
            JOptionPane.showMessageDialog(null, "Gpa is :"+arr.get(i).getGpa());       
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong Password");
        }
    }
    
    
    
    /*===================================================================================================
    ===========================           METHODS FOR ADMIN PORTAL          =============================
    =====================================================================================================*/
    
    
    //----------------------------------------METHOD FOR CHECKING THE ADMIN PASS
    //                                          AND RETURNING TRUE IF CORRECT
    static boolean admin_pass(ArrayList<Login> login)
    {
       
       
       int pass=Integer.parseInt(JOptionPane.showInputDialog("Enter 4 Digit Admin Login Pass"));  
            
       if(pass==login.get(0).get_Admin_pass());
       {
           return true;
       }
       
   }
    
   //------------------------------------------------IF PASS IS CORRECT OPTIONS FOR ADMIN 
    static void admin_portal(ArrayList<Student> arr,ArrayList<Login> login)
    {
       
    
    
        if(admin_pass(login)==true)
       {
           int admin_choices=0;
           
           while(admin_choices!=4)
           {
               
           
          
           String[] opt={"Add Student",
                        "Remove Student",
                        "Show Student info",
                        "change Student info",
                        "Back"};
           
             admin_choices=JOptionPane.showOptionDialog(null,
                    "Enter option", "Admin Portal",
                   0, 0, null, opt, opt[3]);
           
            switch(admin_choices)
            {
                //=======================================ADD STUDENT=============================
                case 0:
                {
                    String name=JOptionPane.showInputDialog("Enter name");
                    String roll=JOptionPane.showInputDialog("Enter roll no");
                    double gpa=Double.parseDouble(JOptionPane.showInputDialog("Enter Gpa"));
                    int pass=Integer.parseInt(JOptionPane.showInputDialog("Enter Pass of Student"));
                    
                    Student Std_info_temp=new Student(name,roll,gpa);
                    
                    arr.add(Std_info_temp);
                    
                    Login Std_pass_temp=new Login(pass);
                    
                    login.add(Std_pass_temp);
                                      
                    break;           
                }  
                //============================================REMOVE STUDENT=======================
                case 1:
                {
                    String roll=JOptionPane.showInputDialog("Enter  roll no of Student to remove");
                    int count=0;
                    
                    for(int i=0;i<arr.size();i++)
                    {
                        if(roll.equals(arr.get(i).RollNo))
                        {
                            arr.remove(i);
                            login.get(i).remove_student();
                            login.remove(i);
                            count++;
                            break;
                        }   
                    }
                    if(count==0)
                    {
                        JOptionPane.showMessageDialog(null, "Roll No Not Found");
                    }
                    break;
                }  
                
                //=====================================SHOW STUDENT INFO========================== 
                case 2:
                {
                    
                    
                  String roll=JOptionPane.showInputDialog(login.get(0).toString()+"\nEnter roll no of Student");
                    int count=0;
                    for(int i=0;i<arr.size();i++)
                    {
                        if(roll.equals(arr.get(i).RollNo))
                        {
                            System.out.println("...");
                            JOptionPane.showMessageDialog(null,arr.get(i).toString());
                            count++;
                            break;
                        }   
                    }
                    if(count==0)
                    {
                        JOptionPane.showMessageDialog(null, "Roll No Not Found");
                        break;
                    }  
                   break; 
                }
                //======================================CHANGE STUDENT INFO==================================
                case 3:
                {
                    
           String roll=JOptionPane.showInputDialog("Enter the Full Roll No of Student");
         
           int counter=0;
           for(int i=0;i<arr.size();i++)
           {    
               if(roll.equals(arr.get(i).RollNo))
               {
                   counter++;
                   String[] admin_option={"Change Student Name",
                                          "Change Student GPA"};
                   
                  int choice = JOptionPane.showOptionDialog(null, 
                  "Enter Options", "Student Portal", 0,
                  1, null, admin_option, null);
                   
                   switch(choice)
                   {
                       case 0:
                       {
                           
                           String name=JOptionPane.showInputDialog("Enter the New Name:");
                           Student temp1=new Student(name,arr.get(i).RollNo,arr.get(i).getGpa());
                           arr.set(i, temp1);
                           JOptionPane.showMessageDialog(null, "New name is "+arr.get(i).name);
                           break;
                       }   
                       case 1:
                       {
                           double gpa=Double.parseDouble(JOptionPane.showInputDialog("Enter the New GPA:"));

                           Student temp2=new Student(arr.get(i).name,arr.get(i).RollNo,gpa);
                           arr.set(i, temp2);
                          
                           JOptionPane.showMessageDialog(null, "New Gpa is "+arr.get(i).getGpa());
                           break;
                       }   
                       default :                          
                           JOptionPane.showMessageDialog(null, "Invalid input");
                   }
               }
           }
           if(counter==0)
           {
               JOptionPane.showMessageDialog(null, "Roll No Not Found");
           }
            }
                //======================================BACK======================================
                case 4:
                {
                    break;
                }
                
            }                  
   }
       }
       else
           JOptionPane.showMessageDialog(null, "Invalid Pass");                       
       
    }
       
   
}
