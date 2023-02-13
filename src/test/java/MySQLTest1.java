import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class MySQLTest1 extends BaseMySqlTest{
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
            statement.executeUpdate("INSERT INTO emocije VALUES(NULL,'Radost',\"AAAAAAAAAAAAAAAAAAAAAAAAAA\")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @AfterAll
    static void showResult() {
        showTable();
        emptyData();
    }
}
