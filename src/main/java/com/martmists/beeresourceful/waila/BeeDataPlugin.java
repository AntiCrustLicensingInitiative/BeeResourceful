/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.BeeProductive
 *  io.github.alloffabric.beeproductive.api.BeeComponent
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  io.github.alloffabric.beeproductive.api.Nectar
 *  io.github.alloffabric.beeproductive.api.hive.Beehive
 *  io.github.alloffabric.beeproductive.api.hive.BeehiveProvider
 *  it.unimi.dsi.fastutil.objects.Object2IntMap
 *  kotlin.Metadata
 *  kotlin.TypeCastException
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  mcp.mobius.waila.api.IComponentProvider
 *  mcp.mobius.waila.api.IDataAccessor
 *  mcp.mobius.waila.api.IPluginConfig
 *  mcp.mobius.waila.api.IRegistrar
 *  mcp.mobius.waila.api.IServerDataProvider
 *  mcp.mobius.waila.api.ITaggableList
 *  mcp.mobius.waila.api.IWailaPlugin
 *  mcp.mobius.waila.api.TooltipPosition
 *  nerdhub.cardinal.components.api.ComponentType
 *  nerdhub.cardinal.components.api.component.Component
 *  net.minecraft.block.BeehiveBlock
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.BeeEntity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.text.LiteralText
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.registry.Registry
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.waila;

import io.github.alloffabric.beeproductive.BeeProductive;
import io.github.alloffabric.beeproductive.api.BeeComponent;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import io.github.alloffabric.beeproductive.api.hive.Beehive;
import io.github.alloffabric.beeproductive.api.hive.BeehiveProvider;
import mcp.mobius.waila.api.*;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import java.util.List;
import java.util.Map;
import java.util.Set;


public final class BeeDataPlugin implements IWailaPlugin {
	@Override
	public void register(IRegistrar p0) {

		p0.registerComponentProvider(BeeBlockComponentProvider.INSTANCE, TooltipPosition.TAIL, BeehiveBlock.class);
		p0.registerComponentProvider(BeeEntityComponentProvider.INSTANCE, TooltipPosition.TAIL, BeeEntity.class);
		p0.registerBlockDataProvider(BeeBlockDataProvider.INSTANCE, BeehiveBlock.class);
		p0.registerEntityDataProvider(BeeEntityDataProvider.INSTANCE, BeeEntity.class);
	}


	public static final class BeeBlockComponentProvider implements IComponentProvider {
		public static final BeeBlockComponentProvider INSTANCE;

		/*
		 * WARNING - void declaration
		 */
		@Override
		public void appendTail(List<Text> tooltip, IDataAccessor accessor, IPluginConfig config) {
			CompoundTag flavors = (CompoundTag) accessor.getServerData().get("beeproductive");
			if (flavors != null && !flavors.isEmpty()) {
				((ITaggableList<Identifier, Text>) tooltip).setTag(new Identifier("beeresourceful", "title"), new LiteralText("Nectars in hive:"));
				Set<String> keys = flavors.getKeys();
				int index = 0;
				for (String key : keys) {
					((ITaggableList<Identifier, Text>) tooltip).setTag(new Identifier("beeresourceful", String.valueOf(index)), new LiteralText("  " + key + ": " + flavors.getInt(key)));
				}
			}
		}

		private BeeBlockComponentProvider() {
		}

		static {
			INSTANCE = new BeeBlockComponentProvider();
		}
	}


	public static final class BeeBlockDataProvider implements IServerDataProvider<BlockEntity> {
		public static final BeeBlockDataProvider INSTANCE;

		@Override
		public void appendServerData(CompoundTag data, ServerPlayerEntity player, World world, BlockEntity t) {
			BlockState blockState = t.getCachedState();
			Block block = blockState.getBlock();
			Beehive hive = ((BeehiveProvider) block).getBeehive(world, t.getPos(), t.getCachedState());
			CompoundTag tag = new CompoundTag();

			Map<HoneyFlavor, Integer> map = hive.getFlavors();
			for (Map.Entry<HoneyFlavor, Integer> object : map.entrySet()) {
				tag.putInt(String.valueOf(BeeProductive.HONEY_FLAVORS.getId(object.getKey())), object.getValue());
			}
			data.put("beeproductive", tag);
		}

		private BeeBlockDataProvider() {
		}

		static {
			INSTANCE = new BeeBlockDataProvider();
		}
	}


	public static final class BeeEntityComponentProvider implements IComponentProvider {
		public static final BeeEntityComponentProvider INSTANCE;

		@Override
		public void appendTail(List<Text> tooltip, IDataAccessor accessor, IPluginConfig config) {
			String flavor = accessor.getServerData().getString("beeproductive_flavor");
			if (flavor != null) {
				((ITaggableList<Identifier, Text>) tooltip).setTag(new Identifier("beeresourceful", "bee_flavor"), new LiteralText("Nectar Flavor: " + flavor));
			}
		}

		private BeeEntityComponentProvider() {
		}

		static {
			INSTANCE = new BeeEntityComponentProvider();
		}
	}


	public static final class BeeEntityDataProvider implements IServerDataProvider<LivingEntity> {
		public static final BeeEntityDataProvider INSTANCE;

		@Override
		public void appendServerData(CompoundTag data, ServerPlayerEntity player, World world, LivingEntity t) {
			BeeComponent beeComponent = BeeProductive.BEE_COMPONENT.get(t);
			data.putString("beeproductive_flavor", String.valueOf(BeeProductive.NECTARS.getId(beeComponent.getNectar())));
		}

		private BeeEntityDataProvider() {
		}

		static {
			INSTANCE = new BeeEntityDataProvider();
		}
	}

}

