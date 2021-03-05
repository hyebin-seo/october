package method;

import java.util.Scanner;

public class Exam_01 {
	
	public static void regi(Scanner sc, String[] name, int[] id, String[] dept, String[] ph) {
		int count = 0;
		boolean over = true;
		while(count<id.length) {
			System.out.print("학     번 입력 : ");
			id[count] = sc.nextInt();

			if(count == 0) {
				System.out.print("이     름 입력 : ");
				name[count] = sc.next();
				System.out.print("학     과 입력 : ");
				dept[count] = sc.next();
				System.out.print("전화번호 입력 : ");
				ph[count] = sc.next();
				System.out.println("----------------------");
				count++;
			} else {
				for(int j=(count-1); j>=0; j--) {
					if(id[count] == id[j]) {
						System.out.println("[동일한 학번입니다. 다시 입력하세요.]");
						over = false;
						break;
					}
					over = true;
				}
				if(over) {
					System.out.print("이     름 입력 : ");
					name[count] = sc.next();
					System.out.print("학     과 입력 : ");
					dept[count] = sc.next();
					System.out.print("전화번호 입력 : ");
					ph[count] = sc.next();
					System.out.println("----------------------");
					count++;
				}
						
			}
		}
	}
	
	public static void print(String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			System.out.println("학  번:" + id[i]);
			System.out.println("이  름:" + name[i]);
			System.out.println("학  과:" + dept[i]);
			System.out.println("연락처: " + ph[i]);
			System.out.println("----------------------");
		}
	}
	
	public static void search(int sid, String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			if(id[i] == sid) {
				System.out.println("학  번:" + id[i]);
				System.out.println("이  름:" + name[i]);
				System.out.println("학  과:" + dept[i]);
				System.out.println("연락처: " + ph[i]);
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				System.out.println("[일치하는 학번이 없습니다.]");
			}
		}
	}
	
	public static void modify(Scanner sc, int sid, String[] name, int[] id, String[] dept, String[] ph) {
		for(int i=0; i<id.length; i++) {
			if(id[i] == sid) {
				System.out.println("학     번 : " + id[i]);
				System.out.println("이     름 : " + name[i]);
				System.out.print("학     과 입력 : ");
				dept[i] = sc.next();
				System.out.print("전화번호 입력 : ");
				ph[i] = sc.next();
				System.out.println("----------------------");
				break;
			} else if(i == (id.length-1)){
				System.out.println("[일치하는 학번이 없습니다.]");
			}
		}
	}
	
	public static void end(Scanner sc) {
		System.exit(0);
		sc.close();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 수 입력 : ");

		int[] id = new int[sc.nextInt()];
		String[] name = new String[id.length];
		String[] dept = new String[id.length];
		String[] ph = new String[id.length];
		
		while(true) {
			System.out.println("**** 학생 관리 프로그램 ****");
			System.out.println("1.학생 등록");
			System.out.println("2.전체 출력");
			System.out.println("3.학생 조회");
			System.out.println("4.정보 수정");
			System.out.println("5.프로그램 종료");
			
			System.out.print("관리 번호를 입력하세요. : ");
			int num = sc.nextInt();
			System.out.println("----------------------");
			
			if(num > 5 || num < 0) {
				System.out.println("[잘못된 관리 번호 입니다. 다시 입력 하십시오.]");
			} else {
				switch (num) {
				case 1:
					System.out.println("[학생을 등록합니다.]");
					regi(sc, name, id, dept, ph);
					break;
					
				case 2:
					System.out.println("====== 전체 학생 출력 ======");
					print(name, id, dept, ph);
					break;
					
				case 3:
					System.out.println("[학생을 조회 합니다.]");
					System.out.print("학번을 입력하십시오. : ");
					search(sc.nextInt(), name, id, dept, ph);
					break;
					
				case 4:
					System.out.println("[학생 정보를 수정합니다.]");
					System.out.print("학번을 입력하십시오. : ");
					modify(sc, sc.nextInt(), name, id, dept, ph);
					break;
	
				default:
					System.out.println("[프로그램을 종료합니다.]");
					end(sc);
					break;
				}
			}
			
		}

		
	}

}
