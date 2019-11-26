package original;

import java.util.HashMap;
import java.util.Map;

import lombok.SneakyThrows;
import original.PersonFinder.Person;

public class ObjectProvider {
	
	private static final Map<Class<?>, Object> objects = new HashMap<>();
	
	static {
		ObjectRegister.regist();
	}

	@SneakyThrows
	public static <T> T getObjectNewInstance(Class<T> clazz) {
		return clazz.newInstance();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getObject(Class<T> clazz) {
		return (T) objects.get(clazz);
	}
	
	public static <T> void registObject(Class<T> clazz, T t) {
		objects.put(clazz, t);
	}
	
	public static void main(String[] args) {
		Person p = ObjectProvider.getObject(Person.class);
		System.out.println(p);
	}
}
