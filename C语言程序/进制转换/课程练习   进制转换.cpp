#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include <ctype.h>
int JanceB(char *p) //判断是否是二进制数
{
	for(;*p!='\0';p++)
	{
		if((*p-'0')>1)
		{
			return -1;
			break;
		}
	}
	return 1;
}
int JanceO(char *p)//判断是否是八进制数
{
	for(;*p!='\0';p++)
	{
		if((*p-'0')>8)
		{
			return -1;
			break;
		}
	}
	return 1;
}
int JanceD(char *p)//判断是否是十进制数
{
	for(;*p!='\0';p++)
	{
		if((*p-'0')>9)
		{
			return -1;
			break;
		}
	}
	return 1;
}
int JanceH(char *p)//判断是否是十六进制数
{
	for(;*p!='\0';p++)
	{
	    if((*p>='0'&&*p<='9')||(*p>='A'&&*p<='F'))
		{
			continue;
		}
	  else
		{
			return -1;
		}
	}
	return 1;
}
void input(int *p,char arr[])//测试函数
{
	int i;
	int i1,i2,i3,i4;
	while(1)
	{
		printf("亲~~你想输入什么进制的数字？（用2,8,10,16表示）\n");
        scanf("%d",&i);
		*p=i;
		printf("请输入数字\n");
		fflush(stdin);
		gets(arr);
		switch(i)
		{
		   case 2:
				   i1=JanceB(arr);
				   if(i1==1)
				   {
					   printf("该数是二进制数\n");
					   return;
				   }
				   else
					printf("该数不是二进制数\n"); break;
		   case 8:
				i2=JanceO(arr);
				if(i2==1)
				{printf("该数是八进制数\n");return;}
				else
				  printf("该数不是八进制数\n");break;
		   case 10:
			   i3=JanceD(arr);
			   if(i3==1)
			   {printf("该数是十进制数\n");return;}
			   else
				  printf("该数不是十进制数\n"); break;
			  
		   case 16:
			   i4=JanceH(arr);
			   if(i4==1)
			   {printf("该数是十六进制数\n");return;}
			   else
				  printf("该数不是十六进制数\n");break;
		   default:printf("你输入的进制不在范围内！请选择正确的进制\n");continue;
		}
		
	}
}
long  exchange(char a[],int n)  // 任意进制转化为十进制
{	
		int b,i;
		long sum=0;
		b=strlen(a);
	for(i=0;i<b;i++)
	{
		if(a[i]>='A'&&a[i]<='Z')
			sum+=(a[i]-'7')*pow(n,b-i-1);
		else 
			sum+=(a[i]-'0')*pow(n,b-i-1);
	}
	return sum;
}

void tansform(long int a,int b)//  a表示输入的十进制数，b表示要转化的进制
{
	char str[100]={0};
	int i=0,j;
	while(a!=0)
	{
		if((a%b)>=10)
		{
			 str[i]=a%b+55;
			 a=a/b;
		}
		else
		{
			str[i]=a%b+48;
             a=a/b;
		}
		i++;
	}
	for(j=i-1;j>=0;j--)
	{
		printf("%c",str[j]);
	}
	printf("\n");
}
void pingmu()
{ 
	system("color 3A");
printf("\t\t┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n");
printf("\t\t┃         ☆●欢迎进入进制转换系统●☆               ┃ \n");
printf("\t\t┗┳━━━━━━━━━━━━━━┳━━━━━━━━━┳┛\n");
printf("\t\t  ┃  功能：转换为十进制        ┃注意：输入数据请规┃\n");
printf("\t\t  ┣━━━━━━━━━━━━━━┫范                ┃\n");
printf("\t\t  ┃        转换为二进制        ┃                  ┃\n");
printf("\t\t  ┣━━━━━━━━━━━━━━╋******************┫\n");
printf("\t\t  ┃        转换为八进制        ┃    ☆        ☆  ┃\n");
printf("\t\t  ┣━━━━━━━━━━━━━━╋******************┫\n");
printf("\t\t  ┃        转换为十六进制      ┃    ★        ★  ┃\n");
printf("\t\t  ┣━━━━━━━━━━━━━━╋******************┫\n");
printf("\t\t  ┗━━━━━━━━━━━━━━┻━━━━━━━━━┛\n"); 
}
int main()
{
    int n,*p=&n,i;long b;
  char a[100],d;
  while(d!='0')
 {	 
	     pingmu();
	    input(p,a);
	    b=exchange(a,n);
		printf("请输入你要转化的进制？（用2,8,10,16表示）\n");
		scanf("%d",&i);
	while(i!=6)
	 { 
		
		switch(i)
		{
		   case 10:   tansform(b,10);  break;
		   case 2:    tansform(b,2);  break;
		   case 8:    tansform(b,8);  break;
		   case 16:   tansform(b,16);  break;
		   default: printf("请看表格！\n");break;
		}
	   printf("（返回首页输入6）\n你还想继续转换为其他进制吗？如果想请继续输入\n：");
	   scanf("%d",&i);
	} 
	   printf("是否还进行进制转换;\n是：按任意键继续（5除外），否：按‘5‘结束\n");
	   scanf("%c",&d);
       system("cls");
  }  
  system("cls");
	return 0;
}


 



