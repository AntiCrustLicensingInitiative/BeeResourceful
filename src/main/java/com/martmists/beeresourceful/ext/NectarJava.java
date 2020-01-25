/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.Nectar
 *  io.github.alloffabric.beeproductive.init.BeeProdItems
 *  io.github.alloffabric.beeproductive.item.NectarItem
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$Settings
 *  net.minecraft.item.ItemGroup
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.ext;

import com.martmists.beeresourceful.BeeResourceful;
import io.github.alloffabric.beeproductive.api.Nectar;
import io.github.alloffabric.beeproductive.init.BeeProdItems;
import io.github.alloffabric.beeproductive.item.NectarItem;
import net.minecraft.item.Item;


public final class NectarJava {
	public static Item registerItem(Nectar $this$registerItem, String name) {
		return BeeResourceful.INSTANCE.registerItem(name, new NectarItem($this$registerItem, new Item.Settings().group(BeeProdItems.NECTAR_GROUP)));
	}
}

