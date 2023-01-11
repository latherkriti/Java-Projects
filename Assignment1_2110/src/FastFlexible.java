public class FastFlexible extends FastPiece{
    public FastFlexible(String name, String colour, int[] position ){
        super(name, colour, position);
    }
    public void move(String direction, int n) {
        if (direction.equals("down")) {
            if (super.getPosition()[0] + n <= 8) {
                int[] array = super.getPosition();
                array[0] += n;
                super.setPosition(array);
            }
        }
        if (direction.equals("down")) {
            if (super.getPosition()[0] + n <= 8) {
                int[] array = super.getPosition();
                array[0] += n;
                super.setPosition(array);
            }
        } else if (direction.equals("up")) {
            if (super.getPosition()[0] - n >= 0) {
                int[] array = super.getPosition();
                array[0] -= n;
                super.setPosition(array);
            }
        } else super.move(direction, n);


    }
    @Override
    public String toString(){
        return super.toString()+"F";
    }
}
