import java.util.Scanner;

public class GameDemo {
    /**
     * Scanning the input command
     * @param args
     */
    public static void main(String[] args) {
        Scanner kr_input = new Scanner(System.in);
        System.out.println("Enter a command (type help for details)");
        String command = "";
        Board board = new Board();
        /**
         * The below statements could have been printed by /n command
         * but due to lot of integrities I have used a different method
         */
        while (!(command = kr_input.nextLine()).equals("exit")) {
            if (command.equals("help")) {
                System.out.println("Possible commands are as follows:");
                System.out.println("create location[fast][flexible]: Creates a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece.");
                System.out.println("print: Displays the board.");
                System.out.println("help: Displays help.");
                System.out.println("exit: Exits the program.");
                /**
                 * method of Displaying
                 */
            } else if (command.equals("print")) {
                board.Display();
                /**
                 * Spliting command display
                 */
            } else if (command.split(" ")[0].equals("create")) {
                createPlay(command, kr_input, board);
                /**
                 * moving command
                 */
            } else if (command.split(" ")[0].equals("move")) {
                movePlay(command, board);
            }
            System.out.println("Enter a command(type help for details)");
        }
        System.out.println("Done");
    }

    public static void createPlay(String command, Scanner kr_input, Board board) {

        String[] array = command.split(" ");
        if (array.length < 3) {
            return;
        }
        int kr_pos[] = new int[2];
        kr_pos[0] = Integer.parseInt(array[1]);
        kr_pos[1] = Integer.parseInt(array[2]);
        /**
         * Taking inputs
         */
        System.out.println("Input a name for the new piece:");
        String name = kr_input.nextLine();
        System.out.println("Input a colour for the new piece:");
        String colour = kr_input.nextLine();
        /**
         * array lengths.
         */
        if (array.length == 3) {
            SlowPiece slow_piece = new SlowPiece(name, colour, kr_pos);
            board.Add(slow_piece);
        } else if (array.length == 4) {
            if (array[3].equals("fast")) {
                FastPiece fast_piece = new FastPiece(name, colour, kr_pos);
                board.Add(fast_piece);
            }
            if (array[3].equals("flexible")) {
                SlowFlexible slow_flexible = new SlowFlexible(name, colour, kr_pos);
                board.Add(slow_flexible);
            }
        } else if (array[3].equals("fast") && array.length == 5 && array[4].equals("flexible")) {
            FastFlexible fast_flexible = new FastFlexible(name, colour, kr_pos);
            board.Add(fast_flexible);
        } else {
            System.out.println("failed create");
        }
    }

    /**
     * moveplay methods
     * @param command
     * @param board
     */
    public static void movePlay(String command, Board board) {
        String[] array = command.split(" ");
        if (array.length < 3) {
            return;
        }
        int xpos = Integer.parseInt(array[1]);
        int ypos = Integer.parseInt(array[2]);
        if (array.length == 3) {
            /**
             * print methods
             */
            System.out.println("Error, there is no parameter direction");
        } else if (array.length == 4) {
            board.move(xpos, ypos, array[3], 1);
        } else if (array.length == 5) {
            int n = Integer.parseInt(array[4]);
            board.move(xpos, ypos, array[3], n);
        }
    }
}
