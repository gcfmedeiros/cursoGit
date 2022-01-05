import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class HelloWorld {

	public static void main(String[] args) {
		String dburl = "jdbc:oracle:thin:@//localhost:1521/xe";
		
        try {
            Connection conn = DriverManager.getConnection(dburl, "system", "tovar01");
            System.out.println("Conexão bem sucedida!");
            
           
            
            String query = "INSERT INTO ARQUIVO (ID, NOME, F_INFO) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 4);
            pstmt.setString(2, "Teste pdf");
            FileInputStream fin = new FileInputStream("C:\\Users\\gcfle\\Downloads\\z9-PATRON_ANGELICA.pdf");
            pstmt.setBlob(3, fin);
            pstmt.execute();
            System.out.println("Arquivo inserido!");
            
            //Statement stmt = conn.createStatement();
            //String sql = "INSERT INTO ARQUIVO VALUES (3, 'Teste blob', file)";
            //stmt.executeUpdate(sql);
            
            conn.close();
            System.out.println("Conexão fechada!");
        } catch (SQLException | FileNotFoundException e) {
        	System.out.println("Ops, erro!");
            e.printStackTrace();
        }
    }
}