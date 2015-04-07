package br.com.justoeu.domain.enums;


public enum TypeAccount {

	PRIME("prime"), SINGLE("single"), COUPLE("couple");
	
	private String name;
	
	private TypeAccount(String name){
		this.name = name;
	}
	
	public String getValue(){
		return this.name;
	}
	
	public static TypeAccount getTypeAccount(String name){
		
		TypeAccount typCurrent = null;

		for (TypeAccount typeAccount : TypeAccount.values()){
			if (typCurrent.getValue().equals(name)){
				typCurrent = typeAccount;
				continue;
			}
		}
		
		return typCurrent;
	}
}