package day4.ooad;

public class LED전구 implements 전구 {

	@Override
	public void LightOn() {
		System.out.println("led등이 밝게 쳐집니다.");
	}

	@Override
	public void LightOff() {
		System.out.println("led등이 꺼집니다.");
	}

}
