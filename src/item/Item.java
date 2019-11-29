/*
 * 파일생성시각: 5월 3일 21시 33분
 * 수정시각:
 * 수정내용:
 * 
 * <클래스 이름>
 * 아이템 클래스
 * 
 * <클래스 설명>
 * - 아이템들의 상위클래스이다
 * 
 * <변수>
 * - 이름: 아이템의 이름을 저장하는 변수
 * - 가격: 아이템의 가격을 저장하는 변수
 * 
 * <메소드>
 * - 사용되다
*/

package item;

public class Item {
	
	//<변수>
	String name; //이름
	int price; //가격
	
	//<생성자>
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	//<Getter,Setter>
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//<메소드>
	//사용되다
	public void used() {
		System.out.println(this.name + "을 사용합니다!");
	}

}
