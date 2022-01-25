package user.uziza.SheetImporter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.Score;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.primitives.Chars;

import user.uziza.SheetImporter.SheetImporter;
import user.uziza.SheetImporter.Items.CharBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;  

public class SheetImporterCommands implements CommandExecutor, Listener {
	public String imp = "import";
	public String sh = "sheet";
	public String desc = "desc";
	public String dl = "dl";
	public String asn = "assign";
	
	SheetImporter plugin;
	public SheetImporterCommands(SheetImporter plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase(dl)) {
			if (sender.isOp()) {
				String name;
				InputStream inputStream;
				try {
					name = "ai";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ai.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "aitfr-avt";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-aitfr-avt.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "egw";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-egw.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ftd";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ftd.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-mm";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-mm.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-saw";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-saw.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-ss";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-ss.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-tobm";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-tobm.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					
					name = "xge";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-xge.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-2020por";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-2020por.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-2020smt";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-2020smt.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-2021do";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-2021do.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-ar";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-ar.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ua-frw";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ua-frw.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ggr";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-ggr.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "idrotf";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-idrotf.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "llk";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-llk.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "phb";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-phb.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "scc";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-scc.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "tce";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/spells/spells-tce.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/Spellcasting/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					sender.sendMessage("Spells done");
				}
				catch (Exception e) {
					
				}
				try {
					name = "races";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/races.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "monk";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-monk.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "mystic";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-mystic.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "paladin";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-paladin.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "ranger";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-ranger.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "rogue";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-rogue.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "runescribe";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-rune-scribe.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "sidekick";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-sidekick.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "sorcerer";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-sorcerer.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "warlock";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-warlock.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "wizard";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-wizard.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "artificer";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-artificer.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "barbarian";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-barbarian.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "bard";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-bard.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "cleric";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-cleric.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "druid";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-druid.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					name = "fighter";
					inputStream = new URL("https://raw.githubusercontent.com/5etools-mirror-1/5etools-mirror-1.github.io/master/data/class/class-fighter.json").openStream();
					Files.copy(inputStream, Paths.get(plugin.getDataFolder() + "/Info/"+name+".json"), StandardCopyOption.REPLACE_EXISTING);
					sender.sendMessage("Classes/races done");
				}
				catch (Exception e) {
					
				}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(asn)) {
			if (sender.isOp()) {
			if (args.length > 1) {
				try {
				String character = null;
				String player = args[0];
				if (args[1].contains(".csv")) {
					String c;
					boolean go = false;
					for (Entry<String, Object> val: plugin.getConfig().getValues(false).entrySet()) {
						c = val.getKey();
						for (Entry<String, Object> val2: plugin.getConfig().getConfigurationSection(c).getValues(false).entrySet()) {
							if (val2.getKey().equals("File") && val2.getValue().equals(args[1])) {
								
								character = c;
								go = true;
								break;
							}
						}
					}
					if (go == false) {
						throw new Exception();
					}
				}
				else {
					character = args[1]+" "+args[2];
				}
				plugin.getConfig().getConfigurationSection(character).set("Owner", player);
				plugin.saveConfig();
				}
				catch (Exception e) {
					
				}
			}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(imp)) {
			if (sender.isOp()) {
				try {
					
					List<String> characters = new ArrayList<String>();
					
					String owner = "None";
					if (args.length == 0 || args[0].equals("all")) {
						for (String c: new File(plugin.getDataFolder() + "/Spreadsheets/").list()) {
							characters.add(c);
							
						}
						for (Entry<String, Object> val: plugin.getConfig().getValues(false).entrySet()) {
							String c = val.getKey();
							String file = "";
							String own = "";
							for (Entry<String, Object> val2: plugin.getConfig().getConfigurationSection(c).getValues(false).entrySet()) {
								if (val2.getKey().equals("File")) {
									file = val2.getValue().toString();
								}
								else if (val2.getKey().equals("Owner") && !val2.getValue().equals("None")) {
									own = val2.getValue().toString();
								}
							}
							if (!own.isBlank()) {
								characters.remove(file);
							}
						}
					}
					else if (!args[0].equals("all")) {
						boolean works = false;
						if (!args[0].contains(".csv") || args[0].contains("/") || args[0].contains("~") || args[0].equals(".csv")) {
							throw new FileNotFoundException();
						}
						for (String c: new File(plugin.getDataFolder() + "/Spreadsheets/").list()) {
							if (args[0].equals(c)) {
								//sender.sendMessage(args[0]);
								
								works = true;
								characters.add(args[0]);
							}
						}
						if (works == false) {
							throw new FileNotFoundException();
						}
						
						if (args.length > 1) {
							if (plugin.getServer().getPlayer(args[1]) != null) {
								owner = args[1];
							}
						}
						
					}
					
					
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
					String STR_M = null;
					String DEX_M = null;
					String CON_M = null;
					String WIS_M = null;
					String INT_M = null;
					String CHR_M = null;
					String ATK = null;
					String ATKBONUS = null;
					String ATKDESC = null;
					String ATKTYPE = null;
					String AC = null;
					String SPEED = null;
					String PB = null;
					String PP = null;
					String subclass = null;
					String race = null;
					
					String p_one = null;
					String p_two = null;
					String p_three = null;
					
					String STH = null;
					String ACR = null;
					String ANH = null;
					String ARC = null;
					String ATH = null;
					String DEC = null;
					String HIS = null;
					String INS = null;
					String INV = null;
					String ITN = null;
					String MED = null;
					String NTR = null;
					String PEC = null;
					String PEN = null;
					String PER = null;
					String REG = null;
					String SoH = null;
					String SVL = null;
					
					String DIE = null;
					
					String BG = null;
					String BG1 = "";
					String BG2 = "";
					String BG3 = "";
					String BG4 = "";
					
					String PF1 = "None";
					String PF2 = "None";
					String PF3 = "None";
					String PF4 = "None";
					String PF5 = "None";
					String PF6 = "None";
					
					String STR_SAVE = null;
					String CON_SAVE = null;
					String CHA_SAVE = null;
					String INT_SAVE = null;
					String DEX_SAVE = null;
					String WIS_SAVE = null;
					
					String spellability = null;
					String spellsavedc = null;
					String spellattackmodifier = null;
					
					String cantripa = null;
					String cantripb = null;
					String cantripc = null;
					
					try {
						for (String c: characters) {
							try {
							BG1 = "";
							BG2 = "";
							BG3 = "";
							BG4 = "";
						Scanner csv = new Scanner(new File(plugin.getDataFolder() + "/Spreadsheets/" + c), "UTF-8");
					Scanner csv_reset = new Scanner(new File(plugin.getDataFolder() + "/Spreadsheets/" + c), "UTF-8");
					String[] msgs_reset;
					int index_reset = 0;
					for (int i = 0; i < 2; i++) {
						boolean noabc = false;
						int add = i;
						boolean abc = false;
						int valz = 0;
						try {
					while (csv_reset.hasNext()) {
						index_reset += 1;
						String msg_reset = csv_reset.nextLine();
						msgs_reset = msg_reset.split(",");
						
						if(index_reset == 7+add) {
							NAME = msgs_reset[2];
							plugin.getConfig().set(NAME, null);
							plugin.saveConfig();
							break;
						}
					}
					plugin.getConfig().set(NAME+"."+"Subclass", subclass);
					csv_reset.close();
					String[] msgs;
					int index = 0;
					if (add == 0 || add == 1) {
						int alt = 0;
						boolean a= false;
						boolean b = false;
						boolean d = false;
						int superadd = 0;
						int addagain = 0;
						boolean addagain2 = false;
						while (csv.hasNext()) {
							//fix string name problem (later?)
							index += 1;
							String msg = csv.nextLine();
							msgs = msg.split(",");
							if (msg.contains("***")) {
								//may need fixing
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
							
							if(index == 7+add) {
								try {
								NAME = msgs[2];
								LVL = msgs[37];
								CLASS = msgs[43];
								plugin.getConfig().set(NAME+"."+ "Class", CLASS);
								plugin.getConfig().set(NAME+"."+"Level", Integer.valueOf(LVL));
								plugin.getConfig().set(NAME+"."+"Subclass", subclass);
								}
								catch (Exception e) {
									plugin.getConfig().set(NAME, null);
									
									add+=1;
								}
								
								
								
							}
							else if (index > 64-superadd+addagain && index < 91-superadd+addagain || abc == true && noabc == false) {
								if (abc == true) {
									try {
										
										try {
										if (index == 32+valz+alt) {
											MED = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
											
											
										}
										}
										catch (Exception e) {
											
										}
										
					
										if (index == 35+valz+alt) {
											WIS = msgs[2];
											plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
											NTR = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
											
										}
										if (index == 36+valz+alt) {
											PEC = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.PEC", Integer.valueOf(PEC));
										}
										if (index == 37+valz+alt) {
											PER = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.PER", Integer.valueOf(PER));
											
										}
										if (index == 38+valz+alt) {
											CHR_M = msgs[2];
											plugin.getConfig().set(NAME+"."+"Charisma.Modifier", Integer.valueOf(CHR_M));
											PEN = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.PEN", Integer.valueOf(PEN));
											
										}
										if (index == 39+valz+alt) {
											REG = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.REG", Integer.valueOf(REG));
										}
										if (index == 40+valz+alt) {
											CHR = msgs[2];
											plugin.getConfig().set(NAME+"."+"Charisma.Default", Integer.valueOf(CHR));
											SoH = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.SoH", Integer.valueOf(SoH));
										}
										if (index == 41+valz+alt) {
											STH = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.STH", Integer.valueOf(STH));
										}
										if (index ==  42+valz+alt) {
											SVL = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.SVL", Integer.valueOf(SVL));
										}
										
										if (index ==  45+valz+alt) {
											
											PP = msgs[2];
											plugin.getConfig().set(NAME+"."+"PP", Integer.valueOf(PP));
										}
									if (index == 49+valz+alt) {
										PF1 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										plugin.getConfig().set(NAME+"."+"Proficiencies.Armor", PF1);
									}
									if (index == 50+valz+alt) {
										try {
										PF2 = "\""+ msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										}
										catch (Exception e) {
											
										}
										plugin.getConfig().set(NAME+"."+"Proficiencies.Weapon", PF2);
									}
									if (index == 51+valz+alt) {
										try {
										PF3 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										}
										catch (Exception e) {
											
										}
										plugin.getConfig().set(NAME+"."+"Proficiencies.Vehicle", PF3);
									}
									if (index == 52+valz+alt) {
										try {
											PF4 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										}
										
										catch (Exception e) {
											
										}
										plugin.getConfig().set(NAME+"."+"Proficiencies.2Tool", PF4);
									}
									if (index == 53+valz+alt) {
										try {
										PF5 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										}
										catch (Exception e) {
											
										}
										plugin.getConfig().set(NAME+"."+"Proficiencies.Other", PF5);
									}
									if (index == 54+valz+alt) {
										try {
										PF6 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
										}
										catch (Exception e) {
											
										}
										plugin.getConfig().set(NAME+"."+"Proficiencies.Speeds", PF6);
									}
									if (index == 96+valz+alt) {
										try {
											cantripa = msgs[13];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
										}
										catch (Exception e) {
											
										}
										try {
											cantripb = msgs[23];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
										}
										catch (Exception e){
											
										}
										try {
										cantripc = msgs[36];
										plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
										}
										catch (Exception e) {
											
										}
										
									}
									if (index == 97+valz+alt) {
										try {
											cantripa = msgs[13];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
										}
										catch (Exception e) {
											
										}
										try {
											cantripb = msgs[23];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
										}
										catch (Exception e){
											
										}
										try {
										cantripc = msgs[36];
										plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
										}
										catch (Exception e) {
											
										}
									}
									if (index == 98+valz+alt) {
										try {
											cantripa = msgs[13];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
										}
										catch (Exception e) {
											
										}
										try {
											cantripb = msgs[23];
											plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
										}
										catch (Exception e){
											
										}
										try {
										cantripc = msgs[36];
										plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
										}
										catch (Exception e) {
											
										}
									}
									if (index == 91+valz+alt) {
										spellability = msgs[20];
										plugin.getConfig().set(NAME+"."+"Spellcasting.spell_ability", spellability);
										spellsavedc = msgs[27];
										plugin.getConfig().set(NAME+"."+"Spellcasting.spell_savedc", spellsavedc);
										spellattackmodifier = msgs[34];
										plugin.getConfig().set(NAME+"."+"Spellcasting.spell_attackmodifier", spellattackmodifier);

									}
									if (index >= 100+valz+alt && index < 105+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[3], 1);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[13], 1);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[23], 1);
										}
										catch (Exception e) {
											
										}
										
										
										
									}
									if (index >= 112+valz+alt && index < 117+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[3], 3);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[13], 3);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[23], 3);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 123+valz+alt && index < 127+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[3], 5);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[13], 5);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[23], 5);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 133+valz+alt && index < 136+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[3], 7);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[13], 7);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[23], 7);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 141+valz+alt && index < 144+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[3], 9);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[13], 9);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[23], 9);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 106+valz+alt && index < 111+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+msgs[13], 2);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+ msgs[23],2);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+msgs[33], 2);
										}
										catch (Exception e) {
											
										}
										
										
										
									}
									if (index >= 118+valz+alt && index < 122+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+msgs[13], 4);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+ msgs[23],4);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+msgs[33], 4);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 128+valz+alt && index < 131+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+msgs[13], 6);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+ msgs[23],6);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+msgs[33], 6);
										}
										catch (Exception e) {
											
										}
									}
									if (index >= 137+valz+alt && index < 140+valz+alt) {
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+msgs[13], 8);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+ msgs[23],8);
										}
										catch (Exception e) {
											
										}
										try {
											plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+msgs[33], 8);
										}
										catch (Exception e) {
											
										}
									}
									if (index > 61+alt && index < 88+alt) {
										if (msg.contains("FEATURES & TRAITS     ")) {
											continue;
										}
										try {
											p_one = msgs[2];
											plugin.getConfig().set(NAME+"."+"Perks."+p_one, 1);
			
										}
										catch (Exception e) {
											
										}
										try {
											p_two = msgs[15];
											plugin.getConfig().set(NAME+"."+"Perks."+p_two, 1);
										}
										catch (Exception e) {
											
										}
										try {
											p_three = msgs[28];
											plugin.getConfig().set(NAME+"."+"Perks."+p_three, 1);
										}
										catch (Exception e) {
											
										}
										
									}
									}
									catch (Exception e) {
									
										abc = false;
										noabc = true;
										index = 0;
										csv.reset();
									}
								}
								else {
								if (msg.contains("FEATURES & TRAITS     ")) {
									continue;
								}
								try {
									p_one = msgs[2];
									plugin.getConfig().set(NAME+"."+"Perks."+p_one, 1);
	
								}
								catch (Exception e) {
									
								}
								try {
									p_two = msgs[15];
									plugin.getConfig().set(NAME+"."+"Perks."+p_two, 1);
								}
								catch (Exception e) {
									
								}
								try {
									p_three = msgs[28];
									plugin.getConfig().set(NAME+"."+"Perks."+p_three, 1);
								}
								catch (Exception e) {
									
								}
								}
							}
							else if (index == 8+add) {
								race = msgs[19];
								
								plugin.getConfig().set(NAME+"."+"Race", race);
							}
							else if (index == 6) {
								subclass = msgs[19];
								plugin.getConfig().set(NAME+"."+"Subclass", subclass);
							}
							else if (index == 13+add) {
								try {
									BG1 += "\"" + msgs[30] + " ";
								}
								catch (Exception e) {
									BG1 += "\"None\"";
								}
								AC = msgs[17];
								SPEED = msgs[25].replace(" ft", "");
								plugin.getConfig().set(NAME+"."+"AC", Integer.valueOf(AC));
								plugin.getConfig().set(NAME+"."+"Speed", Integer.valueOf(SPEED));
							}
							else if (index == 19+add) {
								try {
								BG2 += msgs[30] + "\"";
								}
								catch (Exception e) {
									BG2 += "\"";
								}
								
								DEX_M = msgs[2];
								plugin.getConfig().set(NAME+"."+"Dexterity.Modifier", Integer.valueOf(DEX_M));
								DEX_SAVE = msgs[8];
								plugin.getConfig().set(NAME+".Saves." + "DEX", Integer.valueOf(DEX_SAVE));
							}
							else if (index == 20+add) {
								CON_SAVE = msgs[8];
								plugin.getConfig().set(NAME+".Saves." + "CON", Integer.valueOf(CON_SAVE));
							}
							else if (index == 18+add) {
								try {
								BG2 += msgs[30] + " ";
								}
								catch (Exception e){
									BG2 += "\"";
								}
								STR_SAVE = msgs[8];
								HP = msgs[17];
								plugin.getConfig().set(NAME+"." + "HP", Integer.valueOf(HP));
								plugin.getConfig().set(NAME+".Saves." + "STR", Integer.valueOf(STR_SAVE));
								
							}
							else if (index == 14+add) {
								try {
								BG1 += msgs[30] + " ";
								}
								catch (Exception e) {
									BG1 += "\"";
								}
								STR_M = msgs[2];
								plugin.getConfig().set(NAME+"."+"Strength.Modifier", Integer.valueOf(STR_M));
							}
							else if (index == 17+add) {
								try {
									BG2 += "\""+msgs[30] + " ";
								}
								catch (Exception e){
									BG2 += "\"None\"";
								}
								HPMAX = msgs[20];
								plugin.getConfig().set(NAME+"."+"MaxHP", Integer.valueOf(HPMAX));
							}
							else if (index == 16+add) {
								STR = msgs[2];
								plugin.getConfig().set(NAME+"."+"Strength.Default", Integer.valueOf(STR));
							}
							else if (index == 12+add) {
								try {
								BG = msgs[35];
								}
								catch (Exception e) {
									BG = "None";
								}
								
								plugin.getConfig().set(NAME+"."+"BG", BG);
							}
							else if (index == 21+add) {
								
								INT_SAVE = msgs[8];
								DEX = msgs[2];
								try {
									BG3 += "\"" +msgs[30] + " ";
									}
								catch (Exception e){
									BG3 += "\"None\"";
								}
								
								
								plugin.getConfig().set(NAME+"."+"Dexterity.Default", Integer.valueOf(DEX));
								plugin.getConfig().set(NAME+".Saves." + "INT", Integer.valueOf(INT_SAVE));
	
							}
							else if (index == 22+add) {
								
								WIS_SAVE = msgs[8];
								try {
									BG3 += msgs[30] + " ";
									}
								catch (Exception e){
									BG3 += "\"";
								}
								
								plugin.getConfig().set(NAME+".Saves." + "WIS", Integer.valueOf(WIS_SAVE));
							}
							else if (index == 23+add) {
								
								CHA_SAVE = msgs[8];
								try {
								BG3 += msgs[30] + "\"";
								}
								catch (Exception e){
									BG3 += "\"";
								}
								plugin.getConfig().set(NAME+".Saves." + "CHA", Integer.valueOf(CHA_SAVE));
							}
							else if (index == 26+add) {
								
								DIE = msgs[17];
								
								plugin.getConfig().set(NAME+"."+"DIE", DIE);
								try {
								BG4 += msgs[30] + " ";
								}
								catch (Exception e) {
									BG4 += "\"";
								}
								CON = msgs[2];
								plugin.getConfig().set(NAME+"."+"Constitution.Default", Integer.valueOf(CON));
								ACR = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.ACR", Integer.valueOf(ACR));
								
							}
							else if (index == 25+add) {
								try {
								BG4 += "\"" +  msgs[30] + " ";
								}
								catch (Exception e) {
									BG4 += "\"None\"";
								}
							}
							else if (index == 27+add) {
								
								try {
								BG4 += msgs[30] + "\"";
								}
								catch (Exception e) {
									BG4 += "\"";
								}
								ANH = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.ANH", Integer.valueOf(ANH));
							}
							else if (index == 28+add) {
								ARC = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.ARC", Integer.valueOf(ARC));
							}
							else if (index == 29+add) {
								INT_M = msgs[2];
								plugin.getConfig().set(NAME+"."+"Intellect.Modifier", Integer.valueOf(INT_M));
								ATH = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.ATH", Integer.valueOf(ATH));
							}
							else if (index == 30+add) {
								
								DEC = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.DEC", Integer.valueOf(DEC));
							}
							else if (index == 32+add) {
								
								INS = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.INS", Integer.valueOf(INS));
							}
							else if (index == 33+add) {
								ITN = msgs[8];
								
								plugin.getConfig().set(NAME+"."+"Skills.ITN", Integer.valueOf(ITN));
							}
							else if (index == 34) {
								if (abc == false) {
								if (a == false) {
									try {
										if (msg.toString().contains("Medicine")) {

											MED = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
											a = true;
										}
									}
									catch (Exception e) {
										
									}
								}
								
								if (b == false) {
									try {
										if (msg.toString().contains("Investigation")) {
											WIS_M = msgs[2];
											INV = msgs[8];
											
											plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(WIS_M));
											
											plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
											b = true;
												}
									}
									catch (Exception e) {
										
									}
								}
								
								if (d == false) {
									if (msg.toString().contains("Nature")) {
										WIS = msgs[2];
										plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
										NTR = msgs[8];
										plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
										d = true;
									}
								}
								
								}
							}
							else if (index == 35) {
								if (abc == false) {
								if (a == false) {
									try {
										if (msg.toString().contains("Medicine")) {
											MED = msgs[8];
											
											plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
											a = true;
										}
										
									}
									catch (Exception e) {
										
									}
								}
								
								if (b == false) {
									try {
										if (msg.toString().contains("Investigation")) {
											WIS_M = msgs[2];
											INV = msgs[8];
											
											plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(WIS_M));
											
											plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
											b = true;
												}
									}
									catch (Exception e) {
										
									}
								}
								
								if (d == false) {
									if (msg.toString().contains("Nature")) {
										WIS = msgs[2];
										plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
										NTR = msgs[8];
										plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
										d = true;
									}
								}
								
								if (a == true && b == true) {
									abc = true;
									valz = 1;
								}
								}
							}
							
							else if (index == 36) {
								if (abc == false) {
								if (a == false) {
									try {
										if (msg.toString().contains("Medicine")) {

											MED = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
											a = true;
											
												}
										
									}
									catch (Exception e) {
									
									}
								}
								
								if (b == false) {
									try {
										if (msg.toString().contains("Investigation")) {
									WIS_M = msgs[2];
									INV = msgs[8];
									
									plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(WIS_M));
									
									plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
									b = true;
										}
									}
									catch (Exception e) {
										
									}
								}
								
								if (d == false) {
									if (msg.toString().contains("Nature")) {
										WIS = msgs[2];
										plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
										NTR = msgs[8];
										plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
										d = true;
									}
								}
								
								
								if (a == true || b == true) {
									if (a == false) {
										alt = 4;
									}
									else {
										alt = 0;
									}
									abc = true;
									valz = 2;
								}
								else {
									superadd = 1;
								}
								
								}
								
							}
							else if (abc == false &&index == 40-superadd && addagain2 == false|| abc==false && index == 38-superadd && addagain2 == false|| addagain2 == true && (index == 38-superadd+addagain || index == 40-superadd+addagain)) {
								if (index == 38-superadd && addagain2 == false || index == 38-superadd+addagain && addagain2 == true) {
									if (superadd > 0) {
										try {
										plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(msg.split(",,")[1].split(",,,")[0]));
										INV = msgs[8];
										plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
										}
										catch (Exception e) {
											addagain += 1;
											addagain2 = true;
										}
									}
									else {
									MED = msgs[8];
									plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
									
								}
								}
								try {
									if (index == 40-superadd || addagain2 == true &&  index == 40-superadd+addagain) {
									
									MED = msgs[8];
									plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
								}
								}
								
								catch (Exception e) {
									if (addagain2 == false) {
										addagain = 2;
									}
									else if (addagain2 == true){
										addagain = 3;
									}
										if (index == 40-superadd+addagain) {
											MED = msgs[8];
											plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
										}
								}
							}
							else if (index == 42-superadd+addagain) {
								try {
									PEC = msgs[8];
									plugin.getConfig().set(NAME+"."+"Skills.PEC", Integer.valueOf(PEC));
								}
								catch (Exception e) {
									addagain += 1;
								}
								
							}
							else if (index == 43-superadd+addagain) {
								
								PER = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.PER", Integer.valueOf(PER));
								
							}
							else if (index == 44-superadd+addagain) {
								
								
								CHR_M = msgs[2];
								plugin.getConfig().set(NAME+"."+"Charisma.Modifier", Integer.valueOf(CHR_M));
								PEN = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.PEN", Integer.valueOf(PEN));
								
							}
							else if (index == 45-superadd+addagain) {
								
								REG = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.REG", Integer.valueOf(REG));
								
							}
							else if (index == 41-superadd+addagain) {
								try {
								WIS = msgs[2];
								plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
								NTR = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
								}
								catch (Exception e) {
									
									addagain += 1;
								}
								
							}
							else if (index == 31+add) {
								
								HIS = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.HIS", Integer.valueOf(HIS));
								INT = msgs[2];
								plugin.getConfig().set(NAME+"."+"Intellect.Default", Integer.valueOf(INT));
							}
							else if (index == 55-superadd+addagain) {
								PF1 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								plugin.getConfig().set(NAME+"."+"Proficiencies.Armor", PF1);
							}
							else if (index == 56-superadd+addagain) {
								try {
								PF2 = "\""+ msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								}
								catch (Exception e) {
									
								}
								plugin.getConfig().set(NAME+"."+"Proficiencies.Weapon", PF2);
							}
							else if (index == 57-superadd+addagain) {
								try {
								PF3 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								}
								catch (Exception e) {
									
								}
								plugin.getConfig().set(NAME+"."+"Proficiencies.Vehicle", PF3);
							}
							else if (index == 58-superadd+addagain) {
								try {
									PF4 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								}
								
								catch (Exception e) {
									
								}
								plugin.getConfig().set(NAME+"."+"Proficiencies.2Tool", PF4);
							}
							else if (index == 59-superadd+addagain) {
								try {
								PF5 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								}
								catch (Exception e) {
									
								}
								plugin.getConfig().set(NAME+"."+"Proficiencies.Other", PF5);
							}
							else if (index == 60-superadd+addagain) {
								try {
								PF6 = "\""+msg.split(":,,,,,,")[1].split(",,")[0]+"\"";
								}
								catch (Exception e) {
									
								}
								plugin.getConfig().set(NAME+"."+"Proficiencies.Speeds", PF6);
							}
							else if (index == 46-superadd+addagain) {
								
								CHR = msgs[2];
								plugin.getConfig().set(NAME+"."+"Charisma.Default", Integer.valueOf(CHR));
								SoH = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.SoH", Integer.valueOf(SoH));
							}
							else if (index == 48-superadd+addagain) {
								
								SVL = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.SVL", Integer.valueOf(SVL));
								
							}
							else if (index == 15+add) {
								try {
								BG1 += msgs[30] + "\"";
								}
								catch (Exception e) {
									BG1 += "\"";
								}
								PB = msgs[7];
								plugin.getConfig().set(NAME+"."+"PB", Integer.valueOf(PB));
							}
							else if (index == 51-superadd+addagain) {
								PP = msgs[2];
								plugin.getConfig().set(NAME+"."+"PP", Integer.valueOf(PP));
							}
							else if (index == 47-superadd+addagain) {
								
								STH = msgs[8];
								plugin.getConfig().set(NAME+"."+"Skills.STH", Integer.valueOf(STH));
						
							}
							else if (index == 24+add) {
								CON_M = msgs[2];
								plugin.getConfig().set(NAME+"."+"Constitution.Modifier", Integer.valueOf(CON_M));
							}
							else if (index == 101+add) {
								try {
									cantripa = msgs[13];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
								}
								catch (Exception e) {
									
								}
								try {
									cantripb = msgs[23];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
								}
								catch (Exception e){
									
								}
								try {
								cantripc = msgs[36];
								plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
								}
								catch (Exception e) {
									
								}
								
							}
							else if (index == 102+add) {
								try {
									cantripa = msgs[13];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
								}
								catch (Exception e) {
									
								}
								try {
									cantripb = msgs[23];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
								}
								catch (Exception e){
									
								}
								try {
								cantripc = msgs[36];
								plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
								}
								catch (Exception e) {
									
								}
							}
							else if (index == 103+add) {
								try {
									cantripa = msgs[13];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripa, 1);
								}
								catch (Exception e) {
									
								}
								try {
									cantripb = msgs[23];
									plugin.getConfig().set(NAME+"."+"CanTrip."+cantripb, 1);
								}
								catch (Exception e){
									
								}
								try {
								cantripc = msgs[36];
								plugin.getConfig().set(NAME+"."+"CanTrip."+cantripc, 1);
								}
								catch (Exception e) {
									
								}
							}
							else if (index == 96+add) {
								spellability = msgs[20];
								plugin.getConfig().set(NAME+"."+"Spellcasting.spell_ability", spellability);
								spellsavedc = msgs[27];
								plugin.getConfig().set(NAME+"."+"Spellcasting.spell_savedc", spellsavedc);
								spellattackmodifier = msgs[34];
								plugin.getConfig().set(NAME+"."+"Spellcasting.spell_attackmodifier", spellattackmodifier);

							}
							else if (index >= 105+add && index < 110+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[3], 1);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[13], 1);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level1."+msgs[23], 1);
								}
								catch (Exception e) {
									
								}
								
								
								
							}
							else if (index >= 117+add && index < 122+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[3], 3);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[13], 3);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level3."+msgs[23], 3);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 128+add && index < 132+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[3], 5);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[13], 5);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level5."+msgs[23], 5);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 138+add && index < 141+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[3], 7);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[13], 7);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level7."+msgs[23], 7);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 146+add && index < 149+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[3], 9);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[13], 9);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level9."+msgs[23], 9);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 111+add && index < 116+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+msgs[13], 2);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+ msgs[23],2);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level2."+msgs[33], 2);
								}
								catch (Exception e) {
									
								}
								
								
								
							}
							else if (index >= 123+add && index < 127+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+msgs[13], 4);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+ msgs[23],4);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level4."+msgs[33], 4);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 133+add && index < 136+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+msgs[13], 6);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+ msgs[23],6);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level6."+msgs[33], 6);
								}
								catch (Exception e) {
									
								}
							}
							else if (index >= 142+add && index < 145+add) {
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+msgs[13], 8);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+ msgs[23],8);
								}
								catch (Exception e) {
									
								}
								try {
									plugin.getConfig().set(NAME+"."+"Spellcasting.level8."+msgs[33], 8);
								}
								catch (Exception e) {
									
								}
							}
							
						}
						
						plugin.getConfig().set(NAME+"."+"BG1", BG1.replace("'", ""));
						plugin.getConfig().set(NAME+"."+"BG2", BG2.replace("'", ""));
						plugin.getConfig().set(NAME+"."+"BG3", BG3.replace("'", ""));
						plugin.getConfig().set(NAME+"."+"BG4", BG4.replace("'", ""));
						plugin.getConfig().set(NAME+"."+"Owner", owner);
						plugin.getConfig().set(NAME+"."+"File", c);
						plugin.saveConfig();
						
						csv.close();
						break;
						}
						}
						
						catch (Exception e) {
							
						}
					}
					}
							catch (Exception e) {
								
							}
						}
					}
					catch (Exception e) {
						
					}
				} catch (FileNotFoundException e) {
					sender.sendMessage("Could not read file.");
				} //catch no stuff
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(sh)) {
			if (args.length > 0) {
				if (sender.isOp()) {
				if (args[0].contains("give")) {
					try {
						Player player = plugin.getServer().getPlayer(args[1]);
						String UID = UUID.randomUUID().toString().split("-")[0];
						CharBook charBook = new CharBook(plugin);
						String character = null;
						if (args[2].contains(".csv")) {
							String c;
							boolean go = false;
							for (Entry<String, Object> val: plugin.getConfig().getValues(false).entrySet()) {
								c = val.getKey();
								for (Entry<String, Object> val2: plugin.getConfig().getConfigurationSection(c).getValues(false).entrySet()) {
									if (val2.getKey().equals("File") && val2.getValue().equals(args[2])) {
										character = c;
										go = true;
										break;
									}
								}
							}
							if (go == false) {
								throw new Exception();
							}
						}
						else {
							character = args[2]+" "+args[3];
						}
						charBook.createBook(player, character, false, UID);
					}
					catch (Exception e) {
						sender.sendMessage("Could not load character for player");
					}
				}
				else if (args[0].contains("list")) {
					File files = new File(plugin.getDataFolder() + "/Spreadsheets/");
					sender.sendMessage("Files:");
					for (String file: files.list()) { 
						sender.sendMessage(file);
					}
				}
				}
			}
			else {
				CharBook charBook = new CharBook(plugin);
				Player player = (Player) sender;
				String character;
				boolean get = false;
				for (Entry<String, Object> val: plugin.getConfig().getValues(false).entrySet()) {
					character = val.getKey();
					for (Entry<String, Object> val2: plugin.getConfig().getConfigurationSection(character).getValues(false).entrySet()) {
						if (val2.getKey().equals("Owner") && val2.getValue().equals(player.getName())) {
							String UID = UUID.randomUUID().toString().split("-")[0];
							charBook.createBook(player, character, false, UID);
							get = true;
						}
					}

				}
				if (get == false) {
					sender.sendMessage("Cannot find user in files");
				}
				
				
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(desc)) {
			if (args.length >= 2) {
				String msg = "None";
				Object type_JSON;
				JSONObject typeJSON;
				String values = args[0].replaceAll("(.)([A-Z])", "$1 $2").replaceAll("(.)([0-9][a-z])", "$1 $2").replace("And ", "and ").replace("Of ", "of ").replace("In ", "in ").replace("( ", "(").replace("(", " (").trim();
				try {
					String type = args[1];
					if (type.toLowerCase().equals("race")) {
						type+="s";
					}
					type_JSON = new JSONParser().parse(new FileReader(plugin.getDataFolder() + "/Info/" +type.toLowerCase()+".json"));
					typeJSON = (JSONObject) type_JSON;
					if (type.equals("races")) {		
						String race = args[2].replaceAll("(.)([A-Z])", "$1 $2").replace("- ", "-").replace("High Elf", "High").replace("( ", " (");
						
						JSONArray races = (JSONArray) typeJSON.get("race");
						
						Iterator itr2 = races.iterator();
						
						JSONObject race_JSON = new JSONObject();
						boolean israce = false;
						while (itr2.hasNext()) {
							
				            Object result = itr2.next();
				           
				            if (result.toString().contains(race)) {
				            	israce = true;
				            	race_JSON.put("race", result);
				            }
				            else if (result.toString().contains("name") && israce == true) {
				            	israce = false;
				            }
				            if (israce == true) {
				            	
				            	boolean go = false;
				            	boolean abc = false;
				            	String value = "";
				            	for (int i = 0; i < result.toString().length(); i++) {
				            		if (result.toString().charAt(i) == '{') {
				            			go = true;
				            		}
				            		else if (result.toString().charAt(i) == ',' && result.toString().charAt(i-1) == '}' && !(result.toString().charAt(i+1) == '"')|| result.toString().charAt(i) == ']' && result.toString().charAt(i-1) == '}') {
				            			if (result.toString().charAt(i) == ',' && result.toString().charAt(i-1) == '}' && !(result.toString().charAt(i+1) == '"')) {
				            				abc = true;
				            			}
				            			value += result.toString().charAt(i);
				            			if (value.contains(values)) {
				            				boolean go2 = false;
				            				String finished = "";
				            				for (int i2 = 0; i2 < value.length(); i2++) {
				            					if (go2 == true) {
							            			finished += value.charAt(i2);
							            		}
				            					if (value.charAt(i2) == '[') {
				            						
							            			go2 = true;
							            		}
				            					else if (value.charAt(i2) == ']') {
				            						if (abc == true) {
				            							abc = false;
				            						}
				            						else {
				            						go2 = false;
				            						sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", ""));
							            			return true;
				            						}
							            		}
				            					
				            				}
				            				break;
				            			}
				            				
				            			value = "";
				            			go = false;
				            			
				            		}
				            		if (go == true) {
				            			value += result.toString().charAt(i);
				            		}
				            	}
				            }
				            
				         }
						
						itr2 = races.iterator();
						
						race_JSON = new JSONObject();
						israce = false;
						while (itr2.hasNext()) {
							
				            Object result = itr2.next();
				           
				            if (result.toString().contains(race)) {
				            	israce = true;
				            	race_JSON.put("race", result);
				            }
				            else if (result.toString().contains("name") && israce == true) {
				            	israce = false;
				            }
				            if (israce == true) {
				            	
				            	boolean go = false;
				            	String value = "";
				            	for (int i = 0; i < result.toString().length(); i++) {
				            		if (result.toString().charAt(i) == '{') {
				            			go = true;
				            		}
				            		else if (result.toString().charAt(i) == ',' && result.toString().charAt(i-1) == '}'|| result.toString().charAt(i) == ']' && result.toString().charAt(i-1) == '}') {
				            			value += result.toString().charAt(i);
				            			if (value.contains(values)) {
				            				boolean go2 = false;
				            				String finished = "";
				            				for (int i2 = 0; i2 < value.length(); i2++) {
				            					if (go2 == true) {
							            			finished += value.charAt(i2);
							            		}
				            					if (value.charAt(i2) == '[') {
				            						
							            			go2 = true;
							            		}
				            					else if (value.charAt(i2) == ']') {

				            						go2 = false;
				            						sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", ""));
							            			return true;
							            		}
				            					
				            				}
				            				break;
				            			}
				            				
				            			value = "";
				            			go = false;
				            			
				            		}
				            		if (go == true) {
				            			value += result.toString().charAt(i);
				            		}
				            	}
				            }
				            
				         }
						
						races = (JSONArray) typeJSON.get("subrace");
						itr2 = races.iterator();
						
						race_JSON = new JSONObject();
						israce = false;
						while (itr2.hasNext()) {
							
				            Object result = itr2.next();
				           
				           
				            if (result.toString().contains(race+"\"")) {
				            	israce = true;
				            	race_JSON.put("subrace", result);
				            }
				            else if (result.toString().contains("name") && israce == true) {
				            	israce = false;
				            }
				            if (israce == true) {
				            	 
				            	boolean go = false;
				            	String value = "";
				            	for (int i = 0; i < result.toString().length(); i++) {
				            		if (result.toString().charAt(i) == '{') {
				            			go = true;
				            		}
				            		else if (result.toString().charAt(i) == ',' && result.toString().charAt(i-1) == '}' && result.toString().charAt(i-2) == '"'|| result.toString().charAt(i) == ']' && result.toString().charAt(i-1) == '}') {
				            			value += result.toString().charAt(i);
				            			if (value.contains(values)) {
				            				boolean go2 = false;
				            				String finished = "";
				            				for (int i2 = 0; i2 < value.length(); i2++) {
				            					if (go2 == true) {
							            			finished += value.charAt(i2);
							            		}
				            					if (value.charAt(i2) == '[') {
				            						
							            			go2 = true;
							            		}
				            					else if (value.charAt(i2) == ']') {

				            						go2 = false;
				            						sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", ""));
							            			return true;
							            		}
				            					
				            				}
				            				break;
				            			}
				            				
				            			value = "";
				            			go = false;
				            			
				            		}
				            		if (go == true) {
				            			value += result.toString().charAt(i);
				            		}
				            	}
				            }
				            
				         }
					}
					else {
						JSONArray vals = (JSONArray) typeJSON.get("classFeature");
						Iterator itr2 = vals.iterator();
						
						JSONArray vals2 = (JSONArray) typeJSON.get("subclassFeature");
						Iterator itr2b = vals2.iterator();
						
						JSONObject val_JSON = new JSONObject();
						boolean isval = false;
						String finished = "";
						while (itr2.hasNext()) {
				           Object result = itr2.next();
				           
				           if (result.toString().toLowerCase().contains(values.toLowerCase())) {
				        	   int add =0;
	            				for (int i2 = 0; i2 < result.toString().length(); i2++) {
	            					if (isval == true) {
				            			finished += result.toString().charAt(i2);
				            			if (finished.toLowerCase().contains("\"4th\"")  || finished.toLowerCase().contains("\"5th\"") || finished.toLowerCase().contains("\"6th\"")||finished.toLowerCase().contains("\"2nd\"") ||finished.toLowerCase().contains("\"3rd\"") ||finished.toLowerCase().contains("subclassfeature") || finished.toLowerCase().contains("collabels")|| finished.toLowerCase().contains("spell level")|| finished.toLowerCase().contains("text-center") || finished.toLowerCase().contains("\"1st\"") ) {
		            						finished = "";
		            						isval = false;
					            		}
				            		}
	            					
	            					if (result.toString().charAt(i2) == '[') {
	            						isval = true;
	            						add += 1;
				            		}
	            					else if (result.toString().charAt(i2) == ']' && isval == true) {
	            						add -= 1;
	            						if (add == 0) {
	            						
	            						isval = false;
	            						sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", "").replace("{entries:", "").replace(",{style:list-hang-notitle,type:list,items:", " "));
				            			return true;
	            						}
				            		}
	            					
	            				}
				           
				           }
						}
						while (itr2b.hasNext()) {
					           Object result = itr2b.next();
					           
					           if (result.toString().toLowerCase().contains(values.toLowerCase())) {
					           
		            				for (int i2 = 0; i2 < result.toString().length(); i2++) {
		            					if (isval == true) {
					            			finished += result.toString().charAt(i2);
					            			if (finished.toLowerCase().contains("\"4th\"")  || finished.toLowerCase().contains("\"5th\"") || finished.toLowerCase().contains("\"6th\"")||finished.toLowerCase().contains("\"2nd\"") ||finished.toLowerCase().contains("\"3rd\"") ||finished.toLowerCase().contains("subclassfeature") || finished.toLowerCase().contains("collabels") || finished.toLowerCase().contains("spell level")|| finished.toLowerCase().contains("text-center") || finished.toLowerCase().contains("\"1st\"") ) {
			            						finished = "";
			            						isval = false;
						            		}
					            		}
		            					
		            					if (result.toString().charAt(i2) == '[') {
		            						isval = true;
					            		}
		            					else if (result.toString().charAt(i2) == ']' && isval == true) {
		            						isval = false;
		            						sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", "").replace("{entries:", "").replace(",{style:list-hang-notitle,type:list,items:", " "));
		            						return true;
					            		}
		            					
		            				}
					           
					           }
					           
						}
						
					}
				}
				catch (IOException | ParseException e) {
					boolean dont = false;
					try {
						for (Object val: Files.list(Paths.get(plugin.getDataFolder() + "/Info/Spellcasting")).toArray()) {
						type_JSON = new JSONParser().parse(new FileReader(val.toString()));
						typeJSON = (JSONObject) type_JSON;
						JSONArray vals = (JSONArray) typeJSON.get("spell");
						
						String time = "";
						String range = "";
						String components = "";
						String duration = "";
						Iterator itr2 = vals.iterator();
						while (itr2.hasNext()) {
							Object result = itr2.next();
							if (result.toString().contains("\""+values+"\"")) {
								String res = result.toString();
								Object type_JSON_VALZ = new JSONParser().parse(res);
								JSONObject typeJSON_VALZ = (JSONObject) type_JSON_VALZ;
								JSONArray t = (JSONArray) typeJSON_VALZ.get("time");
								String t_num = t.toString().split("\"number\":")[1].split(",")[0];
								String t_type = t.toString().split("\"unit\":")[1].split("\"")[1];
								String t_condtion = "";
								try {
									t_condtion = ", "+t.toString().split("\"condition\":")[1].split("\"")[1];
								}
								catch (Exception e2) {
									
								}
								sender.sendMessage("Time: "+t_num + " " + t_type + t_condtion);
								Object r = typeJSON_VALZ.get("range");
								String r_type;
								r_type = r.toString().split("\"distance\":")[1].split("\"type\":")[1].split("\"")[1];
								sender.sendMessage("Range: "+r_type);
								Object c = typeJSON_VALZ.get("components");
								sender.sendMessage("Components: "+c.toString().replace("true", "").replace(":", "").replace("{", "").replace("}", "").replace("\"", "").replace(",", ", ").toUpperCase());
								JSONArray d = (JSONArray) typeJSON_VALZ.get("duration");
								String d_time = "";
								try {
								d_time = d.toString().split("\"amount\":")[1].split(",")[0] + " ";
								}
								catch (Exception e2) {
									
								}
								String d_type = d.toString().split("\"type\":")[1].split("\"")[1];
								sender.sendMessage("Duration: " + d_time + d_type);
								
							}
						}
						
						itr2 = vals.iterator();
						
						JSONObject val_JSON = new JSONObject();
						boolean isval = false;
						String finished = "";
						boolean done = false;
						while (itr2.hasNext() && done != true) {
						   Object result = itr2.next();
						   
						   if (result.toString().contains("\""+values+"\"") && dont == false) {
							  String newresult= result.toString().replace("\"entriesHigherLevel\":[{\"entries\":[\"", "\"entHigherLevel\":{\"entHigherLevel\":[\'").replace("\"],\"name\":\"At Higher Levels\",\"type\":\"entries\"}]", "'}");
							  for (int i2 = 0; i2 < newresult.toString().length(); i2++) {
								  
									if (isval == true) {
						    			finished += newresult.toString().charAt(i2);
						    			
						    			if (finished.contains("\"duration\":") || finished.contains("SGT") || finished.contains("\"source\":") || finished.contains("\"type\":") || finished.contains("MAC") || finished.contains("{subclassFeature")) {
						    				finished = "";
											isval = false;
						        		}
						    		}
									
									if (newresult.toString().charAt(i2) == '[') {
										isval = true;
						    		}
									else if (newresult.toString().charAt(i2) == ']' && isval == true) {
										if (finished.split(" ").length > 1) {
										isval = false;
										sender.sendMessage( values+": "+"\n"+finished.replace("\"", "").replace("[", "").replace("]", "").replace("{entries:", "").replace(",{style:list-hang-notitle,type:list,items:", " "));
										done = true;
										break;
										}
										else {
											finished = "";
										}
						    		}
									
								}
							  
						   }
						}
						}
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				return true;	
			}
		}
		return false;
	}
}
