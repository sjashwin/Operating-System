#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char *argv[]){
	char *environment_variable , *env_details[2];
	int option = 0 ;
	option = getopt(argc, argv, "-i") ;
	switch (((option != -1) ?option : 32)){
		case ' ':{
			system("env") ;
		}
 		case 'i':{
			char* token ;
			int i =0 ;
			//char *env_name[20], *env_value[100] ;
			//printf("\nEnter environment name : ") ;
			//scanf("%s", env_name) ;
			//printf("\nEnter environment value : ");
			//scanf("%s", env_value) ;
			while( (token = strsep(&argv[2], "=")) != NULL ){
				env_details[i] = token ;
				i++ ;
				}
			int flag = setenv( env_details[0], env_details[1], 1) ;
			if (flag == 0)
				printf("Environment has been set\n") ;
			else
				printf("Error in setting flag\n") ;
			break ;
			}
		default:
			printf("Unknown command\n") ;
		}
	environment_variable = getenv(env_details[0]) ;
	if (environment_variable == NULL){
		perror("Error : Environment variable not available ");
		return -1 ;
	}
	printf("%s\n", environment_variable) ;
	return  0;
}
