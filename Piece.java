package CHESS;

import java.util.Objects;

public abstract class Piece {
   // fields
   public Position pos;
   public String color;
   // Constructors
   Piece(){
	   
   }
   Piece(Position position){
	   pos = position;
   }
   // abstract method:
   public abstract void setPosition(Position position);
   public abstract boolean isLegalMove(Position position);
   // toString method:
   public String toString() {
	   return  pos.toString();
   }
   //equals method
   public boolean equals(Object o) {
   	if (this == o) return true;
   	if (o == null) return false;
   	if (this.getClass() != o.getClass()) return false;
   	Piece piece = (Piece) o;
   	return    pos.equals(piece.pos);
   }
   // hashCode() method
   public int hashCode() {
   	   return Objects.hash(pos);
   }
}
