package original;

import java.sql.Connection;
import java.sql.DriverManager;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class ConnectionProvider {

	private final String dirverClass;
	private final String url;
	private final String username;
	private final String password;
	
	@SneakyThrows
	private Connection getConnection() {
		Class.forName(this.dirverClass);
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		return conn;
	}
}
