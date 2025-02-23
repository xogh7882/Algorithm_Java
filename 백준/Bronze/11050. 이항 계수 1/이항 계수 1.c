#include <stdio.h>

int fac(int x)
{
	int i,sum = 1;
    for(i=1;i<=x;i++){
        sum*=i;
    }
    return sum;
}

int main(void)
{
	int n,r;
	int sum = 0;
	scanf("%d %d", &n, &r);
	
	sum = fac(n) / (fac(r)*(fac(n-r)));
	printf("%d", sum);
	return 0;
}