package restaurant.controller;

import restaurant.model.Item;
import restaurant.model.SetPackage;

public class PromoController extends MenuController {

	public Item getPromoByName(String itemName) {
		for (Item item : getMenu().getPromotionList()) {
			if (itemName.toString().equalsIgnoreCase(item.getName())) {
				return item;
			}
		}
		return null;
	}

	public void createAddPromoItem(SetPackage promotion, Item promoItem) {
		promotion.getPromotionalItemList().add(promoItem);
	}
	public void createPromoItem(Item promotion) {
		getMenu().getPromotionList().add(promotion);
	}
	
	public void updateAddPromoItem(SetPackage promotion,Item promoItem) {
		promotion.getPromotionalItemList().add(promoItem);
	}
	
	public void updateRemovePromoItem(SetPackage promotion,Item promoItem) {
		promotion.getPromotionalItemList().remove(promoItem);
	}
	
	public void deletePromoByName(Item item) {
		getMenu().getPromotionList().remove(item);
	}
	
	@Override
	public void updateItemNameByName(Item item, String newName) {
		item.setName(newName);
	}

	@Override
	public void updateItemDescriptionByName(Item item, String newDescription) {
		item.setDescription(newDescription);
	}
	
	@Override
	public void updateItemPriceByName(Item item, float newPrice) {
		item.setPrice(newPrice);
	}

}
