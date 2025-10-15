import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A collection of intentionally vulnerable example methods.
 * These are small, self-contained snippets that demonstrate common
 * weaknesses CodeQL is designed to find: SQL injection, command injection,
 * insecure deserialization, and path traversal.
 */
public class VulnerableExamples {

    // 1) SQL Injection: building a query with unsanitized user input.
    public static ResultSet vulnerableSqlQuery(Connection conn, String username) {
        try {
            Statement stmt = conn.createStatement();
            // Vulnerable: concatenating user input directly into SQL
            String query = "SELECT * FROM users WHERE username = '" + username + "'";
            return stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 2) Command Injection: passing unsanitized input into Runtime.exec
    public static Process runUserCommand(String userArg) {
        try {
            // Vulnerable: attacker-controlled userArg is appended to the command
            String cmd = "sh -c 'ls " + userArg + "'"; // unix-style example
            return Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "ls " + userArg});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3) Insecure deserialization: deserializing untrusted data
    public static Object insecureDeserialize(byte[] serialized) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serialized);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            // Vulnerable: reading objects from untrusted input can lead to remote code execution
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 4) Path Traversal: using user-supplied filename to access filesystem
    public static byte[] readUploadedFile(String filename) {
        try {
            // Vulnerable: concatenating the filename allows '../' sequences to escape the intended directory
            File f = new File("uploads/" + filename);
            try (FileInputStream fis = new FileInputStream(f)) {
                byte[] buf = new byte[(int) f.length()];
                fis.read(buf);
                return buf;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Small main to keep the class usable for quick compilation checks.
    public static void main(String[] args) {
        // ...existing code...
        System.out.println("VulnerableExamples compiled. Do not run these methods with untrusted input.");
    }
}
