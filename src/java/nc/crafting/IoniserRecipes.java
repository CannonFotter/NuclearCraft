package nc.crafting;

import nc.item.NCItems;
import net.minecraft.item.ItemStack;

public class IoniserRecipes extends NCRecipeHelper {

	private static final IoniserRecipes recipes = new IoniserRecipes();

	public IoniserRecipes(){
		super(2, 2);
	}
	public static final NCRecipeHelper instance() {
		return recipes;
	}

	public void addRecipes() {
		fuelFuel(1, 48, 8, 36, 1, 49, 8, 45);
	}
	
	public void fuelFuel(int noIn, int metaIn, int noIn2, int metaIn2, int noOut, int metaOut, int noOut2, int metaOut2) {
		addRecipe(new ItemStack(NCItems.fuel, noIn, metaIn), new ItemStack(NCItems.fuel, noIn2, metaIn2), new ItemStack(NCItems.fuel, noOut, metaOut), new ItemStack(NCItems.fuel, noOut2, metaOut2));
	}
}