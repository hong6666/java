package lhh.pattern.adapterPattern;

/**
 * @program: IdeaJava
 * @Date: 2019/12/2 17:02
 * @Author: lhh
 * @Description:
 */

class Phone{

    public static final int V = 220;

    private VoltageAdapter adapter;

    //充电
    public void charge(){
        adapter.changeVoltage();
    }

    public void setAdapter(VoltageAdapter adapter){
        this.adapter = adapter;
    }
}
//电压适配器
class VoltageAdapter{
    // 改变电压的功能
    public void changeVoltage(){
        System.out.println("正在充电");
        System.out.println("原始电压：" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压：" + (Phone.V -200) + "V");
    }
}

public class AdapterPatternTest {

    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }
}
