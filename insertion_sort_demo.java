import java.util.*;
class insertion_sort_demo{
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

System.out.println("element in the array is");
for(i=0;i<n;i++){
System.out.println(a[i]);
}

for(i=1;i<n;i++)
{
temp = a[i];
for(j=i-1;a[j]>temp && j>=1;j--)
{
a[j+1] = a[j];
}
if(a[j]>temp)
{
a[j+1]=a[j];
a[j]=temp;
}
else
a[j+1] = temp;
}

System.out.println("sorted array");
for(i=0;i<n;i++)
{
System.out.println(a[i]+" ");
}

}
}