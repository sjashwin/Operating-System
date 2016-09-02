#include<stdio.h>
#include<sys/shm.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<string.h>

#define SHMKEY 90
#define SHMSIZE 512
#define SIZE 5

int main(){
	key_t key = SHMKEY ;
	char *shared_memory ;
	int shmid, row, col ;
	if((shmid = shmget(key, SHMSIZE, IPC_CREAT)) < 0 )
		perror("SHMGET") ;
	if((shared_memory = (char *)shmat(shmid, (void *)0, 0)) == -1)
		perror("SHMAT") ;
	for ( row = 0; row<SIZE; row++ ){
		for( col = 0 ; col < SIZE ; col++){
			if ( (col == 0) && (row = (SIZE-1))){
				shared_memory[SIZE*row+col] = 'F' ;
				continue ;
			}
			shared_memory[SIZE*row + col] = '-' ;
		}
	}
	return 0 ;
}
