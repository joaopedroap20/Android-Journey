#include <iostream>
#include <vector>
#include <cmath>

    struct Point {
        double x, y;
    };

    class Polygon : public Point 
    {
        protected:
        Polygon(){}

        //Calculate distances
        double distance(const Point& v1, const Point& v2) const {
            return std::sqrt(pow(v1.x - v2.x, 2) + pow(v1.y - v2.y, 2));
        }
        //Calculate area
        double area() const {
            return 0;
        }  

        void runDemo(){}

        private:
        Point va;
        Point vb;
        Point vc;
        std::vector<Point> vertexes;
    };

namespace god_help_me_with_three_vertices{

class Triangle : public Polygon 
{
    Triangle(const Point& v1, const Point& v2, const Point& v3) : 
        va(v1),
        vb(v2),
        vc(v3)
        {}
    //Calculate area for base Triangle

    private:
    //calc sides here
    Point va;
    Point vb;
    Point vc;
    double side1 = distance(va, vb);
    double side2 = distance(vb, vc);
    double side3 = distance(vc, va);
};
    void runDemo(){
        std::cout << "Bear QA initiated... \n";

/*         Triangle testTri({1.0, 0.0},{2.0, 0.0},{1.0, 1.0});
        testTri.calcArea();
        delete testTri; 
        testTri.printVertices();*/
    }
}
int main(int argc, char** argv)
{
    //god_help_me_with_three_vertices::runDemo();
    //god_help_me_with_four_vertices::runDemo();

    return 0;
}