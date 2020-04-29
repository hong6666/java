package thread.chapter08线程池原理及自定义线程池;


 class RunnableDenyException extends RuntimeException{

    public RunnableDenyException(String message)
    {
        super(message);
    }

}
