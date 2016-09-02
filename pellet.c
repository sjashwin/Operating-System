#include<stdio.h>
#include<sys/shm.h>
#include<sys/types.h>
#include<sys/ipc.h>

#define SHMKEY 90
#define SHMSIZE 512
#define SIZE 5

int main(){

	key_t key = SHMKEY ;
	char *shared_memory, entity ;
	int shmid, row, col ;
	if((shmid = shmget(key, SHMSIZE, 0666)) < 0 )
		perror("SHMGET") ;
	if(*(shared_memory = (char *)shmat(shmid, (void *)0, 0)) == -1)
		perror("SHMAT") ;
	shared_memory[SIZE*0+3] = 'P' ;
	for ( row = 0; row<SIZE ; row++ ){
		for(col = 0; col<SIZE; col++){
			entity = shared_memory[SIZE*row+col] ;
			printf("%c\t", entity) ;
		}
		printf("\n") ;
	}
	return 0 ;
}
