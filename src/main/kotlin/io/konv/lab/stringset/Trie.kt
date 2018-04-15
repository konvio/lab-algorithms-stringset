package io.konv.lab.stringset

import org.springframework.stereotype.Component

@Component
class Trie {

    private val root = Node()

    fun add(word: String) {
        var current: Node = root
        word.forEach {
            current = current.children.getOrPut(it, { Node() })
        }
        current.isWord = true
    }

    fun remove(word: String) {
        var current: Node = root
        word.forEach {
            current = current.children[it] ?: return
        }
        current.isWord = false
    }

    fun contains(word: String): Boolean {
        var current: Node = root
        word.forEach {
            current = current.children[it] ?: return false
        }
        return current.isWord
    }

    private inner class Node {
        var isWord: Boolean = false
        val children: MutableMap<Char, Node> = HashMap()
    }
}