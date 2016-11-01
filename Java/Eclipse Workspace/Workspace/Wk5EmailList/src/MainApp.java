
public class MainApp 
{
	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}

	private void start() 
	{
		/*Person me 
		= new Person("john", "j@gmail.com");
		
		Email e1 
		= new Email(me, "hi", "lunch @ 1?");
		
		Person p1 = new Person("ciara", 
				"ciara@gmail.com", "0861234567");
		Person p2 = new Person("joe", 
				"joe@hotmail.com");
		
		e1.addPersonTo(p1);
		e1.addPersonTo(p2);
		e1.print();	*/	
				System.out.println("*****Email System *****");
				int choice = ScannerUtility.getInt("1) Register\n2) Exit\nPlease Select: ",1,2);
				
				Person sender = null;
				
				if(choice == 1)
				{
					doRegistration(sender);
					
					int email = ScannerUtility.getInt("1) Send Email\n2) Exit\nPlease Select: ",1,2);
					
					if(email == 1)
					{
						doSendEmail(sender);
					}
					else
						doExit();
				}
				else
					doExit();
	}
	private void doRegistration(Person sender) {
		String name = ScannerUtility.getString("Please enter a name: ");
		String tel = ScannerUtility.getString("Please enter a Telephone: ");
		String email = ScannerUtility.getString("Please enter a email: ");
		
		sender = new Person(name,email,tel);
	}
	private void doSendEmail(Person sender)
	{
		String name = ScannerUtility.getString("Enter to Name: ");
		String email = ScannerUtility.getString("Enter to Email: ");
		Person p = new Person(name, email);
		String subject = ScannerUtility.getString("Enter Subject: ");
		
	}
	private void doExit() {
		System.out.println("Goodbye!");
	}
}
