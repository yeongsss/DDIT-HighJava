package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueTest {
/*
	Stack ==> 후입선출(LIFO)(나중들어간게 먼저나옴)의 자료구조
			**페이지 앞으로가기,뒤로가기 등
		
	Queue ==> 선입선출(FIFO)의 자료구조
			** 프린터
	
	Stack과 Queue는 LinkedList를 이용해서 사용할 수 있다.
			
*/
	public static void main(String[] args) {
	/*
		Stack의 명령
		1. 자료 입력 : push(입력할 값);
		2. 자료 출력 : pop()	==> 자료를 꺼내온 후 자료를 Stack에서 삭제한다.
					   peek()	==> 삭제없이 자료를 꺼내온다.(꺼내온 데이터를 확인하고 처리하고싶을때 사용)
	*/
//		Stack<String> stack = new Stack<String>();  --> java초기떄부터 만들어져 사용되옴
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 stack값: "+ stack);				//		현재 stack값: [강감찬, 변학도, 일지매, 홍길동]
//	 																==> 데이터 삽입순서의 반대로 나온다
		
		String data = stack.pop();
		System.out.println("꺼내온 값: "+ data);					//		꺼내온 값: 강감찬
		System.out.println("꺼내온 값: "+ stack.pop());				//		꺼내온 값: 변학도
		System.out.println("현재 stack값: "+ stack);				//		현재 stack값: [일지매, 홍길동]
		
		stack.push("성춘향");
		System.out.println("새로 추가 후 Stack값: "+ stack);		//		새로 추가 후 Stack값: [성춘향, 일지매, 홍길동]
		System.out.println("꺼내온 값: "+ stack.pop());				//		꺼내온 값: 성춘향
		System.out.println("현재 stack값: "+ stack);				//		현재 stack값: [일지매, 홍길동]
		
		System.out.println("삭제없이 꺼내온 값: "+ stack.peek());	//		삭제없이 꺼내온 값: 일지매
		System.out.println("현재 stack값: "+ stack);				//		현재 stack값: [일지매, 홍길동]
		System.out.println("=============================================================");
		System.out.println();
		
		/*
			Queue의 명령
			1. 자료 입력 : offer(입력값)
			2. 자료 출력 : poll() ==> 자료를 꺼내온 후 꺼내온 자료를 삭제한다.
						   peek() ==> 삭제없이 자료를 꺼내온다.
		*/
		
		LinkedList<String> queue = new LinkedList<String>();
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재 queue의 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : "+ temp);
		System.out.println("꺼내온 값 : "+ queue.poll());
		System.out.println("현재 queue의 값 : " + queue);
		
		queue.offer("성춘향");
		System.out.println("현재 queue의 값 : "+ queue);
		
		System.out.println("꺼내온 값 : "+ queue.poll());
		System.out.println("현재 queue의 값 : "+ queue);
		
		System.out.println("삭제없이 꺼내온 값 : "+ queue.peek());
		System.out.println("현재 queue의 값 : "+ queue);
		
		
		
	}
}








