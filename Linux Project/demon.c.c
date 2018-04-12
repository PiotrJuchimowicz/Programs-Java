#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <syslog.h>
#include <sys/stat.h>

int recursion = 0; //1 if enabled,0 if off
int sleepTime = 300;
int fileLimit = 0;
int signal = 0;

//Content of argv tab
/**
 * argv[0] program name
 * argv[1] source path
 * argv[2] goal path
 * argv[3] -T 
 * argv[4] value of -T
 * argv[5] -R   for recursion without value
 * argv[6] -M 
 * argv[7] value for -M
 * example:
 * demon pathA pathB  -T 300 -R -M 20000
 * */
//Returns 0 if arguments are correct otherwise returns 1
//number-number of arguments in main function
//argv - table with Strings- arguments from main function

// example of use readArguments(argc,argv,source,goal)
int readArguments(int number, char **argv, char *source, char *goal)
{
    //if number of arguments is less than minimum or greater than maximum
    if (number < 3 || number > 9)
    {
        printf("Incorrect number of arguments\n");
        return 1;
    }

    else
    {
        //for obligatory arguments(paths will be checked later in main)
        //paths copy
        strcpy(source, argv[1]);
        strcpy(goal, argv[2]);

        int i, variable;
        //Let's assume for example when we have -T 200 that -T is argument and 200 is value
        //0 Initial values for guards
        //2 guards that argument can be read only once
        int recursionGuard = 0, timeGuard = 0, limitGuard = 0;

        //checks each optional argument separately
        for (i = 3; i < number; ++i)
        {
            //recognises arguments and converts value from string into int
            if (strcmp(argv[i], "-T") == 0 && timeGuard == 0)
            {
                //if it is in range of argv array we can read value of -T
                if(argv[i + 1]>0)
                {
                    i = i + 1;
                    variable=atoi(argv[i]);
                    if (variable > 0) //if atoi can convert string into int
                    {
                        sleepTime = variable;
                        timeGuard = 2;
                        
                        
                    }
                    //if convertion failed
                    else
                    {
                        printf("Incorrect argument types\n");
                        return 1;
                    }
                }
                //if it is not  in range of argv  array,like only -T
               else
                {
                    printf("Incorrect number of arguments\n");
                    return 1;
                }
            }
            else if (strcmp(argv[i], "-R") == 0 && recursionGuard == 0)
            {
                recursion = 1;
                recursionGuard = 2;
            }
            else if (strcmp(argv[i], "-M") == 0 && limitGuard == 0)
            {
               
                //if it is in range of argv array we can read value of -M
               if(argv[i + 1]>0)
                {
                    i = i + 1;
                    variable = atoi(argv[i]);
                    if ( variable > 0) //if atoi can convert string into int
                    {
                        fileLimit = variable;
                        limitGuard = 2;
                    }
                    else
                    {
                        printf("Incorrect argument types\n");
                        return 1;
                    }
                }
                 //if it is not  in range of argv  array,like only -M
                else
                {
                    printf("Incorrect number of arguments\n");
                    return 1;
                }
            }
            else
            {
                printf("Problem with reading arguments.Enter arguments correctly.\n [daemon name] [path to source] [path to goal] [-R for recursive folder sync]\n [-T with value(integer) for change deamon sleep] [-M with value(integer) for change maximum file size to copy] ");
                return 1;
            }
        }
    }

    //RESULT:

    printf("source :%s ", source);
    printf("goal :%s ", goal);
    printf("recursion :%d ", recursion);
    printf("sleepTime :%d ", sleepTime);
    printf("fileLimit :%d ", fileLimit);

    return 0;
}
int checkFileType(struct stat file)
{
    if (S_ISDIR(file.st_mode))
        return 0; //folder
    else if (S_ISREG(file.st_mode))
        return 1; //regular file
    else
        return -1; //something different
}

int main(int argc, char **argv)
{
    //char tables for paths(which must be checked later)
    char source[200], goal[200];
    struct stat Source, Goal;
    //checking and reading arguments
    if (readArguments(argc, argv, source, goal) == 1)
        exit(-1);

    //if arguments are correct :
    //we have to check follwing conditions :

    //checking  if argv[1] and argv[2] are existing paths
    if (lstat(source, &Source) != 0 || lstat(goal, &Goal) != 0) //bad result
    {
        printf("One of the paths or both dont exist\n");
        exit(-1);
    }

    //checking if argv[1] and argv[2] are paths to  existing folders
    if (checkFileType(Source) != 0 || checkFileType(Goal) != 0)
    {
        printf("One of the paths or both arent paths to folders\n");
        exit(-1);
    }

    //forking the parent process
    pid_t pid;
    // Fork off the parent process  and create new
    pid = fork();
    //if failure
    if (pid > 0)
    {
        exit(-1);
    }
    // if it is native process
    else if (pid < 0)
    {
        return 0;
    }
    //if pid==0 then it is childs process
    else
    {
        //now we have to umask in order to write to any files(for exmaple logs)
        //By setting the umask to 0, we will have full access to the files generated by the daemon
        umask(0);
        openlog("logFile", LOG_PID, LOG_DAEMON);
        syslog(LOG_INFO, "Deamon has just started\n");
        //about sitsid : https://linux.die.net/man/2/setsid
        pid_t sid = setsid();
        if (sid < 0)
        {
            syslog(LOG_ERR, "Error with session opening\n");
            exit(-1);
        }
    }

    //at the end of program we need to close log using
    closelog();

    return 0;
}

/**
 * 
 * if(lstat(sciezka_zrodlowa, &Zrodlo)!=0)
//istnienie sciezki
{
printf("Sciezka zrodlowa %s nie istnieje\n",sciezka_zrodlowa);
exit(-1);
}
if(lstat(sciezka_docelowa, &Cel)!=0)
{
printf("Sciezka docelowa %s nie istnieje\n",sciezka_docelowa);
exit(-1);
}
 * int rodzajPliku(struct stat plik)
{
if(S_ISDIR(plik.st_mode)) return 0; //katalog
else
if(S_ISREG(plik.st_mode)) return 1; //plik regularny
else return -1;
//ani plik, ani katalog
}
 * 
 * 
 *
 *  */
