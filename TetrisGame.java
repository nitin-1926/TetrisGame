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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        this.verNo = verNo;
    }
    public void generateVer() 
    {

    }
    public boolean checkDown(char mainboard[][]) 
    {
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        super.changeVer(verNo, mainboard);
        	//x[0] , y[0] is constant
        	mainboard[x[3]][y[3]]=' ';
        	mainboard[x[1]][y[1]]=' ';
        	mainboard[x[2]][y[2]]=' ';
        	int temp;

        	temp=x[3];
        	x[3]=y[3];
        	y[3]=temp;

        	temp=x[1];
        	x[1]=y[1];
        	y[1]=temp;

        	temp=x[2];
        	x[2]=y[2];
        	y[2]=temp;
    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 3, 4};
        y = new int[] {1, 1, 1, 1};
    }
    public boolean checkDown(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[1] + 1][y[1]] == '#' || mainboard[x[2] + 1][y[2]] == '#' 
 		|| mainboard[x[3] + 1][y[3]] == '#')) 
 		{
            return true;
        }
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && mainboard[x[0]][y[0] - 1] == '#') 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] + 1] == '#' || mainboard[x[1]][y[1] + 1] == '#' || mainboard[x[2]][y[2] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && mainboard[x[3]][y[3] - 1] == '#') 
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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        super.changeVer(verNo, mainboard);
    }
    public void generateVer() 
    {
        x = new int[] {1, 1, 2, 2};
        y = new int[] {1, 2, 1, 2};
    }
    public boolean checkDown(char mainboard[][]) 
    {
        if(mainboard[x[2] + 1][y[2]] == '#' || mainboard[x[3] + 1][y[3]] == '#') 
            return true;
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        if(mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#') 
            return true;
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
    {
        if(mainboard[x[1]][y[1] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')
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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        super.changeVer(verNo,mainboard);
        //x[3],y[3] is fixed
        if(verNo == 1)	//4->1
        {
        	mainboard[x[0]][y[0]]=' ';
        	mainboard[x[1]][y[1]]=' ';
        	mainboard[x[2]][y[2]]=' ';
        	int temp;

        	temp=x[0];
        	x[0]=y[0];
        	y[0]=temp;

        	temp=x[1];
        	x[1]=y[1];
        	y[1]=temp;

        	temp=x[2];
        	x[2]=y[2];
        	y[2]=temp;
        }
        else if(verNo==2)	//1->2
        {
    	  	mainboard[x[0]][y[0]]=' ';
        	mainboard[x[1]][y[1]]=' ';
        	mainboard[x[2]][y[2]]=' ';
        	int temp;

        	temp=x[0];
        	x[0]=y[0];
        	y[0]=temp;
        	y[0]+=2;

        	temp=x[1];
        	x[1]=y[1];
        	y[1]=temp;
        	y[1]+=2;

        	temp=x[2];
        	x[2]=y[2];
        	y[2]=temp;
        	y[2]+=2;
        }
        else if(verNo==3)	//2->3
        {
        	mainboard[x[0]][y[0]]=' ';
        	mainboard[x[1]][y[1]]=' ';
        	mainboard[x[2]][y[2]]=' ';
        	int temp;

        	temp=x[0];
        	x[0]=y[0];
        	y[0]=temp;

        	temp=x[1];
        	x[1]=y[1];
        	y[1]=temp;

        	temp=x[2];
        	x[2]=y[2];
        	y[2]=temp;	
        }
        else if(verNo == 4)   //3->4
        {
        	mainboard[x[0]][y[0]]=' ';
        	mainboard[x[1]][y[1]]=' ';
        	mainboard[x[2]][y[2]]=' ';
        	int temp;

        	temp=x[0];
        	x[0]=y[0];
        	y[0]=temp;
        	y[0]-=2;

        	temp=x[1];
        	x[1]=y[1];
        	y[1]=temp;
        	y[1]-=2;

        	temp=x[2];
        	x[2]=y[2];
        	y[2]=temp;
        	y[2]-=2;
        }
    }
    public void generateVer() 
    {
        x = new int[] {1, 1, 1, 2};
        y = new int[] {1, 2, 3, 2};
    }
    public boolean checkDown(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[2] + 1][y[2]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( mainboard[x[2] + 1][y[2]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[1] + 1][y[1]] == '#' || mainboard[x[2] + 1][y[2]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[3] + 1][y[3]] == '#'))
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[2]][y[2]- 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[2]][y[2] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        super.changeVer(verNo, mainboard);

    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 3, 3};
        y = new int[] {1, 1, 1, 2};
    }
    public boolean checkDown(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[2] + 1][y[2]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && ( mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[1] + 1][y[1]] == '#' || mainboard[x[2] + 1][y[2]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[1] + 1][y[1]] == '#' || mainboard[x[2] + 1][y[2]] == '#' ))
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] + 1] == '#' || mainboard[x[1]][y[1] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0]][y[0] + 1] == '#' || mainboard[x[1]][y[1] + 1] == '#' || mainboard[x[2]][y[2] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
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
    public void changeVer(int verNo, char mainboard[][]) 
    {
        super.changeVer(verNo, mainboard);
    }
    public void generateVer() 
    {
        x = new int[] {1, 2, 2, 3};
        y = new int[] {1, 1, 2, 2};
    }
    public boolean checkDown(char mainboard[][]) 
    {
        if((verNo == 1 || verNo == 3 ) && (mainboard[x[1] + 1][y[1]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        } 
        else if((verNo == 2 || verNo == 4 ) && ( mainboard[x[0] + 1][y[0]] == '#' || mainboard[x[2] + 1][y[2]] == '#' || mainboard[x[3] + 1][y[3]] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkLeft(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
    public boolean checkRight(char mainboard[][]) 
    {
        if(verNo == 1 && (mainboard[x[0]][y[0] + 1] == '#' || mainboard[x[2]][y[2] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 2 && (mainboard[x[0]][y[0] - 1] == '#' || mainboard[x[2]][y[2] - 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 3 && (mainboard[x[0]][y[0] + 1] == '#' || mainboard[x[1]][y[1] + 1] == '#' || mainboard[x[3]][y[3] + 1] == '#')) 
        {
            return true;
        } 
        else if(verNo == 4 && (mainboard[x[1]][y[1] - 1] == '#' || mainboard[x[3]][y[3] - 1] == '#')) 
        {
            return true;
        }
        return false;
    }
}

public class TetrisGame
{
    public static char mainboard[][] = new char[20][20];
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
        initmainboard();
        while(true) 
        {
        	// if(currentShapeNo==1)
        	// 	currentShape = line;
        	// else if(currentShapeNo==2)
        	// 	currentShape = square;
        	// else if(currentShapeNo==3)
        	// 	currentShape = t;
        	// else if(currentShapeNo==4)
        	// 	currentShape = l;
        	// else
        	// 	currentShape = z;
        	currentShape=t;
            drawOnmainboard(currentShape);
            displaymainboard();
            choice = scanner.next().charAt(0);
            if (choice == 'm')
            {
            	if(currentVer>4)
            	{
            		currentVer=1;
            	}
            	else
            		currentVer++;
                currentShape.changeVer(currentVer,mainboard);
                undoStack.push("m");
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
    public static void initmainboard() 
    {
        for(int i = 0;i<mainboard.length;i++) 
        {
            for(int j = 0;j<mainboard[i].length;j++) 
            {
                if(i == 0 || j == 0 || i == mainboard.length - 1 || j == mainboard.length - 1 )
                    mainboard[i][j] = '*';
                else
                    mainboard[i][j] = ' ';
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
    public static void drawOnmainboard(Versions V) 
    {
        for(int i = 0;i<V.x.length;i++) 
        {
            mainboard[V.x[i]][V.y[i]] = '#';
        }
    } 
    public static void displaymainboard() 
    {
        for(char arr[]:mainboard) 
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
        if(V.x[0] == (mainboard.length - 2) || V.x[1] == (mainboard.length - 2) || V.x[2] == (mainboard.length - 2) || V.x[3] == (mainboard.length - 2) || V.checkDown(mainboard)) 
        {
            for(int i=0;i<V.x.length;i++ ) 
            {
                hashCount[i]++;
                if(hashCount[i] == mainboard.length - 2) 
                {
                    hashCount[i] = 0;
                    int j;
                    for(j = i;j>1 && hashCount[j - 1] != 0;j--) 
                    {
                        mainboard[j] = mainboard[j-1];
                    }
                    mainboard[j] = new char[20];
                    mainboard[j][0] = '*';
                    mainboard[j][mainboard.length - 1] = '*';
                    // displaymainboard();
                }
            }
            V.generateVer();
            currentShapeNo = (int)(Math.random() * 5) + 1;
            return;
        }
        for(int i = 0;i<V.x.length;i++) 
        {
            mainboard[V.x[i]][V.y[i]] = ' ';
            V.x[i]++;
        }   
    }
    public static void moveLeft(Versions V) 
    {
        if(V.y[0] == 1 || V.y[1] == 1 || V.y[2] == 1 || V.y[3] == 1 || V.checkLeft(mainboard))
            return;
        for(int i = 0;i<V.x.length;i++) 
        {
            mainboard[V.x[i]][V.y[i]] = ' ';
            V.y[i]--;
        }
        
    }
    public static void moveRight(Versions V) 
    {
        if(V.y[0] == (mainboard.length - 2) || V.y[1] == (mainboard.length - 2) || V.y[2] == (mainboard.length - 2) || V.y[3] == (mainboard.length - 2) || V.checkRight(mainboard))
            return;
        for(int i = 0;i<V.x.length;i++) 
        {
            mainboard[V.x[i]][V.y[i]] = ' ';
            V.y[i]++;
        } 
    }
    public static void undoStep(String choice, Versions V) 
    {
        if(choice.equals("s")) 
        {
            for(int i = 0;i<V.x.length;i++) 
            {
                mainboard[V.x[i]][V.y[i]] = ' ';
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
        else if(choice.equals("m")) 
        {
            currentVer--;
            V.changeVer(currentVer, mainboard);   
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
        else if(choice.equals("m")) 
        {
            currentVer++;
            V.changeVer(currentVer, mainboard);   
        }
    }
}