#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>
#include<time.h>
#include<windows.h>
#define LEN 500 //����ʿⵥ������
struct words
{
	char word[20];
	char chinese[20];
};
//���������
int SUIjishu()
{
	srand( (unsigned)time( NULL ) );  
    return (rand()%30+10);
}
//�ʿ�
struct words bank[LEN]=
{   {"aspect","����"},
	{"according","����"},
	{"accustomde","ϰ�ߵ�"},
	{"basis","����"},
	{"confidence","����"},
	{"dismiss","��ɢ"},
	{"economy","����"},
	{"fatal","������"},
	{"global","ȫ���"},
	{"helpful","���������"},
	{"impose","�ѡ�����ǿ"},
	{"largely","�󲿷�"},
	{"mystery","���ص��˻���"},
	{"nuclear","���ӵ�"},
	{"obtain","���"},
	{"occasion","����"},
	{"particularly","����"},
	{"patient","���͵�"},
	{"railway","��·"},
	{"reaction","��Ӧ"},
	{"remote","ңԶ��"},
	{"selection""ѡ��"},
	{"setting","����"},
	{"shrink","����"},
	{"translation","����"},
	{"troublesome","���˷��յ�"},
	{"undergo","����"},
	{"unlike","����"},
	{"volunteer","־Ը��"},
	{"virtue","����"},
	{"wideapread","�ֲ��㷺��"},
	{"withdraw","�ջ�"},
	{"absence","ȱϯ"},
	{"abstract","�����"},
	{"bacteria","ϸ��"},
	{"biology","����ѧ"},
	{"characterize","��Ϊ��������"},
	{"debate","����"},
{"display","����"},
{"abominate","ʹ��"},
{"satisfactory","����"},
{"creation","����"},
{"combine","���"},
{"element","Ԫ��"},
{"countless","������"},
{"antibiotic","������"},
{"antibody","����"},
{"antigen","��ԭ"},
{"antic","�Źֵ�"},
{"antics","�Źֻ����Ķ���"},
{"anticipate","Ԥ��"},
{"anticipatory","Ԥ�ڵ�"},
{"antidote","�ⶾҩ"},
{"antiquated","�¾ɵ�"},
{"antiseptic","ɱ����"},
{"antithesis","����"}

};
//���Ե��ʵĳɼ�                         
void testCJ(int n)
{
	switch(n)
	{
	    case 0:
		case 1:
		case 2:
		case 3:printf("\n\t��ȷ������%d \n\t����Ŭ��Ŷ��\n\n",n);break;
		case 4:
		case 5:
		case 6:printf("\n\t��ȷ������%d \n\t���������\n\n",n);break;
		case 7:
		case 8:
		case 9:
		case 10:printf("\n\t��ȷ������%d \n\ttGreat�������ģ�\n\n",n);break;
		default:printf("ϵͳ����!");getch();
	}
}
//���ṹ������д���ļ�
void writeFile(struct words bank[],int len)
{
	FILE *fp=NULL;

	if((fp=fopen("���ʿ�.txt","a+"))==NULL)
	{
		printf("д���ļ�ʧ��!\n");
		return ;
	}

	fwrite(bank,sizeof(struct words),len,fp);

	fclose(fp);
}
//���ļ��ж���������ɽṹ������
void readFromFile(struct words bank[],int len)
{
	FILE *fp=NULL;

	if((fp=fopen("���ʿ�.txt","a+"))==NULL)
	{
		return ;
	}
	fread(bank,sizeof(struct words),len,fp);
	fclose(fp);
}
//������
void Peidanchi()
{
	int a,i;
	int num;
	int n=0;
	int j=0;
	system("cls");
    char word[20];
    while(strcmp(bank[n].chinese," ")!=0)
	{
		n++;
	}
	readFromFile(bank,n);
	printf("\n\n\n");
	printf("\t��~~~���뱳���ٸ�������?\n\t");
	scanf("%d",&num);
	if(num>0&&num<=100)
	{
		system("cls");
		printf("\t\t��ʼ�����!\n\n");
		for(i=0;i<num;i++)
		{
			a=SUIjishu();
			printf("\t%s\n",bank[a].chinese);
			printf("\t�������Ӧ�ĵ���\n\t");
			fflush(stdin);
			gets(word);
			if(strcmp(bank[a].word,word)==0)
			{
				printf("\t�ش���ȷ!\n");
				j++;
            
			}
			else
			{
				printf("\t�ش����!\n");
			}
		}
		testCJ(j);
		system("pause");
		system("cls");
	}
}
//Ӣ�뺺
void English()   
{
	char word[20];
	int i=0;
	int num=0;
	printf("\t��������Ҫ��ѯ�ĵ��ʣ�\n\t");
	fflush(stdin);
	gets(word);
    while(strcmp(bank[num].chinese," ")!=0)
	{
		num++;
	}
	readFromFile(bank,num);
	while(strcmp(bank[i].word,word)!=0&&i<num)
	{
      i++; 
	}
	if(i<num)
	{
		printf("\t�õ��ʵ�������˼Ϊ��%s\n",bank[i].chinese);
	}

	else 
	{
		printf("\t��Ǹ��û�в鵽��Ҫ�ҵĵ���\n");
	}
    system("pause");
	system("cls");
}
//����Ӣ
void Chinese()   
{
	char chinese[20];
	int i=0,num=0;
    while(strcmp(bank[num].chinese," ")!=0)
	{
		num++;
	}
	readFromFile(bank,num);
	printf("��������Ҫ��ѯ���ʵ�������˼��\n");
	fflush(stdin);
	gets(chinese);
	while(strcmp(bank[i].chinese,chinese)!=0&&i<num)
	{
      i++; 
	}
	if(i<num)
	{
		printf("�����ĵ�Ӣ�ﵥ��Ϊ��%s\n",bank[i].word);
	}

	else 
	{
		printf("��Ǹ��û�в鵽��Ӧ����\n");
	}
	system("pause");
	system("cls");
}
//��ӵ���
void Addword()
{ 
	system("cls");
	int i=0;
	int num,n=0;
	while(strcmp(bank[n].word," ")!=0)
	{
		n++;
	}
	printf("%d\n",n);
	 readFromFile(bank,n);
     printf("\t������Ӷ��ٸ�����?\n\t");
	 scanf("%d",&num);
	 for(int m=n+1;m<=n+num;m++)
	 {
		memset(bank,0,sizeof(struct words));
		puts("\t��������Ҫ��ӵĵ��ʣ�\n\t");
		fflush(stdin);
		gets(bank[m].word);
		puts("\t������ôʵ�������˼��\n\t");
		fflush(stdin);
		gets(bank[m].chinese);
        writeFile(bank,(n+num));
		printf("\t��ӳɹ�!\n");
	 }
}
//ɾ������
void Deleteword()
{
	char word[20];
	int i=0,num=0;
	printf("\t��������Ҫɾ���ĵ��ʣ�\n");
	fflush(stdin);
	gets(bank[i].word);
    while(strcmp(bank[num].chinese," ")!=0)
	{
		num++;
	}
	readFromFile(bank,num);
	while(strcmp(bank[i].word,word)!=0&&i<num) 
		i++;
  
	if(i<num)
	{
		for(;i<num;i++)
		{
			bank[i]=bank[i+1];
			puts("ɾ���ɹ���");
		}
	}
	else 
		puts("û���ҵ���Ӧ�ĵ��ʣ�\n");
    writeFile(bank,num);
    
}
//��������ʻ��
void Outputwords()
{
	int i;
   system("mode con cols=38 lines=50");
	printf("\t ����-----����\n");
	for(i=0;i<50;i++)
	{
		printf("\t%s----%s\n",bank[i].word,bank[i].chinese);
	}
    system("pause");
	system("cls");
}
void Print1()
{	
	int i;
	while(1)
	{
        system("mode con cols=35 lines=20");
        printf("\n\n\n");
		printf("\t Ӣ�뺺------1\n");
		printf("\t ����Ӣ------2\n");
		printf("\t ������һ��--0\n");
		printf("\t ��ѡ��\n\t ");
		scanf("%d",&i);
		switch(i)
		{
		case 1:
			{
			  English();break;
			}
		case 2: 
			{
				Chinese();break;
			}
		 case 0:
			 {
				 system("cls");
				 return;
			 }
		 default:printf("\t\t\t��ѡ����ȷ����\n");break;
		}
	}

}
void Print2()
{	
	while(1)
	{
		int i;
        system("mode con cols=35 lines=20");
        printf("\n\n\n");
		printf("\t  ��ӵ���------1\n");
		printf("\t  ɾ������------2\n");
		printf("\t  ������һ��--0\n");
		printf("\t  ��ѡ��\n\t ");
		scanf("%d",&i);
		switch(i)
		{
		 case 1:Addword();break;
		 case 2:Deleteword();break;
		 case 0:
			 {
				 system("cls");
				 return;
			 }
		 default:printf("\t\t\t��ѡ����ȷ����\n");break;
		}
	}
}
int main()
{
	while(1)
	{
		system("color 8A");
		int i;
        system("mode con cols=40 lines=20");
        printf("\n\n\n\n");
		printf("\t ��ʼ������-----------1\n");
		printf("\t ��Ӣ���ʷ���---------2\n");
		printf("\t �ʿ�������ɾ��-----3\n");
		printf("\t �ʻ��Ԥ��-----------4\n");
		printf("\t �˳�-----------------0\n");
		printf("\t ��ѡ����\n\t");
		scanf("%d",&i);
		switch(i)
		{
		  case 1:
			  { 
			    system("cls");
				Peidanchi();
       
			  }break;
		  case 2:
			  {
                  system("cls");
				  Print1();
			  }break;
		  case 3:
			  {
				  system("cls");
				  Print2();
			  }break;
		  case 4:
			  {
				  system("cls");
				  Outputwords();
			  }break;
		  case 0:
			  {
				  system("cls");
				  system("mode con cols=40 lines=20");
				  printf("\n\n\n\n\n\n");
				  printf("\t   �����˳�.....\n");
				  printf("\t   ��ӭ�´�ʹ��!\n");
				  Sleep(1300);
				  exit(0);
			  }break;
		  default:printf("\t\t\t��ѡ����ȷ����!\n");break;
		 }
	}
   return 0;
}
