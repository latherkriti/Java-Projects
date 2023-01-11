public class SlowPiece extends Piece {
    public SlowPiece ( String name, String colour, int[] position){
        super (name, colour, position);
    }

    public String move(String direction) {
        if (direction.equals("right")) {
            if (super.getPosition()[1] < 8) {
                int[] array = super.getPosition();
                array[1]++;
                super.setPosition(array);
            }
        } else if (direction.equals("left")) {
            if (super.getPosition()[1] > 0) {
                int[] array = super.getPosition();
                array[1]--;
                super.setPosition(array);
            } else {
                System.out.println("Illegal Commands");
            }
        }
        String toString;
        {
            return
                    super.toString() + "S";
        }
    }
}
