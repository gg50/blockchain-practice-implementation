package main;

import models.Simple;

/**
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Simple.BlockChain blockChain = new Simple.BlockChain();
        blockChain.addData("Hello ");
        blockChain.addData("World");
        blockChain.addData("!");
        blockChain.forEachBlock(System.out::println);
    }
}
