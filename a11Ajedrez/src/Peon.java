import java.util.LinkedList;

public class Peon extends Ficha {

	private static final long serialVersionUID = 7100012578621812349L;

	public Peon(int x, int y, char c) {
		super(x, y, c,(c=='B' || c=='b')? "\u265F":"\u2659");
	}

	@Override
	public LinkedList<Posicion> posiblesPosiciones(Tablero tab) {
		
		LinkedList<Posicion> posibles = new LinkedList<Posicion>();
		Ficha[][] casillas=tab.casillas;
		
		int x = this.posicion.x;
		
		int y = this.posicion.y;
		
		
		
//		blancas
		if (this.color=='B' || this.color=='b') {
			
//			mov
//			2 saltos
			if ( y==6 && casillas[x][y-2]==null) posibles.add(new Posicion(x,y-2));
//			1 salto
			if (casillas[x][y-1]==null) posibles.add(new Posicion(x,y-1)); 
//			matar
			if (x<7 && x>0 && casillas[x+1][y-1]!=null &&  casillas[x+1][y-1].color!=this.color) posibles.add(new Posicion(x+1,y-1)); 
			if (x>0 && x<7 && casillas[x-1][y-1]!=null &&  casillas[x-1][y-1].color!=this.color) posibles.add(new Posicion(x-1,y-1)); 
			
		} else {	
//		Negras	
			
//			mov
//			2 saltos
			if (y==1 && casillas[x][y+2]==null) posibles.add(new Posicion(x,y+2));
//			1 salto
			if (casillas[x][y+1]==null) posibles.add(new Posicion(x,y+1)); 
//			matar
			if (x<7 && x>0 && casillas[x-1][y+1]!=null && casillas[x-1][y+1].color!=this.color) posibles.add(new Posicion(x-1,y+1)); 
			if (x>0 && x<7 && casillas[x+1][y+1]!=null && casillas[x+1][y+1].color!=this.color) posibles.add(new Posicion(x+1,y+1)); 							
		}		
		
		return posibles;
	}

}
