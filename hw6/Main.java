package hw6;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(13);
        //0 6-1-2-5
        //6 0-4
        //1 0
        //2 0
        //5 3-4-0
        //3 5-4
        //4 5-6-3
        g.addEdge(0,6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(5,0);
        g.addEdge(4,6);
        g.addEdge(4,3);

        g.addEdge(7,8);

        g.addEdge(9,10);
        g.addEdge(9,12);
        g.addEdge(9,11);
        g.addEdge(11,12);

        DepthFirstPaths dfs = new DepthFirstPaths(g, 0);
        System.out.println(dfs.hasPathTo(5));
        System.out.println(dfs.hasPathTo(12));
        System.out.println(dfs.pathTo(5));
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, 0);
        System.out.println(bfs.hasPathTo(5));
        System.out.println(bfs.hasPathTo(12));
        System.out.println(bfs.pathTo(5));
        System.out.println(bfs.distTo(5));

        Graph test = new Graph();
        test.addVertex(0);
        test.addVertex(2);
        test.addVertex(3);
        test.addVertex(4);
        test.addVertex(8);
        test.addVertex(9);
        test.addEdge(0,2);
        test.addEdge(0,3);
        test.addEdge(2,4);
        test.addEdge(4,8);
        test.addEdge(3,9);
        //DepthFirstPaths dfp = new DepthFirstPaths(test, 0);
        BreadthFirstPaths dfp = new BreadthFirstPaths(test, 0);
        System.out.println(dfp.hasPathTo(9));
        //test.removeEdge(9, 3);
        test.removeVertex(9);
        System.out.println(dfp.hasPathTo(9));
        System.out.println(dfp.pathTo(8));
        System.out.println(dfp.distTo(8));
        test.addVertex(-15);
        test.addEdge(-15, 3);
        System.out.println(dfp.hasPathTo(-15));
        System.out.println(dfp.pathTo(-15));
        System.out.println(dfp.distTo(-15));
    }
}
