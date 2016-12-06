/**
 * Represents an arbitrarily sized keypad,
 * with a current position "cursor" and the ability to move
 * this cursor around the keypad.
 *
 * Based on a matrix which can contain zero values,
 * declaring "edges" that the cursor can't move onto.
 *
 * Example (posX: 1, posY: 1)
 * 0  1  0
 * 2 (3) A
 * 0  B  0
 */
public class MatrixKeypad {

	private String[][] matrix;
	private int sizeX;
	private int sizeY;
	private int posX;
	private int posY;

	public MatrixKeypad(String[][] matrix, int posX, int posY) {
		this.matrix = matrix;
		this.sizeX = matrix[0].length;
		this.sizeY = matrix.length;
		this.posX = posX;
		this.posY = posY;
	}

	public void moveUp() {
		int posY = (this.posY > 0) ? this.posY - 1 : 0;
		if(isValid(this.posX, posY)) {
			this.posY = posY;
		}
	}

	public void moveDown() {
		int posY = (this.posY < this.sizeY-1) ? this.posY + 1 : this.sizeY-1;
		if(isValid(this.posX, posY)) {
			this.posY = posY;
		}
	}

	public void moveLeft() {
		int posX = (this.posX > 0) ? this.posX - 1 : 0;
		if(isValid(posX, this.posY)) {
			this.posX = posX;
		}
	}

	public void moveRight() {
		int posX = (this.posX < this.sizeX-1) ? this.posX + 1 : this.sizeX-1;
		if(isValid(posX, this.posY)) {
			this.posX = posX;
		}
	}

	public String getSymbol() {
		// System.out.println(this.posX);
		// System.out.println(this.matrix[this.posY][this.posX]);
		return this.matrix[this.posY][this.posX];
	}

	public boolean isValid(int posX, int posY) {
		return this.matrix[posY][posX] != "0";
	}

}