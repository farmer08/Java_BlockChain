package com.yangxingang.bean;

import com.yangxingang.util.Utils;

/**
 * 区块
 */
public class Block {
    private static final String GENESISBLOCKSTR = "Create Genesis Block";
    public int version = 1;//版本
    public String prevBlockHash = "";//前一个区块的hash
    public String currentBlockHash = "";//当前区块的hash
    public String timestamp = "";//当前区块产生的时间
    public int nonce = 0;//随机值
    public String data = "";

    public Block() {
        this.version = 1;
        this.nonce = 5;
        this.timestamp = Utils.getSystemTime();
    }

    /**
     * 创建创世区块
     *
     * @return
     */
    public static Block newGenesisBlock() {
        Block block = createBlock(GENESISBLOCKSTR,"");
        return block;
    }

    /**
     * 创建普通区块
     *
     * 普通区块和创世区块的区别就是创世区块没有prevhash
     *
     * @return
     */
    public static Block createBlock(String data, String prevBlockHash) {
        Block block = new Block();
        block.setPrevBlockHash(prevBlockHash);//创世区块没有前一个区块的hash
        block.setData(data);
        block.setCurrentBlockHash(setHash(block));
        return block;
    }

    /**
     * 设置hash
     *
     * @param block 需要计算的区块
     * @return 当前区块的hash值
     */
    public static String setHash(Block block) {
        String currentBlockdata = block.getData();
        String currentBlockNonce = block.getNonce() + "";
        String currentBlockPrevHash = block.getPrevBlockHash();
        String currentBlockTimestamp = block.getTimestamp();
        String currentBlockVersion = block.getVersion() + "";
        String currentBlockHash = Utils.signWithSha256(currentBlockdata +
                currentBlockNonce + currentBlockPrevHash + currentBlockTimestamp
                + currentBlockVersion);

        return currentBlockHash;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public void setPrevBlockHash(String prevBlockHash) {
        this.prevBlockHash = prevBlockHash;
    }

    public String getCurrentBlockHash() {
        return currentBlockHash;
    }

    public void setCurrentBlockHash(String currentBlockHash) {
        this.currentBlockHash = currentBlockHash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
