package hw6;

import hw3.MyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class DepthFirstPaths {

    private Map<Integer, Boolean> mrkd;
    private Map<Integer, Integer> edgTo;
    private int source;
    private Graph g;

    public DepthFirstPaths(Graph g, int source){
        this.source = source;
        this.g = g;
        init(this.g, this.source);
    }

    private void init(Graph g, int source){
        mrkd = new HashMap<>();
        edgTo = new HashMap<>();
        for (Integer o : g.getVCount()) {
            mrkd.put(o, false);
            edgTo.put(o, 0);
        }
        dfs(g, source);
    }

    private void dfs(Graph g, int v){
        mrkd.put(v, true);
        for (int w : g.adjMap.get(v)) {
            if (!mrkd.get(w)){
                mrkd.put(w, true);
                edgTo.put(w, v);
                dfs(g, w);
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

}
