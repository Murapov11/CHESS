package CHESS;

public class Rock extends Piece{
	Rock(){
		
	}
    Rock(Position pos){
    	super();
    	this.pos = pos;
    }
	public boolean isLegalMove(Position position) {
		if (!position.rightPos()) return false;
		if (position.xx == pos.xx || position.yy == pos.yy) {
			return true;
		}
		return false;
	}
	public void setPosition(Position position) {
        pos = position;		
	}
}
