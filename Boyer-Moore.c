#include <stdio.h>

int main() {
    int a[100], n, i;
    int candidate = 0, count = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for (i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    // Step 1: Find candidate
    for (i = 0; i < n; i++) {
        if (count == 0) {
            candidate = a[i];
            count = 1;
        } else if (a[i] == candidate) {
            count++;
        } else {
            count--;
        }
    }

    // Step 2: Verify candidate
    count = 0;
    for (i = 0; i < n; i++) {
        if (a[i] == candidate)
            count++;
    }

    if (count > n / 2) {
        printf("Majority element = %d\n", candidate);
    } else {
        printf("No majority element\n");
    }

    return 0;
}
