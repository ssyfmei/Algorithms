package com.yifeng.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class TopologicalSort {
	boolean[] marked;
	Deque<Integer> order;
	public TopologicalSort(DGraph graph) {
		marked = new boolean[graph.V()];
		order  = new ArrayDeque<>();
		for(int v = 0; v < graph.V(); v++) {
			if(!marked[v])
				dfs(v, graph);
		}
	}
	private void dfs(int v, DGraph graph) {
		marked[v] = true;
		for(int w: graph.adj(v)) {
			if(!marked[w]) {
				dfs(w, graph);
			}
		}
		order.addFirst(v);
	}
}