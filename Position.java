package CHESS;

public class Position {
   int xx,yy;
   Position(String pos){
	   xx = pos.charAt(0)- 'a'; // so xx like a column
	   yy = pos.charAt(1)- '1'; // so yy like a row
   }
   Position(int x,int y){
	   xx = x;
	   yy = y;
   }
   int getPositionx() {
	   return xx;   // get column position
   }
   int getPositiony() {
	   return yy;   // get row position
   }
   public boolean rightPos() {
	   if (xx >= 0 && xx <= 7 && yy >= 0 && yy <= 7) {
		   return true;
       }
	   return false;
   }
}
