package com.cumulusmc.artofalchemy.blockentity;

import com.cumulusmc.artofalchemy.AoAConfig;

public class BlockEntityCalcinatorPlus extends BlockEntityCalcinator {

	private int operationTime;
	private float yield;

	public BlockEntityCalcinatorPlus() {
		super(AoABlockEntities.CALCINATOR_PLUS);
		AoAConfig.CalcinatorSettings settings = AoAConfig.get().calcinatorSettings;
		operationTime = settings.opTimePlus;
		yield = settings.yieldPlus;
		maxProgress = getOperationTime();
	}

	@Override
	public int getOperationTime() {
		return operationTime;
	}

	@Override
	public float getYield() {
		return yield;
	}

}
