import java.util.*;

class HashTable{

final int n=10;

public void insert(int data[],boolean flag[], int x)
{
int i,j;
j= x%n;
for(i=0;i<n;i++)
{
if(flag[j]==false){
data[j]=x;
flag[j]=true;
return;
}
else
{
j=(j+1)%n;
}
}
System.out.println("Hash table is full");
}

public int search(int data[],boolean flag[],int x)
{
int i,j;
j=x%n;
for(i=0;i<n;i++)
{
if(flag[j]==true && data[j]==x)
{
return(j);
}
else
{
j=(j+1)%n;
}
}
return(-1);
}


public void print(int data[], boolean flag[])
{
int i;
for(i=0;i<n;i++)
{
if(flag[i])
{
System.out.println(data[i]);
}
else
{
System.out.println("___");
}
}
}

}
class Liner_probing{
public static void main(String args[]){
int n=10;
int data[]=new int[n];
boolean flag[]=new boolean[n];
int i,j,x,op,loc;

Scanner sc = new Scanner(System.in);

for(i=0;i<n;i++){
flag[i] = false;
}

do{
System.out.println("\n1)Insert\n2)Search\n3)Print\n4)Quit");

System.out.println("Enter your Choice");
op = sc.nextInt();

switch(op)
{
case 1: System.out.println("\n Enter the number to be inserted:");
int a = sc.nextInt();
HashTable HS = new HashTable();
HS.insert(data, flag, a);
break;
case 2: System.out.println("\n Enter a number to be searched:");
int b = sc.nextInt();
HashTable HS1 = new HashTable();
if((loc=HS1.search(data,flag,b)) == -1){
System.out.println("Element is not found:");
}
else{
System.out.println("Found at the location "+loc);
}
break;
case 3: HashTable HS2 = new HashTable();
HS2.print(data,flag);
break;
}
} while(op!=4);

}
}





