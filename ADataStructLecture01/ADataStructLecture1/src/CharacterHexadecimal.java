
public class CharacterHexadecimal {

	public static void main(String[] args) {
		// Characters		:	Code Value in Decimal	:	Unicode Value
		// '0' - '9'		:	48 to 57				:	\u0030 to \u0039
		// 'A' - 'Z'		:	65 to 90				:	\u0041 to \u005A
		// 'a' - 'z'		:	97 to 122 				: 	\u0061 to \u007A	
		
		//char[] characters = {'a', 'b', 'A', 'B'};		
//		for(int i = 0; i < characters.length; i++)
//			System.out.print(((int)characters[i]) + " ");
		
		for(int i = 0; i < 26; i++) {
			char c = ((char)(i + 65));
			System.out.print((i < 26)? (c + ", ") : (c + " "));
		}
		System.out.println();
		for(int i = 0; i < 26; i++) {
			char c = ((char)(i + 97));
			System.out.print((i < 26)? (c + ", ") : (c + " "));
		}

	}

}
