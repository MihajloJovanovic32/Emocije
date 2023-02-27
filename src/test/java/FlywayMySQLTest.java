import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.FlywayManager;
import org.etsntesla.it.spring.MySQLManagerBean;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlywayMySQLTest {
    public static Statement statement;
    protected static Flyway flyway;
    @BeforeAll
    static void baseInit() throws SQLException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanFactory.class);
        statement = ctx.getBean(MySQLManagerBean.class).getConnection().createStatement();
        flyway = ctx.getBean(FlywayManager.class).getFlyway();
    }

    static void showTable(){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM emocije;");
            while (resultSet.next()){
                System.out.println("###############################Id="+resultSet.getInt(1)+"#################################");
                System.out.println("    Vrsta_emocije="+resultSet.getString(2));
                System.out.println("    Poruka="+resultSet.getString(3));
            }
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
