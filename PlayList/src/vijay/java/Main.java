package vijay.java;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums= new ArrayList<Album>();

        Album album = new Album("RockOn","vijay");
        album.addSong("Kesaria",5.5);
        album.addSong("Ashique",4.5);
        album.addSong("Kaisa Hua",5.6);
        album.addSong("Em maya chesave",6.6);
        album.addSong("kundanapuBomma",3.4);
        albums.add(album);

        Album album1 = new Album("Sadhguru","jaggiVasudev");
        album1.addSong("Damaru",7);
        album1.addSong("Adhiyogi",7);
        album1.addSong("Sri hari stotram",7);
        album1.addSong("Shiva stuti Stotram",7);
        albums.add(album1);

        LinkedList<Song>playList=new LinkedList<Song>();
        albums.get(0).addPlayList("Kesaria",playList);
        albums.get(0).addPlayList("hum nava mera",playList);
        albums.get(0).addPlayList("Kaisa hua",playList);
        albums.get(1).addPlayList(1,playList);
        albums.get(1).addPlayList(2,playList);
        albums.get(1).addPlayList(6,playList);

        play(playList);

    }
    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit =false;
        boolean forward=true;
        ListIterator<Song> listIterator=playList.listIterator();

        if(playList.size()==0){
            System.out.println("no songs in the playList");
            return;
        }else{
            System.out.println("now playing "+listIterator.next().toString());
           printMenu();
        }
        while (!quit){
            int action=scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("playlist completed.");
                    quit=true;
                    break;
                case 1:
                    if(!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing"+listIterator.next().toString());
                    }else {
                        System.out.println("we have reached end of the playlist");
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("now playing"+listIterator.previous().toString());
                    }else {
                        System.out.println("we have reached start of the playlist");
                    }
                    break;
                case 3:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("now replaying "+listIterator.previous().toString());
                            forward=false;
                        }else
                        {
                            System.out.println("we are at start");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now replaying"+listIterator.next());
                            forward=true;
                        }else {
                            System.out.println("we are at the end ");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size()>0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("now playing"+listIterator.next().toString());
                        }else if(listIterator.hasPrevious()){
                            System.out.println("now playing"+listIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions\npress\n"+
                "0-> to quit\n" +
                "1-> to play next song\n" +
                "2-> to play previous song\n" +
                "3-> to replay the current song\n" +
                "4-> to print the list of songs\n" +
                "5-> to show the menu of available actions\n" +
                "6-> to remove the current playing song form the playlist\n" );
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator=playList.iterator();
        System.out.println("=================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=================================");

    }
    public static void listExample(){
        List<String> listIte=new LinkedList<>();
        listIte.add("Vijay");
        listIte.add("siddarth");

    }


}
