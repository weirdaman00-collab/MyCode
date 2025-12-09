#include <stdio.h>
#define N 5

int stack[N], top = -1;
int adj[N][N];
int visited[N] = {0};

void push(int v){
    stack[++top] = v;
}

int pop(){
    return stack[top--];
}

int isEmpty(){
    return (top == -1);
}

void DFS(int start){
    int i, v;

    push(start);

    while(!isEmpty()){
        v = pop();

        if(visited[v] == 0){
            printf("%d ", v);
            visited[v] = 1;
        }

        for(i = N-1; i >= 0; i--){ 
            if(adj[v][i] == 1 && visited[i] == 0){
                push(i);
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

    printf("DFS Traversal using Stack: ");
    DFS(0);   // Start from node 0

    return 0;
}
