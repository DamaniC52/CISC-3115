
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Files_practice {
    public static void main(String[] args) throws FileNotFoundException {
        
    File file = new File("1.txt");
    
    if(file.exists()){

        System.out.println("File exists");
        System.exit(1);
    }

    PrintWriter out = new PrintWriter(file); 

    for(int i = 0; i<1000; i ++) {

        out.print((int)(Math.random()*100));
    }


    }
}
