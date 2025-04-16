import com.learning.Database;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.*;

public class DatabaseMock {

    private Connection mockConnection;
    private PreparedStatement mockInsertStatement;
    private PreparedStatement mockCountStatement;
    private ResultSet mockResultSet;

    public void setUpMocks() throws SQLException {
        mockConnection = mock(Connection.class);
        mockInsertStatement = mock(PreparedStatement.class);
        mockCountStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        // Mock für die statische Methode von Database.getConnection()
        try (MockedStatic<Database> dbMock = mockStatic(Database.class)) {
            dbMock.when(Database::getConnection).thenReturn(mockConnection);

            // Mock für das Insert Statement
            when(mockConnection.prepareStatement(startsWith("INSERT"))).thenReturn(mockInsertStatement);
            when(mockInsertStatement.executeUpdate()).thenReturn(1);

            // Mock für das COUNT Statement
            when(mockConnection.prepareStatement("SELECT COUNT(*) FROM")).thenReturn(mockCountStatement);
            when(mockCountStatement.executeQuery()).thenReturn(mockResultSet);
            when(mockResultSet.next()).thenReturn(true);
            when(mockResultSet.getInt(1)).thenReturn(1); // Zählwert 1 zurückgeben
        }
    }

    public Connection getMockConnection() {
        return mockConnection;
    }

    public PreparedStatement getMockInsertStatement() {
        return mockInsertStatement;
    }

    public PreparedStatement getMockCountStatement() {
        return mockCountStatement;
    }

    public ResultSet getMockResultSet() {
        return mockResultSet;
    }
}

