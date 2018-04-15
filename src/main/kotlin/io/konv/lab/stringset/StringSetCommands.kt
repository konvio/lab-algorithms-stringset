package io.konv.lab.stringset

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class StringSetCommands {

    @Autowired
    lateinit var trie: Trie

    @ShellMethod(value = "Add word to the set", key = ["+", "insert"])
    fun add(word: String) = trie.add(word)

    @ShellMethod(value = "Check whether word is present in the set", key = ["?", "check"])
    fun contains(word: String): Boolean = trie.contains(word)

    @ShellMethod(value = "Remove word from the set", key = ["-", "delete"])
    fun remove(word: String) = trie.remove(word)
}