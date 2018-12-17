package hw6;

import hw1.MyArrayList;
import hw3.MyLinkedList;


import java.util.HashMap;
import java.util.Map;

public class Graph {

    private int edgeCount = 0;
    Map<Integer, MyLinkedList<Integer>> adjMap;
    private MyLinkedList<Integer> vCount = new MyLinkedList<>();

    public Graph(int vertexCount){
        if (vertexCount < 0) throw new IllegalArgumentException("Количество вершин графа не может быть меньше 0");
        adjMap = new HashMap<>();
        for (int i = 0; i < vertexCount; i++) addVertex(i);
    }

    public Graph(){
        adjMap = new HashMap<>();
    }

    public MyLinkedList<Integer> getVCount() {
        return vCount;
    }

    public void addVertex(int v){
        if (!containsVertex(v)) adjMap.put(v, new MyLinkedList<>());
        vCount.addLast(v);
    }

    public void removeVertex(int v){
        if (!adjMap.containsKey(v)) throw  new IllegalArgumentException("Вершины не существует");
        for (Map.Entry<Integer, MyLinkedList<Integer>> o : adjMap.entrySet()) if (o.getKey() != v) o.getValue().remove(v);
        adjMap.remove(v);
        vCount.remove(v);
    }

    public boolean containsVertex(int v){
        return adjMap.containsKey(v);
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(int v1, int v2){
        if (!containsVertex(v1) || !containsVertex(v2)) throw  new IllegalArgumentException("Некорректное значение вершины");
        adjMap.get(v1).addLast(v2);
        adjMap.get(v2).addLast(v1);
        edgeCount++;
    }

    public void removeEdge(int v1, int v2){
        if (!containsVertex(v1) || !containsVertex(v2)) throw  new IllegalArgumentException("Некорректное значение вершины");
        if (adjMap.get(v1).remove(v2) != null && adjMap.get(v2).remove(v1) != null) edgeCount--;
    }

    public MyLinkedList<Integer> adjList(int v){
        if (!adjMap.containsKey(v)) throw new IllegalArgumentException("Некорректное значение вершины");
        return adjMap.get(v);
    }
}
