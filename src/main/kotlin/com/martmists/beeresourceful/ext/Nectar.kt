package com.martmists.beeresourceful.ext

import com.martmists.beeresourceful.BeeResourceful
import io.github.alloffabric.beeproductive.api.Nectar
import io.github.alloffabric.beeproductive.init.BeeProdItems
import io.github.alloffabric.beeproductive.item.NectarItem
import net.minecraft.item.Item

fun Nectar.registerItem(name: String) = BeeResourceful.registerItem(name, NectarItem(this, Item.Settings().group(BeeProdItems.NECTAR_GROUP)))