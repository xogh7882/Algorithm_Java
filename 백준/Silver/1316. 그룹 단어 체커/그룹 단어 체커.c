#include <stdio.h>

int main(void)
{
	int n,i,j,flag1=0;
	char ch[101];
	int arr[26]={0};
	int sum = 0;
	char t;
	
	scanf("%d", &n);
	getchar();
	for(i=0;i<n;i++){
		scanf("%s", ch);
		for(j=0;ch[j];j++){
			if(j==0){
				t = ch[j];
				arr[ch[j]-'a'] = 1;
			}
			else{
				if(ch[j] != t){
					if(arr[ch[j]-'a'] != 1){
						t = ch[j];
						arr[ch[j]-'a'] = 1;
					}
					else{
						flag1 = 1;
					}
				}
			}
		}
		if(flag1 == 0) sum++;
		for(j=0;j<26;j++){
			arr[j] = 0;
		}
		flag1 = 0;
	}
	printf("%d", sum);
	
	return 0;
}