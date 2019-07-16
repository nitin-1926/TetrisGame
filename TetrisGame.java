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
	void line(int version)
	{
		Shape i = new Shape();
		i.pts[0][0] = new Point(0,0);
		i.pts[0][1] = new Point(1,0);
		i.pts[0][2] = new Point(2,0);
		i.pts[0][3] = new Point(3,0);

		i.pts[1][0] = new Point(0,0);
		i.pts[1][1] = new Point(0,1);
		i.pts[1][2] = new Point(0,2);
		i.pts[1][3] = new Point(0,3);

		Board b = new Board();
		b.assign(i,version,1,1);	
	}
			
	void square(int version)
	{
		Shape s = new Shape();
		s.pts[0][0] = new Point(0,0);
		s.pts[0][1] = new Point(0,1);
		s.pts[0][2] = new Point(1,0);
		s.pts[0][3] = new Point(1,1);

		Board b = new Board();
		 b.assign(s,version,4,14);
	}

	void lll(int version)
	{
		Shape l = new Shape();
		l.pts[0][0] = new Point(0,0);
		l.pts[0][1] = new Point(1,0);
		l.pts[0][2] = new Point(2,0);
		l.pts[0][3] = new Point(2,1);

		l.pts[1][0] = new Point(0,0);
		l.pts[1][1] = new Point(1,0);
		l.pts[1][2] = new Point(0,1);
		l.pts[1][3] = new Point(0,2);

		l.pts[2][0] = new Point(0,0);
		l.pts[2][1] = new Point(0,1);
		l.pts[2][2] = new Point(1,1);
		l.pts[2][3] = new Point(2,1);

		l.pts[3][0] = new Point(2,0);
		l.pts[3][1] = new Point(2,1);
		l.pts[3][2] = new Point(2,2);
		l.pts[3][3] = new Point(1,2);

		Board b = new Board();
		b.assign(l,version,6,6);
	}

	void zzz(int version)
	{
		Shape z = new Shape();
		z.pts[0][0] = new Point(0,0);
		z.pts[0][1] = new Point(1,0);
		z.pts[0][2] = new Point(1,1);
		z.pts[0][3] = new Point(2,1);

		z.pts[1][0] = new Point(0,1);
		z.pts[1][1] = new Point(0,2);
		z.pts[1][2] = new Point(1,0);
		z.pts[1][3] = new Point(1,1);

		Board b = new Board();
		b.assign(z,version,3,3);
	}

	void ttt(int version)
	{
		Shape t = new Shape();
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

		Board b = new Board();
		b.assign(t,version,1,1);
	}
	public static void main(String[] args)
		{
			Scanner sc = new Scanner (System.in);
			char c = '\0';		
			int version= 0;
			TetrisGame tg = new TetrisGame();

			//tg.line();
			//tg.square();
			tg.lll(version);
			//tg.zzz();
			//tg.ttt();
			while(c != 'q')
			{
			//	tg.lll();
				c = sc.nextLine().charAt(0);
				if(c=='c'&&version!=3)
				{
					tg.lll(++version);
				}
				if(c=='c'&&version==3)
				{
					version =0;
					tg.lll(version);
				}
				if(c=='l'&&version!=0)
				{
					tg.lll(--version);
				}
				if(c=='l'&&version==0)
				{
					version =3;
					tg.lll(version);
				}

			}
		System.out.println("Game Quitted");
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