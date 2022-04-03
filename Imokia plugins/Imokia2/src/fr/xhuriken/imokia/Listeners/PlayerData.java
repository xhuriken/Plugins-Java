package fr.xhuriken.imokia.Listeners;



import fr.xhuriken.imokia.Main;
import wtf.listenia.citronDB.api.TableManager;
import wtf.listenia.citronDB.api.annotations.Unique;
import wtf.listenia.citronDB.api.builders.RowBuilder;

public class PlayerData{
	
	public class Structure {
		
		@Unique(size = 36)
		public String UUID;
		
	    public String grade = "Imokien";
	    
	    public long money = 500;
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final TableManager<Structure> table = new TableManager(Main.dataBase, "player", Structure.class) {{
		
		System.out.println("test");
		
		createTable(true);
		
	}};
	
	public static PlayerData getPlayer(String uuid) {
		
		return new PlayerData(uuid);
		
	}
	
	private final RowBuilder playerPattern;
	
	public PlayerData (String uuid) {
		
		this.playerPattern = new RowBuilder().define("UUID", uuid);

        if (!table.exist(playerPattern)) {
            table.insert(new Structure() {{
                this.UUID = uuid;
            }});
        }
		
	}
	
	public void setMoney(long money) {
		
		final RowBuilder modif = new RowBuilder().define("money", money);
		
		table.update(playerPattern, modif);
		
		
	}
	
	public void setGrade(String grade) {
		
		final RowBuilder modif = new RowBuilder().define("grade", grade);
		
		table.update(playerPattern, modif);
		
		
	}
	
	public Structure getAll() {
		
		return table.getLine(playerPattern);
		
	}
	
	public long getMoney() {
		
		return getAll().money;
		
	}
	
	public String getGrade() {
		
		return getAll().grade;
		
	}
	
}
