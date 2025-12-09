#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node *left;
    struct node *right;
};

// Create a new node
struct node* createNode(int value){
    struct node *newnode;
    newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data = value;
    newnode->left = NULL;
    newnode->right = NULL;
    return newnode;
}

// Preorder Traversal (Root, Left, Right)
void Preorder(struct node *root){
    if(root != NULL){
        printf("%d ", root->data);
        Preorder(root->left);
        Preorder(root->right);
    }
}

// Inorder Traversal (Left, Root, Right)
void Inorder(struct node *root){
    if(root != NULL){
        Inorder(root->left);
        printf("%d ", root->data);
        Inorder(root->right);
    }
}

// Postorder Traversal (Left, Right, Root)
void Postorder(struct node *root){
    if(root != NULL){
        Postorder(root->left);
        Postorder(root->right);
        printf("%d ", root->data);
    }
}

int main(){
    // Manual tree creation
    struct node *root = createNode(10);
    root->left = createNode(20);
    root->right = createNode(30);
    root->left->left = createNode(40);
    root->left->right = createNode(50);

    printf("Preorder Traversal: ");
    Preorder(root);

    printf("\nInorder Traversal: ");
    Inorder(root);

    printf("\nPostorder Traversal: ");
    Postorder(root);

    return 0;
}
