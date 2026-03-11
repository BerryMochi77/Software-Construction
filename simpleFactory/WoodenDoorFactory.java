public class WoodenDoorFactory implements DoorFactory{
    @Override
    public Door makeDoor() {
        return new WoodDoor();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Carpenter();
    }
}
