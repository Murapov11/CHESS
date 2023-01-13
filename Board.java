package CHESS;
import java.util.Scanner;


public class Board {
	public boolean flag;
    Piece board [][] = new Piece[8][8];
    Board(){
        setInitPos();
        flag = true;
	}
    void setInitPos() {
    	for(int i = 0 ; i < 8;i++) {
 		   for(int j = 0; j < 8;j++) {
 			   Position p = new Position(j,i);
 			   if (i == 1 || i == 6) {
 				   board[i][j] = new Pawn(p);
 				   if (i == 6) board[i][j].color = "WHITE";
 				   else board[i][j].color = "BLACK";
 			   }
 			   if (i == 0 || i == 7) {
 				   if (j == 0 || j == 7) board[i][j] = new Rock(p);
 				   else if (j == 1 || j == 6) board[i][j] = new Knight(p);
 				   else if (j == 2 || j == 5) board[i][j] = new Bishop(p);
 				   else if (j == 3) board[i][j] = new Queen(p);
 				   else board[i][j] = new King(p);
 				   if (i == 7) board[i][j].color = "WHITE";
 				   else board[i][j].color = "BLACK";
 			   }
 		   }
 	   }
    }
    void show() {
    	System.out.println("  a b c d e f g h");
    	//System.out.println("  - - - - - - - -");
    	for(int i = 0 ; i < 8;i++) {
    		System.out.print(i+1);
    		System.out.print('|');
    		for(int j =0; j < 8; j ++) {
    			if (board[i][j] != null) {
    				if(board[i][j] instanceof Knight) {
    					 System.out.print("Г ");
    				}
    				else if (board[i][j] instanceof Pawn) {
    					System.out.print("П ");
    				}
    				else if (board[i][j] instanceof Rock) {
    					System.out.print("U ");
    				}
    				else if (board[i][j] instanceof Bishop) {
    					System.out.print("I ");
    				}
    				else if (board[i][j] instanceof Queen) {
    					System.out.print("Q ");
    				}else{
    					System.out.print("K ");
    				}
    			}
    			else System.out.print("0 ");
    		}
    		System.out.println();
    	}
    }
    void swap(Position a, Position b) {
    	int a1 = a.getPositionx(),a2 = a.getPositiony(),b1 = b.getPositionx(),b2 = b.getPositiony();
    	board[b2][b1] = board[a2][a1];
    	Position p = new Position(b1,b2);
    	board[b2][b1].setPosition(p);
    	board[a2][a1] = null;
    }
    void choose(int x1,int y1) {
		Scanner myObj = new Scanner(System.in);
    	System.out.println("What do you choose Bishop or Knight or Queen or Rock");
    		String s = myObj.nextLine();
    		Position p = new Position(y1,x1);
    		if(s.equals("Bishop")) {
    			board[x1][y1] = new Bishop(p);
    			board[x1][y1].color = "WHITE";
    		}
    		else if(s.equals("Knight")) {
    			board[x1][y1] = new Knight(p);
    			board[x1][y1].color = "WHITE"; 			
    		}
    		else if(s.equals("Queen")) {
    			board[x1][y1] = new Queen(p);
    			board[x1][y1].color = "WHITE";
    		}
    		else {
    			board[x1][y1] = new Rock(p);
    			board[x1][y1].color = "WHITE";
    		}
    		flag = !flag;
    }
    public boolean checkHorVer() {
		return flag;
    }
    public boolean checkDiag() {
    	return false;
    }
    public boolean  betweenElements(int x, int y,int x1, int y1) {
		if (board[x][y] instanceof Rock) {
		     if(!checkHorVer()) return true;
		}
		else if (board[x][y] instanceof Bishop) {
			  if(!checkDiag()) return true;
		}
		else if (board[x][y] instanceof Queen) {
			if (!checkHorVer() || !checkDiag()) return true;
		}
		else if (board[x][y] instanceof Pawn) {
			if(Math.abs(y1-y) == 2) {
				if(board[(x1+x)/2][y] == null) return true;
			}
		}
		return false;
    }
    void move(String s1,String s2) {
    	 if(flag) {
    	     Position p1 = new Position(s1);
	         Position p2 = new Position(s2);
	         int y = p1.getPositionx(),x = p1.getPositiony(),y1 = p2.getPositionx(),x1 = p2.getPositiony();
	         if (board[x][y].isLegalMove(p2) && board[x][y].color.equals("WHITE")) {
	        	 //if (!betweenElements(x,y,x1,y1)) {
    			 //    System.out.println("error");
	        		// return;
	        	 //}
	        	 if (x1 == 0 && board[x][y] instanceof Pawn) {
	        		 choose(x1, y1);
	        		 board[x][y] = null;
		    		 show();
		    		 return;
	        	 }
	        	 else if(board[x1][y1] != null) {
	    		     if(board[x1][y1].color.equals("WHITE")) {
	    			     System.out.println("error");
	    			     return;
	    		     }
	    		     // x means row y means character
	    		     if (board[x][y] instanceof Pawn ) {
	    		    	 if (y == y1) {
	    			       System.out.println("error");
	    			       return;
	    		    	 }
	    		     }
	    	     }
	    	     swap(p1,p2);
	    	     show();
	         }
	         else {
	    	     System.out.println("error");
	    	     return;
	         }
		     flag = !flag;
        }
    	 else {
    		 Position p1 = new Position(s1);
		     Position p2 = new Position(s2);
		     int y = p1.getPositionx(),x = p1.getPositiony(),y1 = p2.getPositionx(),x1 = p2.getPositiony();
		     if (board[x][y].isLegalMove(p2) && board[x][y].color.equals("BLACK")  ) {
	        	 if (x1 == 7 && board[x][y] instanceof Pawn) {
	        		 choose(x1, y1);
	        		 board[x][y] = null;
		    		 show();
		    		 return;
	        	 }
		    	 if(board[x1][y1] != null) {
		    		 if(board[x1][y1].color.equals("BLACK")) {
		    			 System.out.println("error");
		    			 return;
		    		 }
		    	
	    		     if (board[x][y] instanceof Pawn) {
	    		    	 if(y == y1) {
	    			     System.out.println("error");
	    			     return;
	    		    	 }
	    		     }
		    	 }
 		    	 swap(p1,p2);
		    	 show();
		     }
		     else {
		    	 System.out.println("error");
		    	 return;
		     }
			 flag = !flag;
    	 }
    }
}

/*
 * minuses
 1) between elements
 2) check
 3) checkmate
 4) castling
 pluses
 choosing elements when pawn go to the 1st line
*/
