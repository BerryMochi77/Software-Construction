abstract class HringManager {
    protected abstract Interviewer makeInterviewer();

    public void takeInterviewer(){
        Interviewer i = makeInterviewer();
        i.askQuestion();
    }

    public static void main(String[] args){
        //调用 takeInterview() -> 内部执行 makeInterviewer() -> 返回 new Developer()
        HringManager derM = new DevelopmentManager();
        //Developer.askQuestions()
        derM.takeInterviewer();

        HringManager merM = new DevelopmentManager();
        merM.takeInterviewer();
    }
}
