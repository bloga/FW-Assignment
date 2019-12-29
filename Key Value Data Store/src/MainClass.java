
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	static String filename = "DataStore.txt";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String absoluteFilePath;
		String workingDirectory = System.getProperty("user.dir");
		Scanner input = new Scanner(System.in);

		System.out.println("Hello :)");
		System.out.println("Provide the absolute file path or press 'Enter' key to select the default file path ("
				+ workingDirectory + File.separator + filename + ")");
		absoluteFilePath = input.nextLine();
		if (absoluteFilePath.isEmpty()) {
			absoluteFilePath = workingDirectory + File.separator + filename;
		}

		File file = DataStore.createFile(absoluteFilePath);
		if (file != null) {
			try {
				DataStore.readFile(absoluteFilePath);
				
				do {
					System.out.println("********************************************************");
					System.out.println("Press 1 to create, 2 to read, 3 to delete or 4 to exit");
					String val = input.nextLine();
					if (val.equals("1")) {
						// CREATE
						System.out.print("Enter key : ");
						String key = input.nextLine();

						System.out.print("Enter value : ");
						String value = input.nextLine();

						System.out.print("Enter time to live in ms : ");
						String timeOutString = input.nextLine();
						long timeOut = 0;
						try {
							timeOut = Integer.parseInt(timeOutString);
						}catch(NumberFormatException e) {
							
						}
						DataStore.create(key, value, timeOut);
					} else if (val.equals("2")) {
						// READ
						System.out.print("Enter key : ");
						String key = input.nextLine();
						DataStore.read(key);
					} else if (val.equals("3")) {
						// DELETE
						System.out.print("Enter key : ");
						String key = input.nextLine();
						DataStore.delete(key);
					} else {
						// EXIT
						System.out.println("Exit");
						DataStore.writeFile(absoluteFilePath);
						break;
					}
				} while (true);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return;
	}


}
