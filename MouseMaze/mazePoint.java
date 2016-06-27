package io.github.xieyezi;
/*
 用mazePoint类来表示迷宫里面的每一个点
 */
public class mazePoint
{
	//“0”表示有墙，“1”表示无墙
	private int left = 0;   //点的左边属性
	private int right = 0; //点的右边属性
	private int up = 0;    //点的上边属性
	private int down = 0;  //点的底边属性
	//迷宫中的坐标
	private int x;
	private int y;
	public boolean visted = false; //点的访问标记

	public mazePoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getLeft()
	{
		return left;
	}

	public void setLeft()
	{
		this.left = 1;
	}

	public int getRight()
	{
		return right;
	}

	public void setRight()
	{
		this.right = 1;
	}

	public int getUp()
	{
		return up;
	}

	public void setUp()
	{
		this.up = 1;
	}

	public int getDown()
	{
		return down;
	}

	public void setDown()
	{
		this.down = 1;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

}
