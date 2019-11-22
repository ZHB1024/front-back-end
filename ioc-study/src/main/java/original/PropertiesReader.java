package original;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Properties;

import lombok.SneakyThrows;
import original.PersonFinder.Person;

public class PropertiesReader {

	private final Properties properties = new Properties();

	@SneakyThrows
	public PropertiesReader() {
		this.properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream("application.properties"));
	}
	
	@SneakyThrows
	public <T> T read(Class<T> clazz, String prefix) {
		T ret = clazz.newInstance();
		PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if ("class".equals(pd.getName())) {
				continue;
			}
			pd.getWriteMethod().invoke(ret, this.properties.getProperty(prefix + "." + pd.getName()));
		}
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(Person.class.getName());
		Person p = new PropertiesReader().read(Person.class, "person");
		System.out.println(p);
	}
}
