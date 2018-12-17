package hw6;

import hw3.MyLinkedList;
import hw3.MyLinkedListQue;

import java.util.HashMap;
import java.util.Map;

public class BreadthFirstPaths {

    private int source;
    private Map<Integer, Boolean> mrkd;
    private Map<Integer, Integer> edgTo;
    private Map<Integer, Integer> dstTo;
    private static final int INF = Integer.MAX_VALUE;
    private Graph g;

    public BreadthFirstPaths(Graph g, int source){
        this.source = source;
        this.g = g;
        init(this.g, this.source);
    }

    private void init(Graph g, int source){
        mrkd = new HashMap<>();
        edgTo = new HashMap<>();
        dstTo = new HashMap<>();
        for (Integer o : g.getVCount()) {
            mrkd.put(o, false);
            edgTo.put(o, 0);
            dstTo.put(o, INF);
        }
        bfs(g, source);
    }

    private void bfs(Graph g, int v){
        MyLinkedListQue<Integer> que = new MyLinkedListQue<>();
        que.enqueue(v);
        mrkd.put(v, true);
        dstTo.put(v, 0);
        while (!que.isEmpty()){
            int vertex = que.dequeue();
            for (int w : g.adjMap.get(vertex)) {
                if (!mrkd.get(w)){
                    mrkd.put(w, true);
                    edgTo.put(w, vertex);
                    dstTo.put(w, dstTo.get(vertex) + 1);
                    que.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int dist){
        init(this.g, this.source);
        if (!mrkd.containsKey(dist)) return false;
        return mrkd.get(dist);
    }

    public MyLinkedList<Integer> pathTo(int dist){
        if (!hasPathTo(dist)) return null;
        MyLinkedList<Integer> path = new MyLinkedList<>();
        while (dist != source){
            path.addFirst(dist);
            dist = edgTo.get(dist);
        }
        return path;
    }

    public int distTo(int v){
        init(this.g, this.source);
        return dstTo.get(v);
    }

}
