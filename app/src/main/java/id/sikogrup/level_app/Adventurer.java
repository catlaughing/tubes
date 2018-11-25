package id.sikogrup.level_app;


import java.util.*;

class Adventurer extends User implements Comparable<Adventurer> {
    private int exp,level;
    private String name;
    private ArrayList<Guild> takenGuild;
    private Map<Guild,Integer> points; //ini juga gw bikin jadi maps, baca docs nya di geeksforgeeks
    private ArrayList<Quest> takenQuest;

    public Adventurer(String name, String email, String password){
        super(name,email,password);
        this.exp = 0;
        this.level = 1;
        this.takenGuild = new ArrayList<>();
        this.points = new HashMap<>();
        this.takenQuest = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void joinGuild(Guild g){
        g.addAdventurer(this); //Nambahin dia ke guild
        this.takenGuild.add(g); //Nambahin guild nya ke list guild yang pernah dia ambil
        this.points.put(g, 0); //bikin object baru dalam map key nya guild itu value nya 0
    }

    public Guild getGuild(int idxGuild){
        return this.takenGuild.get(idxGuild);
    }

    public void updateExp(int exp){
        //buat update exp kalau lebih dari 100 naik level
        if (this.exp + exp < 100){
            this.exp+=exp;
        }
        else{
            this.exp = this.exp + exp - 100;
            this.levelUp();
        }
    }
    public int getExp(){
        return this.exp;
    }

    public void levelUp(){
        this.level = (this.getLevel() + 1);
    }

    public void takeQuest(Quest q){
        this.takenQuest.add(q);
    }

    public Quest getTakenQuest(int i) {
        return takenQuest.get(i);
    }

    @Override
    public int compareTo(Adventurer o) {
        return o.getName().compareTo(this.getName());
    }
}
