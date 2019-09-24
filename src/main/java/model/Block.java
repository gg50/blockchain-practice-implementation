package model;

import lombok.Value;

/**
 * @version 1.0
 */
@Value
public class Block {
    Object data;
    int previousHash;
}
