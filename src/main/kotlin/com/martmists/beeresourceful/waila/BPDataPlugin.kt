package com.martmists.beeresourceful.waila

import io.github.alloffabric.beeproductive.BeeProductive
import io.github.alloffabric.beeproductive.api.hive.BeehiveProvider
import mcp.mobius.waila.api.*
import net.minecraft.block.BeehiveBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.passive.BeeEntity
import net.minecraft.nbt.CompoundTag
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.LiteralText
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import net.minecraft.world.World
import java.awt.Dimension

class BPDataPlugin : IWailaPlugin {
    object BeeBlockComponentProvider : IComponentProvider {
        override fun appendTail(tooltip: MutableList<Text>, accessor: IDataAccessor, config: IPluginConfig) {
            tooltip as ITaggableList<Identifier, Text>

            val flavors = accessor.serverData.get("beeproductive") as CompoundTag?

            if (flavors != null && !flavors.isEmpty) {
                tooltip.setTag(Identifier("beeresourceful", "title"), LiteralText("Nectars in hive:"))
                flavors.keys.forEachIndexed { i, it ->
                    tooltip.setTag(
                            Identifier("beeresourceful", i.toString()),
                            LiteralText("  $it: ${flavors.getInt(it)}")
                    )
                }
            }
        }
    }

    object BeeBlockDataProvider : IServerDataProvider<BlockEntity> {
        override fun appendServerData(data: CompoundTag, player: ServerPlayerEntity, world: World, t: BlockEntity) {
            val hive = (t.cachedState.block as BeehiveProvider).getBeehive(world, t.pos, t.cachedState)
            val tag = CompoundTag()
            hive.flavors.forEach { (flavor, weight) ->
                tag.putInt(
                        BeeProductive.HONEY_FLAVORS.getId(flavor).toString(),
                        weight
                )
            }
            data.put("beeproductive", tag)
        }
    }

    object BeeEntityComponentProvider : IComponentProvider {
        override fun appendTail(tooltip: MutableList<Text>, accessor: IDataAccessor, config: IPluginConfig) {
            tooltip as ITaggableList<Identifier, Text>

            val flavor = accessor.serverData.getString("beeproductive_flavor")
            if (flavor != null)
                tooltip.setTag(
                        Identifier("beeresourceful", "bee_flavor"),
                        LiteralText("Nectar Flavor: $flavor")
                )
        }
    }

    object BeeEntityDataProvider : IServerDataProvider<LivingEntity> {
        override fun appendServerData(data: CompoundTag, player: ServerPlayerEntity, world: World, t: LivingEntity) {
            val component = BeeProductive.BEE_COMPONENT.get(t as BeeEntity)
            data.putString(
                    "beeproductive_flavor",
                    BeeProductive.NECTARS.getId(component.nectar).toString()
            )
        }
    }

    override fun register(p0: IRegistrar) {
        p0.registerComponentProvider(BeeBlockComponentProvider, TooltipPosition.TAIL, BeehiveBlock::class.java)
        p0.registerComponentProvider(BeeEntityComponentProvider, TooltipPosition.TAIL, BeeEntity::class.java)
        p0.registerBlockDataProvider(BeeBlockDataProvider, BeehiveBlock::class.java)
        p0.registerEntityDataProvider(BeeEntityDataProvider, BeeEntity::class.java)
    }
}