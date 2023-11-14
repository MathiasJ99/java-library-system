import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Books {
	private int barcode;
	private String type;
	private String title;
	private String language;
	private String genre;
	private Date relaseDate;
	private int quantityInStock;
	private float retailPrice;
	private String Ad1;
	private String Ad2;
	
	
	
	
	
	public Books(int barcode,String type,String title,String language,
	 String genre,
	 Date relaseDate,
	 int quantityInStock,
	 float retailPrice,
	 String Ad1,
	 String Ad2) {
		this.barcode = barcode;
		this.title = title;
		this.type = type;
		this.language = language;
		this.genre = genre;
		this.relaseDate = relaseDate;
		this.quantityInStock = quantityInStock;
		this.retailPrice = retailPrice;
		this.Ad1 = Ad1;
		this.Ad2 = Ad2;
				
	}
	

	

	/////getters

	public int getBarcode() {
		return barcode;
	}

	public String getType() {
		return type;
	}
	
	public  String getTitle() {
		return title;
	}
	

	public String getGenre() {
		return genre;
	}

	public String getLanguage() {
		return language;
	}
	
	public String getRelaseDate() {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
		String StringRelaseDate= formatter1.format(relaseDate);
		return StringRelaseDate;
	}
	public Date getRelaseDateDate() {
		return relaseDate;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	
	public float getRetailPrice() {
		return retailPrice;
	}
	
	public String getAd1() {
		return Ad1;
	}

	public String getAd2() {
		return Ad2;
	}
	
	
	
	
	///setters
	
	
	
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setType(String type) {
		this.type = type;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setRelaseDate(Date relaseDate) {
		this.relaseDate = relaseDate;
	}
	
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

	public void setAd1(String ad1) {
		Ad1 = ad1;
	}

	public void setAd2(String ad2) {
		Ad2 = ad2;
	}
	
	////Custom methods
	///Different sorting for books
	private static void DateSorted() throws FileNotFoundException, ParseException {

		List<Books> BooksArr = Books.CreateStock();
		
		
		DateCompare newDateCompare = new DateCompare();
		Collections.sort(BooksArr, newDateCompare);
		
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void PriceSorted() throws FileNotFoundException, ParseException {

		List<Books> BooksArr = Books.CreateStock();
		PriceCompare newPriceCompare = new PriceCompare();
		Collections.sort(BooksArr, newPriceCompare);
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void QuantitySorted() throws FileNotFoundException, ParseException {

		List<Books> BooksArr = Books.CreateStock();
		QuantityCompare newQuantityCompare = new QuantityCompare();
		Collections.sort(BooksArr, newQuantityCompare);
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void GenreSorted() throws FileNotFoundException, ParseException {

		List<Books> BooksArr = Books.CreateStock();
		GenreCompare newGenreCompare = new GenreCompare();
		Collections.sort(BooksArr, newGenreCompare);
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void TitleSorted() throws FileNotFoundException, ParseException {
		List<Books> BooksArr = Books.CreateStock();
		TitleCompare newTitleCompare = new TitleCompare();
		Collections.sort(BooksArr, newTitleCompare);
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void BarcodeSorted() throws FileNotFoundException, ParseException {
		List<Books> BooksArr = Books.CreateStock();
		///sorting 
		
		BarcodeCompare newBarcodeCompare = new BarcodeCompare();
		Collections.sort(BooksArr, newBarcodeCompare);
		
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void TypeSorted() throws FileNotFoundException, ParseException {
		List<Books> BooksArr = Books.CreateStock();
		///sorting 
		
		TypeCompare newTypeCompare = new TypeCompare();
		Collections.sort(BooksArr, newTypeCompare);
		
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}
	
	private static void LanguageSorted() throws FileNotFoundException, ParseException {
		List<Books> BooksArr = Books.CreateStock();
		LanguageCompare newLaguageCompare = new LanguageCompare();
		Collections.sort(BooksArr, newLaguageCompare);
		System.out.println("barcode |  book type |  title |  language |  genre |  release"
				+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
		for (Books i : BooksArr) {
			System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
		 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
		 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
		}
	}

		
	/// Other Custom methods
	public static List<Books> CreateStock() throws FileNotFoundException, ParseException {
		File inputFile = new File("Stock.txt");
		Scanner fileScan =new Scanner(inputFile);
		List<Books> Stock = new ArrayList<>();
		while (fileScan.hasNextLine()) {
			String line = fileScan.nextLine();
			
			String[] tempArr = line.split(",");
			
			int barcode = Integer.parseInt(tempArr[0].trim());
			String type = tempArr[1].trim();
			String title = tempArr[2].trim();
			String language = tempArr[3].trim();
			String genre = tempArr[4].trim();
			
			String relaseDateString = tempArr[5].trim();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date relaseDateObj = formatter.parse(relaseDateString);
			
			int quantityInStock = Integer.parseInt(tempArr[6].trim());
			float retailPrice = Float.parseFloat(tempArr[7].trim());
			String Ad1 = tempArr[8].trim();
			String Ad2 = tempArr[9].trim();
			
			Books newBook = new Books(barcode,type, title, language,genre,relaseDateObj,quantityInStock,retailPrice,Ad1,Ad2);
			Stock.add(newBook);
		
		}
		return Stock;
		
	}
	

	private static void AddtoStock(String line) throws IOException {
		FileWriter fw = new FileWriter("Stock.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
		bw.newLine();
		bw.close();
		System.out.println("Stock updateded Successfully");
	   }
		
	public static void UpdateStock(List<Books> Stock, List<Books> Basket) throws IOException { 
		  try {
		        File inputFile = new File("Stock.txt");

		        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		        List<String> lines = new ArrayList<>();

		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] section = line.split(",");
		            int barcode = Integer.parseInt(section[0].trim());
		            int quantity = Integer.parseInt(section[6].trim());
		            
		            for (Books i : Basket) {
		            	if (barcode ==i.getBarcode()) {
			                section[6] = String.valueOf(quantity-1);
			            }
		  		  	}

		            // Append updated line to list
		            String updatedLine = String.join(", ", section);
		            lines.add(updatedLine);
		        }

		        reader.close();

		        // Write updated lines to input file
		        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
		        for (String updatedLine : lines) {
		            writer.write(updatedLine);
		            writer.newLine();
		        }

		        writer.close();

		        System.out.println("File updated successfully");
		    } catch (IOException e) {
		        System.out.println("An error occurred while editing the file.");
		        e.printStackTrace();
		    }
	  }
	
	private static boolean OnlyNumbersArr(String...strings ) {
		for (String str : strings) {
			if (!str.matches("\\d+")) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean OnlyLettersArr(String...strings ) {
		for (String str : strings) {
			if (!str.matches("[a-zA-Z ]+")) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean OnlyDate(String str) {//////CHECK DATE FORMAT
		return str.matches("\\d{2}-\\d{2}-\\d{4}");
	}

	private static boolean OnlyFloatArr(String...strings ) {
		for (String str : strings) {
			if (!str.matches("\\d+(\\.\\d+)?")) {
				return false;
			}
		}
		return true;
	}
	
	private static void AddPaperback() throws IOException, ParseException {
		System.out.println("Enter the book detals in this order separated by a comma");
		System.out.println("barcode, title, language, genre, release date, quantity in stock, retail price, number of pages"
				+ ", condition");
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		String Input = reader.readLine();
		String[] tempArr = Input.split(",");
		
		
		//String[] tempArrNumbers = {tempArr[0] , tempArr[5], tempArr[7]};
		//String[] tempArrLetters = {tempArr[1] , tempArr[2], tempArr[3], tempArr[8]};
		//String tempDate = tempArr[4];
		//String tempFloat = tempArr[6];
		
		boolean CheckInts = OnlyNumbersArr(tempArr[0].trim() , tempArr[5].trim() , tempArr[7].trim() );
		boolean CheckLetters = OnlyLettersArr(tempArr[1].trim()  , tempArr[2].trim() , tempArr[3].trim() , tempArr[8].trim() );
		boolean CheckDate =  OnlyDate(tempArr[4].trim() );
		boolean CheckFloat = OnlyFloatArr(tempArr[6].trim() );
		boolean valid = true;
		
		if(CheckLetters != true) {
			System.out.println("error: can only accept letters for title, langugae, genre and condition");
			valid = false;
		}
		
		
		if(CheckInts != true) {
			valid = false;
			System.out.println("error: can only accept integers for barcode, quantity and number of pages");
			//System.out.printf(tempArr[0] , tempArr[5], tempArr[7]);
		}
		
		
		if(CheckDate != true) {
			valid = false;
			
			System.out.println("error: can only accept dates format for relase date");
			//System.out.printf(tempArr[4].trim());
		}
		
		if(CheckFloat != true) {
			valid = false;
			System.out.println("error: can only accept floats and int format for price");
			//System.out.printf(tempArr[6]);
		}
		
		if (valid == true ) {
			int barcode = Integer.parseInt(tempArr[0].trim());
			if (InStock(barcode) == false) {
				String type = "paperback";
				String title = tempArr[1].trim();
				String language = tempArr[2].trim();
				String genre = tempArr[3].trim();
				
				String relaseDateString = tempArr[4].trim();
				
				
				int quantityInStock = Integer.parseInt(tempArr[5].trim());
				float retailPrice = Float.parseFloat(tempArr[6].trim());
				String Ad1 = tempArr[7].trim();
				String Ad2 = tempArr[8].trim();
				
				//Books newBook = new Books(barcode,type, title, language,genre,relaseDateObj,quantityInStock,retailPrice,Ad1,Ad2);
				// write new book to file or update stock
				Books.AddtoStock(barcode+","+type+","+ title+","+ language+","+genre+","+relaseDateString+","+quantityInStock+","+retailPrice+","+Ad1+","+Ad2);
				Books.CreateStock();
				System.out.print("Added new book "+ title);
			}
			else {
				System.out.println("error: book is already in stock");
			}
		}
		else {
			AddPaperback();
		}
	}
	
	
	private static void AddEbook() throws IOException, ParseException {

		System.out.println("Enter the book detals in this order separated by a comma");
		System.out.println("barcode, title, language, genre, release date, quantity in stock, retail price, number of pages"
				+ ", format");
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		String Input = reader.readLine();
		String[] tempArr = Input.split(",");
		
		boolean CheckInts = OnlyNumbersArr(tempArr[0].trim() , tempArr[5].trim() , tempArr[7].trim() );
		boolean CheckLetters = OnlyLettersArr(tempArr[1].trim()  , tempArr[2].trim() , tempArr[3].trim() , tempArr[8].trim() );
		boolean CheckDate =  OnlyDate(tempArr[4].trim() );
		boolean CheckFloat = OnlyFloatArr(tempArr[6].trim() );
		boolean valid = true;
		
		if(CheckLetters != true) {
			System.out.println("error: can only accept letters for title, langugae, genre and format");
			valid = false;
		}
		
		
		if(CheckInts != true) {
			valid = false;
			System.out.println("error: can only accept integers for barcode, quantity and number of pages");
			//System.out.printf(tempArr[0] , tempArr[5], tempArr[7]);
		}
		
		
		if(CheckDate != true) {
			valid = false;
			
			System.out.println("error: can only accept dates format for relase date");
			//System.out.printf(tempArr[4].trim());
		}
		
		if(CheckFloat != true) {
			valid = false;
			System.out.println("error: can only accept floats and int format for price");
			//System.out.printf(tempArr[6]);
		}
		
		if (valid == true ) {
		
			int barcode = Integer.parseInt(tempArr[0].trim());
			if (InStock(barcode) == false) {
				String type = "ebook";
				String title = tempArr[1].trim();
				String language = tempArr[2].trim();
				String genre = tempArr[3].trim();
				
				String relaseDateString = tempArr[4].trim();
				
				
				int quantityInStock = Integer.parseInt(tempArr[5].trim());
				float retailPrice = Float.parseFloat(tempArr[6].trim());
				String Ad1 = tempArr[7].trim();
				String Ad2 = tempArr[8].trim();
				
				//Books newBook = new Books(barcode,type, title, language,genre,relaseDateObj,quantityInStock,retailPrice,Ad1,Ad2);
				// write new book to file or update stock
				Books.AddtoStock(barcode+","+type+","+ title+","+ language+","+genre+","+relaseDateString+","+quantityInStock+","+retailPrice+","+Ad1+","+Ad2);
				Books.CreateStock();
				System.out.print("Added new book "+ title);
			}
			else {
				System.out.println("error: book is already in stock");
			}
		}
		else {
			AddEbook();
		}
	}
	
	private static boolean InStock(int barcode) throws FileNotFoundException, ParseException {
		List<Books> BooksArr = Books.CreateStock();
		for (Books i : BooksArr) {
			if (i.getBarcode() == barcode) {
				return true;
			}
		}
		return false;
	}
	
	private static void AddAudiobook() throws IOException, ParseException {
		System.out.println("Enter the book detals in this order separated by a comma");
		System.out.println("barcode, title, language, genre, release date, quantity in stock, retail price, length"
				+ ", format");
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		String Input = reader.readLine();
		String[] tempArr = Input.split(",");
		
		boolean CheckInts = OnlyNumbersArr(tempArr[0].trim() , tempArr[5].trim());
		boolean CheckLetters = OnlyLettersArr(tempArr[1].trim()  , tempArr[2].trim() , tempArr[3].trim() , tempArr[8].trim() );
		boolean CheckDate =  OnlyDate(tempArr[4].trim() );
		boolean CheckFloat = OnlyFloatArr(tempArr[6].trim(), tempArr[7].trim() );
		boolean valid = true;
		
		if(CheckLetters != true) {
			System.out.println("error: can only accept letters for title, langugae, genre and format");
			valid = false;
		}
		
		
		if(CheckInts != true) {
			valid = false;
			System.out.println("error: can only accept integers for barcode, quantity and number of pages");
			
		}
		
		
		if(CheckDate != true) {
			valid = false;
			
			System.out.println("error: can only accept dates format for relase date");
			
		}
		
		if(CheckFloat != true) {
			valid = false;
			System.out.println("error: can only accept floats and int format for price and length");
			
		}
		
		if (valid == true ) {
		
			int barcode = Integer.parseInt(tempArr[0].trim());
			if (InStock(barcode) == false) {
				String type = "audiobook";
				String title = tempArr[1].trim();
				String language = tempArr[2].trim();
				String genre = tempArr[3].trim();
				
				String relaseDateString = tempArr[4].trim();
				
				
				int quantityInStock = Integer.parseInt(tempArr[5].trim());
				float retailPrice = Float.parseFloat(tempArr[6].trim());
				String Ad1 = tempArr[7].trim();
				String Ad2 = tempArr[8].trim();
				
				//Books newBook = new Books(barcode,type, title, language,genre,relaseDateObj,quantityInStock,retailPrice,Ad1,Ad2);
				// write new book to file or update stock
				Books.AddtoStock(barcode+","+type+","+ title+","+ language+","+genre+","+relaseDateString+","+quantityInStock+","+retailPrice+","+Ad1+","+Ad2);
				Books.CreateStock();
				System.out.println("Added new book "+ title);
			}
			else {
				System.out.println("error: book is already in stock");
			}
		}
		else {
			AddAudiobook();
		}
	}
	
	public static  void viewBooks(String role) throws ParseException, IOException {
		
		List<Books> BooksArr = Books.CreateStock();
		System.out.println("Would you like to go to viewbooks normally (n) or view books sorted (s)? ");
		Scanner reader1 = new Scanner(System.in);
		String Choice = reader1.nextLine();
		//reader1.close();
		if ((Choice.equalsIgnoreCase("n")) || (Choice.equalsIgnoreCase("s"))) {
			switch (Choice){
			case "n":
				System.out.println("barcode | type |  title |  language |  genre |  release"
						+ "date |  quantity in stock |  retail price |  additional information 1 |  additional information 2");
				for (Books i : BooksArr) {
					System.out.println(i.getBarcode() + " | "+i.getType() + " | "+ i.getTitle()+ " | "+
				 i.getLanguage() + " | "+i.getGenre() + " | "+ i.getRelaseDate() + " | "+ i.getQuantityInStock()
				 + " | "+ i.getRetailPrice() + " | "+ i.getAd1() + " | "+ i.getAd2());
				}
				
				if (role.equalsIgnoreCase("customer")) {
					Main.CustomerMainMenu();
				}
				else if (role.equalsIgnoreCase("admin")) {
					Main.AdminMainMenu();
				}
				break;
				
			case "s":
				System.out.println("What would you like to sort by (barcode), (type), (title), (language), (genre), (release-date),(quantity) or (price)? ");
				Scanner reader2 = new Scanner(System.in);
				String sort = reader2.nextLine();
				//reader2.close();
				if (sort.equalsIgnoreCase("barcode")) {
					BarcodeSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("type")) {
					TypeSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("title")) {
					TitleSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("language")) {
					LanguageSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("genre")) {
					GenreSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("release-date")) {
					DateSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("quantity")) {
					QuantitySorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
				if (sort.equalsIgnoreCase("price")) {
					PriceSorted();
					if (role.equalsIgnoreCase("customer")) {
						Main.CustomerMainMenu();
					}
					else if (role.equalsIgnoreCase("admin")) {
						Main.AdminMainMenu();
					}
					break;
				}
		}		
		}
		else {
			System.out.println("error: please choose (s) or (n)");
			viewBooks(role);
			if (role.equalsIgnoreCase("customer")) {
				Main.CustomerMainMenu();
			}
			else if (role.equalsIgnoreCase("admin")) {
				Main.AdminMainMenu();
			}
			
		}
		
	}
	
	public static void AddBooks() throws IOException, ParseException {
		System.out.print("do you want to add a paperback book(p), e-book (e) or audiobook (a)");
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
		String booktype = reader.readLine();
		
		switch (booktype){
			case "p":
				Books.AddPaperback();
				Main.AdminMainMenu();
				break;
			case "e":
				Books.AddEbook();
				Main.AdminMainMenu();
				break;
			case "a":
				Books.AddAudiobook();
				Main.AdminMainMenu();
				break;
		}
	}

	
}
