/*
 * 파일생성시각: 5월 2일 11시 30분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 사람 클래스
 * 
 * <클래스 설명>
 * - 케릭터들의 최상위 클래스이다
 * 
 * <변수>
 * - 이름 : 캐릭터의 이름을 저장한다.
 * - 대사 : 캐릭터의 대사들을 저장한다.
 * 
 * <메소드>
 * - 대사를말한다 : 대사 변수에 저장된 대사를 말한다.
*/

package characters;

import java.util.ArrayList;

public class Person {
	
	//<변수>
	String name; // 이름
	ArrayList<String> dialogue = new ArrayList<String>(); // 대사
	
	//<생성자>
	public Person(String name) {
		this.name = name;
	}
	
	//<Getter,Setter>
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getDialogue() {
		return dialogue;
	}

	public void setDialogue(ArrayList<String> dialogue) {
		this.dialogue = dialogue;
	}
	
	
	//<메소드>
	//대사를말한다
	public void sayDialogue(int dialogueNum) {
		System.out.println(name + ": " + dialogue.get(dialogueNum)); // 예) 오박사: 안녕!
	}
	
	

	

}
