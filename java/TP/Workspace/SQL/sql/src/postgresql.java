//CTRL + SHIFT + O pour générer les imports
//export CLASSPATH=$CLASSPATH:/home/aghiles/Programme/java/java_SQL/Pilote/postgresql.jar
//psql upec
//grant all privileges on database upec to aghiles;
//alter user aghiles with password 'aghilesDJ35B';
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;

public class postgresql {

  private static final String dbClassName = "org.postgresql.Driver";
  private static final String CONNECTION = "jdbc:postgresql://localhost/upec";


  public static void main(String[] args) throws ClassNotFoundException,SQLException {

    System.out.println(dbClassName);
    Class.forName(dbClassName);

    Properties p = new Properties();
    p.put("user","aghiles");
    p.put("password","aghilesDJ35");

    Connection c = DriverManager.getConnection(CONNECTION,p);

    System.out.println("It works !");
    c.close();
	}
}
