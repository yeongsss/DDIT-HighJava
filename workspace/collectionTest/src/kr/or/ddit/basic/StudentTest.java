package kr.or.ddit.basic;
/*
	문제_) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다
			이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 설정해서 데이터를 초기화처리 한다.
			
			이 Student객체는 List에 저장하여 관리한다.
			
			List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
			총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를
			작성하여 정렬한 결과를 출력하시오.
			
			(등수는 List에 전체 데이터가 추가된 후에 구한다.)
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentTest {
	// 등수를 구하는 메소드
	public void setRanking(ArrayList<Student> stu){
		for (Student student : stu) { // 기준이 되는 데이터 개수만큼 반복
			int rank = 1;			// 등수가 저장될 변수(처음에는 1등으로 셋팅한다.)
			for (Student student2 : stu) {  // 비교 대상을 나타내는 반복문

				// 기준보다 큰 값을 만나면 등수를 증가시킨다.
				if (student.getTotal() < student2.getTotal()) {
					rank++;
				}
				
			}
			// 구해진 등수를 Student객체의 rank변수에 저장한다.
			student.setRank(rank);	
		}
	}
	
	
	public static void main(String[] args) {
		StudentTest studentTest = new StudentTest();
		
		ArrayList<Student> stu = new ArrayList<Student>();
		
		stu.add(new Student(1, "홍길동", 90, 95, 80));
		stu.add(new Student(3, "성춘향", 90, 75, 70));
		stu.add(new Student(7, "강감찬", 95, 95, 80));
		stu.add(new Student(5, "변학도", 80, 95, 90));
		stu.add(new Student(2, "일지매", 100, 85, 80));
		stu.add(new Student(4, "이순신", 60, 65, 70));
		stu.add(new Student(6, "이몽룡", 90, 100, 90));
		
		// 등수를 구하는 메소드를 호출하여 등수를 구한다.
		studentTest.setRanking(stu);
		
		System.out.println("정렬전");
		System.out.println();
		for (Student student : stu) {
			System.out.println(student);
		}
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("학번의 오름차순으로 정렬"); // 내부정렬기준을 이용하여 정렬
		System.out.println();
		
		Collections.sort(stu);
		for (Student student : stu) {
			System.out.println(student);
		}
		
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("총점의 역순(내림차순)으로 정렬");
		System.out.println();
		
		Collections.sort(stu, new totalScore());
		for (Student student : stu) {
			
			System.out.println(student);
		}
		
	}
}

class Student implements Comparable<Student>{
	private int studentNum;
	private String name;
	private int korea;
	private int english;
	private int math;
	private int total;
	private int rank;
	
	public Student(int studentNum, String name, int korea, int english, int math) {
		this.studentNum = studentNum;
		this.name = name;
		this.korea = korea;
		this.english = english;
		this.math = math;
		this.total= korea+english+math;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorea() {
		return korea;
	}

	public void setKorea(int korea) {
		this.korea = korea;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	
	@Override
	public String toString() {
		return "학번=" + studentNum + ", 이름=" + name + ", 국어=" + korea + ", 영어=" + english
				+ ", 수학=" + math + ", 총점=" + total + ", 등수=" + rank + "]";
	}

//	[학번의 오름차순으로 정렬]
//	@Override
//	public int compareTo(Student nm) {
//		if (this.studentNum > nm.getStudentNum()) {
//			return 1;					
//		} else if (this.studentNum < nm.getStudentNum()) {
//			return -1;
//		} else {
//			return 0;
//		}
//	}
//	
	@Override
	public int compareTo(Student st) {
		return Integer.compare(this.getStudentNum(), st.getStudentNum());
	}
	
	
}

// 총점의 역순(내림차순)으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 
// 외부 정렬 기준 클래스

class totalScore implements Comparator<Student>{

//	@Override
//	public int compare(Student total1, Student total2) {
//		if (total1.getTotal() > total2.getTotal() ) {
//			return -1;
//		} else if (total1.getTotal() < total2.getTotal()) {
//			return 1;
//		} else {
//			return total1.compareTo(total2)*-1;
//		}
//		 
//	}
	
	@Override
	public int compare(Student std1, Student std2) {
		if (std1.getTotal() == std2.getTotal()) {
			return std1.getName().compareTo(std2.getName());
		} else {
			return Integer.compare(std1.getTotal(), std2.getTotal()) *-1;
		}
	}
	
	
}





