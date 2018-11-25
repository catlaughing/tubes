package id.sikogrup.level_app;

import java.util.*;

public class GuildMaster extends User {
    private String name, contact;
    private List<Guild> guild;

    public GuildMaster(String name, String username, String email, String password, String contact){
        super(username, email, password);
        this.name = name;
        this.contact=contact;
        this.guild= new LinkedList();
    }

    public void setContact(String contact){
        this.contact=contact;
    }

    public void makeGuild(String name, String subject, int levelRequirement){ //Membuat list adventurer dan guide book baru, membuat guild baru dan memasukkan ke list guild
        Guild guild = new Guild(name,subject,levelRequirement,this);
        this.guild.add(guild);
    }

    public void makeQuest(Guild guild, String name, String deskripsi, int tipe, String deadline, String startDate, int rewardPoint, int rewardExp){ //Membuat list adventurer dan guide book baru, membuat guild baru dan memasukkan ke list guild
        Quest quest = new Quest(name,deskripsi,tipe,deadline,startDate,rewardPoint,rewardExp,this,guild);
        guild.addQuest(quest);
    } //Menunggu class quest

    public void makeGuideBook(Guild guild, String judul, String isi, int rewardExp, int rewardPoint){ //Membuat guidebookbaru dan memasukkan ke guild
        Guide_Book guideBook = new Guide_Book(this,guild,judul,isi,rewardExp,rewardPoint);
        guild.addGuideBook(guideBook);
    }

    public Guild getGuild(int i){
        return guild.get(i);
    }

    public void showGuild(){ //Mengoutput semua guild GM
        for (Guild guild1 : guild) {
            System.out.println(guild1.getNama());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name : "+this.getName()+"|| Contact : "+this.contact;
    }
}
