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

import user.uziza.SheetImporter.Main;
import user.uziza.SheetImporter.Items.CharBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
	
	Main plugin;
	public SheetImporterCommands(Main plugin) {
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
				if (args[1].contains(".profile")) {
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
					String NAME = null;
					
					if (args.length == 0 || args[0].equals("all")) {
						for (String c: new File(plugin.getDataFolder() + "/Spreadsheets/").list()) {
							if (c.contains(".html") && !c.contains("/") && !c.contains("~")) {
								characters.add(c);
							}
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
								characters.remove(file.replace(".profile", ".html").trim());
							}
						}
					}
					else if (!args[0].equals("all")) {
						boolean works = false;
						
						if (args[0].contains(".html") && !args[0].contains("/") && !args[0].contains("~")) {
							for (String c: new File(plugin.getDataFolder() + "/Spreadsheets/").list()) {
								if (args[0].equals(c)) {
									works = true;
									characters.add(args[0]);
								}
							}
							if (works == false) {
								throw new FileNotFoundException();
							}
						}
						
						if (args.length > 1) {
							if (plugin.getServer().getPlayer(args[1]) != null) {
								owner = args[1];
							}
						}
					}
					for (String character: characters) {
						FileReader FR = new FileReader(new File(plugin.getDataFolder() + "/Spreadsheets/" + character));
						BufferedReader buf= new BufferedReader(FR);
						StringBuilder content=new StringBuilder(1024);
						
						try {
							String val;
							while ((val = buf.readLine()) != null) {
								content.append(val);
				            }
							FR.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						String[] result=content.toString().split("<tbody>")[1].split("</tbody>")[0].split("</tr>");
						String CLASS = null;
						String SUBCLASS = null;
						Integer LEVEL = null;
						String RACE = null;
						Boolean runperks = false;
						List<String> perks = new ArrayList<String>();
						Integer AC = null;
						Integer SPEED = null;
						Integer DEX_MOD = null;
						Integer DEX_SAVE = null;
						Integer CON_SAVE = null;
						Integer HP = null;
						Integer STR_SAVE = null;
						Integer STR_MOD = null;
						Integer HPMAX = null;
						Integer STR = null;
						String BG = null;
						Integer CHA_SAVE = null;
						Integer CON = null;
						Integer DEX = null;
						String DIE = null;
						Integer INT_SAVE = null;
						Integer WIS_SAVE = null;
						Integer ACR = null;
						Integer ANH = null;
						Integer ARC = null;
						Integer INT_MOD = null;
						Integer ATH = null;
						Integer DEC = null;
						Integer CHA_MOD = null;
						Integer INS = null;
						Integer HIS = null;
						Integer INT = null;
						Integer ITN = null;
						Integer INV = null;
						Integer MED = null;
						Integer WIS = null;
						Integer WIS_MOD = null;
						Integer NTR = null;
						Integer PEN = null;
						Integer PER = null;
						Integer REG = null;
						Integer PEC = null;
						Boolean runweapon = false;
						List<List<String>> weapons = new ArrayList<List<String>>();
						List<String> PF = new ArrayList<String>();
						boolean runprof = false;
						Integer CHR = null;
						Integer SoH = null;
						Integer STH = null;
						Integer SVL = null;
						Integer PP = null;
						Integer PB = null;
						Integer CON_MOD = null;
						Boolean runcan = false;
						Integer cans = 0;
						List<String> cantrips = new ArrayList<String>();
						String spell_ability = null;
						Integer spell_attackmod = null;
						Integer spell_savedc = null;
						boolean runspells = false;
						List<List<String>> spellLevels = new ArrayList<List<String>>();
						List<String> spells = new ArrayList<String>();
						Integer level = 1;
						Integer level_mul = 6;
						boolean level_init = true;
						Integer lvl = 1;
						Integer lvls = 0;
						boolean alt = false;
						String BG1 = "";
						String BG2 = "";
						String BG3 = "";
						String BG4 = "";
						
						//int add_error = 0;
						for (String res: result) {
							
							if (res.contains("\"359784640R4\"")) {
								try {
								CLASS = res.split("<td class=\"s7\" dir=\"ltr\" colspan=\"11\">")[1].split("</td>")[0].split(" ")[res.split("<td class=\"s7\" dir=\"ltr\" colspan=\"11\">")[1].split("</td>")[0].split(" ").length-2];
								SUBCLASS = res.split("<td class=\"s7\" dir=\"ltr\" colspan=\"11\">")[1].split("</td>")[0].split(" "+CLASS)[0];
								}
								catch (Exception e) {
									//add_error += 1;
									
									CLASS = res.split("<td class=\"s7 softmerge\" dir=\"ltr\"")[1].split("</td>")[0].split(" / ")[1];
									SUBCLASS = res.split("<td class=\"s7 softmerge\" dir=\"ltr\"")[1].split("</td>")[0].split(" / ")[0];
									NAME = res.split("<td class=\"s11\" dir=\"ltr\" colspan=\"6\">")[1].split("</td>")[0];
								}
								
							}
							else if (res.contains("\"359784640R5\"")) {
								try {
								NAME = res.split("<td class=\"s12\" dir=\"ltr\" colspan=\"16\" rowspan=\"2\">")[1].split("</td>")[0];
								LEVEL = Integer.valueOf(res.split("<td class=\"s15\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0]);
								}
								catch (Exception e) {
									LEVEL = Integer.valueOf(res.split("<td class=\"s21\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0]);
								}
								
							}
							else if (res.contains("\"359784640R6\"")) {
								try {
								RACE = res.split("<td class=\"s16\" dir=\"ltr\" colspan=\"11\">")[1].split("</td>")[0];
								}
								catch (Exception e) {
									RACE = res.split("<td class=\"s22\" dir=\"ltr\" colspan=\"11\">")[1].split("</td>")[0];
								}
							}
							else if (res.contains("\"359784640R10\"")) {
								BG = res.split("BACKGROUND:</td>")[1].split("\">")[1].split("</td>")[0];
							}
							else if (res.contains("\"359784640R11\"")) {
								try {
								AC = Integer.valueOf(res.split("<td class=\"s42\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0]);
								SPEED = Integer.valueOf(res.split("<td class=\"s43\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0].split(" ")[0]);
								BG1 += res.split("\">")[11].split("</td>")[0];
								if (!BG1.isBlank()) {
									BG1 += " ";
								}
								}
								catch (Exception e) {
									AC = Integer.valueOf(res.split("<td class=\"s48\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0]);
									SPEED = Integer.valueOf(res.split("<td class=\"s49\" colspan=\"2\" rowspan=\"2\">")[1].split("</td>")[0].split(" ")[0]);
									BG1 += res.split("\">")[11].split("</td>")[0];
									if (!BG1.isBlank()) {
										BG1 += " ";
									}
								}
							}
							else if (res.contains("\"359784640R12\"")) {
								STR_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								BG1 += res.split("\">")[15].split("</td>")[0];
								if (!BG1.isBlank()) {
									BG1 += " ";
								}
							}
							else if (res.contains("\"359784640R13\"")) {
								PB = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								BG1 += res.split("\">")[14].split("</td>")[0];
								if (!BG1.isBlank()) {
									BG1 += " ";
								}
							}
							else if (res.contains("\"359784640R14\"")) {
								STR = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R15\"")) {
								BG2 += res.split("\">")[19].split("</td>")[0];
								if (!BG2.isBlank()) {
									BG2 += " ";
								}
								HPMAX = Integer.valueOf(res.split("\">")[17].split("</td>")[0]);
								try {
									HP = Integer.valueOf(res.split("<td class=\"s62\" colspan=\"7\">")[1].split("</td>")[0]);
									
								}
								catch (Exception e) {
									HP = Integer.valueOf(res.split("<td class=\"s56\" colspan=\"7\">")[1].split("</td>")[0]);
								}
							}
							else if (res.contains("\"359784640R16\"")) {
								BG2 += res.split("\">")[13].split("</td>")[0];
								if (!BG2.isBlank()) {
									BG2 += " ";
								}
								STR_SAVE = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
								try {
								HP = Integer.valueOf(res.split("\">")[11].split("</td>")[0]);
								}
								catch (Exception e) {
									
								}
							}
							else if (res.contains("\"359784640R17\"")) {
								BG2 += res.split("\">")[12].split("</td>")[0];
								if (!BG2.isBlank()) {
									BG2 += " ";
								}
								DEX_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								DEX_SAVE = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R18\"")) {
								CON_SAVE = Integer.valueOf(res.split("\">")[7].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R19\"")) {
								BG3 += res.split("\">")[14].split("</td>")[0];
								if (!BG3.isBlank()) {
									BG3 += " ";
								}
								DEX = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								INT_SAVE = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R20\"")) {
								BG3 += res.split("\">")[14].split("</td>")[0];
								if (!BG3.isBlank()) {
									BG3 += " ";
								}
								WIS_SAVE = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R21\"")) {
								BG3 += res.split("\">")[12].split("</td>")[0];
								if (!BG3.isBlank()) {
									BG3 += " ";
								}
								CHA_SAVE = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R22\"")) {
								CON_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R23\"")) {
								BG4 += res.split("\">")[21].split("</td>")[0];
								if (!BG4.isBlank()) {
									BG4 += " ";
								}
							}
							else if (res.contains("\"359784640R24\"")) {
								DIE = res.split("\">")[17].split("</td>")[0];
								BG4 += res.split("\">")[23].split("</td>")[0];
								if (!BG4.isBlank()) {
									BG4 += " ";
								}
								CON = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								ACR = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R25\"")) {
								BG4 += res.split("\">")[23].split("</td>")[0];
								if (!BG4.isBlank()) {
									BG4 += " ";
								}
								ANH = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R26\"")) {
								ARC = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R27\"")) {
								INT_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								ATH = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R28\"")) {
								DEC = Integer.valueOf(res.split("\">")[7].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R29\"")) {
								HIS = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
								INT = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R30\"")) {
								INS = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R31\"")) {
								runweapon = true;
								ITN = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R32\"")) {
								WIS_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								INV = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R33\"")) {
								MED = Integer.valueOf(res.split("\">")[7].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R34\"")) {
								WIS = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								NTR = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R35\"")) {
								PEC = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R36\"")) {
								runweapon = false;
								PER = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R37\"")) {
								PEN = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
								CHA_MOD = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R38\"")) {
								REG = Integer.valueOf(res.split("\">")[7].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R39\"")) {
								CHR = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
								SoH = Integer.valueOf(res.split("\">")[8].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R40\"")) {
								STH = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R41\"")) {
								try {
								SVL = Integer.valueOf(res.split("\">")[9].split("</td>")[0]);
								}
								catch (Exception e) {
									SVL = Integer.valueOf(res.split("\">")[10].split("</td>")[0]);
								}
							}
							else if (res.contains("\"359784640R44\"")) {
								PP = Integer.valueOf(res.split("\">")[5].split("</td>")[0]);
							}
							else if (res.contains("\"359784640R48\"")) {
								runprof = true;
							}
							else if (res.contains("\"359784640R54\"")) {
								runprof = false;
							}
							else if(res.contains("\"359784640R58\"")) {
								runperks = true;
							}
							else if (res.contains("\"359784640R83\"")) {
								runperks = false;
							}
							else if (res.contains("\"359784640R90\"")) {
								String val = null;
								for (Integer i = 0; i < 3; i++) {
									Integer num = null;
									if (res.split("\">")[7+i].split("</td>")[0] == "-" && i == 0) {
										val = "None";
									}
									else {
										val = res.split("\">")[7+i].split("</td>")[0];
									}
									
									if (i > 0){
										try {
											num = Integer.valueOf(res.split("\">")[7+i].split("</td>")[0]);
										}
										catch (Exception e) {
											num = 0;
										}
									}
									
									if (i == 0) {
										spell_ability = val;
									}
									else if (i == 1) {
										spell_attackmod = num;
									}
									else if (i == 2) {
										spell_savedc = num;
									}
								}
								
								
								
							}
							else if (res.contains("\"359784640R95\"")) {
								runperks = false;
								runcan = true;
								cans = 0;
							}
							else if (res.contains("\"359784640R98\"")) {
								runcan = false;
							}
							else if (res.contains("\"359784640R99\"")) {
								runspells = true;
							}
							else if (res.contains("\"359784640R144\"")) {
								runspells = false;
							}
							
							if (runspells == true) {
								int s1 = 1;
								int s2 = 2;
								int s3 = 9;
								String res_rep = res.replaceAll("<div class=\"softmerge-inner\" style=\"[0-9A-z:;-]*\">", "");
									if (alt == false) {
										if (level_init == true) {
											
											if (res_rep.replace("</div>", "").split("\">")[8+1].split("</td>")[0].contains("<")) {
												s1 = 0;
												s2 = 0;
												s3 = 0;
											}
											else {
												if (level == 3 || level == 5) {
													s1 = 1;
													s2 = 2;
													s3 = 3;
												}
												else if (level == 7 || level == 9) {
													s1 = 1;
													s2 = 2;
													s3 = 3;
												}
											}
											
											spells.add(res_rep.replace("</div>", "").split("\">")[8+s1].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[12+s2].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[16+s3].split("</td>")[0]);
											level_init = false;
										}
										else {
											spells.add(res_rep.replace("</div>", "").split("\">")[6].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[8].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[10].split("</td>")[0]);
										}
									}
									else {
										if (level_init == true) {
											boolean addthis = true;
											
											try {
												int a1 = 4;
												int a2 = 5;
												int a3 = 6;
												if (level == 2) {
													a1 = 4;
													a2 = 11;
													a3 = 12;
												}
												else if (level == 8) {
													a1 = 4;
													a2 = 5;
													a3 = 6;
												}
											spells.add(res_rep.replace("</div>", "").split("\">")[25+a3].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[21+a2].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[17+a1].split("</td>")[0]);
											
											}
											catch (Exception e) {
												spells.add(res_rep.replace("</div>", "").split("\">")[17].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[21].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[25].split("</td>")[0]);
											}
											level_init = false;
										}
										else {
											if (lvls == 1) {
											spells.add(res_rep.replace("</div>", "").split("\">")[9].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[11].split("</td>")[0]);
											spells.add(res_rep.replace("</div>", "").split("\">")[13].split("</td>")[0]);
											}
											else if (lvls == 2) {
												spells.add(res_rep.replace("</div>", "").split("\">")[7].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[9].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[11].split("</td>")[0]);
											}
											else if (lvls == 3) {
												spells.add(res_rep.replace("</div>", "").split("\">")[11].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[13].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[15].split("</td>")[0]);
											}
											else if (lvls == 4) {
												spells.add(res_rep.replace("</div>", "").split("\">")[16].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[18].split("</td>")[0]);
												spells.add(res_rep.replace("</div>", "").split("\">")[20].split("</td>")[0]);
											}
										}
										lvls += 1;
									}
									if (res.contains("\"359784640R" + String.valueOf(99+(level*level_mul)-lvl) +"\"")) {
										spellLevels.add(spells);
										spells = new ArrayList<String>();
										if (alt == false) {
											alt = true;
										}
										else {
											alt = false;
										}
										level_init = true;
										
										level += 1;
										if (level>=4) {
											lvl += 1;
										}
										if (level>=7) {
											lvl += 1;
										}
										lvls = 0;
									}
				
							}
							
							if (runprof == true) {
								String prof = "None";
								try {
									prof = res.split("\">")[6].split("</td>")[0];
								}
								catch (Exception e ) {

								}
								finally {
									if (prof.isBlank()) {
										prof = "None";
									}
									PF.add(prof);
								}
							}
							
							if (runweapon == true) {
								String weapon = null;
								String bonus = null;
								String weapon_info = null;
								String weapon_desc = null;
								String weapon_dmg = null;
								String weapon_atk = null;
								String weapon_type = "";
								List<String> wep = new ArrayList<String>();
								try {
									bonus = res.split("colspan=\"3\">")[1].split("</td>")[0];
									weapon = res.split("colspan=\"6\">")[1].split("</td>")[0];
									weapon_info = res.split("colspan=\"12\">")[1].split("<br>")[0].replace("\"", "");
									weapon_desc = weapon_info.split("\\|")[1].replace("*", "");
									weapon_dmg = weapon_info.split("\\[")[0];
									weapon_atk = weapon_info.split("\\[")[1].split("\\]")[0];
									wep.add(weapon);
									wep.add(weapon_desc);
									
									if (weapon_desc.toLowerCase().contains("melee")) {
										if (weapon_type.length() > 0) {
											weapon_type += "/Melee";
										}
										else {
											weapon_type += "Melee";
										}
									}
									if (weapon_desc.toLowerCase().contains("range")) {
										if (weapon_type.length() > 0) {
											weapon_type += "/Ranged";
										}
										else {
											weapon_type += "Ranged";
										}
									}
									if (weapon_desc.toLowerCase().contains("spell")) {
										if (weapon_type.length() > 0) {
											weapon_type += "/Spell";
										}
										else {
											weapon_type += "Spell";
										}
										
									}

									
									wep.add(weapon_type);
									wep.add(weapon_dmg);
									wep.add(weapon_atk);
									wep.add(bonus);
									
								}
								catch (Exception e) {
									
								}
								finally {
									if (wep.size() == 6) {
										weapons.add(wep);
									}
								}
							}
							
							if (runperks == true) {
								String one = "";
								String two = "";
								String three = "";
								try {
									one = res.split("colspan=\"12\">")[1].split("</td>")[0];
									two = res.split("colspan=\"12\">")[2].split("</td>")[0];
									three = res.split("colspan=\"12\">")[3].split("</td>")[0];
								}
								finally {
									if (!one.isBlank()) {
										perks.add(one);
									}
									if (!two.isBlank()) {
										perks.add(two);
									}
									if (!three.isBlank()) {
										perks.add(three);
									}
								}
							}
							
							if (runcan == true) {
								String res_rep = res.replaceAll("<div class=\"softmerge-inner\" style=\"[0-9A-z:;-]*\">", "");
								String one_c = "";
								String two_c = "";
								String three_c = "";
								int sub_can1 = 0;
								int sub_can2 = 9;
								int sub_can3 = 10;
								boolean addthis = true;
								int add = 0;
								try {
									if (cans == 0) {
										one_c = res_rep.split("\">")[16+sub_can1].split("</td>")[0].replace("</div>", "");
										
										if (one_c.contains("<")) {
											one_c = res_rep.split("\">")[16].split("</td>")[0].replace("</div>", "");
											sub_can2 = 0;
											sub_can3 = 0;
										}

										two_c = res_rep.split("\">")[20+sub_can2].split("</td>")[0].replace("</div>", "");
										three_c = res_rep.split("\">")[24+sub_can3].split("</td>")[0].replace("</div>", "");
									}
									else if (cans == 1) {
										if (sub_can2 != 0) {
											sub_can2 = 6;
											sub_can3 = 6;
										}
										one_c = res_rep.split("\">")[8].split("</td>")[0].replace("</div>", "");
										two_c = res_rep.split("\">")[10+sub_can2].split("</td>")[0].replace("</div>", "");
										three_c = res_rep.split("\">")[12+sub_can3].split("</td>")[0].replace("</div>", "");
									}
									else if (cans == 2) {
										if (sub_can2 != 0) {
											sub_can2 = 8;
											sub_can3 = 4;
										}
										one_c = res_rep.split("\">")[7].split("</td>")[0].replace("</div>", "");
										two_c = res_rep.split("\">")[9+sub_can2].split("</td>")[0].replace("</div>", "");
										three_c = res_rep.split("\">")[11+sub_can3].split("</td>")[0].replace("</div>", "");
									}
								}
								catch (Exception e) {
									
								}
								finally {
									cans += 1;
									if (!one_c.isBlank()) {
										cantrips.add(one_c);
									}
									if (!two_c.isBlank()) {
										cantrips.add(two_c);
									}
									if (!three_c.isBlank()) {
										cantrips.add(three_c);
									}
								}
							}
						}
						
						plugin.getConfig().set(NAME, null);
						plugin.getConfig().set(NAME+"."+"Level", LEVEL);
						plugin.getConfig().set(NAME+"."+ "Class", CLASS.split("<")[0].replaceAll("[0-9]*", "").trim());
						if (SUBCLASS.contains("\">")) {
							SUBCLASS = SUBCLASS.split("\">")[1].replaceAll("[0-9]*", "").trim();
						}
						plugin.getConfig().set(NAME+"."+"Subclass", SUBCLASS);
						plugin.getConfig().set(NAME+"."+"Race", RACE);
						for (String perk: perks) {
							plugin.getConfig().set(NAME+"."+"Perks."+perk, 1);
						}
						plugin.getConfig().set(NAME+"."+"AC", AC);
						plugin.getConfig().set(NAME+"."+"Speed", SPEED);
						plugin.getConfig().set(NAME+"."+"Dexterity.Modifier", DEX_MOD);
						plugin.getConfig().set(NAME+".Saves." + "DEX", Integer.valueOf(DEX_SAVE));
						plugin.getConfig().set(NAME+".Saves." + "CON", Integer.valueOf(CON_SAVE));
						plugin.getConfig().set(NAME+"." + "HP", Integer.valueOf(HP));
						plugin.getConfig().set(NAME+".Saves." + "STR", Integer.valueOf(STR_SAVE));

						plugin.getConfig().set(NAME+"."+"Strength.Modifier", Integer.valueOf(STR_MOD));
						plugin.getConfig().set(NAME+"."+"MaxHP", Integer.valueOf(HPMAX));
						plugin.getConfig().set(NAME+"."+"Strength.Default", Integer.valueOf(STR));
						plugin.getConfig().set(NAME+"."+"BG", BG);

						plugin.getConfig().set(NAME+"."+"Dexterity.Default", Integer.valueOf(DEX));
						plugin.getConfig().set(NAME+".Saves." + "INT", Integer.valueOf(INT_SAVE));

						plugin.getConfig().set(NAME+".Saves." + "WIS", Integer.valueOf(WIS_SAVE));

						plugin.getConfig().set(NAME+".Saves." + "CHA", Integer.valueOf(CHA_SAVE));

						plugin.getConfig().set(NAME+"."+"DIE", DIE);
						plugin.getConfig().set(NAME+"."+"Constitution.Default", Integer.valueOf(CON));

						
						plugin.getConfig().set(NAME+"."+"Skills.ACR", Integer.valueOf(ACR));
						plugin.getConfig().set(NAME+"."+"Skills.ANH", Integer.valueOf(ANH));
						plugin.getConfig().set(NAME+"."+"Skills.ARC", Integer.valueOf(ARC));
						plugin.getConfig().set(NAME+"."+"Intellect.Modifier", Integer.valueOf(INT_MOD));
						plugin.getConfig().set(NAME+"."+"Skills.ATH", Integer.valueOf(ATH));
						plugin.getConfig().set(NAME+"."+"Skills.DEC", Integer.valueOf(DEC));

						plugin.getConfig().set(NAME+"."+"Skills.INS", Integer.valueOf(INS));
						plugin.getConfig().set(NAME+"."+"Skills.ITN", Integer.valueOf(ITN));
						plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
						plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(WIS_MOD));
						plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
						plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
						plugin.getConfig().set(NAME+"."+"Skills.PEC", Integer.valueOf(PEC));
						plugin.getConfig().set(NAME+"."+"Skills.PER", Integer.valueOf(PER));
						plugin.getConfig().set(NAME+"."+"Charisma.Modifier", Integer.valueOf(CHA_MOD));
						plugin.getConfig().set(NAME+"."+"Skills.PEN", Integer.valueOf(PEN));
						plugin.getConfig().set(NAME+"."+"Skills.REG", Integer.valueOf(REG));
						plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
						plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
						plugin.getConfig().set(NAME+"."+"Skills.HIS", Integer.valueOf(HIS));
						plugin.getConfig().set(NAME+"."+"Intellect.Default", Integer.valueOf(INT));
						for (List<String> weapon: weapons) {
							String wep = weapon.get(0);
							Integer w = 0;
							while (plugin.getConfig().get(NAME+".Weapons."+wep) != null) {
								w += 1;
								wep = weapon.get(0) + " " + w;
							}
							weapon.set(0, wep);
							plugin.getConfig().set(NAME+".Weapons."+weapon.get(0)+".AttackDesc", weapon.get(1));
							plugin.getConfig().set(NAME+".Weapons."+weapon.get(0)+".AttackType", weapon.get(2));
							plugin.getConfig().set(NAME+".Weapons."+weapon.get(0)+".AttackDMG", weapon.get(3));
							plugin.getConfig().set(NAME+".Weapons."+weapon.get(0)+".DMGType", weapon.get(4));
							plugin.getConfig().set(NAME+".Weapons."+weapon.get(0)+".AttackBonus", Integer.valueOf(weapon.get(5)));
						}
						plugin.getConfig().set(NAME+"."+"Proficiencies.Armor", PF.get(0));
						plugin.getConfig().set(NAME+"."+"Proficiencies.Weapon", PF.get(1));
						plugin.getConfig().set(NAME+"."+"Proficiencies.Vehicle", PF.get(2));
						plugin.getConfig().set(NAME+"."+"Proficiencies.2Tool", PF.get(3));
						plugin.getConfig().set(NAME+"."+"Proficiencies.Other", PF.get(4));
						plugin.getConfig().set(NAME+"."+"Proficiencies.Speeds", PF.get(5));
						

						plugin.getConfig().set(NAME+"."+"Charisma.Default", Integer.valueOf(CHR));
						plugin.getConfig().set(NAME+"."+"Skills.SoH", Integer.valueOf(SoH));


						plugin.getConfig().set(NAME+"."+"Skills.SVL", Integer.valueOf(SVL));

						plugin.getConfig().set(NAME+"."+"PB", Integer.valueOf(PB));

						plugin.getConfig().set(NAME+"."+"PP", Integer.valueOf(PP));

						plugin.getConfig().set(NAME+"."+"Skills.STH", Integer.valueOf(STH));

						plugin.getConfig().set(NAME+"."+"Constitution.Modifier", Integer.valueOf(CON_MOD));
						for (String cantrip: cantrips) {
							plugin.getConfig().set(NAME+"."+"CanTrip."+cantrip, 1);
						}
						plugin.getConfig().set(NAME+"."+"Spellcasting.spell_ability", spell_ability);
						plugin.getConfig().set(NAME+"."+"Spellcasting.spell_savedc", spell_savedc);
						plugin.getConfig().set(NAME+"."+"Spellcasting.spell_attackmodifier", spell_attackmod);
						
						for (Integer i = 1; i <10; i++) {
							plugin.getConfig().createSection(NAME+"."+"Spellcasting.level"+i);
						}
						Integer levl = 1;
						for (List<String> spell: spellLevels) {
							for (String s: spell) {
								if (!s.isBlank()) {
								plugin.getConfig().set(NAME+"."+"Spellcasting.level"+levl+"."+s.replace("&#39;", "\'"), levl);
								}
							}
							levl += 1;
						}

				if (BG1.replace("'", "").isBlank()) {
					BG1 = "None";
				}
				
				if (BG2.replace("'", "").isBlank()) {
					BG2 = "None";
				}
				
				if (BG3.replace("'", "").isBlank()) {
					BG3 = "None";
				}
				
				if (BG4.replace("'", "").isBlank()) {
					BG4 = "None";
				}
				plugin.getConfig().set(NAME+"."+"BG1", BG1.replace("&#39;", "\'"));
				plugin.getConfig().set(NAME+"."+"BG2", BG2.replace("&#39;", "\'"));
				plugin.getConfig().set(NAME+"."+"BG3", BG3.replace("&#39;", "\'"));
				plugin.getConfig().set(NAME+"."+"BG4", BG4.replace("&#39;", "\'"));
				plugin.getConfig().set(NAME+"."+"Owner", owner);
				plugin.getConfig().set(NAME+"."+"File", character.split("\\.")[0]+".profile");
				plugin.saveConfig();
					}
				}
				catch (FileNotFoundException e) {
					
				}
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
						if (args[2].contains(".profile")) {
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
						
						Iterator<?> itr2 = races.iterator();
						
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
						Iterator<?> itr2 = vals.iterator();
						
						JSONArray vals2 = (JSONArray) typeJSON.get("subclassFeature");
						Iterator<?> itr2b = vals2.iterator();
						
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
						Iterator<?> itr2 = vals.iterator();
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
