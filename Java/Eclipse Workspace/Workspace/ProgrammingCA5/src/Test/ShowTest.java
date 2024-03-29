package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Show;

public class ShowTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testWrite() {
		try {
			RandomAccessFile raf = new RandomAccessFile("c:/temp/testWrite.txt","rw");
			Show s = new Show("RAF", "Daniel", "Action", 1.99, 5, 6);
			assertNotNull(s);
			
			boolean success = Show.write(raf, s);
			assertTrue(success);
			
			boolean exists = new File("c:/temp/testWrite.txt").exists();
			assertTrue(exists);
			
			long length = raf.length();
			assertEquals(length, Show.size);
			
			raf.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
@Test
	public void testRead() {
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile("c:/temp/testWrite.txt","rw");
			Show s = new Show("RAF", "Daniel", "Action", 1.99, 5, 6);
			boolean success = Show.write(raf, s);
			assertTrue(success);
			
			raf.seek(0);
			Show in = Show.read(raf);
			assertEquals(in.getName(),"RAF");
			assertEquals(in.getProducer(), "Daniel");
			assertEquals(in.getDuration(), 6);
			
			raf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
