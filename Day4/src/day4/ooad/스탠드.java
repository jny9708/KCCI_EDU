package day4.ooad;

public class 스탠드 {
	
	private 전구 b;
//	private 백열등 b;
	
//	public 스탠드(백열등 b) {
//		this.b = b;
//	}
	
	public void Install(전구 b) {
		this.b = b;
	}

	public void On() {
		if(b != null) b.LightOn();

		else System.out.println("먼저 전구를 설치하세요");
	}
	
	public void Off() {
		b.LightOff();
	}
}
