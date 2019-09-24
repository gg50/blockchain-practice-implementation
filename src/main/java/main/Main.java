package main;

import model.BlockChain;

/**
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        BlockChain blockChain = new BlockChain();
        blockChain.addData("Hello ");
        blockChain.addData("World");
        blockChain.addData("!");
        blockChain.forEachBlock(System.out::println);
    }
}
