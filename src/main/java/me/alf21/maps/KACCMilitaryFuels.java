package me.alf21.maps;
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
@EventMapDescription(name = "K.A.C.C Military Fuels", credits = "Ceedie", size = EventMapSize.XLARGE, description = "Zombie Map")
public class KACCMilitaryFuels extends EventMap {

	public KACCMilitaryFuels() { }

	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventMap#create(int, int, float, float, me.alf21.eventsystem.EventData, net.gtaun.shoebill.data.WeaponData)
	 */
	@Override
	public DynamicSampObject[] create(int worldId, int interiorId, float streamDistance, float drawDistance, EventData eventData, WeaponData weaponData) {
		return new DynamicSampObject[] {
			DynamicSampObject.create(3361, 2592.6f, 2789.0f, 12.0f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodstair) (1)
			DynamicSampObject.create(3361, 2592.6f, 2795.3f, 16.2f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodstair) (2)
			DynamicSampObject.create(3361, 2592.6f, 2795.3f, 6.5f, 0.0f, 180.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodstair) (3)
			DynamicSampObject.create(3406, 2589.9f, 2801.2f, 16.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodjetty) (1)
			DynamicSampObject.create(3406, 2589.9f, 2803.2f, 16.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodjetty) (2)
			DynamicSampObject.create(3406, 2586.1f, 2805.1f, 16.2f, 0.0f, 0.0f, 89.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodjetty) (4)
			DynamicSampObject.create(3578, 2527.4f, 2804.9f, 10.6f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(dockbarr1_la) (1)
			DynamicSampObject.create(3578, 2521.2f, 2791.7f, 10.6f, 0.0f, 0.0f, 58.0f, worldId, interiorId, streamDistance, drawDistance), //object(dockbarr1_la) (2)
			DynamicSampObject.create(3620, 2535.1f, 2806.2f, 25.8f, 348.0f, 0.0f, 271.75f, worldId, interiorId, streamDistance, drawDistance), //object(redockrane_las) (1)
			DynamicSampObject.create(3798, 2548.7f, 2781.5f, 9.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (1)
			DynamicSampObject.create(3798, 2550.6f, 2779.5f, 9.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (2)
			DynamicSampObject.create(3798, 2553.0f, 2775.4f, 11.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (3)
			DynamicSampObject.create(3798, 2551.1f, 2773.6f, 11.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (4)
			DynamicSampObject.create(3798, 2556.1f, 2772.1f, 15.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (5)
			DynamicSampObject.create(3798, 2557.2f, 2775.7f, 15.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox3_sfs) (6)
			DynamicSampObject.create(5262, 2586.0f, 2735.9f, 12.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(las2dkwar04) (1)
			DynamicSampObject.create(7040, 2509.9f, 2714.1f, 13.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgnplcehldbox01) (1)
			DynamicSampObject.create(3796, 2515.0f, 2729.9f, 9.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(acbox1_sfs) (1)
			DynamicSampObject.create(3630, 2502.8f, 2743.2f, 11.3f, 0.0f, 12.0f, 358.0f, worldId, interiorId, streamDistance, drawDistance), //object(crdboxes2_las) (1)
			DynamicSampObject.create(6994, 2514.3f, 2763.2f, 7.0f, 0.0f, 90.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgncircus1) (1)
			DynamicSampObject.create(6994, 2509.0f, 2774.2f, 7.0f, 0.0f, 90.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgncircus1) (2)
			DynamicSampObject.create(6994, 2519.9f, 2779.8f, 7.0f, 0.0f, 90.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgncircus1) (3)
			DynamicSampObject.create(6994, 2530.6f, 2757.6f, 7.0f, 0.0f, 90.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgncircus1) (4)
			DynamicSampObject.create(3575, 2549.0f, 2715.9f, 12.5f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(lasdkrt05) (1)
			DynamicSampObject.create(3722, 2612.6f, 2792.9f, 14.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(laxrf_scrapbox) (1)
			DynamicSampObject.create(3406, 2595.1f, 2799.4f, 16.2f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodjetty) (5)
			DynamicSampObject.create(3406, 2595.1f, 2790.6f, 16.2f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodjetty) (6)
			DynamicSampObject.create(3361, 2595.1f, 2787.5f, 20.6f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(cxref_woodstair) (6)
			DynamicSampObject.create(12932, 2554.7f, 2762.5f, 13.2f, 0.0f, 0.0f, 206.0f, worldId, interiorId, streamDistance, drawDistance), //object(sw_trailer02) (1)
			DynamicSampObject.create(18260, 2522.6f, 2796.1f, 11.4f, 0.0f, 0.0f, 58.75f, worldId, interiorId, streamDistance, drawDistance), //object(crates01) (1)
			DynamicSampObject.create(18260, 2538.9f, 2789.1f, 14.4f, 0.0f, 0.0f, 174.749f, worldId, interiorId, streamDistance, drawDistance), //object(crates01) (2)
			DynamicSampObject.create(2973, 2523.7f, 2768.3f, 9.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (1)
			DynamicSampObject.create(2973, 2519.5f, 2772.3f, 9.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (2)
			DynamicSampObject.create(2991, 2607.2f, 2799.9f, 23.0f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(imy_bbox) (1)
			DynamicSampObject.create(2991, 2607.2f, 2801.4f, 24.3f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(imy_bbox) (2)
			DynamicSampObject.create(2991, 2607.2f, 2802.4f, 23.0f, 0.0f, 0.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(imy_bbox) (3)
			DynamicSampObject.create(2973, 2578.4f, 2831.0f, 26.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (3)
			DynamicSampObject.create(2973, 2593.5f, 2827.6f, 26.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (4)
			DynamicSampObject.create(5262, 2564.4f, 2829.6f, 29.8f, 0.0f, 0.0f, 116.0f, worldId, interiorId, streamDistance, drawDistance), //object(las2dkwar04) (2)
			DynamicSampObject.create(5262, 2601.2f, 2833.5f, 29.8f, 0.0f, 358.0f, 25.999f, worldId, interiorId, streamDistance, drawDistance), //object(las2dkwar04) (3)
			DynamicSampObject.create(3066, 2580.8f, 2816.1f, 27.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (1)
			DynamicSampObject.create(3066, 2578.1f, 2815.9f, 27.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (2)
			DynamicSampObject.create(3066, 2579.3f, 2816.2f, 29.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (3)
			DynamicSampObject.create(3066, 2530.8f, 2748.4f, 10.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (4)
			DynamicSampObject.create(3066, 2525.4f, 2748.5f, 10.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (5)
			DynamicSampObject.create(3066, 2527.4f, 2724.3f, 11.0f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(ammotrn_obj) (6)
			DynamicSampObject.create(3585, 2501.3f, 2755.7f, 11.5f, 23.752f, 8.746f, 30.454f, worldId, interiorId, streamDistance, drawDistance), //object(lastran1_la02) (1)
			DynamicSampObject.create(922, 2504.3f, 2766.4f, 10.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (1)
			DynamicSampObject.create(922, 2504.3f, 2772.0f, 10.7f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (2)
			DynamicSampObject.create(922, 2502.5f, 2769.2f, 10.7f, 0.0f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (3)
			DynamicSampObject.create(922, 2504.3f, 2766.4f, 13.9f, 180.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (5)
			DynamicSampObject.create(922, 2502.5f, 2769.2f, 13.9f, 179.995f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (6)
			DynamicSampObject.create(922, 2504.4f, 2772.0f, 13.9f, 179.995f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (7)
			DynamicSampObject.create(922, 2506.5f, 2769.3f, 13.9f, 179.995f, 0.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(packing_carates1) (8)
			DynamicSampObject.create(939, 2539.8f, 2778.4f, 12.3f, 0.0f, 0.0f, 290.0f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (1)
			DynamicSampObject.create(939, 2536.4f, 2758.8f, 12.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (2)
			DynamicSampObject.create(939, 2538.7f, 2767.6f, 12.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (3)
			DynamicSampObject.create(939, 2615.5f, 2758.4f, 25.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (4)
			DynamicSampObject.create(939, 2527.1f, 2773.9f, 12.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (5)
			DynamicSampObject.create(939, 2644.5f, 2793.0f, 12.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (6)
			DynamicSampObject.create(939, 2646.2f, 2788.2f, 12.3f, 0.0f, 0.0f, 289.995f, worldId, interiorId, streamDistance, drawDistance), //object(cj_df_unit) (7)
			DynamicSampObject.create(16766, 2588.5f, 2763.0f, 14.6f, 0.0f, 0.0f, 122.0f, worldId, interiorId, streamDistance, drawDistance), //object(des_oilpipe_02) (1)
			DynamicSampObject.create(16766, 2588.5f, 2762.9f, 9.7f, 180.0f, 0.0f, 121.998f, worldId, interiorId, streamDistance, drawDistance), //object(des_oilpipe_02) (2)
			DynamicSampObject.create(16481, 2544.1f, 2709.3f, 17.9f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(des_quarrybelt19) (1)
			DynamicSampObject.create(18260, 2534.8f, 2814.4f, 11.4f, 0.0f, 0.0f, 274.749f, worldId, interiorId, streamDistance, drawDistance), //object(crates01) (3)
			DynamicSampObject.create(16076, 2503.4f, 2822.3f, 11.8f, 0.0f, 0.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance), //object(des_sorter01) (1)
			DynamicSampObject.create(16086, 2526.8f, 2774.5f, 13.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(des_bigoilpipe01) (1)
			DynamicSampObject.create(2973, 2498.6f, 2738.5f, 12.6f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (5)
			DynamicSampObject.create(2973, 2498.6f, 2738.5f, 10.2f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (6)
			DynamicSampObject.create(2973, 2498.6f, 2738.5f, 8.4f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (7)
			DynamicSampObject.create(16318, 2637.6f, 2789.7f, 27.5f, 0.0f, 0.0f, 91.25f, worldId, interiorId, streamDistance, drawDistance), //object(des_quarrybelt18) (1)
			DynamicSampObject.create(2973, 2635.0f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (8)
			DynamicSampObject.create(2973, 2637.3f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (9)
			DynamicSampObject.create(2973, 2637.2998f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (10)
			DynamicSampObject.create(2973, 2639.6f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (11)
			DynamicSampObject.create(2973, 2641.9f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (12)
			DynamicSampObject.create(2973, 2641.8f, 2802.0f, 33.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (13)
			DynamicSampObject.create(2973, 2639.6f, 2802.0f, 33.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (14)
			DynamicSampObject.create(2973, 2637.4f, 2802.0f, 33.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (15)
			DynamicSampObject.create(2973, 2635.1f, 2802.0f, 33.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (16)
			DynamicSampObject.create(2973, 2632.7f, 2802.0f, 31.3f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (17)
			DynamicSampObject.create(2973, 2632.8f, 2802.0f, 33.8f, 0.0f, 0.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(k_cargo2) (18)
			DynamicSampObject.create(8356, 2496.9f, 2767.4f, 29.8f, 0.0f, 270.0f, 0.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgssairportland15) (1)
			DynamicSampObject.create(8356, 2590.8f, 2857.7f, 29.8f, 0.0f, 270.0f, 270.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgssairportland15) (2)
			DynamicSampObject.create(8356, 2591.0f, 2703.7f, 29.8f, 0.0f, 270.0f, 90.0f, worldId, interiorId, streamDistance, drawDistance), //object(vgssairportland15) (3)
			DynamicSampObject.create(8356, 2684.4f, 2783.2f, 29.8f, 0.0f, 270.0f, 180.0f, worldId, interiorId, streamDistance, drawDistance) //object(vgssairportland15) (4)
		};
	}
	
	/* (non-Javadoc)
	 * @see me.alf21.eventsystem.EventMap#getLocation()
	 */
	@Override
	public Location getLocation() {
		return new Location(2637.199f, 2796.1753f, 30.816061f);
	}
}
