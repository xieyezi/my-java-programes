/******************************************************************************************************
   判断任意输入的某数，是否是自守数。若一个自然数的平方数的尾部仍然为该自然数本身，则该数为自守数。
 ****************************************************************************************************/
#include<stdio.h>
#include <windows.h>
void Print()
{
    system("color 3A");
   system("mode con cols=40 lines=15");
	printf("\n\n\n");
	printf("\t    判断自守数\n\n");
    printf("\t亲~~请输入您想判断的数字\n\t");
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
			printf("\t该数是自守数!\n\t");
		    system("pause");
			system("cls");
		}

		else
		{
			printf("\t该数不是自守数!\n\t");
            system("pause");
            system("cls");
		}
	
	}	
	return 0;
}
