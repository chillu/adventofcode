public class KeypadProcess {

	public static void main(String[] args) {
		Keypad pad = new Keypad(3, 3);
		String[] directions = args[0].split(",");
		for(String direction : directions) {
			for(int i = 0; i < direction.length(); i++) {
				String move = direction.charAt(i) + "";
				switch(move) {
					case "U":
						pad.moveUp();
						break;
					case "D":
						pad.moveDown();
						break;
					case "L":
						pad.moveLeft();
						break;
					case "R":
						pad.moveRight();
						break;
				}
				// System.out.println(move);
				// System.out.println(pad.getNumber());
			}
			System.out.print(pad.getNumber());
		}
	}

}