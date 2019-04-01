#include "basicgraphs.h"
#include <iostream>
using namespace std;

void graphsTest();
int main()
{
    graphsTest();
    return 0;
}

void graphsTest(){
    basicGraphs graph(true,true);
    graph.addVertex("A");
    graph.addVertex("B");
    graph.addVertex("C");
    graph.addVertex("D");
    graph.addVertex("E");
    graph.addVertex("F");
    graph.addVertex("G");
    graph.addVertex("H");
    graph.addVertex("I");
    graph.addVertex("J");
    graph.addVertex("K");
    graph.addVertex("L");

    graph.addEdge("A","B",3);
    graph.addEdge("A","C",4);
    graph.addEdge("B","D",3);
    graph.addEdge("B","E",4);
    graph.addEdge("C","E",2);
    graph.addEdge("C","H",4);
    graph.addEdge("D","E",6);
    graph.addEdge("D","F",2);
    graph.addEdge("E","G",4);
    graph.addEdge("E","H",5);
    graph.addEdge("F","G",3);
    graph.addEdge("F","I",5);
    graph.addEdge("G","H",3);
    graph.addEdge("G","I",3);
    graph.addEdge("G","J",2);
    graph.addEdge("H","J",3);
    graph.addEdge("I","J",3);

    graph.addEdge("K","L", 3);


    graph.printGraph();

    graph.shortestPathDijkstra("B");
    graph.DepthFirstSearch();
    graph.BreadthFirstSearch("B");
    //graph.topologicalSort();


    //graph.addEdge("C","A",4.0);
    //graph.addEdge("C","F",5.0);
    //graph.addEdge("A","B",2.0);
    //graph.addEdge("A","D",1.0);
    //graph.addEdge("B","D",3.0);
    //graph.addEdge("B","E",10.0);
    //graph.addEdge("D","C",2.0);
    //graph.addEdge("D","E",2.0);
    //graph.addEdge("D","F",8.0);
    //graph.addEdge("D","G",4.0);
    //graph.addEdge("G","F",1.0);
    //graph.addEdge("E","G",6.0);

    //graph.addEdge("A","D",80.0);
    //graph.addEdge("A","G",20.0);
    //graph.addEdge("G","A",20.0);
    //graph.addEdge("A","B",20.0);
    //graph.addEdge("B","A",20.0);
    //graph.addEdge("E","B",80.0);
    //graph.addEdge("E","G",30.0);
    //graph.addEdge("B","F",10.0);
    //graph.addEdge("F","C",70.0);
    //graph.addEdge("C","H",20.0);
    //graph.addEdge("C","D",10.0);
    //graph.addEdge("D","C",10.0);
    //graph.addEdge("D","F",40.0);
    //graph.addEdge("F","D",40.0);
    //graph.addEdge("G","D",120.0);
    //graph.addEdge("G","F",1.0);


    //graph.BreadthFirstSearch("A");
}

