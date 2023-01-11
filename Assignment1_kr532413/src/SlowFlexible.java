/**
 * SlowFlexible is subclass of SlowPiece
 */
public class SlowFlexible extends SlowPiece {
    /**
     * Instance Variables
     * @param name
     * @param colour
     * @param position
     */
    public SlowFlexible(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    /**
     * move method for pieces from up to down
     * @param direction
     * @return
     */
    @Override
    public String move(String direction) {
        if (direction.equals("down")) {
            moveDown();
        } else if (direction.equals("up")) {
            moveUp();
        } else {
            super.move(direction);
        }
        return direction;
    }

    /**
     * method moves up or down by just 1 step at a time
     */
    public void moveUp() {
        if (super.getPosition()[0] > 0) {
            int[] array = super.getPosition();
            array[0]--;
            super.setPosition(array);
        }
    }

    public void moveDown() {
        if (super.getPosition()[0] < 8) {
            int[] array = super.getPosition();
            array[0]++;
            super.setPosition(array);
        }
    }

    /**
     * toString() Method
     * @return
     */
    @Override
    public String toString() {return super.toString() + "S";}
}
