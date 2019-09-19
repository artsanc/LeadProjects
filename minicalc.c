/*
Arturo Sanchez
Panther ID: 6100325
I affirm that I wrote this program myself without any help form any
other people or sources from the internet.”
Program Description: A program in C for a calculator that performs additon, multiplication and a power of 2 functions
*/


#include <stdio.h>
#include <stdlib.h>


int debug = 0;

int
main(int argc, char **argv)
{
	extern char *optarg;//optional parameter to command line
	extern int optind;//index value of next argument handled by getopt
	int c, err = 0; 
    int aflag=0, mflag=0, xflag = 0; //variables flag
    int aNum,mNum;
    float value; //optional 
    
    static char usage[] = "Usage: minicalc [-a num] [-m num] [-x] value\n";//everything in brackets is required

    while ((c = getopt(argc, argv, "a:m:x")) != -1) //switch case
		switch (c) {
		case 'a':
			aflag = 1;//if a is used
            aNum = atoi(optarg); //ascii to integer
			break;
		case 'm':
			mflag = 1;//if m is used
            mNum = atoi(optarg); //ascii to integer
			break;
		case 'x':
            xflag = 1;//if x is used
			break;
		default:
			err = 1;//if error
			break;
		}
    
    if (argc < (optind +1)) {//error code if theres a missing argument
        fprintf(stderr, "%s: Missing argument\n", argv[0]);//prints "missing argument"
        fprintf(stderr, usage, argv[0]);//prints usage
        exit(1);
    }
    else if (err) {//print error message 
        fprintf(stderr, usage, argv[0]);//prints usage
        exit(1);
    }


    
    value = atof(argv[argc -1]);//initializes value 
    
    if((value < 1) || (value > 50))
    {
        fprintf(stderr, "%.2f: Error: Please use a Number between 1 and 50n\n", value); // validating variable value
        fprintf(stderr, usage, argv[0]);//prints usage
        exit(2);
    }

    if(xflag == 1) // if -x is called (Highest priority)
    {
    
        value = value * value;
    }
    
    if(mflag == 1) //if -m is called (second highest priority)
    {

        if((mNum < 1) || (mNum > 10))//validates mNum conditions
        {
            printf("Error: Please use a number between 1 and 10\n"); 
            exit(2);
        }
        else
        {

            value = value * mNum;
        }
    }
    
    if(aflag == 1) // if -a is called (lowest priority)
    {
        if((aNum < 1) || (aNum > 500))//validates aNum conditions
        {
            printf("Error: Please use a number between 1 and 500\n"); 
            exit(2);
        }
        else
        {
        
            value = value +aNum;
        }
    }
    printf("Answer: %.2f\n", value);//prints out answer in 2 decimal format
    exit(0);
}
