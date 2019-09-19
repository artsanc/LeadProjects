import java.io.PrintWriter;
public class TA extends Student{
    
    public TA(String name,int studentID,int teacherID,long phone){
        super(name,studentID,teacherID,phone);
    }
    
    
    public int getID(){
        if(studentID > teacherID){
            return studentID;
        }
        else{
            return teacherID;
    }
    }
    
    
    public void csvPrintln(PrintWriter out){
        //this method parses entry in correct format
        StringBuilder sb = new StringBuilder();
         String nameWithoutComma = getName();
         nameWithoutComma = nameWithoutComma.replace(",", " ");//gets name without comma
         
         sb.append(nameWithoutComma+","+getID()+","+phone);
         sb.append("\n");
         out.write(sb.toString());//writes name to file
    }
}