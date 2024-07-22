import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class VulnerableCode {
    public static void main(String[] args) {
        try {
            // SQL Injection vulnerability
            String userId = args[0]; //abcd
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM users WHERE id = " + userId);

            // Command Injection vulnerability
            String fileName = args[1];
            Runtime.getRuntime().exec("ls " + fileName);

            // Insecure Deserialization
            File file = new File(args[2]);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Object obj = in.readObject();

            // Hardcoded credentials
            String hardcodedPassword = "supersecretpassword123";

            // Unvalidated Redirect
            String redirect = args[3];
            response.sendRedirect(redirect);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}