package ex8_as2;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();
    Song next();
}

interface Playlist {
    Iterator createIterator();
    void addSong(Song song);
}

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}


class PlaylistImpl implements Playlist {
    private List<Song> songs;

    public PlaylistImpl() {
        songs = new ArrayList<>();
    }

    @Override
    public Iterator createIterator() {
        return new PlaylistIterator(songs);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

    private class PlaylistIterator implements Iterator {
        private int currentIndex = 0;
        private List<Song> songs;

        public PlaylistIterator(List<Song> songs) {
            this.songs = songs;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < songs.size();
        }

        @Override
        public Song next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more songs in the playlist");
            }
            Song song = songs.get(currentIndex);
            currentIndex++;
            return song;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new PlaylistImpl();
        playlist.addSong(new Song("Song A", "Artist A"));
        playlist.addSong(new Song("Song B", "Artist B"));
        playlist.addSong(new Song("Song C", "Artist C"));

        Iterator iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist());
        }
    }
}
