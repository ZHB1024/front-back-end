package original;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SingletonConnectionProvider {

	private final String dirverClass;
	private final String url;
	private final String username;
	private final String password;
	
	private static SingletonConnectionProvider INSTANCE = null; // new SingletonConnectionProvider("", "", "", "");
	
	public static SingletonConnectionProvider instance1() {
		return INSTANCE;
	}
	
	public static SingletonConnectionProvider instance() {
		if (Objects.isNull(INSTANCE)) {
			INSTANCE = new SingletonConnectionProvider("", "", "", "");
		}
		return INSTANCE;
	}
	
	public synchronized static SingletonConnectionProvider instanceSync() {
		if (Objects.isNull(INSTANCE)) {
			INSTANCE = new SingletonConnectionProvider("", "", "", "");
		}
		return INSTANCE;
	}
	
	public static SingletonConnectionProvider instanceCl() {
		if (Objects.isNull(INSTANCE)) {
			synchronized (SingletonConnectionProvider.class) {
				INSTANCE = new SingletonConnectionProvider("", "", "", "");
			}
		}
		return INSTANCE;
	}
	
	public static SingletonConnectionProvider instanceDcl() {
		if (Objects.isNull(INSTANCE)) {
			synchronized (SingletonConnectionProvider.class) {
				if (Objects.isNull(INSTANCE)) {
					INSTANCE = new SingletonConnectionProvider("", "", "", "");
				}
			}
		}
		return INSTANCE;
	}
	
	@SneakyThrows
	private Connection getConnection() {
		Class.forName(this.dirverClass);
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		return conn;
	}
}
