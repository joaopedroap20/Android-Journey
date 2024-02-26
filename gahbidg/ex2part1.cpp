
#include <iostream>
#include <cmath>
#include <vector>

    struct Point {
        double x, y;

    };

class Polygon : public Point
    {
        protected: //iso and equi tris dont need to know Polygon, only Triangle
        Polygon() { std::cout << "I'm gosh dang Polygonal!\n \n";}
        //Calculate distances
        double distance(const Point& p1, const Point& p2) const {
            return std::sqrt(pow(p1.x - p2.x, 2) + pow(p1.y - p2.y, 2));
        }
        virtual ~Polygon(){std::cout <<"Polygon is sleeping with the fishes (Destructed)\n";}
        private:
        std::vector<Point> vertexes;
    };

namespace god_help_me_with_three_vertices{


class Triangle : public Polygon
    {
    public:
            Triangle(const Point& a, const Point& b, const Point& c) :
            va(a),
            vb(b),
            vc(c)
        {
            //std::cout << "Triangle vertices constructor\n \n";
            //printVertices();
        }
    double calcArea() const 
    {
        double side1 = distance(va, vb);
        double side2 = distance(vb, vc);
        double side3 = distance(vc, va);
        
        double area = ((side1 +side2 + side3)/2);

        std::cout << "This triangle's area is : " << area << "!\n";
        return area;
    }

            Triangle(double base_len, const Point& v) :
            Triangle({0, 0}, v, {0, base_len})
        {
            std::cout << "custom Triangle base plus top vertex constructor\n";
        }

    //Point Printer
        void printVertices() const
        {
            std::cout << "    a = (" << va.x << ", " << va.y << ") \n" << std::endl
                      << "    b = (" << vb.x << ", " << vb.y << ") \n" << std::endl
                      << "    c = (" << vc.x << ", " << vc.y << ") \n \n" << std::endl;
        }

    //Triangle destructor indicator
    ~Triangle (){std::cout <<"Triangle is gone! (Destructed)\n \n"; }

    private:
        Point va;
        Point vb;
        Point vc;
    };

/* class IsoscelesTriangle : public Triangle
    {
        public:
        IsoscelesTriangle() {}
        
    };
class EquilateralTriangle : public Triangle
    {
        public:
        EquilateralTriangle() { std::cout << "I'm a Equilateral Triangle!\n";}
        double 
    }; */

    void runDemo(){
        std::cout << "Bear QA initiated... \n";

        Triangle testTri({1.0, 0.0},{2.0, 0.0},{1.0, 1.0});
        testTri.calcArea();
        //delete testTri;
        //testTri.printVertices();
    }
}

namespace god_help_me_with_four_vertices{

class Quadrilateral : public Polygon
    {

        public:
        Quadrilateral() { std::cout << "I'm mf'ing quadrilateral!\n";}
        //Starting from here we play with 4 vertices
    }; 
class Trapezoid : public Quadrilateral
    {
        public:
        Trapezoid() { std::cout << "I'm a mf'ing Trapezoid!\n";}
    }; 
class Parallelogram : public Trapezoid
    {
        public:
        Parallelogram() { std::cout << "I'm a mf'ing Parallelogram!\n";}
    };
class Rhombus : public Parallelogram
    {
        public:
        Rhombus() { std::cout << "I'm a mf'ing Big Rhombus!\n";} //big chungus vibes
    };
class Rectangle : public Parallelogram
    {
        public:
        Rectangle() { std::cout << "I'm a gosh darn Rectangle! AH-HYUK!\n";}
    };
class Square : public Rectangle
    {
        public:
        Square() { std::cout << "I'm a mf'ing Square!\n";} //won't be there
    }; 
}

int main(int argc, char** argv)
{
    god_help_me_with_three_vertices::runDemo();
    //god_help_me_with_four_vertices::runDemo();

    return 0;
}