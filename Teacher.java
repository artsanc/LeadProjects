import java.io.PrintWriter;

public class Teacher implements CSVPrintable{
    private String name;
    private int studentID;
    private int teacherID;
    private long longPhone;
    private int phone;
    
    
    public Teacher(String name, int studentID, int teacherID, long phone){
        this.name = name;
        this.studentID = studentID;
        this.teacherID = teacherID;
        longPhone = phone;   
    }
    
    public String getName(){
        return name;
    }
    
    public int getID(){
        return teacherID;
    }
    
    public int getPostfix(){
        //method to get postfix(last four digits of phone)
        String temp = String.valueOf(longPhone);
        int postfix = (int) Long.parseLong(temp.substring(6,10));
        return postfix;
    }
    
    
    public void csvPrintln(PrintWriter out){
        //this method parses entry in correct format
        StringBuilder sb = new StringBuilder();
        String nameWithoutComma = getName();
        nameWithoutComma = nameWithoutComma.replace(",", " ");
        sb.append(nameWithoutComma + "," + getID() + "," + getPostfix());
        sb.append("\n");

        out.write(sb.toString());
    }
}