package ceckari.thedrake;

import java.util.List;

public interface TheDrakeSetup {
	public List<TroopInfo> troops();
    public TroopInfo infoByName(String name);
}
