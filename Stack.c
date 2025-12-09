#include<stdio.h>
#define MAX 100
int stack[MAX];
int top = -1;
void push(int data){
    if(top == MAX -1){
        printf("Stack Overflow\n");
    }
    else{
        top++;
        stack[top] =data;
        printf("the %d is pushed to stack\n", data);
    }
}
void pop(){
    if(top == -1){
        printf("stack underflow\n");
    }
    else{
        printf("the %d is popped from stack\n", stack[top]);
        top--;
    }
}
void peek(){
    if(top == -1){
        printf("stack is empty\n");
    }
    else{
        printf(" the top element is %d\n", stack[top]);
    }
}
void display(){
    if(top == -1){
        printf("stack is empty\n");
    }
    else{
        printf("stack elements are:\n");
        for(int i = top; i>=0;i--){
            printf("%d\n", stack[i]);
        }
        printf("\n");
    }
}
int main(){
    push(10);
    push(20);
    push(30);
    display();
    peek();
    pop();
    display();
    return 0;
}
