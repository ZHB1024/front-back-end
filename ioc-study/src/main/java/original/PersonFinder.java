package original;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class PersonFinder {

	private final String dirverClass;
	private final String url;
	private final String username;
	private final String password;
	
	@SneakyThrows
	public List<Person> findAll() {
		Class.forName(this.dirverClass);
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		PreparedStatement ps = conn.prepareStatement("select * from t_person");
		ResultSet rs = ps.executeQuery();
		List<Person> ret = new ArrayList<>();
		while (rs.next()) {
			Person p = new Person();
			p.setName(rs.getString(""));
			p.setAddress(rs.getString(""));
			ret.add(p);
		}
		ps.close();
		conn.close();
		return ret;
	}
	
	@SneakyThrows
	private Connection getConnection() {
		Class.forName(this.dirverClass);
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		return conn;
	}
	
	public static @Data class Person {
		private String name;
		private String address;
	}
}
