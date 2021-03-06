package nc.tile.generator;

import nc.NuclearCraft;
import nc.block.basic.NCBlocks;
import nc.block.generator.BlockFusionReactor;
import nc.item.NCItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyReceiver;

public class TileFusionReactor extends TileGenerator implements IEnergyReceiver {

		public int size = 1;
		public boolean isMain = true;
		public int below = 0;
		
	    public int EShown;
	    
	    public static double pMult = 1.25*NuclearCraft.fusionRF;
	    
	    public int HLevel;
	    public int DLevel;
	    public int TLevel;
	    public int HeLevel;
	    public int BLevel;
	    public int Li6Level;
	    public int Li7Level;
	    public int HLevel2;
	    public int DLevel2;
	    public int TLevel2;
	    public int HeLevel2;
	    public int BLevel2;
	    public int Li6Level2;
	    public int Li7Level2;
	    
	    public double HOut;
	    public double DOut;
	    public double TOut;
	    public double HE3Out;
	    public double HE4Out;
	    public double nOut;
	    
	    public static int Max = 12096000;
	    
	    public static int powerHH = 80;
	    public static int powerHD = 60;
	    public static int powerHT = 20;
	    public static int powerHHe = 20;
	    public static int powerHB = 80;
	    public static int powerHLi6 = 30;
	    public static int powerHLi7 = 120;
	    
	    public static int powerDD = 140;
	    public static int powerDT = 200;
	    public static int powerDHe = 160;
	    public static int powerDB = 20;
	    public static int powerDLi6 = 150;
	    public static int powerDLi7 = 10;
	    
	    public static int powerTT = 60;
	    public static int powerTHe = 40;
	    public static int powerTB = 10;
	    public static int powerTLi6 = 5;
	    public static int powerTLi7 = 10;
	    
	    public static int powerHeHe = 120;
	    public static int powerHeB = 5;
	    public static int powerHeLi6 = 140;
	    public static int powerHeLi7 = 30;
	    
	    public static int powerBB = 10;
	    public static int powerBLi6 = 5;
	    public static int powerBLi7 = 5;
	    
	    public static int powerLi6Li6 = 5;
	    public static int powerLi6Li7 = 5;
	    
	    public static int powerLi7Li7 = 5;
	    
	    public static int requiredHH = 10000/NuclearCraft.fusionEfficiency;
	    public static int requiredHD = 6000/NuclearCraft.fusionEfficiency;
	    public static int requiredHT = 4000/NuclearCraft.fusionEfficiency;
	    public static int requiredHHe = 4000/NuclearCraft.fusionEfficiency;
	    public static int requiredHB = 1000/NuclearCraft.fusionEfficiency;
	    public static int requiredHLi6 = 1000/NuclearCraft.fusionEfficiency;
	    public static int requiredHLi7 = 2000/NuclearCraft.fusionEfficiency;

	    public static int requiredDD = 4000/NuclearCraft.fusionEfficiency;
	    public static int requiredDT = 8000/NuclearCraft.fusionEfficiency;
	    public static int requiredDHe = 2500/NuclearCraft.fusionEfficiency;
	    public static int requiredDB = 1000/NuclearCraft.fusionEfficiency;
	    public static int requiredDLi6 = 2500/NuclearCraft.fusionEfficiency;
	    public static int requiredDLi7 = 1000/NuclearCraft.fusionEfficiency;
	    
	    public static int requiredTT = 2000/NuclearCraft.fusionEfficiency;
	    public static int requiredTHe = 1000/NuclearCraft.fusionEfficiency;
	    public static int requiredTB = 1000/NuclearCraft.fusionEfficiency;
	    public static int requiredTLi6 = 200/NuclearCraft.fusionEfficiency;
	    public static int requiredTLi7 = 400/NuclearCraft.fusionEfficiency;

	    public static int requiredHeHe = 2000/NuclearCraft.fusionEfficiency;
	    public static int requiredHeB = 500/NuclearCraft.fusionEfficiency;
	    public static int requiredHeLi6 = 2800/NuclearCraft.fusionEfficiency;
	    public static int requiredHeLi7 = 1000/NuclearCraft.fusionEfficiency;

	    public static int requiredBB = 500/NuclearCraft.fusionEfficiency;
	    public static int requiredBLi6 = 500/NuclearCraft.fusionEfficiency;
	    public static int requiredBLi7 = 500/NuclearCraft.fusionEfficiency;

	    public static int requiredLi6Li6 = 500/NuclearCraft.fusionEfficiency;
	    public static int requiredLi6Li7 = 500/NuclearCraft.fusionEfficiency;

	    public static int requiredLi7Li7 = 500/NuclearCraft.fusionEfficiency;

	    public static double maxHeat = 20000;
	    public double efficiency = 0;
	    public double heatVar = 9;
	    public double heat;

	    public static double heatHH = 8.87;
	    public static double heatHD = 8.43;
	    public static double heatHT = 9.65;
	    public static double heatHHe = 9.68;
	    public static double heatHB = 9.84;
	    public static double heatHLi6 = 9.62;
	    public static double heatHLi7 = 9.64;

	    public static double heatDD = 9.67;
	    public static double heatDT = 7.70;
	    public static double heatDHe = 8.97;
	    public static double heatDB = 9.89;
	    public static double heatDLi6 = 9.78;
	    public static double heatDLi7 = 10.10;

	    public static double heatTT = 9.46;
	    public static double heatTHe = 9.73;
	    public static double heatTB = 10.16;
	    public static double heatTLi6 = 10.28;
	    public static double heatTLi7 = 10.31;

	    public static double heatHeHe = 10.02;
	    public static double heatHeB = 10.30;
	    public static double heatHeLi6 = 10.56;
	    public static double heatHeLi7 = 10.62;

	    public static double heatBB = 10.58;
	    public static double heatBLi6 = 10.61;
	    public static double heatBLi7 = 10.69;

	    public static double heatLi6Li6 = 10.68;
	    public static double heatLi6Li7 = 10.66;

	    public static double heatLi7Li7 = 10.73;
	    
	    public int lastE;
	    public int E;
	    
		public final int[] input = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		public final int[] output = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
	    
	    public TileFusionReactor() {
			super("Fusion Reactor", 10000000, 9);
		}

	    public void updateEntity() {
	    	super.updateEntity();
	    	isMain(worldObj, xCoord, yCoord, zCoord);
	    	isMain();
	    	getBelow(worldObj, xCoord, yCoord, zCoord);
	    	getMain();
	    	if(!this.worldObj.isRemote) {
		    	setSize(worldObj, xCoord, yCoord, zCoord);
		    	energy();
		    	addEnergy();
		    	fuel1();
		    	fuel2();
		    	outputs();
		    	efficiency();
		    	for (int i = 1; i < 10; i++) {
		    		if ((heat < 8 || HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level <= 0 || HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 <= 0) && storage.getEnergyStored() >= 8000) {
		    			this.storage.receiveEnergy(-10000, false);
		    			heat = heat+0.0005;
		    		}
	    		}
		    	if (heat < 0) {
		    		heat = 0;
		    	}
	    	}
	    	if (flag != flag1) { flag1 = flag; BlockFusionReactor.updateBlockState(worldObj, xCoord, yCoord, zCoord); }
	    	markDirty();
	    }
	    
	    public void efficiency() {
	    	if (HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level <= 0 || HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 <= 0) {
	    		efficiency = 0;
	    	} else if (heat >= 8) {
	    		efficiency = 100*Math.exp(-Math.pow(heatVar-Math.log(heat), 2)/2)/(heat*Math.exp(0.5-heatVar));
	    	} else {
	    		efficiency = 0;
	    	}
	    }
	    
	    public void outputs() {
	    	if (HOut >= 336000) {
	    		if (this.slots[3] == null) { this.slots[3] = new ItemStack(NCItems.fuel, 1, 36); HOut -= 336000; }
	    		else if (this.slots[3].stackSize < 64) { this.slots[3].stackSize ++; HOut -= 336000; }
	    	}
	    	if (DOut >= 336000) {
	    		if (this.slots[4] == null) { this.slots[4] = new ItemStack(NCItems.fuel, 1, 37); DOut -= 336000; }
	    		else if (this.slots[4].stackSize < 64) { this.slots[4].stackSize ++; DOut -= 336000; }
	    	}
	    	if (TOut >= 336000) {
	    		if (this.slots[5] == null) { this.slots[5] = new ItemStack(NCItems.fuel, 1, 38); TOut -= 336000; }
	    		else if (this.slots[5].stackSize < 64) { this.slots[5].stackSize ++; TOut -= 336000; }
	    	}
	    	if (HE3Out >= 336000) {
	    		if (this.slots[6] == null) { this.slots[6] = new ItemStack(NCItems.fuel, 1, 39); HE3Out -= 336000; }
	    		else if (this.slots[6].stackSize < 64) { this.slots[6].stackSize ++; HE3Out -= 336000; }
	    	}
	    	if (HE4Out >= 336000) {
	    		if (this.slots[7] == null) { this.slots[7] = new ItemStack(NCItems.fuel, 1, 40); HE4Out -= 336000; }
	    		else if (this.slots[7].stackSize < 64) { this.slots[7].stackSize ++; HE4Out -= 336000; }
	    	}
	    	if (nOut >= 336000 && this.slots[2] != null && this.slots[2].stackSize > 0 && this.slots[2].getItem() == new ItemStack (NCItems.fuel, 1, 48).getItem() && this.slots[2].getItem().getDamage(this.slots[2]) == 48) {
	    		if (this.slots[8] == null) { this.slots[8] = new ItemStack(NCItems.fuel, 1, 47); nOut -= 336000; this.slots[2].stackSize --; if (this.slots[2].stackSize < 1) this.slots[2] = null;}
	    		else if (this.slots[8].stackSize < 64) { this.slots[8].stackSize ++; nOut -= 336000; this.slots[2].stackSize --; if (this.slots[2].stackSize < 1) this.slots[2] = null;}
	    	}
	    	
	    	if (HOut > Max) HOut = Max;
	    	if (DOut > Max) DOut = Max;
	    	if (TOut > Max) TOut = Max;
	    	if (HE3Out > Max) HE3Out = Max;
	    	if (HE4Out > Max) HE4Out = Max;
	    	if (nOut > Max) nOut = Max;
	    }
	    
	    public void setSize(World world, int x, int y, int z) {
			size = 1;
			for (int yUp = 1; yUp < 128; ++yUp) {
				if (world.getBlock(x, y + 2*yUp, z) == NCBlocks.fusionReactor) {
					size++;
				} else break;
			}
		}
	    
	    public void isMain(World world, int x, int y, int z) {
	    	if (world.getBlock(x, y - 2, z) == NCBlocks.fusionReactor) {
	    		isMain = false;
	    	} else {
	    		isMain = true;
	    	}
	    }
	    
	    public void getBelow(World world, int x, int y, int z) {
			int b = 0;
			for (int yDown = 1; yDown < 128; ++yDown) {
				if (world.getBlock(x, y - 2*yDown, z) == NCBlocks.fusionReactor) {
					b++;
				} else break;
			}
			below = b;
		}
	    
	    public TileFusionReactor getMain() {
	    	/*if (worldObj.getTileEntity(xCoord, yCoord, zCoord) == null) return null;
	    	else*/ if (worldObj.getTileEntity(xCoord, yCoord - 2*below, zCoord) == null) {
	    		below = 0;
	    		return (TileFusionReactor) worldObj.getTileEntity(xCoord, yCoord, zCoord);
	    	}
	    	else if (below != 0 && worldObj.getTileEntity(xCoord, yCoord - 2*below, zCoord) != null) {
	    		TileFusionReactor main = (TileFusionReactor) worldObj.getTileEntity(xCoord, yCoord - 2*below, zCoord);
	    		return main;
	    	} else {
	    		below = 0;
	    		return (TileFusionReactor) worldObj.getTileEntity(xCoord, yCoord, zCoord);
	    	}
	    }
	    
	    public boolean isMain() {
	    	if (worldObj.getBlock(xCoord, yCoord - 2, zCoord) == NCBlocks.fusionReactor) return false;
	    	else return true;
	    }
	    
	    private void energy() {
	    	int prevE = this.storage.getEnergyStored();
	    	int newE;
	    	//double eV = Math.sqrt(efficiency)/10;

	    	if (!worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord) && heat >=8) {
	    	lastE = storage.getEnergyStored();
	    	
	    	if (this.HLevel > 0 && this.HLevel2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHH && this.HLevel2 >= size*TileFusionReactor.requiredHH) {
		    		this.heatVar = TileFusionReactor.heatHH; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHH/100), false); this.HLevel -= size*TileFusionReactor.requiredHH; this.HLevel2 -= size*TileFusionReactor.requiredHH; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.DOut += size*TileFusionReactor.requiredHH;
		    	}
		    	if (this.HLevel < size*TileFusionReactor.requiredHH) {this.HLevel = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHH) {this.HLevel2 = 0;}
	    	}
	    	
	    	else if (this.HLevel > 0 && this.DLevel2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHD && this.DLevel2 >= size*TileFusionReactor.requiredHD) {
		    		this.heatVar = TileFusionReactor.heatHD; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHD/100), false); this.HLevel -= size*TileFusionReactor.requiredHD; this.DLevel2 -= size*TileFusionReactor.requiredHD; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE3Out += size*TileFusionReactor.requiredHD;
		    	 }
		    	if (this.HLevel < size*TileFusionReactor.requiredHD) {this.HLevel = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredHD) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.HLevel2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredHD && this.HLevel2 >= size*TileFusionReactor.requiredHD) {
		    		this.heatVar = TileFusionReactor.heatHD; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHD/100), false); this.DLevel -= size*TileFusionReactor.requiredHD; this.HLevel2 -= size*TileFusionReactor.requiredHD; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE3Out += size*TileFusionReactor.requiredHD;
		    	 }
		    	if (this.DLevel < size*TileFusionReactor.requiredHD) {this.DLevel = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHD) {this.HLevel2 = 0;}
	    	}
		    
	    	else if (this.HLevel > 0 && this.TLevel2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHT && this.TLevel2 >= size*TileFusionReactor.requiredHT) {
		    		this.heatVar = TileFusionReactor.heatHT; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHT/100), false); this.HLevel -= size*TileFusionReactor.requiredHT; this.TLevel2 -= size*TileFusionReactor.requiredHT; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE3Out += size*TileFusionReactor.requiredHT; this.nOut += size*TileFusionReactor.requiredHT/8;
		    	 }
		    	if (this.HLevel < size*TileFusionReactor.requiredHT) {this.HLevel = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredHT) {this.TLevel2 = 0;}
	    	}
		    
	    	else if (this.TLevel > 0 && this.HLevel2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredHT && this.HLevel2 >= size*TileFusionReactor.requiredHT) {
		    		this.heatVar = TileFusionReactor.heatHT; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHT/100), false); this.TLevel -= size*TileFusionReactor.requiredHT; this.HLevel2 -= size*TileFusionReactor.requiredHT; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE3Out += size*TileFusionReactor.requiredHT; this.nOut += size*TileFusionReactor.requiredHT/8;
		    	 }
		    	if (this.TLevel < size*TileFusionReactor.requiredHT) {this.TLevel = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHT) {this.HLevel2 = 0;}
	    	}
	    	
	    	else if (this.HLevel > 0 && this.HeLevel2 > 0) {
	    		if (this.HLevel >= size*TileFusionReactor.requiredHHe && this.HeLevel2 >= size*TileFusionReactor.requiredHHe) {
		    		this.heatVar = TileFusionReactor.heatHHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHHe/100), false); this.HLevel -= size*TileFusionReactor.requiredHHe; this.HeLevel2 -= size*TileFusionReactor.requiredHHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHHe;
		    	}
		    	if (this.HLevel < size*TileFusionReactor.requiredHHe) {this.HLevel = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredHHe) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.HLevel2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredHHe && this.HLevel2 >= size*TileFusionReactor.requiredHHe) {
		    		this.heatVar = TileFusionReactor.heatHHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHHe/100), false); this.HeLevel -= size*TileFusionReactor.requiredHHe; this.HLevel2 -= size*TileFusionReactor.requiredHHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHHe;
		    	 }
		    	if (this.HeLevel < size*TileFusionReactor.requiredHHe) {this.HeLevel = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHHe) {this.HLevel2 = 0;}
	    	}
	    	
	    	else if (this.HLevel > 0 && this.BLevel2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHB && this.BLevel2 >= size*TileFusionReactor.requiredHB) {
		    		this.heatVar = TileFusionReactor.heatHB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHB/100), false); this.HLevel -= size*TileFusionReactor.requiredHB; this.BLevel2 -= size*TileFusionReactor.requiredHB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHB*3;
		    	}
		    	if (this.HLevel < size*TileFusionReactor.requiredHB) {this.HLevel = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredHB) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.HLevel2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredHB && this.HLevel2 >= size*TileFusionReactor.requiredHB) {
		    		this.heatVar = TileFusionReactor.heatHB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHB/100), false); this.BLevel -= size*TileFusionReactor.requiredHB; this.HLevel2 -= size*TileFusionReactor.requiredHB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHB*3;
		    	}
		    	if (this.BLevel < size*TileFusionReactor.requiredHB) {this.BLevel = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHB) {this.HLevel2 = 0;}
	    	}
	    	
	    	else if (this.HLevel > 0 && this.Li6Level2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHLi6 && this.Li6Level2 >= size*TileFusionReactor.requiredHLi6) {
		    		this.heatVar = TileFusionReactor.heatHLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHLi6/100), false); this.HLevel -= size*TileFusionReactor.requiredHLi6; this.Li6Level2 -= size*TileFusionReactor.requiredHLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHLi6; this.TOut += size*TileFusionReactor.requiredHLi6;
		    	}
		    	if (this.HLevel < size*TileFusionReactor.requiredHLi6) {this.HLevel = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredHLi6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.HLevel2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredHLi6 && this.HLevel2 >= size*TileFusionReactor.requiredHLi6) {
		    		this.heatVar = TileFusionReactor.heatHLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHLi6/100), false); this.Li6Level -= size*TileFusionReactor.requiredHLi6; this.HLevel2 -= size*TileFusionReactor.requiredHLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHLi6; this.TOut += size*TileFusionReactor.requiredHLi6;
		    	}
		    	if (this.Li6Level < size*TileFusionReactor.requiredHLi6) {this.Li6Level = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHLi6) {this.HLevel2 = 0;}
	    	}
	    	
	    	else if (this.HLevel > 0 && this.Li7Level2 > 0) {
		    	if (this.HLevel >= size*TileFusionReactor.requiredHLi7 && this.Li7Level2 >= size*TileFusionReactor.requiredHLi7) {
		    		this.heatVar = TileFusionReactor.heatHLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHLi7/100), false); this.HLevel -= size*TileFusionReactor.requiredHLi7; this.Li7Level2 -= size*TileFusionReactor.requiredHLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHLi7*2;
		    	}
		    	if (this.HLevel < size*TileFusionReactor.requiredHLi7) {this.HLevel = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredHLi7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.HLevel2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredHLi7 && this.HLevel2 >= size*TileFusionReactor.requiredHLi7) {
		    		this.heatVar = TileFusionReactor.heatHLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHLi7/100), false); this.Li7Level -= size*TileFusionReactor.requiredHLi7; this.HLevel2 -= size*TileFusionReactor.requiredHLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHLi7*2;
		    	}
		    	if (this.Li7Level < size*TileFusionReactor.requiredHLi7) {this.Li7Level = 0;}
		    	if (this.HLevel2 < size*TileFusionReactor.requiredHLi7) {this.HLevel2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.DLevel > 0 && this.DLevel2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDD && this.DLevel2 >= size*TileFusionReactor.requiredDD) {
		    		this.heatVar = TileFusionReactor.heatDD; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDD/100), false); this.DLevel -= size*TileFusionReactor.requiredDD; this.DLevel2 -= size*TileFusionReactor.requiredDD; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE3Out += size*TileFusionReactor.requiredDD/2; this.TOut += size*TileFusionReactor.requiredDD/2; this.nOut += size*TileFusionReactor.requiredDD/16; this.HOut += size*TileFusionReactor.requiredDD/2;
		    	}
		    	if (this.DLevel < size*TileFusionReactor.requiredDD) {this.DLevel = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDD) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.TLevel2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDT && this.TLevel2 >= size*TileFusionReactor.requiredDT) {
		    		this.heatVar = TileFusionReactor.heatDT; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDT/100), false); this.DLevel -= size*TileFusionReactor.requiredDT; this.TLevel2 -= size*TileFusionReactor.requiredDT; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDT; this.nOut += size*TileFusionReactor.requiredDT/8;
		    	}
		    	if (this.DLevel < size*TileFusionReactor.requiredDT) {this.DLevel = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredDT) {this.TLevel2 = 0;}
	    	}
	    	
	    	else if (this.TLevel > 0 && this.DLevel2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredDT && this.DLevel2 >= size*TileFusionReactor.requiredDT) {
		    		this.heatVar = TileFusionReactor.heatDT; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDT/100), false); this.TLevel -= size*TileFusionReactor.requiredDT; this.DLevel2 -= size*TileFusionReactor.requiredDT; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDT; this.nOut += size*TileFusionReactor.requiredDT/8;
		    	}
		    	if (this.TLevel < size*TileFusionReactor.requiredDT) {this.TLevel = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDT) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.HeLevel2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDHe && this.HeLevel2 >= size*TileFusionReactor.requiredDHe) {
		    		this.heatVar = TileFusionReactor.heatDHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDHe/100), false); this.DLevel -= size*TileFusionReactor.requiredDHe; this.HeLevel2 -= size*TileFusionReactor.requiredDHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDHe; this.HOut += size*TileFusionReactor.requiredDHe;
		    	}
		    	if (this.DLevel < size*TileFusionReactor.requiredDHe) {this.DLevel = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredDHe) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.DLevel2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredDHe && this.DLevel2 >= size*TileFusionReactor.requiredDHe) {
		    		this.heatVar = TileFusionReactor.heatDHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDHe/100), false); this.HeLevel -= size*TileFusionReactor.requiredDHe; this.DLevel2 -= size*TileFusionReactor.requiredDHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDHe; this.HOut += size*TileFusionReactor.requiredDHe;
		    	}
		    	if (this.HeLevel < size*TileFusionReactor.requiredDHe) {this.HeLevel = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDHe) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.BLevel2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDB && this.BLevel2 >= size*TileFusionReactor.requiredDB) {
		    		this.heatVar = TileFusionReactor.heatDB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDB/100), false); this.DLevel -= size*TileFusionReactor.requiredDB; this.BLevel2 -= size*TileFusionReactor.requiredDB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDB*3; this.nOut += size*TileFusionReactor.requiredDB/8;
			    }
		    	if (this.DLevel < size*TileFusionReactor.requiredDB) {this.DLevel = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredDB) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.DLevel2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredDB && this.DLevel2 >= size*TileFusionReactor.requiredDB) {
		    		this.heatVar = TileFusionReactor.heatDB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDB/100), false); this.BLevel -= size*TileFusionReactor.requiredDB; this.DLevel2 -= size*TileFusionReactor.requiredDB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDB*3; this.nOut += size*TileFusionReactor.requiredDB/8;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredDB) {this.BLevel = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDB) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.Li6Level2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDLi6 && this.Li6Level2 >= size*TileFusionReactor.requiredDLi6) {
		    		this.heatVar = TileFusionReactor.heatDLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDLi6/100), false); this.DLevel -= size*TileFusionReactor.requiredDLi6; this.Li6Level2 -= size*TileFusionReactor.requiredDLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDLi6*2;
			    }
		    	if (this.DLevel < size*TileFusionReactor.requiredDLi6) {this.DLevel = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredDLi6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.DLevel2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredDLi6 && this.DLevel2 >= size*TileFusionReactor.requiredDLi6) {
		    		this.heatVar = TileFusionReactor.heatDLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDLi6/100), false); this.Li6Level -= size*TileFusionReactor.requiredDLi6; this.DLevel2 -= size*TileFusionReactor.requiredDLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDLi6*2;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredDLi6) {this.Li6Level = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDLi6) {this.DLevel2 = 0;}
	    	}
	    	
	    	else if (this.DLevel > 0 && this.Li7Level2 > 0) {
		    	if (this.DLevel >= size*TileFusionReactor.requiredDLi7 && this.Li7Level2 >= size*TileFusionReactor.requiredDLi7) {
		    		this.heatVar = TileFusionReactor.heatDLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDLi7/100), false); this.DLevel -= size*TileFusionReactor.requiredDLi7; this.Li7Level2 -= size*TileFusionReactor.requiredDLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDLi7*2; this.nOut += size*TileFusionReactor.requiredDLi7/8;
			    }
		    	if (this.DLevel < size*TileFusionReactor.requiredDLi7) {this.DLevel = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredDLi7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.DLevel2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredDLi7 && this.DLevel2 >= size*TileFusionReactor.requiredDLi7) {
		    		this.heatVar = TileFusionReactor.heatDLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerDLi7/100), false); this.Li7Level -= size*TileFusionReactor.requiredDLi7; this.DLevel2 -= size*TileFusionReactor.requiredDLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredDLi7*2; this.nOut += size*TileFusionReactor.requiredDLi7/8;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredDLi7) {this.Li7Level = 0;}
		    	if (this.DLevel2 < size*TileFusionReactor.requiredDLi7) {this.DLevel2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.TLevel > 0 && this.TLevel2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredTT && this.TLevel2 >= size*TileFusionReactor.requiredTT) {
		    		this.heatVar = TileFusionReactor.heatTT; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTT/100), false); this.TLevel -= size*TileFusionReactor.requiredTT; this.TLevel2 -= size*TileFusionReactor.requiredTT; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTT; this.nOut += size*TileFusionReactor.requiredTT/4;
			    }
		    	if (this.TLevel < size*TileFusionReactor.requiredTT) {this.TLevel = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredTT) {this.TLevel2 = 0;}
	    	}
	    	
	    	else if (this.TLevel > 0 && this.HeLevel2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredTHe && this.HeLevel2 >= size*TileFusionReactor.requiredTHe) {
		    		this.heatVar = TileFusionReactor.heatTHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTHe/100), false); this.TLevel -= size*TileFusionReactor.requiredTHe; this.HeLevel2 -= size*TileFusionReactor.requiredTHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTHe; this.nOut += size*TileFusionReactor.requiredTHe/8; this.HOut += size*TileFusionReactor.requiredTHe;
			    }
		    	if (this.TLevel < size*TileFusionReactor.requiredTHe) {this.TLevel = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredTHe) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.TLevel2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredTHe && this.TLevel2 >= size*TileFusionReactor.requiredTHe) {
		    		this.heatVar = TileFusionReactor.heatTHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTHe/100), false); this.HeLevel -= size*TileFusionReactor.requiredTHe; this.TLevel2 -= size*TileFusionReactor.requiredTHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTHe; this.nOut += size*TileFusionReactor.requiredTHe/8; this.HOut += size*TileFusionReactor.requiredTHe;
			    }
		    	if (this.HeLevel < size*TileFusionReactor.requiredTHe) {this.HeLevel = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredTHe) {this.TLevel2 = 0;}
	    	}
	    	
	    	else if (this.TLevel > 0 && this.BLevel2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredTB && this.BLevel2 >= size*TileFusionReactor.requiredTB) {
		    		this.heatVar = TileFusionReactor.heatTB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTB/100), false); this.TLevel -= size*TileFusionReactor.requiredTB; this.BLevel2 -= size*TileFusionReactor.requiredTB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTB*3; this.nOut += size*TileFusionReactor.requiredTB/4;
			    }
		    	if (this.TLevel < size*TileFusionReactor.requiredTB) {this.TLevel = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredTB) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.TLevel2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredTB && this.TLevel2 >= size*TileFusionReactor.requiredTB) {
		    		this.heatVar = TileFusionReactor.heatTB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTB/100), false); this.BLevel -= size*TileFusionReactor.requiredTB; this.TLevel2 -= size*TileFusionReactor.requiredTB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTB*3; this.nOut += size*TileFusionReactor.requiredTB/4;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredTB) {this.BLevel = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredTB) {this.TLevel2 = 0;}
	    	}
	    	
	    	else if (this.TLevel > 0 && this.Li6Level2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredTLi6 && this.Li6Level2 >= size*TileFusionReactor.requiredTLi6) {
		    		this.heatVar = TileFusionReactor.heatTLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTLi6/100), false); this.TLevel -= size*TileFusionReactor.requiredTLi6; this.Li6Level2 -= size*TileFusionReactor.requiredTLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTLi6*2; this.nOut += size*TileFusionReactor.requiredTLi6/8;
			    }
		    	if (this.TLevel < size*TileFusionReactor.requiredTLi6) {this.TLevel = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredTLi6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.TLevel2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredTLi6 && this.TLevel2 >= size*TileFusionReactor.requiredTLi6) {
		    		this.heatVar = TileFusionReactor.heatTLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTLi6/100), false); this.Li6Level -= size*TileFusionReactor.requiredTLi6; this.TLevel2 -= size*TileFusionReactor.requiredTLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTLi6*2; this.nOut += size*TileFusionReactor.requiredTLi6/8;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredTLi6) {this.Li6Level = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredTLi6) {this.TLevel2 = 0;}
	    	}
	    	
	    	else if (this.TLevel > 0 && this.Li7Level2 > 0) {
		    	if (this.TLevel >= size*TileFusionReactor.requiredTLi7 && this.Li7Level2 >= size*TileFusionReactor.requiredTLi7) {
		    		this.heatVar = TileFusionReactor.heatTLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTLi7/100), false); this.TLevel -= size*TileFusionReactor.requiredTLi7; this.Li7Level2 -= size*TileFusionReactor.requiredTLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTLi7*2; this.nOut += size*TileFusionReactor.requiredTLi7/4;
			    }
		    	if (this.TLevel < size*TileFusionReactor.requiredTLi7) {this.TLevel = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredTLi7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.TLevel2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredTLi7 && this.TLevel2 >= size*TileFusionReactor.requiredTLi7) {
		    		this.heatVar = TileFusionReactor.heatTLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerTLi7/100), false); this.Li7Level -= size*TileFusionReactor.requiredTLi7; this.TLevel2 -= size*TileFusionReactor.requiredTLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredTLi7*2; this.nOut += size*TileFusionReactor.requiredTLi7/4;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredTLi7) {this.Li7Level = 0;}
		    	if (this.TLevel2 < size*TileFusionReactor.requiredTLi7) {this.TLevel2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.HeLevel > 0 && this.HeLevel2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredHeHe && this.HeLevel2 >= size*TileFusionReactor.requiredHeHe) {
		    		this.heatVar = TileFusionReactor.heatHeHe; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeHe/100), false); this.HeLevel -= size*TileFusionReactor.requiredHeHe; this.HeLevel2 -= size*TileFusionReactor.requiredHeHe; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeHe; this.HOut += size*TileFusionReactor.requiredHeHe*2;
			    }
		    	if (this.HeLevel < size*TileFusionReactor.requiredHeHe) {this.HeLevel = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredHeHe) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.BLevel2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredHeB && this.BLevel2 >= size*TileFusionReactor.requiredHeB) {
		    		this.heatVar = TileFusionReactor.heatHeB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeB/100), false); this.HeLevel -= size*TileFusionReactor.requiredHeB; this.BLevel2 -= size*TileFusionReactor.requiredHeB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeB*3; this.DOut += size*TileFusionReactor.requiredHeB;
			    }
		    	if (this.HeLevel < size*TileFusionReactor.requiredHeB) {this.HeLevel = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredHeB) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.HeLevel2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredHeB && this.HeLevel2 >= size*TileFusionReactor.requiredHeB) {
		    		this.heatVar = TileFusionReactor.heatHeB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeB/100), false); this.BLevel -= size*TileFusionReactor.requiredHeB; this.HeLevel2 -= size*TileFusionReactor.requiredHeB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeB*3; this.DOut += size*TileFusionReactor.requiredHeB;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredHeB) {this.BLevel = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredHeB) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.Li6Level2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredHeLi6 && this.Li6Level2 >= size*TileFusionReactor.requiredHeLi6) {
		    		this.heatVar = TileFusionReactor.heatHeLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeLi6/100), false); this.HeLevel -= size*TileFusionReactor.requiredHeLi6; this.Li6Level2 -= size*TileFusionReactor.requiredHeLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeLi6*2; this.HOut += size*TileFusionReactor.requiredHeLi6;
			    }
		    	if (this.HeLevel < size*TileFusionReactor.requiredHeLi6) {this.HeLevel = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredHeLi6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.HeLevel2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredHeLi6 && this.HeLevel2 >= size*TileFusionReactor.requiredHeLi6) {
		    		this.heatVar = TileFusionReactor.heatHeLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeLi6/100), false); this.Li6Level -= size*TileFusionReactor.requiredHeLi6; this.HeLevel2 -= size*TileFusionReactor.requiredHeLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeLi6*2; this.HOut += size*TileFusionReactor.requiredHeLi6;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredHeLi6) {this.Li6Level = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredHeLi6) {this.HeLevel2 = 0;}
	    	}
	    	
	    	else if (this.HeLevel > 0 && this.Li7Level2 > 0) {
		    	if (this.HeLevel >= size*TileFusionReactor.requiredHeLi7 && this.Li7Level2 >= size*TileFusionReactor.requiredHeLi7) {
		    		this.heatVar = TileFusionReactor.heatHeLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeLi7/100), false); this.HeLevel -= size*TileFusionReactor.requiredHeLi7; this.Li7Level2 -= size*TileFusionReactor.requiredHeLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeLi7*2; this.DOut += size*TileFusionReactor.requiredHeLi7;
			    }
		    	if (this.HeLevel < size*TileFusionReactor.requiredHeLi7) {this.HeLevel = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredHeLi7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.HeLevel2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredHeLi7 && this.HeLevel2 >= size*TileFusionReactor.requiredHeLi7) {
		    		this.heatVar = TileFusionReactor.heatHeLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerHeLi7/100), false); this.Li7Level -= size*TileFusionReactor.requiredHeLi7; this.HeLevel2 -= size*TileFusionReactor.requiredHeLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredHeLi7*2; this.DOut += size*TileFusionReactor.requiredHeLi7;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredHeLi7) {this.Li7Level = 0;}
		    	if (this.HeLevel2 < size*TileFusionReactor.requiredHeLi7) {this.HeLevel2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.BLevel > 0 && this.BLevel2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredBB && this.BLevel2 >= size*TileFusionReactor.requiredBB) {
		    		this.heatVar = TileFusionReactor.heatBB; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerBB/100), false); this.BLevel -= size*TileFusionReactor.requiredBB; this.BLevel2 -= size*TileFusionReactor.requiredBB; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredBB*5; this.nOut += size*TileFusionReactor.requiredBB/4;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredBB) {this.BLevel = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredBB) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.Li6Level2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredBLi6 && this.Li6Level2 >= size*TileFusionReactor.requiredBLi6) {
		    		this.heatVar = TileFusionReactor.heatBLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerBLi6/100), false); this.BLevel -= size*TileFusionReactor.requiredBLi6; this.Li6Level2 -= size*TileFusionReactor.requiredBLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredBLi6*4; this.nOut += size*TileFusionReactor.requiredBLi6/8;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredBLi6) {this.BLevel = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredBLi6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.BLevel2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredBLi6 && this.BLevel2 >= size*TileFusionReactor.requiredBLi6) {
		    		this.heatVar = TileFusionReactor.heatBLi6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerBLi6/100), false); this.Li6Level -= size*TileFusionReactor.requiredBLi6; this.BLevel2 -= size*TileFusionReactor.requiredBLi6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredBLi6*4; this.nOut += size*TileFusionReactor.requiredBLi6/8;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredBLi6) {this.Li6Level = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredBLi6) {this.BLevel2 = 0;}
	    	}
	    	
	    	else if (this.BLevel > 0 && this.Li7Level2 > 0) {
		    	if (this.BLevel >= size*TileFusionReactor.requiredBLi7 && this.Li7Level2 >= size*TileFusionReactor.requiredBLi7) {
		    		this.heatVar = TileFusionReactor.heatBLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerBLi7/100), false); this.BLevel -= size*TileFusionReactor.requiredBLi7; this.Li7Level2 -= size*TileFusionReactor.requiredBLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredBLi7*4; this.nOut += size*TileFusionReactor.requiredBLi7/4;
			    }
		    	if (this.BLevel < size*TileFusionReactor.requiredBLi7) {this.BLevel = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredBLi7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.BLevel2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredBLi7 && this.BLevel2 >= size*TileFusionReactor.requiredBLi7) {
		    		this.heatVar = TileFusionReactor.heatBLi7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerBLi7/100), false); this.Li7Level -= size*TileFusionReactor.requiredBLi7; this.BLevel2 -= size*TileFusionReactor.requiredBLi7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredBLi7*4; this.nOut += size*TileFusionReactor.requiredBLi7/4;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredBLi7) {this.Li7Level = 0;}
		    	if (this.BLevel2 < size*TileFusionReactor.requiredBLi7) {this.BLevel2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.Li6Level > 0 && this.Li6Level2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredLi6Li6 && this.Li6Level2 >= size*TileFusionReactor.requiredLi6Li6) {
		    		this.heatVar = TileFusionReactor.heatLi6Li6; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerLi6Li6/100), false); this.Li6Level -= size*TileFusionReactor.requiredLi6Li6; this.Li6Level2 -= size*TileFusionReactor.requiredLi6Li6; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredLi6Li6*3;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredLi6Li6) {this.Li6Level = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredLi6Li6) {this.Li6Level2 = 0;}
	    	}
	    	
	    	else if (this.Li6Level > 0 && this.Li7Level2 > 0) {
		    	if (this.Li6Level >= size*TileFusionReactor.requiredLi6Li7 && this.Li7Level2 >= size*TileFusionReactor.requiredLi6Li7) {
		    		this.heatVar = TileFusionReactor.heatLi6Li7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerLi6Li7/100), false); this.Li6Level -= size*TileFusionReactor.requiredLi6Li7; this.Li7Level2 -= size*TileFusionReactor.requiredLi6Li7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredLi6Li7*3; this.nOut += size*TileFusionReactor.requiredLi6Li7/8;
			    }
		    	if (this.Li6Level < size*TileFusionReactor.requiredLi6Li7) {this.Li6Level = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredLi6Li7) {this.Li7Level2 = 0;}
	    	}
	    	
	    	else if (this.Li7Level > 0 && this.Li6Level2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredLi6Li7 && this.Li6Level2 >= size*TileFusionReactor.requiredLi6Li7) {
		    		this.heatVar = TileFusionReactor.heatLi6Li7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerLi6Li7/100), false); this.Li7Level -= size*TileFusionReactor.requiredLi6Li7; this.Li6Level2 -= size*TileFusionReactor.requiredLi6Li7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredLi6Li7*3; this.nOut += size*TileFusionReactor.requiredLi6Li7/8;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredLi6Li7) {this.Li7Level = 0;}
		    	if (this.Li6Level2 < size*TileFusionReactor.requiredLi6Li7) {this.Li6Level2 = 0;}
	    	}
	    	
		    	//
		    	
	    	else if (this.Li7Level > 0 && this.Li7Level2 > 0) {
		    	if (this.Li7Level >= size*TileFusionReactor.requiredLi7Li7 && this.Li7Level2 >= size*TileFusionReactor.requiredLi7Li7) {
		    		this.heatVar = TileFusionReactor.heatLi7Li7; this.storage.receiveEnergy((int) (efficiency*pMult*size*TileFusionReactor.powerLi7Li7/100), false); this.Li7Level -= size*TileFusionReactor.requiredLi7Li7; this.Li7Level2 -= size*TileFusionReactor.requiredLi7Li7; heat += (100-(0.75*efficiency))/5000; flag = true;
		    		this.HE4Out += size*TileFusionReactor.requiredLi7Li7*3; this.nOut += size*TileFusionReactor.requiredLi7Li7/4;
			    }
		    	if (this.Li7Level < size*TileFusionReactor.requiredLi7Li7) {this.Li7Level = 0;}
		    	if (this.Li7Level2 < size*TileFusionReactor.requiredLi7Li7) {this.Li7Level2 = 0;}
	    	}
	    	
		    	//
	    	
	    	else {
	    		flag = false;
	    		if (heat >= 0.5 && heat >= (0.0002*heat*Math.log(heat+Math.E)) /*&& storage.getEnergyStored() >= 20000*/) {
	    			heat = heat-(0.0002*heat*Math.log(heat+Math.E));
	    		}
	    	}
	    	E = storage.getEnergyStored();
	    	if (E != lastE) BlockFusionReactor.updateBlockState(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	    	
	    	} else {
	    		if (heat >= 0.5 && heat >= (0.0002*heat*Math.log(heat+Math.E)) /*&& storage.getEnergyStored() < 20000*/) {
	    			heat = heat-(0.0002*heat*Math.log(heat+Math.E));
	    		}
	    	}
	    	
	    	newE = this.storage.getEnergyStored();
          	EShown = newE-prevE;
          	prevE = newE;
          	
          	if (HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level == 0 || HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 == 0) {EShown = 0;}
          	
          	if (HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level <= 0) {HLevel=0; DLevel=0; TLevel=0; HeLevel=0; BLevel=0; Li6Level=0; Li7Level=0;}
          	if (HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 <= 0) {HLevel2=0; DLevel2=0; TLevel2=0; HeLevel2=0; BLevel2=0; Li6Level2=0; Li7Level2=0;}
	    }

		public void addEnergy() {
				lastE = storage.getEnergyStored();
				if (heat >= 8 && HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level > 0 && HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 > 0) {
					for (ForgeDirection side : ForgeDirection.VALID_DIRECTIONS) {
						for (int x = -1; x < 2; ++x) {
							for (int y = (0 - 2*below); y < (2 + 2*(size-1)); ++y) {
								for (int z = -1; z < 2; ++z) {
									
									TileEntity tile = this.worldObj.getTileEntity(xCoord + side.offsetX + x, yCoord + side.offsetY + y, zCoord + side.offsetZ + z);
					
									if (!(tile instanceof TileGenerator) && !(tile instanceof TileReactionGenerator) && !(tile instanceof TileContinuousBase) && !(tile instanceof TileRTG) && !(tile instanceof TileWRTG) && !(tile instanceof TileFusionReactor) && !(tile instanceof TileFusionReactorBlock) && !(tile instanceof TileFissionReactor)) {
										if ((tile instanceof IEnergyHandler)) {
											storage.extractEnergy(((IEnergyHandler)tile).receiveEnergy(side.getOpposite(), storage.extractEnergy(storage.getMaxEnergyStored(), true), false), false);
										}
									}
								}
							}
						}
					}
				}
				E = storage.getEnergyStored();
				if (E != lastE) {
					BlockFusionReactor.updateBlockState(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				}
		}

	    private void fuel1() {
	    	if (getMain() != null) {
	    	if (isMain()) {
	        ItemStack stack = this.getStackInSlot(1);
	        if (stack != null && isHFuel(stack) && this.HLevel() + HFuelValue(stack) <= TileFusionReactor.Max && this.DLevel() <= 0 && this.TLevel() <= 0 && this.HeLevel() <= 0 && this.BLevel() <= 0 && this.Li6Level() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addH(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isDFuel(stack) && this.DLevel() + DFuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.TLevel() <= 0 && this.HeLevel() <= 0 && this.BLevel() <= 0 && this.Li6Level() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addD(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isTFuel(stack) && this.TLevel() + TFuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.DLevel() <= 0 && this.HeLevel() <= 0 && this.BLevel() <= 0 && this.Li6Level() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addT(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isHeFuel(stack) && this.HeLevel() + HeFuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.DLevel() <= 0 && this.TLevel() <= 0 && this.BLevel() <= 0 && this.Li6Level() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addHe(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isBFuel(stack) && this.BLevel() + BFuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.DLevel() <= 0 && this.TLevel() <= 0 && this.HeLevel() <= 0 && this.Li6Level() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addB(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isLi6Fuel(stack) && this.Li6Level() + Li6FuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.DLevel() <= 0 && this.TLevel() <= 0 && this.HeLevel() <= 0 && this.BLevel() <= 0 && this.Li7Level() <= 0)
	        {
	            this.addLi6(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	        else if (stack != null && isLi7Fuel(stack) && this.Li7Level() + Li7FuelValue(stack) <= TileFusionReactor.Max && this.HLevel() <= 0 && this.DLevel() <= 0 && this.TLevel() <= 0 && this.HeLevel() <= 0 && this.BLevel() <= 0 && this.Li6Level() <= 0)
	        {
	            this.addLi7(fuelValue(stack)); --this.slots[1].stackSize;
	            if (this.slots[1].stackSize <= 0) {this.slots[1] = null;}
	        }
	    	} else {
	    		getMain().fuel1();
	    	}
	    	} else {
	    		
	    	}
	    }
	    
	    private void fuel2() {
	    	if (getMain() != null) {
	    	if (isMain()) {
	        ItemStack stack = this.getStackInSlot(0);
	        if (stack != null && isHFuel(stack) && this.HLevel2() + HFuelValue(stack) <= TileFusionReactor.Max && this.DLevel2() <= 0 && this.TLevel2() <= 0 && this.HeLevel2() <= 0 && this.BLevel2() <= 0 && this.Li6Level2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addH2(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isDFuel(stack) && this.DLevel2() + DFuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.TLevel2() <= 0 && this.HeLevel2() <= 0 && this.BLevel2() <= 0 && this.Li6Level2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addD2(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isTFuel(stack) && this.TLevel2() + TFuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.DLevel2() <= 0 && this.HeLevel2() <= 0 && this.BLevel2() <= 0 && this.Li6Level2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addT2(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isHeFuel(stack) && this.HeLevel2() + HeFuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.DLevel2() <= 0 && this.TLevel2() <= 0 && this.BLevel2() <= 0 && this.Li6Level2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addHe2(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isBFuel(stack) && this.BLevel2() + BFuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.DLevel2() <= 0 && this.TLevel2() <= 0 && this.HeLevel2() <= 0 && this.Li6Level2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addB2(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isLi6Fuel(stack) && this.Li6Level2() + Li6FuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.DLevel2() <= 0 && this.TLevel2() <= 0 && this.HeLevel2() <= 0 && this.BLevel2() <= 0 && this.Li7Level2() <= 0)
	        {
	            this.addLi62(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	        else if (stack != null && isLi7Fuel(stack) && this.Li7Level2() + Li7FuelValue(stack) <= TileFusionReactor.Max && this.HLevel2() <= 0 && this.DLevel2() <= 0 && this.TLevel2() <= 0 && this.HeLevel2() <= 0 && this.BLevel2() <= 0 && this.Li6Level2() <= 0)
	        {
	            this.addLi72(fuelValue(stack)); --this.slots[0].stackSize;
	            if (this.slots[0].stackSize <= 0) {this.slots[0] = null;}
	        }
	    	} else {
	    		getMain().fuel2();
	    	}
	    	} else {
	    		
	    	}
	    }
	    
	    public static int fuelValue(ItemStack stack)
	    {
	    	if (stack == null) {return 0;}
	    	else {
	    		Item i = stack.getItem();
	    			if(i == new ItemStack (NCItems.fuel, 1, 36).getItem() && i.getDamage(stack) == 36)
	    			{
	    				return 336000;
	    			}
	    			else if(i == new ItemStack (NCItems.fuel, 1, 37).getItem() && i.getDamage(stack) == 37)
	    			{
	    				return 336000;
	    			}
	    			else if(i == new ItemStack (NCItems.fuel, 1, 38).getItem() && i.getDamage(stack) == 38)
	    			{
	    				return 336000;
	    			}
	    			else if(i == new ItemStack (NCItems.fuel, 1, 39).getItem() && i.getDamage(stack) == 39)
	    			{
	    				return 336000;
	    			}
	    			else if(i == new ItemStack (NCItems.fuel, 1, 44).getItem() && i.getDamage(stack) == 44)
	    			{
	    				return 336000;
	    			}
	    			else if(i == new ItemStack (NCItems.fuel, 1, 41).getItem() && i.getDamage(stack) == 41)
	    			{
	    				return 336000;
	    			}	
	    			else if(i == new ItemStack (NCItems.fuel, 1, 42).getItem() && i.getDamage(stack) == 42)
	    			{
	    				return 336000;
	    			}
	        }
	        return 0;
	    }

	    public static boolean isAnyFuel(ItemStack stack) {
	        return fuelValue(stack) > 0;
	    }
	    
	    public static boolean isCapsule(ItemStack stack) {
	    		if (stack.getItem() == new ItemStack(NCItems.fuel, 1, 48).getItem() && stack.getItem().getDamage(stack) == 48) {
	    			return true;
	    		}
	    	return false;
	    }

	    public static int HFuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 36).getItem() && i.getDamage(stack) == 36) {return 336000;}}
	        return 0;
	    }
	    
	    public static int DFuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 37).getItem() && i.getDamage(stack) == 37) {return 336000;}}
	        return 0;
	    }
	    
	    public static int TFuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 38).getItem() && i.getDamage(stack) == 38) {return 336000;}}
	        return 0;
	    }
	    
	    public static int HeFuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 39).getItem() && i.getDamage(stack) == 39) {return 336000;}}
	        return 0;
	    }
	    
	    public static int BFuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 44).getItem() && i.getDamage(stack) == 44) {return 336000;}}
	        return 0;
	    }
	    
	    public static int Li6FuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 41).getItem() && i.getDamage(stack) == 41) {return 336000;}}
	        return 0;
	    }
	    
	    public static int Li7FuelValue(ItemStack stack) {
	    	if (stack == null) {return 0;} else { Item i = stack.getItem();
	    		if(i == new ItemStack (NCItems.fuel, 1, 42).getItem() && i.getDamage(stack) == 42) {return 336000;}}
	        return 0;
	    }
	    
	    public void readFromNBT(NBTTagCompound nbt) {
	        super.readFromNBT(nbt);
	        if (nbt.hasKey("storage")) {
	            this.storage.readFromNBT(nbt.getCompoundTag("storage"));
	        }
	        this.EShown = nbt.getInteger("EShown");
	        this.HLevel = nbt.getInteger("HLevel");
	        this.DLevel = nbt.getInteger("DLevel");
	        this.TLevel = nbt.getInteger("TLevel");
	        this.HeLevel = nbt.getInteger("HeLevel");
	        this.BLevel = nbt.getInteger("BLevel");
	        this.Li6Level = nbt.getInteger("Li6Level");
	        this.Li7Level = nbt.getInteger("Li7Level");
	        this.HLevel2 = nbt.getInteger("HLevel2");
	        this.DLevel2 = nbt.getInteger("DLevel2");
	        this.TLevel2 = nbt.getInteger("TLevel2");
	        this.HeLevel2 = nbt.getInteger("HeLevel2");
	        this.BLevel2 = nbt.getInteger("BLevel2");
	        this.Li6Level2 = nbt.getInteger("Li6Level2");
	        this.Li7Level2 = nbt.getInteger("Li7Level2");
	        
	        this.HOut = nbt.getDouble("HOut");
	        this.DOut = nbt.getDouble("DOut");
	        this.TOut = nbt.getDouble("TOut");
	        this.HE3Out = nbt.getDouble("HE3Out");
	        this.HE4Out = nbt.getDouble("HE4Out");
	        this.nOut = nbt.getDouble("nOut");
	        
	        this.size = nbt.getInteger("size");
	        this.isMain = nbt.getBoolean("isMain");
	        this.below = nbt.getInteger("below");
	        
	        this.efficiency = nbt.getDouble("efficiency");
	        this.heat = nbt.getDouble("heat");
	        this.heatVar = nbt.getDouble("heatVar");
	        
	        this.lastE = nbt.getInteger("lE");
	        this.E = nbt.getInteger("E");
	    }

	    public void writeToNBT(NBTTagCompound nbt) {
	        super.writeToNBT(nbt);
	        
	        NBTTagCompound energyTag = new NBTTagCompound();
	        this.storage.writeToNBT(energyTag);
	        nbt.setTag("storage", energyTag);
	        
	        nbt.setInteger("EShown", this.EShown);
	        nbt.setInteger("HLevel", this.HLevel);
	        nbt.setInteger("DLevel", this.DLevel);
	        nbt.setInteger("TLevel", this.TLevel);
	        nbt.setInteger("HeLevel", this.HeLevel);
	        nbt.setInteger("BLevel", this.BLevel);
	        nbt.setInteger("Li6Level", this.Li6Level);
	        nbt.setInteger("Li7Level", this.Li7Level);
	        nbt.setInteger("HLevel2", this.HLevel2);
	        nbt.setInteger("DLevel2", this.DLevel2);
	        nbt.setInteger("TLevel2", this.TLevel2);
	        nbt.setInteger("HeLevel2", this.HeLevel2);
	        nbt.setInteger("BLevel2", this.BLevel2);
	        nbt.setInteger("Li6Level2", this.Li6Level2);
	        nbt.setInteger("Li7Level2", this.Li7Level2);
	        
	        nbt.setDouble("HOut", this.HOut);
	        nbt.setDouble("DOut", this.DOut);
	        nbt.setDouble("TOut", this.TOut);
	        nbt.setDouble("HE3Out", this.HE3Out);
	        nbt.setDouble("HE4Out", this.HE4Out);
	        nbt.setDouble("nOut", this.nOut);
	        
	        nbt.setInteger("size", this.size);
	        nbt.setBoolean("isMain", this.isMain);
	        nbt.setInteger("below", this.below);
	        
	        nbt.setDouble("efficiency", this.efficiency);
	        nbt.setDouble("heat", this.heat);
	        nbt.setDouble("heatVar", this.heatVar);
	        
	        nbt.setInteger("lE", this.lastE);
	        nbt.setInteger("E", this.E);
	    }
		
	    public void addH(int add) {if (isMain()) {this.HLevel += add;} else {getMain().addH(add);}}
	    public void addD(int add) {if (isMain()) {this.DLevel += add;} else {getMain().addD(add);}}
	    public void addT(int add) {if (isMain()) {this.TLevel += add;} else {getMain().addT(add);}}
	    public void addHe(int add) {if (isMain()) {this.HeLevel += add;} else {getMain().addHe(add);}}
	    public void addB(int add) {if (isMain()) {this.BLevel += add;} else {getMain().addB(add);}}
	    public void addLi6(int add) {if (isMain()) {this.Li6Level += add;} else {getMain().addLi6(add);}}
	    public void addLi7(int add) {if (isMain()) {this.Li7Level += add;} else {getMain().addLi7(add);}}
	    
	    public void addH2(int add) {if (isMain()) {this.HLevel2 += add;} else {getMain().addH2(add);}}
	    public void addD2(int add) {if (isMain()) {this.DLevel2 += add;} else {getMain().addD2(add);}}
	    public void addT2(int add) {if (isMain()) {this.TLevel2 += add;} else {getMain().addT2(add);}}
	    public void addHe2(int add) {if (isMain()) {this.HeLevel2 += add;} else {getMain().addHe2(add);}}
	    public void addB2(int add) {if (isMain()) {this.BLevel2 += add;} else {getMain().addB2(add);}}
	    public void addLi62(int add) {if (isMain()) {this.Li6Level2 += add;} else {getMain().addLi62(add);}}
	    public void addLi72(int add) {if (isMain()) {this.Li7Level2 += add;} else {getMain().addLi72(add);}}
	    
	    public void removeH(int remove) {if (isMain()) {this.HLevel -= remove;} else {getMain().removeH(remove);}}
	    public void removeD(int remove) {if (isMain()) {this.DLevel -= remove;} else {getMain().removeD(remove);}}
	    public void removeT(int remove) {if (isMain()) {this.TLevel -= remove;} else {getMain().removeT(remove);}}
	    public void removeHe(int remove) {if (isMain()) {this.HeLevel -= remove;} else {getMain().removeHe(remove);}}
	    public void removeB(int remove) {if (isMain()) {this.BLevel -= remove;} else {getMain().removeB(remove);}}
	    public void removeLi6(int remove) {if (isMain()) {this.Li6Level -= remove;} else {getMain().removeLi6(remove);}}
	    public void removeLi7(int remove) {if (isMain()) {this.Li7Level -= remove;} else {getMain().removeLi7(remove);}}
	    
	    public void removeH2(int remove) {if (isMain()) {this.HLevel2 -= remove;} else {getMain().removeH2(remove);}}
	    public void removeD2(int remove) {if (isMain()) {this.DLevel2 -= remove;} else {getMain().removeD2(remove);}}
	    public void removeT2(int remove) {if (isMain()) {this.TLevel2 -= remove;} else {getMain().removeT2(remove);}}
	    public void removeHe2(int remove) {if (isMain()) {this.HeLevel2 -= remove;} else {getMain().removeHe2(remove);}}
	    public void removeB2(int remove) {if (isMain()) {this.BLevel2 -= remove;} else {getMain().removeB2(remove);}}
	    public void removeLi62(int remove) {if (isMain()) {this.Li6Level2 -= remove;} else {getMain().removeLi62(remove);}}
	    public void removeLi72(int remove) {if (isMain()) {this.Li7Level2 -= remove;} else {getMain().removeLi72(remove);}}
	    
	    public int HLevel() {if (isMain()) {return HLevel;} else {getMain().HLevel();} return HLevel;}
	    public int DLevel() {if (isMain()) {return DLevel;} else {getMain().DLevel();} return DLevel;}
	    public int TLevel() {if (isMain()) {return TLevel;} else {getMain().TLevel();} return TLevel;}
	    public int HeLevel() {if (isMain()) {return HeLevel;} else {getMain().HeLevel();} return HeLevel;}
	    public int BLevel() {if (isMain()) {return BLevel;} else {getMain().BLevel();} return BLevel;}
	    public int Li6Level() {if (isMain()) {return Li6Level;} else {getMain().Li6Level();} return Li6Level;}
	    public int Li7Level() {if (isMain()) {return Li7Level;} else {getMain().Li7Level();} return Li7Level;}
	    
	    public int HLevel2() {if (isMain()) {return HLevel2;} else {getMain().HLevel2();} return HLevel2;}
	    public int DLevel2() {if (isMain()) {return DLevel2;} else {getMain().DLevel2();} return DLevel2;}
	    public int TLevel2() {if (isMain()) {return TLevel2;} else {getMain().TLevel2();} return TLevel2;}
	    public int HeLevel2() {if (isMain()) {return HeLevel2;} else {getMain().HeLevel2();} return HeLevel2;}
	    public int BLevel2() {if (isMain()) {return BLevel2;} else {getMain().BLevel2();} return BLevel2;}
	    public int Li6Level2() {if (isMain()) {return Li6Level2;} else {getMain().Li6Level2();} return Li6Level2;}
	    public int Li7Level2() {if (isMain()) {return Li7Level2;} else {getMain().Li7Level2();} return Li7Level2;}

	    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate)
	    {
	    	if (heat < 8 || (HLevel + DLevel + TLevel + HeLevel + BLevel + Li6Level + Li7Level <= 0 || HLevel2 + DLevel2 + TLevel2 + HeLevel2 + BLevel2 + Li6Level2 + Li7Level2 <= 0)) {
	    		return isMain() ? this.storage.receiveEnergy(maxReceive, simulate) : getMain().storage.receiveEnergy(maxReceive, simulate);
	    	}
	    	else return 0;
	    }

	    public static boolean isHFuel(ItemStack stack) {return HFuelValue(stack) > 0;}
	    public static boolean isDFuel(ItemStack stack) {return DFuelValue(stack) > 0;}
	    public static boolean isTFuel(ItemStack stack) {return TFuelValue(stack) > 0;}
	    public static boolean isHeFuel(ItemStack stack) {return HeFuelValue(stack) > 0;}
	    public static boolean isBFuel(ItemStack stack) {return BFuelValue(stack) > 0;}
	    public static boolean isLi6Fuel(ItemStack stack) {return Li6FuelValue(stack) > 0;}
	    public static boolean isLi7Fuel(ItemStack stack) {return Li7FuelValue(stack) > 0;}
	    
	    public boolean isInputtableFuel2(ItemStack stack) {
	        if (HLevel > 0) return isHFuel(stack);
	        else if (DLevel > 0) return isDFuel(stack);
	        else if (TLevel > 0) return isTFuel(stack);
	        else if (HeLevel > 0) return isHeFuel(stack);
	        else if (BLevel > 0) return isBFuel(stack);
	        else if (Li6Level > 0) return isLi6Fuel(stack);
	        else if (Li7Level > 0) return isLi7Fuel(stack);
	        else return isAnyFuel(stack);
	    }
	    
	    public boolean isInputtableFuel1(ItemStack stack) {
	       	if (HLevel2 > 0) return isHFuel(stack);
	       	else if (DLevel2 > 0) return isDFuel(stack);
	       	else if (TLevel2 > 0) return isTFuel(stack);
	       	else if (HeLevel2 > 0) return isHeFuel(stack);
	       	else if (BLevel2 > 0) return isBFuel(stack);
	       	else if (Li6Level2 > 0) return isLi6Fuel(stack);
	       	else if (Li7Level2 > 0) return isLi7Fuel(stack);
	       	else return isAnyFuel(stack);
	    }

	    public boolean isItemValidForSlot(int slot, ItemStack stack) {
	        if (slot == 1) {
	        	if (HLevel > 0) return isHFuel(stack);
	        	else if (DLevel > 0) return isDFuel(stack);
	        	else if (TLevel > 0) return isTFuel(stack);
	        	else if (HeLevel > 0) return isHeFuel(stack);
	        	else if (BLevel > 0) return isBFuel(stack);
	        	else if (Li6Level > 0) return isLi6Fuel(stack);
	        	else if (Li7Level > 0) return isLi7Fuel(stack);
	        	else return isAnyFuel(stack);
	        }
	        else if (slot == 0) {
	        	if (HLevel2 > 0) return isHFuel(stack);
	        	else if (DLevel2 > 0) return isDFuel(stack);
	        	else if (TLevel2 > 0) return isTFuel(stack);
	        	else if (HeLevel2 > 0) return isHeFuel(stack);
	        	else if (BLevel2 > 0) return isBFuel(stack);
	        	else if (Li6Level2 > 0) return isLi6Fuel(stack);
	        	else if (Li7Level2 > 0) return isLi7Fuel(stack);
	        	else return isAnyFuel(stack);
	        }
	        else if (slot == 2) {
	        	return isCapsule(stack);
	        }
	        return false;
	    }

	    /**
	     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
	     * block.
	     */
	    public int[] getAccessibleSlotsFromSide(int side) {
	        return isMain() ? input : getMain().input;
	    }

	    /**
	     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
	     * side
	     */
	    public boolean canInsertItem(int slot, ItemStack stack, int par) {
	    	return isMain() ? this.isItemValidForSlot(slot, stack) : getMain().canInsertItem(slot, stack, par);
	    }

	    /**
	     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
	     * side
	     */
	    public boolean canExtractItem(int slot, ItemStack stack, int side) {
	        return isMain() ? (slot > 2) : getMain().canExtractItem(slot, stack, side);
	    }

	    public ItemStack getStackInSlot(int var1) {
	    	return isMain() ? slots[var1] : getMain().slots[var1];
		}
	    
	    public int getSizeInventory()
	    {
	        return /*isMain() ?*/ this.slots.length /*: getMain().getSizeInventory()*/;
	    }
	    
	    public void setInventorySlotContents(int i, ItemStack itemstack)
	    {
	    	if (getMain() != null) {
	    		if (isMain()) {
	    			this.slots[i] = itemstack;

	    			if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
	    				itemstack.stackSize = this.getInventoryStackLimit();
	    			}
	    			markDirty();
	    		} else {
	    			getMain().setInventorySlotContents(i, itemstack);
	    		}
	    	} else {
	    		
	    	}
	    }
}