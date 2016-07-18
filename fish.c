#include<stdio.h>
#include<sys/shm.h>
#include<sys/types.h>
#include<sys/ipc.h>

#define SHMKEY 90
#define SHMSIZE 90

int main(){

	key_t key = SHMSIZE ;
	int *shared_memory, shmid, counter ;
	if((shmid = shmget(key, SHMSIZE, IPC_CREAT)) < 0 )
		perror("SHMGET") ;
	if(*(shared_memory = (int *)shmat(shmid, (void *)0, 0)) == -1)
		perror("SHMAT") ;
	while( *shared_memory != 0 )
		printf("%d\n", *shared_memory++) ;
	return 0 ;
}
