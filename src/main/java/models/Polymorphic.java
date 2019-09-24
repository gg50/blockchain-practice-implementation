package models;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
public class Polymorphic {
    @Value
    public static class Block<T> {
        T data;
        int prevHash;
    }

    public static class BlockChain<T> {
        private List<Block<T>> blocks = new ArrayList<>();

        public BlockChain() {
            blocks.add(new Block<>(null, 0));
        }

        public void addData(T data) {
            Block<T> prev = blocks.get(blocks.size() - 1);
            Block<T> next = new Block<>(data, prev.hashCode());
            blocks.add(next);
        }

        public void forEachBlock(Consumer<? super Block> consumer) {
            blocks.forEach(consumer);
        }
    }
}
