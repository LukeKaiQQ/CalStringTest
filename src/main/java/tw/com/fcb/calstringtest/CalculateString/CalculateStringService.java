package tw.com.fcb.calstringtest.CalculateString;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CalculateStringService {
	public CalculateStringService() {
	}
	
	public void readOption() {
		try {
			CalculateString calculateString = new CalculateString();
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入選項: 1)靠右補零. 2)靠左補零.: ");
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
	
	public void inputOption(CalculateString cString) {
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.print("請輸入數字長度: ");
			int numLength = scanner.nextInt();
			
			System.out.print("請輸入數字: ");
			String number = scanner.next();
			cString.setNumString(number);
			
			if(number.length() > numLength) {
				System.out.println("數字超出範圍");
			}
			else {
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
}
