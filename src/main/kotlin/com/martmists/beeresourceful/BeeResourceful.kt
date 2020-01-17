package com.martmists.beeresourceful

import com.martmists.beeresourceful.ext.registerItem
import com.martmists.beeresourceful.ext.registerNectar
import com.martmists.beeresourceful.libcd.CustomBPNectar
import com.martmists.beeresourceful.nectars.*
import com.swordglowsblue.artifice.api.Artifice
import io.github.alloffabric.beeproductive.BeeProductive
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.alloffabric.beeproductive.api.Nectar
import io.github.alloffabric.beeproductive.api.hive.Beehive
import io.github.alloffabric.beeproductive.init.BeeProdItems
import io.github.alloffabric.beeproductive.item.NectarItem
import net.fabricmc.api.EnvType
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.entity.passive.BeeEntity
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager

object BeeResourceful : ModInitializer {
    private val logger = LogManager.getLogger("Bee Resourceful")

    override fun onInitialize() {
        logger.info("[Bee Resourceful] loading items...")
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            logger.info("[Bee Resourceful] Loading TR drops...")
            VanillaAlt.init()
            logger.info("[Bee Resourceful] Loading Vanilla[TR] drops...")
            TechReborn.init()
        } else {
            logger.info("[Bee Resourceful] Loading Vanilla drops...")
            Vanilla.init()
        }
        VanillaCommon.init()

        logger.info("[Bee Resourceful] Adding potions...")
        Potions.init()

        if (FabricLoader.getInstance().environmentType == EnvType.CLIENT) {
            logger.info("[Bee Resourceful] Adding Artifice resources...")

            Artifice.registerAssets(Identifier("beeresourceful", "br_potion_data")){ pack ->
                pack.addTranslations(Identifier("beeresourceful", "en_us")) { translations ->
                    Potions.PotionFlavors.forEach { potion ->
                        val id = Identifier("beeresourceful", potion.key + "_nectar")

                        translations.entry("item.beeresourceful."+id.path, id.path.split("_").joinToString(" ") { it.capitalize() })

                        pack.addItemModel(id) {
                            it.parent(Identifier("minecraft", "generated"))
                            it.texture("layer0", Identifier("beeresourceful", "potion_nectar"))
                        }

                        println("Created item model and translation for $id.")
                    }
                }
            }
        }

        if (FabricLoader.getInstance().isModLoaded("oysters")){
            logger.info("[Bee Resourceful] Adding Oysters drops...")
            Oysters.init()
        }

        if (FabricLoader.getInstance().isModLoaded("mobz")){
            logger.info("[Bee Resourceful] Adding MobZ drops...")
            MobZ.init()
        }

        if (FabricLoader.getInstance().isModLoaded("libcd")){
            logger.info("[Bee Resourceful] Adding LibCD tweaker...")
            CustomBPNectar.__register()
            logger.warn(
                    "NOTE: The LibCD tweaker adds the items to the registry! " +
                    "If you create custom Nectars in one world, these will stay around " +
                    "in others until you restart your game! " +
                    "(This feature also may not work reliably on servers)")
        }

        logger.info("[Bee Resourceful] Done loading. Enjoy!")
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier("beeresourceful", name+"_nectar"), item)
    }

    fun registerNectar(name: String, nectar: (BeeEntity, Beehive) -> Unit): Nectar {
        return Registry.register(BeeProductive.NECTARS, Identifier("beeresourceful", name), Nectar(nectar)).also { it.registerItem(name) }
    }

    fun registerFlavor(name: String, flavor: HoneyFlavor): HoneyFlavor {
        return Registry.register(BeeProductive.HONEY_FLAVORS, Identifier("beeresourceful", name), flavor).also { it.registerNectar(name) }
    }
}