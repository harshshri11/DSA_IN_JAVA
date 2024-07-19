import java.util.*;

class quick_sort_demo{
static void quick_sort(int a[],int l,int u){
int j;
if(l<u){
j=partition(a,l,u);
quick_sort(a,l,j-1);
quick_sort(a,j+1,u);
}
}

static int partition(int a[],int l, int u){
int v,i,j,temp;
v=a[l];
i=l;
j=u+1;
do
{
do
i++;
while(a[i]<v && i<=u);
do 
j--;
while(v<a[j]);
if(i<j)
{
temp=a[i];
a[i]=a[j];
a[j]=temp;
}
} 
while(i<j);
a[l]=a[j];
a[j]=v;
return j;
}


public static void main(String args[]){

Scanner sc = new Scanner(System.in);
System.out.println("enter the num numbers: ");
int n = sc.nextInt();

int i,temp,j;
System.out.println("enter the element");
int a[] = new int[n];
for(i=0;i<n;i++)
{
a[i] = sc.nextInt();
}
quick_sort(a,0,n-1);
System.out.println("sorted array is:");
for(i=0;i<n;i++){
System.out.println(a[i]);

}
}
}








