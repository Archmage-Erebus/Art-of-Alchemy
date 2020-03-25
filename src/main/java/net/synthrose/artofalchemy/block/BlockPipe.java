package net.synthrose.artofalchemy.block;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.synthrose.artofalchemy.blockentity.BlockEntityPipe;
	
public class BlockPipe extends Block implements BlockEntityProvider {
	
	private Map<Direction, EnumProperty<IOFace>> faces;

	public BlockPipe() {
		super(Settings.of(Material.METAL).nonOpaque().noCollision());
	}
	
	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		this.faces = new HashMap<>();
		for (Direction dir : Direction.values()) {
			faces.put(dir, EnumProperty.of(dir.asString(), IOFace.class));
			builder.add(faces.get(dir));
		}
	}

	public EnumProperty<IOFace> getProperty(Direction dir) {
		return faces.get(dir);
	}
	
	public enum IOFace implements StringIdentifiable {
		NONE("none"),
		CONNECT("connect"),
		PULL("pull"),
		PUSH("push"),
		PASSIVE("passive");
		
		private String string;
		
		IOFace(String string) {
			this.string = string;
		}
		
		@Override
		public String asString() {
			return string;
		}
	}

	@Override
	public BlockEntity createBlockEntity(BlockView world) {
		return new BlockEntityPipe();
	}

}
