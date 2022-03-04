package user.uziza.SheetImporter;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import user.uziza.SheetImporter.Items.CharBook;

public class Main extends JavaPlugin implements Listener {
	private SheetImporterCommands SSICommands = new SheetImporterCommands(this); 
	@Override
	public void onEnable() {
		Boolean spreadsheets = new File(this.getDataFolder() + "/Spreadsheets").mkdirs();
		Boolean spellcasting = new File(this.getDataFolder() + "/Info/Spellcasting").mkdirs();
		this.getCommand(SSICommands.imp).setExecutor(SSICommands);
		this.getCommand(SSICommands.sh).setExecutor(SSICommands);
		this.getCommand(SSICommands.desc).setExecutor(SSICommands);
		this.getCommand(SSICommands.dl).setExecutor(SSICommands);
		this.getCommand(SSICommands.asn).setExecutor(SSICommands);
		getServer().dispatchCommand(getServer().getConsoleSender(), "import");
		getServer().getPluginManager().registerEvents(new CharBook(this), this);
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
}
