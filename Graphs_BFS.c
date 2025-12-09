#include <stdio.h>
#define N 5

int adj[N][N];
int visited[N] = {0};
int queue[N], front = -1, rear = -1;

void enqueue(int v){
    if(rear == N-1) return;
    if(front == -1) front = 0;
    queue[++rear] = v;
}

int dequeue(){
    if(front == -1 || front > rear) return -1;
    return queue[front++];
}

void BFS(int v){
    int i;
    visited[v] = 1;
    enqueue(v);

    while(front != -1){
        int node = dequeue();
        if(node == -1) break;

        printf("%d ", node);

        for(i = 0; i < N; i++){
            if(adj[node][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                enqueue(i);
            }
        }
    }
}

int main(){
    int i, j;

    printf("Enter Adjacency Matrix:\n");
    for(i = 0; i < N; i++){
        for(j = 0; j < N; j++){
            scanf("%d", &adj[i][j]);
        }
    }

    printf("BFS Traversal: ");
    BFS(0);

    return 0;
}
