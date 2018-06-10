package com.yangxingang;

import com.yangxingang.bean.Block;
import com.yangxingang.bean.BlockChain;
import com.yangxingang.util.Utils;

import java.util.List;

/**
 * 区块链主函数
 */
public class MainApp {
    public static void main(String args[]) {
        testBlockChain();
    }

    /**
     * 测试方法
     */
    private static void testBlockChain() {
        BlockChain blockChain = new BlockChain();
        List<Block> mBlockChainList = blockChain.newBlockChain();
        blockChain.addBlock("A to B send 1btc");
        blockChain.addBlock("B to C send 3btc");


        for (int i = 0; i < mBlockChainList.size(); i++) {
            Block block =  mBlockChainList.get(i);
            String blockdata = block.getData();
            String blockNonce = block.getNonce() + "";
            String blockPrevHash = block.getPrevBlockHash();
            String blockTimestamp = block.getTimestamp();
            String blockVersion = block.getVersion() + "";
            String blockhash = block.getCurrentBlockHash() + "";

            Utils.log("============block"+(i+1),"==================");
            Utils.log("blockVersion",blockVersion);
            Utils.log("blockdata",blockdata);
            Utils.log("blockhash",blockhash);
            Utils.log("blockPrevHash",blockPrevHash);
            Utils.log("blockTimestamp",blockTimestamp);
            Utils.log("blockNonce",blockNonce);

        }

    }
}
