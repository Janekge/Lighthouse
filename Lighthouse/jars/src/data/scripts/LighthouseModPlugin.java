package data.scripts;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import data.scripts.world.Lighthouse.LGHTGEN;
import exerelin.campaign.SectorManager;

public class LighthouseModPlugin extends BaseModPlugin  {

    public static boolean isExerelin = false;

    public static void initLGHT() {
        if (isExerelin && !SectorManager.getManager().isCorvusMode()) {
            return;
        }
        new LGHTGEN().generate(Global.getSector());
        //new LGHTGEN().cleanup((StarSystemAPI) Global.getSector());
    }

    @Override
    public void onApplicationLoad() {
        isExerelin = Global.getSettings().getModManager().isModEnabled("nexerelin");
    }

    @Override
    public void onNewGame() {
        initLGHT();
    }


}