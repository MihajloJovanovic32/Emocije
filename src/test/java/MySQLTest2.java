import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySQLTest2 extends BaseMySqlTest {
    @BeforeAll
    static void init1() {
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
