/***************************************************************************************************************************************
    ��ϵͳ��Ϊ��ҵ�����ɹ���ϵͳ������ϵͳ����Ϊ���ɵĹ���Ա�ṩ���ͻ��쿨���񡢿ͻ������Ǽǡ��鿴����Ӫҵ��鿴�ͻ�������Ϣ���ȹ��ܡ�

    ��ϵͳ�пͻ������ļƼ۱�׼Ϊ��ͨ��5ԪǮÿСʱ����Ա��4ԪǮÿСʱ����ͨ�����Ѽ�ʱ������8Сʱ��С��9Сʱ����ÿСʱ����2Ԫ���㣬��
    ����9ССʱ������4.5ԪǮÿСʱ���㡣�����Ǹ�ϵͳ��Դ���롣   ע:����Ա����Ϊ:��ҵ��,�����ʼΪ520
***************************************************************************************************************************************/
#include <stdio.h>
#include <math.h>
#include <windows.h>
#include <stdlib.h>
#include <conio.h>
#include <stdio.h>

//��Ա������Ϣ����
struct birthdate
{
	int years;
	int months;
	int days;
};
//��Աʹ����Ϣ����
struct usedata
{
	char phonenumbers[12];
	char IDnumbers[19];
	char bankadata[20];  //��Ա���İ���ʱ��
	char uselimit[5];  //��Ա������Чʱ�� 
};
//��Ա������Ϣ����
struct information
{
	char name[20];
	char sex[5];
    struct birthdate birth;
    struct usedata userinformation;
    struct information *next;
};
//�ͻ�������Ϣ
struct information1
{
	char Idnumbers[19];
	char place[5];          //�ͻ��Ļ���λ��
    char beginusetime[20];  //�ͻ����ϻ�ʱ��
	float deposit;            //�ͻ�����Ѻ��
    char lastusetime[20];   //�ͻ����»�ʱ��
	float lastmoney;          //�ͻ���ʵ�����ѽ��
    struct information1 *next;
};

//����������
void goto_pos(int x, int y) //(��,��)
{
	
	COORD coord = {x,y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), coord);

}

//��¼����
int Admin() 
{

	system("mode con cols=30 lines=22");
	system("color 3F");
	int i;
	char name[10]={"��ҵ��"},password[10]={"520"};
	char get_1[10],get_2[10];
	for(i=0;i<3;i++) {
		system("cls");
		printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
		printf("          ����Ա��¼\n\n");
		printf("    ���שששששששששש�\n");
		printf("    �ǵ�¼��:             ��\n");
	    printf("    ���ߩߩߩߩߩߩߩߩߩߩ�\n");
	    printf("\n");
		printf("    ���שששששששששש�\n");
		printf("    ������:               ��\n");
	    printf("    ���ߩߩߩߩߩߩߩߩߩߩ�\n");
		printf("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		fflush(stdin);
		goto_pos(13,7);
		scanf("%10s",get_1);
		fflush(stdin);
		goto_pos(11,11);
		scanf("%10s",get_2);
		if(strcmp(name,get_1)==0&&strcmp(password,get_2)==0){
			goto_pos(11,17);
			printf("��¼�ɹ�!");
			Sleep(800);
			return 0;
		}else{
			goto_pos(11,17);
			printf("�������\n   ���������� (ʣ�����:%d)",2-i);
			Sleep(1300);
		}
	}
	return -1;
}

//������
void Print1()
{
    system("mode con cols=40 lines=25");
    system("color 3F");
	printf("\n\n\n");
	printf("\t�X�j�j�j�j�j�j�j�j�j�j�j�j�[\n");
	printf("\t�d                        �g\n");
    printf("\t�d  �����Ա��Ϣ-------1  �g\n");
	printf("\t�d  �ͻ������Ǽ�-------2  �g\n");
	printf("\t�d  �鿴������Ӫ���---3  �g\n");
	printf("\t�d  ����---------------4  �g\n");
	printf("\t�d  �˳���¼-----------0  �g\n");
    printf("\t�d                        �g\n");
	printf("\t�^�m�m�m�m�m�m�m�m�m�m�m�m�a\n");
}
void Print2()
{
   system("mode con cols=50 lines=20");
   system("color 3F");
   printf("\n\n\n\n");
   printf("\t�X�j�j�j�j�j�j�j�j�j�j�j�j�j�[\n");
   printf("\t�d  ע���»�Ա------------1 �g\n");
   printf("\t�d  �鿴��Ա��Ϣ----------2 �g\n");
   printf("\t�d  �鿴���л�Ա��Ϣ------3 �g\n");
   printf("\t�d  ɾ����Ա--------------4 �g\n");
   printf("\t�d  �޸Ļ�Ա��Ϣ----------5 �g\n");
   printf("\t�d  ������һ���˵�--------0 �g\n");
   printf("\t�^�m�m�m�m�m�m�m�m�m�m�m�m�m�a\n");
}

//Ϊ�����ÿ����Ա�����ڴ�
struct information *getNode()
{
	struct information *node=NULL;
	node=(struct information *)malloc(sizeof(struct information));
	if(node!=NULL)
	{
		memset(node,0,sizeof(struct information));
		return node;
	}
	printf("�����ڴ�ʧ�ܣ�\n");
	return NULL;
}
//��ʼ����Ա��Ϣ
void Inputinformation(struct information *head)
{
	if(head==NULL)
	{
		printf("��ʼ������ʧ�ܣ�\n");
	}
	else
	{
		printf("������ͻ�����\n");
		fflush(stdin);
		gets(head->name);
		printf("������ͻ��Ա�(��ΪM��ŮΪF)\n");
		fflush(stdin);
		gets(head->sex);
		printf("������ͻ��ĳ�������\n");
		scanf("%d%d%d",&head->birth.years,&head->birth.months,&head->birth.days);
		printf("������ͻ����ֻ�����\n");
		fflush(stdin);
		gets(head->userinformation.phonenumbers);
		printf("������ͻ������֤����\n");
		fflush(stdin);
		gets(head->userinformation.IDnumbers);
		printf("������ͻ��İ쿨ʱ��\n");
		fflush(stdin);
		gets(head->userinformation.bankadata);
		printf("������ͻ��Ŀ���Чʱ��\n");
		fflush(stdin);
		gets(head->userinformation.uselimit);
	}
}
//����Ա��Ϣд���ļ�����
int writeListFile(struct information *head)
{

	struct information *node=head;

	FILE *fp=NULL;

	fp=fopen("VIPinformation.txt","a+");

	if(fp==NULL)
	{
		printf("���ļ�ʧ�ܣ�\n");
		return 1;
	}
	
	while(node!=NULL)
	{
		
		if(fwrite(node,sizeof(struct information),1,fp)==1)		
			node=node->next;
		else
		{
			printf("�ļ�д��ʧ�ܣ�\n");
		}		
	}
	fclose(fp);
	return 0;
}
//���ļ������ȡ��Ա��Ϣ��������
struct information *readList(char *filename)
{
	FILE *fp=NULL;
    struct information *head=NULL;
	if((fp=fopen(filename,"a+"))==NULL)
	{
		printf("���ļ�ʧ��!\n");
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

//���������Ա����Ϣ
void Outputsingle(struct information *node)
{
	printf("�ͻ�����Ϊ--");
	printf("%s\n",node->name);
    printf("�ͻ��Ա�Ϊ--");
	printf("%s\n",node->sex);
	printf("�ͻ��ĳ�������Ϊ--");
    printf("%d%d%d\n",node->birth.years,node->birth.months,node->birth.days);
    printf("�ͻ����ֻ�����Ϊ--");
    printf("%s\n",node->userinformation.phonenumbers);
    printf("�ͻ������֤����Ϊ--");
    printf("%s\n",node->userinformation.IDnumbers);
    printf("�ͻ��İ쿨ʱ��Ϊ--");
    printf("%s\n",node->userinformation.bankadata);
    printf("�ͻ��Ŀ���Чʱ��Ϊ--");
    printf("%s\n",node->userinformation.uselimit);
}
//������л�Ա��Ϣ
void Outputall(struct information *head)
{
	while(head!=NULL)
	{
		printf("�ͻ�����Ϊ--");
		printf("%s\n",head->name);
		printf("�ͻ��Ա�Ϊ--");
		printf("%s\n",head->sex);
		printf("�ͻ��ĳ�������Ϊ--");
		printf("%d%d%d\n",head->birth.years,head->birth.months,head->birth.days);
		printf("�ͻ����ֻ�����Ϊ--");
		printf("%s\n",head->userinformation.phonenumbers);
		printf("�ͻ������֤����Ϊ--");
		printf("%s\n",head->userinformation.IDnumbers);
		printf("�ͻ��İ쿨ʱ��Ϊ--");
		printf("%s\n",head->userinformation.bankadata);
		printf("�ͻ��Ŀ���Чʱ��Ϊ--");
		printf("%s��\n",head->userinformation.uselimit);
		head=head->next;
	}
}
//��һ��û��ͷ��������֮�еĻ�Ա��Ϣɾ��
struct information * deleteNode(struct information *head,char *Idnumber)
{
	struct information *p=head;
	struct information *temp=NULL;
	if(head==NULL)
	{
		printf("�������滹û�пͻ���\n");
		return NULL ;
	}
	else if(strcmp(Idnumber,p->userinformation.IDnumbers)==0)
	{
		temp=head;
		head=head->next;
		free(temp);
		printf("ɾ���ɹ���\n");
	}	return head;	
}
//��ѯ��Ա��Ϣ�����
struct information * Inserchbyidnumber(struct information *head,char *Idnumber)
{
    struct information *p=head;
	if(head==NULL)
	{
		printf("�����ǿյģ���ѯʧ�ܣ�\n");
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
//�޸Ļ�Ա����Ϣ��ͨ�����֤���룩
void changebyidnumbers(struct information *head,char *Idnumber)
{
	int i;
    struct information *p=head;
	if(head==NULL)
	{
		printf("�����ǿյģ��޸�ʧ�ܣ�\n");
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
			printf("1-�޸Ŀͻ�����\n");
			printf("2-�޸Ŀͻ��Ա�(��ΪM��ŮΪF)\n");
			printf("3-�޸Ŀͻ��ĳ�������\n");
			printf("4-�޸Ŀͻ����ֻ�����\n");
			printf("5-�޸Ŀͻ������֤����\n");
			printf("6-�޸Ŀͻ��İ쿨ʱ��\n");
			printf("7-�޸Ŀͻ��Ŀ���Чʱ��\n");
			printf("0-�˳��޸�\n");
			scanf("%d",&i);
			switch(i)
			{
				case 1:
					{
		     			printf("������ͻ�����\n");
						fflush(stdin);
						gets(p->name);
					}break;
				case 2:
					{
						printf("������ͻ��Ա�(��ΪM��ŮΪF)\n");
						fflush(stdin);
						gets(p->sex);
					}break;
				case 3:
					{
						 printf("������ͻ��ĳ�������\n");
						 scanf("%d%d%d",&p->birth.years,&p->birth.months,&p->birth.days);
					}break;
				case 4:
					{
						printf("������ͻ����ֻ�����\n");
						fflush(stdin);
						gets(p->userinformation.phonenumbers);
					}break;
				case 5:
					{
						printf("������ͻ������֤����\n");
						fflush(stdin);
						gets(p->userinformation.IDnumbers);
					}break;
				case 6:
					{
						printf("������ͻ��İ쿨ʱ��\n");
						fflush(stdin);
						gets(p->userinformation.bankadata);
					}break;
				case 7:
					{

						printf("������ͻ��Ŀ���Чʱ��\n");
						fflush(stdin);
						gets(p->userinformation.uselimit);
					}break;
				default :printf("����ȷ������\n");break;
			}
		}
        writeListFile(head);
		printf("�޸ĳɹ���\n");
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
      printf("\t��ѡ����\n\t");
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
			   printf("��ӳɹ���\n");
			   printf("�������������һ���˵�\n");
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
			   printf("�����������ѯ��Ա�����֤����\n");
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
				   printf("��λ�ͻ����ǻ�Ա��\n");
			   printf("�������������һ���˵�\n");
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
                printf("�������������һ���˵�\n");
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
			   printf("����������ɾ����Ա�����֤����\n");
			   fflush(stdin);
			   gets(idnumber);
			   p=readList("VIPinformation.txt");
               node=getNode();
			   node=Inserchbyidnumber(p,idnumber);
               if(node==NULL)
			   {
				  printf("��λ�ͻ����ǻ�Ա��\n");
			   }
			   else
			   {
                 deleteNode(p,idnumber);
				 printf("ɾ���ɹ���\n");
			   }
			   writeListFile(p);
			   printf("�������������һ���˵�\n");
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
			   printf("�����������޸Ļ�Ա�����֤����\n");
			   fflush(stdin);
			   gets(idnumber);
			   p=readList("VIPinformation.txt");
               node=getNode();
			   node=Inserchbyidnumber(p,idnumber);
               if(node!=NULL)
			   {
                 changebyidnumbers(p,idnumber);
				 printf("�޸ĳɹ���\n");
			   }
			   else
				   printf("��λ�ͻ����ǻ�Ա��\n");
			   printf("�������������һ���˵�\n");
			   fflush(stdin);
			   random=getchar();
			   system("cls");
			 }break;
		 case 0:
			 {
                 system("cls");
                 return ;
			 }
		  default:printf("����ȷѡ����!");break;
	   }
	 }
}
/*int main()
{
   if(Admin()==-1)  //�����¼ʧ�����˳�
		exit(0);
   else
   {
     Vipmeau();
   }
   return 0;
}*/
//�����ǻ�Ա��Ϣ����,ɾ,��,��

//Ϊ�����ÿ���ͻ������ڴ�
struct information1 *Getnode()
{
	struct information1 *node=NULL;
	node=(struct information1 *)malloc(sizeof(struct information1));
	if(node!=NULL)
	{
		memset(node,0,sizeof(struct information1));
		return node;
	}
	printf("�����ڴ�ʧ�ܣ�\n");
	return NULL;
}

//��ʼ���ͻ�������Ϣ
void Inputinformation1(struct information1 *head)
{
	if(head==NULL)
	{
		printf("��ʼ��ʧ�ܣ�\n");
	}
	else
	{
		struct information *node=NULL;
        struct information *p=NULL;
		char idnum[19];
        p=readList("VIPinformation.txt");
        node=getNode();
		printf("������ͻ������֤����\n");
        fflush(stdin);
		gets(idnum);
	    node=Inserchbyidnumber(p,idnum);
		if(node!=NULL)
		{
			float time;
			printf("�ÿͻ�Ϊ��Ա,4ԪÿСʱ\n");
		    strcpy(head->Idnumbers,idnum);
			printf("������ͻ��Ļ���λ��\n");
			fflush(stdin);
			gets(head->place);
			printf("������ͻ����ϻ�ʱ��\n");
			fflush(stdin);
			gets(head->beginusetime);
            printf("������ͻ����»�ʱ��\n");
		    fflush(stdin);
			gets(head->lastusetime);
			printf("������ͻ���Ѻ��\n");
			scanf("%f",&head->deposit);
			printf("������ÿͻ�������ʱ��\n");
			scanf("%f",&time);
			if((time*4)>=(head->deposit))
			{
				(head->lastmoney)=time*4;
				printf("�ÿͻ���Ӧ�ý�%dԪǮ\n",(time*4)-(head->deposit));
			}
		    else
			{
				head->lastmoney=time*4;
				printf("����%dԪǮ���ÿͻ�\n",(head->deposit)-(time*4));
			}
			printf("����ɹ���");
			system("pause");
		}
		else
		{
	        float time;
			printf("�ÿͻ�Ϊ��ʱ�ͻ�,5ԪÿСʱ\n");
			strcpy(head->Idnumbers,idnum);
			printf("������ͻ��Ļ���λ��\n");
			fflush(stdin);
			gets(head->place);
			printf("������ͻ����ϻ�ʱ��\n");
			fflush(stdin);
			gets(head->beginusetime);
            printf("������ͻ����»�ʱ��\n");
		    fflush(stdin);
			gets(head->lastusetime);
			printf("������ͻ���Ѻ��\n");
			scanf("%f",&head->deposit);
			printf("������ÿͻ�������ʱ��\n");
			scanf("%f",&time);
			if(time<=8)
			{
		        if((time*5)>=(head->deposit))
				{
					(head->lastmoney)=time*5;
					printf("�ÿͻ���Ӧ�ý�%dԪǮ\n",(time*5)-(head->deposit));
				}
		       else
			   {
					head->lastmoney=time*5;
					printf("����%dԪǮ���ÿͻ�\n",(head->deposit)-(time*5));
			   }
				printf("����ɹ���");
				system("pause");
			}
		   else if(time>8&&time<=9)
		   {
              if((time*2)>=(head->deposit))
			  {
				(head->lastmoney)=time*2;
				printf("�ÿͻ���Ӧ�ý�%dԪǮ\n",(time*2)-(head->deposit));
			  }
			 else
			 {
				head->lastmoney=time*2;
				printf("����%dԪǮ���ÿͻ�\n",(head->deposit)-(time*2));
			 }
				printf("����ɹ���");
				system("pause");
		   }
		   else
		   {
				if((time*4.5)>=(head->deposit))
				{
					(head->lastmoney)=time*4.5;
					printf("�ÿͻ���Ӧ�ý�%dԪǮ\n",(time*4.5)-(head->deposit));
				}
				else
				{
					head->lastmoney=time*4.5;
					printf("����%dԪǮ���ÿͻ�\n",(head->deposit)-(time*4.5));
				}
				printf("����ɹ���");
				system("pause");
		   }
		}
	}
}
//���ͻ�������Ϣд���ļ�����
int writeListFILE(struct information1 *head)
{

	struct information1 *node=head;

	FILE *fp=NULL;

	fp=fopen("userinformation.txt","a+");

	if(fp==NULL)
	{
		printf("���ļ�ʧ�ܣ�\n");
		return 1;
	}
	while(node!=NULL)
	{
		
		if(fwrite(node,sizeof(struct information1),1,fp)==1)		
			node=node->next;
		else
		{
			printf("�ļ�д��ʧ�ܣ�\n");
		}		
	}
	printf("�ļ�д��ɹ�!\n");
	fclose(fp);
	return 0;
}

//��ȡ�ͻ�������Ϣ�Դ�������
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

//����ͻ�������Ϣ
void OUTput(struct information1 *head)
{
    system("mode con cols=70 lines=30");
    printf("   ���֤��           ����λ��       �ϻ�ʱ��          Ѻ��   ʵ������\n");
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
	printf("��ϵͳ��Ϊ��ҵ�����ɹ���ϵͳ������ϵͳ����Ϊ���ɵĹ���Ա�ṩ���ͻ��쿨���񡢿ͻ������Ǽǡ��鿴����Ӫҵ��鿴�ͻ�������Ϣ���ȹ��ܡ�");
    printf("��ϵͳ�пͻ������ļƼ۱�׼Ϊ��ͨ��5ԪǮÿСʱ����Ա��4ԪǮÿСʱ����ͨ�����Ѽ�ʱ������8Сʱ��С��9Сʱ����ÿСʱ����2Ԫ���㣬��");
    printf("����9ССʱ������4.5ԪǮÿСʱ���㡣   \n");
	printf("��ʹ�ù����г���bug,����ϵ����\(^o^)/,QQ:1435398529\n");
	printf("ע:����Ա����Ϊ:��ҵ��,�����ʼΪ520 \n");
}
//�ͻ������Ǽ�
void Menu()
{
	system("3F");
	int i;
	while(1)
	{
		Print1();
		printf("\t��ѡ����\n\t");
		scanf("%d",&i);
		switch(i)
		{
		 case 1:
			 {
			   system("cls");
			   char random;
			   Vipmeau();
			   printf("�������������һ���˵�\n");
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
			   printf("�������������һ���˵�\n");
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
				 printf("\t   �����˳�......\n");
				 printf("\t   ��ӭ�´�ʹ��!\n");
				 Sleep(1300);
				 exit(0);
			 }break;
		 default:printf("����ȷ����!\n");break;
		}
	}
}
int main()
{
	 if(Admin()==-1)   //�����¼ʧ�����˳�
	 exit(0);
	 else
	 Menu();
	 return 0;
}
