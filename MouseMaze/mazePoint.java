package io.github.xieyezi;
/*
 ��mazePoint������ʾ�Թ������ÿһ����
 */
public class mazePoint
{
	//��0����ʾ��ǽ����1����ʾ��ǽ
	private int left = 0;   //����������
	private int right = 0; //����ұ�����
	private int up = 0;    //����ϱ�����
	private int down = 0;  //��ĵױ�����
	//�Թ��е�����
	private int x;
	private int y;
	public boolean visted = false; //��ķ��ʱ��

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
