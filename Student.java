import java.io.PrintWriter;

public class Student implements CSVPrintable{
    private String name;
    protected int studentID;
    protected int teacherID;
    protected long phone;
    
    public Student(String name, int studentID, int teacherID, long phone){
        this.name = name;
        this.studentID = studentID;
        this.teacherID = teacherID;
        this.phone = phone;   
    }
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return studentID;
    }
    
    public void csvPrintln(PrintWriter out){
        //this method parses entry in correct format
        
         StringBuilder sb = new StringBuilder();
         String nameWithoutComma = getName();
         nameWithoutComma = nameWithoutComma.replace(",", " ");
         sb.append(nameWithoutComma+","+getID()+","+phone);
         sb.append("\n");
         
         out.write(sb.toString());
        
    }
    
    
    
}