import java.util.Map;

public class GenericMapUtility {
	
	public static <K,V> void print(Map<K, V> map){
		for(K key : map.keySet()){
			System.out.println(key +"\t:\t"+ map.get(key));
		}
	}
	
	public static <K, V> void print(Map<K, V> map, String prompt){
		System.out.println(prompt);
		print(map);
	}
	
}
