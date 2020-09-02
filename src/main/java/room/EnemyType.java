package room;

public enum EnemyType {
    DRAGON("Dragon"),
    OGRE("Ogre"),
    DROW("Drow"),
    SKELETON("Skeleton");

    private String name;

    EnemyType(String name) {
        this.name = name;
    }
}
