package cn.edud;

public class mazePoint
{
	// “0”表示有墙，“1”表示无墙
	private int left = 0;
	private int right = 0;
	private int up = 0;
	private int down = 0;
	// 迷宫中的坐标
	private int x;
	private int y;
	public boolean visted;
	// 周围空白墙壁的数量
	private int direction = 0;

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

	public void setLeft(int left)
	{
		this.left = left;
	}

	public void setRight(int right)
	{
		this.right = right;
	}

	public void setUp(int up)
	{
		this.up = up;
	}

	public void setDown(int down)
	{
		this.down = down;
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

	public int getDirection()
	{
		return direction;
	}

	public void setDirection()
	{
		if (this.up == 1)
			this.direction++;
		if (this.right == 1)
			this.direction++;
		if (this.down == 1)
			this.direction++;
		if (this.left == 1)
			this.direction++;
	}
}
