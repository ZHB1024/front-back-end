package original;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

public class ObjectRegister {

	@SuppressWarnings("unchecked")
	public static void regist() {
		PropertiesReader reader = new PropertiesReader();
		reader.read(ObjectsDefine.class, "objects").objectDefines()
			.stream()
			.forEach(define -> ObjectProvider.registObject(define.clazz, reader.read(define.clazz, define.prefix)));
	}
	
	public static @Data class ObjectsDefine {
		
		private String prefixes;
		private String classes;
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@SneakyThrows
		public List<ObjectDefine> objectDefines() {
			String[] pres = this.prefixes.split(",");
			String[] claes = this.classes.split(",");
			List<ObjectDefine> ret = new ArrayList<>(pres.length);
			for (int i = 0; i < pres.length; i++) {
				ret.add(new ObjectDefine(pres[i], Class.forName(claes[i])));
			}
			return ret;
		}
	}
	
	@AllArgsConstructor
	public static @Data class ObjectDefine<T> {
		private String prefix;
		private Class<T> clazz;
	}
}
