package model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
public class BlockChain {
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