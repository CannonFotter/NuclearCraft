package nc.crafting.nei;

import nc.NuclearCraft;
import nc.block.basic.NCBlocks;
import nc.gui.crafting.GuiNuclearWorkspace;
import nc.gui.generator.GuiFissionReactor;
import nc.gui.machine.GuiCollector;
import nc.gui.machine.GuiCooler;
import nc.gui.machine.GuiCrusher;
import nc.gui.machine.GuiElectricCrusher;
import nc.gui.machine.GuiElectricFurnace;
import nc.gui.machine.GuiElectrolyser;
import nc.gui.machine.GuiFactory;
import nc.gui.machine.GuiFurnace;
import nc.gui.machine.GuiHastener;
import nc.gui.machine.GuiHeliumExtractor;
import nc.gui.machine.GuiIoniser;
import nc.gui.machine.GuiIrradiator;
import nc.gui.machine.GuiNuclearFurnace;
import nc.gui.machine.GuiOxidiser;
import nc.gui.machine.GuiSeparator;
import nc.item.NCItems;
import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.DefaultOverlayHandler;

public class NEINCConfig implements IConfigureNEI {

	public void loadConfig() {
		API.registerUsageHandler(new InfoUsageHandler());

		API.registerRecipeHandler(new CrusherRecipeHandler());
		API.registerUsageHandler(new CrusherRecipeHandler());
		API.registerRecipeHandler(new CrusherFuelRecipeHandler());
		API.registerUsageHandler(new CrusherFuelRecipeHandler());
		API.registerRecipeHandler(new MetalFurnaceRecipeHandler());
		API.registerUsageHandler(new MetalFurnaceRecipeHandler());
		API.registerRecipeHandler(new MetalFurnaceFuelRecipeHandler());
		API.registerUsageHandler(new MetalFurnaceFuelRecipeHandler());
		API.registerRecipeHandler(new NuclearFurnaceRecipeHandler());
		API.registerUsageHandler(new NuclearFurnaceRecipeHandler());
		API.registerRecipeHandler(new NuclearFurnaceFuelRecipeHandler());
		API.registerUsageHandler(new NuclearFurnaceFuelRecipeHandler());
		API.registerRecipeHandler(new ElectricCrusherRecipeHandler());
		API.registerUsageHandler(new ElectricCrusherRecipeHandler());
		API.registerRecipeHandler(new ElectricFurnaceRecipeHandler());
		API.registerUsageHandler(new ElectricFurnaceRecipeHandler());
		API.registerRecipeHandler(new HastenerRecipeHandler());
		API.registerUsageHandler(new HastenerRecipeHandler());
		API.registerRecipeHandler(new SeparatorRecipeHandler());
		API.registerUsageHandler(new SeparatorRecipeHandler());
		API.registerRecipeHandler(new NuclearWorkspaceRecipeHandler());
		API.registerUsageHandler(new NuclearWorkspaceRecipeHandler());
		//API.registerRecipeHandler(new NuclearWorkspaceShapelessRecipeHandler());
		//API.registerUsageHandler(new NuclearWorkspaceShapelessRecipeHandler());
		API.registerRecipeHandler(new FissionRecipeHandler());
		API.registerUsageHandler(new FissionRecipeHandler());
		API.registerRecipeHandler(new CollectorRecipeHandler());
		API.registerUsageHandler(new CollectorRecipeHandler());
		API.registerRecipeHandler(new ElectrolyserRecipeHandler());
		API.registerUsageHandler(new ElectrolyserRecipeHandler());
		API.registerRecipeHandler(new OxidiserRecipeHandler());
		API.registerUsageHandler(new OxidiserRecipeHandler());
		API.registerRecipeHandler(new IoniserRecipeHandler());
		API.registerUsageHandler(new IoniserRecipeHandler());
		API.registerRecipeHandler(new FactoryRecipeHandler());
		API.registerUsageHandler(new FactoryRecipeHandler());
		API.registerRecipeHandler(new IrradiatorRecipeHandler());
		API.registerUsageHandler(new IrradiatorRecipeHandler());
		API.registerRecipeHandler(new CoolerRecipeHandler());
		API.registerUsageHandler(new CoolerRecipeHandler());
		API.registerRecipeHandler(new HeliumExtractorRecipeHandler());
		API.registerUsageHandler(new HeliumExtractorRecipeHandler());
		
		API.registerRecipeHandler(new InfoUsageHandler());
		
		API.registerGuiOverlayHandler(GuiNuclearWorkspace.class, new DefaultOverlayHandler(), "nwcrafting");
		
		API.registerGuiOverlay(GuiCrusher.class, "crushing");
		API.registerGuiOverlay(GuiCrusher.class, "crushfuel");
		API.registerGuiOverlay(GuiFurnace.class, "metalsmelting");
		API.registerGuiOverlay(GuiFurnace.class, "metalfuel");
		API.registerGuiOverlay(GuiNuclearFurnace.class, "nuclearsmelting");
		API.registerGuiOverlay(GuiNuclearFurnace.class, "nuclearfuel");
		
		API.registerGuiOverlay(GuiElectricCrusher.class, "ecrushing");
		API.registerGuiOverlay(GuiElectricFurnace.class, "esmelting");
		API.registerGuiOverlay(GuiHastener.class, "hastening");
		API.registerGuiOverlay(GuiSeparator.class, "separating");
		API.registerGuiOverlay(GuiNuclearWorkspace.class, "nwcrafting");
		API.registerGuiOverlay(GuiFissionReactor.class, "fission");
		API.registerGuiOverlay(GuiCollector.class, "collecting");
		API.registerGuiOverlay(GuiElectrolyser.class, "electrolysing");
		API.registerGuiOverlay(GuiOxidiser.class, "oxidising");
		API.registerGuiOverlay(GuiIoniser.class, "ionising");
		API.registerGuiOverlay(GuiIrradiator.class, "irradiating");
		API.registerGuiOverlay(GuiCooler.class, "cooling");
		API.registerGuiOverlay(GuiFactory.class, "manufactoring");
		API.registerGuiOverlay(GuiHeliumExtractor.class, "heliumExtracting");
		
		API.hideItem(new ItemStack(NCBlocks.electricCrusherActive));
		API.hideItem(new ItemStack(NCBlocks.electricFurnaceActive));
		API.hideItem(new ItemStack(NCBlocks.crusherActive));
		API.hideItem(new ItemStack(NCBlocks.fissionReactorGraphiteActive));
		API.hideItem(new ItemStack(NCBlocks.furnaceActive));
		API.hideItem(new ItemStack(NCBlocks.hastenerActive));
		API.hideItem(new ItemStack(NCBlocks.nuclearFurnaceActive));
		API.hideItem(new ItemStack(NCBlocks.reactionGeneratorActive));
		API.hideItem(new ItemStack(NCBlocks.separatorActive));
		API.hideItem(new ItemStack(NCBlocks.collectorActive));
		API.hideItem(new ItemStack(NCBlocks.electrolyserActive));
		API.hideItem(new ItemStack(NCBlocks.oxidiserActive));
		API.hideItem(new ItemStack(NCBlocks.ioniserActive));
		API.hideItem(new ItemStack(NCBlocks.irradiatorActive));
		API.hideItem(new ItemStack(NCBlocks.coolerActive));
		API.hideItem(new ItemStack(NCBlocks.factoryActive));
		API.hideItem(new ItemStack(NCBlocks.heliumExtractorActive));
		API.hideItem(new ItemStack(NCBlocks.electromagnetActive));
		API.hideItem(new ItemStack(NCBlocks.supercoolerActive));
		API.hideItem(new ItemStack(NCBlocks.synchrotronActive));
		API.hideItem(new ItemStack(NCItems.tabItem));
		API.hideItem(new ItemStack(NCBlocks.fusionReactorBlock));
		API.hideItem(new ItemStack(NCBlocks.nukeE));
		API.hideItem(new ItemStack(NCItems.nuclearGrenadeThrown));
	}

	public String getName() {
		return "NuclearCraft NEI Plugin";
	}

	public String getVersion() {
		return NuclearCraft.version;
	}
}