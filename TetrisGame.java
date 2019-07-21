import java.lang.*;
import java.util.*;
import java.io.IOException;

class Points 
{
    int x[];
    int y[];
}
class Versions extends Points 
{
    public int verNo;
    Versions() 
    { 
    	this.verNo = 1; 
	}
    Versions(int verNo) 
    {
        this.verNo = verNo;
    }
    public void changeVer(int verNo) 
    {
        this.verNo = verNo;
    }
    public void generateVer() 
    {

    }
    public boolean checkDown(char board[][]) 
    {
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        return false;
    }
}
class Line extends Versions 
{
    Line() 
    {
        x = new int[] {1, 2, 3, 4};
        y = new int[] {1, 1, 1, 1};
    }
    public void changeVer(int verNo) 
    {
        super.changeVer(verNo);
        int tempVar;
        for(int i = 0;i<x.length;i++) 
        {
            tempVar = x[i];
            x[i] = y[i];
            y[i] = tempVar;
        }
    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 3, 4};
        y = new int[] {1, 1, 1, 1};
    }
    public boolean checkDown(char board[][]) 
    {
        if(verNo == 1 && (board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( board[x[0] + 1][y[0]] == '#' || board[x[1] + 1][y[1]] == '#' || board[x[2] + 1][y[2]] == '#' 
 		|| board[x[3] + 1][y[3]] == '#')) 
 		{
            return true;
        }
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && board[x[0]][y[0] - 1] == '#') 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] + 1] == '#' || board[x[1]][y[1] + 1] == '#' || board[x[2]][y[2] + 1] == '#' || board[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && board[x[3]][y[3] - 1] == '#') 
        {
            return true;
        }
        return false;
    }
}

class Square extends Versions 
{
    Square() 
    {
        x = new int[] {1, 1, 2, 2};
        y = new int[] {1, 2, 1, 2};
    }
    public void changeVer(int verNo) 
    {
        super.changeVer(verNo);
    }
    public void generateVer() 
    {
        x = new int[] {1, 1, 2, 2};
        y = new int[] {1, 2, 1, 2};
    }
    public boolean checkDown(char board[][]) 
    {
        if(board[x[2] + 1][y[2]] == '#' || board[x[3] + 1][y[3]] == '#') 
            return true;
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        if(board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#') 
            return true;
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        if(board[x[1]][y[1] + 1] == '#' || board[x[3]][y[3] + 1] == '#')
            return true;
        return false;
    }
}

class T extends Versions 
{
    int tempVar[] = new int[4];
    public T() 
    {
        x = new int[] {1, 1, 1, 2};
        y = new int[] {1, 2, 3, 2};
    }
    public void changeVer(int verNo) 
    {
        super.changeVer(verNo);
        int length = y.length;
        if(verNo == 1) // 4 -> 1
        { 
            for (int i = 0; i<length; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i];
            }

            for(int i = 0;i<length - 1;i++) 
            {
                y[i] = tempVar[length - (i+2)];
            }

            y[length - 1] = x[length - 1];
        } 
        else if(verNo == 2) // 1 -> 2
        { 
            int max = -32768;
            for (int i = 0; i<length; i++) 
            {
                x[i] = y[i];
                max = max > y[i] ? max : y[i];
            }
            for(int i = 0;i<length - 1;i++) 
            {
                y[i] = max;
            }

            y[length - 1] = x[length - 1];
        } 
        else if(verNo == 3) // 2 -> 3
        { 
            for (int i = 0; i<length; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i];
            }
            for(int i = 0;i<length - 1;i++) 
            {
                y[i] = tempVar[length - (i+2)];
            	y[length - 1] = x[length - 1];
            }
            y[length - 1] = x[length - 1];
        } 
        else if(verNo == 4) // 3 -> 4
        { 
            int min = 32768;
            for (int i = 0; i<length; i++) 
            {
                x[i] = y[i];
                min = min < y[i] ? min : y[i];
            }
            for(int i = 0;i<length - 1;i++) 
            {
                y[i] = min;
            }
            y[length - 1] = x[length - 1];
        }
    }
    public void generateVer() 
    {
        x = new int[] {1, 1, 1, 2};
        y = new int[] {1, 2, 3, 2};
    }
    public boolean checkDown(char board[][]) 
    {
        if(verNo == 1 && (board[x[0] + 1][y[0]] == '#' || board[x[2] + 1][y[2]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( board[x[2] + 1][y[2]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0] + 1][y[0]] == '#' || board[x[1] + 1][y[1]] == '#' || board[x[2] + 1][y[2]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[0] + 1][y[0]] == '#' || board[x[3] + 1][y[3]] == '#'))
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[2]][y[2]- 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        if(verNo == 1 && (board[x[2]][y[2] + 1] == '#' || board[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0]][y[0] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
}

class L extends Versions 
{
    public L() 
    {
        x = new int[] {1, 2, 3, 3};
        y = new int[] {1, 1, 1, 2};
    }
    public void changeVer(int verNo) 
    {
        super.changeVer(verNo);
        int length = y.length;
        if(verNo == 1) // 4 -> 1
        { 
            int min = 32768;
            for (int i = 0; i<length ; i++) 
            {
                min = min < x[i] ? min : x[i];
                x[i] = y[i];
            }
            for(int i = 0; i<length - 1; i++) 
            {
                y[i] = min;
            }
            y[length - 1] = min + 1;
        } 
        else if(verNo == 2) // 1 -> 2
        { 
            int max = -32768;
            for (int i = 0; i<length ; i++) 
            {
                max = max > x[i] ? max : x[i];
                x[i] = y[i];
            }
            max++;
            for(int i = 0; i<length - 1; i++) 
            {
                y[i] = max--;
            }
            y[length - 1] = max + 1;
        } 
        else if(verNo == 3) // 2 -> 3
        { 
            int max = -32768;
            for (int i = 0; i<length ; i++) 
            {
                max = max > x[i] ? max : x[i];
                x[i] = y[i];
            }
            for(int i = 0; i<length - 1; i++) 
            {
                y[i] = max;
            }
            y[length - 1] = max - 1;
        } 
        else if(verNo == 4) // 3 -> 4
        { 
            int min = 32768;
            for (int i = 0; i<length ; i++) 
            {
                min = min < x[i] ? min : x[i];
                x[i] = y[i];
            }
            min--;
            for(int i = 0; i<length - 1; i++) 
            {
                y[i] = min++;
            }
            y[length - 1] = min - 1;
        }
    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 3, 3};
        y = new int[] {1, 1, 1, 2};
    }
    public boolean checkDown(char board[][]) 
    {
        if(verNo == 1 && (board[x[2] + 1][y[2]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( board[x[0] + 1][y[0]] == '#' || board[x[1] + 1][y[1]] == '#' || board[x[2] + 1][y[2]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0] + 1][y[0]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[0] + 1][y[0]] == '#' || board[x[1] + 1][y[1]] == '#' || board[x[2] + 1][y[2]] == '#' ))
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[0]][y[0] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] + 1] == '#' || board[x[1]][y[1] + 1] == '#' || board[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[0]][y[0] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0]][y[0] + 1] == '#' || board[x[1]][y[1] + 1] == '#' || board[x[2]][y[2] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
}

class Z extends Versions
{
    public int tempVar[] = new int[4];
    public Z() 
    {
        x = new int[] {1, 2, 2, 3};
        y = new int[] {1, 1, 2, 2};
    }
    public void changeVer(int verNo) 
    {
        super.changeVer(verNo);
        int length = y.length;
        if(verNo == 1) //4 -> 1
        { 
            for (int i = 0; i<length ; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i] - 1;
            }
            for(int i = 0;i<length;i++) 
            {
                y[i] = tempVar[i];
            }
        } 
        else if(verNo == 2) // 1 -> 2
        { 
            for (int i = 0; i<length ; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i];
            }
            for(int i = 0;i<length;i++) 
            {
                y[i] = tempVar[i];
            }
        } 
        else if(verNo == 3) // 2 -> 3
        { 
            for (int i = 0; i<length ; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i] + 1;
            }
            for(int i = 0;i<length;i++) 
            {
                y[i] = tempVar[i];
            }
        } 
        else if(verNo == 4) // 3 -> 4
        { 
            for (int i = 0; i<length ; i++) 
            {
                tempVar[i] = x[i];
                x[i] = y[i];
            }
            for(int i = 0;i<length;i++) 
            {
                y[i] = tempVar[i];
            }
        }
    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 2, 3};
        y = new int[] {1, 1, 2, 2};
    }
    public boolean checkDown(char board[][]) 
    {
        if((verNo == 1 || verNo == 3 ) && (board[x[1] + 1][y[1]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if((verNo == 2 || verNo == 4 ) && ( board[x[0] + 1][y[0]] == '#' || board[x[2] + 1][y[2]] == '#' || board[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] - 1] == '#' || board[x[1]][y[1] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[1]][y[1] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char board[][]) 
    {
        if(verNo == 1 && (board[x[0]][y[0] + 1] == '#' || board[x[2]][y[2] + 1] == '#' || board[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (board[x[0]][y[0] - 1] == '#' || board[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (board[x[0]][y[0] + 1] == '#' || board[x[1]][y[1] + 1] == '#' || board[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (board[x[1]][y[1] - 1] == '#' || board[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
}

public class Tetris 
{
    public static char board[][] = new char[20][20];
    public static int hashCount[] = new int[20];
    static int currentVer = 1, currentShapeNo = 2;
    public static Stack<String> undoStack = new Stack<String>();
    public static Stack<String> redoStack = new Stack<String>();
    public static void main(String args[]) throws IOException, InterruptedException 
    {
        Scanner scanner = new Scanner(System.in);
        Line line = new Line();
        Square square = new Square();
        T t = new T();
        L l = new L();
        Z z = new Z();
        Versions currentShape = new Versions();
        char choice;
        initBoard();
        while(true) 
        {
            currentShape = currentShapeNo == 1 ? line : currentShapeNo == 2 ? square : currentShapeNo == 3 ? t : currentShapeNo == 4 ? l : z;
            drawOnBoard(currentShape);
            displayBoard();
            choice = scanner.next().charAt(0);
            if (choice == 'c') 
            {
                currentVer = currentVer > 4 ? 1 : ++currentVer;
                currentShape.changeVer(currentVer);
                undoStack.push("c");
            } 
            else if(choice == 'a') 
            {
                undoStack.push("a");
                moveLeft(currentShape);
            } 
            else if(choice == 'd') 
            {
                undoStack.push("d");
                moveRight(currentShape);
            } 
            else if(choice == 's') 
            {
                undoStack.push("s");
                moveDown(currentShape);
            } 
            else if(choice == 'z') 
            {
                if(undoStack.isEmpty()) continue ;
                undoStep(undoStack.peek(), currentShape);
                redoStack.push(undoStack.pop());
            } 
            else if(choice == 'y') 
            {
                if(redoStack.isEmpty()) continue ;
                if(redoStack.peek().equals("a"))  
                    redoStep("d", currentShape);
                else if(redoStack.peek().equals("d"))  
                    redoStep("a", currentShape);
                undoStack.push(redoStack.pop());
            } 
            else if(choice == 'p') 
            {
                printHash();
            } 
            else if(choice == 'q') 
            {
                System.out.println("Game Quitted");
                System.out.println("Your Score is: ");
                break;
            }
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
    }
    public static void initBoard() 
    {
        for(int i = 0;i<board.length;i++) 
        {
            for(int j = 0;j<board[i].length;j++) 
            {
                if(i == 0 || j == 0 || i == board.length - 1 || j == board.length - 1 )
                    board[i][j] = '*';
                else
                    board[i][j] = ' ';
            }
        }
    }
    public static void printHash() 
    {
        for(int i = 0;i<hashCount.length;i++) 
        {
            System.out.println(hashCount[i]);
        }
    } 
    public static void drawOnBoard(Versions V) 
    {
        for(int i = 0;i<V.x.length;i++) 
        {
            board[V.x[i]][V.y[i]] = '#';
        }
    } 
    public static void displayBoard() 
    {
        for(char arr[]:board) 
        {
            for(char a:arr) 
            {
                System.out.print(a);
            }
            System.out.println();
        }
    }
    public static void moveDown(Versions V) 
    {
        if(V.x[0] == (board.length - 2) || V.x[1] == (board.length - 2) || V.x[2] == (board.length - 2) || V.x[3] == (board.length - 2) || V.checkDown(board)) 
        {
            for(int i:V.x ) 
            {
                hashCount[i]++;
                if(hashCount[i] == board.length - 2) 
                {
                    hashCount[i] = 0;
                    int j;
                    for(j = i;j>1 && hashCount[j - 1] != 0;j--) 
                    {
                        board[j] = board[j-1];
                    }
                    board[j] = new char[20];
                    board[j][0] = '*';
                    board[j][board.length - 1] = '*';
                    displayBoard();
                }
            }
            V.generateVer();
            currentShapeNo = (int)(Math.random() * 5) + 1;
            return;
        }
        for(int i = 0;i<V.x.length;i++) 
        {
            board[V.x[i]][V.y[i]] = ' ';
            V.x[i]++;
        }   
    }
    public static void moveLeft(Versions V) 
    {
        if(V.y[0] == 1 || V.y[1] == 1 || V.y[2] == 1 || V.y[3] == 1 || V.checkLeft(board))
            return;
        for(int i = 0;i<V.x.length;i++) 
        {
            board[V.x[i]][V.y[i]] = ' ';
            V.y[i]--;
        }
        
    }
    public static void moveRight(Versions V) 
    {
        if(V.y[0] == (board.length - 2) || V.y[1] == (board.length - 2) || V.y[2] == (board.length - 2) || V.y[3] == (board.length - 2) || V.checkRight(board))
            return;
        for(int i = 0;i<V.x.length;i++) 
        {
            board[V.x[i]][V.y[i]] = ' ';
            V.y[i]++;
        } 
    }
    public static void undoStep(String choice, Versions V) 
    {
        if(choice.equals("s")) 
        {
            for(int i = 0;i<V.x.length;i++) 
            {
                board[V.x[i]][V.y[i]] = ' ';
                V.x[i]--;
            }
        } 
        else if( choice.equals("a")) 
        {
            moveRight(V);
        } 
        else if( choice.equals("d")) 
        {
            moveLeft(V);
        } 
        else if(choice.equals("c")) 
        {
            currentVer--;
            V.changeVer(currentVer);   
        }
    }
    public static void redoStep(String choice, Versions V) 
    {
        if(choice.equals("s")) 
        {
            moveDown(V);
        } 
        else if( choice.equals("a")) 
        {
            moveLeft(V);
        } 
        else if( choice.equals("d")) 
        {
            moveRight(V);
        } 
        else if(choice.equals("c")) 
        {
            currentVer++;
            V.changeVer(currentVer);   
        }
    }
}