import java.text.DecimalFormat;
public class Car 
{
	int time;
	int insurance = 1462;
	int maintenance = 368;
	int parkingPass = 178;
	int fastMPH = 60;
	int slowMPH = 20;
	double gasfuelprice = 2.42;
	int avgmpg = 32;
	double money;
	int distance;
	String vehicle = "Car";
	public Car(int carDistance)
	{
		distance = carDistance;
		
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public int getDistance()
	{
		return distance;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("###.##");
		return ("\nSac State is " + distance + " miles away by " + vehicle
				+ ".\n You should expect to spend $" + df.format(money) + " per year to drive a car.\n");
	}
	
	public void setMoney()
	{
		money = insurance + maintenance + parkingPass + (gasfuelprice / avgmpg * 10 * 34 * distance);
	}
}
