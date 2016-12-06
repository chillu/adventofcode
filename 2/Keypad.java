/**
 * Represents an arbitrarily sized keypad,
 * with a current position "cursor" and the ability to move
 * this cursor around the keypad.
 *
 * Example (posX: 1, posY: 1)
 * 1  2  3
 * 4 (5) 6
 * 7  8  9
 *
 * Example after moveUp() is called (posX: 1, posY: 0):
 * 1 (2) 3
 * 4  5  6
 * 7  8  9
 */
public class Keypad {

	private int sizeX;
	private int sizeY;
	private int posX;
	private int posY;

	public Keypad(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		// start in the middle
		this.posX = (int)Math.floor((double)sizeX / 2);
		this.posY = (int)Math.floor((double)sizeY / 2);
	}

	public void moveUp() {
		this.posY = (this.posY > 0) ? this.posY - 1 : 0;
	}

	public void moveDown() {
		this.posY = (this.posY < this.sizeY-1) ? this.posY + 1 : this.sizeY-1;
	}

	public void moveLeft() {
		this.posX = (this.posX > 0) ? this.posX - 1 : 0;
	}

	public void moveRight() {
		this.posX = (this.posX < this.sizeX-1) ? this.posX + 1 : this.sizeX-1;
	}

	public int getNumber() {
		return (this.posY) * this.sizeY + this.posX + 1;
	}

}