package ing.bank.retail.token;

public class Singleton {
	private static Singleton single_instance = null;

	public static String token;

	private Singleton() {
		token = "inguser";
	}

	// static method to create instance of Singleton class
	public static Singleton getInstance() {
		if (single_instance == null)
			single_instance = new Singleton();

		return single_instance;
	}

}
