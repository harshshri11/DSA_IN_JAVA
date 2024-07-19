import java.util.*;
class Node{
public int data;
public Node next;
Node(int data)
{
this.data=data;
}
public Node(int data, Node next){
this.data = data;
this.next = next;
}
}

class linked_list_demo{
public static void main(String args[]){

Scanner sc = new Scanner(System.in);
Node p;
System.out.println("enter data: ");
int y = sc.nextInt();
Node start = new Node(y);
p=start;

for(int i=0; i<4; i++)
{
System.out.println("enter data: ");
int x = sc.nextInt();
p=p.next=new Node(x);
}

System.out.println("linked list is: ");

for(p=start;p!=null; p=p.next)
System.out.println(p.data);
p=start;
System.out.println("Insert element in the linked list: ");
int a = sc.nextInt();
if(start == null || start.data > a){
start =  new Node(a,start);
}

while(p.next != null){
if(p.next.data > a) break;
p=p.next;
}

p.next = new Node(a,p.next);
System.out.println("After inserting: ");
for(p=start;p!=null; p=p.next)
System.out.println(p.data);
}
}