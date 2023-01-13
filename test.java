package CHESS;
import java.util.Scanner;
public class test {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		Board board = new Board();
		board.show();
		while(true) {
			String s = "2nd(BLACK)";
			if(board.flag) {
				 s = "1st(WHITE)";
			}
			System.out.println(s + "player turn Which piece you want to take");
			String s1 = myObj.nextLine();			    
		    System.out.println(s +  "player turn Which position you want to set this piece");
		    String s2 = myObj.nextLine();
			board.move(s1, s2);
		}
	}
}
