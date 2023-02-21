package prog1;

import java.util.Calendar;
import java.util.*;

public class DataBaseCaller {
	private static HashMap<Long, String> phBook=new HashMap<>();
	private static LinkedList<MissedCallDetails> miss=new LinkedList<>();
	static Scanner sc=new Scanner(System.in);
	static
	{	
		phBook.put(6872687216l, "Person 1");
		phBook.put(6515466854l, "Person 2");
		phBook.put(6125411354l, "Person 3");
		phBook.put(6515141545l, "Person 4");
	}

	public static void displayPhoneBook() 
	{
		System.out.println("\n----------Phone book----------");
		System.out.printf("| %-15s | %-12s |%n","Name","Phno");
		for (Map.Entry<Long,String> i : phBook.entrySet())
			System.out.printf("| %-15s | %-12s |%n",i.getValue(),i.getKey());
	}
	public static void deleteContact()
	{
		System.out.println("Enter phone number to delete");
		long phno=sc.nextLong();
		if(phBook.remove(phno)==null)
			System.out.println("NO SUCH NUMBER");
		else
			System.out.println("Removing.........done");
	}
	public static void displayMissedCalls()
	{
		System.out.println("Misssed call details");
		System.out.printf("| %-15s | %-12s | %-30s |%n","Name","PhNo","Time");
		for (MissedCallDetails m : miss) 
		{
			String name=phBook.get(m.phno);
			if(name==null)name="Private Caller";
			System.out.printf("| %-15s | %-12s | %-30s |%n",name,m.phno,m.cal.getTime());
		}
	}
	public static void addMissedCall()
	{
		System.out.println("Enter missed call number");
		long phno=sc.nextLong();
		Calendar cal=Calendar.getInstance();
		miss.add(new MissedCallDetails(cal, phno));
		if(miss.size()==11)
			miss.removeFirst();
	}
}
