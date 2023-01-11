public class Piece {
    /**
     * instance variables
     */
    private String name;
    private String colour;
    private int[] position;

    /**
     * their constructors
     * @param name
     * @param colour
     * @param position
     */
    public Piece(String name, String colour, int[] position) {
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    /**
     * getters and setters
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * toString() Method
     * @return
     */
    @Override
    public String toString() {
        return
                name + colour;
    }
}
