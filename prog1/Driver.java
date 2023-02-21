package prog1;

public class Driver {
	
	public static void main(String[] args) {
		while(true)
		{
			System.out.println("\n-----(  Menu  )-----");
			System.out.println("1.New missed Call\n2.Display phBook\n3.Dsiplay missed call\n4.Del contact\n5.EXIT\nEnter your choice:");
			int i=DataBaseCaller.sc.nextInt();
			switch (i) {
			
			case 1:DataBaseCaller.addMissedCall();
				break;
			case 2:DataBaseCaller.displayPhoneBook();
				break;
			case 3:DataBaseCaller.displayMissedCalls();
				break;
			case 4:DataBaseCaller.deleteContact();
				break;
			case 5:System.exit(0);
			default:System.out.println("invalid");
				break;
			}
		}
	}
}
