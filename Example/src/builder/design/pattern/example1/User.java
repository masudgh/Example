package builder.design.pattern.example1;

public class User {
	private  String  firstName; //required
	private  String  lastName; //required
	private  String  ssn; //required
	private String address; //optional
	private String phone;  //optional
	private int age; //optional
	
	private User(UserBuilder builder) {
	        this.firstName = builder.firstName;
	        this.lastName = builder.lastName;
	        this.ssn = builder.ssn;
	        this.address = builder.address;
	        this.phone = builder.phone;
	        this.age = builder.age;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getSsn() {
		return ssn;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String sep=" \n";
		return "User Details: \n"+
				"First Name:" + this.firstName +sep+
				"Last  Name: " +this.lastName+sep+
				"SSN: "+this.ssn+sep+
				"Address: "+this.address+sep+
				"Phone: "+this.phone+sep+
				"Age: "+this.age;
				
	}
	
	public static class UserBuilder  {
		 private final String firstName;
		 private final String lastName;
		 private final String ssn;
		 private int age;
		 private  String phone;
		 private String address;
		public UserBuilder(String firstName, String lastName,String ssn ) {
			super();
			//add validation for the following three variable
			this.firstName = firstName;
			this.lastName = lastName;
			this.ssn=ssn;

		}
	    
		public UserBuilder withAge(int age){
			this.age=age;
			return this;
		}
		
		public UserBuilder withAddress(String address){
			this.address=address;
			return this;
		}
		public UserBuilder withPhone(String phone){
			this.phone=phone;
			return this;
		}
		public User build(){
			User user =new User(this);
			return user;
		
		}

	}
	
	
	
}


