package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    public Thread target;
    public State prevState;
    public LoggingStateThread(Thread target){
        this.target = target;
        setDaemon(true);
    }
    public void run(){

        while (true){
            State state = target.getState();
            if (prevState == null) {
                prevState = state;
                System.out.println(state.toString());
            } else if (!state.equals(prevState)) {
                System.out.println(state.toString());
                prevState = state;
            }
            if (state.equals(State.TERMINATED)) { break; }

        }
    }
}
