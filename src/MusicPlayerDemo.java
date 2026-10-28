public class MusicPlayerDemo {
    public static void main(String[] args) {
        MusicPlayList playlist = new MusicPlayList();

        // Adding song
        playlist.addSong("Shape of You", "Ed Sheeran");
        playlist.addSong("Save Me", "BTS");
        playlist.addSong("Kufi", "DUMAN");
        playlist.addSong("like JENNIE", "JENNIE");

        // show the music playlist
        playlist.displayPlaylist();

        // show the song that's currently playing.
        playlist.displayCurrentSong();

        // pass the next music
        playlist.nextSong();
        System.out.println();
        playlist.nextSong();
        System.out.println();

        // back to previous song
        playlist.prevSong();
        System.out.println();

        // "Shape of You" deleted song
        playlist.removeSong("Shape of You");

        // "Kufi" deleted song
        playlist.removeSong("Kufi");
    }
}