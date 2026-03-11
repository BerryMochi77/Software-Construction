//conceret producti

public class WoodDoor implements Door{
    private float width;
    private float height;

    public WoodDoor() {
    }

    public WoodDoor(float width,float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void getDescription() {
        System.out.println("this is made of iron");
    }
}
