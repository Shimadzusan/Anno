package core;

/**
 * �������� ����� ����������, � ��������� �������������� ���
 * ������, �������, ����������, ������
 * �������, ��. ����������
 * �����������, �����������/����������
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
		
		System.out.println("...end");

	}

}
