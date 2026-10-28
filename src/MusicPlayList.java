public class MusicPlayList {

    private SongNode head;
    private SongNode tail;
    private SongNode current;

    public MusicPlayList() {
        this.head = null;
        this.tail = null;
        this.current = null;
    }

    // 1. Şarkı Ekleme (Listenin sonuna ekler)
    public void addSong(String title, String artist) {
        SongNode newNode = new SongNode(title, artist);
        if (head == null) {
            // Liste boşsa
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            // Liste boş değilse, tail sonrasına ekle
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // 2. Sonraki şarkıya geçiş
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("=== NEXT SONG TO PLAY ===");
            System.out.println("Playing: " + current);
        } else {
            System.out.println("Already at the last song.");
        }
    }

    // 3. Önceki şarkıya geçiş
    public void prevSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("=== PREVIOUS SONG TO PLAY ===");
            System.out.println("Playing: " + current);
        } else {
            System.out.println("Already at the first song.");
        }
    }

    // 4. Şarkı Silme (İsme göre)
    public void removeSong(String title) {
        SongNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println("=== AFTER REMOVING " + temp.title + " SONG ===");
                System.out.println("Removed: " + temp);

                if (temp == head && temp == tail) {
                    // Listede tek eleman varsa
                    head = null;
                    tail = null;
                    current = null;
                } else if (temp == head) {
                    // İlk eleman siliniyorsa
                    head = head.next;
                    head.prev = null;
                    if (current == temp) current = head;
                } else if (temp == tail) {
                    // Son eleman siliniyorsa
                    tail = tail.prev;
                    tail.next = null;
                    if (current == temp) current = tail;
                } else {
                    // Ortadaki bir eleman siliniyorsa
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (current == temp) current = temp.next;
                }
                displayPlaylist();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Song not found: " + title);
    }

    // 5. Şu an çalan şarkıyı göster
    public void displayCurrentSong() {
        System.out.println("=== CURRENT SONG PLAYING ===");
        if (current != null) {
            System.out.println("Current Song: " + current);
        } else {
            System.out.println("Playlist is empty.");
        }
        System.out.println();
    }

    // 6. Tüm çalma listesini göster
    public void displayPlaylist() {
        System.out.println("=== PLAYLIST ===");
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(" <-> END\n");
    }
}