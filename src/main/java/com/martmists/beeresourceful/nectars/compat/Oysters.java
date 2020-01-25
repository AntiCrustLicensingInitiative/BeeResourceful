/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.item.Item
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.registry.DefaultedRegistry
 *  net.minecraft.util.registry.Registry
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.nectars.compat;

import com.martmists.beeresourceful.BeeResourceful;
import com.martmists.beeresourceful.entities.SimpleFlavor;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class Oysters {
	private static final HoneyFlavor PEARL_FLAVOR;
	public static final Oysters INSTANCE;

	public final HoneyFlavor getPEARL_FLAVOR() {
		return PEARL_FLAVOR;
	}

	public final void init() {
	}

	private Oysters() {
	}

	static {
		INSTANCE = new Oysters();
		Object object = Registry.ITEM.get(new Identifier("oysters", "blemished_pearl"));

		PEARL_FLAVOR = BeeResourceful.INSTANCE.registerFlavor("pearl", SimpleFlavor.Companion.bySheared((Item) object));
	}
}

