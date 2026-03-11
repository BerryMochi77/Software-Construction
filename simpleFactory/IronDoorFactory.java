public class IronDoorFactory implements DoorFactory{

    @Override
    public Door makeDoor() {
        return new IroDoot();
    }

    @Override
    public DoorFittingExpert makeFittingExpert() {
        return new Welder();
    }
}
