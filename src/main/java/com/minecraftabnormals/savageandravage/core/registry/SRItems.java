package com.minecraftabnormals.savageandravage.core.registry;

import com.minecraftabnormals.savageandravage.common.item.CreeperSporesItem;
import com.minecraftabnormals.savageandravage.common.item.CleaverOfBeheadingItem;
import com.minecraftabnormals.savageandravage.common.item.GrieferArmorItem;
import com.minecraftabnormals.savageandravage.common.item.WandOfFreezingItem;
import com.minecraftabnormals.savageandravage.common.item.MischiefArrowItem;
import com.minecraftabnormals.savageandravage.core.SavageAndRavage;
import com.minecraftabnormals.savageandravage.core.other.SRArmorMaterial;
import com.minecraftabnormals.savageandravage.core.other.SRItemTier;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SavageAndRavage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SRItems {

    public static final RegistryHelper HELPER = SavageAndRavage.REGISTRY_HELPER;

    public static final RegistryObject<Item> CREEPER_SPORES = HELPER.createItem("creeper_spores", () -> new CreeperSporesItem(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> MISCHIEF_ARROW = HELPER.createItem("mischief_arrow", () -> new MischiefArrowItem(new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> BLAST_PROOF_PLATING = HELPER.createItem("blast_proof_plating", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> GRIEFER_HELMET = HELPER.createItem("griefer_helmet", () -> new GrieferArmorItem(SRArmorMaterial.GRIEFER, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> GRIEFER_CHESTPLATE = HELPER.createItem("griefer_chestplate", () -> new GrieferArmorItem(SRArmorMaterial.GRIEFER, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> GRIEFER_LEGGINGS = HELPER.createItem("griefer_leggings", () -> new GrieferArmorItem(SRArmorMaterial.GRIEFER, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> GRIEFER_BOOTS = HELPER.createItem("griefer_boots", () -> new GrieferArmorItem(SRArmorMaterial.GRIEFER, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> WAND_OF_FREEZING = HELPER.createItem("wand_of_freezing", () -> new WandOfFreezingItem(new Item.Properties().maxDamage(250).rarity(Rarity.UNCOMMON).group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> CLEAVER_OF_BEHEADING = HELPER.createItem("cleaver_of_beheading", () -> new CleaverOfBeheadingItem(SRItemTier.CLEAVER, 6.5f, -3.1F, new Item.Properties().rarity(Rarity.UNCOMMON).maxStackSize(1).group(ItemGroup.COMBAT)));
    
    public static final RegistryObject<Item> SKELETON_VILLAGER_SPAWN_EGG = HELPER.createSpawnEggItem("skeleton_villager", SREntities.SKELETON_VILLAGER::get, 11447986, 9407641);
    public static final RegistryObject<Item> GRIEFER_SPAWN_EGG = HELPER.createSpawnEggItem("griefer", SREntities.GRIEFER::get, 8296024, 16037892);
    public static final RegistryObject<Item> ICEOLOGER_SPAWN_EGG = HELPER.createSpawnEggItem("iceologer", SREntities.ICEOLOGER::get, 9343891, 1388394);
    public static final RegistryObject<Item> EXECUTIONER_SPAWN_EGG = HELPER.createSpawnEggItem("executioner", SREntities.EXECUTIONER::get, 0x8E9393, 0x6F484C);

    public static void registerItemProperties() {
        // Shouldn't these be under your mod id? - Ocelot
        ItemModelsProperties.func_239418_a_(Items.CROSSBOW, new ResourceLocation("mischief_arrow"), (stack, world, entity) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, SRItems.MISCHIEF_ARROW.get()) ? 1.0F : 0.0F);
        ItemModelsProperties.func_239418_a_(Items.CROSSBOW, new ResourceLocation("spectral_arrow"), (stack, world, entity) -> entity != null && CrossbowItem.isCharged(stack) && CrossbowItem.hasChargedProjectile(stack, Items.SPECTRAL_ARROW) ? 1.0F : 0.0F);
    }
}