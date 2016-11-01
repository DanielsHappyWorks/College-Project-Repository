package Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Utility.StringUtility;

public class StringUtilityTest 
{
	@Test 
	public void testUnPad()
	{
		String padString = "*";
		String unpadded = "";
		
		unpadded = StringUtility.unpad("john****", padString);		
		assertEquals(unpadded, "john");
		
		unpadded = StringUtility.unpad("john1234", padString);		
		assertEquals(unpadded, "john1234");
		
		unpadded = StringUtility.unpad(null, padString);		
		assertNull(unpadded, null);
		
		unpadded = StringUtility.unpad(null, null);		
		assertNull(unpadded, null);
		
		unpadded = StringUtility.unpad("john****", null);		
		assertNull(unpadded, null);
	}
	
	@Test
	public void testPad()
	{
		String data = "john";
		int padLength = 8;
		String padString = "*";
		String padded = "";
		
		data = null;
		padded = StringUtility.pad(data, padLength, padString);		
		assertNull(padded);
		
		data = "john";
		padLength = 0;
		padded = StringUtility.pad(data, padLength, padString);		
		assertNull(padded);
		
		data = "john";
		padLength = 8;
		padString = null;
		padded = StringUtility.pad(data, padLength, padString);		
		assertNull(padded);
		
		data = "john";
		padLength = 8;
		padString = "*";
		padded = StringUtility.pad(data, padLength, padString);		
		assertEquals(padded, "john****");
		
		data = "johnston";
		padded = StringUtility.pad(data, padLength, padString);		
		assertEquals(padded, "johnston");
		
		data = "bea jones"; //9! too long, chop!
		padded = StringUtility.pad(data, padLength, padString);		
		assertEquals(padded, "bea jone");
		
		
	}

	
}
