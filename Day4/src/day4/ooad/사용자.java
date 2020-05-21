package day4.ooad;

public class 사용자 {
	public static void main(String[] args) {
		백열등 b = new 백열등();
//		스탠드 s1 = new 스탠드(b);
		스탠드 s1 = new 스탠드();
		s1.Install(b);
		s1.On();
		s1.Off();
		
		형광등 b2 = new 형광등();
		s1.Install(b2);
		
		s1.On();
		s1.Off();
		
		전구 b3 = new LED전구();
		s1.Install(b3);
		s1.On();
		s1.Off();
	}
}
