
package studentportal;

/**
 *
 * @author AbuZar
 */

public class Student {
   String name;
   String RollNo;
   private Double Gpa;
   
    Student(String name,String rollNo,Double gpa)
    {
        this.RollNo=rollNo;
        this.name=name;
        this.Gpa=gpa;       
    }
    Student()
        {
        }
    
    public String toString()
    {
        return "Name: "+this.name+"\nRoll No "+this.RollNo+"\nGPA:"+this.getGpa();
        
    }

    public Double getGpa() {
        return Gpa;
    }

    public void setGpa(Double Gpa) {
        this.Gpa = Gpa;
    }
 
    public String getName() {
        return this.name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.RollNo = RollNo;
    }
    
}
