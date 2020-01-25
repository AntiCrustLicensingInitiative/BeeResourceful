/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.libcd;

import com.martmists.beeresourceful.BeeResourceful;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import java.util.ArrayList;
import java.util.List;


public final class CustomNectar {

	private static final List<String> knownNames;
	public static final CustomNectar INSTANCE;


	public final List<String> getKnownNames() {
		return knownNames;
	}


	public final void addNectar(String name, ItemStack shearing, ItemStack bottling) {


		if (!knownNames.contains(name)) {
			knownNames.add(name);
			BeeResourceful.INSTANCE.registerFlavor(name, new HoneyFlavor(shearing, bottling));
		}
	}

	public static /* synthetic */ void addNectar$default(CustomNectar customNectar, String string, ItemStack itemStack, ItemStack itemStack2, int n, Object object) {
		if ((n & 2) != 0) {
			itemStack = new ItemStack(Items.HONEYCOMB, 3);
		}
		if ((n & 4) != 0) {
			itemStack2 = new ItemStack(Items.HONEY_BOTTLE, 1);
		}
		customNectar.addNectar(string, itemStack, itemStack2);
	}


	public final void addNectar(String name, ItemStack shearing) {
		CustomNectar.addNectar$default(this, name, shearing, null, 4, null);
	}


	public final void addNectar(String name) {
		CustomNectar.addNectar$default(this, name, null, null, 6, null);
	}

	static {
		INSTANCE = new CustomNectar();
		knownNames = new ArrayList();
	}
}

