package tw.com.fcb.calstringtest.CalculateString;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CalculateStringService {
	public CalculateStringService() {}
	
	public void readOption() {
		try {
			CalculateString calculateString = new CalculateString();
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入選項: 1)靠右補零. 2)靠左補零. 3)輸入小數點後位數. : ");
			int option = scanner.nextInt();
			if(option == 1) {
				inputOption(calculateString);
				if(calculateString.getZeroString() != null && calculateString.getNumString() != null) {
					System.out.println("靠右補零: " + calculateString.getZeroString() + calculateString.getNumString());
				}
			}
			else if(option == 2) {
				inputOption(calculateString);
				if(calculateString.getZeroString() != null && calculateString.getNumString() != null) {
					System.out.println("靠左補零: " + calculateString.getNumString() + calculateString.getZeroString());
				}
			}
			else if(option == 3) {
				inputDecimalOption(calculateString);
				if(calculateString.getZeroString() != null && calculateString.getNumString() != null) {
					System.out.println("小數點後位數補零: " + calculateString.getNumString() + calculateString.getZeroString());
				}
			}
			else {
				System.out.println("選項輸入錯誤，僅可輸入選項1-3");
			}
		}
		catch (InputMismatchException e) {
			System.out.println("選項輸入錯誤，僅可輸入數字");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 數字靠右-左補零、數字靠左-右補零
	public void inputOption(CalculateString cString) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入數字長度: ");
			int numLength = scanner.nextInt();
			
			System.out.print("請輸入數字: ");
			String number = scanner.next();
			
			if(number.length() > numLength) {
				System.out.println("數字超出範圍");
			}
			else {
				cString.setNumString(number);
				
				// Add Zeros
				String zeroString = new String();
				for(int i  = 0 ; i < (numLength - number.length()) ; i++) {
					zeroString = zeroString + "0";
				}
				cString.setZeroString(zeroString);
//				System.out.println("zeros " + zeroString);
			}
		}
		catch (InputMismatchException e) {
			System.out.println("選項輸入錯誤，僅可輸入數字");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 小數點後補零
	public void inputDecimalOption(CalculateString cString) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入小數點後數字長度: ");
			int numLength = scanner.nextInt();
			
			System.out.print("請輸入數字: ");
			String number = scanner.next();
			
			// 取得小數點索引值
			int idx = number.indexOf(".");
			
			// 取得小數點後位數長度
			int length = number.length() - (idx+1);
			
			if(length > numLength) {
				System.out.println("小數點輸入超出範圍");
			}
			else {
				cString.setNumString(number);
				
				// Add Zeros
				String zeroString = new String();
				for(int i  = 0 ; i < (numLength - length) ; i++) {
					zeroString = zeroString + "0";
				}
				cString.setZeroString(zeroString);
//				System.out.println("zeros " + zeroString);
			}
		}
		catch (InputMismatchException e) {
			System.out.println("選項輸入錯誤，僅可輸入數字");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
