package com.yangxingang.bean;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    static List<Block> mBlockList;

    public BlockChain() {
        mBlockList = new ArrayList<Block>();

    }

    public List<Block> getBlockList() {
        return mBlockList;
    }

    public void setBlockList(List<Block> blockList) {
        mBlockList = blockList;
    }

    public Block mBlock;

    public Block getBlock() {
        return mBlock;
    }

    public void setBlock(Block block) {
        mBlock = block;
    }

    /**
     * 添加区块
     *
     * @param data
     */
    public void addBlock(String data) {
        if (mBlockList.size() == 0) {
            return;
        }
        Block prevBlock = mBlockList.get(mBlockList.size() - 1);
        if (prevBlock != null) {
            Block block = Block.createBlock(data, prevBlock.getCurrentBlockHash());
            mBlockList.add(block);
        }
    }

    public static List<Block> newBlockChain() {
        mBlockList.add(Block.newGenesisBlock());

        return mBlockList;

    }

    public void NewBlockChain() {
    }
}
