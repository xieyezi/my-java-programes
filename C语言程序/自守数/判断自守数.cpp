/******************************************************************************************************
   �ж����������ĳ�����Ƿ�������������һ����Ȼ����ƽ������β����ȻΪ����Ȼ�����������Ϊ��������
 ****************************************************************************************************/
#include<stdio.h>
#include <windows.h>
void Print()
{
    system("color 3A");
   system("mode con cols=40 lines=15");
	printf("\n\n\n");
	printf("\t    �ж�������\n\n");
    printf("\t��~~�����������жϵ�����\n\t");
}
int main()
{
    system("color 3A");
    system("mode con cols=50 lines=20");
	long a,b;
	while(1)
	{
		int i=1;
		Print();
		scanf("%ld",&a);
		b=a;
		do
		{
			b=b/10;
			i=i*10;
		}while(b>0);

		if(a*a%i==a)
		{
			printf("\t������������!\n\t");
		    system("pause");
			system("cls");
		}

		else
		{
			printf("\t��������������!\n\t");
            system("pause");
            system("cls");
		}
	
	}	
	return 0;
}
