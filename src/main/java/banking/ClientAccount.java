package banking;

public class ClientAccount {
	String accontNumber = "";
	int amount;
	
	String firstName = "";
	String secondName = "";
	String otchestvo = "";
	
	String typeDocument = "";
	String idDocument = "";
	
	public String getAccontNumber() {
		return accontNumber;
	}
	public void setAccontNumber(String accontNumber) {
		this.accontNumber = accontNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getOtchestvo() {
		return otchestvo;
	}
	public void setOtchestvo(String otchestvo) {
		this.otchestvo = otchestvo;
	}
	public String getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}
	public String getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(String idDocument) {
		this.idDocument = idDocument;
	}
	

}
