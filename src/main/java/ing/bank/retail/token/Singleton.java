package ing.bank.retail.token;

public class Singleton {
	private static Singleton single_instance = null;

	public String token;

	private Singleton() {
		token = "inguser";
	}
	
	public String getToken() {
		return token;
	}

	// static method to create instance of Singleton class
	public static Singleton getInstance() {
		if (single_instance == null)
			single_instance = new Singleton();

		return single_instance;
	}

}
