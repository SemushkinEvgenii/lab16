package com.company;

interface Char380{
    public void power();
}
interface Char380Rus{
    public void power220();
}

class V380 implements Char380{

    @Override
    public void power(){
        System.out.println("Включена зарядка 380 ");
    }

}

class V220 implements Char380Rus{

    @Override
    public void power220(){ System.out.println("Включена зарядка 220");
    }
}

class CharAdapter220 implements Char380{
    Char380Rus Char380Rus;
    public CharAdapter220(Char380Rus Char380Rus){

        this.Char380Rus = Char380Rus;
    }

    @Override
    public void power(){
        Char380Rus.power220();
    }
}

class CentralProcessor{
    private Char380 Tel;
    public CentralProcessor(Char380 Tel){
        this.Tel = Tel;
    }

    public void work(){
        Tel.power(); // какая зарядка у телефона
    }
}

public class Main{
    public static void main(String[] args){
        Char380 z380 = new V380(); //объект зарядка
        CentralProcessor cp = new CentralProcessor(z380); //объект процессор, передаем в управления зарядку
        cp.work(); //процессор управляет работой

        CharAdapter220 z220 = new CharAdapter220(new V220()); //создать адаптер и передать
        CentralProcessor cpRus = new CentralProcessor(z220); //создаем процессор и передаем в него адаптер
        cpRus.work();
    }
}