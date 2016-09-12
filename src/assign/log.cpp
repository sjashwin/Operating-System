#include<iostream>
#include<unistd.h>
#include<cstdlib>
#include<fstream>
#include<errno.h>
int main(int argc, char *argv[]){
	int c, x ;
	std::string filename = "./logfile.txt", filename_temp ;
	std::ofstream logfile ;//to write to a file. class name ofstream
	logfile.open(filename.c_str()) ;//openeing the file.
	//refer to http://man7.org/linux/man-pages/man3/getopt.3.html
	while ((c =getopt(argc, argv, "-hnl"))!= -1){//getopt parses the command line flags and args.
		switch(c){
			case 'h'://help
				std::cout << "-h - help\n-n x to assign a value\n-l - to assign file name." << std::endl ;
				break ;
			case 'n'://setting the value of x in the file
				x = atoi(argv[optind]) ;
				std::cout << x << std::endl ;
				logfile << "x = "<< x << std::endl ;
				break ;
			case 'l'://to rename the file.
				if (argv[optind] == NULL){
					//incase of null argument with the -l flag.
					errno = EINVAL ;
					perror(argv[0]) ;
				}
				else{
				filename_temp = argv[optind] ;
				std::cout<< filename_temp << std::endl ;
				std::rename( filename.c_str(), filename_temp.c_str() ) ;
				filename = filename_temp ;
				}
				break ;
			case '?':
				errno = EINVAL ;
				perror(argv[0]) ;//error
				break ;
		}
	}
	return 0 ;
}
