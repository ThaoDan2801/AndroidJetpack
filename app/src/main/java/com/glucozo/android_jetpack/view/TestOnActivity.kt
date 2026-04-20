package com.glucozo.android_jetpack.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.glucozo.android_jetpack.R
import java.util.LinkedList

data class Graph(val nodes: MutableMap<Int, MutableList<Int>>)

class TestOnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_on)
//        test()
        add()
        bfs(myGraph, 0)
        println("myGraph : $myGraph")

    }

    val numList  = mutableListOf(1, 2, 3)
    val myList = LinkedList<Int>()


    private fun test(){
        myList.add(1)
        myList.add(4)
        myList.add(6)
        myList.add(8)
        val reLast = myList.removeLast()
        val addFirst = myList.addFirst(9)
        println("list : $myList")
        println("reLast : $reLast")
        println("addFirst : $addFirst")
    }



    val myGraph = Graph(mutableMapOf())

    fun add(){
        myGraph.nodes[0] = mutableListOf(1, 2)
        myGraph.nodes[1] = mutableListOf(0, 3)
        myGraph.nodes[2] = mutableListOf(0, 4)
        myGraph.nodes[3] = mutableListOf(1)
        myGraph.nodes[4] = mutableListOf(2)
    }

// Thêm cạnh cho đồ thị


    // Duyệt đồ thị theo thuật toán BFS (Breadth-First Search)
    fun bfs(graph: Graph, start: Int): List<Int> {
        val queue = mutableListOf<Int>()
        val visited = mutableSetOf<Int>()

        queue.add(start)
        visited.add(start)

        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            println(current)

            for (neighbor in graph.nodes[current]!!) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor)
                    visited.add(neighbor)
                }
            }
        }

        return visited.toList()
    }


}