public class MatrixKeypadProcess {

	public static void main(String[] args) {
		String[][] matrix = {
			{"0","0","1","0","0"},
			{"0","2","3","4","0"},
			{"5","6","7","8","9"},
			{"0","A","B","C","0"},
			{"0","0","D","0","0"}
		};
		MatrixKeypad pad = new MatrixKeypad(matrix, 0, 2);
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
			}
			System.out.print(pad.getSymbol());
		}
	}

}