package zssystem;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;
import me.baks.rpl.api.API;
import me.baks.rpl.config.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Zssystem
  extends JavaPlugin
{
  public static void createFile(Player paramPlayer)
  {
    File localFile = new File(ConfigManager.PATH_TO_FILES + getId(paramPlayer) + ".yml");
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localFile);
    if (!localFile.exists())
    {
      localYamlConfiguration.set("playername", paramPlayer.getName());
      localYamlConfiguration.set("count", Integer.valueOf(0));
      saveFile(localYamlConfiguration, localFile);
    }
  }
  
  public static void deleteFile(Player paramPlayer)
  {
    File localFile = new File(ConfigManager.PATH_TO_FILES + getId(paramPlayer) + ".yml");
    localFile.delete();
  }
  
  public static void saveFile(FileConfiguration paramFileConfiguration, File paramFile)
  {
    try
    {
      paramFileConfiguration.save(paramFile);
    }
    catch (IOException localIOException) {}
  }
  
  public static void loadPlayerToMemory(Player paramPlayer)
  {
    File localFile = new File(ConfigManager.PATH_TO_FILES + getId(paramPlayer) + ".yml");
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localFile);
    new Playercount(paramPlayer.getName(), localYamlConfiguration.getInt("count"));
  }
  
  public static void savePlayerToFile(Player paramPlayer)
  {
    File localFile = new File(ConfigManager.PATH_TO_FILES + getId(paramPlayer) + ".yml");
    YamlConfiguration localYamlConfiguration = YamlConfiguration.loadConfiguration(localFile);
    localYamlConfiguration.set("count", Integer.valueOf(Playercount.getcount()));
    localYamlConfiguration.set("playername", paramPlayer.getName());
    saveFile(localYamlConfiguration, localFile);
  }
  
  private static String getId(Player paramPlayer)
  {
    if (ConfigManager.UUID) {
      return paramPlayer.getUniqueId().toString();
    }
    return paramPlayer.getName();
  }
  
  public void onEnable()
  {
    getLogger().info("-----------------------------------------------!\n");
    getLogger().info("\n");
    getLogger().info("\n");
    getLogger().info("幻世转生系统成功加载 By Jalexdalv QQ 605055840!\n");
    getLogger().info("\n");
    getLogger().info("\n");
    getLogger().info("-----------------------------------------------!\n");
  }
  
  public void onDisable()
  {
    getLogger().info("-----------------------------------------------!\n");
    getLogger().info("\n");
    getLogger().info("\n");
    getLogger().info("幻世转生系统成功卸载 By Jalexdalv QQ 605055840!");
    getLogger().info("\n");
    getLogger().info("\n");
    getLogger().info("-----------------------------------------------!\n");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("zc"))
    {
      sender.sendMessage("§d§l[转生系统]§a§l§c§m §m §b§m §m §e§m §m §a§m §m §d§m §m §e§m §m §d§m §m §6§m §m§d§l幻世转生系统§a§l§c§m §m §b§m §m §e§m §m §a§m §m §d§m §m §e§m §m §d§m §m §6§m §m\n");
      sender.sendMessage("§d§l[转生系统]§3§l/zhuansheng §e§l进行转生§c§l（需要等级100）\n");
      sender.sendMessage("§d§l[转生系统]§3§l/zcinquire §e§l查询转生次数\n");
      sender.sendMessage("§d§l[转生系统]§a§l§c§m §m §b§m §m §e§m §m §a§m §m §d§m §m §e§m §m §d§m §m §6§m §m§c§m §m §b§m §m §e§m §m §a§m §m §d§m §m §e§m §m §d§m §m §6§m §m§c§m §m §b§m §m §e§m §m §a§m §m §d§m §m §e§m §m §d§m §m §6§m §m\n");
    }
    if (cmd.getName().equalsIgnoreCase("zhuansheng"))
    {
      Player player = (Player)sender;
      createFile(player);
      loadPlayerToMemory(player);
      

      int level = API.getPlayerLevel(player);
      int points = API.getStatPoints(player);
      if (level == 100)
      {
        sender.sendMessage("§d§l[转生系统]§e§l恭喜您成功转生!");
        sender.sendMessage("§d§l[转生系统]§c§l您获得了转生奖励：§5§l50§c§l属性点!");
        API.setPlayerLevel(player, 20);
        API.setStatPoints(player, points + 50);
        Playercount.setcount(Playercount.count + 1);
        savePlayerToFile(player);
      }
      else
      {
        sender.sendMessage("§d§l[转生系统]§e§l您的等级不够，不能转生!");
      }
    }
    if (cmd.getName().equalsIgnoreCase("zcinquire"))
    {
      Player player = (Player)sender;
      createFile(player);
      loadPlayerToMemory(player);
      
      int i = Playercount.getcount();
      sender.sendMessage("§d§l[转生系统]§e§l您的转生次数为§3§l" + i);
      savePlayerToFile(player);
    }
    return false;
  }
}
