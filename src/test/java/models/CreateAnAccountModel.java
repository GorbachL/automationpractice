package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAnAccountModel {

	String FirstName;
	String LastName;
	String Password;
	String Address;
	String City;
	String State;
	String PostalCode;
	String MobilePhone;
	String AddressAlias;

}
