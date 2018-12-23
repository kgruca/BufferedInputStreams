import java.io.*;

public class WritingInputWExceptions {

	public static void main(String[] args) throws Exception{
		
		BufferedInputStream myFileIn;
		BufferedOutputStream myFileOut;
		final int SIZE = 100;
		int k, val;
		byte[] myBytes;
		
		myBytes = new byte[SIZE];
		for(k = 0; k < SIZE; k++)
			myBytes[k]  = (byte)k;
		
		try {
			myFileOut = new BufferedOutputStream(new FileOutputStream("TestStream.dat"));
			for(k = 0; k < myBytes.length; k++)
				myFileOut.write(myBytes[k]);
			myFileOut.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Oops we didn't write the file");
		}
		
		try {
			myFileIn = new BufferedInputStream(new FileInputStream("TestStream.dat"));
			for(k = 0; (val = myFileIn.read()) != -1; k++)
				myBytes[k] = (byte)val;
			myFileIn.close();
			
			for(k = 0; k < SIZE; k++) {
				System.out.print(myBytes[k] + " ");
				if(k % 10 == 0)
					System.out.println();
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Oops, where's the file?");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("\nOops, we went beyond the end of the array!");
		}
		
	}
}
