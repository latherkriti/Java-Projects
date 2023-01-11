import java.util.Scanner;
public class Problem1 {
    public static void main(String args[])
    {

        Scanner scanner = new Scanner(System.in);
        int board_size = scanner.nextInt();
        char Player1Board[][] = new char[board_size][board_size];
        char Player2Board[][] = new char[board_size][board_size];
        for (int i=0;i<board_size;i++){
            for(int j=0;j<board_size;j++)
            {
                Player1Board[i][j]='-';
                Player2Board[i][j]='-';
            }
        }

        // How many boats each player will place
        int num_boat = scanner.nextInt();
        //Create One D array to hold data entered for adding boat
        // x y size orientation
        int[] boatdata =new int[4];
        //Give one turn to each player and repeat till all boats placed
        for(int turn=0;turn<num_boat;turn++)
        {
            for(int i=0;i<4;i++)
                boatdata[i] = scanner.nextInt();
            addBoat(Player1Board,boatdata[0],boatdata[1],boatdata[2],boatdata[3]);
            for(int i=0;i<4;i++)
                boatdata[i] = scanner.nextInt();
            addBoat(Player2Board,boatdata[0],boatdata[1],boatdata[2],boatdata[3]);
        }
        // Now print each players board
        printBoard(Player1Board,Player2Board);
        System.out.println();
        // Tell how may fire shots each player will fire
        int num_shots = scanner.nextInt();
        // x y data is there for each shot - shotdata
        int[] shotdata =new int[2];
        // Give num_shots turns to each player
        for(int turn=0;turn<num_shots;turn++)
        {
            for(int i=0;i<2;i++)
                shotdata[i] = scanner.nextInt();
            fireBoat(Player2Board,shotdata[0],shotdata[1]);
            for(int i=0;i<2;i++)
                shotdata[i] = scanner.nextInt();
            fireBoat(Player1Board,shotdata[0],shotdata[1]);
        }
        //Again print the board after all fires
        printBoard(Player1Board,Player2Board);
        printDecision(Player1Board,Player2Board);
        System.out.println();
    }
    // printDecision method prints decision based upon whether players still have boats
    public static void printDecision(char[][]x,char[][] y)
    {   boolean P1boats=false;  //represents whether some boats are there with
        boolean P2boats=false;
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<x[i].length;j++)
            {if (x[i][j]=='B') P1boats=true;
                if (y[i][j]=='B') P2boats=true;
            }

        }
        System.out.println();
        if(P1boats & P2boats) System.out.println("Draw!");
        if(P1boats & !P2boats) System.out.println("P1 Won!");
        if(!P1boats & P2boats) System.out.println("P2 Won!");
        if(!P1boats & !P2boats) System.out.println("All destroyed");

    }
    // Simple fire in which one fire destroys only one place
    public static void fireBoat(char[][]x, int x_coord,int y_coord)
    {
        if(x_coord>x.length || y_coord>x.length) {}
        else
        {x[x_coord][y_coord]='X';}
    }
    // Method to add boat to any Player's board
    public static void addBoat(char[][] x, int x_coord,int y_coord, int size, int orientation)
    {  // check whether the point is within the board or not
        if(x_coord>x.length-1 || y_coord>x.length-1)
        {

        }
        else
        {
            if (orientation == 0)
            {
                for(int j=0;j<size;j++)
                {  if (y_coord+j>x.length-1) break; // equivalent to shrinking boat
                    x[x_coord][y_coord+j]='B';
                }
            }
            else if(orientation == 1)
            {
                for(int i=0;i<size;i++)
                {
                    if (x_coord+i>x.length-1) break; // equivalent to shrinking boat
                    x[x_coord+i][y_coord]='B';
                }
            }

        }
    }
    // method to print Board
    public static void printBoard(char[][] x, char[][] y)
    {
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<x[i].length;j++)
            {
                System.out.print(x[i][j]);
            }
            System.out.print('\t');
            for(int j=0;j<y[i].length;j++)
            {
                System.out.print(y[i][j]);
            }
            System.out.println();

        }

    }
}
