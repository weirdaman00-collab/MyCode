#include <stdio.h>
#include <string.h>

void computeLPS(char pat[], int m, int lps[]) {
    int len = 0;
    int i = 1;

    lps[0] = 0;

    while (i < m) {
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
}

void KMPSearch(char txt[], char pat[]) {
    int n = strlen(txt);
    int m = strlen(pat);
    int lps[100];

    computeLPS(pat, m, lps);

    int i = 0; // index for txt
    int j = 0; // index for pat

    while (i < n) {
        if (pat[j] == txt[i]) {
            i++;
            j++;
        }

        if (j == m) {
            printf("Pattern found at index %d\n", i - j);
            j = lps[j - 1];
        } else if (i < n && pat[j] != txt[i]) {
            if (j != 0)
                j = lps[j - 1];
            else
                i++;
        }
    }
}

int main() {
    char txt[100], pat[100];

    printf("Enter text: ");
    scanf("%s", txt);

    printf("Enter pattern: ");
    scanf("%s", pat);

    KMPSearch(txt, pat);

    return 0;
}
