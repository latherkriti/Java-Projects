public class FastPiece extends Piece{
    public FastPiece ( String name, String colour, int[] position){
        super ( name, colour, position);
    }
    public void move( String direction, int n){
        if (direction.equals("left")){
            if(super.getPosition()[1] - n >= 0){
                int[] array = super.getPosition();
                array[1] -= n;
                super.setPosition(array);
            }
        }
        else if (direction.equals("right")){
            if(super.getPosition()[1] + n <= 8){
                int[] array = super.getPosition();
                array[1] += n;
                super.setPosition(array);
            }
        }
        else System.out.println("illegal command");

    }
    @Override
    public String toString(){
        return super.toString()+"F";
    }
}
