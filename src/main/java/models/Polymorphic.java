package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1.0
 */
public class Polymorphic {
    @Data
    @AllArgsConstructor
    public static class Block<T> {
        T data;
        int prevHash;
    }

    @Log4j2
    public static class BlockChain<T> {
        private List<Block<T>> blocks = new ArrayList<>();

        public BlockChain() {
            log.trace("constructing new ()");
            blocks.add(new Block<>(null, 0));
        }

        public void addData(T data) {
            log.trace("called with ({})", data);
            Block<T> prev = blocks.get(blocks.size() - 1);
            Block<T> next = new Block<>(data, prev.hashCode());
            blocks.add(next);
        }

        public void forEachBlock(Consumer<? super Block> consumer) {
            log.trace("called with ({})", consumer);
            blocks.forEach(consumer);
        }

        public Block<T> getBlock(int index) {
            log.trace("called with({})", index);
            if (index < 1) {
                log.warn("Attempted access of block before first.");
                throw new IndexOutOfBoundsException("Block indexes start at 1");
            }
            if (index >= blocks.size()) {
                log.warn("Attempted access of block after last.");
                throw new IndexOutOfBoundsException("Index beyond last block");
            }
            return blocks.get(index);
        }
    }
}
