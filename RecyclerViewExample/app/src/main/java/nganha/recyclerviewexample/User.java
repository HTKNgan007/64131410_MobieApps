package nganha.recyclerviewexample;

public class User {
    private String name;
    private String info;
    private int avatarResId; // Tài nguyên ảnh

    public User(String name, String info, int avatarResId) {
        this.name = name;
        this.info = info;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}
