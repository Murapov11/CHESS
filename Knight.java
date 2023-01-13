package CHESS;

public class Knight extends Piece {
	Piece p;
    Knight(){
    	
    }
    Knight(Position p){
    	super();
    	pos = p;
    }
	public boolean isLegalMove(Position position) {
		if (!position.rightPos()) return false;
		if ((Math.abs(pos.xx-position.xx) == 2 && Math.abs(pos.yy-position.yy) == 1) ||((Math.abs(pos.xx-position.xx) == 1 && Math.abs(pos.yy-position.yy) == 2) )){
			return true;
		}
		return false;
	}
	@Override
	public void setPosition(Position position) {
      pos = position;		
	}
}
