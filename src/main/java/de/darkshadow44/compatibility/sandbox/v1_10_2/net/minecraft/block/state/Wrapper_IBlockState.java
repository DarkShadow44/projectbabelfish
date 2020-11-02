package de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.state;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableMap;

import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.Compat_Block;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.material.Compat_Material;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Compat_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.block.properties.Wrapper_IProperty;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.Compat_EnumFacing;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_AxisAlignedBB;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.util.math.Compat_BlockPos;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_IBlockAccess;
import de.darkshadow44.compatibility.sandbox.v1_10_2.net.minecraft.world.Compat_World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;

public class Wrapper_IBlockState implements Compat_IBlockState {

	private final IBlockState original;

	public Wrapper_IBlockState(IBlockState original) {
		this.original = original;
	}

	public IBlockState getReal() {
		return original;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Comparable<T>, V extends T> Compat_IBlockState Compat_func_177226_a(Compat_IProperty<T> var1, V var2) {
		Object value = var2;
		if (value instanceof Compat_EnumFacing) {
			value = ((Compat_EnumFacing) value).getReal();
		}
		IBlockState result = original.withProperty(var1.getReal(), (V) value);
		return Compat_IBlockState.getFake(result);
	}

	@Override
	public Comparable<?> Compat_func_177229_b(Compat_IProperty<?> property) {
		Comparable<?> value = original.getValue(property.getReal());
		if (value instanceof EnumFacing) {
			return Compat_EnumFacing.map_real_to_fake((EnumFacing) value);
		}
		return value;
	}

	@Override
	public boolean Compat_isSideSolid(Compat_IBlockAccess world, Compat_BlockPos pos, Compat_EnumFacing facing) {
		return original.isSideSolid(world.getReal(), pos.getReal(), facing.getReal());
	}

	@Override
	public Compat_Block Compat_func_177230_c() {
		return new Compat_Block(original.getBlock());
	}

	public ImmutableMap<Compat_IProperty<?>, Comparable<?>> Compat_func_177228_b() {
		ImmutableMap<IProperty<?>, Comparable<?>> properties = original.getProperties();

		Map<Compat_IProperty<?>, Comparable<?>> ret = new LinkedHashMap<>();

		for (Entry<IProperty<?>, Comparable<?>> property : properties.entrySet()) {
			ret.put(new Wrapper_IProperty<>(property.getKey()), property.getValue());
		}

		return ImmutableMap.copyOf(ret);
	}

	@Override
	public Compat_Material Compat_func_185904_a() {
		return new Compat_Material(original.getMaterial());
	}

	@Override
	public Compat_AxisAlignedBB Compat_func_185918_c(Compat_World world, Compat_BlockPos pos) {
		return new Compat_AxisAlignedBB(original.getSelectedBoundingBox(world.getReal(), pos.getReal()));
	}
}
