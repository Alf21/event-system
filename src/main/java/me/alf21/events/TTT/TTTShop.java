/**
 * @author Alf21 on 18.12.2015 in project event-system.
 * Copyright (c) 2015 Alf21. All rights reserved.
 */

package me.alf21.events.TTT;

import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventSystem;
import me.alf21.eventsystem.PlayerData;
import net.gtaun.shoebill.common.dialog.ListDialogItem;
import net.gtaun.shoebill.common.dialog.TabListDialog;
import net.gtaun.shoebill.common.dialog.TabListDialogItem;
import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Player;
import net.gtaun.wl.lang.LocalizedStringSet;

public class TTTShop {
    private static LocalizedStringSet localizedStringSet = EventSystem.getInstance().getLocalizedStringSet();
	public static void show(Player player) {
		PlayerData playerLifecycle = EventSystem.getInstance().getPlayerLifecycleHolder().getObject(player, PlayerData.class);
		EventData eventData = playerLifecycle.getCurrentEvent();
		if(eventData != null) {
			TabListDialog traitorShop = TabListDialog.create(player, EventSystem.getInstance().getEventManagerInstance())
					.caption("{FF8A05}" + localizedStringSet.get(player, "Event.Class.TTT.Shop.Shop") + " - " + playerLifecycle.getEventPoints() + localizedStringSet.get(player, "Event.Class.TTT.Shop.Money"))
					.buttonOk(localizedStringSet.get(player, "Dialog.Choose"))
					.buttonCancel(localizedStringSet.get(player, "Dialog.Back"))
					.header(0, localizedStringSet.get(player, "Event.Class.TTT.Shop.Object"))
					.header(1, localizedStringSet.get(player, "Event.Class.TTT.Shop.Price") + " (" + localizedStringSet.get(player, "Event.Class.TTT.Shop.Money") + ")")
					.build();
			
			if(!playerLifecycle.getTraitorShop().getOrDefault("GPS", false)) {
				traitorShop.addItem(TabListDialogItem.create()
			            .column(0, ListDialogItem.create().itemText("GPS").build())
			            .column(1, ListDialogItem.create().itemText("1 " + localizedStringSet.get(player, "Event.Class.TTT.Shop.Money")).build())
			            .onSelect((listDialogItem2, o2) -> {
	                		if(playerLifecycle.getEventPoints() >= 1) {
	                			playerLifecycle.getTraitorShop().put("GPS", true);
	                			playerLifecycle.setEventPoints(playerLifecycle.getEventPoints()-1);
	                		}
	                		else {
	                			player.sendMessage(Color.YELLOW, localizedStringSet.get(player, "Event.Class.TTT.Shop.MorePoints"));
	                		}
			            })
				.build());
			}
			traitorShop.show();
		}
	}
}
