package vijay.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs=new ArrayList<Song>();
    }
    public boolean addSong(String tittle,double duration){
        if(findSong(tittle)==null){
            this.songs.add(new Song(tittle,duration));
            return true;
        }
        return false;
    }
    private Song findSong(String tittle){
        for(Song checkedSong: this.songs){
            if (checkedSong.getTitle().equals(tittle)){
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addPlayList(int trackNumber, LinkedList<Song> playList){
        int index=trackNumber-1;
        if((index>=0)&&(index<=this.songs.size())) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album doesn't have a track "+trackNumber);
        return false;
    }
    public boolean addPlayList(String tittle,LinkedList<Song> playList){
        Song song = findSong(tittle);
        if(song!=null){
            playList.add(song);
            return true;
        }
        System.out.println("the song "+tittle+" is not in album");
        return false;
    }
}
