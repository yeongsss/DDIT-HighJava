package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashcodeTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");

		Person p2 = new Person();
//		p2.setId(2);
//		p2.setName("일지매");
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1 == p2);	
		System.out.println(p1 == p3);
		System.out.println(p1.equals(p2));
		System.out.println();
		
		System.out.println(p1);
		System.out.println(p2.toString());
		
		System.out.println("=================================================");
		
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set의 크기 : "+ testSet.size());		
		// hash코드로 객체 저장되기때문에 안에 데이터가 같아도 set에 담길때는 중복된것으로 보지 X
		
		System.out.println("p1 hashcode : "+ p1.hashCode());	// p1 hashcode : 366712642
		System.out.println("p2 hashcode : "+ p2.hashCode());	// p2 hashcode : 1829164700
		
		
		
	}
}

class Person {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person 데이터 : id=" + id + ", name=" + name ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
/*	
   @Override
	public boolean equals(Object obj) {
		if (obj==null) {
			return false;
		}
		
		if (this==obj) {
			return true;
		}
		
		// 같은 유형의 클래스인지 검사
		if (this.getClass() != obj.getClass()) {	
			return false;
		}
		
		// 매개변수의 값을 현재 객체유형으로 형변환한다.
		Person temp =(Person) obj;
		
		if (this.name==null && temp.name!=null) {
			return false;
		}
		
		if (this.id==temp.id && this.name==temp.name) {
			return true;
		}
		
		if (this.id == temp.id && this.name.equals(temp.name)) {
			return true;
		}
		
		return false;
		
	}
	
	@Override
	public int hashCode() {
		if (name!=null) {
			return ("" + id + name).hashCode();
		} else {
			return ("" + id).hashCode();
		}
		
}
 */
			
				
		
	
	
	
}

