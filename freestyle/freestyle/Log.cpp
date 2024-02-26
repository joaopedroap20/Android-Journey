#include <iostream>
#include "Log.h"

void InitLog()
{
    Log("Initializing Log"); // This will call the Log function.
}

void InitLog(const char* message)
{
    std::cout << message << std::endl;
}

void Log(const char* message)
{
    std::cout << message << std::endl; // Definition for Log function.
}
