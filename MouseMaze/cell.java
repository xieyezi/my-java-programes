package cn.edud;


public class cell implements Comparable<cell>
{
	// ��0����ʾ��ǽ����1����ʾ��ǽ
	private int left = 1;
	private int right = 1;
	private int up = 1;
	private int down = 1;
	private int dir;// С��ǰ���ķ���,0,1,2,3�ֱ������������
	private int destion;// �洢��Ԫ���λ��
	// �Թ��е���������
	private int x;
	private int y;
	public boolean visted = false; //��Ԫ��ķ��ʱ��
	private boolean pass = true;//�Ƿ�Ϊ��·
	private int direction = 0; //��Χ�հ�ǽ�ڵ�����
	public cell()
	{
		x = 0;
		y = 0;
	}

	public cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.pass=true;
		
	}

	public cell(int up, int right, int down, int left)
	{
		this.up = up;
		this.right = right;
		this.down = down;
		this.left = left;
		this.pass=true;
		setDirection();
	}

	public int getLeft()
	{
		return left;
	}

	public void setLeft(int left)
	{
		this.left = left;
	}

	public int getRight()
	{
		return right;
	}

	public void setRight(int right)
	{
		this.right = right;
	}

	public int getUp()
	{
		return up;
	}

	public void setUp(int up)
	{
		this.up = up;
	}

	public int getDown()
	{
		return down;
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

	public boolean isVisted()
	{
		return visted;
	}

	public void setVisted(boolean visted)
	{
		this.visted = visted;
	}

	public int getDir()
	{
		return dir;
	}

	public void setDir(int dir)
	{
		this.dir = dir;
	}

	public int compareTo(cell o)
	{

		return this.destion - o.getDix();
	}

	public int getDix()
	{
		return destion;
	}

	public void setDix(int dix)
	{
		this.destion = dix;
	}

	public boolean isPass()
	{
		return pass;
	}

	public void setPass()
	{
		this.pass = false;
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
