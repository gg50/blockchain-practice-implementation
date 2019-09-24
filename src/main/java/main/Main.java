package main;

import models.Polymorphic;
import models.Simple;

/**
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        useSimpleBlockChain();
        System.out.println();
        usePolymorphicBlockChain("Hello ", "World", "!");
        System.out.println();
        usePolymorphicBlockChain("Hello", "World", "!");
        System.out.println();
        usePolymorphicBlockChain(0, 1, 2);
        System.out.println();
        usePolymorphicBlockChain(0, 1, "hello");
    }

    private static void useSimpleBlockChain() {
        Simple.BlockChain blockChain = new Simple.BlockChain();
        blockChain.addData("Hello ");
        blockChain.addData("World");
        blockChain.addData("!");
        blockChain.forEachBlock(System.out::println);
    }

    @SafeVarargs
    private static <T> void usePolymorphicBlockChain(T... data) {
        Polymorphic.BlockChain<T> blockChain = new Polymorphic.BlockChain<>();
        for (T d : data) {
            blockChain.addData(d);
        }
        blockChain.forEachBlock(System.out::println);
    }
}
