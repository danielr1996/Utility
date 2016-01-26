package de.dani.utility.numbers;

public class NumberSystem {
	public static String decToBase(int n, int base) {
		String s = "";
		if(n == 0){
			if(base == 16){
				return "0x0";	
			}else if(base == 8){
				return "0o0";
			}else if(base == 2){
				return "0b0";
			}	
		}
		
		while (n != 0) {
			s = String.valueOf(n % base).replaceAll("10", "A").replaceAll("11", "B").replaceAll("12", "C")
					.replaceAll("13", "D").replaceAll("14", "E").replaceAll("15", "F") + s;
			n /= base;
		}
		if(base == 16){
			s = "0x"+s;	
		}else if(base == 8){
			s = "0o"+s;
		}else if(base == 2){
			s = "0b"+s;
		}
		return s;
	}
	
	public static int baseToDec(String number, int base) {
		char[] arr = number.toCharArray();
		int erg = 0;
		for (int i = 0; i < arr.length; i++) {
			String digit = String.valueOf(arr[i]).replaceAll("A", "10").replaceAll("B", "11").replaceAll("C", "12")
					.replaceAll("D", "13").replaceAll("E", "14").replaceAll("F", "15");
			erg += Integer.parseInt(digit) * Math.pow(base, (arr.length - i - 1));
		}
		return erg;
	}
}
