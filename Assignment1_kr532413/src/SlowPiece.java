public class SlowPiece extends Piece {
    /**
     * Instance Variables
     * @param name
     * @param colour
     * @param position
     */
    public SlowPiece(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    /**
     * pieces move left or right by 1 step at a time
     * toString() Method
     * @param direction
     * @return
     */
    public String move(String direction) {
        if (direction.equals("right")) {
            moveRight();
        } else if (direction.equals("left")) {
            moveLeft();
        }
        {
            return
                    super.toString() + "S";
        }
    }

    public void moveLeft() {
        if (super.getPosition()[1] > 0) {
            int[] array = super.getPosition();
            array[1]--;
            super.setPosition(array);
        } else {
            System.out.println("Illegal Commands");
        }
    }

    /**
     * moving the pieces to the right
     */
    public void moveRight() {
        if (super.getPosition()[1] < 8) {
            int[] array = super.getPosition();
            array[1]++;
            super.setPosition(array);
        }
    }
}

