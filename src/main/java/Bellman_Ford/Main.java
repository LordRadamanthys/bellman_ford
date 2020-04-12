package Bellman_Ford;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));
        vertexList.add(new Vertex("D"));
        vertexList.add(new Vertex("E"));

        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));// A -> B
        edgeList.add(new Edge(5, vertexList.get(1), vertexList.get(2)));// B -> C
        edgeList.add(new Edge(-4, vertexList.get(2), vertexList.get(3)));// C -> D
        edgeList.add(new Edge(-1, vertexList.get(3), vertexList.get(1)));// D -> B
        edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(4)));// A -> D
        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(4)));// A -> D

        BellmanFord algorithm = new BellmanFord(edgeList, vertexList);
        algorithm.shotestPath(vertexList.get(0), vertexList.get(4));
    }
}