import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySQLTest4 extends FlywayMySQLTest{

    @BeforeAll
    static void init(){
        flyway.clean();
        flyway.baseline();
        flyway.migrate();
    }

    @Test
    void test(){
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
