package designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
public static void main(String[] args) {
		
		/* News Publisher */
		Subject publisher = new Publisher();
		
		/* registering observers */
		Observer subscriber1 = new Subscriber1();
		publisher.registerObserver(subscriber1);
		
		Observer subscriber2 = new Subscriber2();
		publisher.registerObserver(subscriber2);
		
		/* Notify observers */
		publisher.notifyObservers();
		
		/* Delete observers */
		publisher.removeObserver(subscriber2);
		
		/* Notify observers */
		publisher.notifyObservers();
	}

}

interface Observer {
	public void update(String editon);
}

class Subscriber1 implements Observer {

	@Override
	public void update(String edition) {
		System.out.println("New Edition from Subscriber1");
	}
}

class Subscriber2 implements Observer {

	@Override
	public void update(String edition) {
		System.out.println("New Edition from Subscriber2");
	}
}

interface Subject {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyObservers();
}

class Publisher implements Subject {

	private List<Observer> _observers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer observer) {
		System.out.println("Registered observer");
		_observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		System.out.println("Deregister observer");
		_observers.remove(observer);
	}

	@Override
	public void notifyObservers() {

		for (Observer observer : _observers) {
			observer.update("Weekly Edition");
		}
	}
}
