#include<stdio.h>
#define MAX 100
queue[MAX];
int front = -1;
int rear = -1;
void enequeue(int data){
    if(rear = MAX -1){
        printf("invalid");
    }
    else{
        if(front == -1){
            front =0;
        }
        rear++;
        queue[rear] = data;
        printf("enqueued %d to queue\n", data);
    }
}
void dequeue(){
    if(front == -1|| front > rear){
        printf("invalid");
    }
    else{
        printf("dequeued %d from queue\n", queue[front]);
        front++;
        if(front>rear){
            front = rear = -1;
        }
    }
}
void display(){
    if(front == -1){
        printf("queue is empty\n");
    }
    else{
        printf("queue elements are:\n");
        for(int i = front;i<=rear;i++){
            printf("%d\n", queue[i]);
        }
    }
}
int main(){
    enequeue(10);
    enequeue(20);
    enequeue(30);
    display();
    dequeue();
    display();
    return 0;
}
