package me.alf21.maps;

import java.util.ArrayList;

import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.data.Location;
import net.gtaun.shoebill.data.WeaponData;
import net.gtaun.shoebill.object.DynamicSampObject;
import me.alf21.eventsystem.EventData;
import me.alf21.eventsystem.EventMap;
import me.alf21.eventsystem.EventMapDescription;
import me.alf21.eventsystem.EventMapSize;

/**
 * @author Alf21
 */
@EventMapDescription(name="cs_dust2", description = "de_dust2 from CS", credits = "SpikY_", size = EventMapSize.XLARGE)
public class CS_Dust2 extends EventMap {
	public CS_Dust2() { }

	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventMap#create(int, int, float, float, me.alf21.eventsystem.EventData, net.gtaun.shoebill.data.WeaponData)
	 */
	@Override
	public DynamicSampObject[] create(int worldId, int interiorId, float streamDistance, float drawDistance, EventData eventData, WeaponData weaponData) {
		ArrayList<DynamicSampObject> tmpobjs = new ArrayList<DynamicSampObject>();
		DynamicSampObject tmpobj;
		tmpobj = DynamicSampObject.create(12814, 250.199f, 1792.4f, 40.77f, 337.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 250.199f, 1840.3f, 50.509f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.3f, 1826.0f, 41.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.199f, 1838.599f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 205.6f, 1808.8f, 46.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 266.899f, 1804.8f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 266.6f, 1825.199f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 266.399f, 1845.699f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 233.899f, 1856.699f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 253.899f, 1856.699f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.699f, 1740.199f, 45.81f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 200.5f, 1782.39f, 50.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.5f, 1758.5f, 46.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 192.8f, 1806.3f, 54.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.8f, 1740.4f, 55.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8558, 232.6f, 1814.199f, 49.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8558, 227.479f, 1814.099f, 49.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8558, 222.36f, 1814.099f, 49.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8558, 217.96f, 1814.099f, 49.38f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 209.199f, 1824.9f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.6f, 1758.599f, 55.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 195.3f, 1768.9f, 54.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 195.1f, 1786.699f, 54.7f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 209.199f, 1823.0f, 55.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 219.899f, 1733.3f, 43.75f, 345.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.199f, 1678.599f, 46.299f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 204.8f, 1734.3f, 46.009f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 205.899f, 1734.099f, 54.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 205.3f, 1720.0f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.199f, 1699.099f, 46.299f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.0f, 1804.9f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 254.3f, 1856.5f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 234.199f, 1856.5f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 266.399f, 1845.5f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 266.6f, 1825.199f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 267.0f, 1805.0f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.3f, 1843.099f, 55.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8558, 199.199f, 1811.5f, 52.0f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 201.5f, 1823.0f, 50.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 269.399f, 1705.599f, 46.099f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 269.399f, 1665.5f, 46.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 288.2f, 1685.5f, 46.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.399f, 1720.0f, 45.81f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 243.3f, 1650.0f, 31.799f, 336.989f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 273.7f, 1683.099f, 42.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 269.399f, 1665.5f, 37.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 212.3f, 1652.199f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 236.8f, 1626.3f, 44.7f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 238.8f, 1643.5f, 48.4f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 258.7f, 1643.599f, 48.4f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 269.6f, 1705.4f, 55.099f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 288.399f, 1685.199f, 55.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 269.6f, 1665.3f, 55.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 259.899f, 1644.699f, 57.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 218.399f, 1666.099f, 55.9f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.199f, 1646.4f, 46.299f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 212.3f, 1602.3f, 41.599f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.199f, 1678.9f, 55.299f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.199f, 1698.8f, 55.299f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 205.99f, 1718.9f, 54.799f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 182.3f, 1652.199f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 182.3f, 1602.3f, 41.599f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.899f, 1660.0f, 45.7f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 188.399f, 1646.699f, 55.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 189.3f, 1662.8f, 54.7f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 199.199f, 1752.199f, 47.009f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 195.289f, 1768.819f, 51.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 206.8f, 1651.099f, 53.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 220.0f, 1655.5f, 45.599f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobj.setObjectMaterial(1, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobj.setObjectMaterial(2, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobj.setObjectMaterial(3, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 220.0f, 1655.5f, 53.599f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 206.8f, 1651.099f, 45.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 247.899f, 1751.5f, 41.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 208.699f, 1757.8f, 41.549f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 165.0f, 1760.9f, 45.599f, 0.0f, 0.0f, 319.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 243.699f, 1702.0f, 41.529f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 243.699f, 1697.9f, 41.509f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 213.699f, 1702.0f, 41.569f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 185.699f, 1702.0f, 41.569f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 143.899f, 1788.599f, 41.599f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 134.699f, 1762.199f, 41.7f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 114.599f, 1762.5f, 41.7f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 239.699f, 1644.4f, 57.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 203.1f, 1665.5f, 55.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 218.399f, 1648.8f, 55.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 203.1f, 1648.199f, 55.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 225.5f, 1720.199f, 54.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 134.8f, 1762.099f, 50.7f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 93.599f, 1761.0f, 49.0f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 185.1f, 1788.5f, 54.4f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 185.1f, 1768.599f, 54.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 153.199f, 1759.41f, 50.7f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 173.199f, 1759.41f, 50.7f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11092, 138.399f, 1614.599f, 53.299f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(7, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 181.3f, 1739.8f, 42.299f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 181.399f, 1719.8f, 42.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 185.0f, 1733.5f, 47.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 237.1f, 1626.099f, 53.7f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 219.1f, 1606.099f, 46.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 219.199f, 1606.099f, 55.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 219.199f, 1585.9f, 46.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 219.1f, 1585.9f, 55.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 203.899f, 1598.5f, 45.599f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 203.6f, 1586.8f, 45.599f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 165.5f, 1597.099f, 26.6f, 20.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 122.199f, 1582.099f, 49.15f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 152.399f, 1620.199f, 41.599f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 204.199f, 1567.0f, 43.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 204.0f, 1567.0f, 52.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 184.8f, 1567.599f, 43.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 184.699f, 1566.9f, 52.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 168.699f, 1567.4f, 43.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 149.0f, 1556.4f, 47.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 148.899f, 1556.4f, 56.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 139.0f, 1556.599f, 47.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 96.599f, 1556.699f, 52.0f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 168.6f, 1566.8f, 52.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 170.6f, 1582.099f, 40.599f, 19.989f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 122.4f, 1596.989f, 34.299f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 153.1f, 1658.599f, 41.58f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.3f, 1721.099f, 46.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.399f, 1700.699f, 46.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.5f, 1680.4f, 46.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 79.0f, 1596.8f, 26.5f, 20.0f, 270.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.8f, 1556.699f, 56.5f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 82.8f, 1556.0f, 48.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 72.8f, 1556.9f, 45.599f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 58.599f, 1555.5f, 45.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 138.5f, 1666.699f, 46.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 138.6f, 1646.199f, 46.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 138.699f, 1627.099f, 46.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 138.8f, 1606.8f, 46.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 178.1f, 1699.699f, 42.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 178.1f, 1679.5f, 42.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 182.0f, 1684.9f, 47.099f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 181.899f, 1640.8f, 31.059f, 320.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 178.089f, 1671.5f, 42.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 167.0f, 1651.099f, 20.309f, 320.0f, 90.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 63.2f, 1587.199f, 41.599f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 153.0f, 1762.099f, 45.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11092, 212.1f, 1667.3f, 62.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(7, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11092, 137.5f, 1650.0f, 53.2f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(7, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11092, 136.699f, 1685.199f, 53.2f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(7, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11092, 135.1f, 1718.9f, 53.299f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(3, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(4, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(5, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(6, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(7, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 126.699f, 1737.3f, 46.799f, 90.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 126.4f, 1742.599f, 43.9f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 126.699f, 1745.599f, 43.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 122.5f, 1738.8f, 43.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 122.5f, 1737.3f, 46.799f, 90.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 118.5f, 1742.699f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 118.599f, 1749.099f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 118.5f, 1733.3f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 118.51f, 1738.599f, 48.9f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 126.4f, 1742.599f, 46.799f, 90.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 122.5f, 1737.3f, 43.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 126.699f, 1737.3f, 43.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 115.099f, 1751.9f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 107.4f, 1752.0f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 106.3f, 1735.8f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 95.9f, 1736.099f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 98.599f, 1735.8f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 83.199f, 1736.3f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 75.4f, 1736.3f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 99.599f, 1752.0f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 91.8f, 1752.0f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 86.3f, 1752.099f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 91.0f, 1736.3f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 157.899f, 1728.699f, 33.0f, 20.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 149.8f, 1767.099f, 41.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.5f, 1680.4f, 37.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.399f, 1700.699f, 37.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.3f, 1721.099f, 37.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 136.289f, 1741.089f, 37.2f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 181.399f, 1719.8f, 33.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 178.1f, 1699.699f, 33.299f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 181.3f, 1739.8f, 33.299f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 200.1f, 1758.0f, 41.549f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 65.3f, 1786.4f, 44.45f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 59.799f, 1736.3f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 55.9f, 1740.099f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 67.599f, 1736.3f, 46.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 55.9f, 1747.9f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3055, 55.799f, 1751.5f, 46.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(1, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(3, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(4, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(5, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 155.0f, 1707.699f, 35.11f, 345.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 89.3f, 1786.4f, 44.439f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 114.699f, 1762.4f, 50.7f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 47.599f, 1765.9f, 48.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 31.299f, 1784.8f, 48.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 31.2f, 1804.8f, 48.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 31.5f, 1825.4f, 49.099f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 49.9f, 1835.099f, 48.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 70.3f, 1826.4f, 48.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 96.599f, 1780.699f, 56.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 99.4f, 1793.5f, 56.4f, 0.0f, 0.0f, 120.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 96.599f, 1780.699f, 48.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16773, 99.4f, 1793.5f, 48.4f, 0.0f, 0.0f, 120.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 10101, "2notherbuildsfe", "sl_vicbrikwall01", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 31.899f, 1766.0f, 47.9f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 65.3f, 1800.4f, 44.45f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 35.9f, 1806.9f, 45.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 35.9f, 1836.9f, 45.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 73.699f, 1582.099f, 40.599f, 19.979f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 63.599f, 1724.199f, 45.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 83.699f, 1723.9f, 45.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 93.69f, 1723.4f, 45.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(12814, 117.599f, 1597.0f, 47.7f, 90.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 6882, "vgnland", "des_scrub1_dirt1a", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 63.4f, 1724.099f, 54.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 83.8f, 1724.0f, 54.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(10631, 94.099f, 1724.099f, 54.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobj.setObjectMaterial(0, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(1, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(2, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(6, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(7, 6882, "vgnland", "des_scrub1_dirt1b", new Color(0));
		tmpobj.setObjectMaterial(8, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(9, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobj.setObjectMaterial(10, 14736, "whorerooms", "AH_bathmos", new Color(0));
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 216.399f, 1792.9f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3796, 188.0f, 1773.4f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(2988, 240.5f, 1845.3f, 50.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 277.899f, 1755.4f, 46.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 235.3f, 1806.8f, 42.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16202, 192.1f, 1830.9f, 46.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16202, 338.299f, 1843.199f, 46.4f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 235.3f, 1806.8f, 43.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 235.3f, 1832.79f, 45.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 212.8f, 1657.4f, 50.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(2988, 248.899f, 1845.3f, 50.5f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 277.899f, 1755.4f, 40.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 261.0f, 1852.0f, 59.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 269.799f, 1828.599f, 59.599f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 269.5f, 1883.3f, 62.799f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 274.6f, 1789.099f, 57.0f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.3f, 1793.599f, 41.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 228.699f, 1798.8f, 52.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 218.399f, 1792.599f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 228.899f, 1799.599f, 50.9f, 0.0f, 0.0f, 340.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.6f, 1830.599f, 50.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 236.3f, 1797.599f, 43.299f, 14.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 276.1f, 1694.599f, 42.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1222, 233.5f, 1795.099f, 51.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 228.5f, 1797.199f, 50.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 194.0f, 1781.699f, 46.0f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 207.199f, 1812.0f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 214.5f, 1746.9f, 47.4f, 14.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 222.8f, 1851.199f, 59.599f, 0.0f, 0.0f, 70.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 214.899f, 1781.699f, 46.0f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 235.3f, 1806.8f, 45.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 235.199f, 1826.699f, 50.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 208.3f, 1811.5f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 206.5f, 1810.5f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 204.6f, 1811.8f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 211.0f, 1812.599f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 210.399f, 1811.0f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(1554, 212.399f, 1812.0f, 50.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 277.899f, 1755.4f, 52.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 258.7f, 1674.4f, 42.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 232.6f, 1799.699f, 50.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 276.1f, 1692.699f, 42.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 218.6f, 1707.9f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 218.5f, 1708.0f, 43.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.699f, 1707.9f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.6f, 1708.0f, 43.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 218.6f, 1705.8f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.699f, 1705.8f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 218.5f, 1705.9f, 43.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 220.6f, 1705.9f, 43.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 223.3f, 1707.699f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 258.7f, 1703.4f, 42.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(14877, 257.399f, 1688.9f, 40.819f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 243.199f, 1634.699f, 43.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 212.8f, 1636.699f, 50.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1673.3f, 50.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 169.72f, 1607.3f, 46.5f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1664.3f, 41.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1664.3f, 50.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1655.3f, 50.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1655.3f, 41.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 258.7f, 1688.4f, 42.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1655.3f, 32.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1664.3f, 32.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 250.699f, 1636.699f, 26.299f, 90.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 205.0f, 1753.599f, 47.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 205.0f, 1754.599f, 49.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 204.0f, 1756.699f, 46.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 204.699f, 1756.699f, 48.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(621, 256.399f, 1781.199f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(621, 257.0f, 1765.099f, 41.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 256.5f, 1775.599f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 257.299f, 1772.599f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 257.299f, 1769.599f, 41.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 152.699f, 1803.099f, 41.2f, 0.0f, 0.0f, 40.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 120.5f, 1803.3f, 41.599f, 0.0f, 0.0f, 40.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 97.599f, 1807.699f, 43.099f, 0.0f, 0.0f, 40.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 158.0f, 1749.3f, 45.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.299f, 1778.3f, 49.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.299f, 1770.099f, 49.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.299f, 1740.699f, 48.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.1f, 1710.099f, 50.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.1f, 1704.0f, 50.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.1f, 1671.0f, 51.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 258.1f, 1664.099f, 51.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 256.399f, 1831.3f, 54.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 256.399f, 1824.5f, 54.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 235.8f, 1758.4f, 50.5f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 203.0f, 1808.599f, 54.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 203.0f, 1801.9f, 54.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 205.3f, 1785.4f, 54.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 205.3f, 1792.599f, 54.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 205.699f, 1764.8f, 54.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 219.399f, 1822.3f, 54.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 236.1f, 1738.599f, 50.4f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 235.8f, 1716.9f, 50.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 173.899f, 1786.599f, 54.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 110.599f, 1786.3f, 58.0f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 179.5f, 1791.3f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 175.5f, 1772.0f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 181.399f, 1791.3f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 181.399f, 1789.4f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 184.899f, 1760.699f, 47.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 198.5f, 1685.199f, 48.9f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 173.899f, 1779.599f, 54.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 121.699f, 1775.699f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 118.3f, 1775.599f, 44.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 119.5f, 1778.3f, 44.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 127.599f, 1791.4f, 44.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 130.1f, 1793.3f, 44.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 132.5f, 1791.099f, 44.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3796, 117.9f, 1793.599f, 45.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(17859, 152.1f, 1607.0f, 43.799f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 124.699f, 1734.4f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 170.3f, 1736.199f, 47.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 283.0f, 1737.199f, 57.0f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 286.299f, 1691.599f, 59.7f, 0.0f, 0.0f, 320.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 222.399f, 1592.3f, 50.299f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 206.6f, 1608.0f, 41.599f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 206.699f, 1608.099f, 46.099f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 206.8f, 1608.089f, 50.599f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(17859, 141.1f, 1739.4f, 43.799f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 274.799f, 1658.9f, 59.599f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 183.3f, 1556.9f, 56.7f, 0.0f, 0.0f, 230.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6232, 127.699f, 1580.5f, 66.4f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 85.3f, 1597.099f, 45.5f, 20.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 110.599f, 1597.0f, 49.9f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 228.3f, 1673.3f, 41.7f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3095, 169.72f, 1615.199f, 46.5f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 154.399f, 1610.3f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 243.8f, 1622.199f, 58.0f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 219.8f, 1576.8f, 56.599f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 140.699f, 1558.599f, 58.799f, 0.0f, 0.0f, 230.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 140.5f, 1741.599f, 41.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 170.199f, 1723.0f, 47.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 167.1f, 1696.699f, 47.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 167.1f, 1673.0f, 47.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 87.099f, 1558.8f, 48.799f, 0.0f, 0.0f, 229.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 134.3f, 1596.9f, 49.799f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 159.5f, 1596.9f, 45.299f, 19.989f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11472, 122.8f, 1732.199f, 41.7f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(11472, 133.0f, 1738.0f, 40.0f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(17859, 65.9f, 1756.4f, 46.799f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 111.0f, 1754.0f, 49.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 101.5f, 1756.0f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 116.0f, 1776.699f, 44.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 113.4f, 1776.5f, 44.099f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 111.5f, 1776.3f, 44.299f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 109.3f, 1776.4f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 60.5f, 1756.0f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16202, 79.699f, 1743.3f, 35.599f, 350.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3066, 168.8f, 1703.699f, 48.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3361, 49.4f, 1789.0f, 43.7f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 181.399f, 1789.4f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6959, 72.0f, 1748.0f, 49.02f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(17859, 110.4f, 1722.699f, 46.7f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3438, 118.5f, 1738.099f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 57.4f, 1751.0f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 65.599f, 1749.9f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 61.599f, 1747.099f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 61.2f, 1742.699f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 60.4f, 1739.0f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 70.599f, 1811.5f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 116.599f, 1743.4f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 65.699f, 1744.8f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 116.599f, 1741.099f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16202, 32.4f, 1653.0f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(2988, 70.599f, 1815.199f, 44.5f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(2988, 62.2f, 1815.099f, 44.5f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 60.799f, 1804.8f, 45.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 47.7f, 1791.9f, 45.2f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16305, 84.699f, 1797.0f, 49.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 78.9f, 1800.9f, 48.5f, 11.0f, 0.0f, 10.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 78.9f, 1800.9f, 49.9f, 11.0f, 0.0f, 10.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 78.9f, 1800.9f, 47.099f, 11.0f, 0.0f, 10.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 42.299f, 1833.4f, 51.7f, 0.0f, 0.0f, 40.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16134, 78.599f, 1821.8f, 48.0f, 90.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3361, 149.899f, 1742.3f, 39.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3361, 51.5f, 1789.0f, 43.7f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 67.0f, 1741.3f, 44.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 71.199f, 1807.3f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 64.5f, 1811.0f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 66.8f, 1806.4f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 56.7f, 1790.9f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 58.7f, 1790.9f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 56.7f, 1789.0f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 58.7f, 1789.0f, 44.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 56.7f, 1790.9f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 58.7f, 1790.9f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 56.7f, 1789.0f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 58.7f, 1789.0f, 46.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 43.5f, 1813.599f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 43.5f, 1793.4f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 43.4f, 1802.4f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 43.5f, 1811.599f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 45.5f, 1813.9f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 44.0f, 1812.8f, 47.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 48.4f, 1820.8f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 58.299f, 1820.5f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 42.0f, 1614.199f, 51.2f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 34.799f, 1604.699f, 42.4f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 34.799f, 1604.699f, 48.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 34.799f, 1683.699f, 48.099f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(8136, 34.799f, 1683.699f, 42.299f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.5f, 1718.199f, 44.299f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.5f, 1716.8f, 44.299f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.5f, 1715.4f, 44.299f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.5f, 1714.0f, 44.299f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.5f, 1712.609f, 44.299f, 0.0f, 90.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(14407, 114.099f, 1710.3f, 41.2f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.4f, 1712.199f, 43.4f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(9339, 115.4f, 1712.199f, 42.0f, 0.0f, 0.0f, 269.989f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 195.899f, 1737.199f, 54.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 215.6f, 1754.9f, 53.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 178.1f, 1662.9f, 53.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 177.199f, 1650.0f, 54.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 177.199f, 1644.199f, 54.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 225.899f, 1626.599f, 51.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 126.4f, 1705.5f, 45.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 126.4f, 1697.3f, 45.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 126.5f, 1680.199f, 45.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 128.6f, 1645.9f, 45.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 128.699f, 1625.199f, 45.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 128.8f, 1609.099f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 128.8f, 1603.4f, 45.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 158.6f, 1574.3f, 52.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 128.3f, 1672.9f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 123.8f, 1718.4f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 56.4f, 1570.0f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 42.5f, 1778.8f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 59.099f, 1769.8f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 44.7f, 1824.8f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 59.0f, 1824.8f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 83.599f, 1772.199f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 147.199f, 1756.8f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 166.1f, 1756.5f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 255.199f, 1845.3f, 42.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 235.3f, 1845.3f, 42.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 235.6f, 1769.699f, 42.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 254.5f, 1647.3f, 49.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 230.3f, 1646.8f, 49.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 225.6f, 1619.8f, 49.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 207.899f, 1610.599f, 49.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 158.3f, 1569.599f, 43.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 198.6f, 1692.4f, 48.799f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16500, 198.5f, 1700.0f, 48.799f, 0.0f, 0.0f, 179.99f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(6295, 56.599f, 1713.0f, 39.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(7017, 151.6f, 1568.0f, 47.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(7017, 195.6f, 1578.9f, 41.599f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(7017, 68.8f, 1568.099f, 42.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.599f, 1597.8f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.599f, 1599.8f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.599f, 1601.8f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.699f, 1597.9f, 43.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.699f, 1599.8f, 43.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 97.8f, 1598.0f, 45.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 95.8f, 1598.0f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 99.5f, 1598.3f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(3798, 101.699f, 1598.5f, 41.799f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 31.1f, 1797.599f, 52.799f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 45.599f, 1565.5f, 52.0f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 39.9f, 1667.9f, 51.2f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 36.5f, 1718.199f, 51.2f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 26.6f, 1758.0f, 51.2f, 0.0f, 0.0f, 130.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		tmpobj = DynamicSampObject.create(16113, 179.199f, 1826.099f, 56.099f, 0.0f, 0.0f, 70.0f, worldId, interiorId, streamDistance, drawDistance); //...
		tmpobjs.add(tmpobj);
		DynamicSampObject[] array = new DynamicSampObject[tmpobjs.size()];
		array = tmpobjs.toArray(array);
		return array;
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventMap#getLocation()
	 */
	@Override
	public Location getLocation() {
		return new Location(95.22585f, 1740.2347f, 45.56775f);
	}
}
