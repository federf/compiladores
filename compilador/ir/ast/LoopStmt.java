/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ir.ast;

/**
 *
 * @author fede
 */
public abstract class LoopStmt extends Statement {
    protected Block block;
    
	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}
}
