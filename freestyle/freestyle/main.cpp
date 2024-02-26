#include <iostream>
#include <string>
#include "Log.h"

namespace operatorOverloading
{
struct Vector2
{
    float x, y;

    Vector2(float x, float y) 
        : x(x), y(y){}

    Vector2 Add( const Vector2& other ) const
    {
        return Vector2( x + other.x, y + other.y );
    }
    Vector2 operator+( const Vector2& other ) const
    {
        return Add(other);
    }

    Vector2 Multiply( const Vector2& other ) const
    {
        return Vector2( x * other.x, y * other.y );
    }
    Vector2 operator*( const Vector2& other ) const
    {
            return Multiply(other);
    }

    bool operator==(const Vector2& other) const
    {
        return x == other.x && y == other.y;
    };
    bool operator!=(const Vector2& other) const
    {
        //return !operator==other; alternative tho its ugly
        return !(*this == other);
    };
};

    std::ostream& operator<<(std::ostream& ostream, const Vector2& other)
    {
        ostream << other.x << " , " << other.y;
        return ostream;
    };

    void runDemo()
    {
        Vector2 position(4.0f, 4.0f);
        Vector2 speed(0.5f, 1.5f);
        Vector2 powerup(1.1f, 1.1f);

        Vector2 result1 = position.Add(speed.Multiply(powerup));
        Vector2 result2 = position + speed * powerup;

        if(result1 == result2)
        {
            std::cout << std::boolalpha << (result1 == result2)  <<" if triggered" << std::endl;
        }else
        {
            std::cout << "bear1" << std::endl;
        }

        std::cout << result2 << std::endl;

        std::cout << "bear2" << std::endl;
        //std::cin.get();
    }
};

namespace headerFiles //log.cpp and log.h
{
    void runDemo()
    {
        InitLog();
        Log("bitch boi carti");
    }
};

namespace debuggingCPP //
{
    void runDemo()
    {
        InitLog();
        Log("bitch boi carti");
    }
};
int main()
{
    //operatorOverloading::runDemo();
    //headerFiles::runDemo();
    debuggingCPP::runDemo();
    std::cout << "pee pee poo poo haha - Bear 2k24." << std::endl; 
}