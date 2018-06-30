package com.gainwise.seed.Vitals;

public class CrashAllocator {

    //declare variable for uncaught exception handler
    private Thread.UncaughtExceptionHandler defaultCrashHandler;

    //declare variable for object imlementing interface
    private Crashable ourCrashHandler;

    public CrashAllocator(Crashable methodToExecute) {
        //in our new Handler, the interface method will execute
        this.ourCrashHandler = methodToExecute;

        // uncaught exception handler variable initialized
        defaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();

        // setup handler for uncaught exception
        Thread.setDefaultUncaughtExceptionHandler(TUEhandler);
    }

    private Thread.UncaughtExceptionHandler TUEhandler =
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable ex) {

                    //Code passed via the Crashable interface in the constructor is executed
                    ourCrashHandler.executeOnCrash();

                    // re-throw critical exception further to the os (important)
                    defaultCrashHandler.uncaughtException(thread, ex);
                }
            };


    interface Crashable{
        void executeOnCrash();
    }
}
