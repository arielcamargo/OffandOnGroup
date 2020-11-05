import java.util.*;
public class User 
{
	//Here's where the variables and constants for this specific object, User, are held.
	//We name these variables private. The reason being is that if we don't you can use them in main, and we want to 
	//limit the access of main to only what it needs.
	private String name;
	private String address;
	private int zipCode;
	private boolean car = true;
	private boolean motorcycle = false;
	private boolean bike = false;
	private int money;
	private int carDistance;
	private int walkDistance;
	private int bikeDistance;
	private int RTDistance;
	private boolean statsYN = false;
	//Static refers to an unchanging value, so a constant. These constants are only here to supplement the actual address lookup.
	private static final int maxDistance = 20;
	private static final int maxDistanceChange = 5;
	
	//This method below is what we call the constructor for the User object. Essentially it what gets run the moment a User object is created.
	public User()
	{
		//These should look similar to standard method calls in C++
		name = inputLongString("Please enter your name: ");
		address = inputLongString("Please enter your street address: ");
		zipCode = inputNumber("Please enter your zip code: ");
		money = inputNumber("Please enter money your are willing to spend: ");
		carDistance = randomDistance(maxDistance);
		walkDistance = carDistance + randomDistance(maxDistanceChange);
		bikeDistance = carDistance + randomDistance(maxDistanceChange);
		RTDistance = carDistance + randomDistance(maxDistanceChange);
		//This is the creation of a new Car object, more on that in Car.java.
		Car car = new Car(carDistance);
		Motorcycle harley = null;
		motorcycle = doYouHave("Do you own a motorcycle?");
		if(motorcycle)
		{
			harley = new Motorcycle(carDistance);
		}
		statsYN = doYouHave("Would you like to see your stats?");
		if(statsYN)
		{
			car.setMoney();
			System.out.print(car);
			if(motorcycle)
			{
				harley.setMoney();
				System.out.print(harley);
			}

		}
	}
	
	//This method takes a String, prompts the user to enter some info as a String, asks if 
	//the info looks correct, and if so it stores that info, otherwise it loops until the user
	// says it is right.
	public static String inputLongString(String message)
	{
		String LongString;
		String yesNo;
		//The line below is what you need to do to get an input from the console.
		//You must first create a Scanner object, which in this case called input.
		//It's a bit more complicated then cin >> x;
		Scanner input = new Scanner(System.in);
		//The line below is how you output to the console.
		// So cout << message; == System.out.println(message);
		System.out.println(message);
		//The line below accepts the next message type into the console until the enter key is hit.
		LongString = input.nextLine();
		System.out.println("\n\nDoes this look right? " + LongString
				+ "\n\n If not hit n and enter, otherwise hit"
				+ " any other key and enter.");
		//The line below is slightly different, it only looks at the next token, which means we stop reading until enter or space is hit.
		yesNo = input.next();
		//The line below takes a String and turns the letters in that string to lowercase.
		yesNo = yesNo.toLowerCase();
		//Loops and Conditional Statements look very similar to C++. Here we are taking advantage of the String object library to only look
		//at the beginning of a string.
		if(yesNo.startsWith("n"))
		{
			return inputLongString(message);
		}
		else
		{
			return LongString;
		}
	}
	//This method is much like the LongString method above, however it is looking for a positive number.
	//One thing to note is that if a user typed "12n" it would not count that as a number but instead it would
	//count the whole thing as a String.
	public static int inputNumber(String message)
	{
		int number = 0;
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		//If a number can't be read, and remember it must be alone, we will loop back to the start along
		//with this error message.
		if(!input.hasNextInt())
		{
			System.out.println("That's not a number. "
					+ "Please enter a number.");
			return inputNumber(message);
		}
		else
		{
			number = input.nextInt();
			//Negative numbers don't make much sense, so we loop the method again if that's the case.
			if(number < 0)
			{
				System.out.println("That's not a valid number. "
						+ "Please enter a valid number.");
				return inputNumber(message);
			}
		}
		return number;
	}
	
	public static boolean doYouHave(String question)
	{
		String yesNo;
		Scanner input = new Scanner(System.in);
		System.out.println(question);
		yesNo = input.next();
		yesNo = yesNo.toLowerCase();
		if(yesNo.startsWith("n"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	//Making a random number also requires the creation of a Random object.
	//This method allows you to just call randomDistance and a number from 0 to the number you enter
	//will be generated. This will not be used in the final code, but its here to help guide things along
	//until API is figured out.
	public static int randomDistance(int x)
	{
		Random rand = new Random();
		int ranNum = rand.nextInt(x);
		return ranNum;
	}
	//The following methods allow outside objects call pieces of the data in User.
	//If I did want the name in the main method, I would type x.getName() and that will grab the name for this user.
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getZipCode()
	{
		return zipCode;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public int getDistance()
	{
		return carDistance;
	}
	
	public int setDistance()
	{
		return carDistance + randomDistance(maxDistanceChange);
	}
	//ToString is an essential method to make for any new objects you make.
	//What you can do is essentially cout << User; That might not make sense
	//but its normally how we output a summary of what is in the object.
	public String toString()
	{
		return name + " is " + carDistance;
	}
	
}


