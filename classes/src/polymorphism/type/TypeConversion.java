package polymorphism.type;

public class TypeConversion {

	public static void main(String[] args) {
		//기본 자료형의 타입 변환
		int iNum = 10;
		float fNum = iNum; // 자동형변환: 큰 자료형 = 작은 자료형
		
		System.out.println(iNum + "," + fNum); //10.0
		
		//강제 형변환(작은자료형 -> 큰자료형)
		double dNum = 2.54;
		iNum = (int)dNum;
		
		System.out.println(dNum + "," + iNum); //2
		
	}

}
