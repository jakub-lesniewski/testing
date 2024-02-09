import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {
	static Figure[] figures;
	private static Logger logger = Logger.getLogger("Figures");
	
	public static void main(String[] args) throws SecurityException, IOException {
		FileHandler fh = new FileHandler("figures.txt",true);
		logger.addHandler(fh);
		logger.info("FIGURES");
		
		getData();
		printData();
		logData(logger);
	}

	private static void logData(Logger logger2) {
		for(int i=0;i<figures.length;i++)
			logger.info(figures[i].printInfoLog());
	}

	private static void printData() {
		for(int i=0;i<figures.length;i++)
			figures[i].printInformation();
	}

	private static void getData() {
		int size = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Number of figures: ");
		size = scan.nextInt();
		String line = scan.nextLine();
		figures = new Figure[size];
		for(int i=0;i<size;i++) {
			System.out.println("Figure "+(i+1)+". ");
			line = scan.nextLine();
			Figure figure = FigureCreator.create(line);
			if(figure == null)
				i--;
			else
				figures[i] = figure;
		}
		scan.close();	
	}
}
