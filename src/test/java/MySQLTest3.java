import org.etsntesla.it.spring.BeanFactory;
import org.etsntesla.it.spring.MySQLManagerBean;
import org.junit.jupiter.api.AfterAll;
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
        setDataDumpMySqlFile("V01.002__emocije_data_data.sql");
        setEmptyDumpMySqlFile("V01.001__emocije_empty_data.sql");
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

    @AfterAll
    static void showResult(){
        showTable();
    }
}