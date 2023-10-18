
package studentportal;

import java.util.ArrayList;

/**
 *
 * @author AbuZar
 */
  // static ArrayList<Integer> arrlist= new ArrayList<>();


public class Login {
    static int total_students;
    private final int ADMIN_PASS=9999;
    
    final private int pass;
    Login(int pass)
    {
        this.pass=pass;
        total_students++;

    }
    
    Login()
    {
        this.pass=1234;
    }

    public int get_pass()
    {
        return this.pass;
        
    }
    public int get_Admin_pass()
    {
        return ADMIN_PASS;
        
    }
    
    public String toString()
    {
        return "Total Students : "+total_students;
        
    }
    
    public void remove_student()
    {
        total_students=total_students-1;
    }
    
    
    
    
}
