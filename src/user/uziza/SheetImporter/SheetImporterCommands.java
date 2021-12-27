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

import user.uziza.SheetImporter.SheetImporter;
import user.uziza.SheetImporter.Items.CharBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;  

public class SheetImporterCommands implements CommandExecutor, Listener {
	public String imp = "import";
	public String chr = "char";
	public String desc = "desc";
	
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
					boolean info = new File(plugin.getDataFolder() + "/Info").mkdir();
					Scanner csv_reset = new Scanner(new File(plugin.getDataFolder() + "/Spreadsheets/" + args[0]), "UTF-8");
					String[] msgs_reset;
					int index_reset = 0;
					while (csv_reset.hasNext()) {
						index_reset += 1;
						String msg_reset = csv_reset.nextLine();
						msgs_reset = msg_reset.split(",");
						if(index_reset == 7) {
							NAME = msgs_reset[2];
							plugin.getConfig().set(NAME, null);
							plugin.saveConfig();
							break;
						}
					}
					csv_reset.close();
					
					String[] msgs;
					int index = 0;
					while (csv.hasNext()) {
						//fix string name problem (later?)
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
						else if (index > 64 && index < 91) {
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
						else if (index == 8) {
							race = msgs[19];
							plugin.getConfig().set(NAME+"."+"Race", race);
						}
						else if (index == 6) {
							subclass = msgs[19];
							plugin.getConfig().set(NAME+"."+"Subclass", subclass);
						}
						else if (index == 13) {
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
						else if (index == 19) {
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
						else if (index == 20) {
							CON_SAVE = msgs[8];
							plugin.getConfig().set(NAME+".Saves." + "CON", Integer.valueOf(CON_SAVE));
						}
						else if (index == 18) {
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
						else if (index == 14) {
							try {
							BG1 += msgs[30] + " ";
							}
							catch (Exception e) {
								BG1 += "\"";
							}
							STR_M = msgs[2];
							plugin.getConfig().set(NAME+"."+"Strength.Modifier", Integer.valueOf(STR_M));
						}
						else if (index == 17) {
							try {
								BG2 += "\""+msgs[30] + " ";
							}
							catch (Exception e){
								BG2 += "\"None\"";
							}
							HPMAX = msgs[20];
							plugin.getConfig().set(NAME+"."+"MaxHP", Integer.valueOf(HPMAX));
						}
						else if (index == 16) {
							STR = msgs[2];
							plugin.getConfig().set(NAME+"."+"Strength.Default", Integer.valueOf(STR));
						}
						else if (index == 12) {
							BG = msgs[35];
							plugin.getConfig().set(NAME+"."+"BG", BG);
						}
						else if (index == 21) {
							
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
						else if (index == 22) {
							
							WIS_SAVE = msgs[8];
							try {
								BG3 += msgs[30] + " ";
								}
							catch (Exception e){
								BG3 += "\"";
							}
							
							plugin.getConfig().set(NAME+".Saves." + "WIS", Integer.valueOf(WIS_SAVE));
						}
						else if (index == 23) {
							
							CHA_SAVE = msgs[8];
							try {
							BG3 += msgs[30] + "\"";
							}
							catch (Exception e){
								BG3 += "\"";
							}
							plugin.getConfig().set(NAME+".Saves." + "CHA", Integer.valueOf(CHA_SAVE));
						}
						else if (index == 26) {
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
						else if (index == 25) {
							try {
							BG4 += "\"" +  msgs[30] + " ";
							}
							catch (Exception e) {
								BG4 += "\"None\"";
							}
						}
						else if (index == 27) {
							try {
							BG4 += msgs[30] + "\"";
							}
							catch (Exception e) {
								BG4 += "\"";
							}
							ANH = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.ANH", Integer.valueOf(ANH));
						}
						else if (index == 28) {
							ARC = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.ARC", Integer.valueOf(ARC));
						}
						else if (index == 29) {
							INT_M = msgs[2];
							plugin.getConfig().set(NAME+"."+"Intellect.Modifier", Integer.valueOf(INT_M));
							ATH = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.ATH", Integer.valueOf(ATH));
						}
						else if (index == 30) {
							
							DEC = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.DEC", Integer.valueOf(DEC));
						}
						else if (index == 32) {
							
							INS = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.INS", Integer.valueOf(INS));
						}
						else if (index == 33) {
							ITN = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.ITN", Integer.valueOf(ITN));
						}
						else if (index == 36) {
							WIS_M = msgs[2];
							plugin.getConfig().set(NAME+"."+"Wisdom.Modifier", Integer.valueOf(WIS_M));
							INV = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.INV", Integer.valueOf(INV));
						}
						else if (index == 38) {
							MED = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.MED", Integer.valueOf(MED));
						}
						else if (index == 42) {
							PEC = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.PEC", Integer.valueOf(PEC));
						}
						else if (index == 43) {
							PER = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.PER", Integer.valueOf(PER));
						}
						else if (index == 44) {
							CHR_M = msgs[2];
							plugin.getConfig().set(NAME+"."+"Charisma.Modifier", Integer.valueOf(CHR_M));
							PEN = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.PEN", Integer.valueOf(PEN));
						}
						else if (index == 45) {
							REG = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.REG", Integer.valueOf(REG));
						}
						else if (index == 48) {
							DIE = msgs[17];
							plugin.getConfig().set(NAME+"."+"DIE", DIE.split(" ")[2].split("=")[1]);
						}
						else if (index == 41) {
							WIS = msgs[2];
							plugin.getConfig().set(NAME+"."+"Wisdom.Default", Integer.valueOf(WIS));
							NTR = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.NTR", Integer.valueOf(NTR));
						}
						else if (index == 31) {
							
							HIS = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.HIS", Integer.valueOf(HIS));
							INT = msgs[2];
							plugin.getConfig().set(NAME+"."+"Intellect.Default", Integer.valueOf(INT));
						}
						else if (index == 55) {
							try {
							PF1 = "\""+msg.split("\"")[1]+"\"";
							}
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.Armor", PF1);
						}
						else if (index == 56) {
							try {
							PF2 = "\""+ msg.split("\"")[1]+"\"";
							}
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.Weapon", PF2);
						}
						else if (index == 57) {
							try {
							PF3 = "\""+msg.split("\"")[1]+"\"";
							}
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.Vehicle", PF3);
						}
						else if (index == 58) {
							try {
								PF4 = "\""+msg.split("\"")[1]+"\"";
							}
							
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.2Tool", PF4);
						}
						else if (index == 59) {
							try {
							PF5 = "\""+msg.split("\"")[1]+"\"";
							}
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.Other", PF5);
						}
						else if (index == 60) {
							try {
							PF6 = "\""+msg.split("\"")[1]+"\"";
							}
							catch (Exception e) {
								
							}
							plugin.getConfig().set(NAME+"."+"Proficiencies.Speeds", PF6);
						}
						else if (index == 46) {
							CHR = msgs[2];
							plugin.getConfig().set(NAME+"."+"Charisma.Default", Integer.valueOf(CHR));
							SoH = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.SoH", Integer.valueOf(SoH));
						}
						else if (index == 48) {
							SVL = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.SVL", Integer.valueOf(SVL));
						}
						else if (index == 15) {
							try {
							BG1 += msgs[30] + "\"";
							}
							catch (Exception e) {
								BG1 += "\"";
							}
							PB = msgs[7];
							plugin.getConfig().set(NAME+"."+"PB", Integer.valueOf(PB));
						}
						else if (index == 51) {
							PP = msgs[2];
							plugin.getConfig().set(NAME+"."+"PP", Integer.valueOf(PP));
						}
						else if (index == 47) {
							STH = msgs[8];
							plugin.getConfig().set(NAME+"."+"Skills.STH", Integer.valueOf(STH));
						}
						else if (index == 24) {
							CON_M = msgs[2];
							plugin.getConfig().set(NAME+"."+"Constitution.Modifier", Integer.valueOf(CON_M));
						}
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
						
					}
					plugin.getConfig().set(NAME+"."+"BG1", BG1.replace("'", ""));
					plugin.getConfig().set(NAME+"."+"BG2", BG2.replace("'", ""));
					plugin.getConfig().set(NAME+"."+"BG3", BG3.replace("'", "'"));
					plugin.getConfig().set(NAME+"."+"BG4", BG4.replace("'", "'"));
					plugin.saveConfig();
					csv.close();
				} catch (FileNotFoundException e) {
					sender.sendMessage("Could not read file.");
				} //catch no stuff
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(chr)) {
			if (args.length > 1) {
				if (plugin.getConfig().getConfigurationSection(args[0]+" "+args[1]) != null) {
					CharBook charBook = new CharBook(plugin);
					String character = args[0]+" "+args[1];
					Player player = (Player) sender;
					String UID = UUID.randomUUID().toString().split("-")[0];
					charBook.createBook(player, character, false, UID);
					
				}
				else {
					sender.sendMessage("Cannot find character.");
				}
			}
			return true;
		}
		else if (cmd.getName().equalsIgnoreCase(desc)) {
			if (args.length >= 2) {
				String msg = "None";
				Object type_JSON;
				JSONObject typeJSON;
				try {
					String values = args[0].replaceAll("(.)([A-Z])", "$1 $2");
					String type = args[1];
					if (type.toLowerCase().equals("race")) {
						type+="s";
					}
					type_JSON = new JSONParser().parse(new FileReader(plugin.getDataFolder() + "/Info/" +type.toLowerCase()+".json"));
					typeJSON = (JSONObject) type_JSON;
					if (type.equals("races")) {
						String race = args[2];
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
				            						sender.sendMessage( "\n\n"+values+": "+finished.replace("\"", "").replace("[", "").replace("]", ""));
							            			break;
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
						
						JSONObject val_JSON = new JSONObject();
						boolean isval = false;
						String finished = "";
						while (itr2.hasNext()) {
				           Object result = itr2.next();
				           if (result.toString().contains(values)) {
				           
	            				for (int i2 = 0; i2 < result.toString().length(); i2++) {
	            					if (isval == true) {
				            			finished += result.toString().charAt(i2);
				            		}
	            					if (result.toString().charAt(i2) == '[') {
	            						isval = true;
				            		}
	            					else if (result.toString().charAt(i2) == ']') {
	            						isval = false;
	            						sender.sendMessage( "\n\n"+values+": "+finished.replace("\"", "").replace("[", "").replace("]", ""));
				            			break;
				            		}
	            					
	            				}
				           
				           }
						}
					}
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;	
			}
		}
		return false;
	}
}
