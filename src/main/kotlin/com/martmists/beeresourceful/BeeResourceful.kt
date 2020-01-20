package com.martmists.beeresourceful

import com.martmists.beeresourceful.ext.registerItem
import com.martmists.beeresourceful.ext.registerNectar
import com.martmists.beeresourceful.libcd.RecipeCreator
import com.martmists.beeresourceful.nectars.Potions
import com.martmists.beeresourceful.nectars.Vanilla
import com.martmists.beeresourceful.nectars.compat.MobZ
import com.martmists.beeresourceful.nectars.compat.Oysters
import com.martmists.beeresourceful.nectars.compat.TechReborn
import com.swordglowsblue.artifice.api.Artifice
import io.github.alloffabric.beeproductive.BeeProductive
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.alloffabric.beeproductive.api.Nectar
import io.github.alloffabric.beeproductive.api.hive.Beehive
import net.fabricmc.api.EnvType
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.entity.passive.BeeEntity
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import org.apache.logging.log4j.LogManager

object BeeResourceful : ModInitializer {
    val logger = LogManager.getLogger("Bee Resourceful")

    override fun onInitialize() {
        logger.info("[Bee Resourceful] loading items...")

        logger.info("[Bee Resourceful] Adding Vanilla drops...")
        Vanilla.init()

        logger.info("[Bee Resourceful] Adding potions...")
        Potions.init()

        if (FabricLoader.getInstance().environmentType == EnvType.CLIENT) {
            logger.info("[Bee Resourceful] Adding Artifice resources...")

            Artifice.registerAssets(Identifier("beeresourceful", "br_potion_data")) { pack ->
                pack.addTranslations(Identifier("beeresourceful", "en_us")) { translations ->
                    Potions.PotionFlavors.forEach { potion ->
                        val id = Identifier("beeresourceful", "potion_" + potion.key + "_nectar")

                        translations.entry("item.beeresourceful." + id.path, id.path.replace("potion_", "potion_of_").split("_").joinToString(" ") { if (it != "of") it.capitalize() else it })

                        pack.addItemModel(id) {
                            it.parent(Identifier("minecraft", "item/generated"))
                            it.texture("layer0", Identifier("beeresourceful", "item/potion_nectar"))
                        }

                    }
                }
            }
        }

        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            logger.info("[Bee Resourceful] Adding TR drops...")
            TechReborn.init()
        }

        if (FabricLoader.getInstance().isModLoaded("oysters")) {
            logger.info("[Bee Resourceful] Adding Oysters drops...")
            Oysters.init()
        }

        if (FabricLoader.getInstance().isModLoaded("mobz")) {
            logger.info("[Bee Resourceful] Adding MobZ drops...")
            MobZ.init()
        }

        logger.info("[Bee Resourceful] Done loading. Enjoy!")
    }

    fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, Identifier("beeresourceful", name + "_nectar"), item)
    }

    fun registerNectar(name: String, nectar: (BeeEntity, Beehive) -> Unit): Nectar {
        return Registry.register(BeeProductive.NECTARS, Identifier("beeresourceful", name), Nectar(nectar)).also { it.registerItem(name) }
    }

    fun registerFlavor(name: String, flavor: HoneyFlavor): HoneyFlavor {
        return Registry.register(BeeProductive.HONEY_FLAVORS, Identifier("beeresourceful", name), flavor).also {
            it.registerNectar(name)
            registerRecipe(name, flavor)
        }
    }

    fun registerRecipe(name: String, flavor: HoneyFlavor) {
        if (name.startsWith("potion_"))
            RecipeCreator.potionFlavors[name] = flavor
        else
            RecipeCreator.flavors[name] = flavor
    }
}