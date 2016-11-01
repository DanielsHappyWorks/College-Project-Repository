public class VirtualContact extends Contact
{
	private String alias;
	private String twitter, email;
	private boolean isOnline;
	
	public VirtualContact(String email, String name)
	{
		super(name);
		setEmail(email);
		setAlias(name);
		this.twitter = "no twitter handle";
		this.isOnline = false;
	}

	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public String toString() {
		return super.toString()+"\nEmail: "+this.email;
	}


}
