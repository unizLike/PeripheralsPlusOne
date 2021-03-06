package com.austinv11.peripheralsplusplus.blocks;

import com.austinv11.collectiveframework.minecraft.reference.ModIds;
import com.austinv11.peripheralsplusplus.reference.Reference;
import com.austinv11.peripheralsplusplus.tiles.TileEntityMEBridge;
import com.austinv11.peripheralsplusplus.tiles.TileEntityModNotLoaded;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class BlockMEBridge extends BlockPppBase implements ITileEntityProvider {

	public BlockMEBridge() {
		super();
		this.setRegistryName(Reference.MOD_ID, "me_bridge");
		this.setUnlocalizedName("me_bridge");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return Loader.isModLoaded(ModIds.APPLIED_ENGERGISTICS) ? new TileEntityMEBridge() :
				new TileEntityModNotLoaded(ModIds.APPLIED_ENGERGISTICS);
	}

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (!Loader.isModLoaded(ModIds.APPLIED_ENGERGISTICS))
			return;
        TileEntityMEBridge meBridge = (TileEntityMEBridge) world.getTileEntity(pos);
        if (meBridge == null || !(placer instanceof EntityPlayer))
        	return;
        meBridge.setPlayer((EntityPlayer)placer);
    }
}
