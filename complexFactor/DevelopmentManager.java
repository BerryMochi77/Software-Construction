public class DevelopmentManager extends HringManager{
    @Override
    protected Interviewer makeInterviewer() {
        return new Developer();
    }
}
