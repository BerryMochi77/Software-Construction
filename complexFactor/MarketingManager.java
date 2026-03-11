public class MarketingManager extends HringManager{
    protected Interviewer makeInterviewer(){
        return new CommunityExecutive();
    }
}
