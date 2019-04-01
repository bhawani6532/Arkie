#include "basicgraphs.h"

basicGraphs::basicGraphs():basicGraphs(false,false){

}

    /* isDirectedGraph: if true, the graph is directed, if false then tge graph is undirected
     * isWeightedGraph: if true, the edge of the graph is weighted one, if false then the each edge has a weight 1.0 as default.
     * Setting number of vertex in this graph to be 0.
    */
basicGraphs::basicGraphs(bool isDirectedGraph, bool isWeightedGraph){
    this->isDirected = isDirectedGraph;
    this->isWeighted = isWeightedGraph;
    numberOfVertex = 0;
}


    /* This method will create a new vertex and set the name of the vertex as v.
     * cost to reach each vertex will be infinite.
     * vertex is not visited if we traverse it.
     * previous : it is set to nullptr as we don't know the path how we reached this node with minimum path.
     * Inserting this vertex to the map with "name" of the vertex as the key.
     * Increase the total number of vertex in this graph.
    */
void basicGraphs::addVertex(string v){
    Vertex * vertex = new Vertex();
    vertex->name = v;
    vertex->cost = std::numeric_limits<double>::max();
    vertex->visited = false;
    vertex->previous = nullptr;
    vertices[v] = vertex;
    numberOfVertex++;
}


    /* This method will create a new edge connecting vertex v1 and v2 with weight of the edge as "edgeWeight"
     * If the graph is undirected, then we will add the same weight to the v2->v1
     *
    */
void basicGraphs::addEdge(string v1, string v2, double edgeWeight){
    Edges* edge = new Edges();
    edge->start = vertices[v1];
    edge->finish = vertices[v2];
    edge->weight = edgeWeight;
    vertices[v1]->edges.insert(edge);
    if(!isDirected){
        Edges* edge2 = new Edges();
        edge2->start = vertices[v2];
        edge2->finish = vertices[v1];
        edge2->weight = edgeWeight;
        vertices[v2]->edges.insert(edge2);
    }
}


    //This method will print the vertex of the graph first followed by all the edges and weight of each vertex separated by ";"
void basicGraphs::printGraph(){
    cout<<"{";
    for(auto v : vertices){
        cout<<v.second->name<<", ";
    }
    for(auto v: vertices){
        for(auto e: v.second->edges){
            cout<<e->start->name<<"-->"<<e->finish->name<<":"<<e->weight<<", ";
        }
    }
    cout<<"}"<<endl;
}


    //This method returns the number of vertex
int basicGraphs::size(){
    return numberOfVertex;
}

    //This method finds the shortest path for each vertex from the source vertex namely "name"
void basicGraphs::shortestPathDijkstra(string name){
    resetCost();
    for(auto v1: vertices){
        if(v1.first==name){
            v1.second->cost = 0;
            pQueue.push(v1.second);
            break;
        }
    }
    while(!pQueue.empty()){
        Vertex* v2 = pQueue.top();
        pQueue.pop();
        v2->visited = true;
        for(auto edge: v2->edges){
            Vertex* v3 = edge->finish;
            if(v3->visited==false){
                if(v3->cost>edge->start->cost+edge->weight){
                    v3->cost = edge->start->cost+edge->weight;
                    v3->previous = v2;
                    pQueue.push(v3);
                }
            }
        }
    }

    cout<<"{";
    for(auto v : vertices){
        if(v.second->cost!=std::numeric_limits<double>::max()){
            cout<<v.second->name<<":"<<v.second->cost<<", ";
        }
        else{
            cout<<v.second->name<<":"<<"This vertex is not connected to the source, ";
        }
    }
    cout<<"}"<<endl;

    for(auto v1 : vertices){
        cout<<"{";
        pathMap(v1.second,name);
        cout<<"}"<<endl;
    }
    cout<<endl;
}


void basicGraphs::BreadthFirstSearch(string name){
    resetCost();
    for(auto v1: vertices){
        if(v1.first==name){
            Queue.push(v1.second);
            v1.second->visited = true;
            break;
        }
    }

    while(!Queue.empty()){
        Vertex* v2 = Queue.front();
        cout<<v2->name<<"--->";
        Queue.pop();
        for(auto edge: v2->edges){
            Vertex* v3 = edge->finish;
            if(v3->visited==false){
                v3->visited = true;
                //v3->previous = v2;
                Queue.push(v3);
            }
        }
    }
    cout<<endl;
}


/*void basicGraphs::shortestPathASearch(string name){


    cout<<"{";
    for(auto v : vertices){
        cout<<v.second->name<<":"<<v.second->cost<<", ";
    }
    cout<<"}"<<endl;
}*/


void basicGraphs::DepthFirstSearch(Vertex* vertexName, string indent){
    for(auto v1: vertexName->edges){
        if(v1->finish->visited==false){
            v1->finish->visited=true;
            cout<<indent<<v1->finish->name<<endl;
            DepthFirstSearch(v1->finish, indent + "     ");
        }
    }
}

void basicGraphs::DepthFirstSearch(){
    string indent = "       ";
    resetCost();
    for(auto v1: vertices){
        if(v1.second->visited ==false){
            v1.second->visited = true;
            cout<<v1.second->name<<"        "<<endl;
            for(auto v2:v1.second->edges){
                if(v2->finish->visited==false){
                    v2->finish->visited = true;
                    cout<<indent<<v2->finish->name<<endl;
                    DepthFirstSearch(v2->finish,indent + "      ");
                    cout<<endl;
                }
            }
            cout<<endl;
         }
    }
}



void basicGraphs::topologicalSort(Vertex* vertexName, string indent){
    for(auto v1: vertexName->edges){
        if(v1->finish->visited==false){
            v1->finish->visited=true;
            topologicalSort(v1->finish, indent + "     ");
            cout<<indent<<v1->finish->name<<endl;
        }
    }
}


void basicGraphs::topologicalSort(){
    string indent = "       ";
    resetCost();
    for(auto v1: vertices){
        if(v1.second->visited ==false){
            v1.second->visited = true;
            for(auto v2:v1.second->edges){
                if(v2->finish->visited==false){
                    v2->finish->visited = true;
                    topologicalSort(v2->finish,indent + "      ");
                    cout<<indent<<v2->finish->name<<endl;
                }
            }
            cout<<v1.second->name<<"        "<<endl;
         }
    }
}

    //This method resets each vertex to its initial condition.
void basicGraphs::resetCost(){
    for(auto v1: vertices){
        v1.second->cost = std::numeric_limits<double>::max();
        v1.second->visited = false;
    }
}

    //This method will print each vertex path to the source vertex
void basicGraphs::pathMap(Vertex* v, string nameSourceVertex){
    cout<<v->name;
    v = v->previous;
    while(v!= nullptr){
        cout<<"--->";
        cout<<v->name;
        if(v->name==nameSourceVertex)
            return;
        v = v->previous;
    }
}

    //delete all the dynamic allocated memory
void basicGraphs::clear(){
    for(auto v:vertices){
        for(auto edge:v.second->edges){
            Edges* deleteEdge = edge;
            delete deleteEdge;
        }
        delete v.second;
    }
}

    //destructor of the class, calling clear() method to free the allocated memory
basicGraphs::~basicGraphs(){
    clear();
}









