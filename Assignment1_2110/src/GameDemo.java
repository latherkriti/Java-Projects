import java.util.Scanner;
import java.util.*;
public class GameDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a command (type help for details");
        String command = input.nextLine();
        Board board = new Board();
        while ( !(command= input.nextLine()).equals("exit")){
            if(command.equals("help")){
                System.out.println("Possible commands are as follows:");
                System.out.println("create location[fast][flexible]: Creates a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece.");
                System.out.println("print: Displays the board.");
                System.out.println("help: Displays help.");
                System.out.println("exit: Exits the program.");
            }
            else if(command.equals("print")){
                board.Display();
            }
            else if(command.split(" ")[0].equals("create")){
                String[] array = command.split(" ");
                if(array.length<3)
                    return;
                int kr_pos[] = new int[2];
                kr_pos[0]=Integer.parseInt(array[1]);
                kr_pos[1]=Integer.parseInt(array[2]);
                System.out.println("Input a name for the new piece:");
                String name = input.nextLine();
                System.out.println("Input a colour for the new piece:");
                String colour = input.nextLine();

                if(array.length==3){
                    SlowPiece slow_piece = new SlowPiece(name, colour, kr_pos);
                    board.Add(slow_piece);
                }
                else if(array.length==4){
                    if(array[3].equals("fast")){
                        FastPiece fast_piece = new FastPiece(name,colour,kr_pos);
                        board.Add(fast_piece);
                    }
                    if (array[3].equals("flexible")){
                        SlowFlexible slow_flexible = new SlowFlexible(name,colour,kr_pos);
                        board.Add(slow_flexible);
                    }
                }
                else if(array[3].equals("fast")&&array.length==5&&array[4].equals("flexible")){
                    FastFlexible fast_flexible = new FastFlexible(name,colour,kr_pos);
                    board.Add(fast_flexible);
                }
                else{
                    System.out.println("failed create");
                }
            }
            else if(command.split(" ")[0].equals("move")){
                String[] array = command.split(" ");
                if(array.length<3){
                    return;
                }
                int xpos = Integer.parseInt(array[1]);
                int ypos = Integer.parseInt(array[2]);
                if(array.length==3){
                    System.out.println("Error, there is no parameter direction");
                }
                else if(array.length==4){
                    board.move(xpos,ypos,array[3],1);
                }
                else if(array.length==5){
                    int n = Integer.parseInt(array[4]);
                    board.move(xpos,ypos,array[3],n);
                }
            }
            System.out.println("Enter a command(type help for details)");
        }
        System.out.println("Done");
    }
}
