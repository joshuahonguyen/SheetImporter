package user.uziza.SheetImporter.Items;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.http.HttpResponse;
import org.bukkit.craftbukkit.libs.org.apache.http.client.methods.HttpGet;
import org.bukkit.craftbukkit.libs.org.apache.http.impl.client.CloseableHttpClient;
import org.bukkit.craftbukkit.libs.org.apache.http.impl.client.HttpClients;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftMetaBook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Item;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.chat.IChatBaseComponent.ChatSerializer;
import net.minecraft.world.entity.player.PlayerAbilities;
import net.minecraft.network.chat.IChatMutableComponent;
import user.uziza.SheetImporter.SheetImporter;

public class CharBook implements Listener {
	
	SheetImporter plugin;
	public CharBook(SheetImporter plugin) {
		this.plugin = plugin;
	}
	
	public void createBook(Player player, String Char, Boolean ALT, String ID) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookmeta = (BookMeta) book.getItemMeta();
		
		String LVL = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Level").toString();
		String CLASS = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Class").toString();
		String HP = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("HP").toString();
		String AC = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("AC").toString();
		String SPEED = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Speed").toString();		
		String STR = plugin.getConfig().getConfigurationSection(Char+".Strength").getValues(false).get("Default").toString();
		String DEX = plugin.getConfig().getConfigurationSection(Char+".Dexterity").getValues(false).get("Default").toString();
		String CON = plugin.getConfig().getConfigurationSection(Char+".Constitution").getValues(false).get("Default").toString();
		String INT = plugin.getConfig().getConfigurationSection(Char+".Intellect").getValues(false).get("Default").toString();
		String WIS = plugin.getConfig().getConfigurationSection(Char+".Wisdom").getValues(false).get("Default").toString();
		String CHA = plugin.getConfig().getConfigurationSection(Char+".Charisma").getValues(false).get("Default").toString();
		String PP = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("PP").toString();
		String PB = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("PB").toString();
		String subclass = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Subclass").toString();
		//split by class?
		
		String STR_MOD = plugin.getConfig().getConfigurationSection(Char+".Strength").getValues(false).get("Modifier").toString();
		String DEX_MOD = plugin.getConfig().getConfigurationSection(Char+".Dexterity").getValues(false).get("Modifier").toString();
		String CON_MOD = plugin.getConfig().getConfigurationSection(Char+".Constitution").getValues(false).get("Modifier").toString();
		String INT_MOD = plugin.getConfig().getConfigurationSection(Char+".Intellect").getValues(false).get("Modifier").toString();
		String WIS_MOD = plugin.getConfig().getConfigurationSection(Char+".Wisdom").getValues(false).get("Modifier").toString();
		String CHA_MOD = plugin.getConfig().getConfigurationSection(Char+".Charisma").getValues(false).get("Modifier").toString();
		
		String STR_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("STR").toString();
		String DEX_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("DEX").toString();
		String CON_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("CON").toString();
		String INT_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("INT").toString();
		String WIS_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("WIS").toString();
		String CHA_SAVE = plugin.getConfig().getConfigurationSection(Char+".Saves").getValues(false).get("CHA").toString();
		
		int roll_DIE = 1;
		String hand = "default";
		if (ALT == true) {
			roll_DIE = 2;
			hand = "adv/dis";
		}
		
		String sense = "None";
		Set<String> perks = plugin.getConfig().getConfigurationSection(Char+".Perks").getKeys(false);
		for (String p: perks) {
			if (p.contains("Darkvision")) {
				sense = "Dark Vision";
			}
		}
		
		BaseComponent[] page0 = new ComponentBuilder(Char)
				.append("\n" + "AC: " + AC + ", HP: " + HP)
				.append("\n\n" + subclass)
				.append("\n\n")
				.append("STR")
				.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+STR_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(STR).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+STR_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+STR_SAVE.toString()).create()))
		        
		        .append(" ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("DEX")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+DEX_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(DEX).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+DEX_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+DEX_SAVE.toString()).create()))
		        
		        .append(" ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("CON")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+CON_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(CON).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+CON_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+CON_SAVE.toString()).create()))
		        
		        .append("\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("+" +STR_MOD + "      " +"+"+DEX_MOD + "      " +"+"+ CON_MOD)
		        
		        .append("\n")
		        
		        .append("INT")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+INT_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(INT).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+INT_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+INT_SAVE.toString()).create()))
		        
		        .append(" ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("WIS")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+WIS_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(WIS).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+WIS_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+WIS_SAVE.toString()).create()))
		        
		        .append(" ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("CHA")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+CHA_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(CHA).create()))
		        .append("(S)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+CHA_SAVE))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+CHA_SAVE.toString()).create()))
		        
		        .append("\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("+"+INT_MOD + "      " +"+"+WIS_MOD+ "      " +"+"+ CHA_MOD)
		        
		        .append("\n\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("Move Speed: " + SPEED)
		        .append("\n")
		        .append("Senses: " + sense)
		        .append("\n")
		        .append("Passive Perception: " + PP)
				.create();
		
		bookmeta.spigot().addPage(page0);
		String BG = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("BG").toString();
		String A_P = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("Armor").toString();
		String W_P = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("Weapon").toString();
		String V_P = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("Vehicle").toString();
		String D_P = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("2Tool").toString();
		String O_P = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("Other").toString();
		String O_S = plugin.getConfig().getConfigurationSection(Char+".Proficiencies").getValues(false).get("Speeds").toString();
		String DIE = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("DIE").toString();

		BaseComponent[] pageBG = new ComponentBuilder("Proficiencies")
				.append("\n\n")
				.append("Armor: " + A_P)
				.append("\n")
				.append("Weapon: " + W_P)
				.append("\n")
				.append("Vehicle: " + V_P)
				.append("\n")
				.append("2 Tool: " + D_P)
				.append("\n")
				.append("Other: " + O_P)
				.append("\n")
				.append("Speeds: " + O_S)
				.append("\n\n")
				.append("Background: " + BG)				
				.append("\n")
				.append("Hit Dice: " + DIE)
				
				.create();
		bookmeta.spigot().addPage(pageBG);
		Map<String, Object> SKILLS = plugin.getConfig().getConfigurationSection(Char+".Skills").getValues(false);
		int NUMB = 0;
		String LINE1 = "";
		String VAL1 = "";
		String LINE2 = "";
		String VAL2 = "";
		String LINE3 = "";
		String VAL3 = "";
		String LINE4 = "";
		String VAL4 = "";
		String LINE5 = "";
		String VAL5 = "";
		String LINE6 = "";
		String VAL6 = "";
		String LINE7 = "";
		String VAL7 = "";
		String LINE8 = "";
		String VAL8 = "";
		String LINE9 = "";
		String VAL9 = "";
		
		String LINE10 = "";
		String VAL10 = "";
		String LINE11 = "";
		String VAL11 = "";
		String LINE12 = "";
		String VAL12 = "";
		String LINE13 = "";
		String VAL13 = "";
		String LINE14 = "";
		String VAL14 = "";
		String LINE15 = "";
		String VAL15 = "";
		String LINE16 = "";
		String VAL16 = "";
		String LINE17 = "";
		String VAL17 = "";
		String LINE18 = "";
		String VAL18 = "";
		
		for (Entry<String, Object> entry: SKILLS.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().toString();
			NUMB += 1;
			if (key.equals("SoH")) {
				LINE16 = "Sleight of Hand";
				VAL16 = value;
			}
			else if (key.equals("STH")) {
				LINE17 = "Stealth";
				VAL17 = value;
			}
			else if (key.equals("SVL")){
				LINE18 = "Survival";
				VAL18 = value;
			}
			else if (key.equals("PER")) {
				LINE13 = "Performance";
				VAL13 = value;
			}
			else if (key.equals("PEN")) {
				LINE14 = "Persuasion";
				VAL14 = value;
			}
			else if (key.equals("REG")) {
				LINE15 = "Religion";
				VAL15 = value;
			}
			else if (key.equals("MED")) {
				LINE10 = "Medicine";
				VAL10 = value;
			}
			else if (key.equals("NTR")) {
				LINE11 = "Nature";
				VAL11 = value;
			}
			else if (key.equals("PEC")) {
				LINE12 = "Perception";
				VAL12 = value;
			}
			else if (key.equals("INS")) {
				LINE7 = "Insight";
				VAL7 = value;
			}
			else if (key.equals("ITN")) {
				LINE8 = "Intimidation";
				VAL8 = value;
			}
			else if (key.equals("INV")) {
				LINE9 = "Investigation";
				VAL9 = value;
			}
			else if (key.equals("ATH")) {
				LINE4 = "Athletics";
				VAL4 = value;
			}
			else if (key.equals("DEC")) {
				LINE5 = "Deception";
				VAL5 = value;
			}
			else if (key.equals("HIS")) {
				LINE6 = "History";
				VAL6 = value;
			}
			else if (key.equals("ACR")) {
				LINE1 = "Acrobatics";
				VAL1 = value;
			}
			else if (key.equals("ANH")) {
				LINE2 = "Animal Handling";
				VAL2 = value;
			}
			else if (key.equals("ARC")) {
				LINE3 = "Arcana";
				VAL3 = value;
			}
				
			if (NUMB == 18) {
				BaseComponent[] SKILLSPAGE1 = new ComponentBuilder("Skills: ")
						.append("\n\n")
						.append(LINE1)
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL1))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL1.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE2)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL2))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL2.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE3)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL3))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL3.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE4)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL4))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL4.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE5)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL5))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL5.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE6)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL6))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL6.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE7)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL7))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL7.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE8)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL8))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL8.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE9)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL9))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL9.toString()).create()))
				        .create();
				bookmeta.spigot().addPage(SKILLSPAGE1);
				BaseComponent[] SKILLSPAGE2 = new ComponentBuilder("Skills: ")
						.append("\n\n")
						.append(LINE10)
						.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL10))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+ VAL10.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE11)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL11))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL11.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE12)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL12))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL12.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE13)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL13))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL13.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE14)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL14))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL14.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE15)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL15))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL15.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE16)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL16))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL16.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE17)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL17))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL17.toString()).create()))
				        .append("\n")
				        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "1"))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				        .append(LINE18)
				        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+roll_DIE+"d20"+"+"+VAL18))
				        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("+"+VAL18.toString()).create()))
				        .create();
				bookmeta.spigot().addPage(SKILLSPAGE2);
				NUMB = 0;
			}
		}
		
		
		
		Set<String> Weapons = plugin.getConfig().getConfigurationSection(Char+".Weapons").getKeys(false);
		for (String wep: Weapons) {
			//word length == big, then 2 lines?
			String desc = "Weapon: "+wep.substring(0, 1).toUpperCase() + wep.substring(1)+"\n";
			String desc2 = "";
			String atkdesc = null;
			String atkbonus = null;
			String atkdmg = null;
			String dmgtype = null;
			int bonusatk = 0;
			String dmgatk = null;
			Map<String, Object> Weapon = plugin.getConfig().getConfigurationSection(Char+".Weapons."+wep.toString()).getValues(false);
			for (Map.Entry<String, Object> entry : Weapon.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue().toString();
				if (key.contains("AttackDMG")) {
					atkdmg = key + ": " + value + "\n";
					dmgatk = value;
				}
				else if (key.contains("AttackBonus")) {
					atkbonus = key + ": " + "+" + value + "\n";
					bonusatk = Integer.parseInt(value);
				}
				else if (key.contains("DMGType")) {
					dmgtype = key + ": " + value.substring(0, 1).toUpperCase() + value.substring(1) + "\n";
				}
				else if (key.contains("AttackDesc")) {
					atkdesc = value.substring(0, 1).toUpperCase() + value.substring(1) + "\n\n";
				}
				else {
					desc2 += key + ": " + value.substring(0, 1).toUpperCase() + value.substring(1) + "\n";
				}
				
			}
			BaseComponent[] pagewep = new ComponentBuilder(desc)
					.append("\n")
					.append(atkdesc)
					.append(desc2)
					.append(dmgtype)
					.append(atkbonus)
					.append(atkdmg)
					.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+dmgatk))
			        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll").create()))
			        .append("\n")
					.event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
					.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
					.create();
			bookmeta.spigot().addPage(pagewep);
		}
		String RACE= plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Race").toString();

		Object class_JSON;
		Object race_JSON;
        try {
        	class_JSON = new JSONParser().parse(new FileReader(plugin.getDataFolder() + "/Info/" +CLASS.toLowerCase()+".json"));
			race_JSON = new JSONParser().parse(new FileReader(plugin.getDataFolder() + "/Info/races.json"));
        } catch (IOException | ParseException e) {
			return;
		}
        
        JSONObject classJSON = (JSONObject) class_JSON;
        JSONObject raceJSON = (JSONObject) race_JSON;
        
		ComponentBuilder FP = new ComponentBuilder("Features\n\n");
		int FP_index = 0;
		Map<String, Object> PERKS = plugin.getConfig().getConfigurationSection(Char+".Perks").getValues(false);
		for (Entry<String, Object> entry: PERKS.entrySet()) {
			String key = entry.getKey();
			String hover = "Misc.";
			String desc = key.replaceAll("\\s", "");
			String type = "";
			
			if (classJSON.toJSONString().contains(key)) {
				hover = "Class: "+CLASS;
				type = "/desc " + desc + " " + CLASS;
			}
			else if (raceJSON.toJSONString().contains(key)) {
				hover = "Race: "+RACE;
				type = "/desc " + desc + " race " + RACE;
			}

			
			FP.append(key);
			FP.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, type));			
			FP.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hover).create()));
			FP.append("\n");
			FP.event(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, null));
			FP.event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()));
			FP_index += 1;
			
			if (FP_index == 9) {
				bookmeta.spigot().addPage(FP.create());
				FP = new ComponentBuilder("Features\n\n");
				FP_index = 0;
			}
			
		}
		
		
		bookmeta.spigot().addPage(pageBG);
		String BG1 = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("BG1").toString().replace("\"", "");
		String BG2 = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("BG2").toString().replace("\"", "");
		String BG3 = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("BG3").toString().replace("\"", "");
		String BG4 = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("BG4").toString().replace("\"", "");
		BaseComponent[] pageBG1 = new ComponentBuilder("Personality Traits")
				.append("\n\n")
				.append(BG1)
				.create();
		BaseComponent[] pageBG2 = new ComponentBuilder("Ideals")
				.append("\n\n")
				.append(BG2)
				.create();
		BaseComponent[] pageBG3 = new ComponentBuilder("Bonds")
				.append("\n\n")
				.append(BG3)
				.create();
		BaseComponent[] pageBG4 = new ComponentBuilder("Flaws")
				.append("\n\n")
				.append(BG4)
				.create();
		bookmeta.spigot().addPage(pageBG1);
		bookmeta.spigot().addPage(pageBG2);
		bookmeta.spigot().addPage(pageBG3);
		bookmeta.spigot().addPage(pageBG4);
		
		bookmeta.setAuthor(player.getName());
		bookmeta.setTitle(ChatColor.DARK_BLUE +"Dungeons and Dragons");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(Char);
		lore.add("("+hand+")");
		lore.add(ID);
		bookmeta.setLore(lore);
		
		book.setItemMeta(bookmeta);
		player.getInventory().addItem(book);
	}
	
	private Collection<? extends String> ArrayOf(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	@EventHandler
	public void changeHand(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Action a = e.getAction();
		ItemStack item = player.getInventory().getItemInMainHand();
		ItemMeta meta = item.getItemMeta();
		
		if (e.getHand() != null) {
			if (e.getHand().equals(EquipmentSlot.HAND)) {
				if (meta != null) {
					if (meta.getLore() != null) {
						if (item.getType().equals(Material.WRITTEN_BOOK)) {
							if (player.isSneaking() && a.equals(Action.LEFT_CLICK_BLOCK) || player.isSneaking() && a.equals(Action.LEFT_CLICK_AIR)) {
								if (meta.getLore().get(1).toString().equals("(default)")) {
									player.getInventory().remove(item);
									createBook(player,meta.getLore().get(0).toString(),true,meta.getLore().get(2));
									
								}
								else if (meta.getLore().get(1).toString().equals("(adv/dis)")){
									player.getInventory().remove(item);
									createBook(player,meta.getLore().get(0).toString(),false, meta.getLore().get(2));
									
								}
								e.setCancelled(true);
							}
						}
					}
				}
			}
		}
	}
}