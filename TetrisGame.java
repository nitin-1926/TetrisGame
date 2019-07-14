import java.util.*;
class Board
{
	char arr[][] = new char[20][20];
	public void display()
	{
		for(int i=0;i<20;i++)
		{
			arr[i][0] = '|';
			arr[i][19] = '|';
		}
		for(int j=0;j<20;j++)
		{
			arr[0][j] = '_';
			arr[19][j] = '_';		
		}
		for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
				{
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
	}
	public void assign(Shape shape,int version,int xadd, int yadd)
	{
		for(int i=0;i<4;i++)
		{
			arr[shape.pts[version][i].x+xadd][shape.pts[version][i].y+yadd] = '#';
		}
		display();
	}
}
public class TetrisGame
{
	public static void main(String[] args)
		{
			Scanner sc = new Scanner (System.in);
			char c = '\0';

			Shape i = new Shape();
			Shape s = new Shape();
			Shape l = new Shape();
			Shape t = new Shape();
			Shape z = new Shape();
			Board b = new Board();

			// i.pts[0][0] = new Point(0,0);
			// i.pts[0][1] = new Point(1,0);
			// i.pts[0][2] = new Point(2,0);
			// i.pts[0][3] = new Point(3,0);

			// i.pts[1][0] = new Point(0,0);
			// i.pts[1][1] = new Point(0,1);
			// i.pts[1][2] = new Point(0,2);
			// i.pts[1][3] = new Point(0,3);

			// int lineversion = 0;
			// b.assign(i,lineversion,1,1);

			// s.pts[0][0] = new Point(0,0);
			// s.pts[0][1] = new Point(0,1);
			// s.pts[0][2] = new Point(1,0);
			// s.pts[0][3] = new Point(1,1);

			//  b.assign(s,0,4,14);

			// l.pts[0][0] = new Point(0,0);
			// l.pts[0][1] = new Point(0,1);
			// l.pts[0][2] = new Point(0,2);
			// l.pts[0][3] = new Point(1,0);

			// l.pts[1][0] = new Point(0,0);
			// l.pts[1][1] = new Point(0,1);
			// l.pts[1][2] = new Point(1,1);
			// l.pts[1][3] = new Point(2,1);

			// l.pts[2][0] = new Point(1,0);
			// l.pts[2][1] = new Point(1,1);
			// l.pts[2][2] = new Point(1,2);
			// l.pts[2][3] = new Point(0,2);

			// l.pts[3][0] = new Point(0,0);
			// l.pts[3][1] = new Point(0,1);
			// l.pts[3][2] = new Point(0,2);
			// l.pts[3][3] = new Point(1,0);

			// int lversion = 0;
			// b.assign(l,lversion,6,6);

			// z.pts[0][0] = new Point(0,1);
			// z.pts[0][1] = new Point(1,0);
			// z.pts[0][2] = new Point(1,1);
			// z.pts[0][3] = new Point(2,1);

			// z.pts[1][0] = new Point(0,1);
			// z.pts[1][1] = new Point(0,2);
			// z.pts[1][2] = new Point(1,0);
			// z.pts[1][3] = new Point(1,1);

			// int zversion = 0;
			// b.assign(z,zversion,3,3);

			t.pts[0][0] = new Point(1,0);
			t.pts[0][1] = new Point(1,1);
			t.pts[0][2] = new Point(1,2);
			t.pts[0][3] = new Point(0,1);

			t.pts[1][0] = new Point(0,1);
			t.pts[1][1] = new Point(1,1);
			t.pts[1][2] = new Point(2,1);
			t.pts[1][3] = new Point(1,2);

			t.pts[2][0] = new Point(1,0);
			t.pts[2][1] = new Point(1,1);
			t.pts[2][2] = new Point(1,2);
			t.pts[2][3] = new Point(2,1);

			t.pts[3][0] = new Point(1,0);
			t.pts[3][1] = new Point(0,1);
			t.pts[3][2] = new Point(1,1);
			t.pts[3][3] = new Point(2,1);

			int tversion = 3;
			b.assign(t,tversion,1,1);

			// while(c != 'Q')
			// {
			// 	c = sc.nextLine().charAt(0);
			// 	//System.out.println(c);

			// }
			//System.out.println("Game Quitted");		
		}

}
class Point
{
	int x,y;
	Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
class Shape
{
	public Point pts[][] = new Point[4][4];
}