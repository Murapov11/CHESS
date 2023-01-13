package CHESS;

public class King extends Piece{
    King(){
    	
    }
    King(Position p){
    	pos = p;
    }
	public boolean isLegalMove(Position position) {
		if (!position.rightPos()) return false;
		return (Math.abs(pos.xx - position.xx) == 1 || Math.abs(pos.yy - position.yy) == 1);
	}
	@Override
	public void setPosition(Position position) {
		pos = position;
	}
}
