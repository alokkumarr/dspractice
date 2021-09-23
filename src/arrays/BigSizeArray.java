package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigSizeArray {

	public static void main(String[] args) {
		int n = 500000;
		String[] select = new String[n];

		List<String> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(String.format("%s[%s]", "d", i));
		}

		System.out.println(list.size());

		//System.out.println(list.toArray());

		String[] data = (String[]) list.toArray();

		System.out.println(Arrays.toString(data));

/*
		for (int i = 0; i < n; i++) {
			select[i] = String.format("%s[%s]", "d", i);
		}
*/

//		System.out.println(Arrays.toString(select));
	}
}

