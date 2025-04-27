package data.scripts.world.Lighthouse.lighthouse;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Factions;
import com.fs.starfarer.api.impl.campaign.procgen.NebulaEditor;
import com.fs.starfarer.api.impl.campaign.terrain.HyperspaceTerrainPlugin;
import com.fs.starfarer.api.util.Misc;



public class Lighthouse {

    public void generate(SectorAPI sector) {

        StarSystemAPI system = sector.createStarSystem("Lighthouse");

        system.setBackgroundTextureFilename("jars/src/graphics/background/background1.jpg");

        PlanetAPI Lighthouse_star = system.initStar(
                "lighthouse",
                "star_yellow",
                600f,
                -55000,
                -40000,
                650f);

        Lighthouse_star.setCustomDescriptionId("lighthouse");

        SectorEntityToken tap = system.addCustomEntity("lighthouse_tap", "Coronal Hypershunt", "coronal_tap", Factions.NEUTRAL);
        //tap.setCircularOrbit(Lighthouse_star, 180f,650, 2800);
        tap.setFixedLocation(0,750);

        PlanetAPI Lighthouse_1 = system.addPlanet(
                "lighthouse_1",
                Lighthouse_star,
                "Pompeii",
                "lava",
                360f*(float)Math.random(),
                150,
                3000,
                360
        );
        //PlanetConditionGenerator.generateConditionsForPlanet(Lighthouse_1, StarAge.YOUNG);
        MarketAPI lighthouse_1_market = Global.getFactory().createMarket("lighthouse_1_market", Lighthouse_1.getName(), 0);
        lighthouse_1_market.setPlanetConditionMarketOnly(true);
        lighthouse_1_market.addCondition(Conditions.ORE_ULTRARICH);
        lighthouse_1_market.addCondition(Conditions.RARE_ORE_ULTRARICH);
        lighthouse_1_market.addCondition(Conditions.ORGANICS_PLENTIFUL);
        lighthouse_1_market.addCondition(Conditions.VERY_HOT);
        lighthouse_1_market.addCondition(Conditions.LOW_GRAVITY);
        lighthouse_1_market.setPrimaryEntity(Lighthouse_1);
        Lighthouse_1.setMarket(lighthouse_1_market);
        Lighthouse_1.setCustomDescriptionId("lighthouse_1");


        SectorEntityToken stableloc1 = system.addCustomEntity("lighthouse_stableloc_1", "Comm Relay", "comm_relay", Factions.NEUTRAL);
        stableloc1.setCircularOrbit(Lighthouse_star, 360f*(float)Math.random(),4500, 540);

        PlanetAPI Lighthouse_2 = system.addPlanet(
                "lighthouse_2",
                Lighthouse_star,
                "Far Port",
                "terran",
                270f,
                200,
                6000,
                720
        );
        //PlanetConditionGenerator.generateConditionsForPlanet(Lighthouse_2, StarAge.YOUNG);
        MarketAPI lighthouse_2_market = Global.getFactory().createMarket("lighthouse_2_market", Lighthouse_2.getName(), 0);
        lighthouse_2_market.setPlanetConditionMarketOnly(true);
        lighthouse_2_market.addCondition(Conditions.FARMLAND_BOUNTIFUL);
        lighthouse_2_market.addCondition(Conditions.MILD_CLIMATE);
        lighthouse_2_market.addCondition(Conditions.RUINS_VAST);
        lighthouse_2_market.addCondition(Conditions.DECIVILIZED);
        lighthouse_2_market.addCondition(Conditions.HABITABLE);
        lighthouse_2_market.setPrimaryEntity(Lighthouse_2);
        Lighthouse_2.setMarket(lighthouse_2_market);
        Lighthouse_2.setCustomDescriptionId("lighthouse_2");

        JumpPointAPI jump_point_Lighthouse_2 = Global.getFactory().createJumpPoint("lighthouse_jump_point_1", "Far Port Approach");
        jump_point_Lighthouse_2.setCircularOrbit(Lighthouse_star, 290f, 6000, 720);
        jump_point_Lighthouse_2.setRelatedPlanet(Lighthouse_2);
        system.addEntity(jump_point_Lighthouse_2);

        SectorEntityToken stableloc2 = system.addCustomEntity("lighthouse_stableloc_2", "Sensor Array", "sensor_array", Factions.NEUTRAL);
        stableloc2.setCircularOrbit(Lighthouse_star, 360f*(float)Math.random(),7500, 960);

        PlanetAPI Lighthouse_3 = system.addPlanet(
                "lighthouse_3",
                Lighthouse_star,
                "Guardian",
                "gas_giant",
                360f*(float)Math.random(),
                500,
                9000,
                1080
        );
        //PlanetConditionGenerator.generateConditionsForPlanet(Lighthouse_3, StarAge.YOUNG);
        MarketAPI lighthouse_3_market = Global.getFactory().createMarket("lighthouse_3_market", Lighthouse_3.getName(), 0);
        lighthouse_3_market.setPlanetConditionMarketOnly(true);
        lighthouse_3_market.addCondition(Conditions.VOLATILES_PLENTIFUL);
        lighthouse_3_market.addCondition(Conditions.DENSE_ATMOSPHERE);
        lighthouse_3_market.setPrimaryEntity(Lighthouse_3);
        Lighthouse_3.setMarket(lighthouse_3_market);
        Lighthouse_3.setCustomDescriptionId("lighthouse_3");

        PlanetAPI Lighthouse_3_moon = system.addPlanet(
                "lighthouse_3_moon",
                Lighthouse_3,
                "Mun",
                "barren",
                360f*(float)Math.random(),
                100,
                800,
                360
        );
        //PlanetConditionGenerator.generateConditionsForPlanet(Lighthouse_3_moon, StarAge.YOUNG);
        MarketAPI lighthouse_3_moon_market = Global.getFactory().createMarket("lighthouse_3_moon_market", Lighthouse_3_moon.getName(), 0);
        lighthouse_3_moon_market.setPlanetConditionMarketOnly(true);
        lighthouse_3_moon_market.addCondition(Conditions.NO_ATMOSPHERE);
        lighthouse_3_moon_market.addCondition(Conditions.LOW_GRAVITY);
        lighthouse_3_moon_market.setPrimaryEntity(Lighthouse_3_moon);
        Lighthouse_3_moon.setMarket(lighthouse_3_moon_market);
        Lighthouse_3_moon.setCustomDescriptionId("lighthouse_3_moon");

        SectorEntityToken stableloc3 = system.addCustomEntity("lighthouse_stableloc_3", "Nav Buoy", "nav_buoy", Factions.NEUTRAL);
        stableloc3.setCircularOrbit(Lighthouse_star, 360f*(float)Math.random(),10500, 1260);

        SectorEntityToken Asteroid_belt = system.addAsteroidBelt(Lighthouse_star, 2000, 12000, 100, 100, 1000);

        SectorEntityToken gate = system.addCustomEntity("lighthouse_gate", "Inactive Gate", "inactive_gate", Factions.NEUTRAL);
        gate.setCircularOrbit(Lighthouse_star, 360f*(float)Math.random(),13500, 2500);

        system.autogenerateHyperspaceJumpPoints(true,true);

        cleanup(system);


    }
    private void cleanup(StarSystemAPI system) {
        HyperspaceTerrainPlugin plugin = (HyperspaceTerrainPlugin) Misc.getHyperspaceTerrain().getPlugin();
        NebulaEditor editor = new NebulaEditor(plugin);
        float minRadius = plugin.getTileSize() * 2f;

        float radius = system.getMaxRadiusInHyperspace();
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius+minRadius * 0.5f , 0, 360f);
        editor.clearArc(system.getLocation().x, system.getLocation().y, 0, radius+minRadius , 0, 360f, 0.25f);

    }


}
