/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  com.martmists.beeresourceful.libcd.RecipeCreator$potion_serializer
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  io.github.cottonmc.libcd.api.tweaker.recipe.RecipeTweaker
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.inventory.CraftingInventory
 *  net.minecraft.inventory.Inventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionUtil
 *  net.minecraft.recipe.Ingredient
 *  net.minecraft.recipe.RecipeSerializer
 *  net.minecraft.recipe.SpecialCraftingRecipe
 *  net.minecraft.recipe.SpecialRecipeSerializer
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.registry.DefaultedRegistry
 *  net.minecraft.util.registry.Registry
 *  net.minecraft.world.World
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.libcd;

import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import io.github.cottonmc.libcd.api.tweaker.recipe.RecipeTweaker;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public final class RecipeCreator {

	private static final Map<String, HoneyFlavor> flavors;

	private static final Map<String, HoneyFlavor> potionFlavors;

	private static final SpecialRecipeSerializer<PotionItemRecipe> potion_serializer;
	public static final RecipeCreator INSTANCE;


	public final Map<String, HoneyFlavor> getFlavors() {
		return flavors;
	}


	public final Map<String, HoneyFlavor> getPotionFlavors() {
		return potionFlavors;
	}

	public final void ___registerRecipes() {
		Iterator<Map.Entry<String, HoneyFlavor>> iterator = flavors.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, HoneyFlavor> $dstr$name$flavor = iterator.next();
			Map.Entry<String, HoneyFlavor> entry = $dstr$name$flavor;
			String name = entry.getKey();
			entry = $dstr$name$flavor;
			HoneyFlavor flavor = entry.getValue();
			Ingredient air = Ingredient.EMPTY;
			RecipeTweaker.INSTANCE.addShaped(new Object[][]{{air, flavor.getSheared(), air}, {flavor.getSheared(), flavor.getBottled(), flavor.getSheared()}, {air, flavor.getSheared(), air}}, new ItemStack(Registry.ITEM.get(new Identifier("beeresourceful", name + "_nectar")), 8));
		}
	}


	public final SpecialRecipeSerializer<PotionItemRecipe> getPotion_serializer() {
		return potion_serializer;
	}

	private RecipeCreator() {
	}

	static {
		INSTANCE = new RecipeCreator();
		flavors = new LinkedHashMap();
		potionFlavors = new LinkedHashMap();
		Object object = Registry.register((Registry) Registry.RECIPE_SERIALIZER, new Identifier("beeresourceful", "crafting_special_beeresourceful_potions"), new SpecialRecipeSerializer<>(PotionItemRecipe::new));
		potion_serializer = (SpecialRecipeSerializer) object;
	}


	public static final class PotionItemRecipe extends SpecialCraftingRecipe {
		public PotionItemRecipe(Identifier id) {
			super(id);
		}

		@Override
		public ItemStack craft(CraftingInventory inv) {
			ItemStack itemStack;

			if (this.matches(inv)) {
				Potion potion = PotionUtil.getPotion(inv.getInvStack(4));
				Map<String, HoneyFlavor> $this$filterValues$iv = INSTANCE.getPotionFlavors();
				LinkedHashMap<String, HoneyFlavor> result$iv = new LinkedHashMap<String, HoneyFlavor>();
                for (Map.Entry<String, HoneyFlavor> entry$iv : $this$filterValues$iv.entrySet()) {
					HoneyFlavor it = entry$iv.getValue();
					if (!potion.equals(PotionUtil.getPotion(it.getBottled()))) continue;
					result$iv.put(entry$iv.getKey(), entry$iv.getValue());
				}
				String name = result$iv.keySet().stream().findFirst().orElse(null);
				Identifier resultID = new Identifier("beeresourceful", name + "_nectar");
				itemStack = new ItemStack(Registry.ITEM.get(resultID), 8);
			} else {
                itemStack = ItemStack.EMPTY;

			}
			return itemStack;
		}

		@Override
		public boolean fits(int width, int height) {
			return width == 3 && height == 3;
		}

		@Override

		public RecipeSerializer<?> getSerializer() {
			return INSTANCE.getPotion_serializer();
		}

		@Override
		public boolean matches(CraftingInventory inv, World world) {


			return this.matches(inv);
		}

		/*
		 * Enabled force condition propagation
		 * Lifted jumps to return sites
		 */
		private boolean matches(CraftingInventory inv) {
			int it;
			Integer[] $this$all$iv = new Integer[]{0, 2, 6, 8};
			for (Integer element$iv : $this$all$iv) {
				it = ((Number) element$iv).intValue();
				ItemStack itemStack = inv.getInvStack(it);

				if (itemStack.isEmpty()) continue;
				return false;
			}
			$this$all$iv = new Integer[]{1, 3, 5, 7};
			for (Integer element$iv : $this$all$iv) {
				it = ((Number) element$iv).intValue();
				ItemStack itemStack = inv.getInvStack(it);

				if (itemStack.getItem().equals(Items.HONEYCOMB)) continue;
				return false;
			}
			Iterable $this$any$iv = INSTANCE.getPotionFlavors().values();
			if (((Collection) $this$any$iv).isEmpty()) {
				return false;
			}
			Iterator iterator = $this$any$iv.iterator();
			do {
				if (!iterator.hasNext()) return false;
				Object element$iv = iterator.next();
				HoneyFlavor it2 = (HoneyFlavor) element$iv;
				ItemStack itemStack = inv.getInvStack(4);
				if (itemStack.getItem().equals(Items.POTION) && PotionUtil.getPotion(inv.getInvStack(4)).equals(PotionUtil.getPotion(it2.getBottled()))) {
					return true;
				}
			} while (true);
		}

	}

}

