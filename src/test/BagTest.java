package test;

import java.util.Scanner;

public class BagTest
{
	 @SuppressWarnings("resource")
    public static void main(String[] args)
    {  
		 /*
		  * @author ����
		  */
     /*==============��������벿��==================
      *        bagVolume       ����������
      *        number          ��ѡ��Ʒ������
      *        singleVolume    ������Ʒ������
      *        singlePrice     ��Ӧ��Ʒ�Ľ��
	   ==============================================*/ 
	  Scanner cin = new Scanner(System.in); 
      //�������ɵ�������
      System.out.print("===���������������===");
      System.out.println("");
      int bagVolume = cin.nextInt(); 
      //��ѡ�����Ʒ�ĸ���
      System.out.print("===��������Ʒ��������===");
      System.out.println("");
      int number = cin.nextInt();
      
      int singleVolume[] = new int[number];
      int singlePrice[] = new int[number];
      System.out.print("===ѭ������"+number+"����Ʒ������===");
      System.out.println("");
      for(int i=0;i<number;i++) //ѭ������ÿ����Ʒ������
      {
    	  singleVolume[i] = cin.nextInt();
      }
      System.out.print("===ѭ����Ӧ����"+number+"����Ʒ�ļ۸�===");
      System.out.println("");
      for(int i=0;i<number;i++) //ѭ������ÿ����Ʒ�ļ۸�
      {
    	  singlePrice[i] = cin.nextInt();
      }
      
      /*==============��������ʼ================*/
      int Value[][] = new int[number][bagVolume];
      int temp1,temp2;
      for(int i=0;i<number;i++)
    	  for(int j=0;j<bagVolume;j++)
    		  {
    		  //����һ������д����
    		  if(i==0)
    		  {
    			  if((j+1>=singleVolume[i]))
    				  Value[i][j]=singlePrice[i];
    			  else
    				  Value[i][j]=0;					  
    		  }
    		  else
    		  {
    			  //��ʼ��temp1,2��ֵ
    			  temp1=0;temp2=0;
    			  //temp�д治�������Ʒ������ֵ
    			  temp1 = Value[i-1][j];
    			  //��Ÿ���Ʒ������ֵ
    			  if(j+1>=singleVolume[i])   				  
    				  {
    				  if(j+1==singleVolume[i]) temp2=singlePrice[i];//�պô�Ÿ���Ʒ�ļ�ֵ
    				  else temp2=singlePrice[i]+Value[i-1][j+1-singleVolume[i]-1];//ʣ��ռ������ֵ
    				  }
    			  else
    				  temp2=Value[i-1][j];
    			 Value[i][j]=temp1>temp2?temp1:temp2; 
    			  
    		  }
    		  }
      for(int i=0;i<number;i++)
      {   	  
    	  for(int j=0;j<bagVolume;j++)
    		  {
    		System.out.print(Value[i][j]+"  ");
    		  }  
    	  System.out.println("");
      }
      System.out.println("����Ϊ"+bagVolume+"ǧ�˵İ���װ����ֵΪ"+Value[number-1][bagVolume-1]);      
    }
}