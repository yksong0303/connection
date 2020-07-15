

package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Execute {
	public static void main(String[] args) {
//		List<Person> pList = new ArrayList<>();
//		pList.add(new Person("동혁",22,90));
//		pList.add(new Person("덩혁",33,80));
//		pList.add(new Person("둥혁",20,74));
//		Collections.sort(pList);
//		System.out.println(pList);
		List<Integer> intList = new ArrayList<>();
		intList.add(5);
		intList.add(7);
		intList.add(9);
		intList.add(12);
		System.out.println(intList);
		Collections.sort(intList);
		System.out.println(intList);
		
		
	}

}
