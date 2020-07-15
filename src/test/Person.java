package test;

public class Person implements Comparable<Person>{

	public String name;
	public int age;
	public int point;
	
	public Person(String name, int age, int point) {
		super();
		this.name = name;
		this.age = age;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if(point<o.point) return -1;
		if(point>o.point) return 1;
		return 0;
	}

}
