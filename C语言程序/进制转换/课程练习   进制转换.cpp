#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>
#include <ctype.h>
int JanceB(char *p) //�ж��Ƿ��Ƕ�������
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
int JanceO(char *p)//�ж��Ƿ��ǰ˽�����
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
int JanceD(char *p)//�ж��Ƿ���ʮ������
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
int JanceH(char *p)//�ж��Ƿ���ʮ��������
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
void input(int *p,char arr[])//���Ժ���
{
	int i;
	int i1,i2,i3,i4;
	while(1)
	{
		printf("��~~��������ʲô���Ƶ����֣�����2,8,10,16��ʾ��\n");
        scanf("%d",&i);
		*p=i;
		printf("����������\n");
		fflush(stdin);
		gets(arr);
		switch(i)
		{
		   case 2:
				   i1=JanceB(arr);
				   if(i1==1)
				   {
					   printf("�����Ƕ�������\n");
					   return;
				   }
				   else
					printf("�������Ƕ�������\n"); break;
		   case 8:
				i2=JanceO(arr);
				if(i2==1)
				{printf("�����ǰ˽�����\n");return;}
				else
				  printf("�������ǰ˽�����\n");break;
		   case 10:
			   i3=JanceD(arr);
			   if(i3==1)
			   {printf("������ʮ������\n");return;}
			   else
				  printf("��������ʮ������\n"); break;
			  
		   case 16:
			   i4=JanceH(arr);
			   if(i4==1)
			   {printf("������ʮ��������\n");return;}
			   else
				  printf("��������ʮ��������\n");break;
		   default:printf("������Ľ��Ʋ��ڷ�Χ�ڣ���ѡ����ȷ�Ľ���\n");continue;
		}
		
	}
}
long  exchange(char a[],int n)  // �������ת��Ϊʮ����
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

void tansform(long int a,int b)//  a��ʾ�����ʮ��������b��ʾҪת���Ľ���
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
printf("\t\t��������������������������������������������������������\n");
printf("\t\t��         ���ӭ�������ת��ϵͳ���               �� \n");
printf("\t\t���ש����������������������������ש������������������ש�\n");
printf("\t\t  ��  ���ܣ�ת��Ϊʮ����        ��ע�⣺����������橧\n");
printf("\t\t  �ǩ����������������������������Ϸ�                ��\n");
printf("\t\t  ��        ת��Ϊ������        ��                  ��\n");
printf("\t\t  �ǩ�����������������������������******************��\n");
printf("\t\t  ��        ת��Ϊ�˽���        ��    ��        ��  ��\n");
printf("\t\t  �ǩ�����������������������������******************��\n");
printf("\t\t  ��        ת��Ϊʮ������      ��    ��        ��  ��\n");
printf("\t\t  �ǩ�����������������������������******************��\n");
printf("\t\t  �������������������������������ߩ�������������������\n"); 
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
		printf("��������Ҫת���Ľ��ƣ�����2,8,10,16��ʾ��\n");
		scanf("%d",&i);
	while(i!=6)
	 { 
		
		switch(i)
		{
		   case 10:   tansform(b,10);  break;
		   case 2:    tansform(b,2);  break;
		   case 8:    tansform(b,8);  break;
		   case 16:   tansform(b,16);  break;
		   default: printf("�뿴���\n");break;
		}
	   printf("��������ҳ����6��\n�㻹�����ת��Ϊ������������������������\n��");
	   scanf("%d",&i);
	} 
	   printf("�Ƿ񻹽��н���ת��;\n�ǣ��������������5���⣩���񣺰���5������\n");
	   scanf("%c",&d);
       system("cls");
  }  
  system("cls");
	return 0;
}


 



