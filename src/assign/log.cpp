#include<iostream>
#include<unistd.h>
#include<cstdlib>
#include<fstream>

int main(int argc, char *argv[]){
	int c, x ;
	std::string filename = "./logfile.txt", filename_temp ;
	std::ofstream logfile ;
	logfile.open(filename.c_str()) ;
	//refer to http://man7.org/linux/man-pages/man3/getopt.3.html
	while ((c =getopt(argc, argv, "-hnl"))!= -1){
		switch(c){
			case 'h':
				std::cout << "-h - help\n-n x to assign a value\n-l - to assign file name." << std::endl ;
				break ;
			case 'n':
				x = atoi(argv[optind]) ;
				std::cout << x << std::endl ;
				logfile << "x = "<< x << std::endl ;
				break ;
			case 'l':
				filename_temp = argv[optind] ;
				std::cout<< filename_temp << std::endl ;
				std::rename( filename.c_str(), filename_temp.c_str() ) ;
				filename = filename_temp ;
				break ;
			case '?':
				std::cout << "not available"<<std::endl ;
				break ;
			case ':':
				std::cout << "argument missing" << std::endl ;
				break ;
		}
	}
	return 0 ;
}
