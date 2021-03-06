package nc.crafting.nei;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import nc.NuclearCraft;
import nc.block.basic.NCBlocks;
import nc.item.NCItems;
import nc.tile.generator.TileFissionReactor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class InfoRecipes {
	private static final InfoRecipes infoBase = new InfoRecipes();
	@SuppressWarnings("rawtypes")
	private Map info = new HashMap();
	@SuppressWarnings("rawtypes")
	private Map infoTypes = new HashMap();

	public static InfoRecipes info() {
		return infoBase;
	}
	
	public String text(String s) {
		return StatCollector.translateToLocal(s);
	}
	
	private InfoRecipes() {
		
		addRecipe(new ItemStack(NCBlocks.fissionReactorGraphiteIdle), "-Nuclear fuel types below--Check uses in NEI for more-info:-"+text("gui.LEU")+"      "+text("gui.HEU")+"-"+text("gui.LEP")+"      "+text("gui.HEP")+"-"+text("gui.MOX")+"      "+text("gui.TBU"));
		addRecipe(new ItemStack(NCBlocks.reactionGeneratorIdle), "-Uses nuclear fuel-and Universal Reactant,-Redstone, Gunpowder, Ghast-Tears, Nether Wart or Blaze-Powder as the catalyst to-generate " + (NuclearCraft.reactionGeneratorRF*2) + " RF/t");
		addRecipe(new ItemStack(NCBlocks.nuclearFurnaceIdle), "-Smelts items very fast-and uses simple nuclear fuels");
		addRecipe(new ItemStack(NCBlocks.furnaceIdle), "-A more efficient furnace");
		addRecipe(new ItemStack(NCBlocks.crusherIdle), "-Uses burnable fuels to-crush items");
		addRecipe(new ItemStack(NCBlocks.electricCrusherIdle), "-Uses RF to crush items--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.electricFurnaceIdle), "-Uses RF to smelt items-efficiently--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.separatorIdle), "-Uses RF to separate-materials into their different-isotopes--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.hastenerIdle), "-Uses RF to cause-radioactive materials to-decay quickly--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.graphiteBlock), "-Generates additional RF-and heat in Fission Reactors");
		addRecipe(new ItemStack(NCBlocks.cellBlock), "-Required in the construction-of Fission Reactors");
		addRecipe(new ItemStack(NCBlocks.reactorBlock), "-Simple block that makes up-the exterior of Fission-Reactors");
		addRecipe(new ItemStack(NCBlocks.machineBlock), "-Used in the construction of-many machines");
		addRecipe(new ItemStack(NCBlocks.coolerBlock), "-Removes heat from-Fission Reactors");
		addRecipe(new ItemStack(NCBlocks.speedBlock), "-Causes nuclear fuels to-deplete faster in Fission-Reactors");
		addRecipe(new ItemStack(NCBlocks.blastBlock), "-Three times as blast-resistant as obsidian--Can resist nuke explosions");
		addRecipe(new ItemStack(NCBlocks.nuclearWorkspace), "-An advanced 5x5-crafting table used to-make many things from-NuclearCraft");
		addRecipe(new ItemStack(NCBlocks.fusionReactor), "-An advanced RF generator-that fuses Hydrogen, Deuterium,-Tritium, Helium3, Lithium6,-Lithium7 and Boron11 to-generate a very large-amount of RF");
		addRecipe(new ItemStack(NCBlocks.tubing1), "-Purely decorative block--Looks nice at the edges of-Fission Reactors");
		addRecipe(new ItemStack(NCBlocks.tubing2), "-Purely decorative block--Looks nice at the edges of-Fission Reactors");
		addRecipe(new ItemStack(NCBlocks.RTG), "-Generates a constant-stream of " + NuclearCraft.RTGRF + " RF/t");
		addRecipe(new ItemStack(NCBlocks.WRTG), "-Generates a constant-stream of " + NuclearCraft.WRTGRF + " RF/t");
		addRecipe(new ItemStack(NCBlocks.solarPanel), "-Generates a constant-stream of " + NuclearCraft.solarRF + " RF/t during-the day");
		addRecipe(new ItemStack(NCBlocks.collectorIdle), "-Slowly generates Helium4-from the Thorium inside of it");
		addRecipe(new ItemStack(NCBlocks.nuke), "-A cruel joke, a fun time,-or just a big hole--Nuff said");
		addRecipe(new ItemStack(NCBlocks.electrolyserIdle), "-Uses RF to separate-water into Oxygen, Hydrogen-and Deuterium--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.oxidiserIdle), "-Uses RF to oxidise materials--Makes nuclear fuels more-efficient--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.ioniserIdle), "-Uses RF to ionise atoms--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.coolerIdle), "-Uses RF to cool Helium4-drastically to temperatures-of around 1 Kelvin-above absolute zero,-causing it to liquify--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.irradiatorIdle), "-Uses RF to bathe-materials in neutron-radiation, causing changes in-nuclear structure--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.factoryIdle), "-A very useful machine-that uses RF to create-machine parts and-efficiently process ores--Can accept speed and-efficiency upgrades");
		addRecipe(new ItemStack(NCBlocks.heliumExtractorIdle), "-Uses RF to carefully-extract Liquid Helium-from its cells, so that it-can be transferred as a fluid");
		addRecipe(new ItemStack(NCBlocks.electromagnetIdle), "-Used to control the-proton beams in particle-accelerators--Require " + NuclearCraft.electromagnetRF + " RF/t to run-continuously, and require-cooling from Supercoolers");
		addRecipe(new ItemStack(NCBlocks.supercoolerIdle), "-Used in the construction-of particle accelerators-to cool the superconducting-electromagnets--Require " + NuclearCraft.electromagnetHe + " mB of Liquid-Helium per second to run-continuously");
		addRecipe(new ItemStack(NCBlocks.synchrotronIdle), "-Place at the corner of a-particle accelerator ring--Takes in proton cells and-fires them into the accelerator");
		addRecipe(new ItemStack(NCBlocks.simpleQuantumUp), "-A block that mimics the-probabilistic quantum-mechanical physics of a spin-1/2 particle, such as an-electron or a neutron");
		addRecipe(new ItemStack(NCBlocks.simpleQuantumDown), "-A block that mimics the-probabilistic quantum-mechanical physics of a spin-1/2 particle, such as an-electron or a neutron");
		addRecipe(new ItemStack(NCBlocks.blockHelium), "-Created by extraction-from supercooled Helium4-cells--Required for supercoolers-to cool down electromagnets-in a particle accelerator");
		
		addRecipe(new ItemStack(NCItems.toughBow), "-A better bow");
		addRecipe(new ItemStack(NCItems.pistol), "-Uses Depleted Uranium-bullets--Deals big damage");
		addRecipe(new ItemStack(NCItems.dUBullet), "-Pistol ammo");
		addRecipe(new ItemStack(NCItems.toughAlloyPaxel), "-A multitool");
		addRecipe(new ItemStack(NCItems.dUPaxel), "-A multitool");
		addRecipe(new ItemStack(NCItems.upgrade), "-Used to increase the-size of Fission Reactors");
		addRecipe(new ItemStack(NCItems.upgradeSpeed), "-Used to increase the-speed of machines");
		addRecipe(new ItemStack(NCItems.upgradeEnergy), "-Used to increase the-energy efficiency of machines");
		addRecipe(new ItemStack(NCItems.nuclearGrenade), "-A VERY deadly bomb");
		addRecipe(new ItemStack(NCItems.portableEnderChest), "-Portable access to your-vanilla ender chest");
		
		fissionFuelInfo(11, 15, 15000, 28);
		fissionFuelInfo(17, 15, 15000, 28);
		fissionFuelInfo(12, 68, 15000, 280);
		fissionFuelInfo(18, 68, 15000, 280);
		fissionFuelInfo(13, 30, 28800, 84);
		fissionFuelInfo(19, 30, 28800, 84);
		fissionFuelInfo(14, 135, 28800, 840);
		fissionFuelInfo(20, 135, 28800, 840);
		fissionFuelInfo(15, 33, 20000, 90);
		fissionFuelInfo(21, 33, 20000, 90);
		fissionFuelInfo(16, 4, 3750, 4);
		
		fissionFuelInfo(59, 23, 15000, 35);
		fissionFuelInfo(63, 23, 15000, 35);
		fissionFuelInfo(60, 101, 15000, 350);
		fissionFuelInfo(64, 101, 15000, 350);
		fissionFuelInfo(61, 45, 28800, 105);
		fissionFuelInfo(65, 45, 28800, 105);
		fissionFuelInfo(62, 203, 28800, 1050);
		fissionFuelInfo(66, 203, 28800, 1050);
		
		addRecipe(new ItemStack(NCItems.dominoes), "-Paul's Favourite: He'll-follow anyone he sees-carrying this in their hand...");
		addRecipe(new ItemStack(NCItems.fuel, 1, 34), "-Right click on a water-source block with an-empty fluid cell to obtain");
		addRecipe(new ItemStack(NCItems.fuel, 1, 45), "-Right click on a water-source block to-obtain a water cell");
		
		addRecipe(new ItemStack(NCItems.fuel, 1, 35), "-Used to oxidise and-improve fission fuels");
		addRecipe(new ItemStack(NCItems.fuel, 1, 36), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 37), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 38), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 39), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 41), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 42), "-Fusion fuel");
		addRecipe(new ItemStack(NCItems.fuel, 1, 44), "-Fusion fuel");
	}

	public void fissionFuelInfo(int meta, int power, int time, int heat) {
		addRecipe(new ItemStack(NCItems.fuel, 1, meta), "Base Power = " + power*TileFissionReactor.power + " RF/t-Lifetime = " + (7200000*NuclearCraft.fissionEfficiency)/(time*20) + " s-Base Heat = "+ heat + " H/t-Base Total Energy = " + (720*power*NuclearCraft.fissionRF*NuclearCraft.fissionEfficiency)/time + " kRF" + "-* Values for a 1*1*1 Reactor-Multiply Base Power by-4 for a 3*3*3 Reactor,-9 for a 5*5*5 Reactor, etc.-Multiply Base Heat-and Base Energy by-2 for a 3*3*3 Reactor,-3 for a 5*5*5 Reactor, etc.");
	}
		
	@SuppressWarnings("unchecked")
	public void addRecipe(ItemStack input, String info) {
		this.info.put(input, info);
	}

	@SuppressWarnings("unchecked")
	public void addRecipe(String type, ItemStack input, String info) {
		this.info.put(input, info);
		this.infoTypes.put(input, type);
	}

	@SuppressWarnings("rawtypes")
	public String getInfo(ItemStack stack) {
		Iterator iterator = this.info.entrySet().iterator();
		Map.Entry entry;
		do {
			if (!iterator.hasNext()) {
				return null;
			}
			entry = (Map.Entry)iterator.next();
		}
		while (!func_151397_a(stack, (ItemStack)entry.getKey()));
		return (String)entry.getValue();
	}

	private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_) {
		return (p_151397_2_.getItem() == p_151397_1_.getItem()) && ((p_151397_2_.getItemDamage() == 32767) || (p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage()));
	}
	
	@SuppressWarnings("rawtypes")
	public Map getInfoList() {
		return this.info;
	}

	@SuppressWarnings("rawtypes")
	public Map getInfoType() {
		return this.infoTypes;
	}
}