//abstract factory


//simple
//public class DoorFactory {
//    public static Door makeDoor(float width, float height){
//        return new WoodDoor(width, height);
//    }


public interface DoorFactory{
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();

    public static void main(String[] args){
       // Door newDoor = DoorFactory.makeDoor(100,200);
       // System.out.println(newDoor.getHeight());
        // System.out.println(newDoor.getWidth());

        DoorFactory df = new WoodenDoorFactory();
        Door wd = df.makeDoor();
        DoorFittingExpert we = df.makeFittingExpert();
        wd.getDescription();
        we.getDescription();


    }
}
