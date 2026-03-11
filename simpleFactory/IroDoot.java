public class IroDoot implements Door{
    private float width;
    private float height;

    public IroDoot(float width,float height) {
        this.width = width;
        this.height = height;
    }

    public IroDoot() {

    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public float getHeight() {
        return 0;
    }

    @Override
    public void getDescription() {
        System.out.println("this door is made of iron");
    }
}
