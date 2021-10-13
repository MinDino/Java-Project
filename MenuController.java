package restaurant.controller;

import restaurant.model.Item;
import restaurant.model.Menu;

public class MenuController extends AbstractController<Menu> {

	private Menu menu;

	private static final String MENU_DIRECTORY = "C:\\Users\\mindi\\Desktop\\sce.ce2002.mm.project\\JavaProject\\src\\restaurant\\io\\menu.io";

	public MenuController() {
		menu = loadReadIOFile(MENU_DIRECTORY);
		
		if (menu == null) {
			menu = new Menu();
		}
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Item getItemByName(String itemName) {
		for (Item item : menu.getFoodItemList()) {
			if (itemName.equalsIgnoreCase(item.getName())) {
				return item;
			}
		}
		return null;
	}
	
	public void createMenuItem(Item item) {
		menu.getFoodItemList().add(item);
	}

	public void updateItemNameByName(Item item, String newName) {
		item.setName(newName);
	}

	public void updateItemDescriptionByName(Item item, String newDescription) {
		item.setDescription(newDescription);
	}
	
	public void updateItemPriceByName(Item item, float newPrice) {
		item.setPrice(newPrice);
	}

	public void deleteItemByName(Item item) {
		menu.getFoodItemList().remove(item);
	}
	
	public void saveData() {
		writeSaveIOFile(MENU_DIRECTORY, menu);
	}
}
