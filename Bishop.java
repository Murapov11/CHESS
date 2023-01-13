package CHESS;

public class Bishop extends Piece {
    Bishop(){
    	
    }
    Bishop(Position p){
    	pos = p;
    }
	public boolean isLegalMove(Position position) {
		if (!position.rightPos()) return false;
		if (position.xx > pos.xx && position.yy > pos.yy) {// xx it is arip yy it is digit
			return (pos.xx - pos.yy == position.xx - position.yy);
		}
		else if (position.xx > pos.xx) {
			return (pos.xx + pos.yy == position.xx + position.yy);
		}
		else if (position.yy > pos.yy) {
			return (pos.xx + pos.yy == position.xx + position.yy);
		}
		else return (pos.xx - pos.yy == position.xx - position.yy);
	}
	@Override
	public void setPosition(Position position) {
            pos = position;		
	}
}
