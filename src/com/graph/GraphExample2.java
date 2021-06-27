package com.graph;

import java.util.*;

public class GraphExample2 {
    Map<Vertex , List<Vertex>> grap = new HashMap<>();

    public void addAge(Vertex v , Vertex adj){
        grap.getOrDefault(v , new ArrayList<Vertex>());
        if(grap.containsKey(v)){
            grap.getOrDefault(v , new ArrayList<Vertex>()).add(adj);
        }else{
            List<Vertex> adjArr = new ArrayList<Vertex>();
            adjArr.add(adj);
            grap.put(v , adjArr);
        }
    }

    public void print(){
        for(Vertex v : grap.keySet()){
            System.out.println("\nfor vertex " + v.value);
            System.out.print("head");
            for (Vertex adj : grap.get(v)){
                System.out.print("->" + adj.value);
            }
        }
    }

    Set<Integer> depthFirstTraversal(Vertex root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Vertex> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Vertex v = st.pop();
            for(Vertex adj : grap.get(v)){
                if(!visited.contains(adj.value)){
                    visited.add(adj.value);
                    st.push(adj);
                }
            }
        }

        return visited;
    }


    Set<Integer> breadthFirstTraversal(Vertex root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Queue<Vertex> st = new LinkedList<>();
        st.add(root);
        visited.add(root.value);
        while(!st.isEmpty()){
            Vertex v = st.poll();
            for(Vertex adj : grap.get(v)){
                if(!visited.contains(adj.value)){
                    visited.add(adj.value);
                    st.add(adj);
                }
            }
        }

        return visited;
    }


    public static void main(String[] args) {
        GraphExample2 gp = new GraphExample2();
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        gp.addAge(v0 , v1);
        gp.addAge(v0 , v4);

        gp.addAge(v1 , v0);
        gp.addAge(v1 , v4);
        gp.addAge(v1 , v2);
        gp.addAge(v1 , v3);

        gp.addAge(v2 , v1);
        gp.addAge(v2 , v3);

        gp.addAge(v3 , v1);
        gp.addAge(v3 , v4);
        gp.addAge(v3 , v2);

        gp.addAge(v4 , v3);
        gp.addAge(v4 , v0);
        gp.addAge(v4 , v1);

       // gp.print();

        Set<Integer> visited = gp.depthFirstTraversal(v0);
        System.out.print("root");
        for(int v : visited){
            System.out.print("->" + v);
        }

        System.out.println("\n-----------");
        Set<Integer> visited1 = gp.breadthFirstTraversal(v0);
        System.out.print("root");
        for(int v : visited1){
            System.out.print("->" + v);
        }
    }
}
