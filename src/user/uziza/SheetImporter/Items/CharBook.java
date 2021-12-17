package user.uziza.SheetImporter.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
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

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.chat.IChatBaseComponent.ChatSerializer;
import net.minecraft.network.chat.IChatMutableComponent;
import user.uziza.SheetImporter.SheetImporter;

public class CharBook implements Listener {
	
	SheetImporter plugin;
	public CharBook(SheetImporter plugin) {
		this.plugin = plugin;
	}
	
	public void createBook(Player player, String Char) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bookmeta = (BookMeta) book.getItemMeta();
		
		String LVL = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Level").toString();
		String CLASS = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Class").toString();
		String HP = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("HP").toString();
		String AC = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("AC").toString();
		String SPEED = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Speed").toString();
		String STR = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Strength").toString();
		String DEX = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Dexterity").toString();
		String CON = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Constitution").toString();
		String INT = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Intellect").toString();
		String WIS = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Wisdom").toString();
		String CHA = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("Charisma").toString();
		String PP = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("PP").toString();
		String PB = plugin.getConfig().getConfigurationSection(Char).getValues(false).get("PB").toString();
		
		int STR_MOD = Integer.parseInt(STR) - 11;
		int DEX_MOD = Integer.parseInt(DEX) - 13;
		int CON_MOD = Integer.parseInt(CON) - 12;
		int INT_MOD = Integer.parseInt(INT) - 10;
		int WIS_MOD = Integer.parseInt(WIS) - 13;
		int CHA_MOD = Integer.parseInt(CHA) - 10;
		
		BaseComponent[] page0 = new ComponentBuilder(Char)
				.append("\nLVL: " + LVL + ", CLS: " + CLASS+ "\n\nHP: " + HP +" AC: "+AC+" SP: "+SPEED + "\n\n")
				.append(" ")
				.append("SR:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(STR.toString()).create()))
		        .append("      ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("DX:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(DEX.toString()).create()))
		        .append("     ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("CN:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(CON.toString()).create()))
		        .append("\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("(L")
				.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+STR_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Strength (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+STR_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Strength (R)").create()))
		        .append("  ")
		        .append("(L")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+DEX_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Dexterity (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+DEX_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Dexterity (R)").create()))
		        .append("  ")
		        .append("(L")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+CON_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Constitution (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+CON_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Constitution (R)").create()))
		        .append("\n\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append(" ")
		        .append("IT:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(INT.toString()).create()))
		        .append("      ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("WS:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(WIS.toString()).create()))
		        .append("     ")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
		        .append("CA:")
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(CHA.toString()).create()))
		        .append("\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				.append("(L")
				.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+INT_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Intellect (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+INT_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Intellect (R)").create()))
		        .append("  ")
		        .append("(L")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+WIS_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Wisdom (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+WIS_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Wisdom (R)").create()))
		        .append("  ")
		        .append("(L")
				.event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+1+"d20+"+CHA_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Charisma (L)").create()))
		        .append("/")
		        .append("R)")
		        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/roll "+2+"d20+"+CHA_MOD))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Roll Charisma (R)").create()))
		        .append("\n\nSAVING THROWS\n")
		        .event(new ClickEvent(ClickEvent.Action.CHANGE_PAGE, "0"))
		        .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("").create()))
				.append("PP: " +PP+" PB: " + PB)
				.create();
		
		bookmeta.spigot().addPage(page0);
		
		
		Set<String> Weapons = plugin.getConfig().getConfigurationSection(Char+".Weapons").getKeys(false);
		for (String wep: Weapons) {
			String desc = "Weapon: "+wep+"\n";
			String desc2 = "";
			String atkdesc = null;
			String atkbonus = null;
			String atkdmg = null;
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
					atkbonus = "\n"+ key + ": " + value + "\n";
					bonusatk = Integer.parseInt(value);
				}
				else if (key.contains("AttackDesc")) {
					atkdesc = key + ": " + value + "\n\n";
				}
				else {
					desc2 += key + ": " + value + "\n";
				}
				
			}
			BaseComponent[] pagewep = new ComponentBuilder(desc)
					.append("\n")
					.append(atkdesc)
					.append(desc2)
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
		bookmeta.setAuthor(player.getName());
		bookmeta.setTitle(ChatColor.DARK_BLUE +"Dungeons and Dragons");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("DND");
		lore.add(Char);
		bookmeta.setLore(lore);
		
		book.setItemMeta(bookmeta);
		player.getInventory().addItem(book);
	}
}