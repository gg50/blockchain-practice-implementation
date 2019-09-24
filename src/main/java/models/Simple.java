package models;

import lombok.Value;

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

    public static class BlockChain {
        private static final Block GENESIS = new Block(null, 0);
        private List<Block> blocks = new ArrayList<>();

        public BlockChain() {
            blocks.add(GENESIS);
        }

        public void addData(Object data) {
            Block prev = blocks.get(blocks.size() - 1);
            Block next = new Block(data, prev.hashCode());
            blocks.add(next);
        }

        public void forEachBlock(Consumer<? super Block> consumer) {
            blocks.forEach(consumer);
        }
    }
}
