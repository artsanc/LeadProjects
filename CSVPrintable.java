import java.io.*;

public interface CSVPrintable{
    
    String getName();
    int getID();
    void csvPrintln(PrintWriter out);
}
    