import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainApp {

	public static void main(String[] args) {
		MainApp theApp = new MainApp();
		try {
			theApp.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() throws IOException {
		String fileName = "myFile.txt";
		String filePath = "C:/Users/Dkill/Desktop/";
		
		//demoFile(fileName,filePath);
		fileName = "myFileStream.txt";
		filePath = "C:/Users/Dkill/Desktop/";
		demoFileStream(fileName,filePath);
		demoFileInputStream(fileName,filePath);
		demoBufferedStream(fileName,filePath);
		demoDataStream(fileName,filePath);
	}

	

	private void demoFile(String fileName, String filePath) throws IOException {
		//create a file using FileOutputStream
		File file = new File(filePath+fileName);
		
		System.out.println("Exists: " + file.exists());
		
		if(!file.exists()){
			file.createNewFile();
		}
		
		System.out.println(file.getAbsolutePath()); //"z:/fasr/../myFile.txt" 
		System.out.println(file.getCanonicalPath()); //"Z:/fasr/sdfgh/ertdyf/dfghj/ertghj/myFile.txt" full path
		System.out.println(file.getFreeSpace());
		System.out.println(file.getParent());
		System.out.println(file.getUsableSpace());
		System.out.println(file.getPath());
		System.out.println(file.getName());
	}
	
	private void demoFileStream(String fileName, String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath+fileName);
		/*fos.write(65);
		fos.write(66);
		fos.write(66);
		fos.write(65);*/
		byte[] byteArray = {68, 97, 110, 105, 101, 108, 32, 70, 111, 116, 104,
				13,10,98,108,97,99,107};
		//fos.write(byteArray); //all of the bytes
		fos.write(byteArray, 0, 11);//from pos 0 to 11
		
		byte[] nextArray = "\r\nThis is a \r\nlovely string!".getBytes(); //strings can be turned into byte arrays using getBytes
		fos.write(nextArray);
		
		fos.flush();
		fos.close();
	}
	
	private void demoFileInputStream(String fileName, String filePath) throws IOException {
		File file = new File(filePath+fileName);
		FileInputStream fis = new FileInputStream(filePath+fileName);
		
		//int anInt = fis.read();
		//System.out.println((char)anInt);
		
		byte[] byteArray = new byte[(int) file.length()];
		fis.read(byteArray);
		String strData = new String(byteArray);
		System.out.println(strData);
		fis.close();
	}
	
	
	
	
	
	
	
	
	
	private void demoBufferedStream(String fileName, String filePath) {
		
		
	}
	
	private void demoDataStream(String fileName, String filePath) {
		
		
	}

}
