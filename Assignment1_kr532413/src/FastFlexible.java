/**
 * Implementing Inheritance
 */
public class FastFlexible extends FastPiece {
    /**
     * fields of piece class
     * @param name
     * @param colour
     * @param position
     */
    public FastFlexible(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    /**
     * move method to move pieces left or right
     * @param direction
     * @param n
     */
    public void move(String direction, int n) {
        if (direction.equals("down")) {
            moveDown(n);
        } else if (direction.equals("up")) {
            moveUp(n);
        } else {
            super.move(direction, n);
        }
    }

    /**
     * flexible method moves the pieces up and down
     * @param n
     */
    public void moveUp(int n) {
        if (super.getPosition()[0] - n >= 0) {
            int[] array = super.getPosition();
            array[0] -= n;
            super.setPosition(array);
        }
    }

    public void moveDown(int n) {
        if (super.getPosition()[0] + n <= 8) {
            int[] array = super.getPosition();
            array[0] += n;
            super.setPosition(array);
        }
    }

    /**
     * toString() method
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "F";
    }
}
