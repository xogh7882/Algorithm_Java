#include <stdio.h>
#include <string.h>

int main(void)
{
	
	int i,flag=0;
	char ch[101];
	
	scanf("%s", ch);
	
	for(i=0;ch[i];i++){
		if(ch[i] != ch[strlen(ch)-1-i]){
			flag = 1;
		}	
	}
	
	if(flag==0) printf("1");
	else printf("0");
	
	
	return 0;
}