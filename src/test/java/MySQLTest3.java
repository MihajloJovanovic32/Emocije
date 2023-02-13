import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.MySQLManagerBean;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MySQLTest3 extends BaseMySqlTest {

    static ApplicationContext ctx;
    @BeforeAll
    static void init1() throws SQLException {
        ctx = new AnnotationConfigApplicationContext(BeanFactory.class);
        statement = ctx.getBean(MySQLManagerBean.class).getConnection().createStatement();
        setDataDumpMySqlFile("emocije_data_data.sql");
        setEmptyDumpMySqlFile("emocije_empty_data.sql");
        emptyData();
        fillData();
    }
    @Test
    void test() {
        try {
            statement.executeUpdate("DELETE FROM emocije WHERE ID=3");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}