package user.uziza.SheetImporter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Score;

import user.uziza.SheetImporter.SheetImporter;
import user.uziza.SheetImporter.Items.CharBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;  

public class SheetImporterCommands implements CommandExecutor, Listener {
	public String imp = "import";
	public String chr = "char";
	
	SheetImporter plugin;
	public SheetImporterCommands(SheetImporter plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase(imp)) {
			if (sender.isOp()) {
				try {
					if (!args[0].contains(".csv") || args[0].contains("/") || args[0].contains("~")) {
						throw new FileNotFoundException();
					}
					Scanner csv = new Scanner(new File(plugin.getDataFolder() + "/Spreadsheets/" + args[0]), "UTF-8");
					String NAME = null;
					String HPMAX = null;
					String LVL = null;
					String HP = null;
					String CLASS = null;
					String STR = null;
					String DEX = null;
					String CON = null;
					String WIS = null;
					String INT = null;
					String CHR = null;
					String ATK = null;
					String ATKBONUS = null;
					String ATKDESC = null;
					String ATKTYPE = null;
					String AC = null;
					String SPEED = null;
					String PB = null;
					String PP = null;
					
					String[] msgs;
					int index = 0;
					while (csv.hasNext()) {
						index += 1;
						String msg = csv.nextLine();
						msgs = msg.split(",");
						if(index == 7) {
							NAME = msgs[2];
							CLASS = msgs[43];
							LVL = msgs[37];
							plugin.getConfig().set(NAME+"."+ "Class", CLASS);
							plugin.getConfig().set(NAME+"."+"Level", Integer.valueOf(LVL));
							
						}
						else if (index == 13) {
							AC = msgs[17];
							SPEED = msgs[25].replace(" ft", "");
							plugin.getConfig().set(NAME+"."+"AC", Integer.valueOf(AC));
							plugin.getConfig().set(NAME+"."+"Speed", Integer.valueOf(SPEED));
						}
						else if (index == 18) {
							HP = msgs[17];
							plugin.getConfig().set(NAME+"." + "HP", Integer.valueOf(HP));
						}
						else if (index == 17) {
							HPMAX = msgs[20];
							plugin.getConfig().set(NAME+"."+"MaxHP", Integer.valueOf(HPMAX));
						}
						else if (index == 16) {
							STR = msgs[2];
							plugin.getConfig().set(NAME+"."+"Strength", Integer.valueOf(STR));
						}
						else if (index == 21) {
							DEX = msgs[2];
							plugin.getConfig().set(NAME+"."+"Dexterity", Integer.valueOf(DEX));
						}
						else if (index == 26) {
							CON = msgs[2];
							plugin.getConfig().set(NAME+"."+"Constitution", Integer.valueOf(CON));
						}
						else if (index == 41) {
							WIS = msgs[2];
							plugin.getConfig().set(NAME+"."+"Wisdom", Integer.valueOf(WIS));
						}
						else if (index == 31) {
							INT = msgs[2];
							plugin.getConfig().set(NAME+"."+"Intellect", Integer.valueOf(INT));
						}
						else if (index == 46) {
							CHR = msgs[2];
							plugin.getConfig().set(NAME+"."+"Charisma", Integer.valueOf(CHR));
						}
						else if (index == 15) {
							PB = msgs[7];
							plugin.getConfig().set(NAME+"."+"PB", Integer.valueOf(PB));
						}
						else if (index == 51) {
							PP = msgs[2];
							plugin.getConfig().set(NAME+"."+"PP", Integer.valueOf(PP));
						}
						else if (msg.contains("***")) {
							if (msg.contains("Melee") | msg.contains("Ranged") | msg.contains("Spell")) {
								ATK = msgs[17];
								ATKDESC = msgs[28].replace("***", "").substring(msgs[28].lastIndexOf("|")+1);
								String ATKDMGTYPE = msgs[28].substring(msgs[28].lastIndexOf("[")+1, msgs[28].indexOf("]"));
								String ATKDMG = msgs[28].substring(msgs[28].lastIndexOf(",,")+1, msgs[28].indexOf("[")).replace("\"", "");
								if (msg.contains("Melee")) {
									ATKTYPE = "Melee";
								}
								else if (msg.contains("Ranged")) {
									ATKTYPE = "Ranged";
								}
								else if (msg.contains("Spell")) {
									ATKTYPE = "Spell";
								}
								ATKBONUS = msgs[24];
								plugin.getConfig().set(NAME+".Weapons."+ATK+".AttackDesc", ATKDESC);
								plugin.getConfig().set(NAME+".Weapons."+ATK+".AttackType", ATKTYPE);
								plugin.getConfig().set(NAME+".Weapons."+ATK+".AttackDMG", ATKDMG);
								plugin.getConfig().set(NAME+".Weapons."+ATK+".DMGType", ATKDMGTYPE);
								plugin.getConfig().set(NAME+".Weapons."+ATK+".AttackBonus", Integer.valueOf(ATKBONUS));
								
							}
						}
						
					}
					plugin.saveConfig();
					csv.close();
				} catch (FileNotFoundException e) {
					sender.sendMessage("Could not read file.");
				} //catch no stuff
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(chr)) {
			if (sender.isOp()) {
				
				if (plugin.getConfig().getConfigurationSection(args[0]+" "+args[1]) != null) {
					CharBook charBook = new CharBook(plugin);
					String character = args[0]+" "+args[1];
					
					Player player = (Player) sender;

					try {
						for (Player p: Bukkit.getOnlinePlayers()) {
							if (p.getName().equals(args[2])) {
								player = p;
								break;
							}
						}
					}
					catch (Exception e) {
						sender.sendMessage("Name set to default..");
					}
					charBook.createBook(player, character);
				}
			}
			return true;
		}
		return false;
	}

}
