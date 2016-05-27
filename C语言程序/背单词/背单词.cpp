#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<conio.h>
#include<time.h>
#include<windows.h>
#define LEN 500 //定义词库单词数量
struct words
{
	char word[20];
	char chinese[20];
};
//产生随机数
int SUIjishu()
{
	srand( (unsigned)time( NULL ) );  
    return (rand()%30+10);
}
//词库
struct words bank[LEN]=
{   {"aspect","方面"},
	{"according","依照"},
	{"accustomde","习惯的"},
	{"basis","基础"},
	{"confidence","信心"},
	{"dismiss","解散"},
	{"economy","经济"},
	{"fatal","致命的"},
	{"global","全球的"},
	{"helpful","给予帮助的"},
	{"impose","把……加强"},
	{"largely","大部分"},
	{"mystery","神秘的人或事"},
	{"nuclear","核子的"},
	{"obtain","获得"},
	{"occasion","场合"},
	{"particularly","尤其"},
	{"patient","忍耐的"},
	{"railway","铁路"},
	{"reaction","反应"},
	{"remote","遥远的"},
	{"selection""选择"},
	{"setting","环境"},
	{"shrink","起皱"},
	{"translation","翻译"},
	{"troublesome","令人烦恼的"},
	{"undergo","经历"},
	{"unlike","不像"},
	{"volunteer","志愿者"},
	{"virtue","美德"},
	{"wideapread","分布广泛的"},
	{"withdraw","收回"},
	{"absence","缺席"},
	{"abstract","抽象的"},
	{"bacteria","细菌"},
	{"biology","生物学"},
	{"characterize","成为…的特征"},
	{"debate","争论"},
{"display","陈列"},
{"abominate","痛恨"},
{"satisfactory","满意"},
{"creation","创造"},
{"combine","结合"},
{"element","元素"},
{"countless","无数的"},
{"antibiotic","抗生素"},
{"antibody","抗体"},
{"antigen","抗原"},
{"antic","古怪的"},
{"antics","古怪滑稽的动作"},
{"anticipate","预期"},
{"anticipatory","预期的"},
{"antidote","解毒药"},
{"antiquated","陈旧的"},
{"antiseptic","杀菌剂"},
{"antithesis","对立"}

};
//测试单词的成绩                         
void testCJ(int n)
{
	switch(n)
	{
	    case 0:
		case 1:
		case 2:
		case 3:printf("\n\t正确个数：%d \n\t还需努力哦！\n\n",n);break;
		case 4:
		case 5:
		case 6:printf("\n\t正确个数：%d \n\t还不错哈！\n\n",n);break;
		case 7:
		case 8:
		case 9:
		case 10:printf("\n\t正确个数：%d \n\ttGreat！好样的！\n\n",n);break;
		default:printf("系统故障!");getch();
	}
}
//将结构体数组写入文件
void writeFile(struct words bank[],int len)
{
	FILE *fp=NULL;

	if((fp=fopen("单词库.txt","a+"))==NULL)
	{
		printf("写入文件失败!\n");
		return ;
	}

	fwrite(bank,sizeof(struct words),len,fp);

	fclose(fp);
}
//从文件中读入数据组成结构体数组
void readFromFile(struct words bank[],int len)
{
	FILE *fp=NULL;

	if((fp=fopen("单词库.txt","a+"))==NULL)
	{
		return ;
	}
	fread(bank,sizeof(struct words),len,fp);
	fclose(fp);
}
//背单词
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
	printf("\t亲~~~你想背多少个单词呢?\n\t");
	scanf("%d",&num);
	if(num>0&&num<=100)
	{
		system("cls");
		printf("\t\t开始测试喽!\n\n");
		for(i=0;i<num;i++)
		{
			a=SUIjishu();
			printf("\t%s\n",bank[a].chinese);
			printf("\t请输入对应的单词\n\t");
			fflush(stdin);
			gets(word);
			if(strcmp(bank[a].word,word)==0)
			{
				printf("\t回答正确!\n");
				j++;
            
			}
			else
			{
				printf("\t回答错误!\n");
			}
		}
		testCJ(j);
		system("pause");
		system("cls");
	}
}
//英译汉
void English()   
{
	char word[20];
	int i=0;
	int num=0;
	printf("\t请输入您要查询的单词：\n\t");
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
		printf("\t该单词的中文意思为：%s\n",bank[i].chinese);
	}

	else 
	{
		printf("\t抱歉，没有查到您要找的单词\n");
	}
    system("pause");
	system("cls");
}
//汉译英
void Chinese()   
{
	char chinese[20];
	int i=0,num=0;
    while(strcmp(bank[num].chinese," ")!=0)
	{
		num++;
	}
	readFromFile(bank,num);
	printf("请输入您要查询单词的中文意思：\n");
	fflush(stdin);
	gets(chinese);
	while(strcmp(bank[i].chinese,chinese)!=0&&i<num)
	{
      i++; 
	}
	if(i<num)
	{
		printf("该中文的英语单词为：%s\n",bank[i].word);
	}

	else 
	{
		printf("抱歉，没有查到对应单词\n");
	}
	system("pause");
	system("cls");
}
//添加单词
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
     printf("\t你想添加多少个单词?\n\t");
	 scanf("%d",&num);
	 for(int m=n+1;m<=n+num;m++)
	 {
		memset(bank,0,sizeof(struct words));
		puts("\t请输入您要添加的单词：\n\t");
		fflush(stdin);
		gets(bank[m].word);
		puts("\t请输入该词的中文意思：\n\t");
		fflush(stdin);
		gets(bank[m].chinese);
        writeFile(bank,(n+num));
		printf("\t添加成功!\n");
	 }
}
//删除单词
void Deleteword()
{
	char word[20];
	int i=0,num=0;
	printf("\t请输入您要删除的单词：\n");
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
			puts("删除成功！");
		}
	}
	else 
		puts("没有找到对应的单词！\n");
    writeFile(bank,num);
    
}
//输出整个词汇表
void Outputwords()
{
	int i;
   system("mode con cols=38 lines=50");
	printf("\t 单词-----中文\n");
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
		printf("\t 英译汉------1\n");
		printf("\t 汉译英------2\n");
		printf("\t 返回上一级--0\n");
		printf("\t 请选择\n\t ");
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
		 default:printf("\t\t\t请选择正确操作\n");break;
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
		printf("\t  添加单词------1\n");
		printf("\t  删除单词------2\n");
		printf("\t  返回上一级--0\n");
		printf("\t  请选择\n\t ");
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
		 default:printf("\t\t\t请选择正确操作\n");break;
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
		printf("\t 开始背单词-----------1\n");
		printf("\t 中英单词翻译---------2\n");
		printf("\t 词库的添加与删除-----3\n");
		printf("\t 词汇表预览-----------4\n");
		printf("\t 退出-----------------0\n");
		printf("\t 请选择功能\n\t");
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
				  printf("\t   正在退出.....\n");
				  printf("\t   欢迎下次使用!\n");
				  Sleep(1300);
				  exit(0);
			  }break;
		  default:printf("\t\t\t请选择正确操作!\n");break;
		 }
	}
   return 0;
}
