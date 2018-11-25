package id.sikogrup.level_app;

import java.util.*;

public class Quest {
    private String id_Quest;
    private static int i = 1;
    private String nama;
    private String deskripsi;
    private int tipe;
    private String startDate;
    private String endDate;
    private int rewardPoint;
    private int rewardExp;
    private HashMap<Adventurer,String> pengumpulan = new HashMap();
    private GuildMaster gm;
    private Guild guild;

    public Quest(String nama, String deskripsi, int tipe, String startDate, String endDate, int rewardPoint, int rewardExp, GuildMaster gm, Guild guild) {
        this.id_Quest = "Quest_"+ (i++);
        this.nama = nama;
        this.deskripsi = deskripsi;
        if(tipe>0 && tipe<4){
            this.tipe = tipe;
        }
        else {
            this.tipe = 1;
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.rewardPoint = rewardPoint;
        this.rewardExp = rewardExp;
        this.gm = gm;
        this.guild = guild;
    }

    public String getId() {
        return id_Quest;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getTipe() {
        return tipe;
    }

    public void printTipe() {
        switch (getTipe()) {
            case 1:
                System.out.println("Normal Quest");
                break;
            case 2:
                System.out.println("Daily Quest");
                break;
            default:
                System.out.println("Grand Quest");
                break;
        }
    }

    public void submitQuest(Adventurer adventurer,String answer){
        pengumpulan.put(adventurer, answer);
    }

    public void showSubmitQuest(){
        for (Adventurer kumpul : pengumpulan.keySet()){
            String jawaban = pengumpulan.get(kumpul);
            System.out.println(kumpul.getName() + " || Jawaban : " + jawaban);
        }
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public int getRewardExp() {
        return rewardExp;
    }

    public void setRewardExp(int rewardExp) {
        this.rewardExp = rewardExp;
    }

    public GuildMaster getGm() {
        return gm;
    }

    public Guild getGuild() {
        return guild;
    }
}
