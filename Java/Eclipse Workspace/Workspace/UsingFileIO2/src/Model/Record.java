package Model;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import Utility.StringUtility;

public class Record 
{
	public static final /*final vars cannot be modified*/ int Size 
		= 2 + StringUtility.StandardPadLength + 12;
	
	private String name; //2 + StandardPadLength
	private int date, month, year; //4, 4, 4
	
	public Record(String name, int date, int month, int year) {
		super();
		this.name = name;
		this.date = date;
		this.month = month;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + date;
		result = prime * result + month;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (date != other.date)
			return false;
		if (month != other.month)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Record [name=" + name + ", date=" + date + ", month=" + month + ", year=" + year + "]";
	}
	
	
	public static Record read(DataInputStream dis)
	{
		try
		{
			String name = StringUtility.unpad(dis.readUTF(), 
										StringUtility.PadString);
			int date = dis.readInt();
			int month = dis.readInt();
			int year = dis.readInt();
			
			return new Record(name, date, month, year);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;		
	}
	
	public void write(DataOutputStream dos)
	{
		try 
		{
			dos.writeUTF(StringUtility.pad(
					this.getName(), 
					StringUtility.StandardPadLength, 
					StringUtility.PadString));
			dos.writeInt(this.getDate());
			dos.writeInt(this.getMonth());
			dos.writeInt(this.getYear());
		//	dos.flush(); //we will decide to do the flush somewhere else
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
