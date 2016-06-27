package io.github.xieyezi;

import java.util.ArrayList;
import java.util.Random;
/*
 用maze类来表示一个迷宫的属性
 */
public class Maze
{

	private int width = 40;   //迷宫的宽度
	private int height = 40;  //迷宫的高度
	private Random random = new Random(); //用于生成迷宫时随机访问一个点的相邻的一个点

	public Maze()
	{
	}
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public Maze(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
//以下方法是从列表里面取出每一个MazePoint的对象
	public ArrayList<mazePoint> getMaze()
	{
		ArrayList<mazePoint> maze = new ArrayList<mazePoint>();
		for (int h = 0; h < height; h++)
		{
			for (int w = 0; w < width; w++)
			{
				mazePoint point = new mazePoint(w, h);
				maze.add(point);
			}
		}
		return CreateMaze(maze);
	}
//以下方法是建造迷宫的方法
	private ArrayList<mazePoint> CreateMaze(ArrayList<mazePoint> maze)
	{
		int top = 0;
		int x = 0;
		int y = 0;
		ArrayList<mazePoint> team = new ArrayList<mazePoint>();
		team.add(maze.get(x + y * width));
		while (top >= 0)
		{
			int[] val = new int[]{ -1, -1, -1, -1 };
			int times = 0;
			boolean flag = false;
			mazePoint pt = (mazePoint) team.get(top);
			x = pt.getX();
			y = pt.getY();
			pt.visted = true;

			ro1: while (times < 4)
			{
				int dir = random.nextInt(4);
				if (val[dir] == dir)
					continue;
				else
					val[dir] = dir;

				switch (dir)
				{
				case 0: // 左边
					if ((x - 1) >= 0 && maze.get(x - 1 + y * width).visted == false)
					{
						if(x==0&&y==0||x==width&&y==height)
						{
							top++;
							flag = true;
							break;
						}
						maze.get(x + y * width).setLeft();
						maze.get(x - 1 + y * width).setRight();
						team.add(maze.get(x - 1 + y * width));
						top++;
						flag = true;
						break ro1;

					}
					break;
				case 1: // 右边
					if ((x + 1) < width && maze.get(x + 1 + y * width).visted == false)
					{

						maze.get(x + y * width).setRight();
						maze.get(x + 1 + y * width).setLeft();
						team.add(maze.get(x + 1 + y * width));
						top++;
						flag = true;
						break ro1;
					}
					break;
				case 2: // 上边
					if ((y - 1) >= 0 && maze.get(x + (y - 1) * width).visted == false)
					{
						maze.get(x + y * width).setUp();
						maze.get(x + (y - 1) * width).setDown();
						team.add(maze.get(x + (y - 1) * width));
						top++;
						flag = true;
						break ro1;
					}
					break;
				case 3: // 下边
					if ((y + 1) < height && maze.get(x + (y + 1) * width).visted == false)
					{
						maze.get(x + y * width).setDown();
						maze.get(x + (y + 1) * width).setUp();
						team.add(maze.get(x + (y + 1) * width));
						top++;
						flag = true;
						break ro1;
					}
					break;
				}
				times ++;
			}
			if (!flag)
			{
				team.remove(top);
				top -= 1;
			}

		}
		return maze;
	}
}
