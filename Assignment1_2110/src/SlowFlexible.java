public class SlowFlexible extends SlowPiece{
    public SlowFlexible (String name, String colour, int[] position){
        super ( name, colour, position);
    }

    @Override
    public String move(String direction) {
        if(direction.equals("down")){
            if (super.getPosition()[0]<8){
                int[] array = super.getPosition();
                array[0]++;
                super.setPosition(array);
            }

        }
        else if (direction.equals("up")){
            if(super.getPosition()[0] > 0){
                int[] array = super.getPosition();
                array[0]--;
                super.setPosition(array);
            }
        }
        else super.move(direction);
        return direction;
    }
    @Override
    public String toString(){return super.toString() + "S";}
}
