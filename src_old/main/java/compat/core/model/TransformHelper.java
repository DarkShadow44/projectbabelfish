package compat.core.model;

import com.google.common.collect.ImmutableMap;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraftforge.client.model.ForgeBlockStateV1.Transforms;
import net.minecraftforge.common.model.TRSRTransformation;

public class TransformHelper {

	public static final ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> ITEM_GENERATED;
	public static final ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> BLOCK_GENERATED;

	static {

		ImmutableMap.Builder<TransformType, TRSRTransformation> builder;

		builder = ImmutableMap.builder();
		TRSRTransformation thirdPersonItem = Transforms.convert(0, 3, 1, 0, 0, 0, 0.55f);
		TRSRTransformation firstPersonItem = Transforms.convert(1.13f, 3.2f, 1.13f, 0, -90, 25, 0.68f);
		builder.put(TransformType.GROUND, Transforms.convert(0, 2, 0, 0, 0, 0, 0.5f));
		builder.put(TransformType.HEAD, Transforms.convert(0, 13, 7, 0, 180, 0, 1));
		builder.put(TransformType.THIRD_PERSON_RIGHT_HAND, thirdPersonItem);
		builder.put(TransformType.THIRD_PERSON_LEFT_HAND, Transforms.leftify(thirdPersonItem));
		builder.put(TransformType.FIRST_PERSON_RIGHT_HAND, firstPersonItem);
		builder.put(TransformType.FIRST_PERSON_LEFT_HAND, Transforms.leftify(firstPersonItem));
		builder.put(TransformType.FIXED, Transforms.convert(0, 0, 0, 0, 180, 0, 1));
		ITEM_GENERATED = builder.build();

		builder = ImmutableMap.builder();
		TRSRTransformation thirdPersonBlock = Transforms.convert(0, 2.5f, 0, 75, 45, 0, 0.375f);
		builder.put(ItemCameraTransforms.TransformType.GUI, Transforms.convert(0, 0, 0, 30, 225, 0, 0.625f));
		builder.put(ItemCameraTransforms.TransformType.GROUND, Transforms.convert(0, 3, 0, 0, 0, 0, 0.25f));
		builder.put(ItemCameraTransforms.TransformType.FIXED, Transforms.convert(0, 0, 0, 0, 0, 0, 0.5f));
		builder.put(ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, thirdPersonBlock);
		builder.put(ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, Transforms.leftify(thirdPersonBlock));
		builder.put(ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND, Transforms.convert(0, 0, 0, 0, 45, 0, 0.4f));
		builder.put(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, Transforms.convert(0, 0, 0, 0, 225, 0, 0.4f));
		BLOCK_GENERATED = builder.build();
	}
}
