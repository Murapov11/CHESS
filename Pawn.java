package CHESS;

public class Pawn extends Piece {
    Pawn(){
    	
    }
    Pawn(Position p){
    	pos = p;
    }
    public void setPosition(Position position) {
    	pos = position;
    }
	public boolean isLegalMove(Position position) {
		if (!position.rightPos()) return false;
		else if (pos.yy == 1 && color.equals("BLACK")) {
        	return position.xx == pos.xx && (position.yy == 2 || position.yy == 3);
        }
		else if (pos.yy == 6 && color.equals("WHITE")) {
        	return position.xx == pos.xx && (position.yy == 5 || position.yy == 4);
        }
		else if(Math.abs(position.xx-pos.xx) == 1 && (position.yy - pos.yy) == 1 && color.equals("BLACK")) {
    		return true;
    	}
		else if(Math.abs(position.xx-pos.xx) == 1 && (position.yy - pos.yy) == -1 && color.equals("WHITE")) {
			return true;
		}
    	return position.xx == pos.xx && (Math.abs(position.yy - pos.yy) == 1);
	}
}


