#include<stdio.h>
#define max 30
typedef struct edge
{
    int. u,v,w;
}edge;
void sort(edge data[max], int n)
{
    int i,j;
    edge temp;
    for(i=1;i<n;i++)
        for(j=0;j<n-i;j++)
            if(data[j].w>data[j+1].w)
            {
                temp=data[j];
                data[j]=data[j+1];
                data[j+1]=temp;
            }
}
void print(edge spanlist[max], int n)
{
    int i, cost=0;
    for(i=0;i<n;i++)
    {
        printf("\n%d\t%d\t%d", spanlist[i].u, spanlist[i].v, spanlist[i].w);
        cost=cost+spanlist[i].w;
    }
    printf("\nCost of spanning tree: %d", cost);
}
void readgraph(int G[max][max], int n)
{
    int i,j;
    printf("Enter adjacency matrix: ");
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            scanf("%d", &G[i][j]);
}

void printgraph(int G[max][max], int n)
{
    int i,j;
    for(i=0;i<n;i++)
    {
        printf("\n");
        for(j=0;j<n;j++)
            printf("%d\t", G[i][j]);
    }
}

int find(int belongs[], int vertexno)
{
    return(belongs[vertexno]);
}

void union1(int belongs[], int c1, int c2, int n)
{
    int i;
    for(i=0;i<n;i++)
        if(belongs[i]==c2)
            belongs[i]=c1;
}
void kruskal(edge spanlist[max], edge data[max], int G[max][max], int n)
{
    int belongs[max],i,j,c1,c2,no=0;
    int num=0;
    for(i=1;i<n;i++)
        for(j=0;j<i;j++)
        {
            if(G[i][j]!=0)
            {
                data[no].u=i;
                data[no].v=j;
                data[no].w=G[i][j];
                no++;
            }
        }
        
    sort(data, no);
    for(i=0;i<n;i++)
    {
        belongs[i]=i;
    }
    for(i=0;i<no;i++)
    {
        c1=find(belongs, data[i].u);
        c2=find(belongs,data[i].v);
        if(c1!=c2)
        {
            spanlist[num]=data[i];
            num++;
            union1(belongs,c1,c2,n);
        }
    }
    printf("%d  ",num);
print(spanlist,num);
}

void main()
{
    edge spanlist[max];
    edge data[max];
    int g1[max][max];
    int n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);
    readgraph(g1,n);
    //int num=
    kruskal(spanlist, data, g1,n);
    
}
