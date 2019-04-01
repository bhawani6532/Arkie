#ifndef BASICGRAPHS_H
#define BASICGRAPHS_H

#include <iostream>
using namespace std;
#include <set>
#include <map>
#include <queue>
#include <limits>

struct Edges;

struct Vertex{
    string name;
    set<Edges*> edges;
    bool visited;
    double cost;
    Vertex* previous;
};

struct Edges {
    Vertex * start;
    Vertex * finish;
    double weight;
};

struct costSmaller{
    bool operator()(Vertex* & v1, Vertex* & v2){
        return (v1->cost>v2->cost);
    }

};

class basicGraphs
{
public:
    basicGraphs();
    basicGraphs(bool idDirectedGraph, bool isWeightedGraph);

    ~basicGraphs();

    void addVertex(string name);
    void addEdge(string name1, string name2, double weightEdge = 1.0);
    void printGraph();
    int size();

    void DepthFirstSearch();
    void BreadthFirstSearch(string name);
    void shortestPathDijkstra(string name);
    void topologicalSort();
    //void shortestPathASearch(string name);
    void clear();

private:
    std::map<string,Vertex*> vertices;
    std::priority_queue<Vertex*,std::vector<Vertex*>,costSmaller> pQueue;
    std::queue<Vertex*> Queue;
    int numberOfVertex;
    bool isWeighted;
    bool isDirected;

    void resetCost();
    void pathMap(Vertex* v, string name);
    void DepthFirstSearch(Vertex* vertexName, string indent="");
    void topologicalSort(Vertex* vertexName, string indent="");

};

#endif // BASICGRAPHS_H
