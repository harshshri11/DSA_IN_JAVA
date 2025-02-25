#define infinity 9999
#define max 20
#include<stdio.h>
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

int prims(int G[max][max], int spanning[max][max],int n)
{
    int cost[max][max];
    int u,v,min_distance,i,j,min_cost,edge_number;
    int distance[max], from[max], visited[max];
    
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
        {
            if(G[i][j]==0)
                cost[i][j]=infinity;
            else
                cost[i][j]=G[i][j];
            spanning[i][j]=0;
        }
    distance[0]=0;
    visited[0]=1;
    for(i=1;i<n;i++)
    {
        distance[i]=cost[0][i];
        from[i]=0;
        visited[i]=0;
    }
    min_cost=0;
    edge_number=n-1;
    while(edge_number>0)
    {
        min_distance=infinity;
        for(i=1;i<n;i++)
            if(visited[i]==0 && distance[i]<min_distance)
            {
                v=i;
                min_distance=distance[i];
            }
        u=from[v];
        spanning[u][v]=distance[v];
        spanning[v][u]=distance[v];
        edge_number--;
        visited[v]=1;
        for(i=1;i<n;i++)
            if(visited[i]==0 && cost[i][v]<distance[i])
            {
                distance[i]=cost[i][v];
                from[i]=v;
            }
        min_cost=min_cost+cost[u][v];
    }
    return(min_cost);
}

void main()
{
    int G[max][max];
    int spanning[max][max];
    int n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);
    readgraph(G, n);
    int total=prims(G,spanning, n);
    printf("\nSpanning tree is:\n");
    printgraph(spanning, n);
    printf("\nTotal cost= %d", total );
}