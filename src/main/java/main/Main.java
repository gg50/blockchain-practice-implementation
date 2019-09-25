package main;

import lombok.extern.log4j.Log4j2;
import lombok.val;
import models.Polymorphic;
import models.Simple;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
@Log4j2
public class Main {
    public static void main(String[] args) {
        log.trace("called with ({})", Arrays.toString(args));
        val blockChain = usePolymorphicBlockChain(1, 2, 3, 4, 5);
        Consumer<Polymorphic.Block> logBlock = block ->
                log.info(block + " " + block.hashCode());
        blockChain.forEachBlock(logBlock);
        log.info("Setting data of first to 100.");
        blockChain.getBlock(1).setData(100);
        blockChain.forEachBlock(logBlock);
    }

    private static void useSimpleBlockChain() {
        log.trace("called ()");
        Simple.BlockChain blockChain = new Simple.BlockChain();
        blockChain.addData("Hello ");
        blockChain.addData("World");
        blockChain.addData("!");
        blockChain.forEachBlock(System.out::println);
    }

    @SafeVarargs
    private static <T> Polymorphic.BlockChain<T> usePolymorphicBlockChain(T... data) {
        log.trace("called with({})", Arrays.toString(data));
        Polymorphic.BlockChain<T> blockChain = new Polymorphic.BlockChain<>();
        for (T d : data) {
            blockChain.addData(d);
        }
        return blockChain;
    }
}
