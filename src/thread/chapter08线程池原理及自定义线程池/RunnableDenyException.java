package thread.chapter08线程池原理及自定义线程池;

/**
 * @program: IdeaJava
 * @Date: 2020/4/28 14:58
 * @Author: lhh
 * @Description:
 */
 class RunnableDenyException extends RuntimeException{

    public RunnableDenyException(String message)
    {
        super(message);
    }

}
