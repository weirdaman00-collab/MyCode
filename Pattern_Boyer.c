#include <stdio.h>
#include <string.h>

#define NO_OF_CHARS 256

void buildBadCharTable(char pat[], int m, int badchar[]) {
    int i;
    for (i = 0; i < NO_OF_CHARS; i++)
        badchar[i] = -1;

    for (i = 0; i < m; i++)
        badchar[(unsigned char)pat[i]] = i;
}

void boyerMooreSearch(char txt[], char pat[]) {
    int n = strlen(txt);
    int m = strlen(pat);
    int badchar[NO_OF_CHARS];

    buildBadCharTable(pat, m, badchar);

    int s = 0; // shift of the pattern
    while (s <= n - m) {
        int j = m - 1;

        while (j >= 0 && pat[j] == txt[s + j])
            j--;

        if (j < 0) {
            printf("Pattern found at index %d\n", s);
            if (s + m < n)
                s += m - badchar[(unsigned char)txt[s + m]];
            else
                s += 1;
        } else {
            int shift = j - badchar[(unsigned char)txt[s + j]];
            s += (shift > 1) ? shift : 1;
        }
    }
}

int main() {
    char txt[100], pat[100];

    printf("Enter text: ");
    scanf("%s", txt);

    printf("Enter pattern: ");
    scanf("%s", pat);

    boyerMooreSearch(txt, pat);

    return 0;
}
