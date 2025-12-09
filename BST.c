#include <stdio.h>

#define SIZE 100

int bst[SIZE];

// Initialize tree with -1 (empty)
void init() {
    for (int i = 0; i < SIZE; i++)
        bst[i] = -1;
}

// Insert into BST array
void insert(int value) {
    int i = 1;  // starting at root

    while (i < SIZE) {
        if (bst[i] == -1) {   // empty spot found
            bst[i] = value;
            return;
        }

        if (value < bst[i])
            i = 2 * i;       // go to left child
        else
            i = 2 * i + 1;   // go to right child
    }

    printf("Tree overflow, cannot insert!\n");
}

// Display array contents
void display() {
    printf("BST Array:\n");
    for (int i = 1; i < 20; i++) {
        if (bst[i] != -1)
            printf("Index %d → %d\n", i, bst[i]);
    }
}

int main() {
    init();

    insert(50);
    insert(30);
    insert(70);
    insert(20);
    insert(40);
    insert(60);
    insert(80);

    display();

    return 0;
}
