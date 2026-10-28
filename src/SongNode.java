/* Ferzan Ozkan
    NO: 240444049
    Date: 10/19/2026 */

public class SongNode {
    String title;
    String artist;
    SongNode prev;
    SongNode next;

    public SongNode(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}