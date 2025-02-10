#include <stdio.h>

int main(void)
{
	int n,i,j,x=0,flag=0;
	char ch[51];
	scanf("%d", &n);
	
	for(i=0;i<n;i++){
		scanf("%s", ch);
		for(j=0;ch[j];j++){
			if(x==0 && ch[j] == ')'){
				flag=1;
				break;
			}
			else if(ch[j] == '('){
				x++;
			}
			else if(ch[j] == ')'){
				x--;
			}
		}
		if(flag==1) printf("NO\n");
		else if(flag==0 && x==0) printf("YES\n");
		else printf("NO\n");
		x=0;
		flag=0;
	}
	
}