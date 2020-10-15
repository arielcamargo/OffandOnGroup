public class Car 
{
	private int time;
	private static final int carPayment = 1000;
	private static final int maintenance = 500;
	private static final int parkingPass = 178;
	private static final int fastMPH = 60;
	private static final int slowMPH = 20;
	private int money;
	private int distance;
	public Car(int carDistance)
	{
		distance = carDistance;
		money = carPayment + maintenance + parkingPass;
	}
}
