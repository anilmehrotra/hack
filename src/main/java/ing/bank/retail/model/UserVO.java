package ing.bank.retail.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserVO {

	@NotEmpty(message = "Country name is Mandatory")
	private String country;

	@NotEmpty(message = "Person Name is Mandatory")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
