package user.uziza.SheetImporter;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import user.uziza.SheetImporter.Items.CharBook;

public class SheetImporter extends JavaPlugin implements Listener {
	private SheetImporterCommands SSICommands = new SheetImporterCommands(this); 
	@Override
	public void onEnable() {
		this.getCommand(SSICommands.imp).setExecutor(SSICommands);
		this.getCommand(SSICommands.chr).setExecutor(SSICommands);
		getServer().getPluginManager().registerEvents(new CharBook(this), this);
		File spreadsheets = new File(this.getDataFolder() + "/Spreadsheets");
		spreadsheets.mkdirs();
	}
	
	@Override
	public void onDisable() {
		
	}
}
