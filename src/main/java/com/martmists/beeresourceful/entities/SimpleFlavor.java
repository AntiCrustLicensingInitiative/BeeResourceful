/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.entities;

import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public final class SimpleFlavor extends HoneyFlavor {
	public static final Companion Companion = new Companion();

	public SimpleFlavor(Item sheared, Item bottled) {
		super(new ItemStack(sheared, 3), new ItemStack(bottled, 1));
	}

	public SimpleFlavor(ItemStack sheared, ItemStack bottled) {
		super(sheared, bottled);
	}

	public static final class Companion {
		public final SimpleFlavor bySheared(ItemStack sheared) {
			return new SimpleFlavor(sheared, new ItemStack(Items.HONEY_BOTTLE, 1));
		}

		public final SimpleFlavor byBottled(ItemStack bottled) {
			return new SimpleFlavor(new ItemStack(Items.HONEYCOMB, 3), bottled);
		}

		public final SimpleFlavor bySheared(Item sheared) {
			Item item = Items.HONEY_BOTTLE;
			return new SimpleFlavor(sheared, item);
		}

		public final SimpleFlavor byBottled(Item bottled) {
			Item item = Items.HONEYCOMB;
			return new SimpleFlavor(item, bottled);
		}

		private Companion() {
		}
	}

}

