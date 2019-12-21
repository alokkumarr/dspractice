package map;

import java.util.HashMap;
import java.util.Map;

public class MapReadWrite {
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(1, 9);
		map.put(4, 29);
		map.put(6, 91);
		map.put(8, 999);

		System.out.println(map.get(4));


	}
}
