/***************************************************************************************************************************************
    该系统名为“业纯网吧管理系统”。该系统可以为网吧的管理员提供”客户办卡服务、客户上网登记、查看网吧营业额、查看客户上网信息“等功能。

    该系统中客户上网的计价标准为普通卡5元钱每小时，会员卡4元钱每小时。普通卡消费计时若高于8小时但小于9小时，则每小时按照2元计算，若
    高于9小小时，按照4.5元钱每小时计算。以下是该系统的源代码。   注:管理员姓名为:苏业纯,密码初始为520
***************************************************************************************************************************************/
#include <stdio.h>
#include <math.h>
#include <windows.h>
#include <stdlib.h>
#include <conio.h>
#include <stdio.h>

//会员生日信息类型
struct birthdate
{
	int years;
	int months;
	int days;
};
//会员使用信息类型
struct usedata
{
	char phonenumbers[12];
	char IDnumbers[19];
	char bankadata[20];  //会员卡的办理时间
	char uselimit[5];  //会员卡的有效时间 
};
//会员个人信息类型
struct information
{
	char name[20];
	char sex[5];
    struct birthdate birth;
    struct usedata userinformation;
    struct information *next;
};
//客户上网信息
struct information1
{
	char Idnumbers[19];
	char place[5];          //客户的机器位置
    char beginusetime[20];  //客户的上机时间
	float deposit;            //客户交的押金
    char lastusetime[20];   //客户的下机时间
	float lastmoney;          //客户的实际消费金额
    struct information1 *next;
};

//控制行与列
void goto_pos(int x, int y) //(列,行)
{
	
	COORD coord = {x,y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);

}

//登录界面
int Admin() 
{

	system("mode con cols=30 lines=22");
	system("color 3F");
	int i;
	char name[10]={"苏业纯"},password[10]={"520"};
	char get_1[10],get_2[10];
	for(i=0;i<3;i++) {
		system("cls");
		printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		printf("          管理员登录\n\n");
		printf("    ┏┳┳┳┳┳┳┳┳┳┳┓\n");
		printf("    ┣登录名:             ┫\n");
	    printf("    ┗┻┻┻┻┻┻┻┻┻┻┛\n");
	    printf("\n");
		printf("    ┏┳┳┳┳┳┳┳┳┳┳┓\n");
		printf("    ┣密码:               ┫\n");
	    printf("    ┗┻┻┻┻┻┻┻┻┻┻┛\n");
		printf("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		fflush(stdin);
		goto_pos(13,7);
		scanf("%10s",get_1);
		fflush(stdin);
		goto_pos(11,11);
		scanf("%10s",get_2);
		if(strcmp(name,get_1)==0&&strcmp(password,get_2)==0){
			goto_pos(11,17);
			printf("登录成功!");
			Sleep(800);
			return 0;
		}else{
			goto_pos(11,17);
			printf("密码错误\n   请重新输入 (剩余次数:%d)",2-i);
			Sleep(1300);
		}
	}
	return -1;
}

//主界面
void Print1()
{
    system("mode con cols=40 lines=25");
    system("color 3F");
	printf("\n\n\n");
	printf("\t╔╦╦╦╦╦╦╦╦╦╦╦╦╗\n");
	printf("\t╠                        ╣\n");
    printf("\t╠  管理会员信息-------1  ╣\n");
	printf("\t╠  客户上网登记-------2  ╣\n");
	printf("\t╠  查看网吧运营情况---3  ╣\n");
	printf("\t╠  帮助---------------4  ╣\n");
	printf("\t╠  退出登录-----------0  ╣\n");
    printf("\t╠                        ╣\n");
	printf("\t╚╩╩╩╩╩╩╩╩╩╩╩╩╝\n");
}
void Print2()
{
   system("mode con cols=50 lines=20");
   system("color 3F");
   printf("\n\n\n\n");
   printf("\t╔╦╦╦╦╦╦╦╦╦╦╦╦╦╗\n");
   printf("\t╠  注册新会员------------1 ╣\n");
   printf("\t╠  查看会员信息----------2 ╣\n");
   printf("\t╠  查看所有会员信息------3 ╣\n");
   printf("\t╠  删除会员--------------4 ╣\n");
   printf("\t╠  修改会员信息----------5 ╣\n");
   printf("\t╠  返回上一级菜单--------0 ╣\n");
   printf("\t╚╩╩╩╩╩╩╩╩╩╩╩╩╩╝\n");
}

//为链表的每个会员申请内存
struct information *getNode()
{
	struct information *node=NULL;
	node=(struct information *)malloc(sizeof(struct information));
	if(node!=NULL)
	{
		memset(node,0,sizeof(struct information));
		return node;
	}
	printf("申请内存失败！\n");
	return NULL;
}
//初始化会员信息
void Inputinformation(struct information *head)
{
	if(head==NULL)
	{
		printf("初始化链表失败！\n");
	}
	else
	{
		printf("请输入客户姓名\n");
		fflush(stdin);
		gets(head->name);
		printf("请输入客户性别(男为M，女为F)\n");
		fflush(stdin);
		gets(head->sex);
		printf("请输入客户的出生日期\n");
		scanf("%d%d%d",&head->birth.years,&head->birth.months,&head->birth.days);
		printf("请输入客户的手机号码\n");
		fflush(stdin);
		gets(head->userinformation.phonenumbers);
		printf("请输入客户的身份证号码\n");
		fflush(stdin);
		gets(head->userinformation.IDnumbers);
		printf("请输入客户的办卡时间\n");
		fflush(stdin);
		gets(head->userinformation.bankadata);
		printf("请输入客户的卡有效时间\n");
		fflush(stdin);
		gets(head->userinformation.uselimit);
	}
}
//将会员信息写到文件里面
int writeListFile(struct information *head)
{

	struct information *node=head;

	FILE *fp=NULL;

	fp=fopen("VIPinformation.txt","a+");

	if(fp==NULL)
	{
		printf("打开文件失败！\n");
		return 1;
	}
	
	while(node!=NULL)
	{
		
		if(fwrite(node,sizeof(struct information),1,fp)==1)		
			node=node->next;
		else
		{
			printf("文件写入失败！\n");
		}		
	}
	fclose(fp);
	return 0;
}
//从文件里面读取会员信息创建链表
struct information *readList(char *filename)
{
	FILE *fp=NULL;
    struct information *head=NULL;
	if((fp=fopen(filename,"a+"))==NULL)
	{
		printf("打开文件失败!\n");
		return NULL;
	}
	while(!feof(fp))
	{
        struct information *node=NULL;
        node=getNode();
		if(fread(node,sizeof(struct information),1,fp)==1)
		{
			node->next=head;
			head=node;
		}	
	}
	fclose(fp);
	return head;
}

//输出单个会员的信息
void Outputsingle(struct information *node)
{
	printf("客户姓名为--");
	printf("%s\n",node->name);
    printf("客户性别为--");
	printf("%s\n",node->sex);
	printf("客户的出生日期为--");
    printf("%d%d%d\n",node->birth.years,node->birth.months,node->birth.days);
    printf("客户的手机号码为--");
    printf("%s\n",node->userinformation.phonenumbers);
    printf("客户的身份证号码为--");
    printf("%s\n",node->userinformation.IDnumbers);
    printf("客户的办卡时间为--");
    printf("%s\n",node->userinformation.bankadata);
    printf("客户的卡有效时间为--");
    printf("%s\n",node->userinformation.uselimit);
}
//输出所有会员信息
void Outputall(struct information *head)
{
	while(head!=NULL)
	{
		printf("客户姓名为--");
		printf("%s\n",head->name);
		printf("客户性别为--");
		printf("%s\n",head->sex);
		printf("客户的出生日期为--");
		printf("%d%d%d\n",head->birth.years,head->birth.months,head->birth.days);
		printf("客户的手机号码为--");
		printf("%s\n",head->userinformation.phonenumbers);
		printf("客户的身份证号码为--");
		printf("%s\n",head->userinformation.IDnumbers);
		printf("客户的办卡时间为--");
		printf("%s\n",head->userinformation.bankadata);
		printf("客户的卡有效时间为--");
		printf("%s年\n",head->userinformation.uselimit);
		head=head->next;
	}
}
//将一个没有头结点的链表之中的会员信息删除
struct information * deleteNode(struct information *head,char *Idnumber)
{
	struct information *p=head;
	struct information *temp=NULL;
	if(head==NULL)
	{
		printf("链表里面还没有客户！\n");
		return NULL ;
	}
	else if(strcmp(Idnumber,p->userinformation.IDnumbers)==0)
	{
		temp=head;
		head=head->next;
		free(temp);
		printf("删除成功！\n");
	}	return head;	
}
//查询会员信息并输出
struct information * Inserchbyidnumber(struct information *head,char *Idnumber)
{
    struct information *p=head;
	if(head==NULL)
	{
		printf("链表是空的，查询失败！\n");
		return NULL;
	}
	else
	{
		while(p!=NULL&&strcmp(p->userinformation.IDnumbers,Idnumber)!=0)
		{
			p=p->next;
		}
	    return p;
	}
}
//修改会员的信息（通过身份证号码）
void changebyidnumbers(struct information *head,char *Idnumber)
{
	int i;
    struct information *p=head;
	if(head==NULL)
	{
		printf("链表是空的，修改失败！\n");
	}
	else
	{
		while(p!=NULL&&strcmp(p->userinformation.IDnumbers,Idnumber)!=0)
		{
			p=p->next;
		}
		while(i!=0)
		{
			printf("\n");
			printf("1-修改客户姓名\n");
			printf("2-修改客户性别(男为M，女为F)\n");
			printf("3-修改客户的出生日期\n");
			printf("4-修改客户的手机号码\n");
			printf("5-修改客户的身份证号码\n");
			printf("6-修改客户的办卡时间\n");
			printf("7-修改客户的卡有效时间\n");
			printf("0-退出修改\n");
			scanf("%d",&i);
			switch(i)
			{
				case 1:
					{
		     			printf("请输入客户姓名\n");
						fflush(stdin);
						gets(p->name);
					}break;
				case 2:
					{
						printf("请输入客户性别(男为M，女为F)\n");
						fflush(stdin);
						gets(p->sex);
					}break;
				case 3:
					{
						 printf("请输入客户的出生日期\n");
						 scanf("%d%d%d",&p->birth.years,&p->birth.months,&p->birth.days);
					}break;
				case 4:
					{
						printf("请输入客户的手机号码\n");
						fflush(stdin);
						gets(p->userinformation.phonenumbers);
					}break;
				case 5:
					{
						printf("请输入客户的身份证号码\n");
						fflush(stdin);
						gets(p->userinformation.IDnumbers);
					}break;
				case 6:
					{
						printf("请输入客户的办卡时间\n");
						fflush(stdin);
						gets(p->userinformation.bankadata);
					}break;
				case 7:
					{

						printf("请输入客户的卡有效时间\n");
						fflush(stdin);
						gets(p->userinformation.uselimit);
					}break;
				default :printf("请正确操作！\n");break;
			}
		}
        writeListFile(head);
		printf("修改成功！\n");
		system("pause");
	}
}
void Vipmeau()
{
    system("color 3F");
	int i;
	while(1)
	{
	  Print2();
      printf("\t请选择功能\n\t");
      scanf("%d",&i);
	  switch(i)
	  {
		   case 1:
			 {
			   system("cls");
               struct information *head=NULL;
			   char random;
			   head=getNode();
			   Inputinformation(head);
			   writeListFile(head);
			   printf("添加成功！\n");
			   printf("按任意键返回上一级菜单\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 2:
			 {
               system("cls");
               char random;
               struct information *node=NULL;
               struct information *p=NULL;
			   char idnumber[19];
			   printf("请输入您想查询会员的身份证号码\n");
			   fflush(stdin);
			   gets(idnumber);
               p=readList("VIPinformation.txt");
			   node=getNode();
			   node=Inserchbyidnumber(p,idnumber);
			   if(node!=NULL)
			   {
                 Outputsingle(node);
			   }
			   else
				   printf("这位客户不是会员！\n");
			   printf("按任意键返回上一级菜单\n");
               fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 3:
			 { 
                system("cls");
                char random;
                struct information *p=NULL;
				p=readList("VIPinformation.txt");
                Outputall(p);
                printf("按任意键返回上一级菜单\n");
                fflush(stdin);
			    random=getchar();
			    system("cls");
			 }break;
		 case 4:
			 {
               system("cls");
			   char random;
               struct information *node=NULL;
               struct information *p=NULL;
               char idnumber[19];
			   printf("请输入您想删除会员的身份证号码\n");
			   fflush(stdin);
			   gets(idnumber);
			   p=readList("VIPinformation.txt");
               node=getNode();
			   node=Inserchbyidnumber(p,idnumber);
               if(node==NULL)
			   {
				  printf("这位客户不是会员！\n");
			   }
			   else
			   {
                 deleteNode(p,idnumber);
				 printf("删除成功！\n");
			   }
			   writeListFile(p);
			   printf("按任意键返回上一级菜单\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 5:
			 {
               system("cls");
			   char random;
               struct information *p=NULL;
               struct information *node=NULL;
               char idnumber[19];
			   printf("请输入您想修改会员的身份证号码\n");
			   fflush(stdin);
			   gets(idnumber);
			   p=readList("VIPinformation.txt");
               node=getNode();
			   node=Inserchbyidnumber(p,idnumber);
               if(node!=NULL)
			   {
                 changebyidnumbers(p,idnumber);
				 printf("修改成功！\n");
			   }
			   else
				   printf("这位客户不是会员！\n");
			   printf("按任意键返回上一级菜单\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 0:
			 {
                 system("cls");
                 return ;
			 }
		  default:printf("请正确选择功能!");break;
	   }
	 }
}
/*int main()
{
   if(Admin()==-1)  //如果登录失败则退出
		exit(0);
   else
   {
     Vipmeau();
   }
   return 0;
}*/
//以上是会员信息的增,删,改,查

//为链表的每个客户申请内存
struct information1 *Getnode()
{
	struct information1 *node=NULL;
	node=(struct information1 *)malloc(sizeof(struct information1));
	if(node!=NULL)
	{
		memset(node,0,sizeof(struct information1));
		return node;
	}
	printf("申请内存失败！\n");
	return NULL;
}

//初始化客户上网信息
void Inputinformation1(struct information1 *head)
{
	if(head==NULL)
	{
		printf("初始化失败！\n");
	}
	else
	{
		struct information *node=NULL;
        struct information *p=NULL;
		char idnum[19];
        p=readList("VIPinformation.txt");
        node=getNode();
		printf("请输入客户的身份证号码\n");
        fflush(stdin);
		gets(idnum);
	    node=Inserchbyidnumber(p,idnum);
		if(node!=NULL)
		{
			float time;
			printf("该客户为会员,4元每小时\n");
		    strcpy(head->Idnumbers,idnum);
			printf("请输入客户的机器位置\n");
			fflush(stdin);
			gets(head->place);
			printf("请输入客户的上机时间\n");
			fflush(stdin);
			gets(head->beginusetime);
            printf("请输入客户的下机时间\n");
		    fflush(stdin);
			gets(head->lastusetime);
			printf("请输入客户的押金\n");
			scanf("%f",&head->deposit);
			printf("请输入该客户的上网时长\n");
			scanf("%f",&time);
			if((time*4)>=(head->deposit))
			{
				(head->lastmoney)=time*4;
				printf("该客户还应该交%d元钱\n",(time*4)-(head->deposit));
			}
		    else
			{
				head->lastmoney=time*4;
				printf("请退%d元钱给该客户\n",(head->deposit)-(time*4));
			}
			printf("办理成功！");
			system("pause");
		}
		else
		{
	        float time;
			printf("该客户为临时客户,5元每小时\n");
			strcpy(head->Idnumbers,idnum);
			printf("请输入客户的机器位置\n");
			fflush(stdin);
			gets(head->place);
			printf("请输入客户的上机时间\n");
			fflush(stdin);
			gets(head->beginusetime);
            printf("请输入客户的下机时间\n");
		    fflush(stdin);
			gets(head->lastusetime);
			printf("请输入客户的押金\n");
			scanf("%f",&head->deposit);
			printf("请输入该客户的上网时长\n");
			scanf("%f",&time);
			if(time<=8)
			{
		        if((time*5)>=(head->deposit))
				{
					(head->lastmoney)=time*5;
					printf("该客户还应该交%d元钱\n",(time*5)-(head->deposit));
				}
		       else
			   {
					head->lastmoney=time*5;
					printf("请退%d元钱给该客户\n",(head->deposit)-(time*5));
			   }
				printf("办理成功！");
				system("pause");
			}
		   else if(time>8&&time<=9)
		   {
              if((time*2)>=(head->deposit))
			  {
				(head->lastmoney)=time*2;
				printf("该客户还应该交%d元钱\n",(time*2)-(head->deposit));
			  }
			 else
			 {
				head->lastmoney=time*2;
				printf("请退%d元钱给该客户\n",(head->deposit)-(time*2));
			 }
				printf("办理成功！");
				system("pause");
		   }
		   else
		   {
				if((time*4.5)>=(head->deposit))
				{
					(head->lastmoney)=time*4.5;
					printf("该客户还应该交%d元钱\n",(time*4.5)-(head->deposit));
				}
				else
				{
					head->lastmoney=time*4.5;
					printf("请退%d元钱给该客户\n",(head->deposit)-(time*4.5));
				}
				printf("办理成功！");
				system("pause");
		   }
		}
	}
}
//将客户上网信息写到文件里面
int writeListFILE(struct information1 *head)
{

	struct information1 *node=head;

	FILE *fp=NULL;

	fp=fopen("userinformation.txt","a+");

	if(fp==NULL)
	{
		printf("打开文件失败！\n");
		return 1;
	}
	while(node!=NULL)
	{
		
		if(fwrite(node,sizeof(struct information1),1,fp)==1)		
			node=node->next;
		else
		{
			printf("文件写入失败！\n");
		}		
	}
	printf("文件写入成功!\n");
	fclose(fp);
	return 0;
}

//读取客户上网信息以创建链表
struct information1 *ReadList(char *filename)
{
	FILE *fp=NULL;
    struct information1 *head=NULL;
	if((fp=fopen(filename,"a+"))==NULL)
	{
		printf("open file failed!\n");
		return NULL;
	}
	while(!feof(fp))
	{
        struct information1 *node=NULL;
        node=Getnode();
		if(fread(node,sizeof(struct information1),1,fp)==1)
		{
			node->next=head;
			head=node;
		}		
	}
	fclose(fp);
	return head;
}

//输出客户上网信息
void OUTput(struct information1 *head)
{
    system("mode con cols=70 lines=30");
    printf("   身份证号           机器位置       上机时间          押金   实际消费\n");
	while(head!=NULL)
	{
		printf("%s     %s       %s     %.f     %.f\n",head->Idnumbers,head->place,head->beginusetime,head->deposit,head->lastmoney);
		head=head->next;
	}
}
void Help()
{
	system("3F");
    system("mode con cols=70 lines=30");
	printf("\t\t          *******         *******\n");
    printf("\t\t        **********        **********\n");
	printf("\t\t       *************     *************\n");
	printf("\t\t      ********************************\n");
	printf("\t\t      ********************************\n");
	printf("\t\t      ********************************\n");
	printf("\t\t       ******************************\n");
	printf("\t\t        *****************************\n");
	printf("\t\t         **************************\n");
	printf("\t\t           **********************\n");
	printf("\t\t             ******************\n");
	printf("\t\t              ***************\n");
	printf("\t\t               *************\n");
	printf("\t\t                 *********\n");
	printf("\t\t                   *****\n");
	printf("\t\t                    **\n");
	printf("该系统名为“业纯网吧管理系统”。该系统可以为网吧的管理员提供”客户办卡服务、客户上网登记、查看网吧营业额、查看客户上网信息“等功能。");
    printf("该系统中客户上网的计价标准为普通卡5元钱每小时，会员卡4元钱每小时。普通卡消费计时若高于8小时但小于9小时，则每小时按照2元计算，若");
    printf("高于9小小时，按照4.5元钱每小时计算。   \n");
	printf("如使用过程中出现bug,请联系本人\(^o^)/,QQ:1435398529\n");
	printf("注:管理员姓名为:苏业纯,密码初始为520 \n");
}
//客户上网登记
void Menu()
{
	system("3F");
	int i;
	while(1)
	{
		Print1();
		printf("\t请选择功能\n\t");
		scanf("%d",&i);
		switch(i)
		{
		 case 1:
			 {
			   system("cls");
			   char random;
			   Vipmeau();
			   printf("按任意键返回上一级菜单\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 2:
			 {
			   system("cls");
			   struct information1 *head=NULL;
			   char random;
			   head=Getnode();
			   Inputinformation1(head);
			   writeListFILE(head);
			   printf("按任意键返回上一级菜单\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 3:
			 {
			   system("cls");
			   struct information1 *head=NULL;
			   head=ReadList("userinformation.txt");
			   OUTput(head);
			   system("pause");
			   system("cls");
			 }break;
		 case 4:
			 {
				 system("cls");
				 Help();
				 system("pause");
				 system("cls");
			 }break;
		 case 0:
			 {
				 system("cls");
				 printf("\n\n\n\n\n\n\n\n\n");
				 printf("\t   正在退出......\n");
				 printf("\t   欢迎下次使用!\n");
				 Sleep(1300);
				 exit(0);
			 }break;
		 default:printf("请正确操作!\n");break;
		}
	}
}
int main()
{
	 if(Admin()==-1)   //如果登录失败则退出
	 exit(0);
	 else
	 Menu();
	 return 0;
}
