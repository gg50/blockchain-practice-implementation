package models;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * A simple Blockchain model.
 *
 * @version 1.1
 */
public class Simple {

    @Value
    public static class Block {
        Object data;
        int prevHash;
    }

    @Log4j2
    public static class BlockChain {
        private static final Block GENESIS = new Block(null, 0);
        private List<Block> blocks = new ArrayList<>();

        public BlockChain() {
            log.trace("constructing new ()");
            blocks.add(GENESIS);
        }

        public void addData(Object data) {
            log.trace("called with ({})", data);
            Block prev = blocks.get(blocks.size() - 1);
            Block next = new Block(data, prev.hashCode());
            blocks.add(next);
        }

        public void forEachBlock(Consumer<? super Block> consumer) {
            log.trace("called with ({})", consumer);
            blocks.forEach(consumer);
        }
    }
}
