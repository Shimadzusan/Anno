package core;

/**
 * Основной поток исполнения, и остальные дополнительные итд
 * Классы, объекты, переменные, методы
 * Импорты, др. информация
 * Модульность, подключение/отключение
 * */
public class Launch {

	public static void main(String[] args) {
		System.out.println("..begin point of the stream execution");
		System.out.println("..something execution");
		System.out.println("..end point of the stream execution");
		
		Thread mp = new MainProcess();
		mp.start();
		
		Thread sp = new SecondProcess();
		sp.start();
		
		Thread fp = new FarmProcess();
		fp.start();
		
		Thread bk = new BankingProcess();
		bk.start();
		
		System.out.println("...end");

	}

}
