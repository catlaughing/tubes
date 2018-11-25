package id.sikogrup.level_app;

import java.util.*;
class Guild {
    private static Integer i = 1;
    private String id_guild;
    private GuildMaster gm;
    private String nama;
    private String subject;
    private int levelRequirement;
    private SortedMap<Adventurer,Integer> listAdventurer;
    private ArrayList<Guide_Book> listGuide_Book;
    private ArrayList<Quest> listQuest;

    public Guild(String name, String subject, int levelRequirement, GuildMaster gm) {
        this.nama = name;
        this.subject = subject;
        this.gm = gm;
        this.levelRequirement = levelRequirement;
        this.listAdventurer = new TreeMap<>();
        this.listGuide_Book = new ArrayList<>();
        this.listQuest = new ArrayList<>();
        this.id_guild = "Guild_"+i;
        i++;
    }

    public void setLevelRequirement(int level) {
        this.levelRequirement = level;
    }

    public void addAdventurer(Adventurer a) {
        this.listAdventurer.put(a,0);
        System.out.println("Berhasil menambahkan adventurer");
    }

    public void addGuideBook(Guide_Book gb) {
        this.listGuide_Book.add(gb);
        System.out.println("Berhasil menambahkan Guide");
    }

    public void addQuest(Quest q) {
        this.listQuest.add(q);
        System.out.println("Berhasil menambahkan Quest");
    }

    public void showRank()
    {
        SortedSet sm = entriesSortedByValues(this.listAdventurer);
        Iterator i = sm.iterator();
        int j = 1;
        while (i.hasNext())
        {
            Map.Entry m = (Map.Entry)i.next();

            Adventurer adv = (Adventurer)m.getKey();
            int value = (Integer)m.getValue();

            System.out.println("No "+j+"."+adv.getName()+" "+value);
            j++;
        }
    }

    public int getLevelRequirement(int level) {
        return this.levelRequirement;
    }

    public String getSubject() {
        return this.subject;
    }

    public void showGuideBook(){
        int j=1;
        for (Guide_Book book : this.listGuide_Book) {
            System.err.println("No "+j+"."+book.getJudul());
            j++;
        }
    }

    public void readGuideBook(String id_GuideBook){
        for (Guide_Book book : this.listGuide_Book) {
            if (book.getId_GuideBook().equals(id_GuideBook)){
                System.out.println(book.getIsi());
            }
        }
    }

    public Quest getListQuest(int i) {
        return listQuest.get(i);
    }


    public String getNama() {
        return nama;
    }


    @Override
    public String toString(){
        return "Name : "+this.getNama()+"|| Subject : "+this.subject+"|| Level Req : "+this.levelRequirement;
    }

    public static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


}
