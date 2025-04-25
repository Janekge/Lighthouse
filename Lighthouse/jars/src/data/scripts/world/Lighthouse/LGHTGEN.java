package data.scripts.world.Lighthouse;


import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorGeneratorPlugin;
import data.scripts.world.Lighthouse.lighthouse.Lighthouse;

public class LGHTGEN implements SectorGeneratorPlugin {

    @Override
    public void generate(SectorAPI sector) {

        new Lighthouse().generate(sector);

    }



}
